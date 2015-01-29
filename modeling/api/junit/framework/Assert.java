package junit.framework;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Assert {

    /**
     * Asserts that a condition is true. If it isn't it throws
     * an AssertionFailedError with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.358 -0500", hash_original_method = "AC762C12A6CDCFE8BA5350001874BBB5", hash_generated_method = "7837AE654693500DE167BF01EE7D750C")
    
static public void assertTrue(String message, boolean condition) {
        if (!condition)
            fail(message);
    }
    /**
     * Asserts that a condition is true. If it isn't it throws
     * an AssertionFailedError.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.361 -0500", hash_original_method = "9E2AB8D38F6DEA48480ED96DF34C2F9C", hash_generated_method = "23DFD6C9B96B7D06C6CD1A45BE791BD5")
    
static public void assertTrue(boolean condition) {
        assertTrue(null, condition);
    }
    /**
     * Asserts that a condition is false. If it isn't it throws
     * an AssertionFailedError with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.364 -0500", hash_original_method = "EA3734ADDEB20313C9CAB09B48812C54", hash_generated_method = "4858AFE909DDE63867ACB561D5449C13")
    
static public void assertFalse(String message, boolean condition) {
        assertTrue(message, !condition);
    }
    /**
     * Asserts that a condition is false. If it isn't it throws
     * an AssertionFailedError.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.367 -0500", hash_original_method = "3FDB9CFD55BF2DF7F8CECAE61175CDAF", hash_generated_method = "274508F7D97D3F403984C22B20F40423")
    
static public void assertFalse(boolean condition) {
        assertFalse(null, condition);
    }
    /**
     * Fails a test with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.369 -0500", hash_original_method = "A25997D93DEDDC22BD08A54D133EED79", hash_generated_method = "6CE41F0362B47B58394AEC91D327D2EF")
    
static public void fail(String message) {
        throw new AssertionFailedError(message);
    }
    /**
     * Fails a test with no message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.371 -0500", hash_original_method = "AD011F96CC6D6A3C23F58CF6EA04738C", hash_generated_method = "63E34E5254D869A30D664F863440D1C7")
    
static public void fail() {
        fail(null);
    }
    /**
     * Asserts that two objects are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.374 -0500", hash_original_method = "0DF13F4E9C7289EDBE516727D7987576", hash_generated_method = "8ABC2977E60E6A60AEAE15751265B93E")
    
static public void assertEquals(String message, Object expected, Object actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        failNotEquals(message, expected, actual);
    }
    /**
     * Asserts that two objects are equal. If they are not
     * an AssertionFailedError is thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.376 -0500", hash_original_method = "178203A8041021E6C223472E0296E87B", hash_generated_method = "4D7543BCA72C4F27D433358AB6CBC87A")
    
static public void assertEquals(Object expected, Object actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two Strings are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.379 -0500", hash_original_method = "82F7EC85E36A90F9F5B540B5F614E447", hash_generated_method = "C091F0C3991B47619AF8DBFB659D7B1A")
    
static public void assertEquals(String message, String expected, String actual) {
        if (expected == null && actual == null)
            return;
        if (expected != null && expected.equals(actual))
            return;
        throw new ComparisonFailure(message, expected, actual);
    }
    /**
     * Asserts that two Strings are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.381 -0500", hash_original_method = "DD16C43D02F60D2EF25B9D7E2B37609F", hash_generated_method = "9E9AC4081BDA0AFCDF0238988BF2DE54")
    
static public void assertEquals(String expected, String actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two doubles are equal concerning a delta.  If they are not
     * an AssertionFailedError is thrown with the given message.  If the expected
     * value is infinity then the delta value is ignored.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.384 -0500", hash_original_method = "EEAAA8BB7464238C2783CDD797C70C53", hash_generated_method = "807AB8C3747A17BA1846DB853B649E51")
    
static public void assertEquals(String message, double expected, double actual, double delta) {
        // handle infinity specially since subtracting to infinite values gives NaN and the
        // the following test fails
        if (Double.isInfinite(expected)) {
            if (!(expected == actual))
                failNotEquals(message, new Double(expected), new Double(actual));
        } else if (!(Math.abs(expected-actual) <= delta)) // Because comparison with NaN always returns false
            failNotEquals(message, new Double(expected), new Double(actual));
    }
    /**
     * Asserts that two doubles are equal concerning a delta. If the expected
     * value is infinity then the delta value is ignored.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.386 -0500", hash_original_method = "2BA0FD4CC00036E4108F83B03D65D405", hash_generated_method = "CE0314F1E44DB5E3E727BF1B17AEFE9D")
    
static public void assertEquals(double expected, double actual, double delta) {
        assertEquals(null, expected, actual, delta);
    }
    /**
     * Asserts that two floats are equal concerning a delta. If they are not
     * an AssertionFailedError is thrown with the given message.  If the expected
     * value is infinity then the delta value is ignored.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.389 -0500", hash_original_method = "0D1F30EAFED4844CCCD5A55529B3095A", hash_generated_method = "441EA7E9E201C102C45720B53E5CE668")
    
static public void assertEquals(String message, float expected, float actual, float delta) {
         // handle infinity specially since subtracting to infinite values gives NaN and the
        // the following test fails
        if (Float.isInfinite(expected)) {
            if (!(expected == actual))
                failNotEquals(message, new Float(expected), new Float(actual));
        } else if (!(Math.abs(expected-actual) <= delta))
              failNotEquals(message, new Float(expected), new Float(actual));
    }
    /**
     * Asserts that two floats are equal concerning a delta. If the expected
     * value is infinity then the delta value is ignored.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.392 -0500", hash_original_method = "E1A7B12278B27631DDD79E5B839DAAE3", hash_generated_method = "CAEE5C71060090FC11681352624FC759")
    
static public void assertEquals(float expected, float actual, float delta) {
        assertEquals(null, expected, actual, delta);
    }
    /**
     * Asserts that two longs are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.395 -0500", hash_original_method = "5604753D706326222B1B40A76BAB0566", hash_generated_method = "A62B05E21869F10B6E83B3E60C41CE47")
    
static public void assertEquals(String message, long expected, long actual) {
        assertEquals(message, new Long(expected), new Long(actual));
    }
    /**
     * Asserts that two longs are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.397 -0500", hash_original_method = "8CB53D267E9464036527893199C594A2", hash_generated_method = "654AAE5A5657CC75F0CF8EC5E2CF19E9")
    
static public void assertEquals(long expected, long actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two booleans are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.399 -0500", hash_original_method = "CE6F8F1C6C2218F6FF3D168198E2B46E", hash_generated_method = "85C3B777A9E01CD242A7BE36DADA6003")
    
static public void assertEquals(String message, boolean expected, boolean actual) {
            assertEquals(message, new Boolean(expected), new Boolean(actual));
      }
    /**
     * Asserts that two booleans are equal.
      */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.401 -0500", hash_original_method = "C186D197DF9F597D97CCBBCF2B270ED9", hash_generated_method = "00CBD488EC6B083F67E9229B1527959E")
    
static public void assertEquals(boolean expected, boolean actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two bytes are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
      @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.403 -0500", hash_original_method = "72E71F3F583D7B7F5DE5B91FA2A122DA", hash_generated_method = "80223F5F52C9BAA4CD781018FACABD23")
    
static public void assertEquals(String message, byte expected, byte actual) {
        assertEquals(message, new Byte(expected), new Byte(actual));
    }
    /**
        * Asserts that two bytes are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.406 -0500", hash_original_method = "6BBA9708D71F9933B89758033290956F", hash_generated_method = "A539C6711159A989B7494C21DF10217B")
    
static public void assertEquals(byte expected, byte actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two chars are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
      @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.409 -0500", hash_original_method = "2419D541CC42366E5221E182D9DD7A15", hash_generated_method = "9094E7BC61424659BA6780257EF54BA1")
    
static public void assertEquals(String message, char expected, char actual) {
            assertEquals(message, new Character(expected), new Character(actual));
      }
    /**
     * Asserts that two chars are equal.
     */
      @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.411 -0500", hash_original_method = "B1E804E14AC6E4164C7C37AAC8BF3F20", hash_generated_method = "F9C9BC9B0ECB43A3ED9EE4D6807AA2ED")
    
static public void assertEquals(char expected, char actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two shorts are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.414 -0500", hash_original_method = "753B9D60ED7A0B20EEF34D565E176B23", hash_generated_method = "E47C679CD7DF7D08B5A5B970D46843F7")
    
static public void assertEquals(String message, short expected, short actual) {
            assertEquals(message, new Short(expected), new Short(actual));
    }
      /**
     * Asserts that two shorts are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.416 -0500", hash_original_method = "BA5E455D31A0289B0DD8C58E3C3391C6", hash_generated_method = "3BCBEE91BF403C6C9299E78B00F085E4")
    
static public void assertEquals(short expected, short actual) {
        assertEquals(null, expected, actual);
    }
    /**
     * Asserts that two ints are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
      @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.418 -0500", hash_original_method = "4D2BE48844A5433A791E1AA55F49F841", hash_generated_method = "A3397764598A0C4CC0F2531E4ECB699A")
    
static public void assertEquals(String message, int expected, int actual) {
        assertEquals(message, new Integer(expected), new Integer(actual));
      }
      /**
        * Asserts that two ints are equal.
     */
      @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.421 -0500", hash_original_method = "B3778AA77CFEBEDD69DFA469D1B245AC", hash_generated_method = "BA5AF8184EF8B605C9D0F1E30BA3B718")
    
static public void assertEquals(int expected, int actual) {
          assertEquals(null, expected, actual);
    }
    /**
     * Asserts that an object isn't null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.423 -0500", hash_original_method = "EA220D62FFC852C05CF541823875A478", hash_generated_method = "30087C250C46D1144814359A1F09C756")
    
static public void assertNotNull(Object object) {
        assertNotNull(null, object);
    }
    /**
     * Asserts that an object isn't null. If it is
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.426 -0500", hash_original_method = "B6ACD9CEE83EB35E5542497C3F0CF3DF", hash_generated_method = "2DDEB25DAD19BA820A67E1CF4DA49F3A")
    
static public void assertNotNull(String message, Object object) {
        assertTrue(message, object != null);
    }
    /**
     * Asserts that an object is null.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.428 -0500", hash_original_method = "726E1430510DEE6537C029850183B163", hash_generated_method = "0B8ACE88D604CACC4FD49C2BA1A770F6")
    
static public void assertNull(Object object) {
        assertNull(null, object);
    }
    /**
     * Asserts that an object is null.  If it is not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.431 -0500", hash_original_method = "8101285F3B7B971E35CF21374AE1FDC7", hash_generated_method = "8BE70D42F84139EB093BCA64D8309885")
    
static public void assertNull(String message, Object object) {
        assertTrue(message, object == null);
    }
    /**
     * Asserts that two objects refer to the same object. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.433 -0500", hash_original_method = "01B27F7B8478EF280F44E13D1105BCC7", hash_generated_method = "A2763C8EB7716C67438AA8D8318493F5")
    
static public void assertSame(String message, Object expected, Object actual) {
        if (expected == actual)
            return;
        failNotSame(message, expected, actual);
    }
    /**
     * Asserts that two objects refer to the same object. If they are not
     * the same an AssertionFailedError is thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.436 -0500", hash_original_method = "338C56936DDCFBFAA814E2FE50D9D4C2", hash_generated_method = "433ED912B3842AB0A69427C288A66E02")
    
static public void assertSame(Object expected, Object actual) {
        assertSame(null, expected, actual);
    }
     /**
      * Asserts that two objects do not refer to the same object. If they are
      * an AssertionFailedError is thrown with the given message.
      */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.438 -0500", hash_original_method = "6BF74F97A8D55EADCED3E5638A05F0CD", hash_generated_method = "BB0AD71DC13F57FADAD9813796AF8E2F")
    
static public void assertNotSame(String message, Object expected, Object actual) {
        if (expected == actual)
            failSame(message);
    }
    /**
     * Asserts that two objects do not refer to the same object. If they are
     * the same an AssertionFailedError is thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.440 -0500", hash_original_method = "6C5EDA37A43755FDD4D913859A366E87", hash_generated_method = "A8F57EBF26CA195968C557CB45DEC795")
    
static public void assertNotSame(Object expected, Object actual) {
        assertNotSame(null, expected, actual);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.443 -0500", hash_original_method = "D02D9FA71E59A8A7ABF194C9053F9568", hash_generated_method = "DE6581EAA1A8965DD61EF567D1091AEC")
    
static private void failSame(String message) {
        String formatted= "";
         if (message != null)
             formatted= message+" ";
         fail(formatted+"expected not same");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.445 -0500", hash_original_method = "001529A7E13C464B17F3E5F8DF723B27", hash_generated_method = "C779A3967D244B583A7D56E026EDFFA7")
    
static private void failNotSame(String message, Object expected, Object actual) {
        String formatted= "";
        if (message != null)
            formatted= message+" ";
        fail(formatted+"expected same:<"+expected+"> was not:<"+actual+">");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.447 -0500", hash_original_method = "5B6EA5D897E7BBC965F2C67022AD3775", hash_generated_method = "8CFB0AA5FB4E79A5519E2A23006F0FC6")
    
static private void failNotEquals(String message, Object expected, Object actual) {
        fail(format(message, expected, actual));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.450 -0500", hash_original_method = "FB3FC63695B82DFE3E79AA1BD297BD98", hash_generated_method = "B541FF8A6333BABAA4117265BAAC4AA3")
    
static String format(String message, Object expected, Object actual) {
        String formatted= "";
        if (message != null)
            formatted= message+" ";
        return formatted+"expected:<"+expected+"> but was:<"+actual+">";
    }
    /**
     * Protect constructor since it is a static only class
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:44.356 -0500", hash_original_method = "E40547AB86F11E4F3EB5ED4FFC825309", hash_generated_method = "F73A9C4B8EF5708F8D4D700ABFDA8AA8")
    
protected Assert() {
    }
    
}

