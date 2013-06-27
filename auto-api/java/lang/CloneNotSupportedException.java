package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CloneNotSupportedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.364 -0400", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "D990718C59BDF04A949966C4F9976823")
    public  CloneNotSupportedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.364 -0400", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "825F226779B0E1E0EE82E2030A12B79A")
    public  CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.364 -0400", hash_original_field = "EFDBAB6F0FFF56EFA226BF324AA14082", hash_generated_field = "4B891633399EB581C340E10C150C2084")

    private static long serialVersionUID = 5195511250079656443L;
}

