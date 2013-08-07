package java.util.zip;

// Droidsafe Imports
import droidsafe.annotations.*;


public class DataFormatException extends Exception {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.503 -0400", hash_original_method = "64C52722D8298AB468E7E3E8999CA51F", hash_generated_method = "3EAAEB4127F03FA62C0948D7293BDD0B")
    public  DataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.503 -0400", hash_original_method = "54A194B6E0CA21D574EDE0E22D325A81", hash_generated_method = "128C863845EA3840AFFEC926C6714336")
    public  DataFormatException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.503 -0400", hash_original_field = "52DAE4F4993373D3F0B04BA7CD8F4579", hash_generated_field = "C9CD720E9C64714A16820A451BFCDC51")

    private static final long serialVersionUID = 2219632870893641452L;
}

