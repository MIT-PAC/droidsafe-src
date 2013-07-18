package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MissingFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.307 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.307 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "2A12ED6A2A640DFCDA50D36271E175DF")
    public  MissingFormatWidthException(String s) {
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1255101354 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1255101354.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1255101354;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.308 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "1B4BDA91B4310A72FC51A7FB888B85C7")
    public String getFormatSpecifier() {
String var0478718F0636FB61899C13801CE9FE09_1189016927 =         s;
        var0478718F0636FB61899C13801CE9FE09_1189016927.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1189016927;
        // ---------- Original Method ----------
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.308 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "085C0ADA3161835A8C0A144CD2182236")
    @Override
    public String getMessage() {
String var0478718F0636FB61899C13801CE9FE09_736111647 =         s;
        var0478718F0636FB61899C13801CE9FE09_736111647.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_736111647;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.308 -0400", hash_original_field = "7188EA7B1AC1322298AB17D61EF9C2EB", hash_generated_field = "9262A014094776552C1DB27AFE71EDD8")

    private static final long serialVersionUID = 15560123L;
}

