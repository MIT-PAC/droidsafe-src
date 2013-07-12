package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;
import libcore.net.UriCodec;

public class URLEncoder {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:55.380 -0400", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "A6F2D9E84EF75199314CB290B61AC175")
    private  URLEncoder() {
        
    }

    
        @Deprecated
    public static String encode(String s) {
        return ENCODER.encode(s, Charsets.UTF_8);
    }

    
        public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        return ENCODER.encode(s, Charset.forName(charsetName));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_field = "BF744055ED759113AEBE28A0C00A3E54", hash_generated_field = "04F0CC19FD1C184FAF8112872B3FF045")

    static UriCodec ENCODER = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "811C6B809939AF0583CA172372A0CFB9")
        @Override
        protected boolean isRetained(char c) {
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_74379594 = (" .-*_".indexOf(c) != -1);
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368;
            
            
        }

        
};
}

