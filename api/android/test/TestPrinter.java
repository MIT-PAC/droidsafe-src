package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import junit.framework.Test;
import junit.framework.TestListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestPrinter implements TestRunner.Listener, TestListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.955 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "0950070738D23525D6B35F116326FC98")

    private String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.955 -0400", hash_original_field = "05174D2D3F3D7323E3B3CAF5EAF7FC22", hash_generated_field = "D67B025BE99076C0AEC784CAEC5187EC")

    private boolean mOnlyFailures;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.955 -0400", hash_original_field = "D48F171902C44EB957A91769674E1E44", hash_generated_field = "43F51331B3B228C3F97F168E07DB7958")

    private Set<String> mFailedTests = new HashSet<String>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.955 -0400", hash_original_method = "010DF77671E7451D539C1A1ED260A711", hash_generated_method = "ECB8B5D16F057CEE59B5F91E35E0E96F")
    public  TestPrinter(String tag, boolean onlyFailures) {
        mTag = tag;
        mOnlyFailures = onlyFailures;
        // ---------- Original Method ----------
        //mTag = tag;
        //mOnlyFailures = onlyFailures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.956 -0400", hash_original_method = "E06339C02C504CC3FAA7279EC2EB70ED", hash_generated_method = "580CC8FE307EDF279E8D9A2DFF389010")
    public void started(String className) {
        addTaint(className.getTaint());
        if(!mOnlyFailures)        
        {
        } //End block
        // ---------- Original Method ----------
        //if (!mOnlyFailures) {
            //Log.i(mTag, "started: " + className);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.956 -0400", hash_original_method = "A637691B3B8AEBA7A141121B8C754CCE", hash_generated_method = "B16ED65B5D6784B06A6B69D577C6A797")
    public void finished(String className) {
        addTaint(className.getTaint());
        if(!mOnlyFailures)        
        {
        } //End block
        // ---------- Original Method ----------
        //if (!mOnlyFailures) {
            //Log.i(mTag, "finished: " + className);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.957 -0400", hash_original_method = "B2685BDD7BE77F914E4C82EABA989E29", hash_generated_method = "E5C28A13568603E58F43B20BBDD7FB48")
    public void performance(String className,
            long itemTimeNS, int iterations,
            List<TestRunner.IntermediateTime> intermediates) {
        addTaint(intermediates.getTaint());
        addTaint(iterations);
        addTaint(itemTimeNS);
        addTaint(className.getTaint());
        if(intermediates != null && intermediates.size() > 0)        
        {
            int N = intermediates.size();
for(int i = 0;i < N;i++)
            {
                TestRunner.IntermediateTime time = intermediates.get(i);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Log.i(mTag, "perf: " + className + " = " + itemTimeNS + "ns/op (done "
                //+ iterations + " times)");
        //if (intermediates != null && intermediates.size() > 0) {
            //int N = intermediates.size();
            //for (int i = 0; i < N; i++) {
                //TestRunner.IntermediateTime time = intermediates.get(i);
                //Log.i(mTag, "  intermediate: " + time.name + " = "
                        //+ time.timeInNS + "ns");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.957 -0400", hash_original_method = "5072DD826312EEF17B7A7B5FAAAB7302", hash_generated_method = "65C325CDBC9594A02B2720725AC323B4")
    public void passed(String className) {
        addTaint(className.getTaint());
        if(!mOnlyFailures)        
        {
        } //End block
        // ---------- Original Method ----------
        //if (!mOnlyFailures) {
            //Log.i(mTag, "passed: " + className);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.957 -0400", hash_original_method = "D902D41E4C6FD22C0B1D6E930A2C1AB8", hash_generated_method = "CE3512C136B066A78D88CF6BD1F7158F")
    public void failed(String className, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(className.getTaint());
        // ---------- Original Method ----------
        //Log.i(mTag, "failed: " + className);
        //Log.i(mTag, "----- begin exception -----");
        //Log.i(mTag, "", exception);
        //Log.i(mTag, "----- end exception -----");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.958 -0400", hash_original_method = "0F028E9D9A8A52FB5170BD338555A5CA", hash_generated_method = "7D9CDE168A06D870A023E3AF7831B394")
    private void failed(Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        mFailedTests.add(test.toString());
        failed(test.toString(), t);
        // ---------- Original Method ----------
        //mFailedTests.add(test.toString());
        //failed(test.toString(), t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.958 -0400", hash_original_method = "1E3C7F99E2FE911AAE2037D2C1A02075", hash_generated_method = "07A05529501B9584821EE27ED643000F")
    public void addError(Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        failed(test, t);
        // ---------- Original Method ----------
        //failed(test, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.958 -0400", hash_original_method = "17AB2A4F5954BF1EFBDAF2C01475EBF7", hash_generated_method = "9F1C96FE2CF05751D96B07F88E50F947")
    public void addFailure(Test test, junit.framework.AssertionFailedError t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        failed(test, t);
        // ---------- Original Method ----------
        //failed(test, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.958 -0400", hash_original_method = "52E622B6CB13E4F1EF7E8AD1CD040C3D", hash_generated_method = "414691E98C08E50509996E43CC9F48EA")
    public void endTest(Test test) {
        addTaint(test.getTaint());
        finished(test.toString());
        if(!mFailedTests.contains(test.toString()))        
        {
            passed(test.toString());
        } //End block
        mFailedTests.remove(test.toString());
        // ---------- Original Method ----------
        //finished(test.toString());
        //if (!mFailedTests.contains(test.toString())) {
            //passed(test.toString());
        //}
        //mFailedTests.remove(test.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.959 -0400", hash_original_method = "9C3D54F0595A1B65649E868CBC4ED418", hash_generated_method = "A36113ABAB5BED207577618DF8691D6B")
    public void startTest(Test test) {
        addTaint(test.getTaint());
        started(test.toString());
        // ---------- Original Method ----------
        //started(test.toString());
    }

    
}

