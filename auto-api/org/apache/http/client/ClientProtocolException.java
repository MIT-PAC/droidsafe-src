package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ClientProtocolException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.814 -0400", hash_original_method = "3260DCF079E7C772EA6A90502130DC83", hash_generated_method = "FCE7E5BB85943B23D2128F2BCBDDA47B")
    public  ClientProtocolException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.814 -0400", hash_original_method = "98A3EFA06D403E8456E33B2220E5EB15", hash_generated_method = "949A737D612AA78E26792D75B72DA50C")
    public  ClientProtocolException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.814 -0400", hash_original_method = "CE5566FA43618E2C322AA845802DCAD6", hash_generated_method = "6F658E9893B189D0BD14B49BED58D9C9")
    public  ClientProtocolException(Throwable cause) {
        initCause(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.815 -0400", hash_original_method = "3D3F161C5740C8F0A7A6AC126178E78A", hash_generated_method = "E4A38F0B3D51CE6B56BEC9B46BF6DE61")
    public  ClientProtocolException(String message, Throwable cause) {
        super(message);
        initCause(cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //initCause(cause);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.815 -0400", hash_original_field = "817BD87F42299068DB46E89E05708687", hash_generated_field = "5C06DEE0510A8A5443E44549FA9970B5")

    private static long serialVersionUID = -5596590843227115865L;
}

