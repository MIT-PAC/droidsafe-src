package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ConcurrentModificationException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.036 -0400", hash_original_method = "5F5AEF59023EF0CE03A16FBB12617DB7", hash_generated_method = "79688BEA5D6B303CB294241AA0949D8E")
    public  ConcurrentModificationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.040 -0400", hash_original_method = "106C24DD3D2A07AA8584E42740C7683A", hash_generated_method = "48EF744F66E1DD67C648FF03510CC342")
    public  ConcurrentModificationException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.040 -0400", hash_original_method = "2C18D4011661B4B4C3C2AF76F80D71D0", hash_generated_method = "F2A76443422049245B147E5C3E066239")
    public  ConcurrentModificationException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.041 -0400", hash_original_method = "1483D8E8224DDF6AD31766681C65E484", hash_generated_method = "51B1549ED82E454472609869B884B7D8")
    public  ConcurrentModificationException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:50.041 -0400", hash_original_field = "6F023EBCD220EEE9FD9D969786933435", hash_generated_field = "A797AB6E64C0488E0F10875DBC10678D")

    private static long serialVersionUID = -3666751008965953603L;
}

