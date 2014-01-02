package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public interface TokenIterator extends Iterator {

    
    boolean hasNext()
        ;


    
    String nextToken()
        ;
}
