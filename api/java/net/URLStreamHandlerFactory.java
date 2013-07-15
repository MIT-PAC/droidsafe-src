package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface URLStreamHandlerFactory {

    
    URLStreamHandler createURLStreamHandler(String protocol);
}
