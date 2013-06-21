package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

public abstract class Message {
    protected int length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.812 -0400", hash_original_method = "C388122C31305A6494A3C73AA60B75A9", hash_generated_method = "C388122C31305A6494A3C73AA60B75A9")
        public Message ()
    {
    }


    abstract int getType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.812 -0400", hash_original_method = "A95929A9D1E422E13DF7B6BE29D62093", hash_generated_method = "B3E727B4318B1ECB11F5A361940FF2BC")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return length;
    }

    
    abstract void send(HandshakeIODataStream out);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.812 -0400", hash_original_method = "5115C1B2C55B3895E035DFBE235241DE", hash_generated_method = "D1D265223143AABF2C0A5DC01905B6F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fatalAlert(byte description, String reason) {
        dsTaint.addTaint(reason);
        dsTaint.addTaint(description);
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLHandshakeException(reason));
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLHandshakeException(reason));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.812 -0400", hash_original_method = "8FFC926D3CD0D9B230B909F759D2E972", hash_generated_method = "7C8B8B0DB26C6E3E606EC9AD138C5602")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void fatalAlert(byte description, String reason, Throwable cause) {
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(reason);
        dsTaint.addTaint(description);
        if (DroidSafeAndroidRuntime.control) throw new AlertException(description, new SSLException(reason, cause));
        // ---------- Original Method ----------
        //throw new AlertException(description, new SSLException(reason, cause));
    }

    
}

