package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
