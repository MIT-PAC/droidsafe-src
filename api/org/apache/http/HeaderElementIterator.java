package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;

public interface HeaderElementIterator extends Iterator {
    
    
    boolean hasNext();
    
    
    HeaderElement nextElement();
    
}
