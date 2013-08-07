package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class DuplicateFormatFlagsException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.325 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "656D592B6CD40AFAB0AF81166CB40D7D")

    private String flags;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.325 -0400", hash_original_method = "BC09E00DC83FE8523846524A935EDBC5", hash_generated_method = "BA20D72A65CC353E0D54071CA3FA9727")
    public  DuplicateFormatFlagsException(String f) {
        if(f == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1319822934 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1319822934.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1319822934;
        } //End block
        flags = f;
        // ---------- Original Method ----------
        //if (f == null) {
            //throw new NullPointerException();
        //}
        //flags = f;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.325 -0400", hash_original_method = "29D28F2D87A5BF440E9E6F54EB537F58", hash_generated_method = "9BA36442A2C38C21D962E59B14F0605F")
    public String getFlags() {
String varD39F51C38FBA335F3A30D14A3811A82C_981230655 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_981230655.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_981230655;
        // ---------- Original Method ----------
        //return flags;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.325 -0400", hash_original_method = "EC94AFCF80AA730DDC49A1A93BB12591", hash_generated_method = "31A05343D3647AB240033BA681FB31AC")
    @Override
    public String getMessage() {
String varD39F51C38FBA335F3A30D14A3811A82C_1499160483 =         flags;
        varD39F51C38FBA335F3A30D14A3811A82C_1499160483.addTaint(taint);
        return varD39F51C38FBA335F3A30D14A3811A82C_1499160483;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:07.325 -0400", hash_original_field = "F993B819FAAC7CCE6A9417B26EF9DEB5", hash_generated_field = "4C0E6AE2289782AA658DEA3E3AFA2999")

    private static final long serialVersionUID = 18890531L;
}

