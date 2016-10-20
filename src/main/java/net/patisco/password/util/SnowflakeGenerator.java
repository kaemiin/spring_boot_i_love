/**
 * Base on https://github.com/sumory/uc/blob/master/src/com/sumory/uc/id/IdWorker.java
 */
package net.patisco.password.util;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import net.patisco.password.exception.PasswordFatalError;

public class SnowflakeGenerator implements IdentifierGenerator {	
	
	// 起始標記點，作為基準
	private final long snsEpoch = 1330328109047L;
	// 0，並發控制
    private long sequence = 0L;
    // sequence值控制在0-4095
    private final long sequenceBits = 12L;
    // 12
    private final long workerIdShift = this.sequenceBits;
    // 22
    private final long timestampLeftShift = this.sequenceBits + 10L;
    // 4095,111111111111,12位
    private final long sequenceMask = -1L ^ -1L << this.sequenceBits;	
	private long lastTimestamp = -1L;
	// 只允許instanceId的範圍為：0-1023
	private final long instanceId = ThreadLocalRandom.current().nextLong(1023);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		return this.nextId();
		
	}
	
	protected synchronized long nextId() throws PasswordFatalError {
		
        long timestamp = this.timeGen();
        
        // 如果上一個timestamp與新產生的相等，則sequence加一(0-4095循環)，下次再使用時sequence是新值        
        if (this.lastTimestamp == timestamp) {
            
            this.sequence = this.sequence + 1 & this.sequenceMask;
            
            if (this.sequence == 0) {
            	
                timestamp = this.tilNextMillis(this.lastTimestamp);
                
            }
        }
        else {
        	
            this.sequence = 0;
            
        }
        
        if (timestamp < this.lastTimestamp) {        	   
        	
            throw new PasswordFatalError(
            		String.format("Clock moved backwards.Refusing to generate id for %d milliseconds", 
            				(this.lastTimestamp - timestamp)));
        }

        this.lastTimestamp = timestamp;
        
        return timestamp - this.snsEpoch << this.timestampLeftShift | 
        		   this.instanceId << this.workerIdShift | this.sequence;
        
    }
	
	/**
	 * 保證返回的毫秒數在參數之後
	 * @param lastTimestamp
	 * @return long
	 */
	private long tilNextMillis(long lastTimestamp) {
		
        long timestamp = this.timeGen();
        
        while (timestamp <= lastTimestamp) {
        	
            timestamp = this.timeGen();
            
        }
        
        return timestamp;
        
    }
	
	/**
	 * 取得系統當前毫秒數
	 * @return long
	 */
	private long timeGen() {
		
        return System.currentTimeMillis();
        
    }

}
