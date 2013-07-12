package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class NullPointerException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.035 -0400", hash_original_method = "4CD1558B74CC9F94FAFFAA64104ABAFD", hash_generated_method = "019AF9545A44CED52FDE464DC17E038C")
    public  NullPointerException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.035 -0400", hash_original_method = "35797291F30B5B7A43FB2D60560B242A", hash_generated_method = "6D5845D5637806BD482E311D922504C1")
    public  NullPointerException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.035 -0400", hash_original_field = "9EF4E0FFE711FEAB3C2192BCC9C27C9A", hash_generated_field = "059D1248FC34ADECE2A43C5EBD68DEF3")

    private static final long serialVersionUID = 5162710183389028792L;
}

