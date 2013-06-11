package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public abstract class Selector {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.490 -0400", hash_original_method = "9524E27FB2E16D9605DE08EA9659D1CB", hash_generated_method = "9BC761F2E4618067AFA6638BC9787E66")
    @DSModeled(DSC.SAFE)
    protected Selector() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.490 -0400", hash_original_method = "D2B63EBEB5E56482EA1EC71E4ADC6B8F", hash_generated_method = "D9D2632C8FA47BFA91F51C1B152ECC92")
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


