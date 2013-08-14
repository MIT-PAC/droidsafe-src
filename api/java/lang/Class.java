package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
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

import dalvik.system.VMStack;




import droidsafe.helpers.DSUtils;

public final class Class<T> implements Serializable, AnnotatedElement, GenericDeclaration, Type {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.624 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.490 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
	public  Class() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.624 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "F381E7F26C23D7611FE4A21954F45510")
    private String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation();
        if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2138252727 =             null;
            var540C13E9E156B687226421B24F2DF178_2138252727.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2138252727;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_2107392196 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_2107392196.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_2107392196;
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

    
    @DSModeled(DSC.BAN)
    public static Class<?> forName(String className) throws ClassNotFoundException {
        return forName(className, true, VMStack.getCallingClassLoader());
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.626 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "D65A47A68B039DD0ED589DE86DE4B062")
    public Class<?>[] getClasses() {
Class<?>[] var57EE08F656A9480168173204F99AA4D1_78090352 =         getFullListOfClasses(true);
        var57EE08F656A9480168173204F99AA4D1_78090352.addTaint(taint);
        return var57EE08F656A9480168173204F99AA4D1_78090352;
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.626 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "B7A3F7B3DC488C09635B8FBBAAD7576C")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_369997871 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_369997871.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_369997871;
        } //End block
        A annotation = getDeclaredAnnotation(annotationType);
        if(annotation != null)        
        {
A varB5EBB19788F53663B19E3EA6F1AE265A_918165834 =             annotation;
            varB5EBB19788F53663B19E3EA6F1AE265A_918165834.addTaint(taint);
            return varB5EBB19788F53663B19E3EA6F1AE265A_918165834;
        } //End block
        if(annotationType.isAnnotationPresent(Inherited.class))        
        {
for(Class<?> sup = getSuperclass();sup != null;sup = sup.getSuperclass())
            {
                annotation = sup.getDeclaredAnnotation(annotationType);
                if(annotation != null)                
                {
A varB5EBB19788F53663B19E3EA6F1AE265A_526672705 =                     annotation;
                    varB5EBB19788F53663B19E3EA6F1AE265A_526672705.addTaint(taint);
                    return varB5EBB19788F53663B19E3EA6F1AE265A_526672705;
                } //End block
            } //End block
        } //End block
