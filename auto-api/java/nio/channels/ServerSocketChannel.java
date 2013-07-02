package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.706 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "11CDF703A4591FA5F7E5C70AF9A7C9BA")
    protected  ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.708 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "39A49C343DAF89019036D8AE56425E65")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389903521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1389903521;
        
        
    }

    
    public abstract ServerSocket socket();

    
    public abstract SocketChannel accept() throws IOException;

    
}

