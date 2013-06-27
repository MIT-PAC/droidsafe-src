package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParserConfigurationException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.592 -0400", hash_original_method = "8E684FA0ECF2833FC98AE584F5004E57", hash_generated_method = "53A7B7CE142D7AEF09E0FF4A81F112E7")
    public  ParserConfigurationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.593 -0400", hash_original_method = "A53B6C9369FBB7C97FD6103A4EABE7DB", hash_generated_method = "9B1324AE38733BDA523E34831CAFA2AD")
    public  ParserConfigurationException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

