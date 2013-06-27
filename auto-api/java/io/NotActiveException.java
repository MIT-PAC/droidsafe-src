package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NotActiveException extends ObjectStreamException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.049 -0400", hash_original_method = "04F1D3389F0C6F41AEA2935866CA7222", hash_generated_method = "071F1807AA26DA7AB825233FA3566BF3")
    public  NotActiveException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.049 -0400", hash_original_method = "3214341FEC67E095A6821294CDC33C6B", hash_generated_method = "EA8F8CC401F1A58B43354791D5B4D78C")
    public  NotActiveException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.049 -0400", hash_original_field = "4B8ABC053A2DCE4C236BA4F246F73C53", hash_generated_field = "B26F14872CB2904EC55CDB13CCC544C0")

    private static long serialVersionUID = -3893467273049808895L;
}

