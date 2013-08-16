package junit.runner;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.386 -0400", hash_original_field = "D86EF6FE2DDA8BCB0B1FF97852B6C141", hash_generated_field = "7A70A04F8D8A962F9AD485A249A9FE8E")

    boolean fLoading = true;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.387 -0400", hash_original_method = "7AE9B4E2779E68829E6E78655AC68035", hash_generated_method = "7AE9B4E2779E68829E6E78655AC68035")
    public BaseTestRunner ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.387 -0400", hash_original_method = "B534170C99FB9AC20DD9E1D90510BBA7", hash_generated_method = "191B263B201A6573423B73D225FF7158")
    public synchronized void startTest(Test test) {
        addTaint(test.getTaint());
        testStarted(test.toString());
        // ---------- Original Method ----------
        //testStarted(test.toString());
    }

    
    @DSModeled(DSC.SAFE)
    protected static void setPreferences(Properties preferences) {
        fPreferences= preferences;
    }

    
    @DSModeled(DSC.SAFE)
    protected static Properties getPreferences() {
        if (fPreferences == null) {
            fPreferences= new Properties();
             fPreferences.put("loading", "true");
             fPreferences.put("filterstack", "true");
              readPreferences();
        }
        return fPreferences;
    }

    
    @DSModeled(DSC.SAFE)
    public static void savePreferences() throws IOException {
        FileOutputStream fos= new FileOutputStream(getPreferencesFile());
        try {
            getPreferences().store(fos, "");
        } finally {
            fos.close();
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.388 -0400", hash_original_method = "B502D6F69F239856B740542829A9775D", hash_generated_method = "B5A2EF63FC90F647B0331C5BC78BDA2B")
    public void setPreference(String key, String value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        getPreferences().setProperty(key, value);
        // ---------- Original Method ----------
        //getPreferences().setProperty(key, value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.389 -0400", hash_original_method = "1D40CF214770214270118EC3034A73D5", hash_generated_method = "65C5A8A2E5F0471415C424B8576D1B14")
    public synchronized void endTest(Test test) {
        addTaint(test.getTaint());
        testEnded(test.toString());
        // ---------- Original Method ----------
        //testEnded(test.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.389 -0400", hash_original_method = "924242240DB2084A1F4B914D25D53B2F", hash_generated_method = "7B350C69B97DA1D2818B08BF47F0A135")
    public synchronized void addError(final Test test, final Throwable t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        testFailed(TestRunListener.STATUS_ERROR, test, t);
        // ---------- Original Method ----------
        //testFailed(TestRunListener.STATUS_ERROR, test, t);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.390 -0400", hash_original_method = "9ED25198C2B890CA881490476183D1D6", hash_generated_method = "7CA30BFC7F413B508A79C9FB2450C1E3")
    public synchronized void addFailure(final Test test, final AssertionFailedError t) {
        addTaint(t.getTaint());
        addTaint(test.getTaint());
        testFailed(TestRunListener.STATUS_FAILURE, test, t);
        // ---------- Original Method ----------
        //testFailed(TestRunListener.STATUS_FAILURE, test, t);
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void testStarted(String testName);

    
    @DSModeled(DSC.SAFE)
    public abstract void testEnded(String testName);

    
    @DSModeled(DSC.SAFE)
    public abstract void testFailed(int status, Test test, Throwable t);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.392 -0400", hash_original_method = "2E093CF05CBCDB737F05E1D7A4FAF338", hash_generated_method = "0D9C8491DABB82E9268E978303A75816")
    public Test getTest(String suiteClassName) {
        addTaint(suiteClassName.getTaint());
        if(suiteClassName.length() <= 0)        
        {
            clearStatus();
Test var540C13E9E156B687226421B24F2DF178_1328281201 =             null;
            var540C13E9E156B687226421B24F2DF178_1328281201.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1328281201;
        } //End block
        Class testClass = null;
        try 
        {
            testClass= loadSuiteClass(suiteClassName);
        } //End block
        catch (ClassNotFoundException e)
        {
            String clazz = e.getMessage();
            if(clazz == null)            
            clazz= suiteClassName;
            runFailed("Class not found \""+clazz+"\"");
Test var540C13E9E156B687226421B24F2DF178_623174277 =             null;
            var540C13E9E156B687226421B24F2DF178_623174277.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_623174277;
        } //End block
        catch (Exception e)
        {
            runFailed("Error: "+e.toString());
Test var540C13E9E156B687226421B24F2DF178_1606272414 =             null;
            var540C13E9E156B687226421B24F2DF178_1606272414.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1606272414;
        } //End block
        Method suiteMethod = null;
        try 
        {
            suiteMethod= testClass.getMethod(SUITE_METHODNAME, new Class[0]);
        } //End block
        catch (Exception e)
        {
            clearStatus();
Test varC1F87E97290793DB49A6390C78C4141F_291595503 =             new TestSuite(testClass);
            varC1F87E97290793DB49A6390C78C4141F_291595503.addTaint(taint);
            return varC1F87E97290793DB49A6390C78C4141F_291595503;
        } //End block
        if(! Modifier.isStatic(suiteMethod.getModifiers()))        
        {
            runFailed("Suite() method must be static");
Test var540C13E9E156B687226421B24F2DF178_1149276189 =             null;
            var540C13E9E156B687226421B24F2DF178_1149276189.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1149276189;
        } //End block
        Test test = null;
        try 
        {
            test= (Test)suiteMethod.invoke(null);
            if(test == null)            
            {
Test varB481C4977C3E3DE299395D5227B858D5_1718831240 =             test;
            varB481C4977C3E3DE299395D5227B858D5_1718831240.addTaint(taint);
            return varB481C4977C3E3DE299395D5227B858D5_1718831240;
            }
        } //End block
        catch (InvocationTargetException e)
        {
            runFailed("Failed to invoke suite():" + e.getTargetException().toString());
Test var540C13E9E156B687226421B24F2DF178_652710997 =             null;
            var540C13E9E156B687226421B24F2DF178_652710997.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_652710997;
        } //End block
        catch (IllegalAccessException e)
        {
            runFailed("Failed to invoke suite():" + e.toString());
Test var540C13E9E156B687226421B24F2DF178_1274350237 =             null;
            var540C13E9E156B687226421B24F2DF178_1274350237.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1274350237;
        } //End block
        clearStatus();
Test varB481C4977C3E3DE299395D5227B858D5_245632135 =         test;
        varB481C4977C3E3DE299395D5227B858D5_245632135.addTaint(taint);
        return varB481C4977C3E3DE299395D5227B858D5_245632135;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.392 -0400", hash_original_method = "6D8039F6261C6F21742AFDC2B366F78B", hash_generated_method = "4A641DE1A81CFFFB3D6E26287966677E")
    public String elapsedTimeAsString(long runTime) {
        addTaint(runTime);
String varED9666B6732423906D0DD3BF9CA61890_1840086301 =         NumberFormat.getInstance().format((double)runTime/1000);
        varED9666B6732423906D0DD3BF9CA61890_1840086301.addTaint(taint);
        return varED9666B6732423906D0DD3BF9CA61890_1840086301;
        // ---------- Original Method ----------
        //return NumberFormat.getInstance().format((double)runTime/1000);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.393 -0400", hash_original_method = "BE11435DC4AA3D9B45D704504FF19D7A", hash_generated_method = "5205F7B1899B23D1AA3BFA3FFDC884C4")
    protected String processArguments(String[] args) {
        addTaint(args[0].getTaint());
        String suiteName = null;
for(int i= 0;i < args.length;i++)
        {
            if(args[i].equals("-noloading"))            
            {
                setLoading(false);
            } //End block
            else
            if(args[i].equals("-nofilterstack"))            
            {
                fgFilterStack= false;
            } //End block
            else
            if(args[i].equals("-c"))            
            {
                if(args.length > i+1)                
                suiteName= extractClassName(args[i+1]);
                else
                System.out.println("Missing Test class name");
                i++;
            } //End block
            else
            {
                suiteName= args[i];
            } //End block
        } //End block
String varD8C9BC94A6E81F246F976FCCA661D48D_306581404 =         suiteName;
        varD8C9BC94A6E81F246F976FCCA661D48D_306581404.addTaint(taint);
        return varD8C9BC94A6E81F246F976FCCA661D48D_306581404;
        // ---------- Original Method ----------
        //String suiteName= null;
        //for (int i= 0; i < args.length; i++) {
            //if (args[i].equals("-noloading")) {
                //setLoading(false);
            //} else if (args[i].equals("-nofilterstack")) {
                //fgFilterStack= false;
            //} else if (args[i].equals("-c")) {
                //if (args.length > i+1)
                    //suiteName= extractClassName(args[i+1]);
                //else
                    //System.out.println("Missing Test class name");
                //i++;
            //} else {
                //suiteName= args[i];
            //}
        //}
        //return suiteName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.395 -0400", hash_original_method = "5089456E72AD517131D2C4755EB25FD8", hash_generated_method = "D9F7D286B22291E15850C20DB8EB5398")
    public void setLoading(boolean enable) {
        fLoading= enable;
        // ---------- Original Method ----------
        //fLoading= enable;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.395 -0400", hash_original_method = "0D3B9048C2AFB821E2A0D331105B4C0F", hash_generated_method = "42390196D798896EAB57B3750F2482E1")
    public String extractClassName(String className) {
        addTaint(className.getTaint());
        if(className.startsWith("Default package for"))        
        {
String var8D3DE937F8CC99D0F460A5297E45B78D_754422592 =         className.substring(className.lastIndexOf(".")+1);
        var8D3DE937F8CC99D0F460A5297E45B78D_754422592.addTaint(taint);
        return var8D3DE937F8CC99D0F460A5297E45B78D_754422592;
        }
String varF57DF2C3C72C0BA8574176BD3A4AA127_1921868751 =         className;
        varF57DF2C3C72C0BA8574176BD3A4AA127_1921868751.addTaint(taint);
        return varF57DF2C3C72C0BA8574176BD3A4AA127_1921868751;
        // ---------- Original Method ----------
        //if(className.startsWith("Default package for"))
            //return className.substring(className.lastIndexOf(".")+1);
        //return className;
    }

    
    @DSModeled(DSC.SAFE)
    public static String truncate(String s) {
        if (fgMaxMessageLength != -1 && s.length() > fgMaxMessageLength)
            s= s.substring(0, fgMaxMessageLength)+"...";
        return s;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void runFailed(String message);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.396 -0400", hash_original_method = "53378ECE171D61BBF4EFB0D39916FCCF", hash_generated_method = "DFDF802C18D4A72F4485AAFADF5FD132")
    protected Class loadSuiteClass(String suiteClassName) throws ClassNotFoundException {
        addTaint(suiteClassName.getTaint());
Class varBEB4DDDE7C412D41DB6B8FD62D89A7A0_869382084 =         getLoader().load(suiteClassName);
        varBEB4DDDE7C412D41DB6B8FD62D89A7A0_869382084.addTaint(taint);
        return varBEB4DDDE7C412D41DB6B8FD62D89A7A0_869382084;
        // ---------- Original Method ----------
        //return getLoader().load(suiteClassName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.397 -0400", hash_original_method = "EEF193CE41029661D90E6D0075FFB68C", hash_generated_method = "374205678E7B67C969D372F4C08DE921")
    protected void clearStatus() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.397 -0400", hash_original_method = "E9EF8772E071281B9CB71EDD599F1B7C", hash_generated_method = "5235F26D48B8DD03FB536C475E07C63F")
    public TestSuiteLoader getLoader() {
        if(useReloadingTestSuiteLoader())        
        {
TestSuiteLoader varB7D97109B31046514562789EA2F7CEA3_1937305971 =         new ReloadingTestSuiteLoader();
        varB7D97109B31046514562789EA2F7CEA3_1937305971.addTaint(taint);
        return varB7D97109B31046514562789EA2F7CEA3_1937305971;
        }
TestSuiteLoader varD4813F3AA8F61C27FF670963E25E8DDB_133763568 =         new StandardTestSuiteLoader();
        varD4813F3AA8F61C27FF670963E25E8DDB_133763568.addTaint(taint);
        return varD4813F3AA8F61C27FF670963E25E8DDB_133763568;
        // ---------- Original Method ----------
        //if (useReloadingTestSuiteLoader())
            //return new ReloadingTestSuiteLoader();
        //return new StandardTestSuiteLoader();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.397 -0400", hash_original_method = "CAFC5B71DA3D583C51BF61B1F5919197", hash_generated_method = "DB3E0D1CFA344513C4BA8A40EADEDC49")
    protected boolean useReloadingTestSuiteLoader() {
        boolean var45D8C0013A9AEEEB8D17EE7A4355FCE4_117846037 = (getPreference("loading").equals("true") && !inVAJava() && fLoading);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_445335761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_445335761;
        // ---------- Original Method ----------
        //return getPreference("loading").equals("true") && !inVAJava() && fLoading;
    }

    
    @DSModeled(DSC.BAN)
    private static File getPreferencesFile() {
        String home= System.getProperty("user.home");
        return new File(home, "junit.properties");
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    public static String getPreference(String key) {
        return getPreferences().getProperty(key);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static boolean inVAJava() {
        try {
            Class.forName("com.ibm.uvm.tools.DebugSupport");
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    
    @DSModeled(DSC.SAFE)
    public static String getFilteredTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        String trace= buffer.toString();
        return BaseTestRunner.getFilteredTrace(trace);
    }

    
    @DSModeled(DSC.SAFE)
    public static String getFilteredTrace(String stack) {
        if (showStackRaw())
            return stack;
        StringWriter sw= new StringWriter();
        PrintWriter pw= new PrintWriter(sw);
        StringReader sr= new StringReader(stack);
        BufferedReader br= new BufferedReader(sr, 1000);
        String line;
        try {
            while ((line= br.readLine()) != null) {
                if (!filterLine(line))
                    pw.println(line);
            }
        } catch (Exception IOException) {
            return stack; 
        }
        return sw.toString();
    }

    
    @DSModeled(DSC.SAFE)
    protected static boolean showStackRaw() {
        return !getPreference("filterstack").equals("true") || fgFilterStack == false;
    }

    
    @DSModeled(DSC.SAFE)
    static boolean filterLine(String line) {
        String[] patterns= new String[] {
            "junit.framework.TestCase",
            "junit.framework.TestResult",
            "junit.framework.TestSuite",
            "junit.framework.Assert.", 
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.398 -0400", hash_original_field = "7A3C9C82DFDAE5C5539B787B18A65355", hash_generated_field = "DD604510C1F195073E90BADCFD83C313")

    public static final String SUITE_METHODNAME= "suite";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.398 -0400", hash_original_field = "0BD526CCD24ACB74799914CD69633E1E", hash_generated_field = "7DB7C036CC486CE65B3BAEB5918F3555")

    private static Properties fPreferences;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.399 -0400", hash_original_field = "4FD24C113F41A8054ED0E4FF9B6A7556", hash_generated_field = "EAA944C707FD59A79AFC020C6041B5A2")

    static int fgMaxMessageLength = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.399 -0400", hash_original_field = "4269CA76C6CCCBEFEEC001E6CBD60B29", hash_generated_field = "E6CDB5750AE301F0223AF2C9783A4849")

    static boolean fgFilterStack = true;
    static {
         fgMaxMessageLength= getPreference("maxmessage", fgMaxMessageLength);
     }
    
}

