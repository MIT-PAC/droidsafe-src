package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface ObjectInput extends DataInput, AutoCloseable {
    
    public int available() throws IOException;

    
    public void close() throws IOException;

    
    public int read() throws IOException;

    
    public int read(byte[] buffer) throws IOException;

    
    public int read(byte[] buffer, int offset, int count) throws IOException;

    
    public Object readObject() throws ClassNotFoundException, IOException;

    
    public long skip(long byteCount) throws IOException;
}
