package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.util.CharArrayBuffer;

public interface FormattedHeader extends Header {


    
    CharArrayBuffer getBuffer()
        ;

    
    int getValuePos()
        ;

}
