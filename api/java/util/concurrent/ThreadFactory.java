package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface ThreadFactory {

    
    Thread newThread(Runnable r);
}
