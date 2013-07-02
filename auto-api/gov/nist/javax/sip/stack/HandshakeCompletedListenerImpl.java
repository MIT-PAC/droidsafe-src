package gov.nist.javax.sip.stack;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public class HandshakeCompletedListenerImpl implements HandshakeCompletedListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.285 -0400", hash_original_field = "9D14D51171F742A3A889E582850559E1", hash_generated_field = "E40E492024A2FBE4470ECB2AA6F30298")

    private HandshakeCompletedEvent handshakeCompletedEvent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.285 -0400", hash_original_field = "6CF4F551C12C7FBF9D73FA862252BD04", hash_generated_field = "30F6A96C5CF9C12617833012C8319655")

    private TLSMessageChannel tlsMessageChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.285 -0400", hash_original_method = "B5E680A19EE8E4EFEF04423A96C79BDB", hash_generated_method = "9BC0DD7FA2706743A5F3BBCFA4894CC5")
    public  HandshakeCompletedListenerImpl(TLSMessageChannel tlsMessageChannel) {
        this.tlsMessageChannel = tlsMessageChannel;
        tlsMessageChannel.setHandshakeCompletedListener(this);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.285 -0400", hash_original_method = "059B216A56A7176FB623C11ADC7DE4FF", hash_generated_method = "05C4BFDC91F20AC9D0D05E91F4982E29")
    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        this.handshakeCompletedEvent = handshakeCompletedEvent;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:44.286 -0400", hash_original_method = "E86D2808B5F943F6445EA098BE441F96", hash_generated_method = "EE2C2D7CA37612E47F0D194704D2F659")
    public HandshakeCompletedEvent getHandshakeCompletedEvent() {
        HandshakeCompletedEvent varB4EAC82CA7396A68D541C85D26508E83_1715675503 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1715675503 = handshakeCompletedEvent;
        varB4EAC82CA7396A68D541C85D26508E83_1715675503.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1715675503;
        
        
    }

    
}

