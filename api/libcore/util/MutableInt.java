package libcore.util;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class MutableInt {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.443 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "5378D9E8A0DCF58CE286A9736F14A59E")

    public int value;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.443 -0400", hash_original_method = "03C0B08CFD4223793C8EE7C700E72B55", hash_generated_method = "8EBFC592B8F5B331690B4A1E8337C15B")
    public  MutableInt(int value) {
        this.value = value;
        // ---------- Original Method ----------
        //this.value = value;
    }

    
}

