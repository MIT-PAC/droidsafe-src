package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.Reference;

public interface RefQueueHandler {

    
    public void handleReference(Reference<?> ref)
        ;
}
