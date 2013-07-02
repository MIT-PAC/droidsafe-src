package java.util.concurrent.locks;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public interface Lock {

    
    void lock();

    
    void lockInterruptibly() throws InterruptedException;

    
    boolean tryLock();

    
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    
    void unlock();

    
    Condition newCondition();
}
