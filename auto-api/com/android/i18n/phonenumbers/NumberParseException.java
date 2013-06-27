package com.android.i18n.phonenumbers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NumberParseException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.989 -0400", hash_original_field = "2A8BCE4C57FBA6E1E2136D9DB057B722", hash_generated_field = "84B9E028BBF2DC9E5382F00380C2F272")

    private ErrorType errorType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.989 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "B2821CE5540C52B19670BB2C4012F012")

    private String message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.989 -0400", hash_original_method = "E3BFB23E8C79BF87D1C5A9FB2A377F86", hash_generated_method = "3806F73A468A4900F06EBC218AF22D9C")
    public  NumberParseException(ErrorType errorType, String message) {
        super(message);
        this.message = message;
        this.errorType = errorType;
        // ---------- Original Method ----------
        //this.message = message;
        //this.errorType = errorType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.990 -0400", hash_original_method = "D589126B13584B530A9FB2F071914799", hash_generated_method = "3CB4900B1FB491091E8DC00F7F5E8080")
    public ErrorType getErrorType() {
        ErrorType varB4EAC82CA7396A68D541C85D26508E83_1323581833 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1323581833 = errorType;
        varB4EAC82CA7396A68D541C85D26508E83_1323581833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1323581833;
        // ---------- Original Method ----------
        //return errorType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:11.991 -0400", hash_original_method = "6D8405A96F8D5D279CAA6C0BAAB6D3AE", hash_generated_method = "C6B637823CC17F645373274174ED5E68")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_918330186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_918330186 = "Error type: " + errorType + ". " + message;
        varB4EAC82CA7396A68D541C85D26508E83_918330186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_918330186;
        // ---------- Original Method ----------
        //return "Error type: " + errorType + ". " + message;
    }

    
    public enum ErrorType {
    INVALID_COUNTRY_CODE,
    NOT_A_NUMBER,
    TOO_SHORT_AFTER_IDD,
    TOO_SHORT_NSN,
    TOO_LONG,
  }

    
}

