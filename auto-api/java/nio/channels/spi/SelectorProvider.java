package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static SelectorProvider provider = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.500 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "B70CB10928E6A3B783DA276771600B42")
    @DSModeled(DSC.SAFE)
    protected SelectorProvider() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.500 -0400", hash_original_method = "CDAD760489E4CBA08CB762B57FD82B13", hash_generated_method = "9787BC8AEE542E1179EA15A898C61B68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.500 -0400", hash_original_method = "C5D0C714A3BF8C6915C7636E13EEA7C7", hash_generated_method = "A60E27474069C0C3802B81F66A315C06")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.501 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "36CB58AB66E625DFB3F61B6B60109C3A")
    @DSModeled(DSC.SAFE)
    public Channel inheritedChannel() throws IOException {
        return (Channel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
}


