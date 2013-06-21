package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IOException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.808 -0400", hash_original_method = "4DDFF90B7CF8CD74272BB60235E66E65", hash_generated_method = "F4838CE634BCA6B1BFF2D1925B3382CA")
    @DSModeled(DSC.SAFE)
    public IOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.808 -0400", hash_original_method = "240D0BB3974E5D097E21F85B24F6FB44", hash_generated_method = "63AD954081645FAD1DB08335AB31B197")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.808 -0400", hash_original_method = "D16D4F9A4DF133858001870C6413D65C", hash_generated_method = "2BAA9BCD270C36E3D70385E9EE7A5603")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.809 -0400", hash_original_method = "653E955146B329965A610B3602D07E3E", hash_generated_method = "C3A1C1A45CB787D12CC8AC86B8FFA223")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IOException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 7818375828146090155L;
}

