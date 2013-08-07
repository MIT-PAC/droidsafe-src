package junit.runner;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface TestSuiteLoader {
	abstract public Class load(String suiteClassName) throws ClassNotFoundException;
	abstract public Class reload(Class aClass) throws ClassNotFoundException;
}
