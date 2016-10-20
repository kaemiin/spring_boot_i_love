package net.patisco.password.exception;

public class PasswordFatalError extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    public PasswordFatalError() {

        this("System has error, please notify system administrator");
    }

    public PasswordFatalError(String errorMsg) {

        super(errorMsg);
    }

    public PasswordFatalError(String errorMsg, Exception cause) {

        super(errorMsg, cause);
    }
	
    public PasswordFatalError(Exception cause) {

        super(cause);
    }
	
}
