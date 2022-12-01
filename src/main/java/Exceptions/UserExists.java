package Exceptions;

public class UserExists extends Exception {

    /**
     * Control if person exists into a project
     * @param message 
     */
    public UserExists(String message) {
        super(message);
    }
    
}
