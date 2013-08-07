package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.CharBuffer;

public interface Readable {

    
    int read(CharBuffer cb) throws IOException;
}
