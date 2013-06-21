package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.SelectorProviderImpl;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ServiceLoader;

public abstract class SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.170 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "6B40AAE650197172BEF43AA1CD6DE226")
    @DSModeled(DSC.SAFE)
    protected SelectorProvider() {
        // ---------- Original Method ----------
    }

    
        synchronized public static SelectorProvider provider() {
        if (provider == null) {
            provider = ServiceLoader.loadFromSystemProperty(SelectorProvider.class);
            if (provider == null) {
                provider = loadProviderByJar();
            }
            if (provider == null) {
                provider = new SelectorProviderImpl();
            }
        }
        return provider;
    }

    
        private static SelectorProvider loadProviderByJar() {
        for (SelectorProvider provider : ServiceLoader.load(SelectorProvider.class)) {
            return provider;
        }
        return null;
    }

    
    public abstract DatagramChannel openDatagramChannel() throws IOException;

    
    public abstract Pipe openPipe() throws IOException;

    
    public abstract AbstractSelector openSelector() throws IOException;

    
    public abstract ServerSocketChannel openServerSocketChannel()
            throws IOException;

    
    public abstract SocketChannel openSocketChannel() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.170 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "A84E323188B8F689844E807FBA408318")
    @DSModeled(DSC.SAFE)
    public Channel inheritedChannel() throws IOException {
        return (Channel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    private static SelectorProvider provider = null;
}

