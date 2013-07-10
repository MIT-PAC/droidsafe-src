package gov.nist.javax.sip.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Iterator;
import java.util.List;
import javax.sip.header.ContentTypeHeader;

public interface MultipartMimeContent {

    public abstract boolean add(Content content);

    
    public abstract ContentTypeHeader getContentTypeHeader();

    public abstract String toString();

    
    public abstract void addContent( Content content);
    
    
    public Iterator<Content> getContents();
    
    
    public int getContentCount();

}
