package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class MissingFormatArgumentException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.301 -0400", hash_original_field = "03C7C0ACE395D80182DB07AE2C30F034", hash_generated_field = "E79B5AF8B4B7B1E184AA763B4F896620")

    private String s;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.302 -0400", hash_original_method = "3488C8E98AE00375533889C559694B58", hash_generated_method = "859A462E775C1E339880BA6E96528135")
    public  MissingFormatArgumentException(String s) {
        if(s == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_825893712 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_825893712.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_825893712;
        } //End block
        this.s = s;
        // ---------- Original Method ----------
        //if (s == null) {
            //throw new NullPointerException();
        //}
        //this.s = s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.302 -0400", hash_original_method = "4D96301902AD0649417B90D095E1EDFD", hash_generated_method = "729C2EAC89C13F0B4467324DE990FD80")
    public String getFormatSpecifier() {
String var0478718F0636FB61899C13801CE9FE09_1774996851 =         s;
        var0478718F0636FB61899C13801CE9FE09_1774996851.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1774996851;
        // ---------- Original Method ----------
        //return s;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.302 -0400", hash_original_method = "D7277B29886D06334EB30606D08F78F5", hash_generated_method = "D4C1BFE82E8AAB521AF043BA29EBCFD8")
    @Override
    public String getMessage() {
String var64A3997F1481D14D238DDFD4FB92CE51_1671887336 =         "Format specifier: " + s;
        var64A3997F1481D14D238DDFD4FB92CE51_1671887336.addTaint(taint);
        return var64A3997F1481D14D238DDFD4FB92CE51_1671887336;
        // ---------- Original Method ----------
        //return "Format specifier: " + s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.302 -0400", hash_original_field = "5CFDCAB17DD67C461A9D1585416DE0E6", hash_generated_field = "723F192E88250AAFAAB75AB9339AECE3")

    private static final long serialVersionUID = 19190115L;
}

