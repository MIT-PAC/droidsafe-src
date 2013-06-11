package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Closeable;
import java.io.IOException;

public interface Channel extends Closeable {

    
    public boolean isOpen();

    
    public void close() throws IOException;
}

