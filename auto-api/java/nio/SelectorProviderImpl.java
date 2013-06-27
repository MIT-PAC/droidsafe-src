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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.223 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.224 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "E5CE26BA76C591879598A69BD61E49D4")
    public DatagramChannel openDatagramChannel() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_332197406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_332197406 = new DatagramChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_332197406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332197406;
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.225 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "1D9E0D346AF685B013959EBE85949A28")
    public Pipe openPipe() throws IOException {
        Pipe varB4EAC82CA7396A68D541C85D26508E83_1961248412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1961248412 = new PipeImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1961248412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1961248412;
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.225 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "6631AB4AB3AF010C3F899FC95A494CB3")
    public AbstractSelector openSelector() throws IOException {
        AbstractSelector varB4EAC82CA7396A68D541C85D26508E83_1766584805 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1766584805 = new SelectorImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1766584805.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1766584805;
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.226 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "FF5B971E862347282B6F2E82DB30F1A0")
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_1426437315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1426437315 = new ServerSocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1426437315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1426437315;
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.226 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "94F80336A0957DCA5E1383CC643E551B")
    public SocketChannel openSocketChannel() throws IOException {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_1364082627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1364082627 = new SocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1364082627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1364082627;
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

