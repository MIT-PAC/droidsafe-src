package java.nio.channels.spi;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.797 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "6B40AAE650197172BEF43AA1CD6DE226")
    protected  SelectorProvider() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.799 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "22004705B61A8A3BCD9E82F94AD21AC5")
    public Channel inheritedChannel() throws IOException {
        Channel varB4EAC82CA7396A68D541C85D26508E83_2004112928 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2004112928 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2004112928.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2004112928;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.799 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "D035C1A1A75D6145DD94D05B3D58FE60")

    private static SelectorProvider provider = null;
}

