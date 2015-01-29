package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Executor {
    
    @DSVerified
    @DSComment("Abstract Method")
    @DSSpec(DSCat.THREADING)
    void execute(Runnable command);
}
