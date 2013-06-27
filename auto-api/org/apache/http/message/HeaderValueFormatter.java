package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;

public interface HeaderValueFormatter {

    
    CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                   HeaderElement[] elems,
                                   boolean quote)
        ;


    
    CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                        HeaderElement elem,
                                        boolean quote)
        ;



    
    CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                     NameValuePair[] nvps,
                                     boolean quote)
        ;


    
    CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                        NameValuePair nvp,
                                        boolean quote)
        ;

}
