package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructLinger {
    public int l_onoff;
    public int l_linger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.020 -0400", hash_original_method = "B2DBC5125F252FD79E2837DA3A5E5C7A", hash_generated_method = "67EB319D13BA47AFDC54EC81AB581D0A")
    @DSModeled(DSC.SAFE)
    public StructLinger(int l_onoff, int l_linger) {
        dsTaint.addTaint(l_onoff);
        dsTaint.addTaint(l_linger);
        // ---------- Original Method ----------
        //this.l_onoff = l_onoff;
        //this.l_linger = l_linger;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.020 -0400", hash_original_method = "9E5D902293FF11591147857F4F3E0D72", hash_generated_method = "A86964113041702CD8F120A8896B1D0A")
    @DSModeled(DSC.SAFE)
    public boolean isOn() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return l_onoff != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.020 -0400", hash_original_method = "F93BE5BFF4FFDE74302B318FFC6DC0AC", hash_generated_method = "18C442242F8C1C0ED70CAE9721133D18")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
    }

    
}

