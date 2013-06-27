package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinkageError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.718 -0400", hash_original_method = "F8257C8B139D012B1AF21CEDF65AEAF0", hash_generated_method = "C273B76F8CF21036701B1DB2BBEFB185")
    public  LinkageError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.719 -0400", hash_original_method = "3F282F39CCEC2A75C9FAEF6579E7409E", hash_generated_method = "451B57946184CB0B2C43D0AE436AF13D")
    public  LinkageError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.720 -0400", hash_original_method = "EA091AF8CE4C0C3DC980640F02BF597B", hash_generated_method = "19F6555DFACDEFEDD91EF9E2EE3213E3")
    public  LinkageError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.720 -0400", hash_original_field = "904FD13B2340D6F83891D103DDD3F915", hash_generated_field = "04FFBB27B98C2D88B97E4FC3B0FAAEDC")

    private static long serialVersionUID = 3579600108157160122L;
}

