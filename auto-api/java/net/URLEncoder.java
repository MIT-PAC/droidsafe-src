package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import libcore.net.UriCodec;

public class URLEncoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.684 -0400", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "A6F2D9E84EF75199314CB290B61AC175")
    private  URLEncoder() {
        // ---------- Original Method ----------
    }

    
        @Deprecated
    public static String encode(String s) {
        return ENCODER.encode(s, Charsets.UTF_8);
    }

    
        public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        return ENCODER.encode(s, Charset.forName(charsetName));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.685 -0400", hash_original_field = "BF744055ED759113AEBE28A0C00A3E54", hash_generated_field = "7A5034E39590025ABCFAD48C86D75361")

    static UriCodec ENCODER = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.685 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "7CC90750ED4E3572D2E315A9AD42341B")
        @Override
        protected boolean isRetained(char c) {
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_1211500897 = (" .-*_".indexOf(c) != -1);
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_699844960 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_699844960;
            // ---------- Original Method ----------
            //return " .-*_".indexOf(c) != -1;
        }

        
};
}

