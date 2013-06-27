package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CharConversionException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.627 -0400", hash_original_method = "DC569460E6B613C2EB5E9DBFD397A52F", hash_generated_method = "9D02A3AF17326460C375C01A7E899BB2")
    public  CharConversionException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.627 -0400", hash_original_method = "FDBB99B99B9CAB30BA127F908E7A50CF", hash_generated_method = "754392A6268252EBA331B5B982ECEF8A")
    public  CharConversionException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.627 -0400", hash_original_field = "8426614A2AF0B4D3FD282DF8C353B803", hash_generated_field = "6152C83E8BB75AE45466B43D57F28767")

    private static long serialVersionUID = -8680016352018427031L;
}

