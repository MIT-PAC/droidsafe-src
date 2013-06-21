package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class KeyManagementException extends KeyException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.331 -0400", hash_original_method = "C1C9437036F95280A4529C1CBB03A96B", hash_generated_method = "A7ED5D3CA4A97EA094E146AA1A3F948A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyManagementException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.331 -0400", hash_original_method = "DE152C48BD78964F95EBFDDBEC69C54C", hash_generated_method = "B8734ACC6C474635792EA54D4600570D")
    @DSModeled(DSC.SAFE)
    public KeyManagementException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.331 -0400", hash_original_method = "81AAB74590EA3C5396EE9D20F7BBE3DD", hash_generated_method = "F89E5436FD9459632F1D2EF34AF66574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyManagementException(String message, Throwable cause) {
        super(message, cause);
        dsTaint.addTaint(message);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.331 -0400", hash_original_method = "E6EDC076BA6A403E961006D69F90ADCE", hash_generated_method = "6E4B8F01F9DC7C2CB24028835B26EEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public KeyManagementException(Throwable cause) {
        super(cause);
        dsTaint.addTaint(cause.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 947674216157062695L;
}

