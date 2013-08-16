package junit.framework;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.342 -0400", hash_original_field = "3BCA106602C866BE981E31C77F5BEC5D", hash_generated_field = "B0AB7F7DF848E16FC564E5B040C82D2A")

    private Vector fTests = new Vector(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.342 -0400", hash_original_field = "92C0A4FDDE9C65D69627C13D4397EA3F", hash_generated_field = "44478883D7DC475A853C092E4F2639C3")

    private String fName;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.342 -0400", hash_original_method = "32487D028E6F96FB94F028FA0EDAB2CF", hash_generated_method = "A3BB17C6F6CBA255CBA107DF4331D4C9")
    public  TestSuite() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.343 -0400", hash_original_method = "C68844F78BFBC377AC149EE8998489D7", hash_generated_method = "694BA6E6591B51908D02CCDF5FCE398A")
    public  TestSuite(Class theClass, String name) {
        this(theClass);
        addTaint(name.getTaint());
        addTaint(theClass.getTaint());
        setName(name);
        // ---------- Original Method ----------
        //setName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.344 -0400", hash_original_method = "EB6125039DDD9B135BF27E0F52457DF2", hash_generated_method = "B1E5ED7CBEE0EE1D93F5C5B6A241BCCF")
    public  TestSuite(final Class theClass) {
        fName= theClass.getName();
        try 
        {
            getTestConstructor(theClass);
        } //End block
        catch (NoSuchMethodException e)
        {
            addTest(warning("Class "+theClass.getName()+" has no public constructor TestCase(String name) or TestCase()"));
            return;
        } //End block
        if(!Modifier.isPublic(theClass.getModifiers()))        
        {
            addTest(warning("Class "+theClass.getName()+" is not public"));
            return;
        } //End block
        Class superClass = theClass;
        Vector names = new Vector();
        while
(Test.class.isAssignableFrom(superClass))        
        {
            Method[] methods = superClass.getDeclaredMethods();
for(int i= 0;i < methods.length;i++)
            {
                addTestMethod(methods[i], names, theClass);
            } //End block
            superClass= superClass.getSuperclass();
        } //End block
        if(fTests.size() == 0)        
        addTest(warning("No tests found in "+theClass.getName()));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.344 -0400", hash_original_method = "AFEF019FF6F5ADCED59C3EF3F970BCF3", hash_generated_method = "5F3C16489AAF3913541789E8247BC8C9")
    public  TestSuite(String name) {
        addTaint(name.getTaint());
        setName(name);
        // ---------- Original Method ----------
        //setName(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.345 -0400", hash_original_method = "B0D60F12FAFD1CE95A6EC9A16242DD4A", hash_generated_method = "05178B25CDE3B67F7E232AF91946EFBF")
    public void addTest(Test test) {
        addTaint(test.getTaint());
        fTests.addElement(test);
        // ---------- Original Method ----------
        //fTests.addElement(test);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.345 -0400", hash_original_method = "5E5F33FEDF0C0EFDF119171FAEDAFD32", hash_generated_method = "6CFD0503B09D63BD095D6EB7A3EB02CD")
    public void addTestSuite(Class testClass) {
        addTaint(testClass.getTaint());
        addTest(new TestSuite(testClass));
        // ---------- Original Method ----------
        //addTest(new TestSuite(testClass));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.346 -0400", hash_original_method = "A640EC9003137483798EE7A767F176ED", hash_generated_method = "EB9357559CC18E0E634C71F7CD139CBD")
    private void addTestMethod(Method m, Vector names, Class theClass) {
        addTaint(theClass.getTaint());
        addTaint(names.getTaint());
        addTaint(m.getTaint());
        String name = m.getName();
        if(names.contains(name))        
        return;
        if(! isPublicTestMethod(m))        
        {
            if(isTestMethod(m))            
            addTest(warning("Test method isn't public: "+m.getName()));
            return;
        } //End block
        names.addElement(name);
        addTest(createTest(theClass, name));
        // ---------- Original Method ----------
        //String name= m.getName();
        //if (names.contains(name))
            //return;
        //if (! isPublicTestMethod(m)) {
            //if (isTestMethod(m))
                //addTest(warning("Test method isn't public: "+m.getName()));
            //return;
        //}
        //names.addElement(name);
        //addTest(createTest(theClass, name));
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static String exceptionToString(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.347 -0400", hash_original_method = "97313544C5808DC71CDB6C5E60051996", hash_generated_method = "12312826A848DF12DA9E28947ADFD752")
    public int countTestCases() {
        int count = 0;
for(Enumeration e= tests();e.hasMoreElements();)
        {
            Test test = (Test)e.nextElement();
            count= count + test.countTestCases();
        } //End block
        int varE2942A04780E223B215EB8B663CF5353_1157871865 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300476362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300476362;
        // ---------- Original Method ----------
        //int count= 0;
        //for (Enumeration e= tests(); e.hasMoreElements(); ) {
            //Test test= (Test)e.nextElement();
            //count= count + test.countTestCases();
        //}
        //return count;
    }

    
    @DSModeled(DSC.SAFE)
    public static Constructor getTestConstructor(Class theClass) throws NoSuchMethodException {
        Class[] args= { String.class };
        try {
            return theClass.getConstructor(args);
        } catch (NoSuchMethodException e) {
        }
        return theClass.getConstructor(new Class[0]);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.348 -0400", hash_original_method = "473CCC3375A8D379896F6F0BA14357FA", hash_generated_method = "888176BF90C1A87FBF4A955A73085C0C")
    private boolean isPublicTestMethod(Method m) {
        addTaint(m.getTaint());
        boolean var3EAD2356F51F58734A9E6F13F0C9FAFD_1283161446 = (isTestMethod(m) && Modifier.isPublic(m.getModifiers()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381377484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381377484;
        // ---------- Original Method ----------
        //return isTestMethod(m) && Modifier.isPublic(m.getModifiers());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.348 -0400", hash_original_method = "F90105657E9B98DED7B6D12FD1F09EBC", hash_generated_method = "CCC0CCE29CBA6534D0E0F11754C54B10")
    private boolean isTestMethod(Method m) {
        addTaint(m.getTaint());
        String name = m.getName();
        Class[] parameters = m.getParameterTypes();
        Class returnType = m.getReturnType();
        boolean var57746E1C48195FCB7CCD5557E9380224_1420910756 = (parameters.length == 0 && name.startsWith("test") && returnType.equals(Void.TYPE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490258959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490258959;
        // ---------- Original Method ----------
        //String name= m.getName();
        //Class[] parameters= m.getParameterTypes();
        //Class returnType= m.getReturnType();
        //return parameters.length == 0 && name.startsWith("test") && returnType.equals(Void.TYPE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.349 -0400", hash_original_method = "9C37034A26A50FB27EDBD0F4F43B733F", hash_generated_method = "E0A942EEBA0EB5AEEE1A6D2018D96C90")
    public void run(TestResult result) {
        addTaint(result.getTaint());
for(Enumeration e= tests();e.hasMoreElements();)
        {
            if(result.shouldStop())            
            break;
            Test test = (Test)e.nextElement();
            runTest(test, result);
        } //End block
        // ---------- Original Method ----------
        //for (Enumeration e= tests(); e.hasMoreElements(); ) {
              //if (result.shouldStop() )
                  //break;
            //Test test= (Test)e.nextElement();
            //runTest(test, result);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.349 -0400", hash_original_method = "72CC76A3223CEB1EEB432C33F48F7C56", hash_generated_method = "C84288FAA08D03A80F4707F04221A38C")
    public void runTest(Test test, TestResult result) {
        addTaint(result.getTaint());
        addTaint(test.getTaint());
        test.run(result);
        // ---------- Original Method ----------
        //test.run(result);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.349 -0400", hash_original_method = "7408A183124CA9C5AD907B0700EAE7FB", hash_generated_method = "EE68D9FF7B945764EF461BC2996C7341")
    public Test testAt(int index) {
        addTaint(index);
Test varE475EB1CBBC65BBAF0BB971E7BE4BD70_1396404749 =         (Test)fTests.elementAt(index);
        varE475EB1CBBC65BBAF0BB971E7BE4BD70_1396404749.addTaint(taint);
        return varE475EB1CBBC65BBAF0BB971E7BE4BD70_1396404749;
        // ---------- Original Method ----------
        //return (Test)fTests.elementAt(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.350 -0400", hash_original_method = "5EA215DA9294B33CBBC0BB090BEF7D0B", hash_generated_method = "188314A38C4D2C6CAADEDD04234EAFB8")
    public int testCount() {
        int var6A2C65EAA1DBEAB7A067E61E49925D4A_1390703172 = (fTests.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457233761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457233761;
        // ---------- Original Method ----------
        //return fTests.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.350 -0400", hash_original_method = "57D1A40E229C18FE8565EDC5A0EA03E1", hash_generated_method = "3FEE61763191B19DE6D726748F6F7F51")
    public Enumeration tests() {
Enumeration var29E37B82B015CC762CB187233998C059_261631085 =         fTests.elements();
        var29E37B82B015CC762CB187233998C059_261631085.addTaint(taint);
        return var29E37B82B015CC762CB187233998C059_261631085;
        // ---------- Original Method ----------
        //return fTests.elements();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.350 -0400", hash_original_method = "F367A28EAE938EF24D795301F789D610", hash_generated_method = "414AA96EC74E247CAB8CDA9DD3871669")
    public String toString() {
        if(getName() != null)        
        {
String var674CAC8E34E5C6C4D042792BFADA198C_399829454 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_399829454.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_399829454;
        }
String varD8287C6801A4C167675BF9EBA9EC2C1B_1319249102 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_1319249102.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_1319249102;
        // ---------- Original Method ----------
        //if (getName() != null)
            //return getName();
        //return super.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.351 -0400", hash_original_method = "6B586B3A073E23F7D2AE9C8A9582E34C", hash_generated_method = "61CBF5B9E74EA314A73D0181F1AF068A")
    public void setName(String name) {
        fName= name;
        // ---------- Original Method ----------
        //fName= name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.351 -0400", hash_original_method = "2EA0F9602490A1D20696A18728516755", hash_generated_method = "4DE8F57D099D99DC8B703FAEB27B5EBF")
    public String getName() {
String var7008830BBF5901458C7F9C81D44DB32A_1665225864 =         fName;
        var7008830BBF5901458C7F9C81D44DB32A_1665225864.addTaint(taint);
        return var7008830BBF5901458C7F9C81D44DB32A_1665225864;
        // ---------- Original Method ----------
        //return fName;
    }

    
    @DSModeled(DSC.BAN)
    private static Test warning(final String message) {
        return new TestCase("warning") {
            protected void runTest() {
                fail(message);
            }
        };
    }

    
}

