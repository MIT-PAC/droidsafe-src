package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.132 -0400", hash_original_method = "134796BB126CC075543A5858F980D0FB", hash_generated_method = "6A27F38CD958D23D87075149EA9DFC8C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.133 -0400", hash_original_method = "9EF0D8B0DC0E3104C0F2D3C59F2DDC24", hash_generated_method = "52E1935B06F713471AF58F4C87325EBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final SelectionKey register(Selector selector, int operations) throws ClosedChannelException {
        dsTaint.addTaint(selector.dsTaint);
        dsTaint.addTaint(operations);
        SelectionKey var6C5619144F354B2D7FF635172C3705A9_989277692 = (register(selector, operations, null));
        return (SelectionKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return register(selector, operations, null);
    }

    
    public abstract SelectionKey register(Selector sel, int ops, Object att)
            throws ClosedChannelException;

    
    public abstract int validOps();

    
}

