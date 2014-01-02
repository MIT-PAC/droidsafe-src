package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TestSuiteLoader {
	abstract public Class load(String suiteClassName) throws ClassNotFoundException;
	abstract public Class reload(Class aClass) throws ClassNotFoundException;
}
