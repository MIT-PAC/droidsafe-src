package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class NoSuchMethodError extends IncompatibleClassChangeError {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.366 -0400", hash_original_method = "80EBD198F916FEE348D274437586B5BC", hash_generated_method = "47FDE86C35A2EDC474B42FD4951F4771")
    public  NoSuchMethodError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.366 -0400", hash_original_method = "4CC31AAD9CD08413E75D886E5A5CF2D3", hash_generated_method = "F70A06E2B6A2049C050C4CF6BC542578")
    public  NoSuchMethodError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.366 -0400", hash_original_field = "78428C3BD4379F8D5042ABC27C7729E6", hash_generated_field = "635C9A9BFCFFDA068A7F59FA9CD17FE1")

    private static final long serialVersionUID = -3765521442372831335L;
}

