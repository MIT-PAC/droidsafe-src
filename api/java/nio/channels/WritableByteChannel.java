package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface WritableByteChannel extends Channel {

    
    public int write(ByteBuffer buffer) throws IOException;
}
