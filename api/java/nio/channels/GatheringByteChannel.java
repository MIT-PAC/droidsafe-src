package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface GatheringByteChannel extends WritableByteChannel {

    
    public long write(ByteBuffer[] buffers) throws IOException;

    
    public long write(ByteBuffer[] buffers, int offset, int length)
            throws IOException;
}
