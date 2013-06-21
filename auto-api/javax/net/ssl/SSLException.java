package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class SSLException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.085 -0400", hash_original_method = "767432C29D53FDFEE031F1BE821865F4", hash_generated_method = "D1B8D8D4A1C5BC847F9AAE5F17E600CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.085 -0400", hash_original_method = "5FF36E085E786A28DDEEC1EBE169EDD3", hash_generated_method = "62F745A2E109BA91FB9779F2BC6CA9C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(String message, Throwable cause) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.085 -0400", hash_original_method = "1E7679A49A32A86556807238CABB4D3B", hash_generated_method = "357612B4C6CFB2FD6F7FC1B91C99A572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLException(Throwable cause) {
        super(cause == null ? null : cause.toString());
        dsTaint.addTaint(cause.dsTaint);
        super.initCause(cause);
        // ---------- Original Method ----------
        //super.initCause(cause);
    }

    
    private static final long serialVersionUID = 4511006460650708967L;
}

