package java.util.concurrent.locks;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.*;
import java.util.Date;

public interface Condition {

    
    void await() throws InterruptedException;

    
    void awaitUninterruptibly();

    
    long awaitNanos(long nanosTimeout) throws InterruptedException;

    
    boolean await(long time, TimeUnit unit) throws InterruptedException;

    
    boolean awaitUntil(Date deadline) throws InterruptedException;

    
    void signal();

    
    void signalAll();
}

