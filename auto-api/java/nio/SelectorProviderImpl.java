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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.151 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.154 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "0249964544B88654C1F638FF8E22DFF6")
    public DatagramChannel openDatagramChannel() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_633643268 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_633643268 = new DatagramChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_633643268.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_633643268;
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.154 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "50899424CC03895731DCD9B0A4A0D932")
    public Pipe openPipe() throws IOException {
        Pipe varB4EAC82CA7396A68D541C85D26508E83_109665240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_109665240 = new PipeImpl();
        varB4EAC82CA7396A68D541C85D26508E83_109665240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_109665240;
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.155 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "DAC9A131B9EB1C2E3CF6E89BD7ECE979")
    public AbstractSelector openSelector() throws IOException {
        AbstractSelector varB4EAC82CA7396A68D541C85D26508E83_225798832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_225798832 = new SelectorImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_225798832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225798832;
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.155 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "C81179996F404726D86B60656B84C764")
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_421311132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_421311132 = new ServerSocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_421311132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_421311132;
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.156 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "022212945C41FE8C4E33D38425E27E2E")
    public SocketChannel openSocketChannel() throws IOException {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_2028945717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2028945717 = new SocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_2028945717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2028945717;
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

