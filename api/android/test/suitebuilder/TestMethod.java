package android.test.suitebuilder;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.TestCase;





public class TestMethod {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.588 -0500", hash_original_field = "64A32E8E7BFE62A68BE11F0567DCBBFF", hash_generated_field = "4B9B267011D653678A1583AF1D29B06C")


    private  String enclosingClassname;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.590 -0500", hash_original_field = "20AE5A9557A4226659C5A08DE3DA1797", hash_generated_field = "5A6576C23C399B00DCB8F0CE832CF8AB")

    private  String testMethodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.592 -0500", hash_original_field = "B6751CD58791E90CCD7E150DD0FC7DA9", hash_generated_field = "104C173A8DBEEF7D6B4715BD9F48974B")

    private  Class<? extends TestCase> enclosingClass;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.595 -0500", hash_original_method = "2AA4194F9790074918F9B75DD6221149", hash_generated_method = "B0BBF0665EF4D63EB6D2DE6AA4EB568B")
    
public TestMethod(Method method, Class<? extends TestCase> enclosingClass) {
        this(method.getName(), enclosingClass);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.598 -0500", hash_original_method = "5FFA0DBC667D98DF223FC5CBA0BC38DE", hash_generated_method = "B0CB1C1E8B1581D3FC66E9FB6E22D810")
    
public TestMethod(String methodName, Class<? extends TestCase> enclosingClass) {
        this.enclosingClass = enclosingClass;
        this.enclosingClassname = enclosingClass.getName();
        this.testMethodName = methodName;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.600 -0500", hash_original_method = "3C76676D8E2DB85D3A8C798366AD92CE", hash_generated_method = "46D06B19C4DBB5FFF6EA36062A7E36E3")
    
public TestMethod(TestCase testCase) {
        this(testCase.getName(), testCase.getClass());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.602 -0500", hash_original_method = "2386A4DFFFB383A6C0CF09ED3BEE1A87", hash_generated_method = "E7CE953CD4969D82DA08D038C7E9589A")
    
public String getName() {
        return testMethodName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.605 -0500", hash_original_method = "39FD7F6F7AA49837DBE77C9F52124BDE", hash_generated_method = "F79F7E96346F75164201BC02E0391CA6")
    
public String getEnclosingClassname() {
        return enclosingClassname;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.609 -0500", hash_original_method = "560FD95528D8BB515E717AAB73D6F7F9", hash_generated_method = "A3BF4470D78E1FE72D44928DDACF47F3")
    
@SuppressWarnings("unchecked")
    public Class<? extends TestCase> getEnclosingClass() {
        return enclosingClass;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.611 -0500", hash_original_method = "4B6F3152800DFE9006457E64BA8A155E", hash_generated_method = "F849D56604F8215C8AB99E50285CEE5B")
    
public TestCase createTest()
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
        return instantiateTest(enclosingClass, testMethodName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.614 -0500", hash_original_method = "61AE5164C815A2E387BB0A5F097B4DE9", hash_generated_method = "04865E3F3B1D3D83FCAE3057BC0F5A34")
    
@SuppressWarnings("unchecked")
    private TestCase instantiateTest(Class testCaseClass, String testName)
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor[] constructors = testCaseClass.getConstructors();

        if (constructors.length == 0) {
            return instantiateTest(testCaseClass.getSuperclass(), testName);
        } else {
            for (Constructor constructor : constructors) {
                Class[] params = constructor.getParameterTypes();
                if (noargsConstructor(params)) {
                    TestCase test = ((Constructor<? extends TestCase>) constructor).newInstance();
                    // JUnit will run just the one test if you call
                    // {@link TestCase#setName(String)}
                    test.setName(testName);
                    return test;
                } else if (singleStringConstructor(params)) {
                    return ((Constructor<? extends TestCase>) constructor)
                            .newInstance(testName);
                }
            }
        }
        throw new RuntimeException("Unable to locate a constructor for "
                + testCaseClass.getName());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.616 -0500", hash_original_method = "FBC2F46CB59FCB97277C0D78D7FF3B06", hash_generated_method = "38140D38D9C3F0D80D661EA9425ED659")
    
private boolean singleStringConstructor(Class[] params) {
        return (params.length == 1) && (params[0].equals(String.class));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.619 -0500", hash_original_method = "F253E63E2D085BA681D7F5582B501A13", hash_generated_method = "EF7D9BEB350E03B3D7B3F92FE4E27FA9")
    
private boolean noargsConstructor(Class[] params) {
        return params.length == 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.621 -0500", hash_original_method = "41856ADD5C3ABB33F713F0C76937EAB6", hash_generated_method = "7EDFCF309FD9C3CBAA30CC77DDE5FD39")
    
@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TestMethod that = (TestMethod) o;

        if (enclosingClassname != null
                ? !enclosingClassname.equals(that.enclosingClassname)
                : that.enclosingClassname != null) {
            return false;
        }
        if (testMethodName != null
                ? !testMethodName.equals(that.testMethodName)
                : that.testMethodName != null) {
            return false;
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.624 -0500", hash_original_method = "C5B5AC51B53BC81DCA89EA241A184E78", hash_generated_method = "215CDB28333D897D9FCB0C2C37F97785")
    
@Override
    public int hashCode() {
        int result;
        result = (enclosingClassname != null ? enclosingClassname.hashCode() : 0);
        result = 31 * result + (testMethodName != null ? testMethodName.hashCode() : 0);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:43.627 -0500", hash_original_method = "B494E05710D5BDAFDFF94E1B47B79EFE", hash_generated_method = "71B0232F6AEA01F5D4F93336085937DF")
    
@Override
    public String toString() {
        return enclosingClassname + "." + testMethodName;
    }

    
}

