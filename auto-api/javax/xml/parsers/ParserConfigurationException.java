package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ParserConfigurationException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.595 -0400", hash_original_method = "8E684FA0ECF2833FC98AE584F5004E57", hash_generated_method = "8BEC75D19D5C2D9BB847D6420B237631")
    @DSModeled(DSC.SAFE)
    public ParserConfigurationException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.596 -0400", hash_original_method = "A53B6C9369FBB7C97FD6103A4EABE7DB", hash_generated_method = "9E7FAC9DDE30A7D931BAF5CBE590DC0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParserConfigurationException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}


