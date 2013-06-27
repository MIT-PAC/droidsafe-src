package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DataFormatException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.665 -0400", hash_original_method = "64C52722D8298AB468E7E3E8999CA51F", hash_generated_method = "3EAAEB4127F03FA62C0948D7293BDD0B")
    public  DataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.665 -0400", hash_original_method = "54A194B6E0CA21D574EDE0E22D325A81", hash_generated_method = "128C863845EA3840AFFEC926C6714336")
    public  DataFormatException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.665 -0400", hash_original_field = "52DAE4F4993373D3F0B04BA7CD8F4579", hash_generated_field = "83572D1545F4AE32F6FA7F973389C205")

    private static long serialVersionUID = 2219632870893641452L;
}

