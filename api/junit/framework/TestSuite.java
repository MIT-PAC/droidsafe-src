package junit.framework;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Vector;
import java.util.Enumeration;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.*;
import java.lang.reflect.Constructor;

public class TestSuite implements Test {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.337 -0400", hash_original_field = "3BCA106602C866BE981E31C77F5BEC5D", hash_generated_field = "B0AB7F7DF848E16FC564E5B040C82D2A")

    private Vector fTests = new Vector(10);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.337 -0400", hash_original_field = "92C0A4FDDE9C65D69627C13D4397EA3F", hash_generated_field = "44478883D7DC475A853C092E4F2639C3")

    private String fName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.337 -0400", hash_original_method = "32487D028E6F96FB94F028FA0EDAB2CF", hash_generated_method = "A3BB17C6F6CBA255CBA107DF4331D4C9")
    public  TestSuite() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.338 -0400", hash_original_method = "C68844F78BFBC377AC149EE8998489D7", hash_generated_method = "694BA6E6591B51908D02CCDF5FCE398A")
    public  TestSuite(Class theClass, String name) {
        this(theClass);
        addTaint(name.getTaint());
        addTaint(theClass.getTaint());
        setName(name);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.339 -0400", hash_original_method = "EB6125039DDD9B135BF27E0F52457DF2", hash_generated_method = "B1E5ED7CBEE0EE1D93F5C5B6A241BCCF")
    public  TestSuite(final Class theClass) {
        fName= theClass.getName();
        try 
        {
            getTestConstructor(theClass);
        } 
        catch (NoSuchMethodException e)
        {
            addTest(warning("Class "+theClass.getName()+" has no public constructor TestCase(String name) or TestCase()"));
            return;
        } 
    if(!Modifier.isPublic(theClass.getModifiers()))        
        {
            addTest(warning("Class "+theClass.getName()+" is not public"));
            return;
        } 
        Class superClass = theClass;
        Vector names = new Vector();
        while
(Test.class.isAssignableFrom(superClass))        
        {
            Method[] methods = superClass.getDeclaredMethods();
for(int i= 0;i < methods.length;i++)
            {
                addTestMethod(methods[i], names, theClass);
            } 
            superClass= superClass.getSuperclass();
        } 
    if(fTests.size() == 0)        
        addTest(warning("No tests found in "+theClass.getName()));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.339 -0400", hash_original_method = "AFEF019FF6F5ADCED59C3EF3F970BCF3", hash_generated_method = "5F3C16489AAF3913541789E8247BC8C9")
    public  TestSuite(String name) {
        addTaint(name.getTaint());
        setName(name);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.340 -0400", hash_original_method = "B0D60F12FAFD1CE95A6EC9A16242DD4A", hash_generated_method = "05178B25CDE3B67F7E232AF91946EFBF")
    public void addTest(Test test) {
        addTaint(test.getTaint());
        fTests.addElement(test);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.340 -0400", hash_original_method = "5E5F33FEDF0C0EFDF119171FAEDAFD32", hash_generated_method = "6CFD0503B09D63BD095D6EB7A3EB02CD")
    public void addTestSuite(Class testClass) {
        addTaint(testClass.getTaint());
        addTest(new TestSuite(testClass));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.340 -0400", hash_original_method = "A640EC9003137483798EE7A767F176ED", hash_generated_method = "EB9357559CC18E0E634C71F7CD139CBD")
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
        } 
        names.addElement(name);
        addTest(createTest(theClass, name));
        
        
        
            
        
            
                
            
        
        
        
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

    
        @DSModeled(DSC.SAFE)
    private static String exceptionToString(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        return stringWriter.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.341 -0400", hash_original_method = "97313544C5808DC71CDB6C5E60051996", hash_generated_method = "C3CF39ABF9330428EFEE25832528C423")
    public int countTestCases() {
        int count = 0;
for(Enumeration e= tests();e.hasMoreElements();)
        {
            Test test = (Test)e.nextElement();
            count= count + test.countTestCases();
        } 
        int varE2942A04780E223B215EB8B663CF5353_135330709 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736658065 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736658065;
        
        
        
            
            
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.342 -0400", hash_original_method = "473CCC3375A8D379896F6F0BA14357FA", hash_generated_method = "638BA0F2EF9FB6CE4C8763F4C5724E7D")
    private boolean isPublicTestMethod(Method m) {
        addTaint(m.getTaint());
        boolean var3EAD2356F51F58734A9E6F13F0C9FAFD_617737867 = (isTestMethod(m) && Modifier.isPublic(m.getModifiers()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987223502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_987223502;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.342 -0400", hash_original_method = "F90105657E9B98DED7B6D12FD1F09EBC", hash_generated_method = "C6F7CAE20F8DACF38351E24F9152F585")
    private boolean isTestMethod(Method m) {
        addTaint(m.getTaint());
        String name = m.getName();
        Class[] parameters = m.getParameterTypes();
        Class returnType = m.getReturnType();
        boolean var57746E1C48195FCB7CCD5557E9380224_1269500328 = (parameters.length == 0 && name.startsWith("test") && returnType.equals(Void.TYPE));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_236373952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_236373952;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.343 -0400", hash_original_method = "9C37034A26A50FB27EDBD0F4F43B733F", hash_generated_method = "E0A942EEBA0EB5AEEE1A6D2018D96C90")
    public void run(TestResult result) {
        addTaint(result.getTaint());
for(Enumeration e= tests();e.hasMoreElements();)
        {
    if(result.shouldStop())            
            break;
            Test test = (Test)e.nextElement();
            runTest(test, result);
        } 
        
        
              
                  
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.343 -0400", hash_original_method = "72CC76A3223CEB1EEB432C33F48F7C56", hash_generated_method = "C84288FAA08D03A80F4707F04221A38C")
    public void runTest(Test test, TestResult result) {
        addTaint(result.getTaint());
        addTaint(test.getTaint());
        test.run(result);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.343 -0400", hash_original_method = "7408A183124CA9C5AD907B0700EAE7FB", hash_generated_method = "0A10A78DC7DCF81046638B7E49CE0B0C")
    public Test testAt(int index) {
        addTaint(index);
Test varE475EB1CBBC65BBAF0BB971E7BE4BD70_1566249558 =         (Test)fTests.elementAt(index);
        varE475EB1CBBC65BBAF0BB971E7BE4BD70_1566249558.addTaint(taint);
        return varE475EB1CBBC65BBAF0BB971E7BE4BD70_1566249558;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.343 -0400", hash_original_method = "5EA215DA9294B33CBBC0BB090BEF7D0B", hash_generated_method = "BF631850BFE83102785D7FB572533B65")
    public int testCount() {
        int var6A2C65EAA1DBEAB7A067E61E49925D4A_1357389825 = (fTests.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594129806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_594129806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.344 -0400", hash_original_method = "57D1A40E229C18FE8565EDC5A0EA03E1", hash_generated_method = "010E55E630DFF73298E557846A7D7627")
    public Enumeration tests() {
Enumeration var29E37B82B015CC762CB187233998C059_1967358861 =         fTests.elements();
        var29E37B82B015CC762CB187233998C059_1967358861.addTaint(taint);
        return var29E37B82B015CC762CB187233998C059_1967358861;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.344 -0400", hash_original_method = "F367A28EAE938EF24D795301F789D610", hash_generated_method = "F9275C4CC944BA46A67E9741939A3A9F")
    public String toString() {
    if(getName() != null)        
        {
String var674CAC8E34E5C6C4D042792BFADA198C_1765724786 =         getName();
        var674CAC8E34E5C6C4D042792BFADA198C_1765724786.addTaint(taint);
        return var674CAC8E34E5C6C4D042792BFADA198C_1765724786;
        }
String varD8287C6801A4C167675BF9EBA9EC2C1B_1465764302 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_1465764302.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_1465764302;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.344 -0400", hash_original_method = "6B586B3A073E23F7D2AE9C8A9582E34C", hash_generated_method = "61CBF5B9E74EA314A73D0181F1AF068A")
    public void setName(String name) {
        fName= name;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.345 -0400", hash_original_method = "2EA0F9602490A1D20696A18728516755", hash_generated_method = "0DA86F48B49F2D4A3AF5D3F9103DED65")
    public String getName() {
String var7008830BBF5901458C7F9C81D44DB32A_32055543 =         fName;
        var7008830BBF5901458C7F9C81D44DB32A_32055543.addTaint(taint);
        return var7008830BBF5901458C7F9C81D44DB32A_32055543;
        
        
    }

    
        private static Test warning(final String message) {
        return new TestCase("warning") {
            protected void runTest() {
                fail(message);
            }
        };
    }

    
}

