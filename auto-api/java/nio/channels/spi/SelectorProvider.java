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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.791 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "6B40AAE650197172BEF43AA1CD6DE226")
    protected  SelectorProvider() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.793 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "00D13A3C73A218764F32611EC95B34E2")
    public Channel inheritedChannel() throws IOException {
        Channel varB4EAC82CA7396A68D541C85D26508E83_884937654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_884937654 = null;
        varB4EAC82CA7396A68D541C85D26508E83_884937654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_884937654;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.812 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "D035C1A1A75D6145DD94D05B3D58FE60")

    private static SelectorProvider provider = null;
}

