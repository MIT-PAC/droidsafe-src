package org.apache.http.message;

// Droidsafe Imports
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

public interface LineFormatter {



    
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer buffer,
                                          ProtocolVersion version)
        ;


    
    CharArrayBuffer formatRequestLine(CharArrayBuffer buffer,
                                      RequestLine reqline) 
        ;


    
    CharArrayBuffer formatStatusLine(CharArrayBuffer buffer,
                                     StatusLine statline) 
        ;


    
    CharArrayBuffer formatHeader(CharArrayBuffer buffer,
                                 Header header)
        ;

}
