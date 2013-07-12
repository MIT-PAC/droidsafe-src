package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.util.Predicate;
import com.android.internal.util.Predicates;
import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.os.Parcelable;
import android.os.PerformanceCollector;
import android.os.PerformanceCollector.PerformanceResultsWriter;
import android.test.suitebuilder.TestMethod;
import android.test.suitebuilder.TestPredicates;
import android.test.suitebuilder.TestSuiteBuilder;
import android.test.suitebuilder.annotation.HasAnnotation;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;
import junit.textui.ResultPrinter;

public class InstrumentationTestRunner extends Instrumentation implements TestSuiteProvider {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "DDBF77BBD59535F3FF16689A18C16686", hash_generated_field = "57041D8C5014DE6D87A28603CC7822CE")

    private final Bundle mResults = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "141E060C3952C133ADC3DF31048B4376")

    private Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "8A42FE0F5154C402C775BB7D2ED3E2D6", hash_generated_field = "0C2BC6A40B4FAAAD4ADDFF4CB98782DA")

    private AndroidTestRunner mTestRunner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "B86684C7DC25411EAA00AFA56FDDD301", hash_generated_field = "4C294409170D3110EF12CA3CCED984A1")

    private boolean mDebug;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "277A3320BD5C49EBD7E492EC22C10058", hash_generated_field = "3F2709EEC2B2C2F043111479DDADB3D4")

    private boolean mJustCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "729867D8145207192C1CF4ED19A541F3", hash_generated_field = "ACA828682E2C6ECC613CA27863C2264D")

    private boolean mSuiteAssignmentMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "496BE6D2800441EA991050C992DF3112", hash_generated_field = "78B349732F0D9D6BFA04A40FFFB14ACA")

    private int mTestCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "6EAA104784C5B2B8C9B8CAFD565B6B86", hash_generated_field = "AD7F82C5377D8DBE525A22C459787867")

    private String mPackageOfTests;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "8D4A2FFC67C1BBF157BF0598BB0CBAA2", hash_generated_field = "39025D4B0FB339CA8809220E55135D9A")

    private boolean mCoverage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "409EB834C72ADBE21423B340E6F22F0C", hash_generated_field = "7CFA27D3752B16D4570E1B9BF2B33568")

    private String mCoverageFilePath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.064 -0400", hash_original_field = "846F714ACC1162A67D468AEB693C0686", hash_generated_field = "DA6E4F18E5C9B928AFD0A314A6DD8344")

    private int mDelayMsec;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.065 -0400", hash_original_method = "4F1BA42F3F5EBFB30B61E510F40B73D6", hash_generated_method = "4F1BA42F3F5EBFB30B61E510F40B73D6")
    public InstrumentationTestRunner ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.067 -0400", hash_original_method = "6DFE69C7BEAD4ACC310BC8D2DE157051", hash_generated_method = "E4410CD32F8592ACBCDDD4BE8990003E")
    @Override
    public void onCreate(Bundle arguments) {
        
        super.onCreate(arguments);
        mArguments = arguments;
        String[] apkPaths = {getTargetContext().getPackageCodePath(), getContext().getPackageCodePath()};
        ClassPathPackageInfoSource.setApkPaths(apkPaths);
        Predicate<TestMethod> testSizePredicate = null;
        Predicate<TestMethod> testAnnotationPredicate = null;
        Predicate<TestMethod> testNotAnnotationPredicate = null;
        String testClassesArg = null;
        boolean logOnly = false;
    if(arguments != null)        
        {
            testClassesArg = arguments.getString(ARGUMENT_TEST_CLASS);
            mDebug = getBooleanArgument(arguments, "debug");
            mJustCount = getBooleanArgument(arguments, "count");
            mSuiteAssignmentMode = getBooleanArgument(arguments, "suiteAssignment");
            mPackageOfTests = arguments.getString(ARGUMENT_TEST_PACKAGE);
            testSizePredicate = getSizePredicateFromArg(
                    arguments.getString(ARGUMENT_TEST_SIZE_PREDICATE));
            testAnnotationPredicate = getAnnotationPredicate(
                    arguments.getString(ARGUMENT_ANNOTATION));
            testNotAnnotationPredicate = getNotAnnotationPredicate(
                    arguments.getString(ARGUMENT_NOT_ANNOTATION));
            logOnly = getBooleanArgument(arguments, ARGUMENT_LOG_ONLY);
            mCoverage = getBooleanArgument(arguments, "coverage");
            mCoverageFilePath = arguments.getString("coverageFile");
            try 
            {
                Object delay = arguments.get(ARGUMENT_DELAY_MSEC);
    if(delay != null)                
                mDelayMsec = Integer.parseInt(delay.toString());
            } 
            catch (NumberFormatException e)
            {
            } 
        } 
        TestSuiteBuilder testSuiteBuilder = new TestSuiteBuilder(getClass().getName(),
                getTargetContext().getClassLoader());
    if(testSizePredicate != null)        
        {
            testSuiteBuilder.addRequirements(testSizePredicate);
        } 
    if(testAnnotationPredicate != null)        
        {
            testSuiteBuilder.addRequirements(testAnnotationPredicate);
        } 
    if(testNotAnnotationPredicate != null)        
        {
            testSuiteBuilder.addRequirements(testNotAnnotationPredicate);
        } 
    if(testClassesArg == null)        
        {
    if(mPackageOfTests != null)            
            {
                testSuiteBuilder.includePackages(mPackageOfTests);
            } 
            else
            {
                TestSuite testSuite = getTestSuite();
    if(testSuite != null)                
                {
                    testSuiteBuilder.addTestSuite(testSuite);
                } 
                else
                {
                    testSuiteBuilder.includePackages("");
                } 
            } 
        } 
        else
        {
            parseTestClasses(testClassesArg, testSuiteBuilder);
        } 
        testSuiteBuilder.addRequirements(getBuilderRequirements());
        mTestRunner = getAndroidTestRunner();
        mTestRunner.setContext(getTargetContext());
        mTestRunner.setInstrumentation(this);
        mTestRunner.setSkipExecution(logOnly);
        mTestRunner.setTest(testSuiteBuilder.build());
        mTestCount = mTestRunner.getTestCases().size();
    if(mSuiteAssignmentMode)        
        {
            mTestRunner.addTestListener(new SuiteAssignmentPrinter());
        } 
        else
        {
            WatcherResultPrinter resultPrinter = new WatcherResultPrinter(mTestCount);
            mTestRunner.addTestListener(new TestPrinter("TestRunner", false));
            mTestRunner.addTestListener(resultPrinter);
            mTestRunner.setPerformanceResultsWriter(resultPrinter);
        } 
        start();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.068 -0400", hash_original_method = "10E6FBEC332CFAAD363071CF1888C5BE", hash_generated_method = "062ABB3A4856B556E974EB422D914831")
    public Bundle getBundle() {
Bundle varA1A5383052F874A8109F2B0284C0CCF1_2125713037 =         mArguments;
        varA1A5383052F874A8109F2B0284C0CCF1_2125713037.addTaint(taint);
        return varA1A5383052F874A8109F2B0284C0CCF1_2125713037;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.069 -0400", hash_original_method = "DCDBF8FA39FD6057A0486A2DA30868B2", hash_generated_method = "5043E521BD08CD9E302CA91C15EFFF06")
     List<Predicate<TestMethod>> getBuilderRequirements() {
List<Predicate<TestMethod>> varB89B9AE74F274E07C099737006AD3C9F_821710440 =         new ArrayList<Predicate<TestMethod>>();
        varB89B9AE74F274E07C099737006AD3C9F_821710440.addTaint(taint);
        return varB89B9AE74F274E07C099737006AD3C9F_821710440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.069 -0400", hash_original_method = "F83C1F460CEFDE714C6876815B6DE46B", hash_generated_method = "29E4380E1330F829CAF50D383EFA7DAF")
    private void parseTestClasses(String testClassArg, TestSuiteBuilder testSuiteBuilder) {
        addTaint(testSuiteBuilder.getTaint());
        addTaint(testClassArg.getTaint());
        String[] testClasses = testClassArg.split(",");
for(String testClass : testClasses)
        {
            parseTestClass(testClass, testSuiteBuilder);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.070 -0400", hash_original_method = "0276346FF35DC079CD9DD44ABC105E23", hash_generated_method = "C0FEF7A322441C4D6069C4BAA6B343FF")
    private void parseTestClass(String testClassName, TestSuiteBuilder testSuiteBuilder) {
        addTaint(testSuiteBuilder.getTaint());
        addTaint(testClassName.getTaint());
        int methodSeparatorIndex = testClassName.indexOf('#');
        String testMethodName = null;
    if(methodSeparatorIndex > 0)        
        {
            testMethodName = testClassName.substring(methodSeparatorIndex + 1);
            testClassName = testClassName.substring(0, methodSeparatorIndex);
        } 
        testSuiteBuilder.addTestClassByName(testClassName, testMethodName, getTargetContext());
        
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.071 -0400", hash_original_method = "59FA7210DE5A9B3F31249CF283F3E831", hash_generated_method = "873EA6B0142075E95117F91E122ABD31")
    protected AndroidTestRunner getAndroidTestRunner() {
AndroidTestRunner var6DED4B728E5CF2C8C96F16BF715A4A14_311912347 =         new AndroidTestRunner();
        var6DED4B728E5CF2C8C96F16BF715A4A14_311912347.addTaint(taint);
        return var6DED4B728E5CF2C8C96F16BF715A4A14_311912347;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.071 -0400", hash_original_method = "770E3D4317847EA06A1A186F0C988E4F", hash_generated_method = "0B9CD389CAE0812DF5798CE49F135EE4")
    private boolean getBooleanArgument(Bundle arguments, String tag) {
        addTaint(tag.getTaint());
        addTaint(arguments.getTaint());
        String tagString = arguments.getString(tag);
        boolean var12C8161A76217C24A65B3158A9660316_606861070 = (tagString != null && Boolean.parseBoolean(tagString));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552647159 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552647159;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.072 -0400", hash_original_method = "778052CD062ADF4C5333CE80FB346BD7", hash_generated_method = "21FE737D4AB9E0F3255A08B5A71AD9D9")
    private Predicate<TestMethod> getSizePredicateFromArg(String sizeArg) {
        addTaint(sizeArg.getTaint());
    if(SMALL_SUITE.equals(sizeArg))        
        {
Predicate<TestMethod> varE0E1D4210503E46CD449DCD4EB6C9FC6_1406359360 =             TestPredicates.SELECT_SMALL;
            varE0E1D4210503E46CD449DCD4EB6C9FC6_1406359360.addTaint(taint);
            return varE0E1D4210503E46CD449DCD4EB6C9FC6_1406359360;
        } 
        else
    if(MEDIUM_SUITE.equals(sizeArg))        
        {
Predicate<TestMethod> varE61B19BA65D0577F79AB0C2F12D95025_423988881 =             TestPredicates.SELECT_MEDIUM;
            varE61B19BA65D0577F79AB0C2F12D95025_423988881.addTaint(taint);
            return varE61B19BA65D0577F79AB0C2F12D95025_423988881;
        } 
        else
    if(LARGE_SUITE.equals(sizeArg))        
        {
Predicate<TestMethod> varEB1CF173AA2514015C318D7BDAAAC8A2_412664828 =             TestPredicates.SELECT_LARGE;
            varEB1CF173AA2514015C318D7BDAAAC8A2_412664828.addTaint(taint);
            return varEB1CF173AA2514015C318D7BDAAAC8A2_412664828;
        } 
        else
        {
Predicate<TestMethod> var540C13E9E156B687226421B24F2DF178_1032491184 =             null;
            var540C13E9E156B687226421B24F2DF178_1032491184.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1032491184;
        } 
        
        
            
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.073 -0400", hash_original_method = "35F9B1C0A7B938B1EE66EE52909CB858", hash_generated_method = "B4160A3C3718E2BA0786A5B4AC0B0673")
    private Predicate<TestMethod> getAnnotationPredicate(String annotationClassName) {
        addTaint(annotationClassName.getTaint());
        Class<? extends Annotation> annotationClass = getAnnotationClass(annotationClassName);
    if(annotationClass != null)        
        {
Predicate<TestMethod> var652FC47B86EAF5D41957119FBE60A366_38662391 =             new HasAnnotation(annotationClass);
            var652FC47B86EAF5D41957119FBE60A366_38662391.addTaint(taint);
            return var652FC47B86EAF5D41957119FBE60A366_38662391;
        } 
Predicate<TestMethod> var540C13E9E156B687226421B24F2DF178_526698136 =         null;
        var540C13E9E156B687226421B24F2DF178_526698136.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_526698136;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.074 -0400", hash_original_method = "4E674ABAF10B3DBE6E2E2F43854FE054", hash_generated_method = "E68476AC0EE4F6A4A6FE3FB26D4A0236")
    private Predicate<TestMethod> getNotAnnotationPredicate(String annotationClassName) {
        addTaint(annotationClassName.getTaint());
        Class<? extends Annotation> annotationClass = getAnnotationClass(annotationClassName);
    if(annotationClass != null)        
        {
Predicate<TestMethod> varF224C75240B780821E5011903BA420E4_439946221 =             Predicates.not(new HasAnnotation(annotationClass));
            varF224C75240B780821E5011903BA420E4_439946221.addTaint(taint);
            return varF224C75240B780821E5011903BA420E4_439946221;
        } 
Predicate<TestMethod> var540C13E9E156B687226421B24F2DF178_1884422516 =         null;
        var540C13E9E156B687226421B24F2DF178_1884422516.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1884422516;
        
        
        
             
         
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.075 -0400", hash_original_method = "7CC1EF53DD56AF5F60DBA3D3D6AD7EDD", hash_generated_method = "AC9E44A4186979EA5401D39E31441B78")
    private Class<? extends Annotation> getAnnotationClass(String annotationClassName) {
        addTaint(annotationClassName.getTaint());
    if(annotationClassName == null)        
        {
Class<? extends Annotation> var540C13E9E156B687226421B24F2DF178_1540172411 =             null;
            var540C13E9E156B687226421B24F2DF178_1540172411.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1540172411;
        } 
        try 
        {
            Class<?> annotationClass = Class.forName(annotationClassName);
    if(annotationClass.isAnnotation())            
            {
Class<? extends Annotation> varA2F119939EC2C10CB58C692AEA560A23_325985277 =                 (Class<? extends Annotation>)annotationClass;
                varA2F119939EC2C10CB58C692AEA560A23_325985277.addTaint(taint);
                return varA2F119939EC2C10CB58C692AEA560A23_325985277;
            } 
            else
            {
            } 
        } 
        catch (ClassNotFoundException e)
        {
        } 
Class<? extends Annotation> var540C13E9E156B687226421B24F2DF178_1451980693 =         null;
        var540C13E9E156B687226421B24F2DF178_1451980693.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1451980693;
        
        
            
        
        
           
           
               
           
               
                       
           
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.076 -0400", hash_original_method = "3F6FAB1D23BC515BB2AF6438AF3536A0", hash_generated_method = "56EE5DBA76486B456591DFDA39E7C473")
     void prepareLooper() {
        Looper.prepare();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.077 -0400", hash_original_method = "13B14429707EB691EB642DFE530B7FBA", hash_generated_method = "2383BFCD59E2DD8C0529D81C8F6F4A37")
    @Override
    public void onStart() {
        
        prepareLooper();
    if(mJustCount)        
        {
            mResults.putString(Instrumentation.REPORT_KEY_IDENTIFIER, REPORT_VALUE_ID);
            mResults.putInt(REPORT_KEY_NUM_TOTAL, mTestCount);
            finish(Activity.RESULT_OK, mResults);
        } 
        else
        {
    if(mDebug)            
            {
                Debug.waitForDebugger();
            } 
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream writer = new PrintStream(byteArrayOutputStream);
            try 
            {
                StringResultPrinter resultPrinter = new StringResultPrinter(writer);
                mTestRunner.addTestListener(resultPrinter);
                long startTime = System.currentTimeMillis();
                mTestRunner.runTest();
                long runTime = System.currentTimeMillis() - startTime;
                resultPrinter.print(mTestRunner.getTestResult(), runTime);
            } 
            catch (Throwable t)
            {
                writer.println(String.format("Test run aborted due to unexpected exception: %s",
                                t.getMessage()));
                t.printStackTrace(writer);
            } 
            finally 
            {
                mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                        String.format("\nTest results for %s=%s",
                        mTestRunner.getTestClassName(),
                        byteArrayOutputStream.toString()));
    if(mCoverage)                
                {
                    generateCoverageReport();
                } 
                writer.close();
                finish(Activity.RESULT_OK, mResults);
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.077 -0400", hash_original_method = "C0E8619C87A7687A5C08E209915D7E38", hash_generated_method = "4FDC4C34C044CA782FB17E313B3B408D")
    public TestSuite getTestSuite() {
TestSuite varA2793CB316857DCB08182DC971BBC9D6_914908042 =         getAllTests();
        varA2793CB316857DCB08182DC971BBC9D6_914908042.addTaint(taint);
        return varA2793CB316857DCB08182DC971BBC9D6_914908042;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.077 -0400", hash_original_method = "BB818280151C8C17876053BFAB976A70", hash_generated_method = "B72B6CC93038B239B7FF80A8A3F6AE06")
    public TestSuite getAllTests() {
TestSuite var540C13E9E156B687226421B24F2DF178_64147358 =         null;
        var540C13E9E156B687226421B24F2DF178_64147358.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_64147358;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.077 -0400", hash_original_method = "9B48FC3FBC8B24E9AD86091F7F4B768A", hash_generated_method = "633D4C96089A302DEBF2F56C067A4DCA")
    public ClassLoader getLoader() {
ClassLoader var540C13E9E156B687226421B24F2DF178_1604668360 =         null;
        var540C13E9E156B687226421B24F2DF178_1604668360.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1604668360;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.078 -0400", hash_original_method = "C84559B4D56F542F69C4278CF0320D22", hash_generated_method = "7586FFDD238FCD1E662ED2708D6E9A63")
    private void generateCoverageReport() {
        String coverageFilePath = getCoverageFilePath();
        java.io.File coverageFile = new java.io.File(coverageFilePath);
        try 
        {
            Class<?> emmaRTClass = Class.forName("com.vladium.emma.rt.RT");
            Method dumpCoverageMethod = emmaRTClass.getMethod("dumpCoverageData",
                    coverageFile.getClass(), boolean.class, boolean.class);
            dumpCoverageMethod.invoke(null, coverageFile, false, false);
            mResults.putString(REPORT_KEY_COVERAGE_PATH, coverageFilePath);
            final String currentStream = mResults.getString(
                    Instrumentation.REPORT_KEY_STREAMRESULT);
            mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("%s\nGenerated code coverage data to %s", currentStream,
                coverageFilePath));
        } 
        catch (ClassNotFoundException e)
        {
            reportEmmaError("Is emma jar on classpath?", e);
        } 
        catch (SecurityException e)
        {
            reportEmmaError(e);
        } 
        catch (NoSuchMethodException e)
        {
            reportEmmaError(e);
        } 
        catch (IllegalArgumentException e)
        {
            reportEmmaError(e);
        } 
        catch (IllegalAccessException e)
        {
            reportEmmaError(e);
        } 
        catch (InvocationTargetException e)
        {
            reportEmmaError(e);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.078 -0400", hash_original_method = "51747DDF7CE66070F16DA4762443E683", hash_generated_method = "880BB154BB993F27C55FD10DF47EB08A")
    private String getCoverageFilePath() {
    if(mCoverageFilePath == null)        
        {
String varEC5DD3BBABE6F7B2F1198ADC694BDBD0_418704463 =             getTargetContext().getFilesDir().getAbsolutePath() + File.separator +
                   DEFAULT_COVERAGE_FILE_NAME;
            varEC5DD3BBABE6F7B2F1198ADC694BDBD0_418704463.addTaint(taint);
            return varEC5DD3BBABE6F7B2F1198ADC694BDBD0_418704463;
        } 
        else
        {
String var9869AA735EFB2F08232388567A171773_509620477 =             mCoverageFilePath;
            var9869AA735EFB2F08232388567A171773_509620477.addTaint(taint);
            return var9869AA735EFB2F08232388567A171773_509620477;
        } 
        
        
            
                   
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.079 -0400", hash_original_method = "5659030AB519EAF8BB83496F91E164E4", hash_generated_method = "EFF08B4EF5D524F43512C966EA4B7685")
    private void reportEmmaError(Exception e) {
        addTaint(e.getTaint());
        reportEmmaError("", e);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.079 -0400", hash_original_method = "2FAE5EEC06744688E8993112C12E7557", hash_generated_method = "D4E1AE7631A6C6436FB9149D034EA714")
    private void reportEmmaError(String hint, Exception e) {
        addTaint(e.getTaint());
        addTaint(hint.getTaint());
        String msg = "Failed to generate emma coverage. " + hint;
        mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT, "\nError: " + msg);
        
        
        
        
    }

    
    private class StringResultPrinter extends ResultPrinter {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.079 -0400", hash_original_method = "8278F372BF23485BBE56A9ABFE31E2B0", hash_generated_method = "0613F1230B12E10F17EBA162C8C35BAF")
        public  StringResultPrinter(PrintStream writer) {
            super(writer);
            addTaint(writer.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_method = "D5539E1607000A054CE19EDFAB1372FF", hash_generated_method = "81430FC53C63167CA209CA914C5933D9")
        synchronized void print(TestResult result, long runTime) {
            addTaint(runTime);
            addTaint(result.getTaint());
            printHeader(runTime);
            printFooter(result);
            
            
            
        }

        
    }


    
    private class SuiteAssignmentPrinter implements TestListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_field = "AFBAC9716FC2073B5BFEA6A40ED35C25", hash_generated_field = "EDD0604A9657EE882307103F9DDCC22C")

        private Bundle mTestResult;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_field = "4FBE52F16DA5DC1AFB86B1520E59C2C0", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

        private long mStartTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_field = "A0F28E4F5A99C619D8D824EA80594134", hash_generated_field = "CE198E728D2042BC4D1888DF0457D27B")

        private long mEndTime;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_field = "3899E50CCDB8685F1A028A39434397F5", hash_generated_field = "079233BE186E56546663F1E57D6A9B4C")

        private boolean mTimingValid;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.080 -0400", hash_original_method = "7306BE02962886D6C53070D35D513D17", hash_generated_method = "C486C7E9A0E6C1AF5474A05D0F461BFF")
        public  SuiteAssignmentPrinter() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.081 -0400", hash_original_method = "5FFF4B907A3EDB23E7C228BF47F3F987", hash_generated_method = "C14208438FD73C35135852E6ECBE60BB")
        public void startTest(Test test) {
            addTaint(test.getTaint());
            mTimingValid = true;
            mStartTime = System.currentTimeMillis();
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.081 -0400", hash_original_method = "345E3DE2999C1B6FA0060A48165FC0F3", hash_generated_method = "76C966886074A965651AC5A8F68EE3FF")
        public void addError(Test test, Throwable t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mTimingValid = false;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.081 -0400", hash_original_method = "F3D48E32FED097901DB6EC97B8BA5D91", hash_generated_method = "B5285F49DABC43D08CC3D83B8937371B")
        public void addFailure(Test test, AssertionFailedError t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mTimingValid = false;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.083 -0400", hash_original_method = "689FF998C59CF6C00229049B71C475A7", hash_generated_method = "7DA7A4F3ED33B3DEFA5267A77C518858")
        public void endTest(Test test) {
            addTaint(test.getTaint());
            float runTime;
            String assignmentSuite;
            mEndTime = System.currentTimeMillis();
            mTestResult = new Bundle();
    if(!mTimingValid || mStartTime < 0)            
            {
                assignmentSuite = "NA";
                runTime = -1;
            } 
            else
            {
                runTime = mEndTime - mStartTime;
    if(runTime < SMALL_SUITE_MAX_RUNTIME
                        && !InstrumentationTestCase.class.isAssignableFrom(test.getClass()))                
                {
                    assignmentSuite = SMALL_SUITE;
                } 
                else
    if(runTime < MEDIUM_SUITE_MAX_RUNTIME)                
                {
                    assignmentSuite = MEDIUM_SUITE;
                } 
                else
                {
                    assignmentSuite = LARGE_SUITE;
                } 
            } 
            mStartTime = -1;
            mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                    test.getClass().getName() + "#" + ((TestCase) test).getName()
                    + "\nin " + assignmentSuite + " suite\nrunTime: "
                    + String.valueOf(runTime) + "\n");
            mTestResult.putFloat(REPORT_KEY_RUN_TIME, runTime);
            mTestResult.putString(REPORT_KEY_SUITE_ASSIGNMENT, assignmentSuite);
            sendStatus(0, mTestResult);
            
            
        }

        
    }


    
    private class WatcherResultPrinter implements TestListener, PerformanceResultsWriter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.083 -0400", hash_original_field = "C0CC6B234496961CA16BD1AFF6688AC9", hash_generated_field = "8CC2E860F13B0FB54DCF8D3075E5FD80")

        private Bundle mResultTemplate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.083 -0400", hash_original_field = "AFBAC9716FC2073B5BFEA6A40ED35C25", hash_generated_field = "671EF5CCCE64ABF621E6F60CFC0B1CEB")

        Bundle mTestResult;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.083 -0400", hash_original_field = "CAE14EB38976D5A2409EAA598B04B2DB", hash_generated_field = "2BA1BF5CC1D20E4D04C04FBE333F6E26")

        int mTestNum = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_field = "6476435AFB794E96877646F5E428426B", hash_generated_field = "5159AE5BB82C390FF229EF7E789C498A")

        int mTestResultCode = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_field = "A42465665376C032FD8CBBCCD1CF8CED", hash_generated_field = "74A0FE6C36B53C52A2FFA32CDE32656B")

        String mTestClass = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_field = "24356C725F6C551190F93ED55DB220B4", hash_generated_field = "FB38EF7819F1C7E367EE6C6D724EEE31")

        PerformanceCollector mPerfCollector = new PerformanceCollector();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_field = "D57CFF79B11BCAC4C5C063A5882BA5CA", hash_generated_field = "927068CD6900F1BBDDB652AF2FC80A7E")

        boolean mIsTimedTest = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_field = "CF30D2C5294CDF39473EE077B661FE68", hash_generated_field = "142F76D07E81C97A91E7F404C5DD8F94")

        boolean mIncludeDetailedStats = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.084 -0400", hash_original_method = "B96CCA607C0FAF94BB8309C0E96C551A", hash_generated_method = "71C7E92BA24911ADEF60606A1A0AB3DF")
        public  WatcherResultPrinter(int numTests) {
            addTaint(numTests);
            mResultTemplate = new Bundle();
            mResultTemplate.putString(Instrumentation.REPORT_KEY_IDENTIFIER, REPORT_VALUE_ID);
            mResultTemplate.putInt(REPORT_KEY_NUM_TOTAL, numTests);
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.086 -0400", hash_original_method = "31528962776A4296CB5B735981815A21", hash_generated_method = "622F68911E8D644054DD6F9AE010C1AC")
        public void startTest(Test test) {
            String testClass = test.getClass().getName();
            String testName = ((TestCase)test).getName();
            mTestResult = new Bundle(mResultTemplate);
            mTestResult.putString(REPORT_KEY_NAME_CLASS, testClass);
            mTestResult.putString(REPORT_KEY_NAME_TEST, testName);
            mTestResult.putInt(REPORT_KEY_NUM_CURRENT, ++mTestNum);
    if(testClass != null && !testClass.equals(mTestClass))            
            {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                        String.format("\n%s:", testClass));
                mTestClass = testClass;
            } 
            else
            {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT, "");
            } 
            Method testMethod = null;
            try 
            {
                testMethod = test.getClass().getMethod(testName);
    if(testMethod.isAnnotationPresent(RepetitiveTest.class))                
                {
                    int numIterations = testMethod.getAnnotation(
                        RepetitiveTest.class).numIterations();
                    mTestResult.putInt(REPORT_KEY_NUM_ITERATIONS, numIterations);
                } 
            } 
            catch (NoSuchMethodException e)
            {
            } 
            try 
            {
    if(mTestNum == 1)                
                Thread.sleep(mDelayMsec);
            } 
            catch (InterruptedException e)
            {
                IllegalStateException var9CE996783689A44496E32DC249802075_1236044797 = new IllegalStateException(e);
                var9CE996783689A44496E32DC249802075_1236044797.addTaint(taint);
                throw var9CE996783689A44496E32DC249802075_1236044797;
            } 
            sendStatus(REPORT_VALUE_RESULT_START, mTestResult);
            mTestResultCode = 0;
            mIsTimedTest = false;
            mIncludeDetailedStats = false;
            try 
            {
    if(testMethod != null && testMethod.isAnnotationPresent(TimedTest.class))                
                {
                    mIsTimedTest = true;
                    mIncludeDetailedStats = testMethod.getAnnotation(
                            TimedTest.class).includeDetailedStats();
                } 
                else
    if(test.getClass().isAnnotationPresent(TimedTest.class))                
                {
                    mIsTimedTest = true;
                    mIncludeDetailedStats = test.getClass().getAnnotation(
                            TimedTest.class).includeDetailedStats();
                } 
            } 
            catch (SecurityException e)
            {
            } 
    if(mIsTimedTest && mIncludeDetailedStats)            
            {
                mPerfCollector.beginSnapshot("");
            } 
            else
    if(mIsTimedTest)            
            {
                mPerfCollector.startTiming("");
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.087 -0400", hash_original_method = "E1F36AA4D0DD5E9460CB2F9E0E2A187E", hash_generated_method = "C819F8C7CED086B627F390906C31A129")
        public void addError(Test test, Throwable t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mTestResult.putString(REPORT_KEY_STACK, BaseTestRunner.getFilteredTrace(t));
            mTestResultCode = REPORT_VALUE_RESULT_ERROR;
            mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("\nError in %s:\n%s",
                    ((TestCase)test).getName(), BaseTestRunner.getFilteredTrace(t)));
            
            
            
            
                
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.087 -0400", hash_original_method = "61B6781BE7A090882DE772A402FB51FB", hash_generated_method = "540086748B2F91DB7E079689AB6E4256")
        public void addFailure(Test test, AssertionFailedError t) {
            addTaint(t.getTaint());
            addTaint(test.getTaint());
            mTestResult.putString(REPORT_KEY_STACK, BaseTestRunner.getFilteredTrace(t));
            mTestResultCode = REPORT_VALUE_RESULT_FAILURE;
            mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("\nFailure in %s:\n%s",
                    ((TestCase)test).getName(), BaseTestRunner.getFilteredTrace(t)));
            
            
            
            
                
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.087 -0400", hash_original_method = "A4B38798820C04F560554F93B29FD69B", hash_generated_method = "4CC6C4B92C2C5BC675E1D5D8A3723959")
        public void endTest(Test test) {
            addTaint(test.getTaint());
    if(mIsTimedTest && mIncludeDetailedStats)            
            {
                mTestResult.putAll(mPerfCollector.endSnapshot());
            } 
            else
    if(mIsTimedTest)            
            {
                writeStopTiming(mPerfCollector.stopTiming(""));
            } 
    if(mTestResultCode == 0)            
            {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT, ".");
            } 
            sendStatus(mTestResultCode, mTestResult);
            try 
            {
                Thread.sleep(mDelayMsec);
            } 
            catch (InterruptedException e)
            {
                IllegalStateException var9CE996783689A44496E32DC249802075_1279704197 = new IllegalStateException(e);
                var9CE996783689A44496E32DC249802075_1279704197.addTaint(taint);
                throw var9CE996783689A44496E32DC249802075_1279704197;
            } 
            
            
                
            
                
            
            
                
            
            
            
                
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.088 -0400", hash_original_method = "7E55B7BB14105B0B262F66875CE13D8A", hash_generated_method = "745BB27702083882F3AAEFD7555CB2D4")
        public void writeBeginSnapshot(String label) {
            addTaint(label.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.088 -0400", hash_original_method = "6245AA309FB3DEC287B93FD35979B625", hash_generated_method = "3EB31E55FA6984F69CCB349748A83A65")
        public void writeEndSnapshot(Bundle results) {
            addTaint(results.getTaint());
            mResults.putAll(results);
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.088 -0400", hash_original_method = "FCAABB153F24A8EFE140AE7259EB6B2D", hash_generated_method = "0DE1640F8BE992C82FE9ECB858F484AE")
        public void writeStartTiming(String label) {
            addTaint(label.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.089 -0400", hash_original_method = "DACFB75F59575B6C3A5EAE9698CE1C2C", hash_generated_method = "E46FBB119E774AFCF0A9E226BA53D2DE")
        public void writeStopTiming(Bundle results) {
            addTaint(results.getTaint());
            int i = 0;
for(Parcelable p : results.getParcelableArrayList(PerformanceCollector.METRIC_KEY_ITERATIONS))
            {
                Bundle iteration = (Bundle)p;
                String index = "iteration" + i + ".";
                mTestResult.putString(index + PerformanceCollector.METRIC_KEY_LABEL,
                        iteration.getString(PerformanceCollector.METRIC_KEY_LABEL));
                mTestResult.putLong(index + PerformanceCollector.METRIC_KEY_CPU_TIME,
                        iteration.getLong(PerformanceCollector.METRIC_KEY_CPU_TIME));
                mTestResult.putLong(index + PerformanceCollector.METRIC_KEY_EXECUTION_TIME,
                        iteration.getLong(PerformanceCollector.METRIC_KEY_EXECUTION_TIME));
                i++;
            } 
            
            
            
                    
                
                
                
                        
                
                        
                
                        
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.089 -0400", hash_original_method = "1954CD3982E421D110E41B97447F0A1C", hash_generated_method = "19FB104ABC338ED5C623D34141479F87")
        public void writeMeasurement(String label, long value) {
            addTaint(value);
            addTaint(label.getTaint());
            mTestResult.putLong(label, value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.089 -0400", hash_original_method = "B544B13CC37BDB1BC661657AE2F550F8", hash_generated_method = "207EF24503377CF46E62FC554A00F3AD")
        public void writeMeasurement(String label, float value) {
            addTaint(value);
            addTaint(label.getTaint());
            mTestResult.putFloat(label, value);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.090 -0400", hash_original_method = "6E66D1C63A065784B7DD47BA02ECF676", hash_generated_method = "B9F1FB7C9BD0BB35CCC90D8C9E91ACF9")
        public void writeMeasurement(String label, String value) {
            addTaint(value.getTaint());
            addTaint(label.getTaint());
            mTestResult.putString(label, value);
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.090 -0400", hash_original_field = "680B833A8AD8BA3349D1ADDF563FEDA7", hash_generated_field = "544F43E7EAEDE0F3FFF2026270B67E8F")

    public static final String ARGUMENT_TEST_CLASS = "class";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.090 -0400", hash_original_field = "D0B187F87A6783F5E724903CD92D2584", hash_generated_field = "61A1CE89468E456A6143B02D9D1238C3")

    public static final String ARGUMENT_TEST_PACKAGE = "package";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.090 -0400", hash_original_field = "6D16BB028E7F5E104CD27BFC528040E6", hash_generated_field = "5DC71B94542AF05C060A59423A46A76A")

    public static final String ARGUMENT_TEST_SIZE_PREDICATE = "size";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "962A45F269C881BDAD99AD7A69CBB866", hash_generated_field = "E4D5A73A648EEA7D95D39635EC2A18DC")

    public static final String ARGUMENT_DELAY_MSEC = "delay_msec";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "89E67944601172B93500701CF1FCFBF3", hash_generated_field = "3D8236D97469E58570ED55142783479C")

    private static final String SMALL_SUITE = "small";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "AEE89B219BD9AD9AFD827BC8C6705315", hash_generated_field = "B754DDFB963A97D2415FE8BBB1143D66")

    private static final String MEDIUM_SUITE = "medium";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "610F4FC5017F82872EC937900CC5E653", hash_generated_field = "F286B101C789E4032BEE582FB1285143")

    private static final String LARGE_SUITE = "large";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "17340BAF643C322B8085F65E6D0A6403", hash_generated_field = "4876AF80B10E4573D3890A893B4D249A")

    private static final String ARGUMENT_LOG_ONLY = "log";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "40C434885D6A04F28172A0DC0AB5D6DF", hash_generated_field = "FDAB7AA5BBA17336BF60EF624D90A67C")

    static final String ARGUMENT_ANNOTATION = "annotation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "CA34B0ED2808CE1354B10AC76EBC8F4C", hash_generated_field = "9CE3F7D7D38797568FD9463120C88BE7")

    static final String ARGUMENT_NOT_ANNOTATION = "notAnnotation";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "175A08AF1E5AED4D9E21D9C5086B5176", hash_generated_field = "091C0D8BF4769827A534FC280151B7B4")

    private static final float SMALL_SUITE_MAX_RUNTIME = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "3036AD96CBC39315F56079406883F47C", hash_generated_field = "48420791998550CDA648A038C6122DB7")

    private static final float MEDIUM_SUITE_MAX_RUNTIME = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "9FAE49A170810669AF74B5FA3CCD0470", hash_generated_field = "FF1D554A58D121C00260C5318CCE0D7D")

    public static final String REPORT_VALUE_ID = "InstrumentationTestRunner";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "6A407905B155CED52369083024E81CA8", hash_generated_field = "8604C63F5C7B8CED7552EA19100C1B95")

    public static final String REPORT_KEY_NUM_TOTAL = "numtests";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "4475CF3EC096881C496DBD0E23046D9F", hash_generated_field = "184A40546511D88041D0A2C4CFFF8F01")

    public static final String REPORT_KEY_NUM_CURRENT = "current";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "D7C8BCD6E06BAFC6FE0308F005B0737A", hash_generated_field = "4E399ED5BE42EBBFB03BC37FED768FE3")

    public static final String REPORT_KEY_NAME_CLASS = "class";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.091 -0400", hash_original_field = "81B491500739FA285353E5D9FD7A27CF", hash_generated_field = "F8AFCA65D0C7EDEA6238DDEA6C0E2C7A")

    public static final String REPORT_KEY_NAME_TEST = "test";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "41A77F02B14445DC0E04958453A3853D", hash_generated_field = "0DD89ADF1D7908DBA256A4F78710AC70")

    private static final String REPORT_KEY_RUN_TIME = "runtime";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "6401EE2ABFFD5AF5A1EDDFF29A1FB48E", hash_generated_field = "0648EBB0AA7417E3FFB0E5664C154E15")

    private static final String REPORT_KEY_NUM_ITERATIONS = "numiterations";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "9A5E0ECC5E4084207A474D298AA4B8CB", hash_generated_field = "C914CC1AEF0E2AA287E3DE25995A4B65")

    private static final String REPORT_KEY_SUITE_ASSIGNMENT = "suiteassignment";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "05DC77209A5D960E597EB38A4668F741", hash_generated_field = "E33466C3D4AA42A42AC46C0CCFED8A04")

    private static final String REPORT_KEY_COVERAGE_PATH = "coverageFilePath";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "CFB9A767DCD032AB4F854E3AD0B3544C", hash_generated_field = "A83BC0A82B464ECC311A8D0492203E1F")

    public static final int REPORT_VALUE_RESULT_START = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "BAD8FE26CB656CD83496A23E5B8D1484", hash_generated_field = "648D7DA2045D906D2B1AF3828EE7CF96")

    public static final int REPORT_VALUE_RESULT_OK = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "6BCE3519B99C4CF6908F01EB9CCCEBFF", hash_generated_field = "2D1B0116564943EB2363EBD41735FAFD")

    public static final int REPORT_VALUE_RESULT_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "DE4EF8420ECB4D1CDC64B13DBECB5770", hash_generated_field = "EB5283F615E0CDF99EB813258804C3EA")

    public static final int REPORT_VALUE_RESULT_FAILURE = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "1725F6AFF1A343C0AB49D753C3B85616", hash_generated_field = "D02BF0791E843808157F866DD068993C")

    public static final String REPORT_KEY_STACK = "stack";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "FDE93756F572FA4E2E672DD5852767A4", hash_generated_field = "B1A8948A59EA4FF3FD3C9F7AC5A8070A")

    private static final String DEFAULT_COVERAGE_FILE_NAME = "coverage.ec";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.092 -0400", hash_original_field = "4F95FF45110AADC53CCF67A9C3F7A727", hash_generated_field = "797E456CAAADD3A4FF0634549F39725A")

    private static final String LOG_TAG = "InstrumentationTestRunner";
}

