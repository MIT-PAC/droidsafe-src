package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedOperationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.714 -0400", hash_original_method = "7F6DB5D5ED9D38F1F537736368EB0450", hash_generated_method = "A99A19AC28CD29E8B1E65D945AA0DFDA")
    public  UnsupportedOperationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.715 -0400", hash_original_method = "D8E5E0CB144C04E81C4A0C2F4745C381", hash_generated_method = "763DB76378F9B1914D41429CBE10CDC0")
    public  UnsupportedOperationException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.715 -0400", hash_original_method = "66AB41D7AD796BF9B33430AF2C434F38", hash_generated_method = "80C10D0A52D2DE4D8017937183AC071D")
    public  UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.715 -0400", hash_original_method = "47724B2BD03E5789FE4A564680099229", hash_generated_method = "00EBFE15AC5DA49C3409311D184F22A5")
    public  UnsupportedOperationException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:41.726 -0400", hash_original_field = "7271E450BBCF0C7A1F91C25441CECD7E", hash_generated_field = "5CBB3858CEEE1C599AFF95002EED88A3")

    private static long serialVersionUID = -1242599979055084673L;
}

