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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.103 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "F1D83FF8D05C80E605D5B118A58AE603")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
        public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.104 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "E6BAC865645517DE70A7D9253D1A71F5")
    @DSModeled(DSC.SAFE)
    @Override
    public final int validOps() {
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.105 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "8AEDC5C17366A11AA6CA292B2B11A803")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        dsTaint.addTaint(targets[0].dsTaint);
        long var8C8D63ACDBC3A6604609CB688A50835B_1566914284 = (read(targets, 0, targets.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.105 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "2169742AB8CDEFAD3F06DFDCB5CAA04F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        dsTaint.addTaint(sources[0].dsTaint);
        long var284611C5A2FA51DEC3760F3DD09B2EC8_2063090671 = (write(sources, 0, sources.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}

