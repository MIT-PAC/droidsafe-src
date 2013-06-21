package libcore.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.InetAddress;

public final class StructGroupReq {
    public int gr_interface;
    public InetAddress gr_group;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.019 -0400", hash_original_method = "4D71F3877768E92734212FD10E1F3346", hash_generated_method = "712882E9A24160E7B9D95DE59C99C728")
    @DSModeled(DSC.SAFE)
    public StructGroupReq(int gr_interface, InetAddress gr_group) {
        dsTaint.addTaint(gr_interface);
        dsTaint.addTaint(gr_group.dsTaint);
        // ---------- Original Method ----------
        //this.gr_interface = gr_interface;
        //this.gr_group = gr_group;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.019 -0400", hash_original_method = "7C7A6CFDA39E9F15601C4EC14F339026", hash_generated_method = "870C570C0D55FA582D87DD3614554B37")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StructGroupReq[gr_interface=" + gr_interface + ",gr_group=" + gr_group + "]";
    }

    
}

