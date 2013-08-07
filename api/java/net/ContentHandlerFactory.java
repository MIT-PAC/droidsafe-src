package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ContentHandlerFactory {
    
    ContentHandler createContentHandler(String contentType);
}
