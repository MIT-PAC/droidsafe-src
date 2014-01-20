package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.List;

public abstract class ProxySelector {

    /**
     * Returns the default proxy selector, or null if none exists.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.082 -0500", hash_original_method = "DD013215750A3DC82326FF22860EEE8C", hash_generated_method = "50A3CC6494504D4CDCD2267DC2EDDE2D")
    
public static ProxySelector getDefault() {
        return defaultSelector;
    }

    /**
     * Sets the default proxy selector. If {@code selector} is null, the current
     * proxy selector will be removed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.085 -0500", hash_original_method = "9E2A7A4187C6254829966FED558C3B1B", hash_generated_method = "2B52B75A0FECC5D70B4F89BB9193DC5D")
    
public static void setDefault(ProxySelector selector) {
        defaultSelector = selector;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.079 -0500", hash_original_field = "677B9A7B45DE601136DFE19E6C8C0EA7", hash_generated_field = "866168BC4273598BE9EC3863505911FF")

    private static ProxySelector defaultSelector = new ProxySelectorImpl();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.322 -0400", hash_original_method = "58B949A565A2A9912CEB4CE07BFCA43A", hash_generated_method = "58B949A565A2A9912CEB4CE07BFCA43A")
    public ProxySelector ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the proxy servers to use on connections to {@code uri}. This list
     * will contain {@link Proxy#NO_PROXY} if no proxy server should be used.
     *
     * @throws IllegalArgumentException if {@code uri} is null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.087 -0500", hash_original_method = "FA2D521FEDCC1B346048CD5647CCB42B", hash_generated_method = "A3763E781BA6591B2332D1594D11606C")
    
public abstract List<Proxy> select(URI uri);

    /**
     * Notifies this {@code ProxySelector} that a connection to the proxy server
     * could not be established.
     *
     * @param uri the URI to which the connection could not be established.
     * @param address the address of the proxy.
     * @param failure the exception which was thrown during connection
     *     establishment.
     * @throws IllegalArgumentException if any argument is null.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.090 -0500", hash_original_method = "E5282D5997A6E32A5F667AD5BD72780C", hash_generated_method = "CA2A4B1CC0FFE3CB020A82D3AABDA514")
    
public abstract void connectFailed(URI uri, SocketAddress address, IOException failure);
}

