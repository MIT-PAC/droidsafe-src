package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InternalError extends VirtualMachineError {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.205 -0400", hash_original_method = "18A11DFE954AAC7F3401D9A18E98EAA5", hash_generated_method = "6CB2AD680A92FD012F933015174E0A46")
    public  InternalError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.206 -0400", hash_original_method = "11A7F61F65B1BF556316C3B357308A87", hash_generated_method = "E9DD4839E3562DA66C7916783D23E007")
    public  InternalError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.206 -0400", hash_original_field = "07244973AA85D4984C2BA9B8626B4EFA", hash_generated_field = "DAD8FB96BBB0A062B3DA55A68D183E86")

    private static final long serialVersionUID = -9062593416125562365L;
}

