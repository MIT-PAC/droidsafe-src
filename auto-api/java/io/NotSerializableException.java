package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NotSerializableException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.064 -0400", hash_original_method = "F05776C79D2C056D2A5E9037EDB03920", hash_generated_method = "E3071F25014A23D137F4E1B852E7E0CA")
    public  NotSerializableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.065 -0400", hash_original_method = "AC41FE5CB653485B7C55102BD4EBFA1E", hash_generated_method = "1DDE35527EB2F2F0B8D30789AD2BCCF2")
    public  NotSerializableException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.065 -0400", hash_original_field = "7AD3D4851AEDBD69120989C544EB910D", hash_generated_field = "CAFA103A93D373FE7AD5320008597CD0")

    private static long serialVersionUID = 2906642554793891381L;
}

