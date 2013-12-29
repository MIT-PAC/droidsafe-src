package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Delayed extends Comparable<Delayed> {

    
    long getDelay(TimeUnit unit);
}
