package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;

import com.google.android.collect.Lists;



public class TestCaseUtil {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.921 -0500", hash_original_method = "9FD0A32684FA5B186B09F654C84A8024", hash_generated_method = "8583F188CF9ABDA2A9AEA4FB05F61321")
    
@SuppressWarnings("unchecked")
    public static List<String> getTestCaseNames(Test test, boolean flatten) {
        List<Test> tests = (List<Test>) getTests(test, flatten);
        List<String> testCaseNames = Lists.newArrayList();
        for (Test aTest : tests) {
            testCaseNames.add(getTestName(aTest));
        }
        return testCaseNames;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.923 -0500", hash_original_method = "F9058D2EEE3D64E57AC774484E353F75", hash_generated_method = "7E46271B3240B5396AC43213DC1EA004")
    
public static List<? extends Test> getTests(Test test, boolean flatten) {
        return getTests(test, flatten, new HashSet<Class<?>>());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.926 -0500", hash_original_method = "93C00521577F44DF8D41C1C2AB9E3721", hash_generated_method = "A1EC84F7C511943ACFE06B3A227A5FB3")
    
private static List<? extends Test> getTests(Test test, boolean flatten,
            Set<Class<?>> seen) {
        List<Test> testCases = Lists.newArrayList();
        if (test != null) {

            Test workingTest = null;
            /*
             * If we want to run a single TestCase method only, we must not
             * invoke the suite() method, because we will run all test methods
             * of the class then.
             */
            if (test instanceof TestCase &&
                    ((TestCase)test).getName() == null) {
                workingTest = invokeSuiteMethodIfPossible(test.getClass(), 
                        seen);
            }
            if (workingTest == null) {
                workingTest = test;
            }

            if (workingTest instanceof TestSuite) {
                TestSuite testSuite = (TestSuite) workingTest;
                Enumeration enumeration = testSuite.tests();
                while (enumeration.hasMoreElements()) {
                    Test childTest = (Test) enumeration.nextElement();
                    if (flatten) {
                        testCases.addAll(getTests(childTest, flatten, seen));
                    } else {
                        testCases.add(childTest);
                    }
                }
            } else {
                testCases.add(workingTest);
            }
        }
        return testCases;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.929 -0500", hash_original_method = "07EFA854A074D722E08D831AD0F2F1EC", hash_generated_method = "0F7E3AA6F9D62473B1826F25DB363314")
    
private static Test invokeSuiteMethodIfPossible(Class testClass,
            Set<Class<?>> seen) {
        try {
            Method suiteMethod = testClass.getMethod(
                    BaseTestRunner.SUITE_METHODNAME, new Class[0]);
            /*
             * Additional check necessary: If a TestCase contains a suite()
             * method that returns a TestSuite including the TestCase itself,
             * we need to stop the recursion. We use a set of classes to
             * remember which classes' suite() methods were already invoked.
             */
            if (Modifier.isStatic(suiteMethod.getModifiers())
                    && !seen.contains(testClass)) {
                seen.add(testClass);
                try {
                    return (Test) suiteMethod.invoke(null, (Object[]) null);
                } catch (InvocationTargetException e) {
                    // do nothing
                } catch (IllegalAccessException e) {
                    // do nothing
                }
            }
        } catch (NoSuchMethodException e) {
            // do nothing
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.931 -0500", hash_original_method = "9868F99DCBE3725E4578898EE3F79492", hash_generated_method = "B1D6B98C30AE527A55CBFBE8BF18C2FB")
    
public static String getTestName(Test test) {
        if (test instanceof TestCase) {
            TestCase testCase = (TestCase) test;
            return testCase.getName();
        } else if (test instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) test;
            String name = testSuite.getName();
            if (name != null) {
                int index = name.lastIndexOf(".");
                if (index > -1) {
                    return name.substring(index + 1);
                } else {
                    return name;
                }
            }
        }
        return "";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.934 -0500", hash_original_method = "C0E28B9E1910A5B87AFB6DE955A6FC6B", hash_generated_method = "E7E3587A76B8DC569DC9ABC1A0B71663")
    
public static Test getTestAtIndex(TestSuite testSuite, int position) {
        int index = 0;
        Enumeration enumeration = testSuite.tests();
        while (enumeration.hasMoreElements()) {
            Test test = (Test) enumeration.nextElement();
            if (index == position) {
                return test;
            }
            index++;
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.937 -0500", hash_original_method = "0FC87DD09556C7A3A66C16C79F06C6C6", hash_generated_method = "3EC4F0F067459BDBA56326D853499C85")
    
public static TestSuite createTestSuite(Class<? extends Test> testClass)
            throws InstantiationException, IllegalAccessException {

        Test test = invokeSuiteMethodIfPossible(testClass, 
                new HashSet<Class<?>>());
        if (test == null) {
            return new TestSuite(testClass);

        } else if (TestCase.class.isAssignableFrom(test.getClass())) {
            TestSuite testSuite = new TestSuite(test.getClass().getName());
            testSuite.addTest(test);
            return testSuite;
        }

        return (TestSuite) test;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.918 -0500", hash_original_method = "8B3FB0DB9AA59378E1F246FBF0E78671", hash_generated_method = "293D39CFE11433CB90AB76BE88A51C65")
    
private TestCaseUtil() {
    }

    
}

