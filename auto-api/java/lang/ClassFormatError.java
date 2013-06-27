package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ClassFormatError extends LinkageError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.296 -0400", hash_original_method = "425CA80A6692859A51AA327ECCF27B34", hash_generated_method = "BF82F7972D435F9EE4D71CA7D0625D1F")
    public  ClassFormatError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.296 -0400", hash_original_method = "BAE3B13B354B16D7CAA986D0ECE3EF81", hash_generated_method = "B2AB2C4D43C370115B45008C4ACD2EEC")
    public  ClassFormatError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.296 -0400", hash_original_field = "D280089B89EA3EF97019C2C1064183E7", hash_generated_field = "50311D9C569C3F5333CEF9821D0A114A")

    private static long serialVersionUID = -8420114879011949195L;
}

