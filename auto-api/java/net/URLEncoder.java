package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import libcore.net.UriCodec;

public class URLEncoder {
    static UriCodec ENCODER = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.436 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "0BF0155B42C6D46C2A618501436A9D5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_441804797 = (" .-*_".indexOf(c) != -1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return " .-*_".indexOf(c) != -1;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.436 -0400", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "4AB066949D11BFF362D133700D54028A")
    @DSModeled(DSC.SAFE)
    private URLEncoder() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.436 -0400", hash_original_method = "F3C1C4CFF9BE8725C4E7F6E8F952E701", hash_generated_method = "1A209DE22072754E840116F302F6A63F")
    @Deprecated
    public static String encode(String s) {
        return ENCODER.encode(s, Charsets.UTF_8);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.436 -0400", hash_original_method = "D7709200003A991BD062A99EB5CFA293", hash_generated_method = "3CD8462111730A87D2D8B52FAAF90629")
    public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        return ENCODER.encode(s, Charset.forName(charsetName));
    }

    
}


