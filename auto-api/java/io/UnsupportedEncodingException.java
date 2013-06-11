package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class UnsupportedEncodingException extends IOException {
    private static final long serialVersionUID = -4274276298326136670L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "120B741722292072F71D190D9178D3DA", hash_generated_method = "CA24F3010F072E2AAF64827511F3BC00")
    @DSModeled(DSC.SAFE)
    public UnsupportedEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.711 -0400", hash_original_method = "94DA8264158047F6F5B3A7DFC24D11B0", hash_generated_method = "9BEC7B134A9856B6006D6BF2E827668D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedEncodingException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


