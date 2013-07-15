package junit.runner;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class StandardTestSuiteLoader implements TestSuiteLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.395 -0400", hash_original_method = "5793FEEF6F25BC48377D1976D0FE8F1B", hash_generated_method = "5793FEEF6F25BC48377D1976D0FE8F1B")
    public StandardTestSuiteLoader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.395 -0400", hash_original_method = "F2FF7EF8A0DC7477BB00BBE8F4736B84", hash_generated_method = "CFED99BAABC5D2502CFD35EEE74EE40E")
    public Class load(String suiteClassName) throws ClassNotFoundException {
        addTaint(suiteClassName.getTaint());
Class varC556F2A00B4C4BB2A37375D22F96F14B_304666649 =         Class.forName(suiteClassName);
        varC556F2A00B4C4BB2A37375D22F96F14B_304666649.addTaint(taint);
        return varC556F2A00B4C4BB2A37375D22F96F14B_304666649;
        // ---------- Original Method ----------
        //return Class.forName(suiteClassName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.396 -0400", hash_original_method = "340959DA3DE1E05DD508233637BBAF32", hash_generated_method = "DD77446817BF6A7D131359398500568B")
    public Class reload(Class aClass) throws ClassNotFoundException {
        addTaint(aClass.getTaint());
Class var64B0AF35677BC764C6785E0AC5EDA6B6_1786116602 =         aClass;
        var64B0AF35677BC764C6785E0AC5EDA6B6_1786116602.addTaint(taint);
        return var64B0AF35677BC764C6785E0AC5EDA6B6_1786116602;
        // ---------- Original Method ----------
        //return aClass;
    }

    
}

