package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class NoClassDefFoundError extends LinkageError {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.358 -0400", hash_original_method = "8CFE32FE45EF5975C0AEC893301BEE4B", hash_generated_method = "0E91492388418CA4E74C2221C3AD3DDC")
    public  NoClassDefFoundError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.358 -0400", hash_original_method = "88A7AB7FEE2EA03213AF9C41CB5D2B15", hash_generated_method = "5B1BB39DBD6C6D89181CD7DE4F2D5796")
    public  NoClassDefFoundError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.358 -0400", hash_original_field = "3BBDD50CDF28334EAE8A1573444528C9", hash_generated_field = "7F723B6959D8FAA4C42C90B77178AC81")

    private static final long serialVersionUID = 9095859863287012458L;
}

