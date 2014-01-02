package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface URLStreamHandlerFactory {

    
    URLStreamHandler createURLStreamHandler(String protocol);
}
