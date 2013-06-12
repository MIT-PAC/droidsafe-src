package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class SQLException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.697 -0400", hash_original_method = "556E5C618BFB2928AAC4F47E36A85E30", hash_generated_method = "E0DBA0A2751D0C9A7442A0BA3ABAF68D")
    @DSModeled(DSC.SAFE)
    public SQLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.697 -0400", hash_original_method = "DC2A21E6520D20A30A0F3CD7D71F8640", hash_generated_method = "F8E5C2D41D81D044E3CDDEEBB7CEA8DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SQLException(String error) {
        super(error);
        dsTaint.addTaint(error);
        // ---------- Original Method ----------
    }

    
}


