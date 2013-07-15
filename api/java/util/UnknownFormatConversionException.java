package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnknownFormatConversionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.818 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.818 -0400", hash_original_method = "0FB4C71CADE23BA4642C2B1DAECF427B", hash_generated_method = "BF798D04ED528A525C4F1211EAFB9A39")
    public  UnknownFormatConversionException(String s) {
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_745666715 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_745666715.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_745666715;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.819 -0400", hash_original_method = "F42E87FF5499AB643BB7E67C5DADAA6D", hash_generated_method = "0C4BADBC07F29AD0C01F5EB06A22AACE")
    public String getConversion() {
String var0478718F0636FB61899C13801CE9FE09_1421101010 =         s;
        var0478718F0636FB61899C13801CE9FE09_1421101010.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1421101010;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.820 -0400", hash_original_method = "E0B7E8AB02E28C66CE17D4B71D9F5BCF", hash_generated_method = "7F8B073DB1E216791BC99D433A4634F4")
    @Override
    public String getMessage() {
String var04C013E7FF0CB0D9D0FF7C21A91E8CEF_252023466 =         "Conversion: " + s;
        var04C013E7FF0CB0D9D0FF7C21A91E8CEF_252023466.addTaint(taint);
        return var04C013E7FF0CB0D9D0FF7C21A91E8CEF_252023466;
        // ---------- Original Method ----------
        //return "Conversion: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.820 -0400", hash_original_field = "08597A3199DE8E22FA177F8DC6A38F35", hash_generated_field = "3D86292F0E1219DE043B5F4188CBC598")

    private static final long serialVersionUID = 19060418L;
}

