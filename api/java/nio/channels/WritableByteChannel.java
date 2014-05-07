package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface WritableByteChannel extends Channel {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.IO)
    @DSSink(DSSinkKind.IO)
    public int write(ByteBuffer buffer) throws IOException;
}
