package org.apache.http.impl.conn.tsccm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.ref.Reference;

public interface RefQueueHandler {

    
    public void handleReference(Reference<?> ref)
        ;
}
