package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TestListener {
    
    public void addError(Test test, Throwable t);
    
     public void addFailure(Test test, AssertionFailedError t);
    
     public void endTest(Test test);
    
    public void startTest(Test test);
}
