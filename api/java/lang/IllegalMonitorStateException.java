package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IllegalMonitorStateException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.888 -0400", hash_original_method = "A830880207AC191B3684BF337F5E0247", hash_generated_method = "0C4EAA93E01B549DF2002FFF068D6996")
    public  IllegalMonitorStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.889 -0400", hash_original_method = "1591087F36D115C0B3CDF3D9C0FC50C3", hash_generated_method = "7E08F7F82383228A5914133957B6BAF2")
    public  IllegalMonitorStateException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.889 -0400", hash_original_field = "E4313FC7C4613B149FC3AFAE9C70AB60", hash_generated_field = "0BB0A250975987D9B0100EE2A72E1F4E")

    private static final long serialVersionUID = 3713306369498869069L;
}

