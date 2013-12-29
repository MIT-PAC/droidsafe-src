package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
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

import com.android.internal.util.Predicate;
import com.android.internal.util.Predicates;






public class InstrumentationTestRunner extends Instrumentation implements TestSuiteProvider {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.796 -0500", hash_original_field = "F6DC7A69727E302F27AAEEE17DCE544E", hash_generated_field = "544F43E7EAEDE0F3FFF2026270B67E8F")

    public static final String ARGUMENT_TEST_CLASS = "class";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.797 -0500", hash_original_field = "DAE47139F19E8856638BBD3D2536C377", hash_generated_field = "61A1CE89468E456A6143B02D9D1238C3")

    public static final String ARGUMENT_TEST_PACKAGE = "package";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.797 -0500", hash_original_field = "850A636A868320D13577B8363E400126", hash_generated_field = "5DC71B94542AF05C060A59423A46A76A")

    public static final String ARGUMENT_TEST_SIZE_PREDICATE = "size";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.798 -0500", hash_original_field = "1FBB4A70C874405F10FC9A9E28EC977A", hash_generated_field = "E4D5A73A648EEA7D95D39635EC2A18DC")

    public static final String ARGUMENT_DELAY_MSEC = "delay_msec";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.799 -0500", hash_original_field = "8BF75D0874F677BE850CEEDAB7BA7F06", hash_generated_field = "3D8236D97469E58570ED55142783479C")


    private static final String SMALL_SUITE = "small";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.800 -0500", hash_original_field = "BAC6661461C176FC9824744B578F9BD6", hash_generated_field = "B754DDFB963A97D2415FE8BBB1143D66")

    private static final String MEDIUM_SUITE = "medium";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.801 -0500", hash_original_field = "6D04331DF66BEBBE6F2F4007BCD9B56E", hash_generated_field = "F286B101C789E4032BEE582FB1285143")

    private static final String LARGE_SUITE = "large";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.801 -0500", hash_original_field = "012A4C807171B3370D28FCB605D5D1AA", hash_generated_field = "4876AF80B10E4573D3890A893B4D249A")


    private static final String ARGUMENT_LOG_ONLY = "log";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.802 -0500", hash_original_field = "B48D839B19844E1FFD00D9200547FE2B", hash_generated_field = "FDAB7AA5BBA17336BF60EF624D90A67C")

