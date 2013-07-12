package junit.framework;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Test {
    
    public abstract int countTestCases();
    
    public abstract void run(TestResult result);
}
