package java.nio.channels;

// Droidsafe Imports
import java.io.IOException;

public interface InterruptibleChannel extends Channel {

    
    public void close() throws IOException;
}
