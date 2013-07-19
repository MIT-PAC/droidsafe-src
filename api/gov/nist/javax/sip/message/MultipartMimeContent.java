package gov.nist.javax.sip.message;

// Droidsafe Imports
import java.util.Iterator;

import javax.sip.header.ContentTypeHeader;

public interface MultipartMimeContent {

    public abstract boolean add(Content content);

    
    public abstract ContentTypeHeader getContentTypeHeader();

    public abstract String toString();

    
    public abstract void addContent( Content content);
    
    
    public Iterator<Content> getContents();
    
    
    public int getContentCount();

}
