package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ReadWriteLock {
    
    Lock readLock();

    
    Lock writeLock();
}
