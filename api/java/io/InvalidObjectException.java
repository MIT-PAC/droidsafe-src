package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class InvalidObjectException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.922 -0400", hash_original_method = "4AF46063AE9909D1F5A16DD867276801", hash_generated_method = "0DC243A4BDCD3B7EE60638A77AB9FDFB")
    public  InvalidObjectException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.924 -0400", hash_original_field = "06C77B5AFC6C0750E2329BE623C0BE16", hash_generated_field = "6F09C82044616D14EF4E046B0DC4AF10")

    private static final long serialVersionUID = 3233174318281839583L;
}

