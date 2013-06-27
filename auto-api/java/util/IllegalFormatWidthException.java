package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalFormatWidthException extends IllegalFormatException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.138 -0400", hash_original_field = "F1290186A5D0B1CEAB27F4E77C0C5D68", hash_generated_field = "23C6668234F9AB5AD401877AE4904DE1")

    private int w;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.139 -0400", hash_original_method = "3E51700FF2AA6FFF2196939892FEBA05", hash_generated_method = "4DD4772DE4285108BD460BD54AF74ECB")
    public  IllegalFormatWidthException(int w) {
        this.w = w;
        // ---------- Original Method ----------
        //this.w = w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.139 -0400", hash_original_method = "E748E6398AAC681AB6A0D4D76FADF497", hash_generated_method = "7210918C920E9D4BDF6D0BEEE598EE86")
    public int getWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888003801 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888003801;
        // ---------- Original Method ----------
        //return w;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.139 -0400", hash_original_method = "DC0A01255F859E7DE489CAE4D4B39EB6", hash_generated_method = "75C52259872A713B1CECCF399C4F0533")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1010589733 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1010589733 = Integer.toString(w);
        varB4EAC82CA7396A68D541C85D26508E83_1010589733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010589733;
        // ---------- Original Method ----------
        //return Integer.toString(w);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.140 -0400", hash_original_field = "F74B6BCC9577BA144E0D156B1DFE7072", hash_generated_field = "CF4DF78E4307EE2CE1EA6609BC9573FD")

    private static long serialVersionUID = 16660902L;
}

