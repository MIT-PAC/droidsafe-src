package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMStack;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.net.URL;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import libcore.util.CollectionUtils;
import libcore.util.EmptyArray;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Class<T> implements Serializable, AnnotatedElement, GenericDeclaration, Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.490 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.490 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
	public  Class() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.491 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "638E758822AA6143595BF786C3FBBBF4")
    private String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation();
    if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_755870702 =             null;
            var540C13E9E156B687226421B24F2DF178_755870702.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_755870702;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_1648713954 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_1648713954.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_1648713954;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation();
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.692 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "580560D142C0CD8EEA5AC831F856A095")
    private Object[] getSignatureAnnotation() {
    	Object[] foo = new Object[0];
    	foo.addTaint(this.taint);
    	return foo;
    }

    
        public static Class<?> forName(String className) throws ClassNotFoundException {
        return forName(className, true, VMStack.getCallingClassLoader());
    }

    
        public static Class<?> forName(String className, boolean initializeBoolean,
            ClassLoader classLoader) throws ClassNotFoundException {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        Class<?> result;
        try {
            result = classForName(className, initializeBoolean,
                    classLoader);
        } catch (ClassNotFoundException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ExceptionInInitializerError) {
                throw (ExceptionInInitializerError) cause;
            }
            throw e;
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    static Class<?> classForName(String className, boolean initializeBoolean,
            ClassLoader classLoader) throws ClassNotFoundException {
    	Class<?> cl = Object.class;
    	return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.494 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "BCEB68B3499E56808A688E7B233A6FEB")
    public Class<?>[] getClasses() {
Class<?>[] var57EE08F656A9480168173204F99AA4D1_1482397406 =         getFullListOfClasses(true);
        var57EE08F656A9480168173204F99AA4D1_1482397406.addTaint(taint);
        return var57EE08F656A9480168173204F99AA4D1_1482397406;
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.495 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "F2F9F134F999C749DDF35DBF083AD327")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1062492067 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1062492067.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1062492067;
        } //End block
        A annotation = getDeclaredAnnotation(annotationType);
    if(annotation != null)        
        {
A varB5EBB19788F53663B19E3EA6F1AE265A_391734486 =             annotation;
            varB5EBB19788F53663B19E3EA6F1AE265A_391734486.addTaint(taint);
            return varB5EBB19788F53663B19E3EA6F1AE265A_391734486;
        } //End block
    if(annotationType.isAnnotationPresent(Inherited.class))        
        {
for(Class<?> sup = getSuperclass();sup != null;sup = sup.getSuperclass())
            {
                annotation = sup.getDeclaredAnnotation(annotationType);
    if(annotation != null)                
                {
A varB5EBB19788F53663B19E3EA6F1AE265A_1653423662 =                     annotation;
                    varB5EBB19788F53663B19E3EA6F1AE265A_1653423662.addTaint(taint);
                    return varB5EBB19788F53663B19E3EA6F1AE265A_1653423662;
                } //End block
            } //End block
        } //End block
A var540C13E9E156B687226421B24F2DF178_810715064 =         null;
        var540C13E9E156B687226421B24F2DF178_810715064.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_810715064;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //A annotation = getDeclaredAnnotation(annotationType);
        //if (annotation != null) {
            //return annotation;
        //}
        //if (annotationType.isAnnotationPresent(Inherited.class)) {
            //for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                //annotation = sup.getDeclaredAnnotation(annotationType);
                //if (annotation != null) {
                    //return annotation;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.496 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "0F711BBA7A3D98C7752D0433B305323D")
    public Annotation[] getAnnotations() {
        HashMap<Class, Annotation> map = new HashMap<Class, Annotation>();
        Annotation[] declaredAnnotations = getDeclaredAnnotations();
for(int i = declaredAnnotations.length-1;i >= 0;--i)
        {
            map.put(declaredAnnotations[i].annotationType(), declaredAnnotations[i]);
        } //End block
for(Class<?> sup = getSuperclass();sup != null;sup = sup.getSuperclass())
        {
            declaredAnnotations = sup.getDeclaredAnnotations();
for(int i = declaredAnnotations.length-1;i >= 0;--i)
            {
                Class<?> clazz = declaredAnnotations[i].annotationType();
    if(!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class))                
                {
                    map.put(clazz, declaredAnnotations[i]);
                } //End block
            } //End block
        } //End block
        Collection<Annotation> coll = map.values();
