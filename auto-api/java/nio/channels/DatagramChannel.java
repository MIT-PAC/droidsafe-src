package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class DatagramChannel extends AbstractSelectableChannel implements ByteChannel, ScatteringByteChannel, GatheringByteChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.482 -0400", hash_original_method = "CB53873E4EB950556D4A1D46A395181D", hash_generated_method = "5253FDB737F446F269763B6BBEB82334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected DatagramChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.482 -0400", hash_original_method = "FF19FCAA1AEEA14F76CE4D3DFB2AA57C", hash_generated_method = "9FAF3ABF2C27F02B828E01EB0D389166")
    public static DatagramChannel open() throws IOException {
        return SelectorProvider.provider().openDatagramChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.482 -0400", hash_original_method = "389104566E9179427B49B1E6618B4C60", hash_generated_method = "B9F07D03B9DC063D8B98FEC0C56733D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.482 -0400", hash_original_method = "27A2349B12D0C34616F4A42E88CDB7C6", hash_generated_method = "DAF0B6501917C146B1C648E791000AAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long read(ByteBuffer[] targets) throws IOException {
        dsTaint.addTaint(targets.dsTaint);
        long var8C8D63ACDBC3A6604609CB688A50835B_1896116486 = (read(targets, 0, targets.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return read(targets, 0, targets.length);
    }

    
    public abstract int write(ByteBuffer source) throws IOException;

    
    public abstract long write(ByteBuffer[] sources, int offset, int length)
            throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.482 -0400", hash_original_method = "3D11D927406C5CFD8B6F27A884F1DAA7", hash_generated_method = "3E24476E30BFD4D0B0A180C92B520C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized final long write(ByteBuffer[] sources) throws IOException {
        dsTaint.addTaint(sources.dsTaint);
        long var284611C5A2FA51DEC3760F3DD09B2EC8_1954603681 = (write(sources, 0, sources.length));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return write(sources, 0, sources.length);
    }

    
}


