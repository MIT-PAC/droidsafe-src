package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class TestCase extends Assert implements Test {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.818 -0500", hash_original_field = "8B24F7B8CD3FDAC03422CA6338432D3D", hash_generated_field = "44478883D7DC475A853C092E4F2639C3")

    private String fName;

    /**
     * No-arg constructor to enable serialization. This method
     * is not intended to be used by mere mortals without calling setName().
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.821 -0500", hash_original_method = "1F809C892F1386C5BCE506B7B9E71577", hash_generated_method = "27CB89EC1ACD5E4D7724790A26284C43")
    
public TestCase() {
        fName= null;
    }
    /**
     * Constructs a test case with the given name.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.823 -0500", hash_original_method = "E2C49012EEA8722F341B549129350038", hash_generated_method = "79103D178E82611667C3864ED717FAAA")
    
public TestCase(String name) {
        fName= name;
    }
    /**
     * Counts the number of test cases executed by run(TestResult result).
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.825 -0500", hash_original_method = "C380EF026EE3B754782A4E35FA9663AC", hash_generated_method = "96D654C442956B5ACD941E2D99AEE102")
    
public int countTestCases() {
        return 1;
    }
    /**
     * Creates a default TestResult object
     *
     * @see TestResult
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.828 -0500", hash_original_method = "974B8EFFC4FED3C302A251DC7978304A", hash_generated_method = "F9E6293C38B6A411D0A3D8B4F70C0426")
    
protected TestResult createResult() {
        return new TestResult();
    }
    /**
     * A convenience method to run this test, collecting the results with a
     * default TestResult object.
     *
     * @see TestResult
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.830 -0500", hash_original_method = "961A5CFC9275837B3D79C86ECF9A0692", hash_generated_method = "635F9BB5EC31EC20435F9A758E3D2B16")
    
public TestResult run() {
        TestResult result= createResult();
        run(result);
        return result;
    }
    /**
     * Runs the test case and collects the results in TestResult.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.832 -0500", hash_original_method = "ED2C86C86B2D9BBF3015D425DB337069", hash_generated_method = "896FFE0DBAD8D0605B4998C2784C2FC6")
    
public void run(TestResult result) {
        result.run(this);
    }
    /**
     * Runs the bare test sequence.
     * @exception Throwable if any exception is thrown
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.834 -0500", hash_original_method = "C8A580F0F00F2E8253C1A0038ADFE159", hash_generated_method = "6A3420AADD23DFC840F8FCD6EA8F7BF8")
    
public void runBare() throws Throwable {
        setUp();
        try {
            runTest();
        }
        finally {
            tearDown();
        }
    }
    /**
     * Override to run the test and assert its state.
     * @exception Throwable if any exception is thrown
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.837 -0500", hash_original_method = "224A26155E20D2310F3074B7F0735777", hash_generated_method = "2ECEA51D62B8E86E19253E5893782A6D")
    
protected void runTest() throws Throwable {
        assertNotNull(fName);
        Method runMethod= null;
        try {
            // use getMethod to get all public inherited
            // methods. getDeclaredMethods returns all
            // methods of this class but excludes the
            // inherited ones.
            runMethod= getClass().getMethod(fName, (Class[]) null);
        } catch (NoSuchMethodException e) {
            fail("Method \""+fName+"\" not found");
        }
        if (!Modifier.isPublic(runMethod.getModifiers())) {
            fail("Method \""+fName+"\" should be public");
        }

        try {
            runMethod.invoke(this, (Object[]) null);
        }
        catch (InvocationTargetException e) {
            e.fillInStackTrace();
            throw e.getTargetException();
        }
        catch (IllegalAccessException e) {
            e.fillInStackTrace();
            throw e;
        }
    }
    /**
     * Sets up the fixture, for example, open a network connection.
     * This method is called before a test is executed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.840 -0500", hash_original_method = "FFA3FA0A8311363EADFF98B8B84529FB", hash_generated_method = "B6ADAD1A3F40B3C98F2C0E29FDA85E0C")
    
protected void setUp() throws Exception {
    }
    /**
     * Tears down the fixture, for example, close a network connection.
     * This method is called after a test is executed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.842 -0500", hash_original_method = "9DC9991C60DD393D44750907790C62ED", hash_generated_method = "7F2F12718C23E6FE2A0FD5257882B9EA")
    
protected void tearDown() throws Exception {
    }
    /**
     * Returns a string representation of the test case
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.844 -0500", hash_original_method = "25D47A11917433AAC827E07C052136CF", hash_generated_method = "F70E6BECEBE68D29D42E13A82E32E01C")
    
public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }
    /**
     * Gets the name of a TestCase
     * @return returns a String
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.846 -0500", hash_original_method = "2EA0F9602490A1D20696A18728516755", hash_generated_method = "9612DF40335A1D2D9A9BC76824AF292F")
    
public String getName() {
        return fName;
    }
    /**
     * Sets the name of a TestCase
     * @param name The name to set
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.849 -0500", hash_original_method = "6B586B3A073E23F7D2AE9C8A9582E34C", hash_generated_method = "7799DA220330373544D84B27CD401871")
    
public void setName(String name) {
        fName= name;
    }
    
}

