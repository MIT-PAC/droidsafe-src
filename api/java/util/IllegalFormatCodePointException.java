package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class IllegalFormatCodePointException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.622 -0400", hash_original_field = "4A8A08F09D37B73795649038408B5F33", hash_generated_field = "50AD48E12B8BEBE82F0051066582ABE2")

    private int c;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.622 -0400", hash_original_method = "EC5D1DD50821B22662FE61EFD96C533A", hash_generated_method = "B0BCC925AF8D66DD3A3ED68FAEE6F46E")
    public  IllegalFormatCodePointException(int c) {
        this.c = c;
        // ---------- Original Method ----------
        //this.c = c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.623 -0400", hash_original_method = "D5B710B3F21DF9B84478D362C18B2C11", hash_generated_method = "B9D1812014F484E8428E8DABEDA6DDE2")
    public int getCodePoint() {
        int var4A8A08F09D37B73795649038408B5F33_661643247 = (c);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280622848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280622848;
        // ---------- Original Method ----------
        //return c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.623 -0400", hash_original_method = "D74EDE3BF1A0D3C4B575CB0DB2BFF88F", hash_generated_method = "C3CAEBD169C0E63EFCF7A8BBFD773D4E")
    @Override
    public String getMessage() {
String var4ACBAC30FC82A2A63B23A29076A6F1DE_734067647 =         Integer.toHexString(c);
        var4ACBAC30FC82A2A63B23A29076A6F1DE_734067647.addTaint(taint);
        return var4ACBAC30FC82A2A63B23A29076A6F1DE_734067647;
        // ---------- Original Method ----------
        //return Integer.toHexString(c);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.623 -0400", hash_original_field = "8EA9CA4F3CA6F25FD16D23B5CEF2BF3C", hash_generated_field = "CA23A340A271E932968B5D7D53D04890")

    private static final long serialVersionUID = 19080630L;
}

