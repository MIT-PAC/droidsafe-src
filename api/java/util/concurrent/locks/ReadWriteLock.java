package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ReadWriteLock {
    
    Lock readLock();

    
    Lock writeLock();
}
