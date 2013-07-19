package org.apache.http;

// Droidsafe Imports
import java.util.Iterator;

public interface HeaderElementIterator extends Iterator {
    
    
    boolean hasNext();
    
    
    HeaderElement nextElement();
    
}
