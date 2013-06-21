package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AbstractMethodError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.362 -0400", hash_original_method = "4F4F671C3B04BA3CBFE40382F9999EB7", hash_generated_method = "3CD8DA6655C9083356BB3F4CDAD51E26")
    @DSModeled(DSC.SAFE)
    public AbstractMethodError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.363 -0400", hash_original_method = "08FCF39731DB3AF551E2B6A840F345BE", hash_generated_method = "03B523625AC06D0DD432BA8D800DCA16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbstractMethodError(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -1654391082989018462L;
}

