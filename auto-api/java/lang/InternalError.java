package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InternalError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.845 -0400", hash_original_method = "18A11DFE954AAC7F3401D9A18E98EAA5", hash_generated_method = "6CB2AD680A92FD012F933015174E0A46")
    public  InternalError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.846 -0400", hash_original_method = "11A7F61F65B1BF556316C3B357308A87", hash_generated_method = "E9DD4839E3562DA66C7916783D23E007")
    public  InternalError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.846 -0400", hash_original_field = "07244973AA85D4984C2BA9B8626B4EFA", hash_generated_field = "64E736E9269CD5C86070902CA22F4E7C")

    private static long serialVersionUID = -9062593416125562365L;
}

