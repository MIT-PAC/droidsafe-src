package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import junit.framework.TestSuite;

public interface TestSuiteProvider {

    TestSuite getTestSuite();
}
