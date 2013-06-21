package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.EventListener;

public interface HandshakeCompletedListener extends EventListener {
    
    void handshakeCompleted(HandshakeCompletedEvent event);
}
