package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InterruptedIOException extends IOException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.105 -0400", hash_original_field = "3CB7FB76A0EEB1CC4DE9CC54B28CCAB8", hash_generated_field = "ADADEC4FF5BBED2ACE9FA0E36B78EE7E")

    public int bytesTransferred;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.106 -0400", hash_original_method = "BB9DACD07ED93D41347C3772C10021CB", hash_generated_method = "83F36F7416CDB5F5500CC88912367489")
    public  InterruptedIOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.106 -0400", hash_original_method = "9DCF8CB18681541ED5194D8FB0295B7F", hash_generated_method = "FC8942E3B5BFB3AAEC381BD5BC60B9C0")
    public  InterruptedIOException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.106 -0400", hash_original_method = "4976F1F97DF8BBE1F3AC7D56299FEDE9", hash_generated_method = "FC1838EDF6EF401FE5785A8475D86A1A")
    public  InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.106 -0400", hash_original_field = "64B0CD09CF62A7C8A0F9BD282DF15A15", hash_generated_field = "00B7350ACE79265F1BE5866C28B5A783")

    private static final long serialVersionUID = 4020568460727500567L;
}

