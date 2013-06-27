package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NegativeArraySizeException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.841 -0400", hash_original_method = "D33CED1C2CC51E1A27A91F713183A870", hash_generated_method = "AAB9A11ADDB53662AAA6D6FF71C8894C")
    public  NegativeArraySizeException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.841 -0400", hash_original_method = "8AAF2E9F34B5796377EDFC62134DFEB6", hash_generated_method = "4C405883FAC3ED31CDDEA2D11953EAE0")
    public  NegativeArraySizeException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.841 -0400", hash_original_field = "F60F45D6F3B06578BA8D5007B337988F", hash_generated_field = "E1B491B1B6A62535E1121A0F02769502")

    private static long serialVersionUID = -8960118058596991861L;
}

