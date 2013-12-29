package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.util.ExceptionUtils;




public class HttpException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.238 -0500", hash_original_field = "5E05CC70F2DC1FB9266744ED1643CB44", hash_generated_field = "D3DA2C51E36CA7A4E1A21B95D35537AD")


    private static final long serialVersionUID = -5437299376222011036L;
    
    /**
     * Creates a new HttpException with a <tt>null</tt> detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.239 -0500", hash_original_method = "CE1042B423C0576E9C85D621B7EA3FF6", hash_generated_method = "2FAAC4CED5A8404791A0535FE84205A7")
    public HttpException() {
        super();
    }

    /**
     * Creates a new HttpException with the specified detail message.
     *
     * @param message the exception detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.241 -0500", hash_original_method = "999797B071E81E9F9DCCEA8ACDA6E65E", hash_generated_method = "ADAC01D6102A37E2F6721B7EA58CA550")
    public HttpException(final String message) {
        super(message);
    }

    /**
     * Creates a new HttpException with the specified detail message and cause.
     * 
     * @param message the exception detail message
     * @param cause the <tt>Throwable</tt> that caused this exception, or <tt>null</tt>
     * if the cause is unavailable, unknown, or not a <tt>Throwable</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:25.241 -0500", hash_original_method = "6034895F301B6A7B932D0B171C9F2AB8", hash_generated_method = "DD0A6E8ADB6DA18B65AB506662CBCCA7")
    public HttpException(final String message, final Throwable cause) {
        super(message);
        ExceptionUtils.initCause(this, cause);
    }
}