A var540C13E9E156B687226421B24F2DF178_936883154 =         null;
        var540C13E9E156B687226421B24F2DF178_936883154.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_936883154;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.627 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "4B551EF27DC43B309DA4B1B8F35E960C")
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
Annotation[] var4D8E3EA02357DB4A1B69E2F9F800E29B_574772046 =         coll.toArray(new Annotation[coll.size()]);
        var4D8E3EA02357DB4A1B69E2F9F800E29B_574772046.addTaint(taint);
        return var4D8E3EA02357DB4A1B69E2F9F800E29B_574772046;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.627 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "81BD4EFEAC4B38E4C50966BAA6459CC9")
    public String getCanonicalName() {
        if(isLocalClass() || isAnonymousClass())        
        {
String var540C13E9E156B687226421B24F2DF178_242186414 =         null;
        var540C13E9E156B687226421B24F2DF178_242186414.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_242186414;
        }
        if(isArray())        
        {
            String name = getComponentType().getCanonicalName();
            if(name != null)            
            {
String var23BD481D46C5AB23ACCAFBC01875058D_10959188 =                 name + "[]";
                var23BD481D46C5AB23ACCAFBC01875058D_10959188.addTaint(taint);
                return var23BD481D46C5AB23ACCAFBC01875058D_10959188;
            } //End block
        } //End block
        else
        if(isMemberClass())        
        {
            String name = getDeclaringClass().getCanonicalName();
            if(name != null)            
            {
String varACD0E7C41AB29D5A792C8B678E06D150_1495589943 =                 name + "." + getSimpleName();
                varACD0E7C41AB29D5A792C8B678E06D150_1495589943.addTaint(taint);
                return varACD0E7C41AB29D5A792C8B678E06D150_1495589943;
            } //End block
        } //End block
        else
        {
String var674CAC8E34E5C6C4D042792BFADA198C_645417913 =             getName();
            var674CAC8E34E5C6C4D042792BFADA198C_645417913.addTaint(taint);
            return var674CAC8E34E5C6C4D042792BFADA198C_645417913;
        } //End block
String var540C13E9E156B687226421B24F2DF178_437128057 =         null;
        var540C13E9E156B687226421B24F2DF178_437128057.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_437128057;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.628 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "E00AA8FEA6081F66C75CD71FF4F609FC")
    public ClassLoader getClassLoader() {
        if(this.isPrimitive())        
        {
ClassLoader var540C13E9E156B687226421B24F2DF178_1917115939 =             null;
            var540C13E9E156B687226421B24F2DF178_1917115939.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1917115939;
        } //End block
        ClassLoader loader = getClassLoaderImpl();
        if(loader == null)        
        {
            loader = BootClassLoader.getInstance();
        } //End block
ClassLoader var556906CF8230EF926A9ABDA8D8CDBEFA_2002422129 =         loader;
        var556906CF8230EF926A9ABDA8D8CDBEFA_2002422129.addTaint(taint);
        return var556906CF8230EF926A9ABDA8D8CDBEFA_2002422129;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.628 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "CC7F6BAC62A26F0A14443C5A01CDDFA4")
     ClassLoader getClassLoaderImpl() {
        ClassLoader loader = getClassLoader(this);
ClassLoader varCF4789975F8C078EDDC0A2EE6321BC19_697004622 =         loader == null ? BootClassLoader.getInstance() : loader;
        varCF4789975F8C078EDDC0A2EE6321BC19_697004622.addTaint(taint);
        return varCF4789975F8C078EDDC0A2EE6321BC19_697004622;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.628 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "AF3BF7D2847B87E92369F3E0FA377EFE")
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
Constructor<T> var47E06E3838B21F4A2F3DABBEB5CEAF67_137831484 =         (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
        var47E06E3838B21F4A2F3DABBEB5CEAF67_137831484.addTaint(taint);
        return var47E06E3838B21F4A2F3DABBEB5CEAF67_137831484;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.629 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "DA8179D78C8ECEF5A1CD6846841BC252")
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(publicOnly);
        addTaint(recursive);
        addTaint(name.getTaint());
        if(recursive && !publicOnly)        
        {
            AssertionError varA81442E36297E737EB908877E58260E8_51015181 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_51015181.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_51015181;
        } //End block
        if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_249086522 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_249086522.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_249086522;
        } //End block
        if(parameterTypes == null)        
        {
            parameterTypes = EmptyArray.CLASS;
        } //End block
for(Class<?> c : parameterTypes)
        {
            if(c == null)            
            {
                NoSuchMethodException varA4C56224F20096ECA3BB3F14FA4B502E_1915855657 = new NoSuchMethodException("parameter type is null");
                varA4C56224F20096ECA3BB3F14FA4B502E_1915855657.addTaint(taint);
                throw varA4C56224F20096ECA3BB3F14FA4B502E_1915855657;
            } //End block
        } //End block
        Member result = recursive
                ? getPublicConstructorOrMethodRecursive(name, parameterTypes)
                : Class.getDeclaredConstructorOrMethod(this, name, parameterTypes);
        if(result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0)        
        {
            NoSuchMethodException varCC7AF5C3A968FEE7885B0585D35A6D6F_1394279535 = new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            varCC7AF5C3A968FEE7885B0585D35A6D6F_1394279535.addTaint(taint);
            throw varCC7AF5C3A968FEE7885B0585D35A6D6F_1394279535;
        } //End block
Member varDC838461EE2FA0CA4C9BBB70A15456B0_37218051 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_37218051.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_37218051;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.630 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "3281140ECD1E1C0F0D5988CE4375C0EC")
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
            Member result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
            if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)            
            {
Member varDC838461EE2FA0CA4C9BBB70A15456B0_2028787390 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_2028787390.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_2028787390;
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                Member result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)                
                {
Member varDC838461EE2FA0CA4C9BBB70A15456B0_1298759409 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1298759409.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1298759409;
                } //End block
            } //End block
        } //End block
