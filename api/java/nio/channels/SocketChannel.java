package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.671 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "72500B6A23D3A49D7E5A870B3B471148")
    protected  SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.672 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "C43D24D01498816053A9839341974F9D")
    @Override
    public final int validOps() {
        int varC233D815DCF051CC3EC450F60F56810D_844506269 = ((SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634465465 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634465465;
        // ---------- Original Method ----------
        //return (SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
    }

    
    public abstract Socket socket();

    
    public abstract boolean isConnected();

    
    public abstract boolean isConnectionPending();

    
    public abstract boolean connect(SocketAddress address) throws IOException;

    
    public abstract boolean finishConnect() throws IOException;

    
    public abstract int read(ByteBuffer target) throws IOException;

    
    public abstract long read(ByteBuffer[] targets, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.673 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "BDC34B782A963E41EB5B8878AF361E8D")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        addTaint(targets[0].getTaint());
        long varFE1CA8A4AFFB15DED53509F1AD9D6EED_124750863 = (read(targets, 0, targets.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1572331434 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1572331434;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.674 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "CB17081AA830B66F4DF3BE1BDCD8F4A4")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        addTaint(sources[0].getTaint());
        long varE628A2D924D52EAEBDED640B5A4AC008_1634085901 = (write(sources, 0, sources.length));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_779927209 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_779927209;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

