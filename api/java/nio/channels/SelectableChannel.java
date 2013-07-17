package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.258 -0400", hash_original_method = "134796BB126CC075543A5858F980D0FB", hash_generated_method = "6A27F38CD958D23D87075149EA9DFC8C")
    protected  SelectableChannel() {
        // ---------- Original Method ----------
    }

    
    public abstract Object blockingLock();

    
    public abstract SelectableChannel configureBlocking(boolean block)
            throws IOException;

    
    public abstract boolean isBlocking();

    
    public abstract boolean isRegistered();

    
    public abstract SelectionKey keyFor(Selector sel);

    
    public abstract SelectorProvider provider();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.260 -0400", hash_original_method = "9EF0D8B0DC0E3104C0F2D3C59F2DDC24", hash_generated_method = "E336014C9CAD971A325F1C55663FDC18")
    public final SelectionKey register(Selector selector, int operations) throws ClosedChannelException {
        addTaint(operations);
        addTaint(selector.getTaint());
SelectionKey var5876B2AC1310ED80B9A3C6592446A1F8_1234949690 =         register(selector, operations, null);
        var5876B2AC1310ED80B9A3C6592446A1F8_1234949690.addTaint(taint);
        return var5876B2AC1310ED80B9A3C6592446A1F8_1234949690;
        // ---------- Original Method ----------
        //return register(selector, operations, null);
    }

    
    public abstract SelectionKey register(Selector sel, int ops, Object att)
            throws ClosedChannelException;

    
    public abstract int validOps();

    
}

