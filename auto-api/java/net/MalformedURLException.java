package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public class MalformedURLException extends IOException {
    private static final long serialVersionUID = -182787522200415866L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.243 -0400", hash_original_method = "6F3415F478603350217F65D672585814", hash_generated_method = "3F2429CC9EE91783B3996725E967F091")
    @DSModeled(DSC.SAFE)
    public MalformedURLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.243 -0400", hash_original_method = "1BAAD892782075B201BE55BD9DAC535A", hash_generated_method = "B0A6A6894A9FDABAEDE50A453597E845")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MalformedURLException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.243 -0400", hash_original_method = "ACF50FF54717652ACCF5120218FC2A60", hash_generated_method = "E9D2F8595249F5F50E86FBC7DC5F2D18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MalformedURLException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


