package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.CharBuffer;

public interface Readable {

    
    int read(CharBuffer cb) throws IOException;
}
