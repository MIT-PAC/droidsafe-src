package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.490 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "16375BF71CBD155998CB13E55BD71836")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.490 -0400", hash_original_method = "34D19E8F6CC7AE23963D26F15FC056F7", hash_generated_method = "82BC2C8DDAA1412A8ADF42B437FD7D7F")
    public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.490 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "6471AF8DF6E48B63EDC17B2F129B38EE")
    @DSModeled(DSC.SAFE)
    @Override
    public final int validOps() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return SelectionKey.OP_ACCEPT;
    }

    
    public abstract ServerSocket socket();

    
    public abstract SocketChannel accept() throws IOException;

    
}


