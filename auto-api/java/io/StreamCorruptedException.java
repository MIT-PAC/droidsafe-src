package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class StreamCorruptedException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.888 -0400", hash_original_method = "03146CFF1C14D5173926865A5139AFE4", hash_generated_method = "58327F1F20247974100B1AF168E65E97")
    public  StreamCorruptedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.889 -0400", hash_original_method = "6AA6DFEF93503E81D7AC2485347FBC08", hash_generated_method = "29C57103E445384F5FD6D420BE45AEA0")
    public  StreamCorruptedException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.889 -0400", hash_original_field = "C81D07EEDBE96789F2215A96129AD6D9", hash_generated_field = "EFE5DA630BBE2FCBC6FAE84CE279A0F5")

    private static long serialVersionUID = 8983558202217591746L;
}

