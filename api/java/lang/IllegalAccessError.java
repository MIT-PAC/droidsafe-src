package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalAccessError extends IncompatibleClassChangeError {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.874 -0400", hash_original_method = "AF78E0BEB545D91D9B237CD89EEDE6D8", hash_generated_method = "FF9C4607F2B6BD8F47118D2DD02021E5")
    public  IllegalAccessError() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.874 -0400", hash_original_method = "82FD6CF28C2427CE5A3234413711027B", hash_generated_method = "EF71EDF71CFD6E601E5B330591C39D44")
    public  IllegalAccessError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.875 -0400", hash_original_field = "2D02D93A8B990F8B2692A1C416DBAE7B", hash_generated_field = "7BC1F56550DFF30D84857A19A2ACAA0A")

    private static final long serialVersionUID = -8988904074992417891L;
}

