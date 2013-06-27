package junit.framework;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Assert {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:03.567 -0400", hash_original_method = "E40547AB86F11E4F3EB5ED4FFC825309", hash_generated_method = "E776EC518D153ABA6A4956D5CD28EDBD")
    protected  Assert() {
        // ---------- Original Method ----------
    }

    
        static public void assertTrue(String message, boolean condition) {
        if (!condition)
            fail(message);
    }

    
        static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }

    
        static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }

    
        static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }

    
        static public void fail(String message) {
        throw new AssertionFailedError(message);
    }

    
        static public void fail() {
        fail(null);
    }

    
        static public void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        failNotEquals(message, expected, actual);
    }

    
        static public void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, String expected, String actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        throw new ComparisonFailure(message, expected, actual);
    }

    
        static public void assertEquals(String expected, String actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, double expected, double actual, double delta) {
        if (Double.isInfinite(expected)) {
            if (!(expected == actual))
                failNotEquals(message, new Double(expected), new Double(actual));
        } else if (!(Math.abs(expected-actual) <= delta)) 
            failNotEquals(message, new Double(expected), new Double(actual));
    }

    
        static public void assertEquals(double expected, double actual, double delta) {
        assertEquals(null, expected, actual, delta);
    }

    
        static public void assertEquals(String message, float expected, float actual, float delta) {
        if (Float.isInfinite(expected)) {
            if (!(expected == actual))
                failNotEquals(message, new Float(expected), new Float(actual));
        } else if (!(Math.abs(expected-actual) <= delta))
              failNotEquals(message, new Float(expected), new Float(actual));
    }

    
        static public void assertEquals(float expected, float actual, float delta) {
        assertEquals(null, expected, actual, delta);
    }

    
        static public void assertEquals(String message, long expected, long actual) {
        assertEquals(message, new Long(expected), new Long(actual));
    }

    
        static public void assertEquals(long expected, long actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, boolean expected, boolean actual) {
        assertEquals(message, new Boolean(expected), new Boolean(actual));
    }

    
        static public void assertEquals(boolean expected, boolean actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, byte expected, byte actual) {
        assertEquals(message, new Byte(expected), new Byte(actual));
    }

    
        static public void assertEquals(byte expected, byte actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, char expected, char actual) {
        assertEquals(message, new Character(expected), new Character(actual));
    }

    
        static public void assertEquals(char expected, char actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, short expected, short actual) {
        assertEquals(message, new Short(expected), new Short(actual));
    }

    
        static public void assertEquals(short expected, short actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertEquals(String message, int expected, int actual) {
        assertEquals(message, new Integer(expected), new Integer(actual));
    }

    
        static public void assertEquals(int expected, int actual) {
        assertEquals(null, expected, actual);
    }

    
        static public void assertNotNull(Object object) {
        assertNotNull(null, object);
    }

    
        static public void assertNotNull(String message, Object object) {
        assertTrue(message, object != null);
    }

    
        static public void assertNull(Object object) {
        assertNull(null, object);
    }

    
        static public void assertNull(String message, Object object) {
        assertTrue(message, object == null);
    }

    
        static public void assertSame(String message, Object expected, Object actual) {
        if (expected == actual)
            return;
        failNotSame(message, expected, actual);
    }

    
        static public void assertSame(Object expected, Object actual) {
        assertSame(null, expected, actual);
    }

    
        static public void assertNotSame(String message, Object expected, Object actual) {
        if (expected == actual)
            failSame(message);
    }

    
        static public void assertNotSame(Object expected, Object actual) {
        assertNotSame(null, expected, actual);
    }

    
        static private void failSame(String message) {
        String formatted= "";
        if (message != null)
             formatted= message+" ";
        fail(formatted+"expected not same");
    }

    
        static private void failNotSame(String message, Object expected, Object actual) {
        String formatted= "";
        if (message != null)
            formatted= message+" ";
        fail(formatted+"expected same:<"+expected+"> was not:<"+actual+">");
    }

    
        static private void failNotEquals(String message, Object expected, Object actual) {
        fail(format(message, expected, actual));
    }

    
        static String format(String message, Object expected, Object actual) {
        String formatted= "";
        if (message != null)
            formatted= message+" ";
        return formatted+"expected:<"+expected+"> but was:<"+actual+">";
    }

    
}

