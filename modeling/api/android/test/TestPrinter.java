package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestListener;

public class TestPrinter implements TestRunner.Listener, TestListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.364 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.366 -0500", hash_original_field = "479F548365C640D5CE2440749BC6DC00", hash_generated_field = "D67B025BE99076C0AEC784CAEC5187EC")

    private boolean mOnlyFailures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.368 -0500", hash_original_field = "DAD3F572FF1DE2D1F1189FE61882992C", hash_generated_field = "43F51331B3B228C3F97F168E07DB7958")

    private Set<String> mFailedTests = new HashSet<String>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.370 -0500", hash_original_method = "010DF77671E7451D539C1A1ED260A711", hash_generated_method = "DF83188D32955D958A6A9165437BB958")
    
public TestPrinter(String tag, boolean onlyFailures) {
        mTag = tag;
        mOnlyFailures = onlyFailures;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.372 -0500", hash_original_method = "E06339C02C504CC3FAA7279EC2EB70ED", hash_generated_method = "CBB7BE3B2ED19CBBA851CEDF1B5FE2F1")
    
public void started(String className) {
        if (!mOnlyFailures) {
            Log.i(mTag, "started: " + className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.375 -0500", hash_original_method = "A637691B3B8AEBA7A141121B8C754CCE", hash_generated_method = "C32C341BE696B16BBAC98985F9277434")
    
public void finished(String className) {
        if (!mOnlyFailures) {
            Log.i(mTag, "finished: " + className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.378 -0500", hash_original_method = "B2685BDD7BE77F914E4C82EABA989E29", hash_generated_method = "12C69C2E7A43A39AA2FB44B57DCCF931")
    
public void performance(String className,
            long itemTimeNS, int iterations,
            List<TestRunner.IntermediateTime> intermediates) {
        Log.i(mTag, "perf: " + className + " = " + itemTimeNS + "ns/op (done "
                + iterations + " times)");
        if (intermediates != null && intermediates.size() > 0) {
            int N = intermediates.size();
            for (int i = 0; i < N; i++) {
                TestRunner.IntermediateTime time = intermediates.get(i);
                Log.i(mTag, "  intermediate: " + time.name + " = "
                        + time.timeInNS + "ns");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.380 -0500", hash_original_method = "5072DD826312EEF17B7A7B5FAAAB7302", hash_generated_method = "FEF6A945899B11101C0758966AD589CF")
    
public void passed(String className) {
        if (!mOnlyFailures) {
            Log.i(mTag, "passed: " + className);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.382 -0500", hash_original_method = "D902D41E4C6FD22C0B1D6E930A2C1AB8", hash_generated_method = "8D3F425C903926B06DED28160F7AB6AE")
    
public void failed(String className, Throwable exception) {
        Log.i(mTag, "failed: " + className);
        Log.i(mTag, "----- begin exception -----");
        Log.i(mTag, "", exception);
        Log.i(mTag, "----- end exception -----");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.384 -0500", hash_original_method = "0F028E9D9A8A52FB5170BD338555A5CA", hash_generated_method = "16C6D01EBA455E3FC51C34CA8D385850")
    
private void failed(Test test, Throwable t) {
        mFailedTests.add(test.toString());
        failed(test.toString(), t);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.386 -0500", hash_original_method = "1E3C7F99E2FE911AAE2037D2C1A02075", hash_generated_method = "1319D76DD409BE7E84B626A78BFCC507")
    
public void addError(Test test, Throwable t) {
        failed(test, t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.389 -0500", hash_original_method = "17AB2A4F5954BF1EFBDAF2C01475EBF7", hash_generated_method = "44FFABABB746769305D799CD9C77BDE0")
    
public void addFailure(Test test, junit.framework.AssertionFailedError t) {
        failed(test, t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.391 -0500", hash_original_method = "52E622B6CB13E4F1EF7E8AD1CD040C3D", hash_generated_method = "12AFFE491642B92F42F35A011003713B")
    
public void endTest(Test test) {
        finished(test.toString());
        if (!mFailedTests.contains(test.toString())) {
            passed(test.toString());
        }
        mFailedTests.remove(test.toString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:41.393 -0500", hash_original_method = "9C3D54F0595A1B65649E868CBC4ED418", hash_generated_method = "8087CC459E08AECC6FFBD408BE1350CB")
    
public void startTest(Test test) {
        started(test.toString());
    }
    
}

