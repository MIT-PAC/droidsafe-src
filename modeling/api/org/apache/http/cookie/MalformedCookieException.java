package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;

public class MalformedCookieException extends ProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.067 -0500", hash_original_field = "D17430246089E98EDCB94E3F59E32760", hash_generated_field = "F0076835C7A0020F1B2206D56F3C0DF8")

    private static final long serialVersionUID = -6695462944287282185L;

    /**
     * Creates a new MalformedCookieException with a <tt>null</tt> detail message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.069 -0500", hash_original_method = "FA8D422BA92412355CA6BC772A1072B7", hash_generated_method = "FA55FD0704AB426B33539342BB0248C9")
    
public MalformedCookieException() {
        super();
    }
     
    /** 
     * Creates a new MalformedCookieException with a specified message string.
     * 
     * @param message The exception detail message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.072 -0500", hash_original_method = "5C17F0343C6E509718E3D350EB6D1C4E", hash_generated_method = "CD780E9C0EEDF6153F684A454110836D")
    
public MalformedCookieException(String message) {
        super(message);
    }

    /**
     * Creates a new MalformedCookieException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.074 -0500", hash_original_method = "8561AF5B806E84C7CA40A0C40C944616", hash_generated_method = "7E3D83D608B2A27BA6F8439F62F1167E")
    
public MalformedCookieException(String message, Throwable cause) {
        super(message, cause);
    }
}

