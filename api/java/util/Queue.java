package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Queue<E> extends Collection<E> {
    
    boolean add(E e);

    
    boolean offer(E e);

    
    E remove();

    
    E poll();

    
    E element();

    
    E peek();
}
