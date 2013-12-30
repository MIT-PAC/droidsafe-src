package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;





public final class SelectorProviderImpl extends SelectorProvider {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:53.908 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.264 -0500", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "7152E15F5845FC2AAE9505FE0A516F46")
    
public DatagramChannel openDatagramChannel() throws IOException {
        return new DatagramChannelImpl(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.267 -0500", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "6843DEF07E5AD6756B9DFCD5A8A83663")
    
public Pipe openPipe() throws IOException {
        return new PipeImpl();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.269 -0500", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "C786B56A077285F67B3A6000EE75C776")
    
public AbstractSelector openSelector() throws IOException {
        return new SelectorImpl(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.272 -0500", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "06C79F73340EFF612909C501AD7779A5")
    
public ServerSocketChannel openServerSocketChannel() throws IOException {
        return new ServerSocketChannelImpl(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:53.275 -0500", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "CFD659B281E7D2668F6A0FCEC6639D90")
    
public SocketChannel openSocketChannel() throws IOException {
        return new SocketChannelImpl(this);
    }

    
}

