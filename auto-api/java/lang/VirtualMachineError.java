package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class VirtualMachineError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.774 -0400", hash_original_method = "0F69B8238323DB052C2C0DA7A3D55736", hash_generated_method = "BD1C14FF154705C3FFBF881DDDA61EC6")
    public  VirtualMachineError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.775 -0400", hash_original_method = "93E73561FDCA8CBD84645ED54333765D", hash_generated_method = "84BEE9C01050148EE9D2573F488DACE4")
    public  VirtualMachineError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.775 -0400", hash_original_field = "D93FAF970C64276FD186C4BF43DB1F7D", hash_generated_field = "9DD427AC5509C44F7A75CE479D157643")

    private static long serialVersionUID = 4161983926571568670L;
}

