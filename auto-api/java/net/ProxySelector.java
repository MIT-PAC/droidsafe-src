package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.util.List;

public abstract class ProxySelector {
    private static ProxySelector defaultSelector = new ProxySelectorImpl();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.266 -0400", hash_original_method = "DD013215750A3DC82326FF22860EEE8C", hash_generated_method = "50A3CC6494504D4CDCD2267DC2EDDE2D")
    public static ProxySelector getDefault() {
        return defaultSelector;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.266 -0400", hash_original_method = "9E2A7A4187C6254829966FED558C3B1B", hash_generated_method = "2B52B75A0FECC5D70B4F89BB9193DC5D")
    public static void setDefault(ProxySelector selector) {
        defaultSelector = selector;
    }

    
    public abstract List<Proxy> select(URI uri);

    
    public abstract void connectFailed(URI uri, SocketAddress address, IOException failure);

    
}


