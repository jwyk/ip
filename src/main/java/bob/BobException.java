package bob;

/**
 * Custom exception class for exceptions specific to Bob. The BobException class extends the
 * built-in Exception class and provides error message constructors for errors specific to Bob only.
 */
public class BobException extends Exception {

    /**
     * Constructs a BobException with custom error messages
     *
     * @param message String with the custom message
     */
    public BobException(String message) {
        super(message);
    }
}
