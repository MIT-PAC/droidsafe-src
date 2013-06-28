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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.350 -0400", hash_original_method = "0FAD76CB1DA362BA4B44B65B1490E94B", hash_generated_method = "0FAD76CB1DA362BA4B44B65B1490E94B")
    public SelectorProviderImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.351 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "56F772B459B9EA2245F9F08BD0E8E810")
    public DatagramChannel openDatagramChannel() throws IOException {
        DatagramChannel varB4EAC82CA7396A68D541C85D26508E83_711728975 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_711728975 = new DatagramChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_711728975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_711728975;
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.352 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "A13BF3C17B0B5E4B2BADE352D2B50480")
    public Pipe openPipe() throws IOException {
        Pipe varB4EAC82CA7396A68D541C85D26508E83_1525660676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1525660676 = new PipeImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1525660676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525660676;
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.352 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "BAB639FE2522C7233296B0918A38241A")
    public AbstractSelector openSelector() throws IOException {
        AbstractSelector varB4EAC82CA7396A68D541C85D26508E83_1254682342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1254682342 = new SelectorImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1254682342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1254682342;
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.353 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "934994D1EA660FC9C2E193006435D68F")
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        ServerSocketChannel varB4EAC82CA7396A68D541C85D26508E83_596253918 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_596253918 = new ServerSocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_596253918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_596253918;
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.353 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "01B9E46F76131CDE13E775C5D5C8BB8A")
    public SocketChannel openSocketChannel() throws IOException {
        SocketChannel varB4EAC82CA7396A68D541C85D26508E83_1459177837 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459177837 = new SocketChannelImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1459177837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459177837;
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

