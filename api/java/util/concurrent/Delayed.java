package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;

public interface Delayed extends Comparable<Delayed> {

    
    long getDelay(TimeUnit unit);
}
