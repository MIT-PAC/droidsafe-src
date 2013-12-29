package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public interface HeaderIterator extends Iterator {

    
    boolean hasNext()
        ;


    
    Header nextHeader()
        ;
}
