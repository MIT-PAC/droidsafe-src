package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.SelectorProviderImpl;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ServiceLoader;

public abstract class SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.717 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "6B40AAE650197172BEF43AA1CD6DE226")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.719 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "DA4A24394BAC57FF04668E824D97D3FB")
    public Channel inheritedChannel() throws IOException {
Channel var540C13E9E156B687226421B24F2DF178_2085358213 =         null;
        var540C13E9E156B687226421B24F2DF178_2085358213.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2085358213;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.719 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "D035C1A1A75D6145DD94D05B3D58FE60")

    private static SelectorProvider provider = null;
}

