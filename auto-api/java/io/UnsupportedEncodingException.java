package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedEncodingException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.352 -0400", hash_original_method = "120B741722292072F71D190D9178D3DA", hash_generated_method = "7FBF0CFE4EECE294CF78ED69B3643DFF")
    @DSModeled(DSC.SAFE)
    public UnsupportedEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.352 -0400", hash_original_method = "94DA8264158047F6F5B3A7DFC24D11B0", hash_generated_method = "8749C4B54B6D9D739CF653BD49E5BC5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedEncodingException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -4274276298326136670L;
}

