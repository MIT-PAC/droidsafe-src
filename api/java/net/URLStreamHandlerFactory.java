package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface URLStreamHandlerFactory {

    
    URLStreamHandler createURLStreamHandler(String protocol);
}
