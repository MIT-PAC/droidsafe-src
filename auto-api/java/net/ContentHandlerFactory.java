package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface ContentHandlerFactory {
    
    ContentHandler createContentHandler(String contentType);
}
