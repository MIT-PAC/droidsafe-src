package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface Queue<E> extends Collection<E> {
    
    boolean add(E e);

    
    boolean offer(E e);

    
    E remove();

    
    E poll();

    
    E element();

    
    E peek();
}

