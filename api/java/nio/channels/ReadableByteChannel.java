package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface ReadableByteChannel extends Channel {

    
    public int read(ByteBuffer buffer) throws IOException;
}
