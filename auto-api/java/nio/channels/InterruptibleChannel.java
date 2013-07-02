package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public interface InterruptibleChannel extends Channel {

    
    public void close() throws IOException;
}
