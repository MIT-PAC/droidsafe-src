package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TestListener {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void addError(Test test, Throwable t);
    
     @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void addFailure(Test test, AssertionFailedError t);
    
     @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void endTest(Test test);
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public void startTest(Test test);
}
