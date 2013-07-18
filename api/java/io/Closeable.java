package java.io;

// Droidsafe Imports

public interface Closeable extends AutoCloseable {

    
    void close() throws IOException;
}
