package net.patisco.password.component;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import net.patisco.password.domain.CompanyInfo;
import net.patisco.password.domain.ForgetPWD;
import net.patisco.password.exception.PasswordFatalError;
import net.patisco.password.repository.CompanyInfoRepository;
import net.patisco.password.repository.ForgetPWDRepository;

@Component("dataAccesser")
@Transactional
public class DataAccesser {

	private final ForgetPWDRepository forgetPWDRepository;
	private final CompanyInfoRepository companyInfoRepository;
	
	public DataAccesser(ForgetPWDRepository forgetPWDRepository,
			                     CompanyInfoRepository companyInfoRepository) {
		
		this.forgetPWDRepository = forgetPWDRepository;
		this.companyInfoRepository = companyInfoRepository;
		
	}
	
	public List<CompanyInfo> findCompanyInfoByEMail(String email) throws PasswordFatalError {
		
		try {
			
			return companyInfoRepository.findByEMailAddressOrEMailOfContact(email, email);
			
		}
		catch(DataAccessException dae) {
			
			throw new PasswordFatalError(dae);
			
		}
		
	}
	
	public void addForgetPWD(ForgetPWD data) throws PasswordFatalError {
		
		try {
			
			forgetPWDRepository.save(data);
			
		}
		catch(DataAccessException dae) {
			
			throw new PasswordFatalError(dae);
			
		}
		
	}

}
