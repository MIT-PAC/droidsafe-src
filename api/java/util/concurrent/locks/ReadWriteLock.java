package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface ReadWriteLock {
    
    Lock readLock();

    
    Lock writeLock();
}
