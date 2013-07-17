package junit.runner;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ReloadingTestSuiteLoader implements TestSuiteLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.403 -0400", hash_original_method = "29760FA8FF235C70A3E71F399656C6F4", hash_generated_method = "29760FA8FF235C70A3E71F399656C6F4")
    public ReloadingTestSuiteLoader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.403 -0400", hash_original_method = "13C1DA2A7A06C5AA5CC7BC929B5B4B4D", hash_generated_method = "E94031855450D5E25D8115AD6C226F90")
    public Class load(String suiteClassName) throws ClassNotFoundException {
        addTaint(suiteClassName.getTaint());
Class var89AC116B9B9FC8B936DF2FD910E07E90_1802463982 =         createLoader().loadClass(suiteClassName, true);
        var89AC116B9B9FC8B936DF2FD910E07E90_1802463982.addTaint(taint);
        return var89AC116B9B9FC8B936DF2FD910E07E90_1802463982;
        // ---------- Original Method ----------
        //return createLoader().loadClass(suiteClassName, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.403 -0400", hash_original_method = "89B315CCC74BC2AD3DF0F1D261AE00FD", hash_generated_method = "A1644F894AE2187ABDB8F1818DA8DE34")
    public Class reload(Class aClass) throws ClassNotFoundException {
        addTaint(aClass.getTaint());
Class var94ED448C605A0DF1C953E6DD05247BFA_1241090962 =         createLoader().loadClass(aClass.getName(), true);
        var94ED448C605A0DF1C953E6DD05247BFA_1241090962.addTaint(taint);
        return var94ED448C605A0DF1C953E6DD05247BFA_1241090962;
        // ---------- Original Method ----------
        //return createLoader().loadClass(aClass.getName(), true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.404 -0400", hash_original_method = "C0CD1B730267B48F98209346AB7074D3", hash_generated_method = "0F97AC6287781E5207C33BF33084BD8A")
    protected TestCaseClassLoader createLoader() {
TestCaseClassLoader var9FDAA0A7F10327187F6F54690C1C504D_846544899 =         new TestCaseClassLoader();
        var9FDAA0A7F10327187F6F54690C1C504D_846544899.addTaint(taint);
        return var9FDAA0A7F10327187F6F54690C1C504D_846544899;
        // ---------- Original Method ----------
        //return new TestCaseClassLoader();
    }

    
}

