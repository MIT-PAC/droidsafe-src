package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.726 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "11CDF703A4591FA5F7E5C70AF9A7C9BA")
    protected  ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        addTaint(selectorProvider.getTaint());
        // ---------- Original Method ----------
    }

    
        public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.727 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "3878F0E694D4191C8695E43868DA7FFC")
    @Override
    public final int validOps() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16995523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_16995523;
        // ---------- Original Method ----------
        //return SelectionKey.OP_ACCEPT;
    }

    
    public abstract ServerSocket socket();

    
    public abstract SocketChannel accept() throws IOException;

    
}

