package java.nio;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;

public final class SelectorProviderImpl extends SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.553 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "FC423FE9F3E0B40EBD9ED78EA2942A43")
    @DSModeled(DSC.SAFE)
    public DatagramChannel openDatagramChannel() throws IOException {
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.555 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "32A61BBE0DDD9478CD150B2C40298DBA")
    @DSModeled(DSC.SAFE)
    public Pipe openPipe() throws IOException {
        return (Pipe)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.556 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "3AA8296486C6721228F8AC55768FEB57")
    @DSModeled(DSC.SAFE)
    public AbstractSelector openSelector() throws IOException {
        return (AbstractSelector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.558 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "167EEEA81033950A4DC02414AA685707")
    @DSModeled(DSC.SAFE)
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        return (ServerSocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:51:07.559 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "6FA3362163947600E50D729483DA3550")
    @DSModeled(DSC.SAFE)
    public SocketChannel openSocketChannel() throws IOException {
        return (SocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}


