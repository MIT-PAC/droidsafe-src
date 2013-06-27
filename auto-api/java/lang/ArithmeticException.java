package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ArithmeticException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.918 -0400", hash_original_method = "24115F2AC5B4BFA51305F479377E801A", hash_generated_method = "C79B2E7C2BBB39468FF7E68D70189892")
    public  ArithmeticException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.919 -0400", hash_original_method = "FAC340A34D2F62BBB9E823C2AE5CBB24", hash_generated_method = "ECEB91A71265109801A18B2FD1482B61")
    public  ArithmeticException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.919 -0400", hash_original_field = "CA1E2486B41FA87215902A3A05BD3EC4", hash_generated_field = "DD8BE6A8B3A61F3FBCAB5EF32CC4012C")

    private static long serialVersionUID = 2256477558314496007L;
}

