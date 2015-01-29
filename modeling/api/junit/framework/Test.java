package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Test {
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int countTestCases();
    
    public abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void run(TestResult result);
}
