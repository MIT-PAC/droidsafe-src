package junit.runner;

// Droidsafe Imports

public interface TestSuiteLoader {
	abstract public Class load(String suiteClassName) throws ClassNotFoundException;
	abstract public Class reload(Class aClass) throws ClassNotFoundException;
}
