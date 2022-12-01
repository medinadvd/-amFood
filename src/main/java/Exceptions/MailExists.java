package Exceptions;

public class MailExists extends Exception{
    /**
     * control if mail exists
     * @param message 
     */
    public MailExists(String message) {
        super (message);
    }
}
