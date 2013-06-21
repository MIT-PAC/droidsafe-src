package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DelegatedTask implements Runnable {
    private HandshakeProtocol handshaker;
    private Runnable action;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.737 -0400", hash_original_method = "E66EF7E710B4ECD724343E3A45657AE3", hash_generated_method = "B843F4E1FCF19ADCBC7319D58C7A5F9B")
    @DSModeled(DSC.SAFE)
    public DelegatedTask(Runnable action, HandshakeProtocol handshaker) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(handshaker.dsTaint);
        // ---------- Original Method ----------
        //this.action = action;
        //this.handshaker = handshaker;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.737 -0400", hash_original_method = "BC92620C95DC261FCD2ED821B8965098", hash_generated_method = "187D0088FB192CF2321E7E72C7476352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        {
            try 
            {
                action.run();
            } //End block
            catch (RuntimeException e)
            {
                handshaker.delegatedTaskErr = e;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (handshaker) {
            //try {
                //action.run();
            //} catch (RuntimeException e) {
                //handshaker.delegatedTaskErr = e;
            //}
        //}
    }

    
}

