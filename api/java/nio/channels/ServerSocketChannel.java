package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.666 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "11CDF703A4591FA5F7E5C70AF9A7C9BA")
    protected  ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        
    }

    
        public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.666 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "E3F807C00AE64972058168A2E42B82A9")
    @Override
    public final int validOps() {
        int var883006640E005F2ED2474E2EA921343D_1209496141 = (SelectionKey.OP_ACCEPT);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241792529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1241792529;
        
        
    }

    
    public abstract ServerSocket socket();

    
    public abstract SocketChannel accept() throws IOException;

    
}

