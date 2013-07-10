package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Callable<V> {
    
    V call() throws Exception;
}
