package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Closeable extends AutoCloseable {

    
    void close() throws IOException;
}
