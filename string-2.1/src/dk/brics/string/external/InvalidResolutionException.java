package dk.brics.string.external;

/**
 * Thrown if a resolver returned an invalid resolution object.
 * 
 * @author Asger
 *
 */
public class InvalidResolutionException extends RuntimeException {

	public InvalidResolutionException() {
	}

	public InvalidResolutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidResolutionException(String message) {
		super(message);
	}

	public InvalidResolutionException(Throwable cause) {
		super(cause);
	}
	
}
