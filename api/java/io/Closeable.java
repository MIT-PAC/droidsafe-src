package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Closeable extends AutoCloseable {

    
    void close() throws IOException;
}
