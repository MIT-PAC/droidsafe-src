package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;





public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.301 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "72500B6A23D3A49D7E5A870B3B471148")
    protected  SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    
    public static SocketChannel open(SocketAddress address) throws IOException {
        SocketChannel socketChannel = open();
        if (socketChannel != null) {
            socketChannel.connect(address);
        }
        return socketChannel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.302 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "F254124F9CF8B51160723AB6D501F5C2")
    @Override
    public final int validOps() {
        int varC233D815DCF051CC3EC450F60F56810D_787272231 = ((SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767655025 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767655025;
        // ---------- Original Method ----------
        //return (SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    
    @DSModeled(DSC.SPEC)
    public abstract Socket socket();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isConnected();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isConnectionPending();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean connect(SocketAddress address) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract boolean finishConnect() throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract int read(ByteBuffer target) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long read(ByteBuffer[] targets, int offset, int length) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.304 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "FA571D76EF10D84A036656E39282387D")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        addTaint(targets[0].getTaint());
        long varFE1CA8A4AFFB15DED53509F1AD9D6EED_2052012801 = (read(targets, 0, targets.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1405764240 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1405764240;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int write(ByteBuffer source) throws IOException;

    
    @DSModeled(DSC.SAFE)
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.305 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "A54505EB08E3F6E7A232E911B40483C2")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        addTaint(sources[0].getTaint());
        long varE628A2D924D52EAEBDED640B5A4AC008_1895224669 = (write(sources, 0, sources.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2052471718 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2052471718;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

