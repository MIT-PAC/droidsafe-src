package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.Charsets;

import libcore.net.UriCodec;



public class URLEncoder {

    /**
     * Equivalent to {@code encode(s, "UTF-8")}.
     *
     * @deprecated use {@link #encode(String, String)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.246 -0500", hash_original_method = "F3C1C4CFF9BE8725C4E7F6E8F952E701", hash_generated_method = "1A209DE22072754E840116F302F6A63F")
    
@Deprecated
    public static String encode(String s) {
        return ENCODER.encode(s, Charsets.UTF_8);
    }

    /**
     * Encodes {@code s} using the {@link Charset} named by {@code charsetName}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.249 -0500", hash_original_method = "D7709200003A991BD062A99EB5CFA293", hash_generated_method = "3CD8462111730A87D2D8B52FAAF90629")
    
public static String encode(String s, String charsetName) throws UnsupportedEncodingException {
        return ENCODER.encode(s, Charset.forName(charsetName));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_field = "BF744055ED759113AEBE28A0C00A3E54", hash_generated_field = "04F0CC19FD1C184FAF8112872B3FF045")

    static UriCodec ENCODER = new UriCodec() {        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.616 -0400", hash_original_method = "70778A5E4342F08CE32F374D86265937", hash_generated_method = "811C6B809939AF0583CA172372A0CFB9")
        @Override
        protected boolean isRetained(char c) {
            boolean varD34241CD5AA4B42C02ED3ACD4E671100_74379594 = (" .-*_".indexOf(c) != -1);
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527189368;
            
            
        }

        
};
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.238 -0500", hash_original_method = "B41CBCC9C76AA809E0DC45FDBBA0D268", hash_generated_method = "6546CA37BB594848B3235CCF30367527")
    
private URLEncoder() {}
}

