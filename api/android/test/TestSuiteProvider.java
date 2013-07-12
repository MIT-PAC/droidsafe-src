package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import junit.framework.TestSuite;

public interface TestSuiteProvider {

    TestSuite getTestSuite();
}
