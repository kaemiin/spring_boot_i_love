package net.patisco.password.spring.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.xinosys.auth.server.model.Message;

import net.patisco.password.exception.PasswordException;
import net.patisco.password.exception.PasswordFatalError;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
	
	private static Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

	@ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Message noHandlerFoundException(Exception ex) {
		
        return new Message(false, ex.getMessage(), 404);
        
    }
	
	@ExceptionHandler(value = { PasswordException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Message constraintViolationException(PasswordException e) {
		
        return new Message(false, e.getMessage(), 500);
        
    }	
	
	@ExceptionHandler(value = { PasswordFatalError.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Message unknownException(PasswordFatalError e) {
		
		logger.error("Error", e);
		
        return new Message(false, "", 500);
        
    }
	
}
