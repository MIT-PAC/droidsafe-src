package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;

public interface HeaderElementIterator extends Iterator {
    
    
    boolean hasNext();
    
    
    HeaderElement nextElement();
    
}
