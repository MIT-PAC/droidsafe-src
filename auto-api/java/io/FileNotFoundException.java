package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class FileNotFoundException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.768 -0400", hash_original_method = "5655520ED34EDABAA2AA5E324B421F90", hash_generated_method = "6C54B6B06E8CFF64E97527885C62D6DC")
    @DSModeled(DSC.SAFE)
    public FileNotFoundException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.769 -0400", hash_original_method = "84F2811DBCCBCE4B9E51EB4FDB1C21D5", hash_generated_method = "63B25582B377AA92991D803FE0325F0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FileNotFoundException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -897856973823710492L;
}

