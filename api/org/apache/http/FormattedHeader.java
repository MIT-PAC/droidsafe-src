package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.util.CharArrayBuffer;

public interface FormattedHeader extends Header {


    
    CharArrayBuffer getBuffer()
        ;

    
    int getValuePos()
        ;

}
