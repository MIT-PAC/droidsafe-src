package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface WritableByteChannel extends Channel {

    
    public int write(ByteBuffer buffer) throws IOException;
}
