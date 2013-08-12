package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;



public class DelegatedTask implements Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.439 -0400", hash_original_field = "06E10442A1A36DF6850A26E24CCFCDA0", hash_generated_field = "1E40A8F04D6C87AD06430CB770B50920")

    private HandshakeProtocol handshaker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.439 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "95D8B8F79B2D276990C93DE7E8E59CF0")

    private Runnable action;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.440 -0400", hash_original_method = "E66EF7E710B4ECD724343E3A45657AE3", hash_generated_method = "C6ABFC00EC20811487B396BC56BE59FB")
    public  DelegatedTask(Runnable action, HandshakeProtocol handshaker) {
        this.action = action;
        this.handshaker = handshaker;
        // ---------- Original Method ----------
        //this.action = action;
        //this.handshaker = handshaker;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.440 -0400", hash_original_method = "BC92620C95DC261FCD2ED821B8965098", hash_generated_method = "AD56B8ACB7D488EFD6FCC505AFCBECDD")
    public void run() {
        synchronized
(handshaker)        {
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

