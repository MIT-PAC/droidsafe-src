package java.util.concurrent;

// Droidsafe Imports

public interface Delayed extends Comparable<Delayed> {

    
    long getDelay(TimeUnit unit);
}
