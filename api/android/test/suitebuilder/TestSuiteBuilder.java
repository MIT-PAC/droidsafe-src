package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import static android.test.suitebuilder.TestGrouping.SORT_BY_FULLY_QUALIFIED_NAME;
import static android.test.suitebuilder.TestPredicates.REJECT_SUPPRESSED;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import android.content.Context;
import android.test.AndroidTestRunner;
import android.test.TestCaseUtil;

import com.android.internal.util.Predicate;
import com.google.android.collect.Lists;






public class TestSuiteBuilder {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.936 -0500", hash_original_method = "B2C0E32F80832659BC02AF16125886AE", hash_generated_method = "FF2BD17ECCE48B8DC9A3BA61FC9C67CD")
    
private static String parsePackageNameFromClassName(String className) {
        return className.substring(0, className.lastIndexOf('.'));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.868 -0500", hash_original_field = "571FE4403DDA9BF54693EBF4F0D6639D", hash_generated_field = "FFC623C2EA984831A33BAADC181E897E")


    private Context context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.870 -0500", hash_original_field = "12F87417C0E327D36555F80CB0C0E624", hash_generated_field = "56A9B7A488A7615FB6C4D1D2217E1503")

    private final TestGrouping testGrouping = new TestGrouping(SORT_BY_FULLY_QUALIFIED_NAME);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.872 -0500", hash_original_field = "01466FEB43190F90CBD5981192C2D5FD", hash_generated_field = "985B70CA3550B01608B83EE3F72168EC")

    private final Set<Predicate<TestMethod>> predicates = new HashSet<Predicate<TestMethod>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.874 -0500", hash_original_field = "EF8ADBE3BF4BD50A8F899E931010F398", hash_generated_field = "C089C26A0F05E75588049BAD1F2BEF5A")

    private List<TestCase> testCases;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.877 -0500", hash_original_field = "85BA7BD1850E0EC035DA86205E979EC9", hash_generated_field = "AC3A2B22FEC9C02F4245743F5AF59C1C")

    private TestSuite rootSuite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.879 -0500", hash_original_field = "67C0FE9EAD28D6048031BC9218280C08", hash_generated_field = "D3496256C20E9CA164F594A66FCB0565")

    private TestSuite suiteForCurrentClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.882 -0500", hash_original_field = "83E1FD7A9757FE516A3BAF3FEA736637", hash_generated_field = "0621208759121B23881D009E501432EE")

    private String currentClassname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.884 -0500", hash_original_field = "6211E8B6C90F8F9C0255A8DCFD71E056", hash_generated_field = "03428D590BDE6503C56EB614336478D2")

    private String suiteName;

    /**
     * The given name is automatically prefixed with the package containing the tests to be run.
     * If more than one package is specified, the first is used.
     *
     * @param clazz Use the class from your .apk. Use the class name for the test suite name.
     *              Use the class' classloader in order to load classes for testing.
     *              This is needed when running in the emulator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.886 -0500", hash_original_method = "8DFAA261B116CB95D8F3EE320976E821", hash_generated_method = "E2028131F1B07E853FD832F61317A006")
    
public TestSuiteBuilder(Class clazz) {
        this(clazz.getName(), clazz.getClassLoader());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.889 -0500", hash_original_method = "9CA7BA6922F108D38C6201808A4CEB3C", hash_generated_method = "9A93B126671833E87F4612FCA36F33BD")
    
public TestSuiteBuilder(String name, ClassLoader classLoader) {
        this.suiteName = name;
        this.testGrouping.setClassLoader(classLoader);
        this.testCases = Lists.newArrayList();
        addRequirements(REJECT_SUPPRESSED);
    }

    /** @hide pending API Council approval */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.891 -0500", hash_original_method = "48780D5C4E993D5976786FDA7072C865", hash_generated_method = "1AEA5C89FAFA827B2A85B4025429AA7B")
    
public TestSuiteBuilder addTestClassByName(String testClassName, String testMethodName,
            Context context) {

        AndroidTestRunner atr = new AndroidTestRunner();
        atr.setContext(context);
        atr.setTestClassName(testClassName, testMethodName);

        this.testCases.addAll(atr.getTestCases());
        return this;
    }

    /** @hide pending API Council approval */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.894 -0500", hash_original_method = "EA702A9DA91338D58DCDCE903BD5BA53", hash_generated_method = "7ADEA3B00E1C29E9DAE688AAC26A2033")
    
public TestSuiteBuilder addTestSuite(TestSuite testSuite) {
        for (TestCase testCase : (List<TestCase>) TestCaseUtil.getTests(testSuite, true)) {
            this.testCases.add(testCase);
        }
        return this;
    }

    /**
     * Include all tests that satisfy the requirements in the given packages and all sub-packages,
     * unless otherwise specified.
     *
     * @param packageNames Names of packages to add.
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.896 -0500", hash_original_method = "F3D792B6EB8BC145BAF2830A3B203CAC", hash_generated_method = "09D3D4C78918C1EF2B20F0543EDEDAE8")
    
public TestSuiteBuilder includePackages(String... packageNames) {
        testGrouping.addPackagesRecursive(packageNames);
        return this;
    }

    /**
     * Exclude all tests in the given packages and all sub-packages, unless otherwise specified.
     *
     * @param packageNames Names of packages to remove.
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.898 -0500", hash_original_method = "ECB1A1FF9D2C5C6048377E0BEB0296EB", hash_generated_method = "4646C61C07C34092FA61EEA7746DDB8D")
    
public TestSuiteBuilder excludePackages(String... packageNames) {
        testGrouping.removePackagesRecursive(packageNames);
        return this;
    }

    /**
     * Exclude tests that fail to satisfy all of the given predicates.
     *
     * @param predicates Predicates to add to the list of requirements.
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.900 -0500", hash_original_method = "30733A3232BFC83399FAC43965000DCC", hash_generated_method = "C7CE9C087A8F529EE5D96931DE516CD1")
    
public TestSuiteBuilder addRequirements(List<Predicate<TestMethod>> predicates) {
        this.predicates.addAll(predicates);
        return this;
    }

    /**
     * Include all junit tests that satisfy the requirements in the calling class' package and all
     * sub-packages.
     *
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.903 -0500", hash_original_method = "58145D33150957DD46A1ADD9032FDB9F", hash_generated_method = "3CE421B65E2729738ED02C12C7AD40C1")
    
public final TestSuiteBuilder includeAllPackagesUnderHere() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        String callingClassName = null;
        String thisClassName = TestSuiteBuilder.class.getName();

        // We want to get the package of this method's calling class. This method's calling class
        // should be one level below this class in the stack trace.
        for (int i = 0; i < stackTraceElements.length; i++) {
            StackTraceElement element = stackTraceElements[i];
            if (thisClassName.equals(element.getClassName())
                    && "includeAllPackagesUnderHere".equals(element.getMethodName())) {
                // We've found this class in the call stack. The calling class must be the
                // next class in the stack.
                callingClassName = stackTraceElements[i + 1].getClassName();
                break;
            }
        }

        String packageName = parsePackageNameFromClassName(callingClassName);
        return includePackages(packageName);
    }

    /**
     * Override the default name for the suite being built. This should generally be called if you
     * call {@link #addRequirements(com.android.internal.util.Predicate[])} to make it clear which
     * tests will be included. The name you specify is automatically prefixed with the package
     * containing the tests to be run. If more than one package is specified, the first is used.
     *
     * @param newSuiteName Prefix of name to give the suite being built.
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.905 -0500", hash_original_method = "DE0BA46F9EE52752A0C868D33280E318", hash_generated_method = "2111F995AE1D670464F9099EECD61985")
    
public TestSuiteBuilder named(String newSuiteName) {
        suiteName = newSuiteName;
        return this;
    }

    /**
     * Call this method once you've configured your builder as desired.
     *
     * @return The suite containing the requested tests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.908 -0500", hash_original_method = "C585F9D3DE53AA6116980D3F6C4B8FC9", hash_generated_method = "83FEE9530342B72CBD7433E103FE771F")
    
public final TestSuite build() {
        rootSuite = new TestSuite(getSuiteName());

        // Keep track of current class so we know when to create a new sub-suite.
        currentClassname = null;
        try {
            for (TestMethod test : testGrouping.getTests()) {
                if (satisfiesAllPredicates(test)) {
                    addTest(test);
                }
            }
            if (testCases.size() > 0) {
                for (TestCase testCase : testCases) {
                    if (satisfiesAllPredicates(new TestMethod(testCase))) {
                        addTest(testCase);
                    }
                }
            }
        } catch (Exception exception) {
            Log.i("TestSuiteBuilder", "Failed to create test.", exception);
            TestSuite suite = new TestSuite(getSuiteName());
            suite.addTest(new FailedToCreateTests(exception));
            return suite;
        }
        return rootSuite;
    }

    /**
     * Subclasses use this method to determine the name of the suite.
     *
     * @return The package and suite name combined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.910 -0500", hash_original_method = "FA6CF1B18274415B042FA89686DFBBA8", hash_generated_method = "328983B6D58F1C389CA9DA48F5FE1D63")
    
protected String getSuiteName() {
        return suiteName;
    }

    /**
     * Exclude tests that fail to satisfy all of the given predicates. If you call this method, you
     * probably also want to call {@link #named(String)} to override the default suite name.
     *
     * @param predicates Predicates to add to the list of requirements.
     * @return The builder for method chaining.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.912 -0500", hash_original_method = "6FE9FBC06898098EA0A0DBF770A42526", hash_generated_method = "BC3E0ED84DC392C25AEE5CBD9CFCD084")
    
public final TestSuiteBuilder addRequirements(Predicate<TestMethod>... predicates) {
        ArrayList<Predicate<TestMethod>> list = new ArrayList<Predicate<TestMethod>>();
        Collections.addAll(list, predicates);
        return addRequirements(list);
    }

    /**
     * @return the test package that represents the packages that were included for our test suite.
     *
     * {@hide} Not needed for 1.0 SDK.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.924 -0500", hash_original_method = "95C63968A7356AFE59EE1560EDC6AFD0", hash_generated_method = "F2EB4499BC1ECF50C137D666C059F849")
    
protected TestGrouping getTestGrouping() {
        return testGrouping;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.927 -0500", hash_original_method = "3B7E4DAFF4F4255560B2EF8BCF0CA264", hash_generated_method = "E7C8BAA1631DCB7A8D74C1F2A689DFB2")
    
private boolean satisfiesAllPredicates(TestMethod test) {
        for (Predicate<TestMethod> predicate : predicates) {
            if (!predicate.apply(test)) {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.929 -0500", hash_original_method = "9609FD64CC859CF40862383CC61076E6", hash_generated_method = "D7827B892E65E750AEF759DC9E78AFBF")
    
private void addTest(TestMethod testMethod) throws Exception {
        addSuiteIfNecessary(testMethod.getEnclosingClassname());
        suiteForCurrentClass.addTest(testMethod.createTest());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.931 -0500", hash_original_method = "7027D4F6836EC90288680E369B5B8F5A", hash_generated_method = "5A88B0ECD367E913FF656BB45D60AEAE")
    
private void addTest(Test test) {
        addSuiteIfNecessary(test.getClass().getName());
        suiteForCurrentClass.addTest(test);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.933 -0500", hash_original_method = "92951B52D867188410A62009711C9261", hash_generated_method = "FCFABC12F2A064D1F2F2C9B825156477")
    
private void addSuiteIfNecessary(String parentClassname) {
        if (!parentClassname.equals(currentClassname)) {
            currentClassname = parentClassname;
            suiteForCurrentClass = new TestSuite(parentClassname);
            rootSuite.addTest(suiteForCurrentClass);
        }
    }

    
    public static class FailedToCreateTests extends TestCase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.916 -0500", hash_original_field = "2CBC6074DF6BD2C2AC2A7CA4BC170BEC", hash_generated_field = "70BD42A5533D521458BB067703B0D3E8")

        private  Exception exception;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.918 -0500", hash_original_method = "1C0BA3005E48DD2AA9883550E9E56685", hash_generated_method = "51BE11751FD69FE84CA5BBA1BEA6A8D9")
        
public FailedToCreateTests(Exception exception) {
            super("testSuiteConstructionFailed");
            this.exception = exception;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:42.921 -0500", hash_original_method = "1942A289EA540D79C743EE0933FD0258", hash_generated_method = "9742EBB8305877B58ABA3531EB4A181D")
        
public void testSuiteConstructionFailed() {
            throw new RuntimeException("Exception during suite construction", exception);
        }

        
    }


    
}

