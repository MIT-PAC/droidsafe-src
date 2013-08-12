package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;


public class StaleDataException extends java.lang.RuntimeException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.091 -0400", hash_original_method = "0B77138B0532969AEB67E7DB9731EFEE", hash_generated_method = "CA11876DF9991FF914361FBFA8E0B2B4")
    public  StaleDataException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.092 -0400", hash_original_method = "4D539F55BE24816442AFE115AFCF4654", hash_generated_method = "AC404D848094EFC3CC11B99B7DFB2C2F")
    public  StaleDataException(String description) {
        super(description);
        addTaint(description.getTaint());
        // ---------- Original Method ----------
    }

    
}

