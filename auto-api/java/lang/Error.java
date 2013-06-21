package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Error extends Throwable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.695 -0400", hash_original_method = "7D5BF5C7538ED3BFC2F69913B33169E2", hash_generated_method = "E209531049EACBDCA8E9D86003B7419F")
    @DSModeled(DSC.SAFE)
    public Error() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.695 -0400", hash_original_method = "C6CAA4A4AF257044103CFF33D3E9FE9A", hash_generated_method = "DE01890F1FF85B2BCF2D73B386D7C359")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Error(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.695 -0400", hash_original_method = "66AA244741442CFF9E9D4A286C858491", hash_generated_method = "03E4DB6205E4CB1991E4F981FF70D663")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Error(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        dsTaint.addTaint(throwable.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.695 -0400", hash_original_method = "4F891171DD00932FF603BE77BF813093", hash_generated_method = "4300A4FE0EFD14167746FA877E478EEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Error(Throwable throwable) {
        super(throwable);
        dsTaint.addTaint(throwable.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 4980196508277280342L;
}

