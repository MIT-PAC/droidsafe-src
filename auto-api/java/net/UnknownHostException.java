package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class UnknownHostException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.694 -0400", hash_original_method = "63F4AB968FFD132B70B6AA5D00C05B79", hash_generated_method = "F64B44015C6B2F668B99417C6CF8EE19")
    public  UnknownHostException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.694 -0400", hash_original_method = "F0919D76ED897260C338F2959B098923", hash_generated_method = "9045703C089BF97EAAEEC7A5A1D5FCBC")
    public  UnknownHostException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.694 -0400", hash_original_field = "2B5B3E47B8A4F7ABB71E682F68692BC4", hash_generated_field = "C9894511FF752A165D86CA0A99A0D0D2")

    private static long serialVersionUID = -4639126076052875403L;
}

