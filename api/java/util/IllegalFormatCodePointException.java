package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;






public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.480 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "50AD48E12B8BEBE82F0051066582ABE2")

    private int c;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.480 -0400", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "B0BCC925AF8D66DD3A3ED68FAEE6F46E")
    public  IllegalFormatCodePointException(int c) {
        this.c = c;
        // ---------- Original Method ----------
        //this.c = c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.481 -0400", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "6C40A151319CF2BA6D2D8D4629138CAF")
    public int getCodePoint() {
        int var4A8A08F09D37B73795649038408B5F33_1204435840 = (c);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334122730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334122730;
        // ---------- Original Method ----------
        //return c;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.481 -0400", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "334D606E59DA755F604D6C2E3B996893")
    @Override
    public String getMessage() {
String var4ACBAC30FC82A2A63B23A29076A6F1DE_1730545065 =         Integer.toHexString(c);
        var4ACBAC30FC82A2A63B23A29076A6F1DE_1730545065.addTaint(taint);
        return var4ACBAC30FC82A2A63B23A29076A6F1DE_1730545065;
        // ---------- Original Method ----------
        //return Integer.toHexString(c);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.481 -0400", hash_original_field = "8EA9CA4F3CA6F25FD16D23B5CEF2BF3C", hash_generated_field = "CA23A340A271E932968B5D7D53D04890")

    private static final long serialVersionUID = 19080630L;
}

