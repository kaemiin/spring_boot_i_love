package net.patisco.password.exception;

public class PasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public PasswordException() {

        this("System has error, please notify system administrator");
    }

    public PasswordException(String errorMsg) {

        super(errorMsg);
    }

    public PasswordException(String errorMsg, Exception cause) {

        super(errorMsg, cause);
    }
	
    public PasswordException(Exception cause) {

        super(cause);
    }  
	
}
