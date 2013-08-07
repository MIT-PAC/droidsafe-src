package junit.framework;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Test {
    
    public abstract int countTestCases();
    
    public abstract void run(TestResult result);
}
