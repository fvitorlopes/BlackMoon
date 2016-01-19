package exceptions;

public class BlackMoonException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlackMoonException(String message) {
        super(message);
    }

    public BlackMoonException(String message, Throwable throwable) {
        // implement jsf out 
    	super(message, throwable);
    }

}