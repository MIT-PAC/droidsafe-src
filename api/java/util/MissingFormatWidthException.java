package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MissingFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.253 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.254 -0400", hash_original_method = "3B5695383AF45988D55F3947C3C6E408", hash_generated_method = "80BB9836BFF3BB7F8C03187DBB29022B")
    public  MissingFormatWidthException(String s) {
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_656526667 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_656526667.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_656526667;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.254 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "E97A86A8F7E631C357289E7F09C6A4D0")
    public String getFormatSpecifier() {
String var0478718F0636FB61899C13801CE9FE09_329733792 =         s;
        var0478718F0636FB61899C13801CE9FE09_329733792.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_329733792;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.254 -0400", hash_original_method = "0A4C8E3EAB801D8800E3A2D920D74C80", hash_generated_method = "31166B51A5D3BEA791D4D09539097064")
    @Override
    public String getMessage() {
String var0478718F0636FB61899C13801CE9FE09_620229218 =         s;
        var0478718F0636FB61899C13801CE9FE09_620229218.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_620229218;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.254 -0400", hash_original_field = "7188EA7B1AC1322298AB17D61EF9C2EB", hash_generated_field = "9262A014094776552C1DB27AFE71EDD8")

    private static final long serialVersionUID = 15560123L;
}