Annotation[] var4D8E3EA02357DB4A1B69E2F9F800E29B_441275720 =         coll.toArray(new Annotation[coll.size()]);
        var4D8E3EA02357DB4A1B69E2F9F800E29B_441275720.addTaint(taint);
        return var4D8E3EA02357DB4A1B69E2F9F800E29B_441275720;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.497 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "CA39BC36C260176EFB9F3CB009FA39C1")
    public String getCanonicalName() {
    if(isLocalClass() || isAnonymousClass())        
        {
String var540C13E9E156B687226421B24F2DF178_1773480994 =         null;
        var540C13E9E156B687226421B24F2DF178_1773480994.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1773480994;
        }
    if(isArray())        
        {
            String name = getComponentType().getCanonicalName();
    if(name != null)            
            {
String var23BD481D46C5AB23ACCAFBC01875058D_456244887 =                 name + "[]";
                var23BD481D46C5AB23ACCAFBC01875058D_456244887.addTaint(taint);
                return var23BD481D46C5AB23ACCAFBC01875058D_456244887;
            } //End block
        } //End block
        else
    if(isMemberClass())        
        {
            String name = getDeclaringClass().getCanonicalName();
    if(name != null)            
            {
String varACD0E7C41AB29D5A792C8B678E06D150_288408525 =                 name + "." + getSimpleName();
                varACD0E7C41AB29D5A792C8B678E06D150_288408525.addTaint(taint);
                return varACD0E7C41AB29D5A792C8B678E06D150_288408525;
            } //End block
        } //End block
        else
        {
String var674CAC8E34E5C6C4D042792BFADA198C_1367345572 =             getName();
            var674CAC8E34E5C6C4D042792BFADA198C_1367345572.addTaint(taint);
            return var674CAC8E34E5C6C4D042792BFADA198C_1367345572;
        } //End block
String var540C13E9E156B687226421B24F2DF178_1044257279 =         null;
        var540C13E9E156B687226421B24F2DF178_1044257279.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1044257279;
        // ---------- Original Method ----------
        //if (isLocalClass() || isAnonymousClass())
            //return null;
        //if (isArray()) {
            //String name = getComponentType().getCanonicalName();
            //if (name != null) {
                //return name + "[]";
            //}
        //} else if (isMemberClass()) {
            //String name = getDeclaringClass().getCanonicalName();
            //if (name != null) {
                //return name + "." + getSimpleName();
            //}
        //} else {
            //return getName();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.498 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "5A7C18FA41607E8E152D37F4D0FD95FC")
    public ClassLoader getClassLoader() {
    if(this.isPrimitive())        
        {
ClassLoader var540C13E9E156B687226421B24F2DF178_1356645593 =             null;
            var540C13E9E156B687226421B24F2DF178_1356645593.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1356645593;
        } //End block
        ClassLoader loader = getClassLoaderImpl();
    if(loader == null)        
        {
            loader = BootClassLoader.getInstance();
        } //End block
ClassLoader var556906CF8230EF926A9ABDA8D8CDBEFA_485323466 =         loader;
        var556906CF8230EF926A9ABDA8D8CDBEFA_485323466.addTaint(taint);
        return var556906CF8230EF926A9ABDA8D8CDBEFA_485323466;
        // ---------- Original Method ----------
        //if (this.isPrimitive()) {
            //return null;
        //}
        //ClassLoader loader = getClassLoaderImpl();
        //if (loader == null) {
            //loader = BootClassLoader.getInstance();
        //}
        //return loader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.499 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "15A55D188568D70CD802B495B9FDC2ED")
     ClassLoader getClassLoaderImpl() {
        ClassLoader loader = getClassLoader(this);
ClassLoader varCF4789975F8C078EDDC0A2EE6321BC19_1935621164 =         loader == null ? BootClassLoader.getInstance() : loader;
        varCF4789975F8C078EDDC0A2EE6321BC19_1935621164.addTaint(taint);
        return varCF4789975F8C078EDDC0A2EE6321BC19_1935621164;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
    @DSModeled(DSC.SAFE)
    private static ClassLoader getClassLoader(Class<?> clazz) {
    	return clazz.getClassLoader();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.699 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "CDEED6F065A507A7FECB927A85CD4D66")
    public Class<?> getComponentType() {
    	Class<?> cl = (Class)new Object();
    	cl.addTaint(this.taint);
    	return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.500 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "EA3D9ED499666F4A48C57E35AF152ABD")
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
Constructor<T> var47E06E3838B21F4A2F3DABBEB5CEAF67_970679451 =         (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
        var47E06E3838B21F4A2F3DABBEB5CEAF67_970679451.addTaint(taint);
        return var47E06E3838B21F4A2F3DABBEB5CEAF67_970679451;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.501 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "3925637027602BCE310836D7B29CAABD")
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(publicOnly);
        addTaint(recursive);
        addTaint(name.getTaint());
    if(recursive && !publicOnly)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_435218178 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_435218178.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_435218178;
        } //End block
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_347575963 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_347575963.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_347575963;
        } //End block
    if(parameterTypes == null)        
        {
            parameterTypes = EmptyArray.CLASS;
        } //End block
for(Class<?> c : parameterTypes)
        {
    if(c == null)            
            {
                NoSuchMethodException varA4C56224F20096ECA3BB3F14FA4B502E_866585270 = new NoSuchMethodException("parameter type is null");
                varA4C56224F20096ECA3BB3F14FA4B502E_866585270.addTaint(taint);
                throw varA4C56224F20096ECA3BB3F14FA4B502E_866585270;
            } //End block
        } //End block
        Member result = recursive
                ? getPublicConstructorOrMethodRecursive(name, parameterTypes)
                : Class.getDeclaredConstructorOrMethod(this, name, parameterTypes);
    if(result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0)        
        {
            NoSuchMethodException varCC7AF5C3A968FEE7885B0585D35A6D6F_1889426196 = new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            varCC7AF5C3A968FEE7885B0585D35A6D6F_1889426196.addTaint(taint);
            throw varCC7AF5C3A968FEE7885B0585D35A6D6F_1889426196;
        } //End block
Member varDC838461EE2FA0CA4C9BBB70A15456B0_2013412063 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2013412063.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2013412063;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.502 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "BF69E0129B42B0A4057F553A47FC1E1C")
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
            Member result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
    if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)            
            {
Member varDC838461EE2FA0CA4C9BBB70A15456B0_1222725579 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1222725579.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1222725579;
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                Member result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
    if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)                
                {
Member varDC838461EE2FA0CA4C9BBB70A15456B0_790549324 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_790549324.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_790549324;
                } //End block
            } //End block
        } //End block
