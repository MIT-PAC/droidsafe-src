package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SocketChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "2E5B32673A9DF9A621D8F99910F278C2", hash_generated_method = "E337C9A4186960986EB8227E0B6F81CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "1C22500DDD1A1C4CBFF296D433984138", hash_generated_method = "BD5E389F8FE3DF580E59B07FBB199E75")
    public static SocketChannel open() throws IOException {
        return SelectorProvider.provider().openSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "AC2B95C5BDC217F19851C0632D37B5EC", hash_generated_method = "034337553752947731A0C6353DC0D7E3")
    public static SocketChannel open(SocketAddress address) throws IOException {
        SocketChannel socketChannel = open();
        if (socketChannel != null) {
            socketChannel.connect(address);
        }
        return socketChannel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "329D33F04038C44D432D32526ECC7D14", hash_generated_method = "8B1541AC0DAE6840E11F4F9197367014")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "D34AC785CCEA34C11BC8284F4DF99329")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        dsTaint.addTaint(targets.dsTaint);
        long var8C8D63ACDBC3A6604609CB688A50835B_1302915166 = (read(targets, 0, targets.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.492 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "E1C13202636ABF79AF5C14DD54859077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        dsTaint.addTaint(sources.dsTaint);
        long var284611C5A2FA51DEC3760F3DD09B2EC8_525841280 = (write(sources, 0, sources.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}


