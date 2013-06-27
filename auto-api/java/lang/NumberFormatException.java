package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NumberFormatException extends IllegalArgumentException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.935 -0400", hash_original_method = "5EB9584C9C40374DC4817FFEDC3C2AF2", hash_generated_method = "CD0AD29B716E5461A290DCEA6E30AEFB")
    public  NumberFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.935 -0400", hash_original_method = "E8CAE1FBBA27FF2762363375A55E9E2D", hash_generated_method = "412D1BFE498F71BF71A0CE8E8E2BB12F")
    public  NumberFormatException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.935 -0400", hash_original_field = "467749A1C61D0A6A779AF4BAE05032B4", hash_generated_field = "4C154784DE37A6A125581C0487A1EE2A")

    private static long serialVersionUID = -2848938806368998894L;
}

