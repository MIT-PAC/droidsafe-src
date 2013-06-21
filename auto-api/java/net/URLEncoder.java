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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.398 -0400", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "A6F2D9E84EF75199314CB290B61AC175")
    @DSModeled(DSC.SAFE)
    private URLEncoder() {
        // ---------- Original Method ----------
    }

    
        @Deprecated
    public static String encode(String s) {
        return ENCODER.encode(s, Charsets.UTF_8);
    }

    
        public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        return ENCODER.encode(s, Charset.forName(charsetName));
    }

    
    static UriCodec ENCODER = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.398 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "D63477391FC19CC37BBB05BCE410527B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_1409611930 = (" .-*_".indexOf(c) != -1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return " .-*_".indexOf(c) != -1;
        }

        
}; //Transformed anonymous class
}

