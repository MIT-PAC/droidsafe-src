package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StreamCorruptedException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.286 -0400", hash_original_method = "03146CFF1C14D5173926865A5139AFE4", hash_generated_method = "58327F1F20247974100B1AF168E65E97")
    @DSModeled(DSC.SAFE)
    public StreamCorruptedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.286 -0400", hash_original_method = "6AA6DFEF93503E81D7AC2485347FBC08", hash_generated_method = "3641840298013F9B4D0A593CF550EC91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StreamCorruptedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 8983558202217591746L;
}

