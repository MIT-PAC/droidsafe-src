package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface ScatteringByteChannel extends ReadableByteChannel {

    
    public long read(ByteBuffer[] buffers) throws IOException;

    
    public long read(ByteBuffer[] buffers, int offset, int length)
            throws IOException;
}
