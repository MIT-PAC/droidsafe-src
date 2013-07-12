package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;

public interface HeaderIterator extends Iterator {

    
    boolean hasNext()
        ;


    
    Header nextHeader()
        ;
}
