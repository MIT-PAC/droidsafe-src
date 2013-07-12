package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class NoSuchMethodException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.032 -0400", hash_original_method = "60C13DDE4E49448CC01A624FC168F601", hash_generated_method = "9D9F27795E3EA552118260D151BF3326")
    public  NoSuchMethodException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.033 -0400", hash_original_method = "C31CF201699BCB0031463CB0C33C59AC", hash_generated_method = "D7AA192B00E4C0EB38A1FE62026EF7EA")
    public  NoSuchMethodException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.033 -0400", hash_original_field = "7E8C4A74C82EE88A85260195E6C0FDFB", hash_generated_field = "57967287B1D470C55211CDC70D6E48BD")

    private static final long serialVersionUID = 5034388446362600923L;
}

