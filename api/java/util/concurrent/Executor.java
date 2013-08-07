package java.util.concurrent;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Executor {

    
    void execute(Runnable command);
}
