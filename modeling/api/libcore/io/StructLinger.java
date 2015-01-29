package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StructLinger {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.868 -0500", hash_original_field = "A78CA655CA35C68307B38A883F062E58", hash_generated_field = "313A34DC743869D82F472BEDE730F98E")

    public  int l_onoff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.870 -0500", hash_original_field = "32E13CC419A45BB78FB27A6ABA473BC5", hash_generated_field = "D8BC60732FDD96B0D1DB46A72316816A")

    public  int l_linger;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.873 -0500", hash_original_method = "B2DBC5125F252FD79E2837DA3A5E5C7A", hash_generated_method = "04B36ACA1EA2B9A5BBE6449E5E6068E4")
    
public StructLinger(int l_onoff, int l_linger) {
        this.l_onoff = l_onoff;
        this.l_linger = l_linger;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.875 -0500", hash_original_method = "9E5D902293FF11591147857F4F3E0D72", hash_generated_method = "9AE321B3914056648980F923BF953A6E")
    
public boolean isOn() {
        return l_onoff != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.877 -0500", hash_original_method = "F93BE5BFF4FFDE74302B318FFC6DC0AC", hash_generated_method = "CED7527B424594A81A8918DC71B96A89")
    
@Override public String toString() {
        return "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
    }
    
}