Member var540C13E9E156B687226421B24F2DF178_193240318 =         null;
        var540C13E9E156B687226421B24F2DF178_193240318.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_193240318;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.630 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "439B1BF20B06DC700EBEBDAD920EC571")
    public Constructor<?>[] getConstructors() {
Constructor<?>[] varA9159445F27BE5BF96D07DDC5E555495_1540592959 =         getDeclaredConstructors(this, true);
        varA9159445F27BE5BF96D07DDC5E555495_1540592959.addTaint(taint);
        return varA9159445F27BE5BF96D07DDC5E555495_1540592959;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.631 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "53C538F592E38246CBBA117245307E84")
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255707121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255707121;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.631 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "E956F68FF1264D99EA10920E14CB8B6C")
    public Class<?>[] getDeclaredClasses() {
Class<?>[] var8EE83CDE3434CCDD419D669BAA2B0697_1153274799 =         getDeclaredClasses(this, false);
        var8EE83CDE3434CCDD419D669BAA2B0697_1153274799.addTaint(taint);
        return var8EE83CDE3434CCDD419D669BAA2B0697_1153274799;
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.632 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "5C893C103376D6A470D535D0396E0571")
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
Class<?>[] varDC838461EE2FA0CA4C9BBB70A15456B0_2086192930 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2086192930.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2086192930;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.632 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "A036CE7F889C5B8983F5CC2ED85B9E7D")
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
Constructor<T> varE919D75DEE456BB1E58FF0D420209277_914568623 =         (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
        varE919D75DEE456BB1E58FF0D420209277_914568623.addTaint(taint);
        return varE919D75DEE456BB1E58FF0D420209277_914568623;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.632 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "1F52E19EDAC3EDCEE3E1EB436C50B346")
    public Constructor<?>[] getDeclaredConstructors() {
Constructor<?>[] var5F5BAEB34C8FF5D8C71B8F5213D8B45B_301923970 =         getDeclaredConstructors(this, false);
        var5F5BAEB34C8FF5D8C71B8F5213D8B45B_301923970.addTaint(taint);
        return var5F5BAEB34C8FF5D8C71B8F5213D8B45B_301923970;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.633 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "23C1E48257964DDA12D98E7FA2819C3E")
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_1728202239 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_1728202239.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_1728202239;
        } //End block
        Field result = getDeclaredField(this, name);
        if(result == null)        
        {
            NoSuchFieldException varD1B492B296DA9CE84CEF37C9691D7298_1504577009 = new NoSuchFieldException(name);
            varD1B492B296DA9CE84CEF37C9691D7298_1504577009.addTaint(taint);
            throw varD1B492B296DA9CE84CEF37C9691D7298_1504577009;
        } //End block
Field varDC838461EE2FA0CA4C9BBB70A15456B0_1463488020 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1463488020.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1463488020;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.633 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "2D6CD6C22A0CF9E3EF2D1A38778E0FAA")
    public Field[] getDeclaredFields() {
Field[] varB13318B8B62F8154F0AA694406899EAD_732481342 =         getDeclaredFields(this, false);
        varB13318B8B62F8154F0AA694406899EAD_732481342.addTaint(taint);
        return varB13318B8B62F8154F0AA694406899EAD_732481342;
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

    
    @DSModeled(DSC.BAN)
    static Field getDeclaredField(Class<?> clazz, String name) {
    	Field ret = new Field();
    	ret.addTaint(clazz.taint);
    	ret.addTaint(name.taint);
    	return ret;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.633 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "D0CF2093E4AA413D9F87759F13C74310")
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
        Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        if(member instanceof Constructor)        
        {
            NoSuchMethodException var93C0A6E4B35311031E6696E05613AB9B_1283858730 = new NoSuchMethodException(name);
            var93C0A6E4B35311031E6696E05613AB9B_1283858730.addTaint(taint);
            throw var93C0A6E4B35311031E6696E05613AB9B_1283858730;
        } //End block
Method var66E333884789DB1C291D2403B1EF3C16_2046084421 =         (Method) member;
        var66E333884789DB1C291D2403B1EF3C16_2046084421.addTaint(taint);
        return var66E333884789DB1C291D2403B1EF3C16_2046084421;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.633 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "97E8F52775ABDB8F0900AE1D648B0F72")
    public Method[] getDeclaredMethods() {
Method[] var25212F30F28FFBC38919078B7CC0EB00_1791002978 =         getDeclaredMethods(this, false);
        var25212F30F28FFBC38919078B7CC0EB00_1791002978.addTaint(taint);
        return var25212F30F28FFBC38919078B7CC0EB00_1791002978;
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "42F609F6A3577ECAA8EE5F0164C83C69")
    public Method getEnclosingMethod() {
    	Method  ret = new Method();
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.634 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "605356D16B18958B582150948FDFE273")
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
        if(!isEnum())        
        {
T[] var540C13E9E156B687226421B24F2DF178_751348504 =             null;
            var540C13E9E156B687226421B24F2DF178_751348504.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_751348504;
        } //End block
