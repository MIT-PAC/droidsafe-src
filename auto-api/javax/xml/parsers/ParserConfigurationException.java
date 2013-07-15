package javax.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ParserConfigurationException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.710 -0400", hash_original_method = "8E684FA0ECF2833FC98AE584F5004E57", hash_generated_method = "53A7B7CE142D7AEF09E0FF4A81F112E7")
    public  ParserConfigurationException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.710 -0400", hash_original_method = "A53B6C9369FBB7C97FD6103A4EABE7DB", hash_generated_method = "9B1324AE38733BDA523E34831CAFA2AD")
    public  ParserConfigurationException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

