package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

public interface LineFormatter {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer buffer,
                                          ProtocolVersion version)
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                      RequestLine reqline) 
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CharArrayBuffer formatStatusLine(CharArrayBuffer buffer,
                                     StatusLine statline) 
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                 Header header)
        ;

}
