package javax.net.ssl;

// Droidsafe Imports
import java.util.EventListener;

public interface HandshakeCompletedListener extends EventListener {
    
    void handshakeCompleted(HandshakeCompletedEvent event);
}
