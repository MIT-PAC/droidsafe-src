package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import libcore.net.UriCodec;

public class URLDecoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.435 -0400", hash_original_method = "B615A2BC4F9E0B242EB3A9536009FA28", hash_generated_method = "22C6E19760682FCDD3324068D65B539B")
    @Deprecated
    public static String decode(String s) {
        return UriCodec.decode(s, true, Charset.defaultCharset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.435 -0400", hash_original_method = "08FCF3E03A800113A7194CB72BB59DA9", hash_generated_method = "E0C46DB131A739C4A90A1AC029D9124F")
    public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        return UriCodec.decode(s, true, Charset.forName(encoding));
    }

    
}


