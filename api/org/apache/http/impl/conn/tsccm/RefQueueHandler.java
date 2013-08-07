package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.ref.Reference;

public interface RefQueueHandler {

    
    public void handleReference(Reference<?> ref)
        ;
}
