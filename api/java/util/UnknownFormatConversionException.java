package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnknownFormatConversionException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.666 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.666 -0400", hash_original_method = "0FB4C71CADE23BA4642C2B1DAECF427B", hash_generated_method = "449E31B12F22A7138A8902190BD17FB4")
    public  UnknownFormatConversionException(String s) {
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1381634394 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1381634394.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1381634394;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.667 -0400", hash_original_method = "F42E87FF5499AB643BB7E67C5DADAA6D", hash_generated_method = "CB064A4775E1EE92AFAE44509A820DE5")
    public String getConversion() {
String var0478718F0636FB61899C13801CE9FE09_1324939476 =         s;
        var0478718F0636FB61899C13801CE9FE09_1324939476.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1324939476;
        // ---------- Original Method ----------
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.667 -0400", hash_original_method = "E0B7E8AB02E28C66CE17D4B71D9F5BCF", hash_generated_method = "B67A8DB88B2E151F4474CDAD2FE90E5C")
    @Override
    public String getMessage() {
String var04C013E7FF0CB0D9D0FF7C21A91E8CEF_1867119917 =         "Conversion: " + s;
        var04C013E7FF0CB0D9D0FF7C21A91E8CEF_1867119917.addTaint(taint);
        return var04C013E7FF0CB0D9D0FF7C21A91E8CEF_1867119917;
        // ---------- Original Method ----------
        //return "Conversion: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.667 -0400", hash_original_field = "08597A3199DE8E22FA177F8DC6A38F35", hash_generated_field = "3D86292F0E1219DE043B5F4188CBC598")

    private static final long serialVersionUID = 19060418L;
}

