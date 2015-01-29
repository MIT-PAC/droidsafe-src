package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.util.CharArrayBuffer;

public interface LineParser {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ProtocolVersion parseProtocolVersion(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean hasProtocolVersion(
            CharArrayBuffer buffer, 
            ParserCursor cursor);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    RequestLine parseRequestLine(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    StatusLine parseStatusLine(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Header parseHeader(CharArrayBuffer buffer)
        throws ParseException
        ;

}
