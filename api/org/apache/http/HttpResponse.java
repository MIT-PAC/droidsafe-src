package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;

public interface HttpResponse extends HttpMessage {

    
    StatusLine getStatusLine();

    
    void setStatusLine(StatusLine statusline);

    
    void setStatusLine(ProtocolVersion ver, int code);

    
    void setStatusLine(ProtocolVersion ver, int code, String reason);
    
    
    void setStatusCode(int code)
        throws IllegalStateException;

    
    void setReasonPhrase(String reason)
        throws IllegalStateException;

    
    HttpEntity getEntity();
    
    
    void setEntity(HttpEntity entity);

    
    Locale getLocale();

    
    void setLocale(Locale loc);
}
