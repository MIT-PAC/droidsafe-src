package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class FileNotFoundException extends IOException {
    private static final long serialVersionUID = -897856973823710492L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.454 -0400", hash_original_method = "5655520ED34EDABAA2AA5E324B421F90", hash_generated_method = "7381CE233533DF4806D9A20EE381DDFD")
    @DSModeled(DSC.SAFE)
    public FileNotFoundException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.454 -0400", hash_original_method = "84F2811DBCCBCE4B9E51EB4FDB1C21D5", hash_generated_method = "2FD826D101B8398BF8BB031516246C21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileNotFoundException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


