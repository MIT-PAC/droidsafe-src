package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MissingFormatArgumentException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.250 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.251 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "C6C470C11F722C5FBD4B81B7273C6CDA")
    public  MissingFormatArgumentException(String s) {
    if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_392050694 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_392050694.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_392050694;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.251 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "911AC3BB143DCFE0586B61FCC34E1FEC")
    public String getFormatSpecifier() {
String var0478718F0636FB61899C13801CE9FE09_750369139 =         s;
        var0478718F0636FB61899C13801CE9FE09_750369139.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_750369139;
        // ---------- Original Method ----------
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.251 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "1ECF8CB35C14D6F16D821B2C1215EAD2")
    @Override
    public String getMessage() {
String var64A3997F1481D14D238DDFD4FB92CE51_1777798586 =         "Format specifier: " + s;
        var64A3997F1481D14D238DDFD4FB92CE51_1777798586.addTaint(taint);
        return var64A3997F1481D14D238DDFD4FB92CE51_1777798586;
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.251 -0400", hash_original_field = "5CFDCAB17DD67C461A9D1585416DE0E6", hash_generated_field = "723F192E88250AAFAAB75AB9339AECE3")

    private static final long serialVersionUID = 19190115L;
}

