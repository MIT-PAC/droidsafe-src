package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class VirtualMachineError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.810 -0400", hash_original_method = "0F69B8238323DB052C2C0DA7A3D55736", hash_generated_method = "BD1C14FF154705C3FFBF881DDDA61EC6")
    public  VirtualMachineError() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.810 -0400", hash_original_method = "93E73561FDCA8CBD84645ED54333765D", hash_generated_method = "84BEE9C01050148EE9D2573F488DACE4")
    public  VirtualMachineError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:47.811 -0400", hash_original_field = "D93FAF970C64276FD186C4BF43DB1F7D", hash_generated_field = "37C73C9EC87FE5E20B65E378CAE59D15")

    private static final long serialVersionUID = 4161983926571568670L;
}