Member var540C13E9E156B687226421B24F2DF178_1975270992 =         null;
        var540C13E9E156B687226421B24F2DF178_1975270992.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1975270992;
        // ---------- Original Method ----------
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //Member result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
            //if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                //return result;
            //}
        //}
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Class<?> ifc : c.getInterfaces()) {
                //Member result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                //if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                    //return result;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.503 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "B031CB8EBC708C7A68262689C0C57EF4")
    public Constructor<?>[] getConstructors() {
Constructor<?>[] varA9159445F27BE5BF96D07DDC5E555495_907043263 =         getDeclaredConstructors(this, true);
        varA9159445F27BE5BF96D07DDC5E555495_907043263.addTaint(taint);
        return varA9159445F27BE5BF96D07DDC5E555495_907043263;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, true);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "2A0D770C788AFD3292AC02E319E3DDE7", hash_generated_method = "DB9C61E181111C55768DF3409E22B2FA")
    public Annotation[] getDeclaredAnnotations() {
    	Annotation[] ret = new Annotation[0];
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "097083D90BBF2FCC58AC81DB8664E54F", hash_generated_method = "33C06C0DC63918D788913C928E9A0C55")
    private <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
    	A ret = (A)new Object();
       	addTaint(annotationClass.taint);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.504 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "54EBD2ACB95BAE2CC00CAD85F14F5B14")
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1105818971 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1105818971;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.505 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "B616C14424DA4742F9BB544A95FCF33D")
    public Class<?>[] getDeclaredClasses() {
Class<?>[] var8EE83CDE3434CCDD419D669BAA2B0697_1004226844 =         getDeclaredClasses(this, false);
        var8EE83CDE3434CCDD419D669BAA2B0697_1004226844.addTaint(taint);
        return var8EE83CDE3434CCDD419D669BAA2B0697_1004226844;
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.505 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "2AB13528B5E1F305B077ED65C634CC6C")
    private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        addTaint(publicOnly);
        Class<?>[] result = getDeclaredClasses(this, publicOnly);
        Class<?> clazz = this.getSuperclass();
        while
(clazz != null)        
        {
            Class<?>[] temp = getDeclaredClasses(clazz, publicOnly);
    if(temp.length != 0)            
            {
                result = arraycopy(new Class[result.length + temp.length], result, temp);
            } //End block
            clazz = clazz.getSuperclass();
        } //End block
Class<?>[] varDC838461EE2FA0CA4C9BBB70A15456B0_1270477149 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1270477149.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1270477149;
        // ---------- Original Method ----------
        //Class<?>[] result = getDeclaredClasses(this, publicOnly);
        //Class<?> clazz = this.getSuperclass();
        //while (clazz != null) {
            //Class<?>[] temp = getDeclaredClasses(clazz, publicOnly);
            //if (temp.length != 0) {
                //result = arraycopy(new Class[result.length + temp.length], result, temp);
            //}
            //clazz = clazz.getSuperclass();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    private static Class<?>[] getDeclaredClasses(Class<?> clazz, boolean publicOnly) {
    	Class[] ret = new Class[0];
    	ret.addTaint(clazz.taint);
    	ret.addTaint(publicOnly);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.506 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "C0AFFEDB416EA501F13828FB9D656063")
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
Constructor<T> varE919D75DEE456BB1E58FF0D420209277_1817068408 =         (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
        varE919D75DEE456BB1E58FF0D420209277_1817068408.addTaint(taint);
        return varE919D75DEE456BB1E58FF0D420209277_1817068408;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.507 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "99AA1E5B82E7C066CBC0846C53822DA1")
    public Constructor<?>[] getDeclaredConstructors() {
Constructor<?>[] var5F5BAEB34C8FF5D8C71B8F5213D8B45B_346324131 =         getDeclaredConstructors(this, false);
        var5F5BAEB34C8FF5D8C71B8F5213D8B45B_346324131.addTaint(taint);
        return var5F5BAEB34C8FF5D8C71B8F5213D8B45B_346324131;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, false);
    }

    
    @DSModeled(DSC.SAFE)
    private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
    	Constructor[] ret = new Constructor[0];
    	ret.addTaint(clazz.taint);
    	ret.addTaint(publicOnly);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.508 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "FBF0F11E6F56F487AE4E682DE8F3C115")
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_459727491 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_459727491.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_459727491;
        } //End block
        Field result = getDeclaredField(this, name);
    if(result == null)        
        {
            NoSuchFieldException varD1B492B296DA9CE84CEF37C9691D7298_1078444103 = new NoSuchFieldException(name);
            varD1B492B296DA9CE84CEF37C9691D7298_1078444103.addTaint(taint);
            throw varD1B492B296DA9CE84CEF37C9691D7298_1078444103;
        } //End block
