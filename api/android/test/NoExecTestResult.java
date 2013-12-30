package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import junit.framework.TestCase;
import junit.framework.TestResult;


class NoExecTestResult extends TestResult {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.779 -0400", hash_original_method = "07F1A2CB1736DDDF316171589F812DEE", hash_generated_method = "07F1A2CB1736DDDF316171589F812DEE")
    public NoExecTestResult ()
    {
        //Synthesized constructor
    }

    /**
     * Override parent to just inform listeners of test,
     * and skip test execution.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.856 -0500", hash_original_method = "89F3D03C5156AFAF550D3AA0FD377E62", hash_generated_method = "58233B713A68AFA01F3A12659B0F4385")
    
@Override
    protected void run(final TestCase test) {
        startTest(test);
        endTest(test);
    }

    
}

