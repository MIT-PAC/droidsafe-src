package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.718 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "72500B6A23D3A49D7E5A870B3B471148")
    protected  SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    
    @DSModeled(DSC.SAFE)
    public static SocketChannel open(SocketAddress address) throws IOException {
        SocketChannel socketChannel = open();
        if (socketChannel != null) {
            socketChannel.connect(address);
        }
        return socketChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.719 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "CC3E3090EF9016CC24DCC17D0AF7FFD6")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281133714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281133714;
        
        
    }

    
    public abstract Socket socket();

    
    public abstract boolean isConnected();

    
    public abstract boolean isConnectionPending();

    
    public abstract boolean connect(SocketAddress address) throws IOException;

    
    public abstract boolean finishConnect() throws IOException;

    
    public abstract int read(ByteBuffer target) throws IOException;

    
    public abstract long read(ByteBuffer[] targets, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.721 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "F7B15B835798E18066F55F2C0C6EA358")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        long var8C8D63ACDBC3A6604609CB688A50835B_1213549469 = (read(targets, 0, targets.length));
        addTaint(targets[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_764214798 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_764214798;
        
        
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.721 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "0B248F1162175BB81B30E63D8D55F035")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        long var284611C5A2FA51DEC3760F3DD09B2EC8_852503150 = (write(sources, 0, sources.length));
        addTaint(sources[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_599670023 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_599670023;
        
        
    }

    
}

