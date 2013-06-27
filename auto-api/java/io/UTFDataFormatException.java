package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UTFDataFormatException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.853 -0400", hash_original_method = "3EA36195962A4C2ABB96F147659089B7", hash_generated_method = "4F6021DB90D836B7A73C5500EB8CC7F8")
    public  UTFDataFormatException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.854 -0400", hash_original_method = "40942835B5B465ACA9ABF07953FCB6E7", hash_generated_method = "DFA1AC2962F25C34FA5A75D7695FCB96")
    public  UTFDataFormatException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.854 -0400", hash_original_field = "7549551782EB7E295360068A79C0473D", hash_generated_field = "5F4EDC6A853AB2990957D10B2C9F5403")

    private static long serialVersionUID = 420743449228280612L;
}

