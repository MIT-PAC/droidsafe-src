package java.util.concurrent.locks;

// Droidsafe Imports

public interface ReadWriteLock {
    
    Lock readLock();

    
    Lock writeLock();
}
