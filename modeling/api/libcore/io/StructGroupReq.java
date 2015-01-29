package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;

public final class StructGroupReq {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.829 -0500", hash_original_field = "E1A3F20BD1F9C0C1F09C25E770F5A92A", hash_generated_field = "A455D75F586868F1FEF5A4B336E5E17D")

    public  int gr_interface;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.831 -0500", hash_original_field = "20A5CDEF15B79284F2B4B7004967F72B", hash_generated_field = "EF4F7D94FD71F04B44672F9CF0D0F3A0")

    public  InetAddress gr_group;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.835 -0500", hash_original_method = "4D71F3877768E92734212FD10E1F3346", hash_generated_method = "F8EADF037538BD72B2F3A90C02C03345")
    
public StructGroupReq(int gr_interface, InetAddress gr_group) {
        this.gr_interface = gr_interface;
        this.gr_group = gr_group;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.837 -0500", hash_original_method = "7C7A6CFDA39E9F15601C4EC14F339026", hash_generated_method = "8AB6BED795E020CEFAD82354C6C46F32")
    
@Override public String toString() {
        return "StructGroupReq[gr_interface=" + gr_interface + ",gr_group=" + gr_group + "]";
    }
    
}

