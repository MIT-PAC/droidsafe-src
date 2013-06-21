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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.140 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "6917D0D587E68B606BD76C76BEEFEF3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.140 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "6B3AD862F2DD1788A3A22986E04E18A6")
    @DSModeled(DSC.SAFE)
    @Override
    public final int validOps() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.141 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "605F0068DEE56408FF0918F16E8729EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        dsTaint.addTaint(targets[0].dsTaint);
        long var8C8D63ACDBC3A6604609CB688A50835B_1789389466 = (read(targets, 0, targets.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.141 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "7639951C5BF5D30AB5D2283229B258F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        dsTaint.addTaint(sources[0].dsTaint);
        long var284611C5A2FA51DEC3760F3DD09B2EC8_1736420650 = (write(sources, 0, sources.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

