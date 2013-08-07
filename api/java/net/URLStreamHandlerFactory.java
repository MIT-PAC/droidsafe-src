package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface URLStreamHandlerFactory {

    
    URLStreamHandler createURLStreamHandler(String protocol);
}
