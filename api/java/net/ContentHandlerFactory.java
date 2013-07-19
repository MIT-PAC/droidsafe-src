package java.net;

// Droidsafe Imports

public interface ContentHandlerFactory {
    
    ContentHandler createContentHandler(String contentType);
}
