package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.EventListener;

public interface HandshakeCompletedListener extends EventListener {
    
    void handshakeCompleted(HandshakeCompletedEvent event);
}

