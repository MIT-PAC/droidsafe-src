package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;






public class IllegalFormatFlagsException extends IllegalFormatException implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.501 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.501 -0400", hash_original_method = "C96D31C6D500DFB377940B671202C076", hash_generated_method = "606309E0D3D43CB5F7F9A0B30C195474")
    public  IllegalFormatFlagsException(String flags) {
        if(flags == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1050278728 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1050278728.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1050278728;
        } //End block
        this.flags = flags;
        // ---------- Original Method ----------
        //if (flags == null) {
            //throw new NullPointerException();
        //}
        //this.flags = flags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.501 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "E06A66DC32B1F3B4A8C135A63CCA4BA9")
    public String getFlags() {
String varD39F51C38FBA335F3A30D14A3811A82C_240065633 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_240065633.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_240065633;
        // ---------- Original Method ----------
        //return flags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.502 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "A9BCCBC0D60071622C02A923F767E26F")
    @Override
    public String getMessage() {
String varD39F51C38FBA335F3A30D14A3811A82C_613763942 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_613763942.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_613763942;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.502 -0400", hash_original_field = "86A01FCBD1242EE1360CD6FC32283E2D", hash_generated_field = "3B223E7F26C32E3992CEACF94EAB3E33")

    private static final long serialVersionUID = 790824L;
}

