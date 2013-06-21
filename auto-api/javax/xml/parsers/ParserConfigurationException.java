package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParserConfigurationException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.399 -0400", hash_original_method = "8E684FA0ECF2833FC98AE584F5004E57", hash_generated_method = "53A7B7CE142D7AEF09E0FF4A81F112E7")
    @DSModeled(DSC.SAFE)
    public ParserConfigurationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.400 -0400", hash_original_method = "A53B6C9369FBB7C97FD6103A4EABE7DB", hash_generated_method = "20EA1B52C73432DECB3D0AE3CBC50626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParserConfigurationException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

