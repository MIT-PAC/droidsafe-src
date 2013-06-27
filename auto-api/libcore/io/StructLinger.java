package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructLinger {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.179 -0400", hash_original_field = "40A71E47B0D99B119DE0C65A0B48528E", hash_generated_field = "313A34DC743869D82F472BEDE730F98E")

    public int l_onoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.180 -0400", hash_original_field = "689F9F1C457A5CB3BAE385B3499F4D5F", hash_generated_field = "D8BC60732FDD96B0D1DB46A72316816A")

    public int l_linger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.181 -0400", hash_original_method = "B2DBC5125F252FD79E2837DA3A5E5C7A", hash_generated_method = "01C58025B7637D560E391B8C3FEF0630")
    public  StructLinger(int l_onoff, int l_linger) {
        this.l_onoff = l_onoff;
        this.l_linger = l_linger;
        // ---------- Original Method ----------
        //this.l_onoff = l_onoff;
        //this.l_linger = l_linger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.182 -0400", hash_original_method = "9E5D902293FF11591147857F4F3E0D72", hash_generated_method = "B77252547679F3376D5DAC812C04ED5A")
    public boolean isOn() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_349522486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_349522486;
        // ---------- Original Method ----------
        //return l_onoff != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:03.182 -0400", hash_original_method = "F93BE5BFF4FFDE74302B318FFC6DC0AC", hash_generated_method = "59D4B4620F26A33F5347A9C86A83867C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_134783321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_134783321 = "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
        varB4EAC82CA7396A68D541C85D26508E83_134783321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_134783321;
        // ---------- Original Method ----------
        //return "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
    }

    
}

