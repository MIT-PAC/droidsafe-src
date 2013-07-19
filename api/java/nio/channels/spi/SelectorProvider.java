package java.nio.channels.spi;

// Droidsafe Imports
import java.io.IOException;
import java.nio.SelectorProviderImpl;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ServiceLoader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.374 -0400", hash_original_method = "DDE564F0B2C96394E14746CA546F5611", hash_generated_method = "6B40AAE650197172BEF43AA1CD6DE226")
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

    
    @DSModeled(DSC.SAFE)
    public abstract DatagramChannel openDatagramChannel() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract Pipe openPipe() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract AbstractSelector openSelector() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract ServerSocketChannel openServerSocketChannel()
            throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract SocketChannel openSocketChannel() throws IOException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.375 -0400", hash_original_method = "1567929400994F6BBA42155A37789D93", hash_generated_method = "3A830C4E766EBB079B5DE563CF317113")
    public Channel inheritedChannel() throws IOException {
Channel var540C13E9E156B687226421B24F2DF178_781734417 =         null;
        var540C13E9E156B687226421B24F2DF178_781734417.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_781734417;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.376 -0400", hash_original_field = "A84D4D80E229BA36EE3D0C6D573ECAAF", hash_generated_field = "D035C1A1A75D6145DD94D05B3D58FE60")

    private static SelectorProvider provider = null;
}

