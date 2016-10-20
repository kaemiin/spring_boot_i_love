package net.patisco.password.domain;

import java.io.Serializable;
import java.sql.*;
import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="ForgetPWD")
public class ForgetPWD implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GenericGenerator(name="seq_id", 
    			strategy="net.patisco.password.util.SnowflakeGenerator")
	@GeneratedValue(generator="seq_id")
    @Column(unique = true, nullable = false, name="RequestID")
    private Long id;

    @Column(nullable = false, name="CmpnyID", length=10)
    private Long cmpnyID;

    @Column(nullable = false, name="UserID", length=10)
    private Long userID;

    @Column(nullable = false, name="RequestDate")
    private Timestamp requestDate;

    @Column(nullable = false, name="isCompleted", length=3)
    private Integer isCompleted = 0;

    @Column(nullable = false, name="ActivateURL", length=20)
    private String activateURL;

    protected ForgetPWD() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    public ForgetPWD(long cmpnyID, long userID, String activateURL) {

        this.cmpnyID = cmpnyID;
        this.userID = userID;
        this.activateURL = activateURL;
        this.requestDate = new Timestamp(new Date().getTime());

    }

	public Long getId() {
		return id;
	}

}
