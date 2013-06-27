package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class DatagramChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.355 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "3892A14533B0657644D04485F31DC036")
    protected  DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
        public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.356 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "F4F849DD10384CC217F4BDDA8CFB2AEE")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942918056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_942918056;
        // ---------- Original Method ----------
        //return (SelectionKey.OP_READ | SelectionKey.OP_WRITE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.418 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "CC36DA8781EBE076641DE59EAA21B9D6")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        long var8C8D63ACDBC3A6604609CB688A50835B_1158175302 = (read(targets, 0, targets.length));
        addTaint(targets[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1109748291 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1109748291;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.419 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "ED36FAF6D9FBDF59E4FC9FD4D89C6191")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        long var284611C5A2FA51DEC3760F3DD09B2EC8_1134747112 = (write(sources, 0, sources.length));
        addTaint(sources[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1655230987 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1655230987;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

