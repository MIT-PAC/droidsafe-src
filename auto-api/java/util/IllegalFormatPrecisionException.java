package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalFormatPrecisionException extends IllegalFormatException {
    private int p;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.490 -0400", hash_original_method = "1F9B0D4B155F0DC19F08720A34E7C4BD", hash_generated_method = "BF864990319862B1FB79EACABFBF4C7E")
    @DSModeled(DSC.SAFE)
    public IllegalFormatPrecisionException(int p) {
        dsTaint.addTaint(p);
        // ---------- Original Method ----------
        //this.p = p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.491 -0400", hash_original_method = "B9EA1DC143DCBA676654F6DE1FED4BDB", hash_generated_method = "3EED1FCCC0AEF5A9988299C5E2F5DA38")
    @DSModeled(DSC.SAFE)
    public int getPrecision() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.491 -0400", hash_original_method = "5619344DED486463EA63A3A2966EBEEE", hash_generated_method = "D85F82B772297243E4D114C59210ABC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String var60805E6F9F1DAC8CD63E64E74DA4132E_1504882927 = (Integer.toString(p));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(p);
    }

    
    private static final long serialVersionUID = 18711008L;
}

