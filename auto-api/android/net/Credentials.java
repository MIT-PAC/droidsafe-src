package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Credentials {
    private int pid;
    private int uid;
    private int gid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.523 -0400", hash_original_method = "0D22AAF944E180A41FC070C17248D99F", hash_generated_method = "E3AA64904E7A154E7505B5C114195BC5")
    @DSModeled(DSC.SAFE)
    public Credentials(int pid, int uid, int gid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(gid);
        dsTaint.addTaint(pid);
        // ---------- Original Method ----------
        //this.pid = pid;
        //this.uid = uid;
        //this.gid = gid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.524 -0400", hash_original_method = "78D1E6D4CA2C23604540BE821B70C9C5", hash_generated_method = "C90D8273FED14EFF7DF1DD5A792B4546")
    @DSModeled(DSC.SAFE)
    public int getPid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return pid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.525 -0400", hash_original_method = "0C7AA9282DA1BA7425530FB39ADDE6D7", hash_generated_method = "45999B48B5813F7FCE78D602F40184ED")
    @DSModeled(DSC.SAFE)
    public int getUid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.525 -0400", hash_original_method = "62E574E9D4A38B83D3EBF8EDA61883B3", hash_generated_method = "2EDF21B0DA93B150A55C04875BBC87F6")
    @DSModeled(DSC.SAFE)
    public int getGid() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return gid;
    }

    
}

