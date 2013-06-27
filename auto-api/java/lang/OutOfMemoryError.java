package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class OutOfMemoryError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.937 -0400", hash_original_method = "ADBA576B8D149CC9A483364A3C8F9DE7", hash_generated_method = "DBAA38D82B9B26FA356A341B9B00F5D0")
    public  OutOfMemoryError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.937 -0400", hash_original_method = "C0FA448A5BDB254B40480B36A6B3D86E", hash_generated_method = "DEFD3CDA125A70AE3135EA174B8DE4EF")
    public  OutOfMemoryError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.938 -0400", hash_original_field = "44D3011FE1F07370C673FC7A7B5EF018", hash_generated_field = "071461E9D94BB34845FBF2F86DE06639")

    private static long serialVersionUID = 8228564086184010517L;
}

