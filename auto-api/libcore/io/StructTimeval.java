package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructTimeval {
    public long tv_sec;
    public long tv_usec;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.024 -0400", hash_original_method = "2F5BA123079D794DD3CCFA1F00DAAB1E", hash_generated_method = "9D3DF1CD37DCDD6AF19CF47FC72F5DC9")
    @DSModeled(DSC.SAFE)
    private StructTimeval(long tv_sec, long tv_usec) {
        dsTaint.addTaint(tv_sec);
        dsTaint.addTaint(tv_usec);
        // ---------- Original Method ----------
        //this.tv_sec = tv_sec;
        //this.tv_usec = tv_usec;
    }

    
        public static StructTimeval fromMillis(long millis) {
        long tv_sec = millis / 1000;
        long tv_usec = (millis - (tv_sec * 1000)) * 1000;
        return new StructTimeval(tv_sec, tv_usec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.024 -0400", hash_original_method = "D7D8FCD49C11BCD20431CC831BF1CCDC", hash_generated_method = "C5D11DB2758263A99AE26D96C56E5C66")
    @DSModeled(DSC.SAFE)
    public long toMillis() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return (tv_sec * 1000) + (tv_usec / 1000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.024 -0400", hash_original_method = "0C66DEC6052711C5671EFCEF17FE1D94", hash_generated_method = "F4730BFD87924E01515369C7642B81C4")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StructTimeval[tv_sec=" + tv_sec + ",tv_usec=" + tv_usec + "]";
    }

    
}

