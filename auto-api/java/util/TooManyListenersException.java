package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TooManyListenersException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.135 -0400", hash_original_method = "394F16F71C461EE8325C7C30649B2ED3", hash_generated_method = "55BADF54015CFE6EC75248941CAF5B26")
    public  TooManyListenersException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.135 -0400", hash_original_method = "9AD8C053A7A66FB4440B6219D5D227F2", hash_generated_method = "76463DC7BB8F3BF752953D58366FC32A")
    public  TooManyListenersException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.135 -0400", hash_original_field = "F85946716EEA793823D372EB44A8FEA3", hash_generated_field = "4F20EE3DF814D25900DC625CAE59DEB4")

    private static long serialVersionUID = 5074640544770687831L;
}

