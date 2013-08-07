package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Queue<E> extends Collection<E> {
    
    boolean add(E e);

    
    boolean offer(E e);

    
    E remove();

    
    E poll();

    
    E element();

    
    E peek();
}
