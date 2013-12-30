package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.Vector;






public class TestSuite implements Test {

    /**
     * ...as the moon sets over the early morning Merlin, Oregon
     * mountains, our intrepid adventurers type...
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.728 -0500", hash_original_method = "88843592DC8467036906B2CA5DC446A3", hash_generated_method = "E1E975E77FA0E9D2C3449E00A1A97FBA")
    
static public Test createTest(Class theClass, String name) {
        Constructor constructor;
        try {
            constructor= getTestConstructor(theClass);
        } catch (NoSuchMethodException e) {
            return warning("Class "+theClass.getName()+" has no public constructor TestCase(String name) or TestCase()");
        }
        Object test;
        try {
            if (constructor.getParameterTypes().length == 0) {
                test= constructor.newInstance(new Object[0]);
                if (test instanceof TestCase)
                    ((TestCase) test).setName(name);
            } else {
                test= constructor.newInstance(new Object[]{name});
            }
        } catch (InstantiationException e) {
            return(warning("Cannot instantiate test case: "+name+" ("+exceptionToString(e)+")"));
        } catch (InvocationTargetException e) {
            return(warning("Exception in constructor: "+name+" ("+exceptionToString(e.getTargetException())+")"));
        } catch (IllegalAccessException e) {
            return(warning("Cannot access test case: "+name+" ("+exceptionToString(e)+")"));
        }
        return (Test) test;
    }

    /**
     * Converts the stack trace into a string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.731 -0500", hash_original_method = "5CDA81376E8E99B82FAEA702F72F29B0", hash_generated_method = "A7C614C4DCC524C8BEBB13E2BDD86C12")
    
private static String exceptionToString(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();

    }

    /**
     * Gets a constructor which takes a single String as
     * its argument or a no arg constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.736 -0500", hash_original_method = "61C725BE0AB392885BB31ED1BE0D6F18", hash_generated_method = "7C2279E28CBBC566D35ED236F401363C")
    
public static Constructor getTestConstructor(Class theClass) throws NoSuchMethodException {
        Class[] args= { String.class };
        try {
            return theClass.getConstructor(args);
        } catch (NoSuchMethodException e) {
            // fall through
        }
        return theClass.getConstructor(new Class[0]);
    }

    /**
     * Returns a test which will fail and log a warning message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.764 -0500", hash_original_method = "DB775F7A4F14CE7DC49AFB9D265CB92C", hash_generated_method = "A70439F06E8979F8553F5C3E3D4BB9D8")
    
private static Test warning(final String message) {
        return new TestCase("warning") {
            protected void runTest() {
                fail(message);
            }
        };
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.704 -0500", hash_original_field = "4BE4F79750EC1A3CE2F895EF0C0FDC74", hash_generated_field = "B0AB7F7DF848E16FC564E5B040C82D2A")


    private Vector fTests= new Vector(10);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.707 -0500", hash_original_field = "8B24F7B8CD3FDAC03422CA6338432D3D", hash_generated_field = "44478883D7DC475A853C092E4F2639C3")

    private String fName;

    /**
     * Constructs an empty TestSuite.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.710 -0500", hash_original_method = "32487D028E6F96FB94F028FA0EDAB2CF", hash_generated_method = "2C78D25882622A0BF1BD5B36A4AF95BE")
    
public TestSuite() {
    }

    /**
     * Constructs a TestSuite from the given class with the given name.
     * @see TestSuite#TestSuite(Class)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.712 -0500", hash_original_method = "C68844F78BFBC377AC149EE8998489D7", hash_generated_method = "846DBB310656F73A93C422929003F4BB")
    
public TestSuite(Class theClass, String name) {
        this(theClass);
        setName(name);
    }

    /**
     * Constructs a TestSuite from the given class. Adds all the methods
     * starting with "test" as test cases to the suite.
     * Parts of this method was written at 2337 meters in the Huffihutte,
     * Kanton Uri
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.715 -0500", hash_original_method = "EB6125039DDD9B135BF27E0F52457DF2", hash_generated_method = "5BCB9217DA3960872C3B3C49A2A8CE72")
    
public TestSuite(final Class theClass) {
        fName= theClass.getName();
        try {
            getTestConstructor(theClass); // Avoid generating multiple error messages
        } catch (NoSuchMethodException e) {
            addTest(warning("Class "+theClass.getName()+" has no public constructor TestCase(String name) or TestCase()"));
            return;
        }

        if (!Modifier.isPublic(theClass.getModifiers())) {
            addTest(warning("Class "+theClass.getName()+" is not public"));
            return;
        }

        Class superClass= theClass;
        Vector names= new Vector();
        while (Test.class.isAssignableFrom(superClass)) {
            Method[] methods= superClass.getDeclaredMethods();
            for (int i= 0; i < methods.length; i++) {
                addTestMethod(methods[i], names, theClass);
            }
            superClass= superClass.getSuperclass();
        }
        if (fTests.size() == 0)
            addTest(warning("No tests found in "+theClass.getName()));
    }

       /**
     * Constructs an empty TestSuite.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.718 -0500", hash_original_method = "AFEF019FF6F5ADCED59C3EF3F970BCF3", hash_generated_method = "92C37CE9C4EBFCF401581C73F164D765")
    
public TestSuite(String name) {
        setName(name);
    }

    /**
     * Adds a test to the suite.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.720 -0500", hash_original_method = "B0D60F12FAFD1CE95A6EC9A16242DD4A", hash_generated_method = "A20C49DC2FAA9FC1B0FE10F22B56A609")
    
public void addTest(Test test) {
        fTests.addElement(test);
    }

    /**
     * Adds the tests from the given class to the suite
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.723 -0500", hash_original_method = "5E5F33FEDF0C0EFDF119171FAEDAFD32", hash_generated_method = "5F40CA70548621A144D489CB410CFAE9")
    
public void addTestSuite(Class testClass) {
        addTest(new TestSuite(testClass));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.725 -0500", hash_original_method = "A640EC9003137483798EE7A767F176ED", hash_generated_method = "7D27FED0D4A8CB874752BB7C3B6F5337")
    
private void addTestMethod(Method m, Vector names, Class theClass) {
        String name= m.getName();
        if (names.contains(name))
            return;
        if (! isPublicTestMethod(m)) {
            if (isTestMethod(m))
                addTest(warning("Test method isn't public: "+m.getName()));
            return;
        }
        names.addElement(name);
        addTest(createTest(theClass, name));
    }

    /**
     * Counts the number of test cases that will be run by this test.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.734 -0500", hash_original_method = "97313544C5808DC71CDB6C5E60051996", hash_generated_method = "CC43D9BC7EC7CA365E60B17571790917")
    
public int countTestCases() {
        int count= 0;
        for (Enumeration e= tests(); e.hasMoreElements(); ) {
            Test test= (Test)e.nextElement();
            count= count + test.countTestCases();
        }
        return count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.738 -0500", hash_original_method = "473CCC3375A8D379896F6F0BA14357FA", hash_generated_method = "94F8BC126840AEB31C2AA2782EF039C6")
    
private boolean isPublicTestMethod(Method m) {
        return isTestMethod(m) && Modifier.isPublic(m.getModifiers());
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.741 -0500", hash_original_method = "F90105657E9B98DED7B6D12FD1F09EBC", hash_generated_method = "8ABDF1D1AE50B9FB8EF44A0CF6F85506")
    
private boolean isTestMethod(Method m) {
        String name= m.getName();
        Class[] parameters= m.getParameterTypes();
        Class returnType= m.getReturnType();
        return parameters.length == 0 && name.startsWith("test") && returnType.equals(Void.TYPE);
     }

    /**
     * Runs the tests and collects their result in a TestResult.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.743 -0500", hash_original_method = "9C37034A26A50FB27EDBD0F4F43B733F", hash_generated_method = "6A3CB4912093E081FFF00B2E20008F21")
    
public void run(TestResult result) {
        for (Enumeration e= tests(); e.hasMoreElements(); ) {
              if (result.shouldStop() )
                  break;
            Test test= (Test)e.nextElement();
            runTest(test, result);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.745 -0500", hash_original_method = "72CC76A3223CEB1EEB432C33F48F7C56", hash_generated_method = "787ADF93ED91B28B634E18CB165EB713")
    
public void runTest(Test test, TestResult result) {
        test.run(result);
    }

    /**
     * Returns the test at the given index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.747 -0500", hash_original_method = "7408A183124CA9C5AD907B0700EAE7FB", hash_generated_method = "B863F72F39184A7F00C1667EB99C5019")
    
public Test testAt(int index) {
        return (Test)fTests.elementAt(index);
    }

    /**
     * Returns the number of tests in this suite
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.749 -0500", hash_original_method = "5EA215DA9294B33CBBC0BB090BEF7D0B", hash_generated_method = "2B6839DB42613BD1BFE64344F24B9EE6")
    
public int testCount() {
        return fTests.size();
    }

    /**
     * Returns the tests as an enumeration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.752 -0500", hash_original_method = "57D1A40E229C18FE8565EDC5A0EA03E1", hash_generated_method = "219C19EAD17FE9B77692E3916D9C48FB")
    
public Enumeration tests() {
        return fTests.elements();
    }

    /**
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.754 -0500", hash_original_method = "F367A28EAE938EF24D795301F789D610", hash_generated_method = "69A352B6C10740072F2CF678EB155C0F")
    
public String toString() {
        if (getName() != null)
            return getName();
        return super.toString();
     }

    /**
     * Sets the name of the suite.
     * @param name The name to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.756 -0500", hash_original_method = "6B586B3A073E23F7D2AE9C8A9582E34C", hash_generated_method = "7799DA220330373544D84B27CD401871")
    
public void setName(String name) {
        fName= name;
    }

    /**
     * Returns the name of the suite. Not all
     * test suites have a name and this method
     * can return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.759 -0500", hash_original_method = "2EA0F9602490A1D20696A18728516755", hash_generated_method = "9612DF40335A1D2D9A9BC76824AF292F")
    
public String getName() {
        return fName;
    }

    
}

