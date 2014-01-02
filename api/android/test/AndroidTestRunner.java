package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import android.app.Instrumentation;
import android.content.Context;
import android.os.PerformanceCollector.PerformanceResultsWriter;

import com.google.android.collect.Lists;






public class AndroidTestRunner extends BaseTestRunner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.123 -0500", hash_original_field = "FAF947ADE8CA338CF26CE4594F5A8D6D", hash_generated_field = "6DA683BBE787F263E5F5E79B3A62B986")


    private TestResult mTestResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.125 -0500", hash_original_field = "C3CB53F1A053E8E518BD9775B0ABB434", hash_generated_field = "5B8CC2DB991885EB5008A645801A9BD1")

    private String mTestClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.127 -0500", hash_original_field = "0E706547655C6D1E7EE8011ED977D558", hash_generated_field = "57CD2938F6E71D086604FFB94901029B")

    private List<TestCase> mTestCases;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.129 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.131 -0500", hash_original_field = "0EA3B0D784086A5E26566265423312CF", hash_generated_field = "6FD7A350695311DE0709E7C398EDB658")

    private boolean mSkipExecution = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.133 -0500", hash_original_field = "0794755E72236CB587617728E7BD124C", hash_generated_field = "AED73EC002699D3069BEE18C310BB33E")


    private List<TestListener> mTestListeners = Lists.newArrayList();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.136 -0500", hash_original_field = "5CBE0F2EE224A7AD181F35AE16EC5D56", hash_generated_field = "B2267B39A1EB39D35FC793A28FB486AB")

    private Instrumentation mInstrumentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.138 -0500", hash_original_field = "E336978E128E2D4BAC13ECE6FC28940B", hash_generated_field = "2E6B5EF6C826CFAA09973D53DE7A3FDC")

    private PerformanceResultsWriter mPerfWriter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.343 -0400", hash_original_method = "2722F23348F424AF929858C44CF90573", hash_generated_method = "2722F23348F424AF929858C44CF90573")
    public AndroidTestRunner ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.140 -0500", hash_original_method = "C1F9E85AE774BF3AF2496CEC49DDE295", hash_generated_method = "45521EACE69F176AAB49A02D38E1B1F7")
    