T[] varC2E74EBDC7FFA30F9E3563FB5AB670BB_884900310 =         (T[]) Enum.getSharedConstants((Class) this).clone();
        varC2E74EBDC7FFA30F9E3563FB5AB670BB_884900310.addTaint(taint);
        return varC2E74EBDC7FFA30F9E3563FB5AB670BB_884900310;
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.634 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "8980F9434EE83C83F4E1A6CEBA2BA578")
    public Field getField(String name) throws NoSuchFieldException {
        addTaint(name.getTaint());
        if(name == null)        
        {
            NullPointerException varA117BA528B11F7D1AC96CABFD5286E5C_687836968 = new NullPointerException("name == null");
            varA117BA528B11F7D1AC96CABFD5286E5C_687836968.addTaint(taint);
            throw varA117BA528B11F7D1AC96CABFD5286E5C_687836968;
        } //End block
        Field result = getPublicFieldRecursive(name);
        if(result == null)        
        {
            NoSuchFieldException varD1B492B296DA9CE84CEF37C9691D7298_1509316714 = new NoSuchFieldException(name);
            varD1B492B296DA9CE84CEF37C9691D7298_1509316714.addTaint(taint);
            throw varD1B492B296DA9CE84CEF37C9691D7298_1509316714;
        } //End block
Field varDC838461EE2FA0CA4C9BBB70A15456B0_993043516 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_993043516.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_993043516;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.634 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "AD95D2C9A97BF346CEDD54ECEE6C3BBD")
    private Field getPublicFieldRecursive(String name) {
        addTaint(name.getTaint());
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
            Field result = Class.getDeclaredField(c, name);
            if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)            
            {
Field varDC838461EE2FA0CA4C9BBB70A15456B0_1145603665 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_1145603665.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_1145603665;
            } //End block
        } //End block
for(Class<?> c = this;c != null;c = c.getSuperclass())
        {
for(Class<?> ifc : c.getInterfaces())
            {
                Field result = ifc.getPublicFieldRecursive(name);
                if(result != null && (result.getModifiers() & Modifier.PUBLIC) != 0)                
                {
Field varDC838461EE2FA0CA4C9BBB70A15456B0_1033351298 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1033351298.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1033351298;
                } //End block
            } //End block
        } //End block
Field var540C13E9E156B687226421B24F2DF178_795432382 =         null;
        var540C13E9E156B687226421B24F2DF178_795432382.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_795432382;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.635 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "B401BA0D16342623556EE62358F29DC1")
    public Field[] getFields() {
        List<Field> fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
Field[] varF97ABECB072F72F32D1A6FDB275E9804_821689451 =         fields.toArray(new Field[fields.size()]);
        varF97ABECB072F72F32D1A6FDB275E9804_821689451.addTaint(taint);
        return varF97ABECB072F72F32D1A6FDB275E9804_821689451;
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.635 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "361118F139993F02EF5C2AEF8822592C")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.635 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "8F11D9058D463F7DD0F67EA272271A16")
    public Type[] getGenericInterfaces() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
Type[] var00DF7A095BC8013DB06DB16809D8ED14_1699004143 =         Types.getClonedTypeArray(parser.interfaceTypes);
        var00DF7A095BC8013DB06DB16809D8ED14_1699004143.addTaint(taint);
        return var00DF7A095BC8013DB06DB16809D8ED14_1699004143;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.635 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "B7D20D0D6F47060EFA69EEB95D40BA4D")
    public Type getGenericSuperclass() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
Type var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1863108335 =         Types.getType(parser.superclassType);
        var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1863108335.addTaint(taint);
        return var71A5E1DE09D6EE3F5949C6CCEFB94DA4_1863108335;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.635 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "28768E7A161FD8044CABECEE1834BDEF")
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        addTaint(parameterTypes[0].getTaint());
        addTaint(name.getTaint());
        Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        if(member instanceof Constructor)        
        {
            NoSuchMethodException var93C0A6E4B35311031E6696E05613AB9B_972050929 = new NoSuchMethodException(name);
            var93C0A6E4B35311031E6696E05613AB9B_972050929.addTaint(taint);
            throw var93C0A6E4B35311031E6696E05613AB9B_972050929;
        } //End block
