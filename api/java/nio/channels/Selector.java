package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public abstract class Selector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.284 -0400", hash_original_method = "9524E27FB2E16D9605DE08EA9659D1CB", hash_generated_method = "43B86B7B1C3DAE791684BCEE03F22EB0")
    protected  Selector() {
        // ---------- Original Method ----------
    }

    
    public static Selector open() throws IOException {
        return SelectorProvider.provider().openSelector();
    }

    
    public abstract void close() throws IOException;

    
    public abstract boolean isOpen();

    
    public abstract Set<SelectionKey> keys();

    
    public abstract SelectorProvider provider();

    
    public abstract int select() throws IOException;

    
    public abstract int select(long timeout) throws IOException;

    
    public abstract Set<SelectionKey> selectedKeys();

    
    public abstract int selectNow() throws IOException;

    
    public abstract Selector wakeup();

    
}

