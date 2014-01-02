package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;






public class HandshakeCompletedListenerImpl implements HandshakeCompletedListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.907 -0500", hash_original_field = "EF7479D13A66C69E786B45EA1BA16848", hash_generated_field = "E40E492024A2FBE4470ECB2AA6F30298")


    private HandshakeCompletedEvent handshakeCompletedEvent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.910 -0500", hash_original_field = "20C6DD04E8CE85395BD0B686FACC66A7", hash_generated_field = "30F6A96C5CF9C12617833012C8319655")

    private TLSMessageChannel tlsMessageChannel;
    
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.913 -0500", hash_original_method = "B5E680A19EE8E4EFEF04423A96C79BDB", hash_generated_method = "C4A20A309489981120FA7402BA2207B1")
    
public HandshakeCompletedListenerImpl(TLSMessageChannel tlsMessageChannel) {
        this.tlsMessageChannel = tlsMessageChannel;
        tlsMessageChannel.setHandshakeCompletedListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.916 -0500", hash_original_method = "059B216A56A7176FB623C11ADC7DE4FF", hash_generated_method = "5DD779F2286329870115D8DBEB1221B4")
    
public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
       this.handshakeCompletedEvent = handshakeCompletedEvent;
       /*
       try {
           Thread.sleep(10);
       } catch (InterruptedException ex) {
           
       }*/
    }

    /**
     * @return the handshakeCompletedEvent
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:15.918 -0500", hash_original_method = "E86D2808B5F943F6445EA098BE441F96", hash_generated_method = "81195944F6C3DB2C5957AF90FCFCA10A")
    
public HandshakeCompletedEvent getHandshakeCompletedEvent() {
        return handshakeCompletedEvent;
    }

    
}

