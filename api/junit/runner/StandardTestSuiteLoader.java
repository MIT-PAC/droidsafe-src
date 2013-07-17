package junit.runner;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class StandardTestSuiteLoader implements TestSuiteLoader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.406 -0400", hash_original_method = "5793FEEF6F25BC48377D1976D0FE8F1B", hash_generated_method = "5793FEEF6F25BC48377D1976D0FE8F1B")
    public StandardTestSuiteLoader ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.407 -0400", hash_original_method = "F2FF7EF8A0DC7477BB00BBE8F4736B84", hash_generated_method = "4834E7FF5575D3CAABA9D80AF758F1D4")
    public Class load(String suiteClassName) throws ClassNotFoundException {
        addTaint(suiteClassName.getTaint());
Class varC556F2A00B4C4BB2A37375D22F96F14B_645104875 =         Class.forName(suiteClassName);
        varC556F2A00B4C4BB2A37375D22F96F14B_645104875.addTaint(taint);
        return varC556F2A00B4C4BB2A37375D22F96F14B_645104875;
        // ---------- Original Method ----------
        //return Class.forName(suiteClassName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.407 -0400", hash_original_method = "340959DA3DE1E05DD508233637BBAF32", hash_generated_method = "85024390F03ADF392398B6F6C175DF52")
    public Class reload(Class aClass) throws ClassNotFoundException {
        addTaint(aClass.getTaint());
Class var64B0AF35677BC764C6785E0AC5EDA6B6_1589496197 =         aClass;
        var64B0AF35677BC764C6785E0AC5EDA6B6_1589496197.addTaint(taint);
        return var64B0AF35677BC764C6785E0AC5EDA6B6_1589496197;
        // ---------- Original Method ----------
        //return aClass;
    }

    
}

