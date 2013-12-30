package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class DelegatedTask implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.003 -0500", hash_original_field = "2FAEBA4E6DD79DB48FD81B0F04E000FA", hash_generated_field = "1E40A8F04D6C87AD06430CB770B50920")


    private  HandshakeProtocol handshaker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.006 -0500", hash_original_field = "6E604B84976ABCF0C30A63D2F996D309", hash_generated_field = "95D8B8F79B2D276990C93DE7E8E59CF0")

    private  Runnable action;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.008 -0500", hash_original_method = "E66EF7E710B4ECD724343E3A45657AE3", hash_generated_method = "DAD7BC05C721AF9B9941C1CD1ED4078B")
    
public DelegatedTask(Runnable action, HandshakeProtocol handshaker) {
        this.action = action;
        this.handshaker = handshaker;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:15.011 -0500", hash_original_method = "BC92620C95DC261FCD2ED821B8965098", hash_generated_method = "DDB79F5778145D07CB17CA4544EE8544")
    
public void run() {
        synchronized (handshaker) {
            try {
                action.run();
            } catch (RuntimeException e) {
                // pass exception to HandshakeProtocol
                handshaker.delegatedTaskErr = e;
            }
        }
    }

    
}

