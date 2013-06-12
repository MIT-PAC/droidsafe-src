package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class StreamCorruptedException extends ObjectStreamException {
    private static final long serialVersionUID = 8983558202217591746L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.683 -0400", hash_original_method = "03146CFF1C14D5173926865A5139AFE4", hash_generated_method = "DE6FF2AABDE1A48B680FB9210F7BE880")
    @DSModeled(DSC.SAFE)
    public StreamCorruptedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.683 -0400", hash_original_method = "6AA6DFEF93503E81D7AC2485347FBC08", hash_generated_method = "0CE8C14A15D265E87AD2E5E382E00AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StreamCorruptedException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