    static final String ARGUMENT_ANNOTATION = "annotation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.803 -0500", hash_original_field = "823E94A1D6375AFA35B0076F6DAAE791", hash_generated_field = "9CE3F7D7D38797568FD9463120C88BE7")

    static final String ARGUMENT_NOT_ANNOTATION = "notAnnotation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.804 -0500", hash_original_field = "C30D8F11BFC77FAFFBB31FA8FCCB9D71", hash_generated_field = "091C0D8BF4769827A534FC280151B7B4")

    private static final float SMALL_SUITE_MAX_RUNTIME = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.805 -0500", hash_original_field = "C0B03C0DA0CD55E64EC4F1DC66212205", hash_generated_field = "48420791998550CDA648A038C6122DB7")

    private static final float MEDIUM_SUITE_MAX_RUNTIME = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:34:08.538 -0500", hash_original_field = "FA35E06B0E20538B6CDBA0D3DD96B1E4", hash_generated_field = "A4E8038785072B6F7F03B3AA288BCAEE")


    /**
     * This value, if stored with key {@link android.app.Instrumentation#REPORT_KEY_IDENTIFIER},
     * identifies InstrumentationTestRunner as the source of the report.  This is sent with all
     * status messages.
     */
    public static final String REPORT_VALUE_ID = "InstrumentationTestRunner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.807 -0500", hash_original_field = "0732C7C69EEB33BC76DC1F3D000DA8B2", hash_generated_field = "8604C63F5C7B8CED7552EA19100C1B95")

    public static final String REPORT_KEY_NUM_TOTAL = "numtests";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.808 -0500", hash_original_field = "D5D564311F37AE757CA4BB3B3557750E", hash_generated_field = "184A40546511D88041D0A2C4CFFF8F01")

    public static final String REPORT_KEY_NUM_CURRENT = "current";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.809 -0500", hash_original_field = "B8C41E5D3C5D7BFBC71DBCBEF35371FC", hash_generated_field = "4E399ED5BE42EBBFB03BC37FED768FE3")

    public static final String REPORT_KEY_NAME_CLASS = "class";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.810 -0500", hash_original_field = "47A7A29D6B107DB99CA5147AAD84572E", hash_generated_field = "F8AFCA65D0C7EDEA6238DDEA6C0E2C7A")

    public static final String REPORT_KEY_NAME_TEST = "test";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.811 -0500", hash_original_field = "E13384B2292C92EB288A203EEECFCFE9", hash_generated_field = "0DD89ADF1D7908DBA256A4F78710AC70")

    private static final String REPORT_KEY_RUN_TIME = "runtime";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.812 -0500", hash_original_field = "F7C1236148E2FA25C5DD6E0E41DE797F", hash_generated_field = "0648EBB0AA7417E3FFB0E5664C154E15")

    private static final String REPORT_KEY_NUM_ITERATIONS = "numiterations";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.813 -0500", hash_original_field = "3BC6A57D815FFDF29931F1EB51D67D72", hash_generated_field = "C914CC1AEF0E2AA287E3DE25995A4B65")

    private static final String REPORT_KEY_SUITE_ASSIGNMENT = "suiteassignment";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.814 -0500", hash_original_field = "9F3DDD71326CF699CC23FBD095B73A3B", hash_generated_field = "E33466C3D4AA42A42AC46C0CCFED8A04")

    private static final String REPORT_KEY_COVERAGE_PATH = "coverageFilePath";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.815 -0500", hash_original_field = "F5D746BC7F0BE2F119B48FBBC3DCF9F1", hash_generated_field = "A83BC0A82B464ECC311A8D0492203E1F")

    public static final int REPORT_VALUE_RESULT_START = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.815 -0500", hash_original_field = "E24AD2DF569ADDBB18DC6914DFF82641", hash_generated_field = "648D7DA2045D906D2B1AF3828EE7CF96")

    public static final int REPORT_VALUE_RESULT_OK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.816 -0500", hash_original_field = "A9A123B319D27FE1EBE9127289CB4842", hash_generated_field = "2D1B0116564943EB2363EBD41735FAFD")

    public static final int REPORT_VALUE_RESULT_ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.817 -0500", hash_original_field = "553ABD6B895B542408A0126DA8C15372", hash_generated_field = "EB5283F615E0CDF99EB813258804C3EA")

    public static final int REPORT_VALUE_RESULT_FAILURE = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.818 -0500", hash_original_field = "B6BDA7821ADE320C16834F8C18D9F404", hash_generated_field = "D02BF0791E843808157F866DD068993C")

    public static final String REPORT_KEY_STACK = "stack";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.819 -0500", hash_original_field = "F4AF382F7680E6516B2B4AFB27560A0E", hash_generated_field = "B1A8948A59EA4FF3FD3C9F7AC5A8070A")

    private static final String DEFAULT_COVERAGE_FILE_NAME = "coverage.ec";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.820 -0500", hash_original_field = "F19C64FD209D635F9DB5130F38335C7D", hash_generated_field = "797E456CAAADD3A4FF0634549F39725A")


    private static final String LOG_TAG = "InstrumentationTestRunner";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.821 -0500", hash_original_field = "7A81CF352B7668AE61BB8040836E73FD", hash_generated_field = "57041D8C5014DE6D87A28603CC7822CE")


    private final Bundle mResults = new Bundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.822 -0500", hash_original_field = "BC54B63AEA85D845C1AC338D041E1ED5", hash_generated_field = "141E060C3952C133ADC3DF31048B4376")

    private Bundle mArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.823 -0500", hash_original_field = "A949B8F5E4E171BD0FB70E396ED98905", hash_generated_field = "0C2BC6A40B4FAAAD4ADDFF4CB98782DA")

    private AndroidTestRunner mTestRunner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.824 -0500", hash_original_field = "AEF6B9BB655763364D4271078CA476DE", hash_generated_field = "4C294409170D3110EF12CA3CCED984A1")

    private boolean mDebug;

    
    private class StringResultPrinter extends ResultPrinter {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.850 -0500", hash_original_method = "8278F372BF23485BBE56A9ABFE31E2B0", hash_generated_method = "979D4DF7C20AB12E89D99335FC1CCDD3")
        public StringResultPrinter(PrintStream writer) {
            super(writer);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.851 -0500", hash_original_method = "D5539E1607000A054CE19EDFAB1372FF", hash_generated_method = "34D3B2CC679CA8D74421C96A2C427A16")
        synchronized void print(TestResult result, long runTime) {
            printHeader(runTime);
            printFooter(result);
        }

        
    }


    
    private class SuiteAssignmentPrinter implements TestListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.852 -0500", hash_original_field = "671EF5CCCE64ABF621E6F60CFC0B1CEB", hash_generated_field = "EDD0604A9657EE882307103F9DDCC22C")


        private Bundle mTestResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.853 -0500", hash_original_field = "3C3A30DDD94D9D47CBB52C3848791CE7", hash_generated_field = "20EEDA67D8E4F20D3E4CA3D911CCA492")

        private long mStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.854 -0500", hash_original_field = "70C1C345A39DB06FF39288963005B239", hash_generated_field = "CE198E728D2042BC4D1888DF0457D27B")

        private long mEndTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.855 -0500", hash_original_field = "DACBF299EB4D1FCA4CBF7E7888FEE933", hash_generated_field = "079233BE186E56546663F1E57D6A9B4C")

        private boolean mTimingValid;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.856 -0500", hash_original_method = "7306BE02962886D6C53070D35D513D17", hash_generated_method = "88C7580DB352E7C5C79EC31E828B9A7C")
        public SuiteAssignmentPrinter() {
        }

        /**
         * send a status for the start of a each test, so long tests can be seen as "running"
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.857 -0500", hash_original_method = "5FFF4B907A3EDB23E7C228BF47F3F987", hash_generated_method = "76D5886473A7D16C3BEA42F2523EF201")
        public void startTest(Test test) {
            mTimingValid = true;
            mStartTime = System.currentTimeMillis();
        }

        /**
         * @see junit.framework.TestListener#addError(Test, Throwable)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.858 -0500", hash_original_method = "345E3DE2999C1B6FA0060A48165FC0F3", hash_generated_method = "4B50A1FF289293A64154A452B2B48E37")
        public void addError(Test test, Throwable t) {
            mTimingValid = false;
        }

        /**
         * @see junit.framework.TestListener#addFailure(Test, AssertionFailedError)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.859 -0500", hash_original_method = "F3D48E32FED097901DB6EC97B8BA5D91", hash_generated_method = "243BC8D2F758A5D490A506B60CA7FFD9")
        public void addFailure(Test test, AssertionFailedError t) {
            mTimingValid = false;
        }

        /**
         * @see junit.framework.TestListener#endTest(Test)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.860 -0500", hash_original_method = "689FF998C59CF6C00229049B71C475A7", hash_generated_method = "B00DBFD3E64E1E6FB7A9D062816FA988")
        public void endTest(Test test) {
            float runTime;
            String assignmentSuite;
            mEndTime = System.currentTimeMillis();
            mTestResult = new Bundle();

            if (!mTimingValid || mStartTime < 0) {
                assignmentSuite = "NA";
                runTime = -1;
            } else {
                runTime = mEndTime - mStartTime;
                if (runTime < SMALL_SUITE_MAX_RUNTIME
                        && !InstrumentationTestCase.class.isAssignableFrom(test.getClass())) {
                    assignmentSuite = SMALL_SUITE;
                } else if (runTime < MEDIUM_SUITE_MAX_RUNTIME) {
                    assignmentSuite = MEDIUM_SUITE;
                } else {
                    assignmentSuite = LARGE_SUITE;
                }
            }
            // Clear mStartTime so that we can verify that it gets set next time.
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.862 -0500", hash_original_field = "637248878ECDDA1D198C7713E86C6649", hash_generated_field = "8CC2E860F13B0FB54DCF8D3075E5FD80")

        private  Bundle mResultTemplate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.863 -0500", hash_original_field = "671EF5CCCE64ABF621E6F60CFC0B1CEB", hash_generated_field = "671EF5CCCE64ABF621E6F60CFC0B1CEB")

        Bundle mTestResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.863 -0500", hash_original_field = "2BA1BF5CC1D20E4D04C04FBE333F6E26", hash_generated_field = "2BA1BF5CC1D20E4D04C04FBE333F6E26")

        int mTestNum = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.864 -0500", hash_original_field = "5159AE5BB82C390FF229EF7E789C498A", hash_generated_field = "5159AE5BB82C390FF229EF7E789C498A")

        int mTestResultCode = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.865 -0500", hash_original_field = "74A0FE6C36B53C52A2FFA32CDE32656B", hash_generated_field = "74A0FE6C36B53C52A2FFA32CDE32656B")

        String mTestClass = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.866 -0500", hash_original_field = "FB38EF7819F1C7E367EE6C6D724EEE31", hash_generated_field = "FB38EF7819F1C7E367EE6C6D724EEE31")

        PerformanceCollector mPerfCollector = new PerformanceCollector();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.866 -0500", hash_original_field = "927068CD6900F1BBDDB652AF2FC80A7E", hash_generated_field = "927068CD6900F1BBDDB652AF2FC80A7E")

        boolean mIsTimedTest = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.867 -0500", hash_original_field = "142F76D07E81C97A91E7F404C5DD8F94", hash_generated_field = "142F76D07E81C97A91E7F404C5DD8F94")

        boolean mIncludeDetailedStats = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.868 -0500", hash_original_method = "B96CCA607C0FAF94BB8309C0E96C551A", hash_generated_method = "AD1E94C69ADDE10DF5C0013FD501BF1E")
        public WatcherResultPrinter(int numTests) {
            mResultTemplate = new Bundle();
            mResultTemplate.putString(Instrumentation.REPORT_KEY_IDENTIFIER, REPORT_VALUE_ID);
            mResultTemplate.putInt(REPORT_KEY_NUM_TOTAL, numTests);
        }

        /**
         * send a status for the start of a each test, so long tests can be seen
         * as "running"
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.870 -0500", hash_original_method = "31528962776A4296CB5B735981815A21", hash_generated_method = "186B8F2FBB52DC26F824F7EE78727CF3")
        public void startTest(Test test) {
            String testClass = test.getClass().getName();
            String testName = ((TestCase)test).getName();
            mTestResult = new Bundle(mResultTemplate);
            mTestResult.putString(REPORT_KEY_NAME_CLASS, testClass);
            mTestResult.putString(REPORT_KEY_NAME_TEST, testName);
            mTestResult.putInt(REPORT_KEY_NUM_CURRENT, ++mTestNum);
            // pretty printing
            if (testClass != null && !testClass.equals(mTestClass)) {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                        String.format("\n%s:", testClass));
                mTestClass = testClass;
            } else {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT, "");
            }

            Method testMethod = null;
            try {
                testMethod = test.getClass().getMethod(testName);
                // Report total number of iterations, if test is repetitive
                if (testMethod.isAnnotationPresent(RepetitiveTest.class)) {
                    int numIterations = testMethod.getAnnotation(
                        RepetitiveTest.class).numIterations();
                    mTestResult.putInt(REPORT_KEY_NUM_ITERATIONS, numIterations);
                }
            } catch (NoSuchMethodException e) {
                // ignore- the test with given name does not exist. Will be handled during test
                // execution
            }

            // The delay_msec parameter is normally used to provide buffers of idle time
            // for power measurement purposes. To make sure there is a delay before and after
            // every test in a suite, we delay *after* every test (see endTest below) and also
            // delay *before* the first test. So, delay test1 delay test2 delay.

            try {
                if (mTestNum == 1) Thread.sleep(mDelayMsec);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            sendStatus(REPORT_VALUE_RESULT_START, mTestResult);
            mTestResultCode = 0;

            mIsTimedTest = false;
            mIncludeDetailedStats = false;
            try {
                // Look for TimedTest annotation on both test class and test method
                if (testMethod != null && testMethod.isAnnotationPresent(TimedTest.class)) {
                    mIsTimedTest = true;
                    mIncludeDetailedStats = testMethod.getAnnotation(
                            TimedTest.class).includeDetailedStats();
                } else if (test.getClass().isAnnotationPresent(TimedTest.class)) {
                    mIsTimedTest = true;
                    mIncludeDetailedStats = test.getClass().getAnnotation(
                            TimedTest.class).includeDetailedStats();
                }
            } catch (SecurityException e) {
                // ignore - the test with given name cannot be accessed. Will be handled during
                // test execution
            }

            if (mIsTimedTest && mIncludeDetailedStats) {
                mPerfCollector.beginSnapshot("");
            } else if (mIsTimedTest) {
                mPerfCollector.startTiming("");
            }
        }

        /**
         * @see junit.framework.TestListener#addError(Test, Throwable)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.871 -0500", hash_original_method = "E1F36AA4D0DD5E9460CB2F9E0E2A187E", hash_generated_method = "A56F47B3FF3D0E4C4593326A5A8A1902")
        public void addError(Test test, Throwable t) {
            mTestResult.putString(REPORT_KEY_STACK, BaseTestRunner.getFilteredTrace(t));
            mTestResultCode = REPORT_VALUE_RESULT_ERROR;
            // pretty printing
            mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("\nError in %s:\n%s",
                    ((TestCase)test).getName(), BaseTestRunner.getFilteredTrace(t)));
        }

        /**
         * @see junit.framework.TestListener#addFailure(Test, AssertionFailedError)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.872 -0500", hash_original_method = "61B6781BE7A090882DE772A402FB51FB", hash_generated_method = "CC3EF69BC324FD30E2208E1B2A5D8A48")
        public void addFailure(Test test, AssertionFailedError t) {
            mTestResult.putString(REPORT_KEY_STACK, BaseTestRunner.getFilteredTrace(t));
            mTestResultCode = REPORT_VALUE_RESULT_FAILURE;
            // pretty printing
            mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("\nFailure in %s:\n%s",
                    ((TestCase)test).getName(), BaseTestRunner.getFilteredTrace(t)));
        }

        /**
         * @see junit.framework.TestListener#endTest(Test)
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.872 -0500", hash_original_method = "A4B38798820C04F560554F93B29FD69B", hash_generated_method = "7C3EC9EA14BA967536321244828364B3")
        public void endTest(Test test) {
            if (mIsTimedTest && mIncludeDetailedStats) {
                mTestResult.putAll(mPerfCollector.endSnapshot());
            } else if (mIsTimedTest) {
                writeStopTiming(mPerfCollector.stopTiming(""));
            }

            if (mTestResultCode == 0) {
                mTestResult.putString(Instrumentation.REPORT_KEY_STREAMRESULT, ".");
            }
            sendStatus(mTestResultCode, mTestResult);

            try { // Sleep after every test, if specified
                Thread.sleep(mDelayMsec);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.873 -0500", hash_original_method = "7E55B7BB14105B0B262F66875CE13D8A", hash_generated_method = "0AD0EE3351627F67617AFC187160B4F6")
        public void writeBeginSnapshot(String label) {
            // Do nothing
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.874 -0500", hash_original_method = "6245AA309FB3DEC287B93FD35979B625", hash_generated_method = "91DEC90CE194A62B8AE86F648E04ECFD")
        public void writeEndSnapshot(Bundle results) {
            // Copy all snapshot data fields into mResults, which is outputted
            // via Instrumentation.finish
            mResults.putAll(results);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.875 -0500", hash_original_method = "FCAABB153F24A8EFE140AE7259EB6B2D", hash_generated_method = "D27473575E876C3BA2327F53FF1B8C11")
        public void writeStartTiming(String label) {
            // Do nothing
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.876 -0500", hash_original_method = "DACFB75F59575B6C3A5EAE9698CE1C2C", hash_generated_method = "58E5F5948F191629F90BD5D13D0E6DF6")
        public void writeStopTiming(Bundle results) {
            // Copy results into mTestResult by flattening list of iterations,
            // which is outputted via WatcherResultPrinter.endTest
            int i = 0;
            for (Parcelable p :
                    results.getParcelableArrayList(PerformanceCollector.METRIC_KEY_ITERATIONS)) {
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.877 -0500", hash_original_method = "1954CD3982E421D110E41B97447F0A1C", hash_generated_method = "D0414868220965DD41EF564A4466742A")
        public void writeMeasurement(String label, long value) {
            mTestResult.putLong(label, value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.878 -0500", hash_original_method = "B544B13CC37BDB1BC661657AE2F550F8", hash_generated_method = "CA6B8694A91CCBCC71023787FC9ABF7E")
        public void writeMeasurement(String label, float value) {
            mTestResult.putFloat(label, value);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.878 -0500", hash_original_method = "6E66D1C63A065784B7DD47BA02ECF676", hash_generated_method = "6D825DAB0F961FC1C7F1C6E000DAEDED")
        public void writeMeasurement(String label, String value) {
            mTestResult.putString(label, value);
        }

        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.824 -0500", hash_original_field = "3EA1F0EA0E7F068FBD0557879F7C5A01", hash_generated_field = "3F2709EEC2B2C2F043111479DDADB3D4")

    private boolean mJustCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.827 -0500", hash_original_field = "74E7A8567822CE6952812CF05B16F2CA", hash_generated_field = "ACA828682E2C6ECC613CA27863C2264D")

    private boolean mSuiteAssignmentMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.827 -0500", hash_original_field = "82A59D887121587E5640473FCE704234", hash_generated_field = "78B349732F0D9D6BFA04A40FFFB14ACA")

    private int mTestCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.828 -0500", hash_original_field = "96E52D017FA6349EA7A57834367771EC", hash_generated_field = "AD7F82C5377D8DBE525A22C459787867")

    private String mPackageOfTests;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.829 -0500", hash_original_field = "4AB2BC19D4DC7D0C87171A6197AAEA10", hash_generated_field = "39025D4B0FB339CA8809220E55135D9A")

    private boolean mCoverage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.830 -0500", hash_original_field = "66C2EBC9084CDE67722D72F26C6AD864", hash_generated_field = "7CFA27D3752B16D4570E1B9BF2B33568")

    private String mCoverageFilePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.830 -0500", hash_original_field = "31CE8CA58E265F7CDBF4F23A10C86C24", hash_generated_field = "DA6E4F18E5C9B928AFD0A314A6DD8344")

    private int mDelayMsec;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.710 -0400", hash_original_method = "4F1BA42F3F5EBFB30B61E510F40B73D6", hash_generated_method = "4F1BA42F3F5EBFB30B61E510F40B73D6")
    public InstrumentationTestRunner ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.832 -0500", hash_original_method = "6DFE69C7BEAD4ACC310BC8D2DE157051", hash_generated_method = "5F54A2F119260F58EC3AAFFCECDA7BF4")
    @Override
public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        mArguments = arguments;

        // Apk paths used to search for test classes when using TestSuiteBuilders.
        String[] apkPaths =
                {getTargetContext().getPackageCodePath(), getContext().getPackageCodePath()};
        ClassPathPackageInfoSource.setApkPaths(apkPaths);

        Predicate<TestMethod> testSizePredicate = null;
        Predicate<TestMethod> testAnnotationPredicate = null;
        Predicate<TestMethod> testNotAnnotationPredicate = null;
        String testClassesArg = null;
        boolean logOnly = false;

        if (arguments != null) {
            // Test class name passed as an argument should override any meta-data declaration.
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

            try {
                Object delay = arguments.get(ARGUMENT_DELAY_MSEC);  // Accept either string or int
                if (delay != null) mDelayMsec = Integer.parseInt(delay.toString());
            } catch (NumberFormatException e) {
                Log.e(LOG_TAG, "Invalid delay_msec parameter", e);
            }
        }

        TestSuiteBuilder testSuiteBuilder = new TestSuiteBuilder(getClass().getName(),
                getTargetContext().getClassLoader());

        if (testSizePredicate != null) {
            testSuiteBuilder.addRequirements(testSizePredicate);
        }
        if (testAnnotationPredicate != null) {
            testSuiteBuilder.addRequirements(testAnnotationPredicate);
        }
        if (testNotAnnotationPredicate != null) {
            testSuiteBuilder.addRequirements(testNotAnnotationPredicate);
        }

        if (testClassesArg == null) {
            if (mPackageOfTests != null) {
                testSuiteBuilder.includePackages(mPackageOfTests);
            } else {
                TestSuite testSuite = getTestSuite();
                if (testSuite != null) {
                    testSuiteBuilder.addTestSuite(testSuite);
                } else {
                    // no package or class bundle arguments were supplied, and no test suite
                    // provided so add all tests in application
                    testSuiteBuilder.includePackages("");
                }
            }
        } else {
            parseTestClasses(testClassesArg, testSuiteBuilder);
        }

        testSuiteBuilder.addRequirements(getBuilderRequirements());

        mTestRunner = getAndroidTestRunner();
        mTestRunner.setContext(getTargetContext());
        mTestRunner.setInstrumentation(this);
        mTestRunner.setSkipExecution(logOnly);
        mTestRunner.setTest(testSuiteBuilder.build());
        mTestCount = mTestRunner.getTestCases().size();
        if (mSuiteAssignmentMode) {
            mTestRunner.addTestListener(new SuiteAssignmentPrinter());
        } else {
            WatcherResultPrinter resultPrinter = new WatcherResultPrinter(mTestCount);
            mTestRunner.addTestListener(new TestPrinter("TestRunner", false));
            mTestRunner.addTestListener(resultPrinter);
            mTestRunner.setPerformanceResultsWriter(resultPrinter);
        }
        start();
    }

    /**
     * Get the Bundle object that contains the arguments
     *
     * @return the Bundle object
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.833 -0500", hash_original_method = "10E6FBEC332CFAAD363071CF1888C5BE", hash_generated_method = "6C7A0038EBB9A91141FF4702B527B9B7")
    public Bundle getBundle(){
        return mArguments;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.834 -0500", hash_original_method = "DCDBF8FA39FD6057A0486A2DA30868B2", hash_generated_method = "DCDBF8FA39FD6057A0486A2DA30868B2")
    List<Predicate<TestMethod>> getBuilderRequirements() {
        return new ArrayList<Predicate<TestMethod>>();
    }

    /**
     * Parses and loads the specified set of test classes
     *
     * @param testClassArg - comma-separated list of test classes and methods
     * @param testSuiteBuilder - builder to add tests to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.835 -0500", hash_original_method = "F83C1F460CEFDE714C6876815B6DE46B", hash_generated_method = "13638EB57CF94D33F1BF62C549AFB267")
    private void parseTestClasses(String testClassArg, TestSuiteBuilder testSuiteBuilder) {
        String[] testClasses = testClassArg.split(",");
        for (String testClass : testClasses) {
            parseTestClass(testClass, testSuiteBuilder);
        }
    }

    /**
     * Parse and load the given test class and, optionally, method
     *
     * @param testClassName - full package name of test class and optionally method to add.
     *        Expected format: com.android.TestClass#testMethod
     * @param testSuiteBuilder - builder to add tests to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.836 -0500", hash_original_method = "0276346FF35DC079CD9DD44ABC105E23", hash_generated_method = "016A39E64874E99BBB7D8F29F651B09A")
    private void parseTestClass(String testClassName, TestSuiteBuilder testSuiteBuilder) {
        int methodSeparatorIndex = testClassName.indexOf('#');
        String testMethodName = null;

        if (methodSeparatorIndex > 0) {
            testMethodName = testClassName.substring(methodSeparatorIndex + 1);
            testClassName = testClassName.substring(0, methodSeparatorIndex);
        }
        testSuiteBuilder.addTestClassByName(testClassName, testMethodName, getTargetContext());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.837 -0500", hash_original_method = "59FA7210DE5A9B3F31249CF283F3E831", hash_generated_method = "0583EE806DD8676EAA23920EE014EDF1")
    protected AndroidTestRunner getAndroidTestRunner() {
        return new AndroidTestRunner();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.838 -0500", hash_original_method = "770E3D4317847EA06A1A186F0C988E4F", hash_generated_method = "666D6986B06EC570ABC5ABBBF814B0DD")
    private boolean getBooleanArgument(Bundle arguments, String tag) {
        String tagString = arguments.getString(tag);
        return tagString != null && Boolean.parseBoolean(tagString);
    }

    /*
     * Returns the size predicate object, corresponding to the "size" argument value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.838 -0500", hash_original_method = "778052CD062ADF4C5333CE80FB346BD7", hash_generated_method = "6017A2C480C7349DEB143945E105F513")
    private Predicate<TestMethod> getSizePredicateFromArg(String sizeArg) {

        if (SMALL_SUITE.equals(sizeArg)) {
            return TestPredicates.SELECT_SMALL;
        } else if (MEDIUM_SUITE.equals(sizeArg)) {
            return TestPredicates.SELECT_MEDIUM;
        } else if (LARGE_SUITE.equals(sizeArg)) {
            return TestPredicates.SELECT_LARGE;
        } else {
            return null;
        }
    }

   /**
    * Returns the test predicate object, corresponding to the annotation class value provided via
    * the {@link ARGUMENT_ANNOTATION} argument.
    *
    * @return the predicate or <code>null</code>
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.839 -0500", hash_original_method = "35F9B1C0A7B938B1EE66EE52909CB858", hash_generated_method = "674082B19D11D4EEDB83B4F640690211")
    private Predicate<TestMethod> getAnnotationPredicate(String annotationClassName) {
        Class<? extends Annotation> annotationClass = getAnnotationClass(annotationClassName);
        if (annotationClass != null) {
            return new HasAnnotation(annotationClass);
        }
        return null;
    }

    /**
     * Returns the negative test predicate object, corresponding to the annotation class value
     * provided via the {@link ARGUMENT_NOT_ANNOTATION} argument.
     *
     * @return the predicate or <code>null</code>
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.840 -0500", hash_original_method = "4E674ABAF10B3DBE6E2E2F43854FE054", hash_generated_method = "0AD0395672AC23583378108FA947B8B5")
    private Predicate<TestMethod> getNotAnnotationPredicate(String annotationClassName) {
         Class<? extends Annotation> annotationClass = getAnnotationClass(annotationClassName);
         if (annotationClass != null) {
             return Predicates.not(new HasAnnotation(annotationClass));
         }
         return null;
     }

    /**
     * Helper method to return the annotation class with specified name
     *
     * @param annotationClassName the fully qualified name of the class
     * @return the annotation class or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.841 -0500", hash_original_method = "7CC1EF53DD56AF5F60DBA3D3D6AD7EDD", hash_generated_method = "6B8DF69971E6B2D9583F74567BB2A025")
    private Class<? extends Annotation> getAnnotationClass(String annotationClassName) {
        if (annotationClassName == null) {
            return null;
        }
        try {
           Class<?> annotationClass = Class.forName(annotationClassName);
           if (annotationClass.isAnnotation()) {
               return (Class<? extends Annotation>)annotationClass;
           } else {
               Log.e(LOG_TAG, String.format("Provided annotation value %s is not an Annotation",
                       annotationClassName));
           }
        } catch (ClassNotFoundException e) {
            Log.e(LOG_TAG, String.format("Could not find class for specified annotation %s",
                    annotationClassName));
        }
        return null;
    }

    /**
     * Initialize the current thread as a looper.
     * <p/>
     * Exposed for unit testing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.842 -0500", hash_original_method = "3F6FAB1D23BC515BB2AF6438AF3536A0", hash_generated_method = "3F6FAB1D23BC515BB2AF6438AF3536A0")
    void prepareLooper() {
        Looper.prepare();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.844 -0500", hash_original_method = "13B14429707EB691EB642DFE530B7FBA", hash_generated_method = "8466CB24FAE080769F5F4056B29BECFD")
    @Override
public void onStart() {
        prepareLooper();

        if (mJustCount) {
            mResults.putString(Instrumentation.REPORT_KEY_IDENTIFIER, REPORT_VALUE_ID);
            mResults.putInt(REPORT_KEY_NUM_TOTAL, mTestCount);
            finish(Activity.RESULT_OK, mResults);
        } else {
            if (mDebug) {
                Debug.waitForDebugger();
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream writer = new PrintStream(byteArrayOutputStream);
            try {
                StringResultPrinter resultPrinter = new StringResultPrinter(writer);

                mTestRunner.addTestListener(resultPrinter);

                long startTime = System.currentTimeMillis();
                mTestRunner.runTest();
                long runTime = System.currentTimeMillis() - startTime;

                resultPrinter.print(mTestRunner.getTestResult(), runTime);
            } catch (Throwable t) {
                // catch all exceptions so a more verbose error message can be outputted
                writer.println(String.format("Test run aborted due to unexpected exception: %s",
                                t.getMessage()));
                t.printStackTrace(writer);
            } finally {
                mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                        String.format("\nTest results for %s=%s",
                        mTestRunner.getTestClassName(),
                        byteArrayOutputStream.toString()));

                if (mCoverage) {
                    generateCoverageReport();
                }
                writer.close();

                finish(Activity.RESULT_OK, mResults);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.845 -0500", hash_original_method = "C0E8619C87A7687A5C08E209915D7E38", hash_generated_method = "68260EC18F5228FCAE4521B9ED77E2B4")
    public TestSuite getTestSuite() {
        return getAllTests();
    }

    /**
     * Override this to define all of the tests to run in your package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.845 -0500", hash_original_method = "BB818280151C8C17876053BFAB976A70", hash_generated_method = "58939AB9E318F6CEC968766EDE84138B")
    public TestSuite getAllTests() {
        return null;
    }

    /**
     * Override this to provide access to the class loader of your package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.846 -0500", hash_original_method = "9B48FC3FBC8B24E9AD86091F7F4B768A", hash_generated_method = "F49023EB57B98D8C4E7D99716CF879A7")
    public ClassLoader getLoader() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.847 -0500", hash_original_method = "C84559B4D56F542F69C4278CF0320D22", hash_generated_method = "A2A56B2752C42F4BF0472BA7D64B9338")
    private void generateCoverageReport() {
        // use reflection to call emma dump coverage method, to avoid
        // always statically compiling against emma jar
        String coverageFilePath = getCoverageFilePath();
        java.io.File coverageFile = new java.io.File(coverageFilePath);
        try {
            Class<?> emmaRTClass = Class.forName("com.vladium.emma.rt.RT");
            Method dumpCoverageMethod = emmaRTClass.getMethod("dumpCoverageData",
                    coverageFile.getClass(), boolean.class, boolean.class);

            dumpCoverageMethod.invoke(null, coverageFile, false, false);
            // output path to generated coverage file so it can be parsed by a test harness if
            // needed
            mResults.putString(REPORT_KEY_COVERAGE_PATH, coverageFilePath);
            // also output a more user friendly msg
            final String currentStream = mResults.getString(
                    Instrumentation.REPORT_KEY_STREAMRESULT);
            mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT,
                String.format("%s\nGenerated code coverage data to %s", currentStream,
                coverageFilePath));
        } catch (ClassNotFoundException e) {
            reportEmmaError("Is emma jar on classpath?", e);
        } catch (SecurityException e) {
            reportEmmaError(e);
        } catch (NoSuchMethodException e) {
            reportEmmaError(e);
        } catch (IllegalArgumentException e) {
            reportEmmaError(e);
        } catch (IllegalAccessException e) {
            reportEmmaError(e);
        } catch (InvocationTargetException e) {
            reportEmmaError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.848 -0500", hash_original_method = "51747DDF7CE66070F16DA4762443E683", hash_generated_method = "8A68CC7B3FC1640FEA6F440A542A67F3")
    private String getCoverageFilePath() {
        if (mCoverageFilePath == null) {
            return getTargetContext().getFilesDir().getAbsolutePath() + File.separator +
                   DEFAULT_COVERAGE_FILE_NAME;
        } else {
            return mCoverageFilePath;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.848 -0500", hash_original_method = "5659030AB519EAF8BB83496F91E164E4", hash_generated_method = "75B804D15CAE486DE73CE7493B35D222")
    private void reportEmmaError(Exception e) {
        reportEmmaError("", e);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:48:40.849 -0500", hash_original_method = "2FAE5EEC06744688E8993112C12E7557", hash_generated_method = "E8DAC8932EAC4F9F04ADEBD9C606E86A")
    private void reportEmmaError(String hint, Exception e) {
        String msg = "Failed to generate emma coverage. " + hint;
        Log.e(LOG_TAG, msg, e);
        mResults.putString(Instrumentation.REPORT_KEY_STREAMRESULT, "\nError: " + msg);
    }
}

