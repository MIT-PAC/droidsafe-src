package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class OutOfMemoryError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.058 -0400", hash_original_method = "ADBA576B8D149CC9A483364A3C8F9DE7", hash_generated_method = "DBAA38D82B9B26FA356A341B9B00F5D0")
    public  OutOfMemoryError() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.059 -0400", hash_original_method = "C0FA448A5BDB254B40480B36A6B3D86E", hash_generated_method = "DEFD3CDA125A70AE3135EA174B8DE4EF")
    public  OutOfMemoryError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.059 -0400", hash_original_field = "44D3011FE1F07370C673FC7A7B5EF018", hash_generated_field = "6777CAF84C62D33BC871EAE1C16AF151")

    private static final long serialVersionUID = 8228564086184010517L;
}

