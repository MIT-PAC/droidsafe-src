package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public final class StructUtsname {
    public String sysname;
    public String nodename;
    public String release;
    public String version;
    public String machine;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.025 -0400", hash_original_method = "ABD276C824D50C395959B30AFCABD3AD", hash_generated_method = "44E8E65D324066D566DFC40CE2963661")
    @DSModeled(DSC.SAFE)
     StructUtsname(String sysname, String nodename, String release, String version, String machine) {
        dsTaint.addTaint(nodename);
        dsTaint.addTaint(machine);
        dsTaint.addTaint(release);
        dsTaint.addTaint(version);
        dsTaint.addTaint(sysname);
        // ---------- Original Method ----------
        //this.sysname = sysname;
        //this.nodename = nodename;
        //this.release = release;
        //this.version = version;
        //this.machine = machine;
    }

    
}

