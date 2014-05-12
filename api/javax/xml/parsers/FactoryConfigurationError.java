package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class FactoryConfigurationError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.287 -0500", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

    private Exception exception;

    /**
     * Create a new <code>FactoryConfigurationError</code> with no
     * detail message.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.290 -0500", hash_original_method = "6620C9D65D7B9B8AED04F1E2286BE37D", hash_generated_method = "745C8338A29F863D10814EC116A8F2BD")
    
public FactoryConfigurationError() {
        this.exception = null;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with
     * the <code>String </code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.292 -0500", hash_original_method = "48F1E682C4A714972A38A39D612B5275", hash_generated_method = "D0676D1AFF49D70AC248B711D650CDA6")
    
public FactoryConfigurationError(String msg) {
        super(msg);
        this.exception = null;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with a
     * given <code>Exception</code> base cause of the error.
     *
     * @param e The exception to be encapsulated in a
     * FactoryConfigurationError.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.296 -0500", hash_original_method = "50F0E936640865FC69642EB9E9B7DACD", hash_generated_method = "0108B88B4CBED651CB8E96F68E07A12C")
    
public FactoryConfigurationError(Exception e) {
        super(e.toString());
        this.exception = e;
    }

    /**
     * Create a new <code>FactoryConfigurationError</code> with the
     * given <code>Exception</code> base cause and detail message.
     *
     * @param e The exception to be encapsulated in a
     * FactoryConfigurationError
     * @param msg The detail message.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.299 -0500", hash_original_method = "6DA0E2DE853AFE92CEEE23D7625EA5CB", hash_generated_method = "D14E373FB5C0C305D1EECCFB4C942FA0")
    
public FactoryConfigurationError(Exception e, String msg) {
        super(msg);
        this.exception = e;
    }

    /**
     * Return the message (if any) for this error . If there is no
     * message for the exception and there is an encapsulated
     * exception then the message of that exception, if it exists will be
     * returned. Else the name of the encapsulated exception will be
     * returned.
     *
     * @return The error message.
     */

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.301 -0500", hash_original_method = "3CFCD04CF304E9364ADFC7DBDB377B80", hash_generated_method = "65176D00D2CAACC6AEEBD824B6D2D655")
    
public String getMessage () {
        String message = super.getMessage ();

        if (message == null && exception != null) {
            return exception.getMessage();
        }

        return message;
    }

    /**
     * Return the actual exception (if any) that caused this exception to
     * be raised.
     *
     * @return The encapsulated exception, or null if there is none.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:58.303 -0500", hash_original_method = "DEACD8BC5F5C015493740DB375DC8E7E", hash_generated_method = "98F36C2AFC36910DAB242F709A323B7F")
    
public Exception getException () {
        return exception;
    }
    
}

