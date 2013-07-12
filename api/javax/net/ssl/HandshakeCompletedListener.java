package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventListener;

public interface HandshakeCompletedListener extends EventListener {
    
    void handshakeCompleted(HandshakeCompletedEvent event);
}
