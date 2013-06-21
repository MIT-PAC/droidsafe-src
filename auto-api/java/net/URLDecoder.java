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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.397 -0400", hash_original_method = "1E29D68C8A40B15616063FB658D5102A", hash_generated_method = "1E29D68C8A40B15616063FB658D5102A")
        public URLDecoder ()
    {
    }


        @Deprecated
    public static String decode(String s) {
        return UriCodec.decode(s, true, Charset.defaultCharset());
    }

    
        public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        return UriCodec.decode(s, true, Charset.forName(encoding));
    }

    
}

