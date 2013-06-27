package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import libcore.net.UriCodec;

public class URLDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.681 -0400", hash_original_method = "857A327B54EFC5B6C22CAE0D3F8923A2", hash_generated_method = "857A327B54EFC5B6C22CAE0D3F8923A2")
    public URLDecoder ()
    {
        //Synthesized constructor
    }


        @Deprecated
    public static String decode(String s) {
        return UriCodec.decode(s, true, Charset.defaultCharset());
    }

    
        public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        return UriCodec.decode(s, true, Charset.forName(encoding));
    }

    
}

