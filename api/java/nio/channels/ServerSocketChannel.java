package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;





public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.291 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "11CDF703A4591FA5F7E5C70AF9A7C9BA")
    protected  ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.292 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "AE212F1166E106871592C27CDFD6315B")
    @Override
    public final int validOps() {
        int var883006640E005F2ED2474E2EA921343D_1706834387 = (SelectionKey.OP_ACCEPT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651773690 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651773690;
        // ---------- Original Method ----------
        //return SelectionKey.OP_ACCEPT;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract ServerSocket socket();

    
    @DSModeled(DSC.SAFE)
    public abstract SocketChannel accept() throws IOException;

    
}

