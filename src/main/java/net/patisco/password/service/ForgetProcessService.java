package net.patisco.password.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinosys.auth.server.model.Message;

import net.patisco.password.component.DataAccesser;
import net.patisco.password.component.EMailSender;
import net.patisco.password.domain.CompanyInfo;
import net.patisco.password.domain.ForgetPWD;
import net.patisco.password.enums.AppType;
import net.patisco.password.exception.PasswordException;

@Service
public class ForgetProcessService {
	
	@Autowired
	private DataAccesser dataAccesser;
	
	@Autowired
	private EMailSender emailSender;

	public Message forget(String langID, String app, String email) {
		
		//TODO
		return null;
		
	}
	
}
