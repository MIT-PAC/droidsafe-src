package java.io;

// Droidsafe Imports

public interface ObjectOutput extends DataOutput, AutoCloseable {
    
    public void close() throws IOException;

    
    public void flush() throws IOException;

    
    public void write(byte[] buffer) throws IOException;

    
    public void write(byte[] buffer, int offset, int count) throws IOException;

    
    public void write(int value) throws IOException;

    
    public void writeObject(Object obj) throws IOException;
}
