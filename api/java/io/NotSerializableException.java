package java.io;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class NotSerializableException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.155 -0400", hash_original_method = "F05776C79D2C056D2A5E9037EDB03920", hash_generated_method = "E3071F25014A23D137F4E1B852E7E0CA")
    public  NotSerializableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.155 -0400", hash_original_method = "AC41FE5CB653485B7C55102BD4EBFA1E", hash_generated_method = "1DDE35527EB2F2F0B8D30789AD2BCCF2")
    public  NotSerializableException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.155 -0400", hash_original_field = "7AD3D4851AEDBD69120989C544EB910D", hash_generated_field = "48F39D42996338B3D3EADC139002C622")

    private static final long serialVersionUID = 2906642554793891381L;
}

