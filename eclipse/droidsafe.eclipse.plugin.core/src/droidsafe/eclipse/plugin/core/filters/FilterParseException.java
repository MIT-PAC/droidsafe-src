package droidsafe.eclipse.plugin.core.filters;

/**
 * An exception raised due to failure in parsing a filter.
 * 
 * @author gilham
 *
 */
public class FilterParseException extends Exception {

    /**
     * Create a FilterParseException with the given error message.
     * 
     * @param message - the error message
     */
    public FilterParseException(String message) {
        super(message);
    }

}
