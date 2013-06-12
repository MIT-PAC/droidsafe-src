package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class IOException extends Exception {
    private static final long serialVersionUID = 7818375828146090155L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "4DDFF90B7CF8CD74272BB60235E66E65", hash_generated_method = "0A471C07336644150176B7F96F874E70")
    @DSModeled(DSC.SAFE)
    public IOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "240D0BB3974E5D097E21F85B24F6FB44", hash_generated_method = "F33AA432D27B4368A72C614D95CF909D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "D16D4F9A4DF133858001870C6413D65C", hash_generated_method = "C075A6BFC234CCFD4E655E3DBEB36D42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "653E955146B329965A610B3602D07E3E", hash_generated_method = "7CEB39A18315525A801996AB8B1AE577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
}


