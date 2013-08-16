package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.util.ExceptionUtils;




public class HttpException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.105 -0400", hash_original_method = "CE1042B423C0576E9C85D621B7EA3FF6", hash_generated_method = "0DA2B15A81BFF0C65703BCFAA76028E6")
    public  HttpException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.106 -0400", hash_original_method = "999797B071E81E9F9DCCEA8ACDA6E65E", hash_generated_method = "EDC649A3F2554453F1FA6080CEF54AB5")
    public  HttpException(final String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.107 -0400", hash_original_method = "6034895F301B6A7B932D0B171C9F2AB8", hash_generated_method = "F589611E0A3D1C85B9F792B285A2C6B1")
    public  HttpException(final String message, final Throwable cause) {
        super(message);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        ExceptionUtils.initCause(this, cause);
        // ---------- Original Method ----------
        //ExceptionUtils.initCause(this, cause);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.107 -0400", hash_original_field = "D819726893DE169EDB80CDF61D951FD6", hash_generated_field = "D3DA2C51E36CA7A4E1A21B95D35537AD")

    private static final long serialVersionUID = -5437299376222011036L;
}

