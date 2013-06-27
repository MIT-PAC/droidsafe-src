package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsatisfiedLinkError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.728 -0400", hash_original_method = "4F1AAD53B033EB263910F7523EBBB434", hash_generated_method = "7AB5ED1DC96BEAEC657FF0F58A7545D2")
    public  UnsatisfiedLinkError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.728 -0400", hash_original_method = "B54BA137AD45C0554FF2013805B3936E", hash_generated_method = "C916F3E2CFD0883CEE8BC0D5187AC92C")
    public  UnsatisfiedLinkError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.728 -0400", hash_original_field = "B8D23C3850733530ED2CB109F0C87642", hash_generated_field = "D968725924F97B420D14ACD5F4D12AAB")

    private static long serialVersionUID = -4019343241616879428L;
}

