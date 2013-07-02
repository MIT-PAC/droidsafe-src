package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class IllegalFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.527 -0400", hash_original_field = "F1290186A5D0B1CEAB27F4E77C0C5D68", hash_generated_field = "23C6668234F9AB5AD401877AE4904DE1")

    private int w;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.527 -0400", hash_original_method = "3E51700FF2AA6FFF2196939892FEBA05", hash_generated_method = "4DD4772DE4285108BD460BD54AF74ECB")
    public  IllegalFormatWidthException(int w) {
        this.w = w;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.527 -0400", hash_original_method = "E748E6398AAC681AB6A0D4D76FADF497", hash_generated_method = "50B8733C47C77EA237919A9256A127ED")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755913725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755913725;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.528 -0400", hash_original_method = "DC0A01255F859E7DE489CAE4D4B39EB6", hash_generated_method = "6AD4054559AFE4E5CF033DF1D05763E6")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1436430895 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1436430895 = Integer.toString(w);
        varB4EAC82CA7396A68D541C85D26508E83_1436430895.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1436430895;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.528 -0400", hash_original_field = "F74B6BCC9577BA144E0D156B1DFE7072", hash_generated_field = "53D64A015A46BFFFE5AD78E919F8231E")

    private static final long serialVersionUID = 16660902L;
}

