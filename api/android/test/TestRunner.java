package android.test;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import android.util.Log;

import com.google.android.collect.Lists;






public class TestRunner implements PerformanceTestCase.Intermediates {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "772110959FF50CB3375732972682630F", hash_generated_field = "80ECCE0FDB54A0C0B71FD5563F9A3BBA")

    private int mMode = REGRESSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "6BF941C4127C989F9AF043F95221948E", hash_generated_field = "816900AFC4C5F99896FEFAE236AAAC3D")

    private List<Listener> mListeners = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "BD3E147FF22ECCD5153F0A5E9B1D2945", hash_generated_field = "9748ECEB0653B84A525176F637D38ECD")

    private int mPassed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "0902E9DB58B13DD3F11BEA37160A278B", hash_generated_field = "D2FC3B99B8E5BAFB19EEF8C8952014A9")

    private int mFailed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "A48D9F4640FED1D584BDAC37375EA09D", hash_generated_field = "3A78B0C220AA631D9D09212ECCBE44E3")

    private int mInternalIterations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

    private long mStartTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "A0F28E4F5A99C619D8D824EA80594134", hash_generated_field = "CE198E728D2042BC4D1888DF0457D27B")

    private long mEndTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "DB6E5647C7C137158D39EAA9BCFFCF3D")

    private String mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.027 -0400", hash_original_field = "FE3ABDDA3BB73A4B1A7F3FA98E33BE6B", hash_generated_field = "2084C12375BBD761F459C848AEF2620C")

    List<IntermediateTime> mIntermediates = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.028 -0400", hash_original_method = "8950AB5377F72756EC0D34993CFF0108", hash_generated_method = "BF65C91F46D7F52B37ED4DA8D623D17F")
    public  TestRunner(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.028 -0400", hash_original_method = "61C23687EE46D7DD02D0495C15E55FFB", hash_generated_method = "6DB471C1DD6B3F0A8491E620ABD89A80")
    public void addListener(Listener listener) {
        addTaint(listener.getTaint());
        mListeners.add(listener);
        // ---------- Original Method ----------
        //mListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.028 -0400", hash_original_method = "C501B549FBBC2113A15CD58FA347FDD6", hash_generated_method = "2D3F33E4F58C5DB0D581E1D5CC825CF0")
    public void startProfiling() {
        File file = new File("/tmp/trace");
        file.mkdir();
        String base = "/tmp/trace/" + mClassName + ".dmtrace";
        Debug.startMethodTracing(base, 8 * 1024 * 1024);
        // ---------- Original Method ----------
        //File file = new File("/tmp/trace");
        //file.mkdir();
        //String base = "/tmp/trace/" + mClassName + ".dmtrace";
        //Debug.startMethodTracing(base, 8 * 1024 * 1024);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.028 -0400", hash_original_method = "4696774C6D9FEF3FF4454E20DBB64304", hash_generated_method = "07899BFCC26D1E02E53077B2B0C266AE")
    public void finishProfiling() {
        Debug.stopMethodTracing();
        // ---------- Original Method ----------
        //Debug.stopMethodTracing();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.029 -0400", hash_original_method = "8C5BFDCF70A85F458A74E20506CDCA9E", hash_generated_method = "7F30D9C133AD14A59581E5576BFE7D1F")
    private void started(String className) {
        addTaint(className.getTaint());
        int count = mListeners.size();
for(int i = 0;i < count;i++)
        {
            mListeners.get(i).started(className);
        } //End block
        // ---------- Original Method ----------
        //int count = mListeners.size();
        //for (int i = 0; i < count; i++) {
            //mListeners.get(i).started(className);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.029 -0400", hash_original_method = "9B2F60619B845977C468209ECD59C4E6", hash_generated_method = "A37A196601166E52929D5B5468BAABAC")
    private void finished(String className) {
        addTaint(className.getTaint());
        int count = mListeners.size();
for(int i = 0;i < count;i++)
        {
            mListeners.get(i).finished(className);
        } //End block
        // ---------- Original Method ----------
        //int count = mListeners.size();
        //for (int i = 0; i < count; i++) {
            //mListeners.get(i).finished(className);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.029 -0400", hash_original_method = "5B73476158BD043DA3960AAE5CE325A6", hash_generated_method = "C95FBD16B6756A0AC595F9A0D21108D6")
    private void performance(String className,
            long itemTimeNS,
            int iterations,
            List<IntermediateTime> intermediates) {
        addTaint(intermediates.getTaint());
        addTaint(iterations);
        addTaint(itemTimeNS);
        addTaint(className.getTaint());
        int count = mListeners.size();
for(int i = 0;i < count;i++)
        {
            mListeners.get(i).performance(className,
                    itemTimeNS,
                    iterations,
                    intermediates);
        } //End block
        // ---------- Original Method ----------
        //int count = mListeners.size();
        //for (int i = 0; i < count; i++) {
            //mListeners.get(i).performance(className,
                    //itemTimeNS,
                    //iterations,
                    //intermediates);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.030 -0400", hash_original_method = "D08F267184DA26F05ED8D6C7FCFE1B8E", hash_generated_method = "87186763FC3EC651E5F7AD90204F2089")
    public void passed(String className) {
        addTaint(className.getTaint());
        mPassed++;
        int count = mListeners.size();
for(int i = 0;i < count;i++)
        {
            mListeners.get(i).passed(className);
        } //End block
        // ---------- Original Method ----------
        //mPassed++;
        //int count = mListeners.size();
        //for (int i = 0; i < count; i++) {
            //mListeners.get(i).passed(className);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.030 -0400", hash_original_method = "D24139E2E0001F60D0C816A9C2E55057", hash_generated_method = "5ABB3C192866038614EA60AF79AAF32D")
    public void failed(String className, Throwable exception) {
        addTaint(exception.getTaint());
        addTaint(className.getTaint());
        mFailed++;
        int count = mListeners.size();
for(int i = 0;i < count;i++)
        {
            mListeners.get(i).failed(className, exception);
        } //End block
        // ---------- Original Method ----------
        //mFailed++;
        //int count = mListeners.size();
        //for (int i = 0; i < count; i++) {
            //mListeners.get(i).failed(className, exception);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.030 -0400", hash_original_method = "0B532C5E5191073233FEF0FB3B24844F", hash_generated_method = "A2748E7FA541F02A09D997354E3DD6DA")
    public int passedCount() {
        int varBD3E147FF22ECCD5153F0A5E9B1D2945_434733989 = (mPassed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545611585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_545611585;
        // ---------- Original Method ----------
        //return mPassed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.031 -0400", hash_original_method = "0CCEB79CE1070F202583C9915927C804", hash_generated_method = "A505FAB4590FF19EF38294106A3F19FF")
    public int failedCount() {
        int var0902E9DB58B13DD3F11BEA37160A278B_1818575499 = (mFailed);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471223555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_471223555;
        // ---------- Original Method ----------
        //return mFailed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.031 -0400", hash_original_method = "EA958BED91E5807BE44C3475743952DB", hash_generated_method = "1FDDED67C124ADAA0D686EE0313A7EA1")
    public void run(String[] classes) {
        addTaint(classes[0].getTaint());
for(String cl : classes)
        {
            run(cl);
        } //End block
        // ---------- Original Method ----------
        //for (String cl : classes) {
            //run(cl);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.032 -0400", hash_original_method = "53E84480F070131E858702808FE92767", hash_generated_method = "DC4449037DFCBD6DB5FA61FD72D77725")
    public void setInternalIterations(int count) {
        mInternalIterations = count;
        // ---------- Original Method ----------
        //mInternalIterations = count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.032 -0400", hash_original_method = "AD98F48B4895306C22AD1BDE79779428", hash_generated_method = "EBF7F3E459298B4E1EA1FE396A838391")
    public void startTiming(boolean realTime) {
        addTaint(realTime);
        if(realTime)        
        {
            mStartTime = System.currentTimeMillis();
        } //End block
        else
        {
            mStartTime = SystemClock.currentThreadTimeMillis();
        } //End block
        // ---------- Original Method ----------
        //if (realTime) {
            //mStartTime = System.currentTimeMillis();
        //} else {
            //mStartTime = SystemClock.currentThreadTimeMillis();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.032 -0400", hash_original_method = "AF5C16E27EBEA087CBAF6BDFC1FB8A45", hash_generated_method = "2C5E1E5108D007D8B61752C5811F22D0")
    public void addIntermediate(String name) {
        addTaint(name.getTaint());
        addIntermediate(name, (System.currentTimeMillis() - mStartTime) * 1000000);
        // ---------- Original Method ----------
        //addIntermediate(name, (System.currentTimeMillis() - mStartTime) * 1000000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.033 -0400", hash_original_method = "09734AD7C7F83A96723D7181F208AECD", hash_generated_method = "3F6D5A2BAAEB6925BFF994BA374A73F9")
    public void addIntermediate(String name, long timeInNS) {
        addTaint(timeInNS);
        addTaint(name.getTaint());
        mIntermediates.add(new IntermediateTime(name, timeInNS));
        // ---------- Original Method ----------
        //mIntermediates.add(new IntermediateTime(name, timeInNS));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.033 -0400", hash_original_method = "EAD0F494E7194587949578C1412758D9", hash_generated_method = "170A236BD8C2D2D62EBB0763137979BA")
    public void finishTiming(boolean realTime) {
        addTaint(realTime);
        if(realTime)        
        {
            mEndTime = System.currentTimeMillis();
        } //End block
        else
        {
            mEndTime = SystemClock.currentThreadTimeMillis();
        } //End block
        // ---------- Original Method ----------
        //if (realTime) {
            //mEndTime = System.currentTimeMillis();
        //} else {
            //mEndTime = SystemClock.currentThreadTimeMillis();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.033 -0400", hash_original_method = "EC5A911B7459E56F5BCB8B3F76085E8F", hash_generated_method = "ABEA4E480EED3CE327E9D593E33EF0F7")
    public void setPerformanceMode(int mode) {
        mMode = mode;
        // ---------- Original Method ----------
        //mMode = mode;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.033 -0400", hash_original_method = "A32FEAB2DFA07740C77FDABE5769E691", hash_generated_method = "74E98EC51E88FEEADB0A5CA41DCB20EE")
    private void missingTest(String className, Throwable e) {
        addTaint(e.getTaint());
        addTaint(className.getTaint());
        started(className);
        finished(className);
        failed(className, e);
        // ---------- Original Method ----------
        //started(className);
        //finished(className);
        //failed(className, e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.035 -0400", hash_original_method = "708D6F0A09F91E4686ADAFFE08052780", hash_generated_method = "E412D96311C46134BE7558FE59B5500A")
    public void run(String className) {
        try 
        {
            mClassName = className;
            Class clazz = mContext.getClassLoader().loadClass(className);
            Method method = getChildrenMethod(clazz);
            if(method != null)            
            {
                String[] children = getChildren(method);
                run(children);
            } //End block
            else
            if(mRunnableClass.isAssignableFrom(clazz))            
            {
                Runnable test = (Runnable) clazz.newInstance();
                TestCase testcase = null;
                if(test instanceof TestCase)                
                {
                    testcase = (TestCase) test;
                } //End block
                Throwable e = null;
                boolean didSetup = false;
                started(className);
                try 
                {
                    if(testcase != null)                    
                    {
                        testcase.setUp(mContext);
                        didSetup = true;
                    } //End block
                    if(mMode == PERFORMANCE)                    
                    {
                        runInPerformanceMode(test, className, false, className);
                    } //End block
                    else
                    if(mMode == PROFILING)                    
                    {
                        startProfiling();
                        test.run();
                        finishProfiling();
                    } //End block
                    else
                    {
                        test.run();
                    } //End block
                } //End block
                catch (Throwable ex)
                {
                    e = ex;
                } //End block
                if(testcase != null && didSetup)                
                {
                    try 
                    {
                        testcase.tearDown();
                    } //End block
                    catch (Throwable ex)
                    {
                        e = ex;
                    } //End block
                } //End block
                finished(className);
                if(e == null)                
                {
                    passed(className);
                } //End block
                else
                {
                    failed(className, e);
                } //End block
            } //End block
            else
            if(mJUnitClass.isAssignableFrom(clazz))            
            {
                Throwable e = null;
                JunitTestSuite suite = new JunitTestSuite();
                Method[] methods = getAllTestMethods(clazz);
for(Method m : methods)
                {
                    junit.framework.TestCase test = (junit.framework.TestCase) clazz.newInstance();
                    test.setName(m.getName());
                    if(test instanceof AndroidTestCase)                    
                    {
                        AndroidTestCase testcase = (AndroidTestCase) test;
                        try 
                        {
                            testcase.setContext(mContext);
                            testcase.setTestContext(mContext);
                        } //End block
                        catch (Exception ex)
                        {
                        } //End block
                    } //End block
                    suite.addTest(test);
                } //End block
                if(mMode == PERFORMANCE)                
                {
                    final int testCount = suite.testCount();
for(int j = 0;j < testCount;j++)
                    {
                        Test test = suite.testAt(j);
                        started(test.toString());
                        try 
                        {
                            runInPerformanceMode(test, className, true, test.toString());
                        } //End block
                        catch (Throwable ex)
                        {
                            e = ex;
                        } //End block
                        finished(test.toString());
                        if(e == null)                        
                        {
                            passed(test.toString());
                        } //End block
                        else
                        {
                            failed(test.toString(), e);
                        } //End block
                    } //End block
                } //End block
                else
                if(mMode == PROFILING)                
                {
                    startProfiling();
                    junit.textui.TestRunner.run(suite);
                    finishProfiling();
                } //End block
                else
                {
                    junit.textui.TestRunner.run(suite);
                } //End block
            } //End block
            else
            {
                System.out.println("Test wasn't Runnable and didn't have a"
                        + " children method: " + className);
            } //End block
        } //End block
        catch (ClassNotFoundException e)
        {
            if(isJunitTest(className))            
            {
                runSingleJunitTest(className);
            } //End block
            else
            {
                missingTest(className, e);
            } //End block
        } //End block
        catch (InstantiationException e)
        {
            System.out.println("InstantiationException for " + className);
            missingTest(className, e);
        } //End block
        catch (IllegalAccessException e)
        {
            System.out.println("IllegalAccessException for " + className);
            missingTest(className, e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.038 -0400", hash_original_method = "AC853D74759560DF742A57C630FB68EF", hash_generated_method = "1CD0EF6B04BDA285C0351E8330D9B076")
    public void runInPerformanceMode(Object testCase, String className, boolean junitTest,
            String testNameInDb) throws Exception {
        addTaint(testNameInDb.getTaint());
        addTaint(junitTest);
        addTaint(className.getTaint());
        addTaint(testCase.getTaint());
        boolean increaseIterations = true;
        int iterations = 1;
        long duration = 0;
        mIntermediates = null;
        mInternalIterations = 1;
        Class clazz = mContext.getClassLoader().loadClass(className);
        Object perftest = clazz.newInstance();
        PerformanceTestCase perftestcase = null;
        if(perftest instanceof PerformanceTestCase)        
        {
            perftestcase = (PerformanceTestCase) perftest;
            if(mMode == REGRESSION && perftestcase.isPerformanceOnly())            
            return;
        } //End block
        Runtime.getRuntime().runFinalization();
        Runtime.getRuntime().gc();
        if(perftestcase != null)        
        {
            mIntermediates = new ArrayList<IntermediateTime>();
            iterations = perftestcase.startPerformance(this);
            if(iterations > 0)            
            {
                increaseIterations = false;
            } //End block
            else
            {
                iterations = 1;
            } //End block
        } //End block
        Thread.sleep(1000);
        do {
            {
                mEndTime = 0;
                if(increaseIterations)                
                {
                    mStartTime = SystemClock.currentThreadTimeMillis();
                } //End block
                else
                {
                    mStartTime = 0;
                } //End block
                if(junitTest)                
                {
for(int i = 0;i < iterations;i++)
                    {
                        junit.textui.TestRunner.run((junit.framework.Test) testCase);
                    } //End block
                } //End block
                else
                {
                    Runnable test = (Runnable) testCase;
for(int i = 0;i < iterations;i++)
                    {
                        test.run();
                    } //End block
                } //End block
                long endTime = mEndTime;
                if(endTime == 0)                
                {
                    endTime = SystemClock.currentThreadTimeMillis();
                } //End block
                duration = endTime - mStartTime;
                if(!increaseIterations)                
                {
                    break;
                } //End block
                if(duration <= 1)                
                {
                    iterations *= 1000;
                } //End block
                else
                if(duration <= 10)                
                {
                    iterations *= 100;
                } //End block
                else
                if(duration < 100)                
                {
                    iterations *= 10;
                } //End block
                else
                if(duration < 1000)                
                {
                    iterations *= (int) ((1000 / duration) + 2);
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
} while (true);
        if(duration != 0)        
        {
            iterations *= mInternalIterations;
            performance(testNameInDb, (duration * 1000000) / iterations,
                    iterations, mIntermediates);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.039 -0400", hash_original_method = "52331F5635218FF0736B4BCBA4AD33A3", hash_generated_method = "9EE00F4CAB5583851ADDB87A8604186C")
    public void runSingleJunitTest(String className) {
        addTaint(className.getTaint());
        Throwable excep = null;
        int index = className.lastIndexOf('$');
        String testName = "";
        String originalClassName = className;
        if(index >= 0)        
        {
            className = className.substring(0, index);
            testName = originalClassName.substring(index + 1);
        } //End block
        try 
        {
            Class clazz = mContext.getClassLoader().loadClass(className);
            if(mJUnitClass.isAssignableFrom(clazz))            
            {
                junit.framework.TestCase test = (junit.framework.TestCase) clazz.newInstance();
                JunitTestSuite newSuite = new JunitTestSuite();
                test.setName(testName);
                if(test instanceof AndroidTestCase)                
                {
                    AndroidTestCase testcase = (AndroidTestCase) test;
                    try 
                    {
                        testcase.setContext(mContext);
                    } //End block
                    catch (Exception ex)
                    {
                    } //End block
                } //End block
                newSuite.addTest(test);
                if(mMode == PERFORMANCE)                
                {
                    try 
                    {
                        started(test.toString());
                        runInPerformanceMode(test, className, true, test.toString());
                        finished(test.toString());
                        if(excep == null)                        
                        {
                            passed(test.toString());
                        } //End block
                        else
                        {
                            failed(test.toString(), excep);
                        } //End block
                    } //End block
                    catch (Throwable ex)
                    {
                        excep = ex;
                    } //End block
                } //End block
                else
                if(mMode == PROFILING)                
                {
                    startProfiling();
                    junit.textui.TestRunner.run(newSuite);
                    finishProfiling();
                } //End block
                else
                {
                    junit.textui.TestRunner.run(newSuite);
                } //End block
            } //End block
        } //End block
        catch (ClassNotFoundException e)
        {
        } //End block
        catch (IllegalAccessException e)
        {
        } //End block
        catch (InstantiationException e)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static Method getChildrenMethod(Class clazz) {
        try {
            return clazz.getMethod("children", (Class[]) null);
        } catch (NoSuchMethodException e) {
        }
        return null;
    }

    
    public static Method getChildrenMethod(Context c, String className) {
        try {
            return getChildrenMethod(c.getClassLoader().loadClass(className));
        } catch (ClassNotFoundException e) {
        }
        return null;
    }

    
    public static String[] getChildren(Context c, String className) {
        Method m = getChildrenMethod(c, className);
        String[] testChildren = getTestChildren(c, className);
        if (m == null & testChildren == null) {
            throw new RuntimeException("couldn't get children method for "
                    + className);
        }
        if (m != null) {
            String[] children = getChildren(m);
            if (testChildren != null) {
                String[] allChildren = new String[testChildren.length + children.length];
                System.arraycopy(children, 0, allChildren, 0, children.length);
                System.arraycopy(testChildren, 0, allChildren, children.length, testChildren.length);
                return allChildren;
            } else {
                return children;
            }
        } else {
            if (testChildren != null) {
                return testChildren;
            }
        }
        return null;
    }

    
    public static String[] getChildren(Method m) {
        try {
            if (!Modifier.isStatic(m.getModifiers())) {
                throw new RuntimeException("children method is not static");
            }
            return (String[]) m.invoke(null, (Object[]) null);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        return new String[0];
    }

    
    public static String[] getTestChildren(Context c, String className) {
        try {
            Class clazz = c.getClassLoader().loadClass(className);
            if (mJUnitClass.isAssignableFrom(clazz)) {
                return getTestChildren(clazz);
            }
        } catch (ClassNotFoundException e) {
            Log.e("TestHarness", "No class found", e);
        }
        return null;
    }

    
    public static String[] getTestChildren(Class clazz) {
        Method[] methods = getAllTestMethods(clazz);
        String[] onScreenTestNames = new String[methods.length];
        int index = 0;
        for (Method m : methods) {
            onScreenTestNames[index] = clazz.getName() + "$" + m.getName();
            index++;
        }
        return onScreenTestNames;
    }

    
    public static Method[] getAllTestMethods(Class clazz) {
        Method[] allMethods = clazz.getDeclaredMethods();
        int numOfMethods = 0;
        for (Method m : allMethods) {
            boolean mTrue = isTestMethod(m);
            if (mTrue) {
                numOfMethods++;
            }
        }
        int index = 0;
        Method[] testMethods = new Method[numOfMethods];
        for (Method m : allMethods) {
            boolean mTrue = isTestMethod(m);
            if (mTrue) {
                testMethods[index] = m;
                index++;
            }
        }
        return testMethods;
    }

    
    @DSModeled(DSC.BAN)
    private static boolean isTestMethod(Method m) {
        return m.getName().startsWith("test") &&
                m.getReturnType() == void.class &&
                m.getParameterTypes().length == 0;
    }

    
    public static int countJunitTests(Class clazz) {
        Method[] allTestMethods = getAllTestMethods(clazz);
        int numberofMethods = allTestMethods.length;
        return numberofMethods;
    }

    
    public static boolean isTestSuite(Context c, String className) {
        boolean childrenMethods = getChildrenMethod(c, className) != null;
        try {
            Class clazz = c.getClassLoader().loadClass(className);
            if (mJUnitClass.isAssignableFrom(clazz)) {
                int numTests = countJunitTests(clazz);
                if (numTests > 0)
                    childrenMethods = true;
            }
        } catch (ClassNotFoundException e) {
        }
        return childrenMethods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.042 -0400", hash_original_method = "B693F140B371F7E4D9D6941B4BAAAF7A", hash_generated_method = "F2ED4040EBC7E22F44ED04170A8E35CF")
    public boolean isJunitTest(String className) {
        addTaint(className.getTaint());
        int index = className.lastIndexOf('$');
        if(index >= 0)        
        {
            className = className.substring(0, index);
        } //End block
        try 
        {
            Class clazz = mContext.getClassLoader().loadClass(className);
            if(mJUnitClass.isAssignableFrom(clazz))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1510201092 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1387147035 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1387147035;
            } //End block
        } //End block
        catch (ClassNotFoundException e)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_225256815 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487472962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487472962;
        // ---------- Original Method ----------
        //int index = className.lastIndexOf('$');
        //if (index >= 0) {
            //className = className.substring(0, index);
        //}
        //try {
            //Class clazz = mContext.getClassLoader().loadClass(className);
            //if (mJUnitClass.isAssignableFrom(clazz)) {
                //return true;
            //}
        //} catch (ClassNotFoundException e) {
        //}
        //return false;
    }

    
    public static int countTests(Context c, String className) {
        try {
            Class clazz = c.getClassLoader().loadClass(className);
            Method method = getChildrenMethod(clazz);
            if (method != null) {
                String[] children = getChildren(method);
                int rv = 0;
                for (String child : children) {
                    rv += countTests(c, child);
                }
                return rv;
            } else if (mRunnableClass.isAssignableFrom(clazz)) {
                return 1;
            } else if (mJUnitClass.isAssignableFrom(clazz)) {
                return countJunitTests(clazz);
            }
        } catch (ClassNotFoundException e) {
            return 1; 
        }
        return 0;
    }

    
    public static String getTitle(String className) {
        int indexDot = className.lastIndexOf('.');
        int indexDollar = className.lastIndexOf('$');
        int index = indexDot > indexDollar ? indexDot : indexDollar;
        if (index >= 0) {
            className = className.substring(index + 1);
        }
        return className;
    }

    
    public class JunitTestSuite extends TestSuite implements TestListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.042 -0400", hash_original_field = "C750A71C64EFE13A86D8146BC51175AB", hash_generated_field = "BDA376DC770C8E971D5C7AD1F1FE1B95")

        boolean mError = false;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.042 -0400", hash_original_method = "CFFE110BDEA2EF1B39A9BF20964D075D", hash_generated_method = "170612CB63D4C2F9D6EFA48333C292DA")
        public  JunitTestSuite() {
            super();
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.042 -0400", hash_original_method = "8428289E0AE15BC8D3D04B7078FF5A2E", hash_generated_method = "88E5412EC565AA5F553061CB483356A7")
        @Override
        public void run(TestResult result) {
            addTaint(result.getTaint());
            result.addListener(this);
            super.run(result);
            result.removeListener(this);
            // ---------- Original Method ----------
            //result.addListener(this);
            //super.run(result);
            //result.removeListener(this);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.042 -0400", hash_original_method = "9C3D54F0595A1B65649E868CBC4ED418", hash_generated_method = "A36113ABAB5BED207577618DF8691D6B")
        public void startTest(Test test) {
            addTaint(test.getTaint());
            started(test.toString());
            // ---------- Original Method ----------
            //started(test.toString());
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_method = "5C6758A8D60C0FE4B774FC491E0F7958", hash_generated_method = "D95CC77B8CDE0BF513BE3B303070BB5F")
        public void endTest(Test test) {
            addTaint(test.getTaint());
            finished(test.toString());
            if(!mError)            
            {
                passed(test.toString());
            } //End block
            // ---------- Original Method ----------
            //finished(test.toString());
            //if (!mError) {
                //passed(test.toString());
            //}
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_method = "0D2F0B914A04C9F7A825DB8C76DB002A", hash_generated_method = "F5F69608461726D41531AC58D402C8ED")
        public void addError(Test test, Throwable t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mError = true;
            failed(test.toString(), t);
            // ---------- Original Method ----------
            //mError = true;
            //failed(test.toString(), t);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_method = "E48FFE8D16E4AA897CF5C85DD7DE476B", hash_generated_method = "7ACE18E9DC9EABB597625653B94C5E74")
        public void addFailure(Test test, junit.framework.AssertionFailedError t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mError = true;
            failed(test.toString(), t);
            // ---------- Original Method ----------
            //mError = true;
            //failed(test.toString(), t);
        }

        
    }


    
    public static class IntermediateTime {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_field = "109690E11DFCD6E52954D8FF899DC87B", hash_generated_field = "FE74B3B074A6BBF26780BB4EDC778464")

        public long timeInNS;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.043 -0400", hash_original_method = "F156F71FB9ADDC03EC513D4C1742F860", hash_generated_method = "984641D3F3EF949BC1A1377F23262FE0")
        public  IntermediateTime(String name, long timeInNS) {
            this.name = name;
            this.timeInNS = timeInNS;
            // ---------- Original Method ----------
            //this.name = name;
            //this.timeInNS = timeInNS;
        }

        
    }


    
    public interface Listener {
        void started(String className);
        void finished(String className);
        void performance(String className,
                long itemTimeNS, int iterations,
                List<IntermediateTime> itermediates);
        void passed(String className);
        void failed(String className, Throwable execption);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "AB1D41AECEB937B400C91CD39B76F5E9", hash_generated_field = "7A19718D05B190820FC65673780FDFD3")

    public static final int REGRESSION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "A2283510F4B2223ED9843D9873C197EF", hash_generated_field = "A674225858E65D6BA5E8E1F49770AD93")

    public static final int PERFORMANCE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "1820AB2918B39397AD10F2B30C77ABD1", hash_generated_field = "122E6B6086C2B35BF409E41D4BD3F8B6")

    public static final int PROFILING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "9FF2DAB456AB44AA5F42FF11C372F9BB", hash_generated_field = "2B9C658BF3C592304842D1E3DF01DC9B")

    public static final int CLEARSCREEN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "FB7C1ED382489C5CC044C44FFF027898", hash_generated_field = "104157555C19EFF242C550E6CF8A49FB")

    private static final String TAG = "TestHarness";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "C7B004639800ACF9AF28CDB016BAAF83", hash_generated_field = "08C0FD9F34C8A57F7E692654DC2345AB")

    private static Class mRunnableClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.044 -0400", hash_original_field = "D8D5E203A2D54DF6030E89582FB47995", hash_generated_field = "55F3A7A57A174853E25B260195B61D60")

    private static Class mJUnitClass;
    static {
        try {
            mRunnableClass = Class.forName("java.lang.Runnable", false, null);
            mJUnitClass = Class.forName("junit.framework.TestCase", false, null);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("shouldn't happen", ex);
        }
    }
    
}

