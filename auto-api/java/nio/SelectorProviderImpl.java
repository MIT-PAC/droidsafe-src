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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.009 -0400", hash_original_method = "88F96E05EFDFC31986DDA7648583D829", hash_generated_method = "88F96E05EFDFC31986DDA7648583D829")
        public SelectorProviderImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.009 -0400", hash_original_method = "387A5A2577212A6C1EA1C3C9B72655AF", hash_generated_method = "7A8B1BC6AD12F5C517A186B3DFD2AB8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DatagramChannel openDatagramChannel() throws IOException {
        DatagramChannel var0158FCB23B5063F2D4D1032A1B739643_1245896896 = (new DatagramChannelImpl(this));
        return (DatagramChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DatagramChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.010 -0400", hash_original_method = "2F15CF0A5D0F2155005284DE3BE9BD3D", hash_generated_method = "3501D64177538B2E26873FA9A2FDB82F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Pipe openPipe() throws IOException {
        Pipe var216FA84F62B4E349C08DDFA88B94F130_1464545002 = (new PipeImpl());
        return (Pipe)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new PipeImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.010 -0400", hash_original_method = "7F763A0354A8071A63016F4A050A4598", hash_generated_method = "CE61DDFCBE9B15CC3A1048E325A511F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AbstractSelector openSelector() throws IOException {
        AbstractSelector varB2B25972C5CE75D966B5FD422E3C5832_1696047104 = (new SelectorImpl(this));
        return (AbstractSelector)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SelectorImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.010 -0400", hash_original_method = "775977081681050F27E8E3BC6B50B017", hash_generated_method = "B45518C18E3A753CE3328DDED559BB78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerSocketChannel openServerSocketChannel() throws IOException {
        ServerSocketChannel var069F4B39ADD63D0A0796851A36587F61_1292673102 = (new ServerSocketChannelImpl(this));
        return (ServerSocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServerSocketChannelImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.010 -0400", hash_original_method = "7755F9A94A84671924AAF38559CE588E", hash_generated_method = "37DCF179967AF39749AFF58EF4910700")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SocketChannel openSocketChannel() throws IOException {
        SocketChannel varB3F884A1EA60B14618DE575AEC09E961_1032883351 = (new SocketChannelImpl(this));
        return (SocketChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SocketChannelImpl(this);
    }

    
}

