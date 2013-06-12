package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.488 -0400", hash_original_method = "134796BB126CC075543A5858F980D0FB", hash_generated_method = "F620F45AD8C9196520AEC3DB99F728A3")
    @DSModeled(DSC.SAFE)
    protected SelectableChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract Object blockingLock();

    
    public abstract SelectableChannel configureBlocking(boolean block)
            throws IOException;

    
    public abstract boolean isBlocking();

    
    public abstract boolean isRegistered();

    
    public abstract SelectionKey keyFor(Selector sel);

    
    public abstract SelectorProvider provider();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.488 -0400", hash_original_method = "9EF0D8B0DC0E3104C0F2D3C59F2DDC24", hash_generated_method = "F2A58DD537849BAC926AE8FFA797B206")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SelectionKey register(Selector selector, int operations) throws ClosedChannelException {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(operations);
        SelectionKey var6C5619144F354B2D7FF635172C3705A9_702035449 = (register(selector, operations, null));
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return register(selector, operations, null);
    }

    
    public abstract SelectionKey register(Selector sel, int ops, Object att)
            throws ClosedChannelException;

    
    public abstract int validOps();

    
}


