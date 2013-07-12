package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.638 -0400", hash_original_field = "F1290186A5D0B1CEAB27F4E77C0C5D68", hash_generated_field = "23C6668234F9AB5AD401877AE4904DE1")

    private int w;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.638 -0400", hash_original_method = "3E51700FF2AA6FFF2196939892FEBA05", hash_generated_method = "4DD4772DE4285108BD460BD54AF74ECB")
    public  IllegalFormatWidthException(int w) {
        this.w = w;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.639 -0400", hash_original_method = "E748E6398AAC681AB6A0D4D76FADF497", hash_generated_method = "C3181C072202F7211DAB064BD8BF93DB")
    public int getWidth() {
        int varF1290186A5D0B1CEAB27F4E77C0C5D68_2028392593 = (w);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41808915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41808915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.639 -0400", hash_original_method = "DC0A01255F859E7DE489CAE4D4B39EB6", hash_generated_method = "C7ADB99C0FBE53E42B3620A97419297A")
    @Override
    public String getMessage() {
String var00AF56990849708EA607805BA70ACC53_2045520961 =         Integer.toString(w);
        var00AF56990849708EA607805BA70ACC53_2045520961.addTaint(taint);
        return var00AF56990849708EA607805BA70ACC53_2045520961;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.639 -0400", hash_original_field = "F74B6BCC9577BA144E0D156B1DFE7072", hash_generated_field = "53D64A015A46BFFFE5AD78E919F8231E")

    private static final long serialVersionUID = 16660902L;
}

