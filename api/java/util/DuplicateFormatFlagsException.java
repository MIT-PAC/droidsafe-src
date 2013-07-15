package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DuplicateFormatFlagsException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.252 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.253 -0400", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "8D9823769FC7418D10A199E08FB4639E")
    public  DuplicateFormatFlagsException(String f) {
    if(f == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1012442210 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1012442210.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1012442210;
        } //End block
        flags = f;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //flags = f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.253 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "6D5ABCE5AE44DF791C544A0CE9942D29")
    public String getFlags() {
String varD39F51C38FBA335F3A30D14A3811A82C_231509274 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_231509274.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_231509274;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.254 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "D3BF62CF66EEB2D1C5587889E127CF90")
    @Override
    public String getMessage() {
String varD39F51C38FBA335F3A30D14A3811A82C_1909605165 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_1909605165.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_1909605165;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:03.254 -0400", hash_original_field = "F993B819FAAC7CCE6A9417B26EF9DEB5", hash_generated_field = "4C0E6AE2289782AA658DEA3E3AFA2999")

    private static final long serialVersionUID = 18890531L;
}

