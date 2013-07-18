package junit.framework;

// Droidsafe Imports

public interface Test {
    
    public abstract int countTestCases();
    
    public abstract void run(TestResult result);
}
