package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.ServerHeader;
import javax.sip.header.UserAgentHeader;
import javax.sip.message.MessageFactory;

public interface MessageFactoryExt extends MessageFactory {
    

    public void setDefaultUserAgentHeader(UserAgentHeader userAgent);


    

    public void setDefaultServerHeader(ServerHeader userAgent);

    
    public  void setDefaultContentEncodingCharset(String charset)
            throws NullPointerException,IllegalArgumentException ;
    
    
    public MultipartMimeContent createMultipartMimeContent(ContentTypeHeader multipartMimeContentTypeHeader,
            String[] contentType, 
            String[] contentSubtype, 
            String[] contentBody);
    
    
    
    
    
}
