package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ReloadingTestSuiteLoader implements TestSuiteLoader {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.403 -0400", hash_original_method = "29760FA8FF235C70A3E71F399656C6F4", hash_generated_method = "29760FA8FF235C70A3E71F399656C6F4")
    public ReloadingTestSuiteLoader ()
    {
        //Synthesized constructor
    }
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.138 -0500", hash_original_method = "13C1DA2A7A06C5AA5CC7BC929B5B4B4D", hash_generated_method = "92FA93F7647A8A4CA9498B1346C9E6AE")
    
public Class load(String suiteClassName) throws ClassNotFoundException {
		return createLoader().loadClass(suiteClassName, true);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.140 -0500", hash_original_method = "89B315CCC74BC2AD3DF0F1D261AE00FD", hash_generated_method = "8188C918C9C269D8115A4E1AFF5D9CFF")
    
public Class reload(Class aClass) throws ClassNotFoundException {
		return createLoader().loadClass(aClass.getName(), true);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.142 -0500", hash_original_method = "C0CD1B730267B48F98209346AB7074D3", hash_generated_method = "B8A41C4FD4A2109647EFA2F6A14A2EE0")
    
protected TestCaseClassLoader createLoader() {
		return new TestCaseClassLoader();
	}
    
}

