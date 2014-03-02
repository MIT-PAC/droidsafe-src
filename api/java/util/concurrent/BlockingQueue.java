package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.Queue;

public interface BlockingQueue<E> extends Queue<E> {
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    boolean add(E e);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean offer(E e);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void put(E e) throws InterruptedException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean offer(E e, long timeout, TimeUnit unit)
        throws InterruptedException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    E take() throws InterruptedException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    E poll(long timeout, TimeUnit unit)
        throws InterruptedException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int remainingCapacity();
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean remove(Object o);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public boolean contains(Object o);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int drainTo(Collection<? super E> c);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int drainTo(Collection<? super E> c, int maxElements);
}
