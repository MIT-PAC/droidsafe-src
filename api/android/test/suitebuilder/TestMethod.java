package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import junit.framework.TestCase;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.558 -0400", hash_original_field = "778943794DB9E30DC87B8F346E6CF336", hash_generated_field = "4B9B267011D653678A1583AF1D29B06C")

    private String enclosingClassname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.558 -0400", hash_original_field = "77F9E185D104CCA41B69200CF65EC898", hash_generated_field = "5A6576C23C399B00DCB8F0CE832CF8AB")

    private String testMethodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.558 -0400", hash_original_field = "33B2723DA86C97CE8FAC78210089CEBE", hash_generated_field = "104C173A8DBEEF7D6B4715BD9F48974B")

    private Class<? extends TestCase> enclosingClass;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.559 -0400", hash_original_method = "2AA4194F9790074918F9B75DD6221149", hash_generated_method = "BBB7E432ACC0FBC9929A1E8CCE93C396")
    public  TestMethod(Method method, Class<? extends TestCase> enclosingClass) {
        this(method.getName(), enclosingClass);
        addTaint(enclosingClass.getTaint());
        addTaint(method.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.560 -0400", hash_original_method = "5FFA0DBC667D98DF223FC5CBA0BC38DE", hash_generated_method = "FEDF627DC18F9E087D101D71B673696A")
    public  TestMethod(String methodName, Class<? extends TestCase> enclosingClass) {
        this.enclosingClass = enclosingClass;
        this.enclosingClassname = enclosingClass.getName();
        this.testMethodName = methodName;
        // ---------- Original Method ----------
        //this.enclosingClass = enclosingClass;
        //this.enclosingClassname = enclosingClass.getName();
        //this.testMethodName = methodName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.560 -0400", hash_original_method = "3C76676D8E2DB85D3A8C798366AD92CE", hash_generated_method = "CEE0CEEF07C50B9DA2E965D5CDB3D31C")
    public  TestMethod(TestCase testCase) {
        this(testCase.getName(), testCase.getClass());
        addTaint(testCase.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.560 -0400", hash_original_method = "2386A4DFFFB383A6C0CF09ED3BEE1A87", hash_generated_method = "36172C4E05DD7F791ED5C1285609AD21")
    public String getName() {
String varA4C9EC0FD5B3028FE8B5A6286DFAFED0_853116402 =         testMethodName;
        varA4C9EC0FD5B3028FE8B5A6286DFAFED0_853116402.addTaint(taint);
        return varA4C9EC0FD5B3028FE8B5A6286DFAFED0_853116402;
        // ---------- Original Method ----------
        //return testMethodName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.560 -0400", hash_original_method = "39FD7F6F7AA49837DBE77C9F52124BDE", hash_generated_method = "EFCD60260178995494B1890E13B19CB6")
    public String getEnclosingClassname() {
String var70BA58E354093CAAF65F7577E0A19767_796500065 =         enclosingClassname;
        var70BA58E354093CAAF65F7577E0A19767_796500065.addTaint(taint);
        return var70BA58E354093CAAF65F7577E0A19767_796500065;
        // ---------- Original Method ----------
        //return enclosingClassname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.561 -0400", hash_original_method = "0CE278D185BC58FF80C97732E6956457", hash_generated_method = "A8CA604DF392754AEFBC404BD39AFFD2")
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        addTaint(annotationClass.getTaint());
        try 
        {
T var324CE2F6140A562CCF31A2BF285CA24A_281264113 =             getEnclosingClass().getMethod(getName()).getAnnotation(annotationClass);
            var324CE2F6140A562CCF31A2BF285CA24A_281264113.addTaint(taint);
            return var324CE2F6140A562CCF31A2BF285CA24A_281264113;
        } //End block
        catch (NoSuchMethodException e)
        {
T var540C13E9E156B687226421B24F2DF178_303216342 =             null;
            var540C13E9E156B687226421B24F2DF178_303216342.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_303216342;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getEnclosingClass().getMethod(getName()).getAnnotation(annotationClass);
        //} catch (NoSuchMethodException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.561 -0400", hash_original_method = "560FD95528D8BB515E717AAB73D6F7F9", hash_generated_method = "5490AA869BDFF27F34231BB0BEC4A6A4")
    @SuppressWarnings("unchecked")
    public Class<? extends TestCase> getEnclosingClass() {
Class<? extends TestCase> var67157264981E698D7E7E8B718102A399_1355170383 =         enclosingClass;
        var67157264981E698D7E7E8B718102A399_1355170383.addTaint(taint);
        return var67157264981E698D7E7E8B718102A399_1355170383;
        // ---------- Original Method ----------
        //return enclosingClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.561 -0400", hash_original_method = "4B6F3152800DFE9006457E64BA8A155E", hash_generated_method = "488CD6B5B4E033B0BA2528B8FDF983CE")
    public TestCase createTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
TestCase var4E67A1ABAA82E50DD551FC54F00F6BA9_673014778 =         instantiateTest(enclosingClass, testMethodName);
        var4E67A1ABAA82E50DD551FC54F00F6BA9_673014778.addTaint(taint);
        return var4E67A1ABAA82E50DD551FC54F00F6BA9_673014778;
        // ---------- Original Method ----------
        //return instantiateTest(enclosingClass, testMethodName);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.562 -0400", hash_original_method = "61AE5164C815A2E387BB0A5F097B4DE9", hash_generated_method = "199979792466A8971BCA377291B5754B")
    @SuppressWarnings("unchecked")
    private TestCase instantiateTest(Class testCaseClass, String testName) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        addTaint(testName.getTaint());
        addTaint(testCaseClass.getTaint());
        Constructor[] constructors = testCaseClass.getConstructors();
    if(constructors.length == 0)        
        {
TestCase var266471F13BD240748A815F8CAD3E5E46_364742340 =             instantiateTest(testCaseClass.getSuperclass(), testName);
            var266471F13BD240748A815F8CAD3E5E46_364742340.addTaint(taint);
            return var266471F13BD240748A815F8CAD3E5E46_364742340;
        } //End block
        else
        {
for(Constructor constructor : constructors)
            {
                Class[] params = constructor.getParameterTypes();
    if(noargsConstructor(params))                
                {
                    TestCase test = ((Constructor<? extends TestCase>) constructor).newInstance();
                    test.setName(testName);
TestCase varB481C4977C3E3DE299395D5227B858D5_940540182 =                     test;
                    varB481C4977C3E3DE299395D5227B858D5_940540182.addTaint(taint);
                    return varB481C4977C3E3DE299395D5227B858D5_940540182;
                } //End block
                else
    if(singleStringConstructor(params))                
                {
TestCase var7292EF57907F5BE446BFFC9C3193CDDB_444079716 =                     ((Constructor<? extends TestCase>) constructor)
                            .newInstance(testName);
                    var7292EF57907F5BE446BFFC9C3193CDDB_444079716.addTaint(taint);
                    return var7292EF57907F5BE446BFFC9C3193CDDB_444079716;
                } //End block
            } //End block
        } //End block
        RuntimeException varF1A09A17AEB8227EF192EC2964C9AEE7_2112538791 = new RuntimeException("Unable to locate a constructor for "
                + testCaseClass.getName());
        varF1A09A17AEB8227EF192EC2964C9AEE7_2112538791.addTaint(taint);
        throw varF1A09A17AEB8227EF192EC2964C9AEE7_2112538791;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.562 -0400", hash_original_method = "FBC2F46CB59FCB97277C0D78D7FF3B06", hash_generated_method = "71174A83F45B2802958B8DB8453B6203")
    private boolean singleStringConstructor(Class[] params) {
        addTaint(params[0].getTaint());
        boolean var530D3C8CDA278A5B16D10713ACC3B209_1506848684 = ((params.length == 1) && (params[0].equals(String.class)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693551935 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693551935;
        // ---------- Original Method ----------
        //return (params.length == 1) && (params[0].equals(String.class));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.562 -0400", hash_original_method = "F253E63E2D085BA681D7F5582B501A13", hash_generated_method = "4FB982206B877C3C61B719DFDB17C415")
    private boolean noargsConstructor(Class[] params) {
        addTaint(params[0].getTaint());
        boolean var22C77C8A6D119B166E7131B229286925_719816761 = (params.length == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482844544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482844544;
        // ---------- Original Method ----------
        //return params.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.563 -0400", hash_original_method = "41856ADD5C3ABB33F713F0C76937EAB6", hash_generated_method = "21EF842B59D76A55E1D45B57758F9FEA")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1822633999 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301613475 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301613475;
        } //End block
    if(o == null || getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_322393277 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131732063 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_131732063;
        } //End block
        TestMethod that = (TestMethod) o;
    if(enclosingClassname != null
                ? !enclosingClassname.equals(that.enclosingClassname)
                : that.enclosingClassname != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_175392843 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_593271979 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_593271979;
        } //End block
    if(testMethodName != null
                ? !testMethodName.equals(that.testMethodName)
                : that.testMethodName != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1652317587 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351028232 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_351028232;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_108147882 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549170574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549170574;
        // ---------- Original Method ----------
        //if (this == o) {
            //return true;
        //}
        //if (o == null || getClass() != o.getClass()) {
            //return false;
        //}
        //TestMethod that = (TestMethod) o;
        //if (enclosingClassname != null
                //? !enclosingClassname.equals(that.enclosingClassname)
                //: that.enclosingClassname != null) {
            //return false;
        //}
        //if (testMethodName != null
                //? !testMethodName.equals(that.testMethodName)
                //: that.testMethodName != null) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.564 -0400", hash_original_method = "C5B5AC51B53BC81DCA89EA241A184E78", hash_generated_method = "EE8FB5801BB0EB5E682F4A620234A7D8")
    @Override
    public int hashCode() {
        int result;
        result = (enclosingClassname != null ? enclosingClassname.hashCode() : 0);
        result = 31 * result + (testMethodName != null ? testMethodName.hashCode() : 0);
        int varB4A88417B3D0170D754C647C30B7216A_934134038 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884589368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1884589368;
        // ---------- Original Method ----------
        //int result;
        //result = (enclosingClassname != null ? enclosingClassname.hashCode() : 0);
        //result = 31 * result + (testMethodName != null ? testMethodName.hashCode() : 0);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.564 -0400", hash_original_method = "B494E05710D5BDAFDFF94E1B47B79EFE", hash_generated_method = "71D33B1837B7259C4ED39777F6A4B4E6")
    @Override
    public String toString() {
String var3C2D685A7CACFC8B69F97E9E8468821C_420447797 =         enclosingClassname + "." + testMethodName;
        var3C2D685A7CACFC8B69F97E9E8468821C_420447797.addTaint(taint);
        return var3C2D685A7CACFC8B69F97E9E8468821C_420447797;
        // ---------- Original Method ----------
        //return enclosingClassname + "." + testMethodName;
    }

    
}

