package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public interface HeaderValueParser {

    
    HeaderElement[] parseElements(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;

    
    HeaderElement parseHeaderElement(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;

    
    NameValuePair[] parseParameters(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;


    
    NameValuePair parseNameValuePair(
            CharArrayBuffer buffer,
            ParserCursor cursor) throws ParseException;
    
}
