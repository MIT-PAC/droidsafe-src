package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WriteAbortedException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.884 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "C3243AD40E57E22F6ED814DD71D64096")

    public Exception detail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.885 -0400", hash_original_method = "DA6C07DB36CBC207B190B4B4ECB6B2B2", hash_generated_method = "9A68D2B382CDBEE907C2EEEBBB424150")
    public  WriteAbortedException(String detailMessage, Exception rootCause) {
        super(detailMessage);
        detail = rootCause;
        initCause(rootCause);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //detail = rootCause;
        //initCause(rootCause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.886 -0400", hash_original_method = "F8C8FA3813C752D5C72108208FEF04C6", hash_generated_method = "389CCD93091863E192A922AA8678E940")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1517540470 = null; //Variable for return #1
        String msg;
        msg = super.getMessage();
        {
            msg = msg + "; " + detail.toString();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1517540470 = msg;
        varB4EAC82CA7396A68D541C85D26508E83_1517540470.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1517540470;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (detail != null) {
            //msg = msg + "; " + detail.toString();
        //}
        //return msg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.886 -0400", hash_original_method = "CA6C7AF43E4792C258E5E6922F45606C", hash_generated_method = "C5FA5621D999AD4BBED5C00C427D5E6A")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_902134906 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_902134906 = detail;
        varB4EAC82CA7396A68D541C85D26508E83_902134906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_902134906;
        // ---------- Original Method ----------
        //return detail;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.886 -0400", hash_original_field = "D14F55C6FD23B1D97DB4AE900326A4F8", hash_generated_field = "12C03860A3640C00CB094064DDEE44D5")

    private static long serialVersionUID = -3326426625597282442L;
}

