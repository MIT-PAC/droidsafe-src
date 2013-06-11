package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class IllegalMonitorStateException extends RuntimeException {
    private static final long serialVersionUID = 3713306369498869069L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.061 -0400", hash_original_method = "A830880207AC191B3684BF337F5E0247", hash_generated_method = "290FAEFB024A1E9FEE2A6DE9732CCB3D")
    @DSModeled(DSC.SAFE)
    public IllegalMonitorStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 16:38:46.072 -0400", hash_original_method = "1591087F36D115C0B3CDF3D9C0FC50C3", hash_generated_method = "0F61120E736AE5B6EAB7C9FBFA5FAC99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IllegalMonitorStateException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


