package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;



public class EOFException extends IOException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.624 -0400", hash_original_method = "1CCCAA76135EE86F6894FC590C0C686A", hash_generated_method = "7B880AD42DEB094CD5B685C1C5FFAC26")
    public  EOFException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.624 -0400", hash_original_method = "1DF3A1A90A52071351DFC31CC87C4540", hash_generated_method = "855014E89A61FE5F00BB1A0F46233C4D")
    public  EOFException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.625 -0400", hash_original_field = "B7325034DCD2CA48559C1DD367EA5CAB", hash_generated_field = "22BD3585BCD2E328E0B1FBA88D70C08F")

    private static final long serialVersionUID = 6433858223774886977L;
}

