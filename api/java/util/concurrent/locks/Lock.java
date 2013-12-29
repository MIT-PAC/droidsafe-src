package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.TimeUnit;

public interface Lock {

    
    void lock();

    
    void lockInterruptibly() throws InterruptedException;

    
    boolean tryLock();

    
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    
    void unlock();

    
    Condition newCondition();
}
