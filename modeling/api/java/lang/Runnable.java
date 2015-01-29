package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Runnable {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.THREADING)
    public void run();
}
