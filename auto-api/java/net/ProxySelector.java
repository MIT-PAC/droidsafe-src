package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.List;

public abstract class ProxySelector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.667 -0400", hash_original_method = "58B949A565A2A9912CEB4CE07BFCA43A", hash_generated_method = "58B949A565A2A9912CEB4CE07BFCA43A")
    public ProxySelector ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    public static ProxySelector getDefault() {
        return defaultSelector;
    }

    
    @DSModeled(DSC.SAFE)
    public static void setDefault(ProxySelector selector) {
        defaultSelector = selector;
    }

    
    public abstract List<Proxy> select(URI uri);

    
    public abstract void connectFailed(URI uri, SocketAddress address, IOException failure);

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.668 -0400", hash_original_field = "F5B52DAA0891C49BF2BCE7F900ABD0A2", hash_generated_field = "866168BC4273598BE9EC3863505911FF")

    private static ProxySelector defaultSelector = new ProxySelectorImpl();
}

