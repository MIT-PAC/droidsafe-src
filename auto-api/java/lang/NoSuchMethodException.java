package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchMethodException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.899 -0400", hash_original_method = "60C13DDE4E49448CC01A624FC168F601", hash_generated_method = "9D9F27795E3EA552118260D151BF3326")
    public  NoSuchMethodException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.899 -0400", hash_original_method = "C31CF201699BCB0031463CB0C33C59AC", hash_generated_method = "D7AA192B00E4C0EB38A1FE62026EF7EA")
    public  NoSuchMethodException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.899 -0400", hash_original_field = "7E8C4A74C82EE88A85260195E6C0FDFB", hash_generated_field = "E27159486338D6B2FDB6A4F56FFA5A2C")

    private static long serialVersionUID = 5034388446362600923L;
}