Field varDC838461EE2FA0CA4C9BBB70A15456B0_832412406 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_832412406.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_832412406;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //Field result = getDeclaredField(this, name);
        //if (result == null) {
            //throw new NoSuchFieldException(name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.508 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "F67DFE4C4C715C07CB04BD5398215659")
    public Field[] getDeclaredFields() {
Field[] varB13318B8B62F8154F0AA694406899EAD_1673644481 =         getDeclaredFields(this, false);
        varB13318B8B62F8154F0AA694406899EAD_1673644481.addTaint(taint);
        return varB13318B8B62F8154F0AA694406899EAD_1673644481;
        // ---------- Original Method ----------
        //return getDeclaredFields(this, false);
    }

    
    @DSModeled(DSC.SAFE)
    static Field[] getDeclaredFields(Class<?> clazz, boolean publicOnly) {
    	Field[] ret = new Field[0];
    	ret.addTaint(clazz.taint);
    	ret.addTaint(publicOnly);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    static Field getDeclaredField(Class<?> clazz, String name) {
    	Field ret = new Field();
    	ret.addTaint(clazz.taint);
    	ret.addTaint(name.taint);
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.510 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "2A5302D64E13B2F3D9D70928E441D4D4")
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
        Member member = getConstructorOrMethod(name, false, false, parameterTypes);
    if(member instanceof Constructor)        
        {
            NoSuchMethodException var93C0A6E4B35311031E6696E05613AB9B_2095665781 = new NoSuchMethodException(name);
            var93C0A6E4B35311031E6696E05613AB9B_2095665781.addTaint(taint);
            throw var93C0A6E4B35311031E6696E05613AB9B_2095665781;
        } //End block
Method var66E333884789DB1C291D2403B1EF3C16_819252196 =         (Method) member;
        var66E333884789DB1C291D2403B1EF3C16_819252196.addTaint(taint);
        return var66E333884789DB1C291D2403B1EF3C16_819252196;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.510 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "9587F8447C177D8868E00E59D34AF440")
    public Method[] getDeclaredMethods() {
Method[] var25212F30F28FFBC38919078B7CC0EB00_558030359 =         getDeclaredMethods(this, false);
        var25212F30F28FFBC38919078B7CC0EB00_558030359.addTaint(taint);
        return var25212F30F28FFBC38919078B7CC0EB00_558030359;
        // ---------- Original Method ----------
        //return getDeclaredMethods(this, false);
    }

    
    @DSModeled(DSC.SAFE)
    static Method[] getDeclaredMethods(Class<?> clazz, boolean publicOnly) {
    	Method[] ret = new Method[0];
    	ret[0].addTaint(clazz.taint);
    	ret[0].addTaint(publicOnly);
    	return ret;
    }

    
    @DSModeled(DSC.BAN)
    static Member getDeclaredConstructorOrMethod(Class clazz, String name, Class[] args) {
    	Method ret = new Method();
    	ret.addTaint(clazz.taint);
    	ret.addTaint(name.taint);
    	ret.addTaint(args[0].taint);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.716 -0400", hash_original_method = "67DCCE022B38EF56E621E9F7C3410002", hash_generated_method = "A08735CEB9F08341039B8C54A1BD5E61")
    public Class<?> getDeclaringClass() {
    	Class  ret = (Class)new Object();
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "B183618DCECD1DBBC6B77A8041AAB5FF", hash_generated_method = "E19B04C40918C59F801E144F365A783E")
    public Class<?> getEnclosingClass() {
    	Class  ret = (Class)new Object();
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "66CD711920ADA841CC04EC44C476AA92", hash_generated_method = "E9EFFA224CF0890C33C432913B5CDC4A")
    public Constructor<?> getEnclosingConstructor() {
    	Constructor  ret = new Constructor();
    	return ret;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "42F609F6A3577ECAA8EE5F0164C83C69")
    public Method getEnclosingMethod() {
    	Method  ret = new Method();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.513 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "F380FE0F1BD3B6E5E7675B0EFB838F37")
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
    if(!isEnum())        
        {
T[] var540C13E9E156B687226421B24F2DF178_1441682285 =             null;
            var540C13E9E156B687226421B24F2DF178_1441682285.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1441682285;
        } //End block
T[] varC2E74EBDC7FFA30F9E3563FB5AB670BB_387812107 =         (T[]) Enum.getSharedConstants((Class) this).clone();
        varC2E74EBDC7FFA30F9E3563FB5AB670BB_387812107.addTaint(taint);
        return varC2E74EBDC7FFA30F9E3563FB5AB670BB_387812107;
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.513 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "A9502913541536B864A6C682D4528997")
    public Field getField(String name) throws NoSuchFieldException {
        addTaint(name.getTaint());
    if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_1722237903 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_1722237903.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_1722237903;
        } //End block
        Field result = getPublicFieldRecursive(name);
    if(result == null)        
        {
            NoSuchFieldException varD1B492B296DA9CE84CEF37C9691D7298_2062676406 = new NoSuchFieldException(name);
            varD1B492B296DA9CE84CEF37C9691D7298_2062676406.addTaint(taint);
            throw varD1B492B296DA9CE84CEF37C9691D7298_2062676406;
        } //End block
