package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class DatagramChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.606 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "3892A14533B0657644D04485F31DC036")
    protected  DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.607 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "576AB1CF8F70609249FBCDC14A5C53D8")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104970407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2104970407;
        
        
    }

    
    public abstract DatagramSocket socket();

    
    public abstract boolean isConnected();

    
    public abstract DatagramChannel connect(SocketAddress address)
            throws IOException;

    
    public abstract DatagramChannel disconnect() throws IOException;

    
    public abstract SocketAddress receive(ByteBuffer target) throws IOException;

    
    public abstract int send(ByteBuffer source, SocketAddress address) throws IOException;

    
    public abstract int read(ByteBuffer target) throws IOException;

    
    public abstract long read(ByteBuffer[] targets, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.611 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "142E26BCF0FE30FF037FC48C3847A442")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        long var8C8D63ACDBC3A6604609CB688A50835B_1351677365 = (read(targets, 0, targets.length));
        addTaint(targets[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1018913433 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1018913433;
        
        
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.612 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "15CEAF7B5334C28FB700E213619A1C02")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        long var284611C5A2FA51DEC3760F3DD09B2EC8_1344582716 = (write(sources, 0, sources.length));
        addTaint(sources[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1725071697 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1725071697;
        
        
    }

    
}

