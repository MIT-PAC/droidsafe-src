package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class MalformedURLException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.935 -0400", hash_original_method = "6F3415F478603350217F65D672585814", hash_generated_method = "AD568FEDA3A16AFE9C14138F3CCC4B4D")
    @DSModeled(DSC.SAFE)
    public MalformedURLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.935 -0400", hash_original_method = "1BAAD892782075B201BE55BD9DAC535A", hash_generated_method = "C948EF04AD7A9330988080903C9CCB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MalformedURLException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.935 -0400", hash_original_method = "ACF50FF54717652ACCF5120218FC2A60", hash_generated_method = "BCF882A260F397DC808AB427B06ACED5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MalformedURLException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -182787522200415866L;
}

