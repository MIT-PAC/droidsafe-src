package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.564 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "72500B6A23D3A49D7E5A870B3B471148")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.565 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "D7A3DA9EE9E90E7340647D16C03260DD")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706597110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706597110;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.577 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "9AD53422CB7566065591740112E7A6B1")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        long var8C8D63ACDBC3A6604609CB688A50835B_589380583 = (read(targets, 0, targets.length));
        addTaint(targets[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1943198254 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1943198254;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.585 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "3E18E44232411DB9C354B73246EEF56F")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        long var284611C5A2FA51DEC3760F3DD09B2EC8_1606228303 = (write(sources, 0, sources.length));
        addTaint(sources[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_434208696 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_434208696;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

