package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface WritableByteChannel extends Channel {

    
    public int write(ByteBuffer buffer) throws IOException;
}
