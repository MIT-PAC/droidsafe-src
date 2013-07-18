package org.apache.http;

// Droidsafe Imports
import java.util.Iterator;

public interface HeaderIterator extends Iterator {

    
    boolean hasNext()
        ;


    
    Header nextHeader()
        ;
}
