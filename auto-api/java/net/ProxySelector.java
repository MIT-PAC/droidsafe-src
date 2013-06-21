package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.List;

public abstract class ProxySelector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.063 -0400", hash_original_method = "2CED11BFE6F6D473E3BFDBD8BCA0C1F0", hash_generated_method = "2CED11BFE6F6D473E3BFDBD8BCA0C1F0")
        public ProxySelector ()
    {
    }


        public static ProxySelector getDefault() {
        return defaultSelector;
    }

    
        public static void setDefault(ProxySelector selector) {
        defaultSelector = selector;
    }

    
    public abstract List<Proxy> select(URI uri);

    
    public abstract void connectFailed(URI uri, SocketAddress address, IOException failure);

    
    private static ProxySelector defaultSelector = new ProxySelectorImpl();
}

