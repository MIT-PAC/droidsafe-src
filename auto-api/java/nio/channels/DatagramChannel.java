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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.483 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "3892A14533B0657644D04485F31DC036")
    protected  DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
        public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.484 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "581ABADFB062E764F9C901F87F5B8DFB")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475048411 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475048411;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.486 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "6410EA5C9E0FFBC42D6F0B16F29EBAA0")
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        long var8C8D63ACDBC3A6604609CB688A50835B_141737115 = (read(targets, 0, targets.length));
        addTaint(targets[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_993849143 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_993849143;
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.487 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "50B29533EA4A21F471D4F3751553707D")
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        long var284611C5A2FA51DEC3760F3DD09B2EC8_252400332 = (write(sources, 0, sources.length));
        addTaint(sources[0].getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1769003880 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1769003880;
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

