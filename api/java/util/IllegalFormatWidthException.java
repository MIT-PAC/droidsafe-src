package java.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IllegalFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.516 -0400", hash_original_field = "F1290186A5D0B1CEAB27F4E77C0C5D68", hash_generated_field = "23C6668234F9AB5AD401877AE4904DE1")

    private int w;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.516 -0400", hash_original_method = "3E51700FF2AA6FFF2196939892FEBA05", hash_generated_method = "4DD4772DE4285108BD460BD54AF74ECB")
    public  IllegalFormatWidthException(int w) {
        this.w = w;
        // ---------- Original Method ----------
        //this.w = w;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.517 -0400", hash_original_method = "E748E6398AAC681AB6A0D4D76FADF497", hash_generated_method = "59BBBB351C4E7F87786FFF33C4180163")
    public int getWidth() {
        int varF1290186A5D0B1CEAB27F4E77C0C5D68_488733736 = (w);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303071629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303071629;
        // ---------- Original Method ----------
        //return w;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.517 -0400", hash_original_method = "DC0A01255F859E7DE489CAE4D4B39EB6", hash_generated_method = "C61DACA1AF961AE8A9EF97BC85E25F2C")
    @Override
    public String getMessage() {
String var00AF56990849708EA607805BA70ACC53_1036544230 =         Integer.toString(w);
        var00AF56990849708EA607805BA70ACC53_1036544230.addTaint(taint);
        return var00AF56990849708EA607805BA70ACC53_1036544230;
        // ---------- Original Method ----------
        //return Integer.toString(w);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.517 -0400", hash_original_field = "F74B6BCC9577BA144E0D156B1DFE7072", hash_generated_field = "53D64A015A46BFFFE5AD78E919F8231E")

    private static final long serialVersionUID = 16660902L;
}

