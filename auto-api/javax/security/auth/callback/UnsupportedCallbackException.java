package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedCallbackException extends Exception {
    private Callback callback;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.131 -0400", hash_original_method = "6F64A91CCA6DECE8990E118F6F2706F6", hash_generated_method = "61721116DA1FDBAD103E05651691A967")
    @DSModeled(DSC.SAFE)
    public UnsupportedCallbackException(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
        //this.callback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.131 -0400", hash_original_method = "E54A6FA33A5BFCD773DCE92A09F71FE9", hash_generated_method = "8BDAB4C856494C4EEE1B0911DC4688AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedCallbackException(Callback callback, String message) {
        super(message);
        dsTaint.addTaint(message);
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
        //this.callback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.131 -0400", hash_original_method = "C52CB6D8F1111BAF8BAA5D6F66319767", hash_generated_method = "05E35815D351BFF934D4352F2B5817B0")
    @DSModeled(DSC.SAFE)
    public Callback getCallback() {
        return (Callback)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callback;
    }

    
    private static final long serialVersionUID = -6873556327655666839L;
}

