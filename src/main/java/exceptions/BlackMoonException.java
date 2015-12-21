package exceptions;

public class BlackMoonException extends Exception {

    public BlackMoonException(String message) {
        super(message);
    }

    public BlackMoonException(String message, Throwable throwable) {
        // implement jsf out 
    	
    	super(message, throwable);
    }

}