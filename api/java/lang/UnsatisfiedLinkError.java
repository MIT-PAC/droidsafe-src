package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class UnsatisfiedLinkError extends LinkageError {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.666 -0400", hash_original_method = "4F1AAD53B033EB263910F7523EBBB434", hash_generated_method = "7AB5ED1DC96BEAEC657FF0F58A7545D2")
    public  UnsatisfiedLinkError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.667 -0400", hash_original_method = "B54BA137AD45C0554FF2013805B3936E", hash_generated_method = "C916F3E2CFD0883CEE8BC0D5187AC92C")
    public  UnsatisfiedLinkError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.667 -0400", hash_original_field = "B8D23C3850733530ED2CB109F0C87642", hash_generated_field = "F642A49CE4CD3CAFBAC50AE6F6260B5A")

    private static final long serialVersionUID = -4019343241616879428L;
}

