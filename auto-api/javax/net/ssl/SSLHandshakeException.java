package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SSLHandshakeException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.087 -0400", hash_original_method = "82B36E212F934FE090A9654C18E5A390", hash_generated_method = "00CC919DB07B5DC59B13124220FB0ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.087 -0400", hash_original_method = "6E4EDFE9C902AE43BD6AF73325E7CB73", hash_generated_method = "3A5448F5BF313D0FDFA21716816D45F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.088 -0400", hash_original_method = "7F0A583E3C5916ED2C2C7E0A6DE82F31", hash_generated_method = "83492E90D0C08535B4C3274087D0999D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLHandshakeException(String reason, Throwable cause) {
        super(reason, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5045881315018326890L;
}

