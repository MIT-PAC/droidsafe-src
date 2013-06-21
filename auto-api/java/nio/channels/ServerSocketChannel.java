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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.138 -0400", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "5B401135C98B9CFA10905D115F72DADE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
        dsTaint.addTaint(selectorProvider.dsTaint);
        // ---------- Original Method ----------
    }

    
        public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.138 -0400", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "BC1065FF0B4291E206F88390D2D73560")
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

