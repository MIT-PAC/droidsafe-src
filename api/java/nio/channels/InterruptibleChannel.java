package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public interface InterruptibleChannel extends Channel {

    
    public void close() throws IOException;
}
