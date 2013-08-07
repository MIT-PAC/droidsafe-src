package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import junit.framework.TestCase;
import junit.framework.TestResult;


class NoExecTestResult extends TestResult {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.779 -0400", hash_original_method = "07F1A2CB1736DDDF316171589F812DEE", hash_generated_method = "07F1A2CB1736DDDF316171589F812DEE")
    public NoExecTestResult ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.780 -0400", hash_original_method = "89F3D03C5156AFAF550D3AA0FD377E62", hash_generated_method = "69560D9A3517E63B0B46968A100C410A")
    @Override
    protected void run(final TestCase test) {
        addTaint(test.getTaint());
        startTest(test);
        endTest(test);
        // ---------- Original Method ----------
        //startTest(test);
        //endTest(test);
    }

    
}

