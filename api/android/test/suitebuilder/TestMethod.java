package android.test.suitebuilder;

// Droidsafe Imports
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class TestMethod {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.220 -0400", hash_original_field = "778943794DB9E30DC87B8F346E6CF336", hash_generated_field = "4B9B267011D653678A1583AF1D29B06C")

    private String enclosingClassname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.220 -0400", hash_original_field = "77F9E185D104CCA41B69200CF65EC898", hash_generated_field = "5A6576C23C399B00DCB8F0CE832CF8AB")

    private String testMethodName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.220 -0400", hash_original_field = "33B2723DA86C97CE8FAC78210089CEBE", hash_generated_field = "104C173A8DBEEF7D6B4715BD9F48974B")

    private Class<? extends TestCase> enclosingClass;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.220 -0400", hash_original_method = "2AA4194F9790074918F9B75DD6221149", hash_generated_method = "BBB7E432ACC0FBC9929A1E8CCE93C396")
    public  TestMethod(Method method, Class<? extends TestCase> enclosingClass) {
        this(method.getName(), enclosingClass);
        addTaint(enclosingClass.getTaint());
        addTaint(method.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.221 -0400", hash_original_method = "5FFA0DBC667D98DF223FC5CBA0BC38DE", hash_generated_method = "FEDF627DC18F9E087D101D71B673696A")
    public  TestMethod(String methodName, Class<? extends TestCase> enclosingClass) {
        this.enclosingClass = enclosingClass;
        this.enclosingClassname = enclosingClass.getName();
        this.testMethodName = methodName;
        // ---------- Original Method ----------
        //this.enclosingClass = enclosingClass;
        //this.enclosingClassname = enclosingClass.getName();
        //this.testMethodName = methodName;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.222 -0400", hash_original_method = "3C76676D8E2DB85D3A8C798366AD92CE", hash_generated_method = "CEE0CEEF07C50B9DA2E965D5CDB3D31C")
    public  TestMethod(TestCase testCase) {
        this(testCase.getName(), testCase.getClass());
        addTaint(testCase.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.222 -0400", hash_original_method = "2386A4DFFFB383A6C0CF09ED3BEE1A87", hash_generated_method = "254CBE3D0AF5A9317031E95659332C80")
    public String getName() {
String varA4C9EC0FD5B3028FE8B5A6286DFAFED0_522845819 =         testMethodName;
        varA4C9EC0FD5B3028FE8B5A6286DFAFED0_522845819.addTaint(taint);
        return varA4C9EC0FD5B3028FE8B5A6286DFAFED0_522845819;
        // ---------- Original Method ----------
        //return testMethodName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.222 -0400", hash_original_method = "39FD7F6F7AA49837DBE77C9F52124BDE", hash_generated_method = "DEC59B133C82FE331616636B5EB8A027")
    public String getEnclosingClassname() {
String var70BA58E354093CAAF65F7577E0A19767_2078192430 =         enclosingClassname;
        var70BA58E354093CAAF65F7577E0A19767_2078192430.addTaint(taint);
        return var70BA58E354093CAAF65F7577E0A19767_2078192430;
        // ---------- Original Method ----------
        //return enclosingClassname;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.223 -0400", hash_original_method = "0CE278D185BC58FF80C97732E6956457", hash_generated_method = "037E28148623D937FDE0A23772D5557F")
    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        addTaint(annotationClass.getTaint());
        try 
        {
T var324CE2F6140A562CCF31A2BF285CA24A_621130133 =             getEnclosingClass().getMethod(getName()).getAnnotation(annotationClass);
            var324CE2F6140A562CCF31A2BF285CA24A_621130133.addTaint(taint);
            return var324CE2F6140A562CCF31A2BF285CA24A_621130133;
        } //End block
        catch (NoSuchMethodException e)
        {
T var540C13E9E156B687226421B24F2DF178_876805713 =             null;
            var540C13E9E156B687226421B24F2DF178_876805713.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_876805713;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getEnclosingClass().getMethod(getName()).getAnnotation(annotationClass);
        //} catch (NoSuchMethodException e) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.223 -0400", hash_original_method = "560FD95528D8BB515E717AAB73D6F7F9", hash_generated_method = "FAE032F1B9F727BE6E398E8B90B76680")
    @SuppressWarnings("unchecked")
    public Class<? extends TestCase> getEnclosingClass() {
Class<? extends TestCase> var67157264981E698D7E7E8B718102A399_887878991 =         enclosingClass;
        var67157264981E698D7E7E8B718102A399_887878991.addTaint(taint);
        return var67157264981E698D7E7E8B718102A399_887878991;
        // ---------- Original Method ----------
        //return enclosingClass;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.223 -0400", hash_original_method = "4B6F3152800DFE9006457E64BA8A155E", hash_generated_method = "D863E0FB93497AC4404A48820B0EFD82")
    public TestCase createTest() throws InvocationTargetException, IllegalAccessException, InstantiationException {
TestCase var4E67A1ABAA82E50DD551FC54F00F6BA9_159726554 =         instantiateTest(enclosingClass, testMethodName);
        var4E67A1ABAA82E50DD551FC54F00F6BA9_159726554.addTaint(taint);
        return var4E67A1ABAA82E50DD551FC54F00F6BA9_159726554;
        // ---------- Original Method ----------
        //return instantiateTest(enclosingClass, testMethodName);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.224 -0400", hash_original_method = "61AE5164C815A2E387BB0A5F097B4DE9", hash_generated_method = "F95B06C8C35958C6EB1EE7C6F836A4A0")
    @SuppressWarnings("unchecked")
    private TestCase instantiateTest(Class testCaseClass, String testName) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        addTaint(testName.getTaint());
        addTaint(testCaseClass.getTaint());
        Constructor[] constructors = testCaseClass.getConstructors();
        if(constructors.length == 0)        
        {
TestCase var266471F13BD240748A815F8CAD3E5E46_433355892 =             instantiateTest(testCaseClass.getSuperclass(), testName);
            var266471F13BD240748A815F8CAD3E5E46_433355892.addTaint(taint);
            return var266471F13BD240748A815F8CAD3E5E46_433355892;
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
TestCase varB481C4977C3E3DE299395D5227B858D5_445920239 =                     test;
                    varB481C4977C3E3DE299395D5227B858D5_445920239.addTaint(taint);
                    return varB481C4977C3E3DE299395D5227B858D5_445920239;
                } //End block
                else
                if(singleStringConstructor(params))                
                {
TestCase var7292EF57907F5BE446BFFC9C3193CDDB_44737021 =                     ((Constructor<? extends TestCase>) constructor)
                            .newInstance(testName);
                    var7292EF57907F5BE446BFFC9C3193CDDB_44737021.addTaint(taint);
                    return var7292EF57907F5BE446BFFC9C3193CDDB_44737021;
                } //End block
            } //End block
        } //End block
        RuntimeException varF1A09A17AEB8227EF192EC2964C9AEE7_1079483899 = new RuntimeException("Unable to locate a constructor for "
                + testCaseClass.getName());
        varF1A09A17AEB8227EF192EC2964C9AEE7_1079483899.addTaint(taint);
        throw varF1A09A17AEB8227EF192EC2964C9AEE7_1079483899;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.225 -0400", hash_original_method = "FBC2F46CB59FCB97277C0D78D7FF3B06", hash_generated_method = "4AB7E1BE30A04FC3F38C06B4790DEDCE")
    private boolean singleStringConstructor(Class[] params) {
        addTaint(params[0].getTaint());
        boolean var530D3C8CDA278A5B16D10713ACC3B209_301178175 = ((params.length == 1) && (params[0].equals(String.class)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400361250 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400361250;
        // ---------- Original Method ----------
        //return (params.length == 1) && (params[0].equals(String.class));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.226 -0400", hash_original_method = "F253E63E2D085BA681D7F5582B501A13", hash_generated_method = "6133363BD2BB17C6A3BCF44E5BAE3154")
    private boolean noargsConstructor(Class[] params) {
        addTaint(params[0].getTaint());
        boolean var22C77C8A6D119B166E7131B229286925_1134670832 = (params.length == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470390831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470390831;
        // ---------- Original Method ----------
        //return params.length == 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.228 -0400", hash_original_method = "41856ADD5C3ABB33F713F0C76937EAB6", hash_generated_method = "035740DC48AEAC3E1063217C4154DB0F")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_47914234 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904984144 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_904984144;
        } //End block
        if(o == null || getClass() != o.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_681988736 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_507990772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_507990772;
        } //End block
        TestMethod that = (TestMethod) o;
        if(enclosingClassname != null
                ? !enclosingClassname.equals(that.enclosingClassname)
                : that.enclosingClassname != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_270841333 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104248992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104248992;
        } //End block
        if(testMethodName != null
                ? !testMethodName.equals(that.testMethodName)
                : that.testMethodName != null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1708038375 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1989358694 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1989358694;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_318608956 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1374141539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1374141539;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.229 -0400", hash_original_method = "C5B5AC51B53BC81DCA89EA241A184E78", hash_generated_method = "D2B863E4DA0DB632F7F6341EB8968A85")
    @Override
    public int hashCode() {
        int result;
        result = (enclosingClassname != null ? enclosingClassname.hashCode() : 0);
        result = 31 * result + (testMethodName != null ? testMethodName.hashCode() : 0);
        int varB4A88417B3D0170D754C647C30B7216A_1170474643 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675041346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675041346;
        // ---------- Original Method ----------
        //int result;
        //result = (enclosingClassname != null ? enclosingClassname.hashCode() : 0);
        //result = 31 * result + (testMethodName != null ? testMethodName.hashCode() : 0);
        //return result;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.229 -0400", hash_original_method = "B494E05710D5BDAFDFF94E1B47B79EFE", hash_generated_method = "303D625C30550A417775286B719D395E")
    @Override
    public String toString() {
String var3C2D685A7CACFC8B69F97E9E8468821C_356326850 =         enclosingClassname + "." + testMethodName;
        var3C2D685A7CACFC8B69F97E9E8468821C_356326850.addTaint(taint);
        return var3C2D685A7CACFC8B69F97E9E8468821C_356326850;
        // ---------- Original Method ----------
        //return enclosingClassname + "." + testMethodName;
    }

    
}

