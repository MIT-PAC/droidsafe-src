package org.apache.http.conn;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.IOException;

public interface EofSensorWatcher {

    
    boolean eofDetected(InputStream wrapped)
        throws IOException
        ;


    
    boolean streamClosed(InputStream wrapped)
        throws IOException
        ;


    
    boolean streamAbort(InputStream wrapped)
        throws IOException
        ;


}