Field varDC838461EE2FA0CA4C9BBB70A15456B0_49363263 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_49363263.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_49363263;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException("name == null");
        //}
        //Field result = getPublicFieldRecursive(name);
        //if (result == null) {
            //throw new NoSuchFieldException(name);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.514 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "BC1CFD88E02812887833A13FED9AE668")
    private Field getPublicFieldRecursive(String name) {
        addTaint(name.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
            Field result = Class.getDeclaredField(c, name);
    if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)            
            {
Field varDC838461EE2FA0CA4C9BBB70A15456B0_2048743956 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_2048743956.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_2048743956;
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                Field result = ifc.getPublicFieldRecursive(name);
    if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)                
                {
Field varDC838461EE2FA0CA4C9BBB70A15456B0_271299567 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_271299567.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_271299567;
                } //End block
            } //End block
        } //End block
Field var540C13E9E156B687226421B24F2DF178_466518098 =         null;
        var540C13E9E156B687226421B24F2DF178_466518098.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_466518098;
        // ---------- Original Method ----------
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //Field result = Class.getDeclaredField(c, name);
            //if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                //return result;
            //}
        //}
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Class<?> ifc : c.getInterfaces()) {
                //Field result = ifc.getPublicFieldRecursive(name);
                //if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                    //return result;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.515 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "3D10D455BC6FFA02E76D92C79BC43EAC")
    public Field[] getFields() {
        List<Field> fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
Field[] varF97ABECB072F72F32D1A6FDB275E9804_1169863822 =         fields.toArray(new Field[fields.size()]);
        varF97ABECB072F72F32D1A6FDB275E9804_1169863822.addTaint(taint);
        return varF97ABECB072F72F32D1A6FDB275E9804_1169863822;
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.516 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "361118F139993F02EF5C2AEF8822592C")
    private void getPublicFieldsRecursive(List<Field> result) {
        addTaint(result.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Field field : Class.getDeclaredFields(c, true))
            {
                result.add(field);
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                ifc.getPublicFieldsRecursive(result);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Field field : Class.getDeclaredFields(c, true)) {
                //result.add(field);
            //}
        //}
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Class<?> ifc : c.getInterfaces()) {
                //ifc.getPublicFieldsRecursive(result);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.517 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "4F56E8D1B9D95EE8FE79BDC6CCFC9B32")
    public Type[] getGenericInterfaces() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
Type[] var00DF7A095BC8013DB06DB16809D8ED14_1846355776 =         Types.getClonedTypeArray(parser.interfaceTypes);
        var00DF7A095BC8013DB06DB16809D8ED14_1846355776.addTaint(taint);
        return var00DF7A095BC8013DB06DB16809D8ED14_1846355776;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.517 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "282895C14E4B816395ABB5DCBD7C6B50")
    public Type getGenericSuperclass() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
Type var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1917862524 =         Types.getType(parser.superclassType);
        var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1917862524.addTaint(taint);
        return var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1917862524;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getType(parser.superclassType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.741 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "2692A665379A2F86FF3326F5F5EB1B7B")
    public Class<?>[] getInterfaces() {
    	Class[] ret = new Class[0];
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.518 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "48CA08D2A8948DF38B17922BF525054D")
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
        Member member = getConstructorOrMethod(name, true, true, parameterTypes);
    if(member instanceof Constructor)        
        {
            NoSuchMethodException var93C0A6E4B35311031E6696E05613AB9B_1821202303 = new NoSuchMethodException(name);
            var93C0A6E4B35311031E6696E05613AB9B_1821202303.addTaint(taint);
            throw var93C0A6E4B35311031E6696E05613AB9B_1821202303;
        } //End block
Method var66E333884789DB1C291D2403B1EF3C16_2031324635 =         (Method) member;
        var66E333884789DB1C291D2403B1EF3C16_2031324635.addTaint(taint);
        return var66E333884789DB1C291D2403B1EF3C16_2031324635;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.519 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "7919127DBD233975B3958B59518DA119")
    public Method[] getMethods() {
        List<Method> methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
Method[] var1C3E257A090AB3A7E4DC4AC6985BC9FB_1514980703 =         methods.toArray(new Method[methods.size()]);
        var1C3E257A090AB3A7E4DC4AC6985BC9FB_1514980703.addTaint(taint);
        return var1C3E257A090AB3A7E4DC4AC6985BC9FB_1514980703;
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.519 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "3CEF07DB9400012F26BC5401CF6AD7DB")
    private void getPublicMethodsRecursive(List<Method> result) {
        addTaint(result.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Method method : Class.getDeclaredMethods(c, true))
            {
                result.add(method);
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                ifc.getPublicMethodsRecursive(result);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Method method : Class.getDeclaredMethods(c, true)) {
                //result.add(method);
            //}
        //}
        //for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            //for (Class<?> ifc : c.getInterfaces()) {
                //ifc.getPublicMethodsRecursive(result);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.520 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "22E6A32F4246BE80D0FD307354A75F0E")
    public int getModifiers() {
        int varFE4FFB4CAC8BB487081CD848C12AB306_652306166 = (getModifiers(this, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656783116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656783116;
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
    @DSModeled(DSC.SAFE)
    private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.521 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "0B3D07E8BB096B41D41CB7BC86BF7FBE")
    public String getName() {
        String result = name;
String var4C566AF6B2791407A05E4F4E371A49A8_875367358 =         (result == null) ? (name = getNameNative()) : result;
        var4C566AF6B2791407A05E4F4E371A49A8_875367358.addTaint(taint);
        return var4C566AF6B2791407A05E4F4E371A49A8_875367358;
        // ---------- Original Method ----------
        //String result = name;
        //return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.755 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "D2A1F2570A688E342CB66374B5D563FA")
    private String getNameNative() {
    	String ret = new String();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.522 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "FE7500D6E2B711E1BDC3B56F2C0C15E3")
    public String getSimpleName() {
    if(isArray())        
        {
String var8EFB0828ABFAF4510FBFBDDE880D15A2_1742939707 =             getComponentType().getSimpleName() + "[]";
            var8EFB0828ABFAF4510FBFBDDE880D15A2_1742939707.addTaint(taint);
            return var8EFB0828ABFAF4510FBFBDDE880D15A2_1742939707;
        } //End block
        String name = getName();
    if(isAnonymousClass())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_168350161 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_168350161.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_168350161;
        } //End block
    if(isMemberClass() || isLocalClass())        
        {
String var905F5014FFB14FA466009DDEAEA3A905_7205169 =             getInnerClassName();
            var905F5014FFB14FA466009DDEAEA3A905_7205169.addTaint(taint);
            return var905F5014FFB14FA466009DDEAEA3A905_7205169;
        } //End block
        int dot = name.lastIndexOf('.');
    if(dot != -1)        
        {
String var08A3BE0F715A4C53303FE59AFABEDC64_1716373213 =             name.substring(dot + 1);
            var08A3BE0F715A4C53303FE59AFABEDC64_1716373213.addTaint(taint);
            return var08A3BE0F715A4C53303FE59AFABEDC64_1716373213;
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_814603010 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_814603010.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_814603010;
        // ---------- Original Method ----------
        //if (isArray()) {
            //return getComponentType().getSimpleName() + "[]";
        //}
        //String name = getName();
        //if (isAnonymousClass()) {
            //return "";
        //}
        //if (isMemberClass() || isLocalClass()) {
            //return getInnerClassName();
        //}
        //int dot = name.lastIndexOf('.');
        //if (dot != -1) {
            //return name.substring(dot + 1);
        //}
        //return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.757 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "E15F8A7CFFBAA6A8E91B4004366ED98B")
    private String getInnerClassName() {
    	String ret = new String();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.523 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "CEFB538DDDE23F6529F18346CCBC19D4")
    public ProtectionDomain getProtectionDomain() {
ProtectionDomain var540C13E9E156B687226421B24F2DF178_609721631 =         null;
        var540C13E9E156B687226421B24F2DF178_609721631.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_609721631;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.524 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "F5C5E96AEF055C43F04C9A08E5DAEF02")
    public URL getResource(String resName) {
        addTaint(resName.getTaint());
    if(resName.startsWith("/"))        
        {
            resName = resName.substring(1);
        } //End block
        else
        {
            String pkg = getName();
            int dot = pkg.lastIndexOf('.');
    if(dot != -1)            
            {
                pkg = pkg.substring(0, dot).replace('.', '/');
            } //End block
            else
            {
                pkg = "";
            } //End block
            resName = pkg + "/" + resName;
        } //End block
        ClassLoader loader = getClassLoader();
    if(loader != null)        
        {
URL varBD7E03DCE503846452E4C60F282C5082_914595896 =             loader.getResource(resName);
            varBD7E03DCE503846452E4C60F282C5082_914595896.addTaint(taint);
            return varBD7E03DCE503846452E4C60F282C5082_914595896;
        } //End block
        else
        {
URL var5BCE521397D83220649EE68F62831709_708351454 =             ClassLoader.getSystemResource(resName);
            var5BCE521397D83220649EE68F62831709_708351454.addTaint(taint);
            return var5BCE521397D83220649EE68F62831709_708351454;
        } //End block
        // ---------- Original Method ----------
        //if (resName.startsWith("/")) {
            //resName = resName.substring(1);
        //} else {
            //String pkg = getName();
            //int dot = pkg.lastIndexOf('.');
            //if (dot != -1) {
                //pkg = pkg.substring(0, dot).replace('.', '/');
            //} else {
                //pkg = "";
            //}
            //resName = pkg + "/" + resName;
        //}
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //return loader.getResource(resName);
        //} else {
            //return ClassLoader.getSystemResource(resName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.526 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "5D9600C92442D1C7F73384765526C6AE")
    public InputStream getResourceAsStream(String resName) {
        addTaint(resName.getTaint());
    if(resName.startsWith("/"))        
        {
            resName = resName.substring(1);
        } //End block
        else
        {
            String pkg = getName();
            int dot = pkg.lastIndexOf('.');
    if(dot != -1)            
            {
                pkg = pkg.substring(0, dot).replace('.', '/');
            } //End block
            else
            {
                pkg = "";
            } //End block
            resName = pkg + "/" + resName;
        } //End block
        ClassLoader loader = getClassLoader();
    if(loader != null)        
        {
InputStream var7C96068EED3C187BCC2775F895143208_1603236582 =             loader.getResourceAsStream(resName);
            var7C96068EED3C187BCC2775F895143208_1603236582.addTaint(taint);
            return var7C96068EED3C187BCC2775F895143208_1603236582;
        } //End block
        else
        {
InputStream var3F96CF621A1F3E1A4483E32D8C834982_1542989165 =             ClassLoader.getSystemResourceAsStream(resName);
            var3F96CF621A1F3E1A4483E32D8C834982_1542989165.addTaint(taint);
            return var3F96CF621A1F3E1A4483E32D8C834982_1542989165;
        } //End block
        // ---------- Original Method ----------
        //if (resName.startsWith("/")) {
            //resName = resName.substring(1);
        //} else {
            //String pkg = getName();
            //int dot = pkg.lastIndexOf('.');
            //if (dot != -1) {
                //pkg = pkg.substring(0, dot).replace('.', '/');
            //} else {
                //pkg = "";
            //}
            //resName = pkg + "/" + resName;
        //}
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //return loader.getResourceAsStream(resName);
        //} else {
            //return ClassLoader.getSystemResourceAsStream(resName);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.527 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "96E6E94A03276F75BADACD4A18DA94AC")
    public Object[] getSigners() {
Object[] var540C13E9E156B687226421B24F2DF178_1313201088 =         null;
        var540C13E9E156B687226421B24F2DF178_1313201088.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1313201088;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
    	Class ret = (Class)new Object();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.527 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "5BB74A347DA95C4AAB0DA8B2E8C90372")
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
TypeVariable<Class<T>>[] var88FA10730ED8D83D53A7F9A30F5F0311_1560108881 =         parser.formalTypeParameters.clone();
        var88FA10730ED8D83D53A7F9A30F5F0311_1560108881.addTaint(taint);
        return var88FA10730ED8D83D53A7F9A30F5F0311_1560108881;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.528 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "6CE28AB787CC81196021257AEF3D686C")
    public boolean isAnnotation() {
        final int ACC_ANNOTATION = 0x2000;
        int mod = getModifiers(this, true);
        boolean varA8ED21048ED38EB744FB2B250A06985D_1239795096 = ((mod & ACC_ANNOTATION) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544957766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544957766;
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.529 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "71AF51EE863767E4109362B8C09761D4")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1844113658 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1844113658.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1844113658;
        } //End block
    if(isDeclaredAnnotationPresent(annotationType))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_219598604 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775878492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_775878492;
        } //End block
    if(annotationType.isDeclaredAnnotationPresent(Inherited.class))        
        {
for(Class<?> sup = getSuperclass();sup != null;sup = sup.getSuperclass())
            {
    if(sup.isDeclaredAnnotationPresent(annotationType))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1466623143 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456390163 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_456390163;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_833771675 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579243223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579243223;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //if (isDeclaredAnnotationPresent(annotationType)) {
            //return true;
        //}
        //if (annotationType.isDeclaredAnnotationPresent(Inherited.class)) {
            //for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                //if (sup.isDeclaredAnnotationPresent(annotationType)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.530 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "356F94E4D9F20F3A2496A308EBADD79C")
    public boolean isAnonymousClass() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_904262322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_904262322;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.530 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "8B2ECC76D51086ADFF441C535F8BF278")
    public boolean isArray() {
        boolean varD9EC80EBE7F6EA0E95A1BEB28155A254_152239394 = (getComponentType() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346194928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_346194928;
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.531 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "48A551731314D39509C33BA113F34A04")
    public boolean isAssignableFrom(Class<?> cls) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1947921045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1947921045;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.531 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "EAB6EBEFF9F12068E6B1B634803F84F1")
    public boolean isEnum() {
        boolean var11C2EB902A1B8BD8CBB2D065CAECE303_1014165857 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1000576128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1000576128;
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.532 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "FE8B4542EB723FBE63C827693EB87DF3")
    public boolean isInstance(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736038599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736038599;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.532 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "8C439B7498223A6A18E0A38B984CF910")
    public boolean isInterface() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237699335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237699335;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.532 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "291DC06D2E73E82F2D2B5DA0A168EFCC")
    public boolean isLocalClass() {
        boolean enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean var5A76BBF6F8D9D20B0C2DEE09C3D27C80_1856879773 = (enclosed && !isAnonymousClass());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127623756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127623756;
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.533 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "25EDA7F08669C428C37E55664FFA0E3A")
    public boolean isMemberClass() {
        boolean varC9096DA666816CCFBD0380B7F2B1C51A_1380029659 = (getDeclaringClass() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725652635 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725652635;
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.533 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "7FC3C856A3E1A1D7D8A17D6DFBC82417")
    public boolean isPrimitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812997109 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812997109;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.534 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "43EDD330CD7DA65CEBADB45393CD9575")
    public boolean isSynthetic() {
        final int ACC_SYNTHETIC = 0x1000;
        int mod = getModifiers(this, true);
        boolean varA3ED4501470133DDF149A0E39C2DD31F_335308508 = ((mod & ACC_SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20571958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_20571958;
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.535 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "A19EFB2FAD98BEF5C6D9EB9DCFDC7665")
    public T newInstance() throws InstantiationException, IllegalAccessException {
T varDABAB645F82D7DAC0FD72FFCF9059689_1735069706 =         newInstanceImpl();
        varDABAB645F82D7DAC0FD72FFCF9059689_1735069706.addTaint(taint);
        return varDABAB645F82D7DAC0FD72FFCF9059689_1735069706;
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.766 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
    	T ret = (T)new Object();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.535 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "B3E9EC5FDD4BAD282D8488315BFE21D4")
    @Override
    public String toString() {
    if(isPrimitive())        
        {
String var3324D10DB87BCD465548F8DC9ECC57B8_171353461 =             getSimpleName();
            var3324D10DB87BCD465548F8DC9ECC57B8_171353461.addTaint(taint);
            return var3324D10DB87BCD465548F8DC9ECC57B8_171353461;
        } //End block
        else
        {
String var098FF1C1E251D1D541F5C2B99C1AEADF_900011252 =             (isInterface() ? "interface " : "class ") + getName();
            var098FF1C1E251D1D541F5C2B99C1AEADF_900011252.addTaint(taint);
            return var098FF1C1E251D1D541F5C2B99C1AEADF_900011252;
        } //End block
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.536 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "504E49DFB9D7D58A46E96265AA4D497A")
    public Package getPackage() {
        ClassLoader loader = getClassLoader();
    if(loader != null)        
        {
            String name = getName();
            int dot = name.lastIndexOf('.');
Package var6194FAAADA178101667EADF15CA13617_1582975031 =             (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
            var6194FAAADA178101667EADF15CA13617_1582975031.addTaint(taint);
            return var6194FAAADA178101667EADF15CA13617_1582975031;
        } //End block
Package var540C13E9E156B687226421B24F2DF178_1480440375 =         null;
        var540C13E9E156B687226421B24F2DF178_1480440375.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1480440375;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.536 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "EB362C6781B568078638D25184727BC9")
    public boolean desiredAssertionStatus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631706015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631706015;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.537 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "3BFC72142ECD1C3F5487E4D76CD5A263")
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        addTaint(clazz.getTaint());
    if(clazz.isAssignableFrom(this))        
        {
Class<? extends U> var02DA6192FD05C589213B6B2CDFCD6CAA_590705386 =             (Class<? extends U>)this;
            var02DA6192FD05C589213B6B2CDFCD6CAA_590705386.addTaint(taint);
            return var02DA6192FD05C589213B6B2CDFCD6CAA_590705386;
        } //End block
        String actualClassName = this.getName();
        String desiredClassName = clazz.getName();
        ClassCastException var7B10A624B63DE93BBB3082FF2B62182B_955078151 = new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        var7B10A624B63DE93BBB3082FF2B62182B_955078151.addTaint(taint);
        throw var7B10A624B63DE93BBB3082FF2B62182B_955078151;
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.538 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "FFC55994B823210F3B4A12975BEA0918")
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        addTaint(obj.getTaint());
    if(obj == null)        
        {
T var540C13E9E156B687226421B24F2DF178_402689265 =             null;
            var540C13E9E156B687226421B24F2DF178_402689265.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_402689265;
        } //End block
        else
    if(this.isInstance(obj))        
        {
T var60E33DF11B55697B4C1C6AE5825E84D3_136459024 =             (T)obj;
            var60E33DF11B55697B4C1C6AE5825E84D3_136459024.addTaint(taint);
            return var60E33DF11B55697B4C1C6AE5825E84D3_136459024;
        } //End block
        String actualClassName = obj.getClass().getName();
        String desiredClassName = this.getName();
        ClassCastException var7B10A624B63DE93BBB3082FF2B62182B_233452772 = new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        var7B10A624B63DE93BBB3082FF2B62182B_233452772.addTaint(taint);
        throw var7B10A624B63DE93BBB3082FF2B62182B_233452772;
        // ---------- Original Method ----------
        //if (obj == null) {
            //return null;
        //} else if (this.isInstance(obj)) {
            //return (T)obj;
        //}
        //String actualClassName = obj.getClass().getName();
        //String desiredClassName = this.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
        private static <T extends Object> T[] arraycopy(T[] result, T[] head, T[] tail) {
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);
        return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.539 -0400", hash_original_field = "07BD6CDA090731A5E103F68AD0EAE9F3", hash_generated_field = "A2E36971CC30DE91D1AF4E9C02F420A3")

    private static final long serialVersionUID = 3206093459760846163L;
}

