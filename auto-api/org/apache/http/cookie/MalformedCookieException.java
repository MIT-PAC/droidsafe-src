package org.apache.http.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolException;

public class MalformedCookieException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.798 -0400", hash_original_method = "FA8D422BA92412355CA6BC772A1072B7", hash_generated_method = "CA497B5D0BB2E41B59B40607BC68553B")
    public  MalformedCookieException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.798 -0400", hash_original_method = "5C17F0343C6E509718E3D350EB6D1C4E", hash_generated_method = "6687D08DEE35BA89303C455BD4909695")
    public  MalformedCookieException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.798 -0400", hash_original_method = "8561AF5B806E84C7CA40A0C40C944616", hash_generated_method = "9DAFEBAEDFDE20DA98538C6087F64F6D")
    public  MalformedCookieException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.799 -0400", hash_original_field = "D6FE0E09048B40ADD73AB430214C0148", hash_generated_field = "931F0A236FAD90CC18223E27DC3DC4D8")

    private static long serialVersionUID = -6695462944287282185L;
}

