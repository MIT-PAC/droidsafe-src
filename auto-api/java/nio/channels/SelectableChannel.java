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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.624 -0400", hash_original_method = "134796BB126CC075543A5858F980D0FB", hash_generated_method = "6A27F38CD958D23D87075149EA9DFC8C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.626 -0400", hash_original_method = "9EF0D8B0DC0E3104C0F2D3C59F2DDC24", hash_generated_method = "8360790281B8001037FCFF7833A91B1F")
    public final SelectionKey register(Selector selector, int operations) throws ClosedChannelException {
        SelectionKey varB4EAC82CA7396A68D541C85D26508E83_923340144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_923340144 = register(selector, operations, null);
        addTaint(selector.getTaint());
        addTaint(operations);
        varB4EAC82CA7396A68D541C85D26508E83_923340144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_923340144;
        // ---------- Original Method ----------
        //return register(selector, operations, null);
    }

    
    public abstract SelectionKey register(Selector sel, int ops, Object att)
            throws ClosedChannelException;

    
    public abstract int validOps();

    
}

