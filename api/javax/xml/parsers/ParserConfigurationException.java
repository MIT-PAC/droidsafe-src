package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ParserConfigurationException extends Exception {

    /**
     * Create a new <code>ParserConfigurationException</code> with no
     * detail message.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.264 -0500", hash_original_method = "8E684FA0ECF2833FC98AE584F5004E57", hash_generated_method = "0C6BC82ACD7D70E8489D62B197489044")
    
public ParserConfigurationException() {
    }

    /**
     * Create a new <code>ParserConfigurationException</code> with
     * the <code>String</code> specified as an error message.
     *
     * @param msg The error message for the exception.
     */

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.267 -0500", hash_original_method = "A53B6C9369FBB7C97FD6103A4EABE7DB", hash_generated_method = "EAB55C0344617AE8D546309413C0BDDC")
    
public ParserConfigurationException(String msg) {
        super(msg);
    }
    
}

