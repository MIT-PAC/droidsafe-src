package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinkageError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.825 -0400", hash_original_method = "F8257C8B139D012B1AF21CEDF65AEAF0", hash_generated_method = "C273B76F8CF21036701B1DB2BBEFB185")
    @DSModeled(DSC.SAFE)
    public LinkageError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.825 -0400", hash_original_method = "3F282F39CCEC2A75C9FAEF6579E7409E", hash_generated_method = "F5A69EE87418BC9DF0054C08570BC383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkageError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.826 -0400", hash_original_method = "EA091AF8CE4C0C3DC980640F02BF597B", hash_generated_method = "9106F890CC0F1BEB884E8C48FCCEACF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkageError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3579600108157160122L;
}

