package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class SocketException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.129 -0400", hash_original_method = "6370438F3E8FDAC390DBF5D95BB547E6", hash_generated_method = "16218E158583D4A8A5981F4E73EFCDEB")
    @DSModeled(DSC.SAFE)
    public SocketException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.129 -0400", hash_original_method = "1136B1CF147D460660A0A79DDF1D5C0A", hash_generated_method = "1E8D10D33D45A9F7982B12A0B1BA5CB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.129 -0400", hash_original_method = "001E874571014D08FBFC41C7A23D02C6", hash_generated_method = "F8BEC9171D2D9791A274FCBA0C74CE9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.129 -0400", hash_original_method = "1ACC59770DF5E02FD5C6C8AE56F288AE", hash_generated_method = "C67BC89E9CCBFA91CB03AE0D97EF82A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5935874303556886934L;
}

