package exception;

public class InvalidAuthenticationException extends Exception {
	private String message;
	
	public InvalidAuthenticationException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
