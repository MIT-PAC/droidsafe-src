package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.632 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.632 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "DBB5F7D66789ED8ABB0A0888AE5E8541")
    public  IllegalFormatFlagsException(String flags) {
    if(flags == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1731176237 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1731176237.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1731176237;
        } //End block
        this.flags = flags;
        // ---------- Original Method ----------
        //if (flags == null) {
            //throw new NullPointerException();
        //}
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.633 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "EF3F24228D9C207328F6769486CDBB61")
    public String getFlags() {
String varD39F51C38FBA335F3A30D14A3811A82C_1324575957 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_1324575957.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_1324575957;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.633 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "5E79F49B24C624C77A9511B4DA90CE30")
    @Override
    public String getMessage() {
String varD39F51C38FBA335F3A30D14A3811A82C_783756579 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_783756579.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_783756579;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.633 -0400", hash_original_field = "86A01FCBD1242EE1360CD6FC32283E2D", hash_generated_field = "3B223E7F26C32E3992CEACF94EAB3E33")

    private static final long serialVersionUID = 790824L;
}

