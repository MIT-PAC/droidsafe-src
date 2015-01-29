package dk.brics.string;

/**
 * Thrown to indicate that some invalid use of the runtime library
 * has been encountered. These include:
 * <ul>
 * <li>Non-constant regular expressions or automaton URLs.</li>
 * <li>Malformed automaton URLs.</li>
 * <li>I/O error while fetching the automaton.</li>
 * <li>Unbound name referenced in regular expression.</li>
 * </ul>
 * Note that invalid use of the runtime library is not guaranteed
 * to throw an <code>InvalidRuntimeUseException</code> at analysis
 * time. In general, the behaviour is undefined if the runtime library
 * is used incorrectly.
 */
public class InvalidRuntimeUseException extends RuntimeException {

    /**
     * Creates an <code>InvalidRuntimeUseException</code> with the given message.
     *
     * @param mes the message.
     */
    public InvalidRuntimeUseException(String mes) {
        super(mes);
    }

    public InvalidRuntimeUseException() {
    }

    public InvalidRuntimeUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRuntimeUseException(Throwable cause) {
        super(cause);
    }
    
}
