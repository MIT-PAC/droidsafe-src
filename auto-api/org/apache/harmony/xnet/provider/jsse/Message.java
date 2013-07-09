package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.215 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "01D45192EF478C4B8895FC65CF51D2EB")

    protected int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.215 -0400", hash_original_method = "1320821CB7E319AA2006FCB6CC079C6F", hash_generated_method = "1320821CB7E319AA2006FCB6CC079C6F")
    public Message ()
    {
        
    }


    abstract int getType();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.216 -0400", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "EEB0169B93018D0D03C76BEEC22C289D")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691048901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691048901;
        
        
    }

    
    abstract void send(HandshakeIODataStream out);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.216 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "F69AC1801CF91CF5B116C4A126917FF1")
    protected void fatalAlert(byte description, String reason) {
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLHandshakeException(reason));
        addTaint(description);
        addTaint(reason.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.217 -0400", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "6112B4EC8EC36FA27C150FC387BC3E7F")
    protected void fatalAlert(byte description, String reason, Throwable cause) {
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLException(reason, cause));
        addTaint(description);
        addTaint(reason.getTaint());
        addTaint(cause.getTaint());
        
        
    }

    
}

