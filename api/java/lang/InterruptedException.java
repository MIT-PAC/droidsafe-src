package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class InterruptedException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.208 -0400", hash_original_method = "276D0C061081F968E041F3504D86F3DC", hash_generated_method = "54C005F360CF44F1F3D0FBF84E1920CD")
    public  InterruptedException() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.209 -0400", hash_original_method = "47A24B4A9D41770C1E928AFF25C6693A", hash_generated_method = "C08CFFB48BC1BEA2415DC4DBEA5EF44C")
    public  InterruptedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.209 -0400", hash_original_field = "62AFE00859395BA49202B2CFC900B3DF", hash_generated_field = "D6A522235FA0337AFC71B5905EFDB292")

    private static final long serialVersionUID = 6700697376100628473L;
}

