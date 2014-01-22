package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.UserAgentHeader;
import javax.sip.message.MessageFactory;

public interface MessageFactoryExt extends MessageFactory {

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setDefaultUserAgentHeader(UserAgentHeader userAgent);

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void setDefaultServerHeader(ServerHeader userAgent);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public  void setDefaultContentEncodingCharset(String charset)
            throws NullPointerException,IllegalArgumentException ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeContentTypeHeader,
            String[] contentType, 
            String[] contentSubtype, 
            String[] contentBody);
    
}
