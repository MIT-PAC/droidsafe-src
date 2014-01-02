package gov.nist.javax.sip.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.CSeqHeader;
import javax.sip.header.CallIdHeader;
import javax.sip.header.ContentLengthHeader;
import javax.sip.header.ContentTypeHeader;
import javax.sip.header.FromHeader;
import javax.sip.header.ToHeader;
import javax.sip.header.ViaHeader;
import javax.sip.message.Message;

public interface MessageExt extends Message {

     

    public void setApplicationData (Object applicationData);


    
    public Object getApplicationData();
    
    
    public MultipartMimeContent getMultipartMimeContent() throws ParseException;
    
    
    public ViaHeader getTopmostViaHeader();
    
    
    public FromHeader getFromHeader();
    
    
    public ToHeader getToHeader();
    
    
    
    public CallIdHeader getCallIdHeader();
    
    
    public  CSeqHeader getCSeqHeader();
    
    
    public ContentTypeHeader getContentTypeHeader();
    
    
    public ContentLengthHeader getContentLengthHeader();
    
    
    public String getFirstLine();

}