Method var66E333884789DB1C291D2403B1EF3C16_2114431022 =         (Method) member;
        var66E333884789DB1C291D2403B1EF3C16_2114431022.addTaint(taint);
        return var66E333884789DB1C291D2403B1EF3C16_2114431022;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.636 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "3148101F22F6866524C465E17D398C1E")
    public Method[] getMethods() {
        List<Method> methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
Method[] var1C3E257A090AB3A7E4DC4AC6985BC9FB_1683180750 =         methods.toArray(new Method[methods.size()]);
        var1C3E257A090AB3A7E4DC4AC6985BC9FB_1683180750.addTaint(taint);
        return var1C3E257A090AB3A7E4DC4AC6985BC9FB_1683180750;
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.636 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "3CEF07DB9400012F26BC5401CF6AD7DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.636 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "5B873533CFE9265A2B31B5389EE5BDF6")
    public int getModifiers() {
        int varFE4FFB4CAC8BB487081CD848C12AB306_747472459 = (getModifiers(this, false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671161057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671161057;
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
    @DSModeled(DSC.SAFE)
    private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.636 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "EA739B3003F4C912DEAA33B13691CFA1")
    public String getName() {
        String result = name;
String var4C566AF6B2791407A05E4F4E371A49A8_1464709607 =         (result == null) ? (name = getNameNative()) : result;
        var4C566AF6B2791407A05E4F4E371A49A8_1464709607.addTaint(taint);
        return var4C566AF6B2791407A05E4F4E371A49A8_1464709607;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.636 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "FE62B6D1677B962A9E8D7239D728DFF5")
    public String getSimpleName() {
        if(isArray())        
        {
String var8EFB0828ABFAF4510FBFBDDE880D15A2_270744478 =             getComponentType().getSimpleName() + "[]";
            var8EFB0828ABFAF4510FBFBDDE880D15A2_270744478.addTaint(taint);
            return var8EFB0828ABFAF4510FBFBDDE880D15A2_270744478;
        } //End block
        String name = getName();
        if(isAnonymousClass())        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1474725886 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1474725886.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1474725886;
        } //End block
        if(isMemberClass() || isLocalClass())        
        {
String var905F5014FFB14FA466009DDEAEA3A905_1810438132 =             getInnerClassName();
            var905F5014FFB14FA466009DDEAEA3A905_1810438132.addTaint(taint);
            return var905F5014FFB14FA466009DDEAEA3A905_1810438132;
        } //End block
        int dot = name.lastIndexOf('.');
        if(dot != -1)        
        {
String var08A3BE0F715A4C53303FE59AFABEDC64_143829681 =             name.substring(dot + 1);
            var08A3BE0F715A4C53303FE59AFABEDC64_143829681.addTaint(taint);
            return var08A3BE0F715A4C53303FE59AFABEDC64_143829681;
        } //End block
String varB017984728AC60AD1F0BF8734F33F15C_583985181 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_583985181.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_583985181;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.637 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "C40A0EADDB42600F5C697773BBCB03AC")
    public ProtectionDomain getProtectionDomain() {
ProtectionDomain var540C13E9E156B687226421B24F2DF178_793541053 =         null;
        var540C13E9E156B687226421B24F2DF178_793541053.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_793541053;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.637 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "C099C7A78A5EE272F85381E456F1580B")
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
URL varBD7E03DCE503846452E4C60F282C5082_636864636 =             loader.getResource(resName);
            varBD7E03DCE503846452E4C60F282C5082_636864636.addTaint(taint);
            return varBD7E03DCE503846452E4C60F282C5082_636864636;
        } //End block
        else
        {
URL var5BCE521397D83220649EE68F62831709_334750405 =             ClassLoader.getSystemResource(resName);
            var5BCE521397D83220649EE68F62831709_334750405.addTaint(taint);
            return var5BCE521397D83220649EE68F62831709_334750405;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.646 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "041C4A1EA1C56CA85BCF1EBC8F140785")
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
InputStream var7C96068EED3C187BCC2775F895143208_1589909595 =             loader.getResourceAsStream(resName);
            var7C96068EED3C187BCC2775F895143208_1589909595.addTaint(taint);
            return var7C96068EED3C187BCC2775F895143208_1589909595;
        } //End block
        else
        {
InputStream var3F96CF621A1F3E1A4483E32D8C834982_760105313 =             ClassLoader.getSystemResourceAsStream(resName);
            var3F96CF621A1F3E1A4483E32D8C834982_760105313.addTaint(taint);
            return var3F96CF621A1F3E1A4483E32D8C834982_760105313;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "364898A44A7EE0A487CAEE8C20DDAA6B")
    public Object[] getSigners() {
Object[] var540C13E9E156B687226421B24F2DF178_1667293101 =         null;
        var540C13E9E156B687226421B24F2DF178_1667293101.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1667293101;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
    	Class ret = (Class)new Object();
    	return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "5042A01008EE01979D6C524A12E1324D")
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
TypeVariable<Class<T>>[] var88FA10730ED8D83D53A7F9A30F5F0311_251484601 =         parser.formalTypeParameters.clone();
        var88FA10730ED8D83D53A7F9A30F5F0311_251484601.addTaint(taint);
        return var88FA10730ED8D83D53A7F9A30F5F0311_251484601;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "DD26C3EFE53E746BBF0150135AD95244")
    public boolean isAnnotation() {
        final int ACC_ANNOTATION = 0x2000;
        int mod = getModifiers(this, true);
        boolean varA8ED21048ED38EB744FB2B250A06985D_1138922100 = ((mod & ACC_ANNOTATION) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789760194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789760194;
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "04AF7D4027BA793CC8B6E0B6EE44C791")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_958641712 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_958641712.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_958641712;
        } //End block
        if(isDeclaredAnnotationPresent(annotationType))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1135282376 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589763824 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589763824;
        } //End block
        if(annotationType.isDeclaredAnnotationPresent(Inherited.class))        
        {
for(Class<?> sup = getSuperclass();sup != null;sup = sup.getSuperclass())
            {
                if(sup.isDeclaredAnnotationPresent(annotationType))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_936317434 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955938768 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955938768;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_675128352 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637348275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637348275;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "DD63EEA97FB6F80FCE8B17685C12458B")
    public boolean isAnonymousClass() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172758331 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172758331;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "BBC3A8C80539B533D7EBCF7E23EFFAED")
    @DSModeled(DSC.SAFE)
    public boolean isArray() {
        boolean varD9EC80EBE7F6EA0E95A1BEB28155A254_408431719 = (getComponentType() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344134589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344134589;
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.647 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "47530057220D3DBD7FD8E1731E59904C")
    public boolean isAssignableFrom(Class<?> cls) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_6366830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_6366830;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.648 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "99DF7E42E57CBDCA6E517882B742F739")
    public boolean isEnum() {
        boolean var11C2EB902A1B8BD8CBB2D065CAECE303_1803550704 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1904516973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1904516973;
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.648 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "BB54BF4595166E24A3A21C0E41950A2D")
    public boolean isInstance(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745626549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745626549;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.651 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "7403A65F4E2967C39437730A72FEEB91")
    public boolean isInterface() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1972309842 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1972309842;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.651 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "5D9CE087E055D2F765FE5DFB95006A0C")
    @DSModeled(DSC.SAFE)
    public boolean isLocalClass() {
        boolean enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean var5A76BBF6F8D9D20B0C2DEE09C3D27C80_583155465 = (enclosed && !isAnonymousClass());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_973677403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_973677403;
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.651 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "A5AE12CFD2FAA602F5C0E4837056A273")
    @DSModeled(DSC.SAFE)
    public boolean isMemberClass() {
        boolean varC9096DA666816CCFBD0380B7F2B1C51A_1395550525 = (getDeclaringClass() != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499404624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499404624;
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.651 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "08680C65DA5E403C742978BBC6B7E2D8")
    public boolean isPrimitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1733259656 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1733259656;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.651 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "0E8E0B6876AF9B58B613AF32B34CDDF6")
    public boolean isSynthetic() {
        final int ACC_SYNTHETIC = 0x1000;
        int mod = getModifiers(this, true);
        boolean varA3ED4501470133DDF149A0E39C2DD31F_666800730 = ((mod & ACC_SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_275604264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_275604264;
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "817F95E6C8C06997062B26BD4E2EEF58")
    public T newInstance() throws InstantiationException, IllegalAccessException {
T varDABAB645F82D7DAC0FD72FFCF9059689_912412957 =         newInstanceImpl();
        varDABAB645F82D7DAC0FD72FFCF9059689_912412957.addTaint(taint);
        return varDABAB645F82D7DAC0FD72FFCF9059689_912412957;
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.766 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
    	T ret = (T)new Object();
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "469F8D9AE5FCC2ADC6D3AE301CEE963C")
    @Override
    public String toString() {
        if(isPrimitive())        
        {
String var3324D10DB87BCD465548F8DC9ECC57B8_946178748 =             getSimpleName();
            var3324D10DB87BCD465548F8DC9ECC57B8_946178748.addTaint(taint);
            return var3324D10DB87BCD465548F8DC9ECC57B8_946178748;
        } //End block
        else
        {
String var098FF1C1E251D1D541F5C2B99C1AEADF_411521045 =             (isInterface() ? "interface " : "class ") + getName();
            var098FF1C1E251D1D541F5C2B99C1AEADF_411521045.addTaint(taint);
            return var098FF1C1E251D1D541F5C2B99C1AEADF_411521045;
        } //End block
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "4A6CC5B9623A5F517F7A0E46369D8337")
    public Package getPackage() {
        ClassLoader loader = getClassLoader();
        if(loader != null)        
        {
            String name = getName();
            int dot = name.lastIndexOf('.');
Package var6194FAAADA178101667EADF15CA13617_1439984144 =             (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
            var6194FAAADA178101667EADF15CA13617_1439984144.addTaint(taint);
            return var6194FAAADA178101667EADF15CA13617_1439984144;
        } //End block
Package var540C13E9E156B687226421B24F2DF178_337558637 =         null;
        var540C13E9E156B687226421B24F2DF178_337558637.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_337558637;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "4866438F4E45146CB57377E525623BEF")
    public boolean desiredAssertionStatus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1414493066 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1414493066;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "910E7DFE96B4605E85B9C0C2ACD0BD70")
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        addTaint(clazz.getTaint());
        if(clazz.isAssignableFrom(this))        
        {
Class<? extends U> var02DA6192FD05C589213B6B2CDFCD6CAA_1691582090 =             (Class<? extends U>)this;
            var02DA6192FD05C589213B6B2CDFCD6CAA_1691582090.addTaint(taint);
            return var02DA6192FD05C589213B6B2CDFCD6CAA_1691582090;
        } //End block
        String actualClassName = this.getName();
        String desiredClassName = clazz.getName();
        ClassCastException var7B10A624B63DE93BBB3082FF2B62182B_1271522509 = new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        var7B10A624B63DE93BBB3082FF2B62182B_1271522509.addTaint(taint);
        throw var7B10A624B63DE93BBB3082FF2B62182B_1271522509;
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "521BA862A15172BE90D80E3869E14622")
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        addTaint(obj.getTaint());
        if(obj == null)        
        {
T var540C13E9E156B687226421B24F2DF178_2081061281 =             null;
            var540C13E9E156B687226421B24F2DF178_2081061281.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2081061281;
        } //End block
        else
        if(this.isInstance(obj))        
        {
T var60E33DF11B55697B4C1C6AE5825E84D3_1320749960 =             (T)obj;
            var60E33DF11B55697B4C1C6AE5825E84D3_1320749960.addTaint(taint);
            return var60E33DF11B55697B4C1C6AE5825E84D3_1320749960;
        } //End block
        String actualClassName = obj.getClass().getName();
        String desiredClassName = this.getName();
        ClassCastException var7B10A624B63DE93BBB3082FF2B62182B_1244987968 = new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        var7B10A624B63DE93BBB3082FF2B62182B_1244987968.addTaint(taint);
        throw var7B10A624B63DE93BBB3082FF2B62182B_1244987968;
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

    
    @DSModeled(DSC.SAFE)
    private static <T extends Object> T[] arraycopy(T[] result, T[] head, T[] tail) {
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);
        return result;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.652 -0400", hash_original_field = "07BD6CDA090731A5E103F68AD0EAE9F3", hash_generated_field = "A2E36971CC30DE91D1AF4E9C02F420A3")

    private static final long serialVersionUID = 3206093459760846163L;
}

