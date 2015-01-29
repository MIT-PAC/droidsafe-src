package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface TestSuiteLoader {
	abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Class load(String suiteClassName) throws ClassNotFoundException;
	abstract @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Class reload(Class aClass) throws ClassNotFoundException;
}
