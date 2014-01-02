package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class SocketUtils {
    /**
     * Helps us reuse more of Socket's implementation in SocketChannelImpl.SocketAdapter.
     * It's not the case that we should set isCreated in the Socket(SocketImpl) constructor;
     * SocketImpl.create should be called in general. But for SocketChannelImpl.SocketAdapter's
     * SocketImpl, we don't want that behavior.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.400 -0500", hash_original_method = "6291BBF5425F669DCF6FA0E928DB5384", hash_generated_method = "2F92712C5B676FDC90324D2DE5695EB9")
    
public static void setCreated(Socket s) {
        s.isCreated = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:09.403 -0500", hash_original_method = "2758868180F6D2D4DEA6AC671B8BE637", hash_generated_method = "37866109A1871B6BE95B52B45BF3CCF0")
    
private SocketUtils() { }

    
}

