package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Closeable;
import java.io.IOException;

public interface Channel extends Closeable {

    
    public boolean isOpen();

    
    public void close() throws IOException;
}