@SuppressWarnings("unchecked")
    public void setTestClassName(String testClassName, String testMethodName) {
        Class testClass = loadTestClass(testClassName);

        if (shouldRunSingleTestMethod(testMethodName, testClass)) {
            TestCase testCase = buildSingleTestMethod(testClass, testMethodName);
            mTestCases = Lists.newArrayList(testCase);
            mTestClassName = testClass.getSimpleName();
        } else {
            setTest(getTest(testClass), testClass);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.142 -0500", hash_original_method = "621D8E85057FEDDF5A2E0BEC9A1D4675", hash_generated_method = "4E8A61C0EFE5347504DB4717E726CCAB")
    
public void setTest(Test test) {
        setTest(test, test.getClass());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.145 -0500", hash_original_method = "8A2ED2B311133489D5211F7B75C9AF00", hash_generated_method = "410699AEEE9950A0F333408530BA2573")
    
private void setTest(Test test, Class<? extends Test> testClass) {
        mTestCases = (List<TestCase>) TestCaseUtil.getTests(test, true);
        if (TestSuite.class.isAssignableFrom(testClass)) {
            mTestClassName = TestCaseUtil.getTestName(test);
        } else {
            mTestClassName = testClass.getSimpleName();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.147 -0500", hash_original_method = "934673426DE78D3BF4595E284314BBA0", hash_generated_method = "94BAD423046962F2AABADA33055AEA29")
    
public void clearTestListeners() {
        mTestListeners.clear();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.149 -0500", hash_original_method = "69E18BF63A69D4030ECF7F312645F69E", hash_generated_method = "63AA6234DEE829925810B129520E1F69")
    
public void addTestListener(TestListener testListener) {
        if (testListener != null) {
            mTestListeners.add(testListener);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.151 -0500", hash_original_method = "4ED6259CFCB0F06AF455BB5AA68C8ADA", hash_generated_method = "0C73C2364852FEB687E4526313F238A5")
    
@SuppressWarnings("unchecked")
    private Class<? extends Test> loadTestClass(String testClassName) {
        try {
            return (Class<? extends Test>) mContext.getClassLoader().loadClass(testClassName);
        } catch (ClassNotFoundException e) {
            runFailed("Could not find test class. Class: " + testClassName);
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.154 -0500", hash_original_method = "680F4AFE025176BB5C5C3EA4F624B107", hash_generated_method = "7E527D59F3A66F96630DAE3691C8A27C")
    
private TestCase buildSingleTestMethod(Class testClass, String testMethodName) {
        try {
            TestCase testCase = (TestCase) testClass.newInstance();
            testCase.setName(testMethodName);
            return testCase;
        } catch (IllegalAccessException e) {
            runFailed("Could not access test class. Class: " + testClass.getName());
        } catch (InstantiationException e) {
            runFailed("Could not instantiate test class. Class: " + testClass.getName());
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.156 -0500", hash_original_method = "DDD5F7F4EAC683F5EFEEC11885AD09F9", hash_generated_method = "16D4C93CAE9D746EF0B46366E79262CB")
    
private boolean shouldRunSingleTestMethod(String testMethodName,
            Class<? extends Test> testClass) {
        return testMethodName != null && TestCase.class.isAssignableFrom(testClass);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.159 -0500", hash_original_method = "771A297B38A7AB0B0FF5862A497CDBEC", hash_generated_method = "6C01E3DBFEBFDBCD202F68F78B8929B0")
    
private Test getTest(Class clazz) {
        if (TestSuiteProvider.class.isAssignableFrom(clazz)) {
            try {
                TestSuiteProvider testSuiteProvider =
                        (TestSuiteProvider) clazz.getConstructor().newInstance();
                return testSuiteProvider.getTestSuite();
            } catch (InstantiationException e) {
                runFailed("Could not instantiate test suite provider. Class: " + clazz.getName());
            } catch (IllegalAccessException e) {
                runFailed("Illegal access of test suite provider. Class: " + clazz.getName());
            } catch (InvocationTargetException e) {
                runFailed("Invocation exception test suite provider. Class: " + clazz.getName());
            } catch (NoSuchMethodException e) {
                runFailed("No such method on test suite provider. Class: " + clazz.getName());
            }
        }
        return getTest(clazz.getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.162 -0500", hash_original_method = "FD0715829EDCBEE3D15F529E318762AF", hash_generated_method = "0138184FB594B570F8D73152598FE65D")
    
protected TestResult createTestResult() {
        if (mSkipExecution) {
            return new NoExecTestResult();
        }
        return new TestResult();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.164 -0500", hash_original_method = "35C6F654589DD3EA8896BA4A5DEE7BCB", hash_generated_method = "35C6F654589DD3EA8896BA4A5DEE7BCB")
    
void setSkipExecution(boolean skip) {
        mSkipExecution = skip;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.166 -0500", hash_original_method = "88882B49F41F9B7FE520559A2C518CF5", hash_generated_method = "E958B99EE289329D71DF85C11D3EF35F")
    
public List<TestCase> getTestCases() {
        return mTestCases;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.168 -0500", hash_original_method = "F2D7E2FB778FC0649CC40AF9C1142527", hash_generated_method = "DEE206C1E07693087949E0CEA63711EF")
    
public String getTestClassName() {
        return mTestClassName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.170 -0500", hash_original_method = "5B53C1B8ED988918C7336B043C531676", hash_generated_method = "A6FD686CD7B3A867501DACC8F83BFDDA")
    
public TestResult getTestResult() {
        return mTestResult;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.172 -0500", hash_original_method = "99F47304AAC4A5C182E0EF1BC1C1BE8D", hash_generated_method = "7E19174E5BA44226A5801560E83A0277")
    
public void runTest() {
        runTest(createTestResult());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.175 -0500", hash_original_method = "ED862A4D59493014B8A195EE02B51D32", hash_generated_method = "D2444EF7E6F58DC6ED1FC9163392AD99")
    
public void runTest(TestResult testResult) {
        mTestResult = testResult;

        for (TestListener testListener : mTestListeners) {
            mTestResult.addListener(testListener);
        }

        Context testContext = mInstrumentation == null ? mContext : mInstrumentation.getContext();
        for (TestCase testCase : mTestCases) {
            setContextIfAndroidTestCase(testCase, mContext, testContext);
            setInstrumentationIfInstrumentationTestCase(testCase, mInstrumentation);
            setPerformanceWriterIfPerformanceCollectorTestCase(testCase, mPerfWriter);
            testCase.run(mTestResult);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.177 -0500", hash_original_method = "949353832C2D9CAB570B13ECD24DC64F", hash_generated_method = "6B5410A5E6A44144F76CB2B78960E68A")
    
private void setContextIfAndroidTestCase(Test test, Context context, Context testContext) {
        if (AndroidTestCase.class.isAssignableFrom(test.getClass())) {
            ((AndroidTestCase) test).setContext(context);
            ((AndroidTestCase) test).setTestContext(testContext);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.179 -0500", hash_original_method = "79C5FD8850A7FDB4967DBA296D1AB9AD", hash_generated_method = "8123FBA4DFA38D2D9EDCDEEE26B6DCB9")
    
public void setContext(Context context) {
        mContext = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.181 -0500", hash_original_method = "E266649630C8CD4E16F7F34F320F1B2E", hash_generated_method = "00D8387B614FDA64AA754A61F66C161A")
    
private void setInstrumentationIfInstrumentationTestCase(
            Test test, Instrumentation instrumentation) {
        if (InstrumentationTestCase.class.isAssignableFrom(test.getClass())) {
            ((InstrumentationTestCase) test).injectInstrumentation(instrumentation);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.184 -0500", hash_original_method = "3D5BBB4E1A08BB692C099BDBCA18366E", hash_generated_method = "84F07B2FE95779CE3249EC52AB034043")
    
private void setPerformanceWriterIfPerformanceCollectorTestCase(
            Test test, PerformanceResultsWriter writer) {
        if (PerformanceCollectorTestCase.class.isAssignableFrom(test.getClass())) {
            ((PerformanceCollectorTestCase) test).setPerformanceResultsWriter(writer);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.186 -0500", hash_original_method = "0EFFD9B799AED609D4828DB6F7AAB0E5", hash_generated_method = "717D638FD35EF51867D6410C89565654")
    
public void setInstrumentation(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    /**
     * @deprecated Incorrect spelling,
     * use {@link #setInstrumentation(android.app.Instrumentation)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.188 -0500", hash_original_method = "8B0B0B0117FF17F8E6C78456D5FA2528", hash_generated_method = "CA29C0A0811207789DF151706A367E65")
    
@Deprecated
    public void setInstrumentaiton(Instrumentation instrumentation) {
        setInstrumentation(instrumentation);
    }

    /**
     * {@hide} Pending approval for public API.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.190 -0500", hash_original_method = "37F3C4CB00E2065177941F440A1EB96E", hash_generated_method = "208A4627DE12EEF6AF05DEF218E1C36B")
    
public void setPerformanceResultsWriter(PerformanceResultsWriter writer) {
        mPerfWriter = writer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.193 -0500", hash_original_method = "9985589E6BCEC9AEDE0CE1DCD556A8F2", hash_generated_method = "EC6CBD6AC34D4A6429B49DDE6BFC4038")
    
@Override
    protected Class loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        return mContext.getClassLoader().loadClass(suiteClassName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.195 -0500", hash_original_method = "1FEF70E96102D7304D006BBFDC4DE6B7", hash_generated_method = "04CDBDA0DBAE932D025ABBC9B68B52FD")
    
public void testStarted(String testName) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.197 -0500", hash_original_method = "95F90AC078029D49ABA36F5E39CE4989", hash_generated_method = "6660BBE65D150E7BA3CD4924169AA014")
    
public void testEnded(String testName) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.199 -0500", hash_original_method = "3C8F23863ACC349D5F634378B8407602", hash_generated_method = "851E95F7B4CF27F0534F12D22C7B0481")
    
public void testFailed(int status, Test test, Throwable t) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.201 -0500", hash_original_method = "F9958EFC768179587B664BD8FA1B92E0", hash_generated_method = "AC8B64732951D6C6451A561EB06DF03B")
    
protected void runFailed(String message) {
        throw new RuntimeException(message);
    }

    
}

