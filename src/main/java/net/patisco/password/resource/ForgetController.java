package net.patisco.password.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xinosys.auth.server.model.Message;

import net.patisco.password.domain.CompanyInfo;
import net.patisco.password.domain.ForgetPWD;
import net.patisco.password.enums.AppType;
import net.patisco.password.enums.AuthenticationStatus;
import net.patisco.password.exception.PasswordException;
import net.patisco.password.service.EMailService;
import net.patisco.password.service.ForgetProcessService;
import net.patisco.password.service.DataAccessService;

@RestController
@RequestMapping(value="/forget", produces="application/json")
public class ForgetController {
	
	@Autowired 
	private ForgetProcessService service;
	
	@RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Message forget(
    		@RequestParam(value="Language", required=false, defaultValue="en_US") String langID,
    		@RequestParam(value="App", required=true) String app,
    		@RequestParam(value="EMailAddress", required=true) String email) {		
		
		return service.forget(langID, app, email);
		
	}	

}
