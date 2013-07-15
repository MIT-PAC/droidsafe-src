package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Instrumentation;
import android.content.Context;
import android.os.PerformanceCollector.PerformanceResultsWriter;
import com.google.android.collect.Lists;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class AndroidTestRunner extends BaseTestRunner {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.799 -0400", hash_original_field = "AFBAC9716FC2073B5BFEA6A40ED35C25", hash_generated_field = "6DA683BBE787F263E5F5E79B3A62B986")

    private TestResult mTestResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.799 -0400", hash_original_field = "D6C521397458BAA8B5C127809C7EE875", hash_generated_field = "5B8CC2DB991885EB5008A645801A9BD1")

    private String mTestClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.799 -0400", hash_original_field = "2ED4118B5877939A22B338135FF316EF", hash_generated_field = "57CD2938F6E71D086604FFB94901029B")

    private List<TestCase> mTestCases;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_field = "683B51EE2461241E872BC0BA75571CEB", hash_generated_field = "6FD7A350695311DE0709E7C398EDB658")

    private boolean mSkipExecution = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_field = "9CB4F75DAF2383CB5E4CE6C101A581F1", hash_generated_field = "AED73EC002699D3069BEE18C310BB33E")

    private List<TestListener> mTestListeners = Lists.newArrayList();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_field = "26B1BECD2B69E5E2482C90E44053F874", hash_generated_field = "2E6B5EF6C826CFAA09973D53DE7A3FDC")

    private PerformanceResultsWriter mPerfWriter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_method = "2722F23348F424AF929858C44CF90573", hash_generated_method = "2722F23348F424AF929858C44CF90573")
    public AndroidTestRunner ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.800 -0400", hash_original_method = "C1F9E85AE774BF3AF2496CEC49DDE295", hash_generated_method = "76EDE852B8EB8625361EFA4F5CC3129B")
    @SuppressWarnings("unchecked")
    public void setTestClassName(String testClassName, String testMethodName) {
        addTaint(testMethodName.getTaint());
        addTaint(testClassName.getTaint());
        Class testClass = loadTestClass(testClassName);
    if(shouldRunSingleTestMethod(testMethodName, testClass))        
        {
            TestCase testCase = buildSingleTestMethod(testClass, testMethodName);
            mTestCases = Lists.newArrayList(testCase);
            mTestClassName = testClass.getSimpleName();
        } //End block
        else
        {
            setTest(getTest(testClass), testClass);
        } //End block
        // ---------- Original Method ----------
        //Class testClass = loadTestClass(testClassName);
        //if (shouldRunSingleTestMethod(testMethodName, testClass)) {
            //TestCase testCase = buildSingleTestMethod(testClass, testMethodName);
            //mTestCases = Lists.newArrayList(testCase);
            //mTestClassName = testClass.getSimpleName();
        //} else {
            //setTest(getTest(testClass), testClass);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.801 -0400", hash_original_method = "621D8E85057FEDDF5A2E0BEC9A1D4675", hash_generated_method = "D5FE32FC45621BCC192C9CB3EC2B0208")
    public void setTest(Test test) {
        addTaint(test.getTaint());
        setTest(test, test.getClass());
        // ---------- Original Method ----------
        //setTest(test, test.getClass());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.801 -0400", hash_original_method = "8A2ED2B311133489D5211F7B75C9AF00", hash_generated_method = "2511B15D278614C90540582FAE83990C")
    private void setTest(Test test, Class<? extends Test> testClass) {
        mTestCases = (List<TestCase>) TestCaseUtil.getTests(test, true);
    if(TestSuite.class.isAssignableFrom(testClass))        
        {
            mTestClassName = TestCaseUtil.getTestName(test);
        } //End block
        else
        {
            mTestClassName = testClass.getSimpleName();
        } //End block
        // ---------- Original Method ----------
        //mTestCases = (List<TestCase>) TestCaseUtil.getTests(test, true);
        //if (TestSuite.class.isAssignableFrom(testClass)) {
            //mTestClassName = TestCaseUtil.getTestName(test);
        //} else {
            //mTestClassName = testClass.getSimpleName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.802 -0400", hash_original_method = "934673426DE78D3BF4595E284314BBA0", hash_generated_method = "0391313513991CD10F2F9FB4A878CA34")
    public void clearTestListeners() {
        mTestListeners.clear();
        // ---------- Original Method ----------
        //mTestListeners.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.802 -0400", hash_original_method = "69E18BF63A69D4030ECF7F312645F69E", hash_generated_method = "E489713107907E23AD20E6B642B30217")
    public void addTestListener(TestListener testListener) {
        addTaint(testListener.getTaint());
    if(testListener != null)        
        {
            mTestListeners.add(testListener);
        } //End block
        // ---------- Original Method ----------
        //if (testListener != null) {
            //mTestListeners.add(testListener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.802 -0400", hash_original_method = "4ED6259CFCB0F06AF455BB5AA68C8ADA", hash_generated_method = "77C6B8C45570E86B4E60F99F836AC572")
    @SuppressWarnings("unchecked")
    private Class<? extends Test> loadTestClass(String testClassName) {
        addTaint(testClassName.getTaint());
        try 
        {
Class<? extends Test> var30ECC5D58D34BFEFC07D6F484C75F66D_752226736 =             (Class<? extends Test>) mContext.getClassLoader().loadClass(testClassName);
            var30ECC5D58D34BFEFC07D6F484C75F66D_752226736.addTaint(taint);
            return var30ECC5D58D34BFEFC07D6F484C75F66D_752226736;
        } //End block
        catch (ClassNotFoundException e)
        {
            runFailed("Could not find test class. Class: " + testClassName);
        } //End block
Class<? extends Test> var540C13E9E156B687226421B24F2DF178_1804336090 =         null;
        var540C13E9E156B687226421B24F2DF178_1804336090.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1804336090;
        // ---------- Original Method ----------
        //try {
            //return (Class<? extends Test>) mContext.getClassLoader().loadClass(testClassName);
        //} catch (ClassNotFoundException e) {
            //runFailed("Could not find test class. Class: " + testClassName);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.803 -0400", hash_original_method = "680F4AFE025176BB5C5C3EA4F624B107", hash_generated_method = "D2D35BFFE196BED0F8561C94FC226748")
    private TestCase buildSingleTestMethod(Class testClass, String testMethodName) {
        addTaint(testMethodName.getTaint());
        addTaint(testClass.getTaint());
        try 
        {
            TestCase testCase = (TestCase) testClass.newInstance();
            testCase.setName(testMethodName);
TestCase varFB127DFE6431D25557ED04A60EC03FF7_74428453 =             testCase;
            varFB127DFE6431D25557ED04A60EC03FF7_74428453.addTaint(taint);
            return varFB127DFE6431D25557ED04A60EC03FF7_74428453;
        } //End block
        catch (IllegalAccessException e)
        {
            runFailed("Could not access test class. Class: " + testClass.getName());
        } //End block
        catch (InstantiationException e)
        {
            runFailed("Could not instantiate test class. Class: " + testClass.getName());
        } //End block
TestCase var540C13E9E156B687226421B24F2DF178_1491100624 =         null;
        var540C13E9E156B687226421B24F2DF178_1491100624.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1491100624;
        // ---------- Original Method ----------
        //try {
            //TestCase testCase = (TestCase) testClass.newInstance();
            //testCase.setName(testMethodName);
            //return testCase;
        //} catch (IllegalAccessException e) {
            //runFailed("Could not access test class. Class: " + testClass.getName());
        //} catch (InstantiationException e) {
            //runFailed("Could not instantiate test class. Class: " + testClass.getName());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.803 -0400", hash_original_method = "DDD5F7F4EAC683F5EFEEC11885AD09F9", hash_generated_method = "EDA0483DF13D048E25D3410C36192C9D")
    private boolean shouldRunSingleTestMethod(String testMethodName,
            Class<? extends Test> testClass) {
        addTaint(testClass.getTaint());
        addTaint(testMethodName.getTaint());
        boolean var908F3200A69B401FB0E0BC02ECC36290_2079749192 = (testMethodName != null && TestCase.class.isAssignableFrom(testClass));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2067880883 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2067880883;
        // ---------- Original Method ----------
        //return testMethodName != null && TestCase.class.isAssignableFrom(testClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.804 -0400", hash_original_method = "771A297B38A7AB0B0FF5862A497CDBEC", hash_generated_method = "A78A0B5280CD6465316421EFEC39D534")
    private Test getTest(Class clazz) {
        addTaint(clazz.getTaint());
    if(TestSuiteProvider.class.isAssignableFrom(clazz))        
        {
            try 
            {
                TestSuiteProvider testSuiteProvider = (TestSuiteProvider) clazz.getConstructor().newInstance();
Test var68AE946AB4E14D9FAAB225BDA8F4D94A_13123521 =                 testSuiteProvider.getTestSuite();
                var68AE946AB4E14D9FAAB225BDA8F4D94A_13123521.addTaint(taint);
                return var68AE946AB4E14D9FAAB225BDA8F4D94A_13123521;
            } //End block
            catch (InstantiationException e)
            {
                runFailed("Could not instantiate test suite provider. Class: " + clazz.getName());
            } //End block
            catch (IllegalAccessException e)
            {
                runFailed("Illegal access of test suite provider. Class: " + clazz.getName());
            } //End block
            catch (InvocationTargetException e)
            {
                runFailed("Invocation exception test suite provider. Class: " + clazz.getName());
            } //End block
            catch (NoSuchMethodException e)
            {
                runFailed("No such method on test suite provider. Class: " + clazz.getName());
            } //End block
        } //End block
Test var996CF625C9F3B89DE3BAFE852F5148F8_2064322932 =         getTest(clazz.getName());
        var996CF625C9F3B89DE3BAFE852F5148F8_2064322932.addTaint(taint);
        return var996CF625C9F3B89DE3BAFE852F5148F8_2064322932;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.804 -0400", hash_original_method = "FD0715829EDCBEE3D15F529E318762AF", hash_generated_method = "942F3756FB57467D1A9D874834D1CFCB")
    protected TestResult createTestResult() {
    if(mSkipExecution)        
        {
TestResult varA06DDFD40BCE7BD2DEE2613EAA6910FC_1080637305 =             new NoExecTestResult();
            varA06DDFD40BCE7BD2DEE2613EAA6910FC_1080637305.addTaint(taint);
            return varA06DDFD40BCE7BD2DEE2613EAA6910FC_1080637305;
        } //End block
TestResult varB1D52DB2FC7B844B35F46763F5119AF7_1360309060 =         new TestResult();
        varB1D52DB2FC7B844B35F46763F5119AF7_1360309060.addTaint(taint);
        return varB1D52DB2FC7B844B35F46763F5119AF7_1360309060;
        // ---------- Original Method ----------
        //if (mSkipExecution) {
            //return new NoExecTestResult();
        //}
        //return new TestResult();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.804 -0400", hash_original_method = "35C6F654589DD3EA8896BA4A5DEE7BCB", hash_generated_method = "52A0B91FB5E6FFC3CAC7A12EB59B5758")
     void setSkipExecution(boolean skip) {
        mSkipExecution = skip;
        // ---------- Original Method ----------
        //mSkipExecution = skip;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.805 -0400", hash_original_method = "88882B49F41F9B7FE520559A2C518CF5", hash_generated_method = "A6535C984AA1045ECAD0B2196CCB0392")
    public List<TestCase> getTestCases() {
List<TestCase> var8F97DD99F42FF73EAB8CDB477DFEE3E9_561792965 =         mTestCases;
        var8F97DD99F42FF73EAB8CDB477DFEE3E9_561792965.addTaint(taint);
        return var8F97DD99F42FF73EAB8CDB477DFEE3E9_561792965;
        // ---------- Original Method ----------
        //return mTestCases;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.805 -0400", hash_original_method = "F2D7E2FB778FC0649CC40AF9C1142527", hash_generated_method = "1B9792FF5C6553CA83BE8721B7558EAA")
    public String getTestClassName() {
String var1CB478C44ABEF9FA32CEDB99E8709D2F_143442411 =         mTestClassName;
        var1CB478C44ABEF9FA32CEDB99E8709D2F_143442411.addTaint(taint);
        return var1CB478C44ABEF9FA32CEDB99E8709D2F_143442411;
        // ---------- Original Method ----------
        //return mTestClassName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.805 -0400", hash_original_method = "5B53C1B8ED988918C7336B043C531676", hash_generated_method = "9A4F310A0990337919F52142D165DB26")
    public TestResult getTestResult() {
TestResult var437D81FF8A497B3A9605171F4D29C8AB_207503714 =         mTestResult;
        var437D81FF8A497B3A9605171F4D29C8AB_207503714.addTaint(taint);
        return var437D81FF8A497B3A9605171F4D29C8AB_207503714;
        // ---------- Original Method ----------
        //return mTestResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.805 -0400", hash_original_method = "99F47304AAC4A5C182E0EF1BC1C1BE8D", hash_generated_method = "B2AC6C3F8BB8B04F2AB4C8D04FFDB305")
    public void runTest() {
        runTest(createTestResult());
        // ---------- Original Method ----------
        //runTest(createTestResult());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.806 -0400", hash_original_method = "ED862A4D59493014B8A195EE02B51D32", hash_generated_method = "A5EF62A37F4659DF1F164432950B98F3")
    public void runTest(TestResult testResult) {
        mTestResult = testResult;
for(TestListener testListener : mTestListeners)
        {
            mTestResult.addListener(testListener);
        } //End block
        Context testContext = mInstrumentation == null ? mContext : mInstrumentation.getContext();
for(TestCase testCase : mTestCases)
        {
            setContextIfAndroidTestCase(testCase, mContext, testContext);
            setInstrumentationIfInstrumentationTestCase(testCase, mInstrumentation);
            setPerformanceWriterIfPerformanceCollectorTestCase(testCase, mPerfWriter);
            testCase.run(mTestResult);
        } //End block
        // ---------- Original Method ----------
        //mTestResult = testResult;
        //for (TestListener testListener : mTestListeners) {
            //mTestResult.addListener(testListener);
        //}
        //Context testContext = mInstrumentation == null ? mContext : mInstrumentation.getContext();
        //for (TestCase testCase : mTestCases) {
            //setContextIfAndroidTestCase(testCase, mContext, testContext);
            //setInstrumentationIfInstrumentationTestCase(testCase, mInstrumentation);
            //setPerformanceWriterIfPerformanceCollectorTestCase(testCase, mPerfWriter);
            //testCase.run(mTestResult);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.806 -0400", hash_original_method = "949353832C2D9CAB570B13ECD24DC64F", hash_generated_method = "808065C7833D1F85AE2C8B8012A988E9")
    private void setContextIfAndroidTestCase(Test test, Context context, Context testContext) {
        addTaint(testContext.getTaint());
        addTaint(context.getTaint());
        addTaint(test.getTaint());
    if(AndroidTestCase.class.isAssignableFrom(test.getClass()))        
        {
            ((AndroidTestCase) test).setContext(context);
            ((AndroidTestCase) test).setTestContext(testContext);
        } //End block
        // ---------- Original Method ----------
        //if (AndroidTestCase.class.isAssignableFrom(test.getClass())) {
            //((AndroidTestCase) test).setContext(context);
            //((AndroidTestCase) test).setTestContext(testContext);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.807 -0400", hash_original_method = "79C5FD8850A7FDB4967DBA296D1AB9AD", hash_generated_method = "6F13A8B42448B2C5D39C1B275EFDE141")
    public void setContext(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.807 -0400", hash_original_method = "E266649630C8CD4E16F7F34F320F1B2E", hash_generated_method = "0C8097DE2199C4BEABCDC9B38773AB56")
    private void setInstrumentationIfInstrumentationTestCase(
            Test test, Instrumentation instrumentation) {
        addTaint(instrumentation.getTaint());
        addTaint(test.getTaint());
    if(InstrumentationTestCase.class.isAssignableFrom(test.getClass()))        
        {
            ((InstrumentationTestCase) test).injectInstrumentation(instrumentation);
        } //End block
        // ---------- Original Method ----------
        //if (InstrumentationTestCase.class.isAssignableFrom(test.getClass())) {
            //((InstrumentationTestCase) test).injectInstrumentation(instrumentation);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.807 -0400", hash_original_method = "3D5BBB4E1A08BB692C099BDBCA18366E", hash_generated_method = "BB08EF2EAD84481345DB17C62819481D")
    private void setPerformanceWriterIfPerformanceCollectorTestCase(
            Test test, PerformanceResultsWriter writer) {
        addTaint(writer.getTaint());
        addTaint(test.getTaint());
    if(PerformanceCollectorTestCase.class.isAssignableFrom(test.getClass()))        
        {
            ((PerformanceCollectorTestCase) test).setPerformanceResultsWriter(writer);
        } //End block
        // ---------- Original Method ----------
        //if (PerformanceCollectorTestCase.class.isAssignableFrom(test.getClass())) {
            //((PerformanceCollectorTestCase) test).setPerformanceResultsWriter(writer);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.808 -0400", hash_original_method = "0EFFD9B799AED609D4828DB6F7AAB0E5", hash_generated_method = "3ACD0016E8612A780C3363D803A8AF08")
    public void setInstrumentation(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
        // ---------- Original Method ----------
        //mInstrumentation = instrumentation;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.808 -0400", hash_original_method = "8B0B0B0117FF17F8E6C78456D5FA2528", hash_generated_method = "3EF8B0CB7FF92401818A0D3175C4DD53")
    @Deprecated
    public void setInstrumentaiton(Instrumentation instrumentation) {
        addTaint(instrumentation.getTaint());
        setInstrumentation(instrumentation);
        // ---------- Original Method ----------
        //setInstrumentation(instrumentation);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.808 -0400", hash_original_method = "37F3C4CB00E2065177941F440A1EB96E", hash_generated_method = "B9C8894AFEBF94656C66FAA8B38F355F")
    public void setPerformanceResultsWriter(PerformanceResultsWriter writer) {
        mPerfWriter = writer;
        // ---------- Original Method ----------
        //mPerfWriter = writer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.808 -0400", hash_original_method = "9985589E6BCEC9AEDE0CE1DCD556A8F2", hash_generated_method = "5932585033D495DB0A52FF239B0ECFF2")
    @Override
    protected Class loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        addTaint(suiteClassName.getTaint());
Class var46F17594A492923407012C376C374B95_1754615885 =         mContext.getClassLoader().loadClass(suiteClassName);
        var46F17594A492923407012C376C374B95_1754615885.addTaint(taint);
        return var46F17594A492923407012C376C374B95_1754615885;
        // ---------- Original Method ----------
        //return mContext.getClassLoader().loadClass(suiteClassName);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.809 -0400", hash_original_method = "1FEF70E96102D7304D006BBFDC4DE6B7", hash_generated_method = "4FAFD7517E2617F717E5C9E85C0A14FE")
    public void testStarted(String testName) {
        addTaint(testName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.809 -0400", hash_original_method = "95F90AC078029D49ABA36F5E39CE4989", hash_generated_method = "9E4B00FBBA1794C65D5334E8AFC03502")
    public void testEnded(String testName) {
        addTaint(testName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.809 -0400", hash_original_method = "3C8F23863ACC349D5F634378B8407602", hash_generated_method = "343C81A91A376A476B6E63854712BD10")
    public void testFailed(int status, Test test, Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        addTaint(status);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.809 -0400", hash_original_method = "F9958EFC768179587B664BD8FA1B92E0", hash_generated_method = "12331753103A262D6BFCD3AB99A0C6B1")
    protected void runFailed(String message) {
        addTaint(message.getTaint());
        RuntimeException var84ECB4EA3AEDFA95D03DB645F86E7A03_2082457288 = new RuntimeException(message);
        var84ECB4EA3AEDFA95D03DB645F86E7A03_2082457288.addTaint(taint);
        throw var84ECB4EA3AEDFA95D03DB645F86E7A03_2082457288;
        // ---------- Original Method ----------
        //throw new RuntimeException(message);
    }

    
}

