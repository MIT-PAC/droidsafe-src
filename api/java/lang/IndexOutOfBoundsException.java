package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IndexOutOfBoundsException extends RuntimeException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.062 -0400", hash_original_method = "D4CD8ADEE84F45A3C2932250B7EFAD5E", hash_generated_method = "21F705B9E81BD76361B6BB1EE50EEEC3")
    public  IndexOutOfBoundsException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.063 -0400", hash_original_method = "43F047B4ECB1C9194E62BC668739E967", hash_generated_method = "EFB4BD9A2A5EEB126591B4F73F003DC9")
    public  IndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.064 -0400", hash_original_field = "41FBF03317C826A6604F3CF2E773984A", hash_generated_field = "E52D317BB649E52FD827F60043ED4186")

    private static final long serialVersionUID = 234122996006267687L;
}

