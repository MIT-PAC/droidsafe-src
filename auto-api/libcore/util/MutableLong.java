package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class MutableLong {
    public long value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.689 -0400", hash_original_method = "B5E860DA0DFEBF0A4A36C551942DC427", hash_generated_method = "15BCF215B558892AFEB0137E4D3FB454")
    @DSModeled(DSC.SAFE)
    public MutableLong(long value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.value = value;
    }

    
}

