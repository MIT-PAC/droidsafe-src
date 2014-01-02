package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class CircularRedirectException extends RedirectException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.883 -0500", hash_original_field = "6A531A38C3DED05F2BFC8CC6944ABDD2", hash_generated_field = "50BE7861277398EEFDA6B1D1CAAE28FE")


    private static final long serialVersionUID = 6830063487001091803L;

    /**
     * Creates a new CircularRedirectException with a <tt>null</tt> detail message. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.887 -0500", hash_original_method = "3163E6492879DE65B32F21199BC78667", hash_generated_method = "041FF0ED395DF69A64E905CDC1ADB194")
    
public CircularRedirectException() {
        super();
    }

    /**
     * Creates a new CircularRedirectException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.891 -0500", hash_original_method = "EFEABC4C711DA14ECED12A57E29FC504", hash_generated_method = "C1E7128B8ABE2E8FF3DAA6D0223CE426")
    
public CircularRedirectException(String message) {
        super(message);
    }

    /**
     * Creates a new CircularRedirectException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.894 -0500", hash_original_method = "6EF8346EA0EE517139281306D8FFC8B9", hash_generated_method = "20A1D10A60BEC37424055D9940BDC000")
    
public CircularRedirectException(String message, Throwable cause) {
        super(message, cause);
    }
}

