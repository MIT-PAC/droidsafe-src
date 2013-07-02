package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Closeable extends AutoCloseable {

    
    void close() throws IOException;
}
