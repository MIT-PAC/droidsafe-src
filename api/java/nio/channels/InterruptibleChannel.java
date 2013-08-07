package java.nio.channels;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

public interface InterruptibleChannel extends Channel {

    
    public void close() throws IOException;
}
