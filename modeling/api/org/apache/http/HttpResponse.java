package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

public interface HttpResponse extends HttpMessage {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    StatusLine getStatusLine();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setStatusLine(StatusLine statusline);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setStatusLine(ProtocolVersion ver, int code);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setStatusLine(ProtocolVersion ver, int code, String reason);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setStatusCode(int code)
        throws IllegalStateException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setReasonPhrase(String reason)
        throws IllegalStateException;
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.NETWORK)
    @DSSource({DSSourceKind.NETWORK})
    HttpEntity getEntity();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setEntity(HttpEntity entity);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Locale getLocale();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void setLocale(Locale loc);
}
