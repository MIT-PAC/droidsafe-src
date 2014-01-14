package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;

public abstract class BaseTestRunner implements TestListener {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.273 -0500", hash_original_method = "81AEB59715E8652DC89184A5B1CF88C4", hash_generated_method = "1CBF9551B83624D65B3361368677B4C7")
    
protected static void setPreferences(Properties preferences) {
        fPreferences= preferences;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.275 -0500", hash_original_method = "DA69842FD3F27114EEF071F656F6196E", hash_generated_method = "CCE0E07084E93354B0C43B02C7F1A420")
    
protected static Properties getPreferences() {
        if (fPreferences == null) {
            fPreferences= new Properties();
             fPreferences.put("loading", "true");
             fPreferences.put("filterstack", "true");
              readPreferences();
        }
        return fPreferences;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.277 -0500", hash_original_method = "C251857E2E28B44C11CDA11163E1AE93", hash_generated_method = "B84314F7C8FB1234A11324190B4CFB44")
    
public static void savePreferences() throws IOException {
        FileOutputStream fos= new FileOutputStream(getPreferencesFile());
        try {
            getPreferences().store(fos, "");
        } finally {
            fos.close();
        }
    }

    /**
     * Truncates a String to the maximum length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.308 -0500", hash_original_method = "4FD9983EAB7FBA133A187A3320DC3C40", hash_generated_method = "A888B1DF356632EFFEB910FAD3D4057C")
    
public static String truncate(String s) {
        if (fgMaxMessageLength != -1 && s.length() > fgMaxMessageLength)
            s= s.substring(0, fgMaxMessageLength)+"...";
        return s;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.322 -0500", hash_original_method = "35F20B64A4FC33C8F24C27C91E536237", hash_generated_method = "F2FAFE1EE2C2184048498A654D1551B6")
    
private static File getPreferencesFile() {
         String home= System.getProperty("user.home");
         return new File(home, "junit.properties");
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.325 -0500", hash_original_method = "EA4BD1C4622D133CAAD3A085AC647F16", hash_generated_method = "56EBE64667FDDB6DE975FCD75709FCF2")
    
private static void readPreferences() {
         InputStream is= null;
         try {
             is= new FileInputStream(getPreferencesFile());
             setPreferences(new Properties(getPreferences()));
            getPreferences().load(is);
        } catch (IOException e) {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e1) {
            }
        }
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.327 -0500", hash_original_method = "546188EB296FF182165775D30DBEF8CB", hash_generated_method = "1658F68DC450829BB9529B34BC9A99D9")
    
public static String getPreference(String key) {
         return getPreferences().getProperty(key);
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.330 -0500", hash_original_method = "C73546D208D255842EFDD569FA86F2C2", hash_generated_method = "538B073E44FFEA94405F6CF68B473E99")
    
public static int getPreference(String key, int dflt) {
         String value= getPreference(key);
         int intValue= dflt;
         if (value == null)
             return intValue;
         try {
             intValue= Integer.parseInt(value);
          } catch (NumberFormatException ne) {
         }
         return intValue;
     }

     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.332 -0500", hash_original_method = "3AF974D7E8831EFE5FB01F2A63D39625", hash_generated_method = "E0E85B4534695DA6E617C5BAF4CCC3E3")
    
public static boolean inVAJava() {
        try {
            Class.forName("com.ibm.uvm.tools.DebugSupport");
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Returns a filtered stack trace
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.334 -0500", hash_original_method = "28E46636FF437AE43E291479AD98B04F", hash_generated_method = "7EA05E5751D122DF450E346687039F72")
    
public static String getFilteredTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        String trace= buffer.toString();
        return BaseTestRunner.getFilteredTrace(trace);
    }

    /**
     * Filters stack frames from internal JUnit classes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.337 -0500", hash_original_method = "1F34B54C4F8B49B6E8A9867036CAC259", hash_generated_method = "2FC5714F1808D39C77E289339760C400")
    
public static String getFilteredTrace(String stack) {
        if (showStackRaw())
            return stack;

        StringWriter sw= new StringWriter();
        PrintWriter pw= new PrintWriter(sw);
        StringReader sr= new StringReader(stack);
        // BEGIN android-changed
        // Use a sensible default buffer size
        BufferedReader br= new BufferedReader(sr, 1000);
        // END android-changed

        String line;
        try {
            while ((line= br.readLine()) != null) {
                if (!filterLine(line))
                    pw.println(line);
            }
        } catch (Exception IOException) {
            return stack; // return the stack unfiltered
        }
        return sw.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.339 -0500", hash_original_method = "6968E5A47F22AEB4A31E2A95F81CE753", hash_generated_method = "9A18349E0BBA099F61D89C7DFED7D37C")
    
protected static boolean showStackRaw() {
        return !getPreference("filterstack").equals("true") || fgFilterStack == false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.347 -0500", hash_original_method = "25C420A2C4F8477871CE10837841E9D2", hash_generated_method = "2540B872E5689958ACCF23A19E82A7C2")
    
static boolean filterLine(String line) {
        String[] patterns= new String[] {
            "junit.framework.TestCase",
            "junit.framework.TestResult",
            "junit.framework.TestSuite",
            "junit.framework.Assert.", // don't filter AssertionFailure
            "junit.swingui.TestRunner",
            "junit.awtui.TestRunner",
            "junit.textui.TestRunner",
            "java.lang.reflect.Method.invoke("
        };
        for (int i= 0; i < patterns.length; i++) {
            if (line.indexOf(patterns[i]) > 0)
                return true;
        }
        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.259 -0500", hash_original_field = "F64E0C66AD3F200E5D27E4556349BE2E", hash_generated_field = "DD604510C1F195073E90BADCFD83C313")

    public static final String SUITE_METHODNAME= "suite";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.261 -0500", hash_original_field = "933D851BB17BF535C50BB224853E7867", hash_generated_field = "7DB7C036CC486CE65B3BAEB5918F3555")

    private static Properties fPreferences;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.263 -0500", hash_original_field = "004DEC929123DEE3921C20C3CAF2EBA6", hash_generated_field = "EAA944C707FD59A79AFC020C6041B5A2")

    static int fgMaxMessageLength= 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.266 -0500", hash_original_field = "078DD08601CD1C2845336538B68EF00C", hash_generated_field = "E6CDB5750AE301F0223AF2C9783A4849")

    static boolean fgFilterStack= true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.268 -0500", hash_original_field = "7A70A04F8D8A962F9AD485A249A9FE8E", hash_generated_field = "7A70A04F8D8A962F9AD485A249A9FE8E")

    boolean fLoading= true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.387 -0400", hash_original_method = "7AE9B4E2779E68829E6E78655AC68035", hash_generated_method = "7AE9B4E2779E68829E6E78655AC68035")
    public BaseTestRunner ()
    {
        //Synthesized constructor
    }

    /*
    * Implementation of TestListener
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.270 -0500", hash_original_method = "B534170C99FB9AC20DD9E1D90510BBA7", hash_generated_method = "F9B1B0A2933633CCE02E2A219602AF12")
    
public synchronized void startTest(Test test) {
        testStarted(test.toString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.280 -0500", hash_original_method = "B502D6F69F239856B740542829A9775D", hash_generated_method = "756D6C20A02790ED152BAF5653874406")
    
public void setPreference(String key, String value) {
        getPreferences().setProperty(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.282 -0500", hash_original_method = "1D40CF214770214270118EC3034A73D5", hash_generated_method = "86D8547C7CFA20D00C10C46605CDE0FE")
    
public synchronized void endTest(Test test) {
        testEnded(test.toString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.284 -0500", hash_original_method = "924242240DB2084A1F4B914D25D53B2F", hash_generated_method = "F6B87B4B3E4E82BAFE314EF7555EC0DE")
    
public synchronized void addError(final Test test, final Throwable t) {
        testFailed(TestRunListener.STATUS_ERROR, test, t);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.286 -0500", hash_original_method = "9ED25198C2B890CA881490476183D1D6", hash_generated_method = "3EBB5D30D41EB7D800D715C1DAF23025")
    
public synchronized void addFailure(final Test test, final AssertionFailedError t) {
        testFailed(TestRunListener.STATUS_FAILURE, test, t);
    }

    // TestRunListener implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.289 -0500", hash_original_method = "F731AEA695E1062B33EB5AEA27BFB580", hash_generated_method = "4D64AA8EA25F432C1A9977A5CB55924F")
    
public abstract void testStarted(String testName);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.291 -0500", hash_original_method = "D9A0E2668DBACCF4959976435590F9D7", hash_generated_method = "B5FEC9CAD6D8624D5513488E4436E64E")
    
public abstract void testEnded(String testName);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.293 -0500", hash_original_method = "F6DC03F50AE1DF5767A89BB487A47184", hash_generated_method = "953ED2CEF22E2FA4B735BB0311D81690")
    
public abstract void testFailed(int status, Test test, Throwable t);

    /**
     * Returns the Test corresponding to the given suite. This is
     * a template method, subclasses override runFailed(), clearStatus().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.296 -0500", hash_original_method = "2E093CF05CBCDB737F05E1D7A4FAF338", hash_generated_method = "21985FE09E0154339DAA04095503B9C7")
    
public Test getTest(String suiteClassName) {
        if (suiteClassName.length() <= 0) {
            clearStatus();
            return null;
        }
        Class testClass= null;
        try {
            testClass= loadSuiteClass(suiteClassName);
        } catch (ClassNotFoundException e) {
            String clazz= e.getMessage();
            if (clazz == null)
                clazz= suiteClassName;
            runFailed("Class not found \""+clazz+"\"");
            return null;
        } catch(Exception e) {
            runFailed("Error: "+e.toString());
            return null;
        }
        Method suiteMethod= null;
        try {
            suiteMethod= testClass.getMethod(SUITE_METHODNAME, new Class[0]);
         } catch(Exception e) {
             // try to extract a test suite automatically
            clearStatus();
            return new TestSuite(testClass);
        }
        if (! Modifier.isStatic(suiteMethod.getModifiers())) {
            runFailed("Suite() method must be static");
            return null;
        }
        Test test= null;
        try {
            test= (Test)suiteMethod.invoke(null); // static method
            if (test == null)
                return test;
        }
        catch (InvocationTargetException e) {
            runFailed("Failed to invoke suite():" + e.getTargetException().toString());
            return null;
        }
        catch (IllegalAccessException e) {
            runFailed("Failed to invoke suite():" + e.toString());
            return null;
        }

        clearStatus();
        return test;
    }

    /**
     * Returns the formatted string of the elapsed time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.299 -0500", hash_original_method = "6D8039F6261C6F21742AFDC2B366F78B", hash_generated_method = "CB8387C8076C572CB7CDE244697FEDBF")
    
public String elapsedTimeAsString(long runTime) {
        return NumberFormat.getInstance().format((double)runTime/1000);
    }

    /**
     * Processes the command line arguments and
     * returns the name of the suite class to run or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.301 -0500", hash_original_method = "BE11435DC4AA3D9B45D704504FF19D7A", hash_generated_method = "AA0602983C75C80BAEE178CCDC64A524")
    
protected String processArguments(String[] args) {
        String suiteName= null;
        for (int i= 0; i < args.length; i++) {
            if (args[i].equals("-noloading")) {
                setLoading(false);
            } else if (args[i].equals("-nofilterstack")) {
                fgFilterStack= false;
            } else if (args[i].equals("-c")) {
                if (args.length > i+1)
                    suiteName= extractClassName(args[i+1]);
                else
                    System.out.println("Missing Test class name");
                i++;
            } else {
                suiteName= args[i];
            }
        }
        return suiteName;
    }

    /**
     * Sets the loading behaviour of the test runner
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.304 -0500", hash_original_method = "5089456E72AD517131D2C4755EB25FD8", hash_generated_method = "3792A5657855C048B1AEF94E7CC4AA17")
    
public void setLoading(boolean enable) {
        fLoading= enable;
    }
    /**
     * Extract the class name from a String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.306 -0500", hash_original_method = "0D3B9048C2AFB821E2A0D331105B4C0F", hash_generated_method = "30E55999F7AE2FF4DD9904E626B47DED")
    
public String extractClassName(String className) {
        if(className.startsWith("Default package for"))
            return className.substring(className.lastIndexOf(".")+1);
        return className;
    }

    /**
     * Override to define how to handle a failed loading of
     * a test suite.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.310 -0500", hash_original_method = "C85720DF55126E44DB47D2789B75FD96", hash_generated_method = "768D9C2755118DC382C0A54779ED9DC6")
    
protected abstract void runFailed(String message);

    /**
     * Returns the loaded Class for a suite name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.313 -0500", hash_original_method = "53378ECE171D61BBF4EFB0D39916FCCF", hash_generated_method = "555C7DE432743A36059FF02274863774")
    
protected Class loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        return getLoader().load(suiteClassName);
    }

    /**
     * Clears the status message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.315 -0500", hash_original_method = "EEF193CE41029661D90E6D0075FFB68C", hash_generated_method = "F86432ADD1E18639A112111422E145D2")
    
protected void clearStatus() { // Belongs in the GUI TestRunner class
    }

    /**
     * Returns the loader to be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.317 -0500", hash_original_method = "E9EF8772E071281B9CB71EDD599F1B7C", hash_generated_method = "FADD03C3DE3629526FC468468334415D")
    
public TestSuiteLoader getLoader() {
        if (useReloadingTestSuiteLoader())
            return new ReloadingTestSuiteLoader();
        return new StandardTestSuiteLoader();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.320 -0500", hash_original_method = "CAFC5B71DA3D583C51BF61B1F5919197", hash_generated_method = "8CCD8696834A98CDC1563C0A6DD0FBE0")
    
protected boolean useReloadingTestSuiteLoader() {
        return getPreference("loading").equals("true") && !inVAJava() && fLoading;
    }
    static {
         fgMaxMessageLength= getPreference("maxmessage", fgMaxMessageLength);
     }
    
}

