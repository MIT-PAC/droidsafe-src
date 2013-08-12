package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;




public class MalformedCookieException extends ProtocolException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.177 -0400", hash_original_method = "FA8D422BA92412355CA6BC772A1072B7", hash_generated_method = "CA497B5D0BB2E41B59B40607BC68553B")
    public  MalformedCookieException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.177 -0400", hash_original_method = "5C17F0343C6E509718E3D350EB6D1C4E", hash_generated_method = "6687D08DEE35BA89303C455BD4909695")
    public  MalformedCookieException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.177 -0400", hash_original_method = "8561AF5B806E84C7CA40A0C40C944616", hash_generated_method = "D0BF5E91F6B2CC4AE295DBE388A14048")
    public  MalformedCookieException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.177 -0400", hash_original_field = "D6FE0E09048B40ADD73AB430214C0148", hash_generated_field = "F0076835C7A0020F1B2206D56F3C0DF8")

    private static final long serialVersionUID = -6695462944287282185L;
}

