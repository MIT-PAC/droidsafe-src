package gov.nist.javax.sip.stack;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

public class HandshakeCompletedListenerImpl implements HandshakeCompletedListener {
    private HandshakeCompletedEvent handshakeCompletedEvent;
    private TLSMessageChannel tlsMessageChannel;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.816 -0400", hash_original_method = "B5E680A19EE8E4EFEF04423A96C79BDB", hash_generated_method = "751CA2719B736CBAD3A24486AABD3DA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HandshakeCompletedListenerImpl(TLSMessageChannel tlsMessageChannel) {
        dsTaint.addTaint(tlsMessageChannel.dsTaint);
        tlsMessageChannel.setHandshakeCompletedListener(this);
        // ---------- Original Method ----------
        //this.tlsMessageChannel = tlsMessageChannel;
        //tlsMessageChannel.setHandshakeCompletedListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.816 -0400", hash_original_method = "059B216A56A7176FB623C11ADC7DE4FF", hash_generated_method = "7D1F3CD19DF117FC80868AE12EC75C40")
    @DSModeled(DSC.SAFE)
    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        dsTaint.addTaint(handshakeCompletedEvent.dsTaint);
        // ---------- Original Method ----------
        //this.handshakeCompletedEvent = handshakeCompletedEvent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.816 -0400", hash_original_method = "E86D2808B5F943F6445EA098BE441F96", hash_generated_method = "27EEF5B59E82D7DA54B43FBBAED1E73B")
    @DSModeled(DSC.SAFE)
    public HandshakeCompletedEvent getHandshakeCompletedEvent() {
        return (HandshakeCompletedEvent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handshakeCompletedEvent;
    }

    
}

