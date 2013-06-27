package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidMarkException extends IllegalStateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.609 -0400", hash_original_method = "B1EE027FE89EEC127536AB7DEF53C391", hash_generated_method = "02636A3D0215C600F7C165854E4FB0DC")
    public  InvalidMarkException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.610 -0400", hash_original_method = "29531E800CAD0F117D34A6102B8A5CF9", hash_generated_method = "12439BB8A7F05A76A92F3ED9129F6BAE")
    public  InvalidMarkException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:45.610 -0400", hash_original_field = "7FAC4A75486D8C40854BA5928A785350", hash_generated_field = "0C224F43914546D0208F9A924670AB66")

    private static long serialVersionUID = 1698329710438510774L;
}

