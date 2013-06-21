package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private transient String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.590 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
    @DSModeled(DSC.SAFE)
    private Class() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.591 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "17ABDCD624A0B1F52E1971055CC37C3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getSignatureAttribute() {
        Object[] annotation;
        annotation = getSignatureAnnotation();
        String var33705CFE2485E284459211E6CFE410F3_645065394 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation();
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.591 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "212F8016FCF15E66D1B128EA0493211D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] getSignatureAnnotation() {
        return (Object[])dsTaint.getTaint();
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

    
        static Class<?> classForName(String className, boolean initializeBoolean,
            ClassLoader classLoader) throws ClassNotFoundException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.591 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "6539F9D0915E301B8F6029A00EB81102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getClasses() {
        Class<?>[] varF323F5AC33396F798529A865EAA5E769_975758452 = (getFullListOfClasses(true));
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.592 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "69C39EC6B459A4BD110B1E99BFFD1AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A annotation;
        annotation = getDeclaredAnnotation(annotationType);
        {
            boolean varCCAC4519E608D500F2E0324B93A2EBDD_50174646 = (annotationType.isAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        annotation = sup.getDeclaredAnnotation(annotationType);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (A)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.592 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "65D952FA66D214928243B19AB10491BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[] getAnnotations() {
        HashMap<Class, Annotation> map;
        map = new HashMap<Class, Annotation>();
        Annotation[] declaredAnnotations;
        declaredAnnotations = getDeclaredAnnotations();
        {
            int i;
            i = declaredAnnotations.length-1;
            {
                map.put(declaredAnnotations[i].annotationType(), declaredAnnotations[i]);
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> sup;
            sup = getSuperclass();
            sup = sup.getSuperclass();
            {
                declaredAnnotations = sup.getDeclaredAnnotations();
                {
                    int i;
                    i = declaredAnnotations.length-1;
                    {
                        Class<?> clazz;
                        clazz = declaredAnnotations[i].annotationType();
                        {
                            boolean varA676920B63F28FB0E69E5ABA9D7FBE4E_324117379 = (!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class));
                            {
                                map.put(clazz, declaredAnnotations[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Collection<Annotation> coll;
        coll = map.values();
        Annotation[] var46E724AFB7A4EE8195F1E7BC790723B0_2098150461 = (coll.toArray(new Annotation[coll.size()]));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.592 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "91BDD9D2007F72546861E7A7A4A47514")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCanonicalName() {
        {
            boolean var86589E80A626B28167A55C52F3C71EC5_79188458 = (isLocalClass() || isAnonymousClass());
        } //End collapsed parenthetic
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_2126499537 = (isArray());
            {
                String name;
                name = getComponentType().getCanonicalName();
            } //End block
            {
                boolean var12FA39E2BB4D752CA1488728A8FD727B_1587868213 = (isMemberClass());
                {
                    String name;
                    name = getDeclaringClass().getCanonicalName();
                    {
                        String var12CEDE781B79C26F7B782E04D53937EB_302772479 = (name + "." + getSimpleName());
                    } //End block
                } //End block
                {
                    String varE91D84E962C134CCD8D6F2DAFE2EEBB3_1898326847 = (getName());
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.593 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "B3F2BE8D6CECC0238670584DB155431C")
    @DSModeled(DSC.BAN)
    public ClassLoader getClassLoader() {
        {
            boolean var0551DFDC1AC60955441420F1F8D72D3E_2004570897 = (this.isPrimitive());
        } //End collapsed parenthetic
        ClassLoader loader;
        loader = getClassLoaderImpl();
        {
            loader = BootClassLoader.getInstance();
        } //End block
        return (ClassLoader)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.593 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "951F091394432599937C3E340134EB1A")
    @DSModeled(DSC.BAN)
     ClassLoader getClassLoaderImpl() {
        ClassLoader loader;
        loader = getClassLoader(this);
        {
            Object var2A626D851C0F41D18615100368A1D6A5_399126466 = (BootClassLoader.getInstance());
        } //End flattened ternary
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
        private static ClassLoader getClassLoader(Class<?> clazz) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.593 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "AC77FFFD5DFF791931D1C2A6E27992E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> getComponentType() {
        return (Class<?>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.594 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "03933C680C2211E23530973B96DBA4AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        Constructor<T> var441BFD392D75D64CC93D6A80A8EE3EE8_999768423 = ((Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes));
        return (Constructor<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.597 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "66903F74F641BE3E4C7122222DFF7977")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        dsTaint.addTaint(publicOnly);
        dsTaint.addTaint(recursive);
        dsTaint.addTaint(name);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        {
            parameterTypes = EmptyArray.CLASS;
        } //End block
        {
            parameterTypes.iterator().hasNext();
            Class<?> c = parameterTypes.iterator().next();
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException("parameter type is null");
                } //End block
            } //End block
        } //End collapsed parenthetic
        Member result;
        result = getPublicConstructorOrMethodRecursive(name, parameterTypes);
        result = Class.getDeclaredConstructorOrMethod(this, name, parameterTypes);
        {
            boolean var2D792DB07DAD7428A386450E26B1B0F6_1672592392 = (result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            } //End block
        } //End collapsed parenthetic
        return (Member)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.602 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "46688C6DDE592E2F47F18C6331902281")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Member result;
                result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_1843682708 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    c.getInterfaces().iterator().hasNext();
                    Class<?> ifc = c.getInterfaces().iterator().next();
                    {
                        Member result;
                        result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_820978596 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Member)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.602 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "6FEEB0B26843AB92ABDEB74E98F5543B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Constructor<?>[] getConstructors() {
        Constructor<?>[] var3D7940C2FBAF0CE610FF17BB50B63359_209604218 = (getDeclaredConstructors(this, true));
        return (Constructor<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.602 -0400", hash_original_method = "2A0D770C788AFD3292AC02E319E3DDE7", hash_generated_method = "A96F9CBE77F2839351AB7488605CBA7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[] getDeclaredAnnotations() {
        return (Annotation[])dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.603 -0400", hash_original_method = "097083D90BBF2FCC58AC81DB8664E54F", hash_generated_method = "C1324AF72F63FDB46E133E778F428F9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        dsTaint.addTaint(annotationClass.dsTaint);
        return (A)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.603 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "A70A734F9281DC37BD2F768DA96F37EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        dsTaint.addTaint(annotationClass.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.603 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "493084C8E46C0FC593444FBBE96F7F6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getDeclaredClasses() {
        Class<?>[] varE1EDB47EF4CD4613D491242D585A7628_1130880199 = (getDeclaredClasses(this, false));
        return (Class<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.603 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "92E5FDCA57A1F31978CAD71C7A603699")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        dsTaint.addTaint(publicOnly);
        Class<?>[] result;
        result = getDeclaredClasses(this, publicOnly);
        Class<?> clazz;
        clazz = this.getSuperclass();
        {
            Class<?>[] temp;
            temp = getDeclaredClasses(clazz, publicOnly);
            {
                result = arraycopy(new Class[result.length + temp.length], result, temp);
            } //End block
            clazz = clazz.getSuperclass();
        } //End block
        return (Class<?>[])dsTaint.getTaint();
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

    
        private static Class<?>[] getDeclaredClasses(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.604 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "14AFFB990961BC91F55DE1013FF001D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        Constructor<T> var2F9441BA4A25BD0748487004FC73A397_378996771 = ((Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes));
        return (Constructor<T>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.604 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "9EA78104824A8D9F2D219C65FBB723D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Constructor<?>[] getDeclaredConstructors() {
        Constructor<?>[] varF6A9CCA0046B4156A4A84DC70FF14789_682794386 = (getDeclaredConstructors(this, false));
        return (Constructor<?>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, false);
    }

    
        private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.604 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "1BB257366B72882DA5D0C4C7F18B7C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getDeclaredField(this, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        return (Field)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.604 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "C4537E825638423E55F763E7A11D0C08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Field[] getDeclaredFields() {
        Field[] varC340694FFC1935059EA20B8B8BB260E1_788492971 = (getDeclaredFields(this, false));
        return (Field[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredFields(this, false);
    }

    
        static Field[] getDeclaredFields(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Field getDeclaredField(Class<?> clazz, String name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.605 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "5B451826CDFA6DB4F354A945B93D0174")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        Member member;
        member = getConstructorOrMethod(name, false, false, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.605 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "11D67D89D2307C9B29242C7FB423AB72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Method[] getDeclaredMethods() {
        Method[] varE7A15E724FF5F13FD06D7A9EEBD078B3_536686743 = (getDeclaredMethods(this, false));
        return (Method[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredMethods(this, false);
    }

    
        static Method[] getDeclaredMethods(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Member getDeclaredConstructorOrMethod(Class clazz, String name, Class[] args) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.605 -0400", hash_original_method = "67DCCE022B38EF56E621E9F7C3410002", hash_generated_method = "3B1F80132D08E4E11E98EE37D848DEBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> getDeclaringClass() {
        return (Class<?>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.605 -0400", hash_original_method = "B183618DCECD1DBBC6B77A8041AAB5FF", hash_generated_method = "8E6D3D5127720D2C270C22FED12DFBC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> getEnclosingClass() {
        return (Class<?>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.605 -0400", hash_original_method = "66CD711920ADA841CC04EC44C476AA92", hash_generated_method = "45ED5A2CAA56300CB69F4A82377698B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Constructor<?> getEnclosingConstructor() {
        return (Constructor<?>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.606 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "2BB1B286D5EEE16C0B90BA03427E5432")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Method getEnclosingMethod() {
        return (Method)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.606 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "0D06F6AF580A34187F4249457813FAB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
        {
            boolean var6E8389F5338F7F2F41F0B21F08A19A46_1713053844 = (!isEnum());
        } //End collapsed parenthetic
        T[] varBEA67759CE6235FB29526707FE622C4A_2016540144 = ((T[]) Enum.getSharedConstants((Class) this).clone());
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.606 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "7FB970895264DABC8D70D1CE3CA14BD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Field getField(String name) throws NoSuchFieldException {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getPublicFieldRecursive(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        return (Field)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.611 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "566CFBE35290840BD30A572C5F02A33A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Field getPublicFieldRecursive(String name) {
        dsTaint.addTaint(name);
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Field result;
                result = Class.getDeclaredField(c, name);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_1726398912 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    Class<?> ifc = c.getInterfaces()[0];
                    {
                        Field result;
                        result = ifc.getPublicFieldRecursive(name);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_1543085127 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Field)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.611 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "6B02A1EAC745C522A96EC765E8F6118A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Field[] getFields() {
        List<Field> fields;
        fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        Field[] var6ECB636C3016A4FDCF529F96C56F9C56_748697395 = (fields.toArray(new Field[fields.size()]));
        return (Field[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.616 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "B41416980E052E2CD88FC156CDD1AEC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getPublicFieldsRecursive(List<Field> result) {
        dsTaint.addTaint(result.dsTaint);
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    Field field = Class.getDeclaredFields(c, true)[0];
                    {
                        result.add(field);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    Class<?> ifc = c.getInterfaces()[0];
                    {
                        ifc.getPublicFieldsRecursive(result);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.617 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "42A2DE757EC4CEAFD9BFAEBB2EC3FA97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type[] getGenericInterfaces() {
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        Type[] varA3A0D34D0D1EA5BC59FEF49159749968_460742264 = (Types.getClonedTypeArray(parser.interfaceTypes));
        return (Type[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.617 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "47CE8817F702A250DF7336BF5B8D9166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericSuperclass() {
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        Type var8787B56A32A77304EFCE2AA14CF45FE7_386461838 = (Types.getType(parser.superclassType));
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getType(parser.superclassType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.617 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "B42DBD8F87738EDBE70D559BAC5DD35E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?>[] getInterfaces() {
        return (Class<?>[])dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.618 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "1EE92CB925EAEF8343DF70C7C37C1128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(parameterTypes[0].dsTaint);
        Member member;
        member = getConstructorOrMethod(name, true, true, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        return (Method)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.618 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "78C0C57A7C3FA378C098940E28AF0077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Method[] getMethods() {
        List<Method> methods;
        methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        Method[] var7F971B816AD7D69C609549AE6B71C6FC_811818079 = (methods.toArray(new Method[methods.size()]));
        return (Method[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.623 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "DC332BF093C14FA4A8BBC73908135B29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getPublicMethodsRecursive(List<Method> result) {
        dsTaint.addTaint(result.dsTaint);
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    Method method = Class.getDeclaredMethods(c, true)[0];
                    {
                        result.add(method);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                {
                    Class<?> ifc = c.getInterfaces()[0];
                    {
                        ifc.getPublicMethodsRecursive(result);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.624 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "446EDB38F9C2175465F2EB48EAE7DFB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int varE142A374AC768972DB237647A19C42B9_1495070646 = (getModifiers(this, false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
        private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.624 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "634462BFDE6D320AE6A2C37073546163")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getName() {
        String result;
        result = name;
        {
            Object varAB1F9F489A8A4B724E80BC90A3C70523_1373713286 = ((name = getNameNative()));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = name;
        //return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.624 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "F10703EEC709BD4A1DDB738B1A363FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getNameNative() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.625 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "DEC770E8063D045E835C21961B4E3D3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSimpleName() {
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_1772202732 = (isArray());
            {
                String var3425C0EE45F8D8EEA4CE63F4DC38FF5D_1537875785 = (getComponentType().getSimpleName() + "[]");
            } //End block
        } //End collapsed parenthetic
        String name;
        name = getName();
        {
            boolean var6C53121FEDEDDD465179821F892D8557_1490066832 = (isAnonymousClass());
        } //End collapsed parenthetic
        {
            boolean var1710CE004786B2172BA7D8655CC10CDC_317927537 = (isMemberClass() || isLocalClass());
            {
                String var9613BFEAB95C16A2F58E7B2A42DC0B1E_969334210 = (getInnerClassName());
            } //End block
        } //End collapsed parenthetic
        int dot;
        dot = name.lastIndexOf('.');
        {
            String varD4D40A6CDC3697423136C30A1478D84F_14378624 = (name.substring(dot + 1));
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.625 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "BBCD94D20B293E5F55201209721A9681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getInnerClassName() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.625 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "D87AD4B23D2F8D50EC175BD51F6EDE11")
    @DSModeled(DSC.SAFE)
    public ProtectionDomain getProtectionDomain() {
        return (ProtectionDomain)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.626 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "8D8CEDAEB329CAC8EBCFA20145F185DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL getResource(String resName) {
        dsTaint.addTaint(resName);
        {
            boolean var718D9075DC8A20618F0410A875A157F6_2115101643 = (resName.startsWith("/"));
            {
                resName = resName.substring(1);
            } //End block
            {
                String pkg;
                pkg = getName();
                int dot;
                dot = pkg.lastIndexOf('.');
                {
                    pkg = pkg.substring(0, dot).replace('.', '/');
                } //End block
                {
                    pkg = "";
                } //End block
                resName = pkg + "/" + resName;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader;
        loader = getClassLoader();
        {
            URL varF21277C48D60F575837036CF5E170B12_262380055 = (loader.getResource(resName));
        } //End block
        {
            URL varB72E3AA1285ABC72D3B34A6B26BA6DBD_59761225 = (ClassLoader.getSystemResource(resName));
        } //End block
        return (URL)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.626 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "DF5B0CB149A694D494DCB0F7E2BF5CC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getResourceAsStream(String resName) {
        dsTaint.addTaint(resName);
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1795517513 = (resName.startsWith("/"));
            {
                resName = resName.substring(1);
            } //End block
            {
                String pkg;
                pkg = getName();
                int dot;
                dot = pkg.lastIndexOf('.');
                {
                    pkg = pkg.substring(0, dot).replace('.', '/');
                } //End block
                {
                    pkg = "";
                } //End block
                resName = pkg + "/" + resName;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader;
        loader = getClassLoader();
        {
            InputStream varE79EE660DA8348F0AC447861FE369C00_844181755 = (loader.getResourceAsStream(resName));
        } //End block
        {
            InputStream var802D299BA50825952D3CD40FC453467A_2143605194 = (ClassLoader.getSystemResourceAsStream(resName));
        } //End block
        return (InputStream)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.627 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "E171DCF1C7C582875260CDD3234FD047")
    @DSModeled(DSC.SAFE)
    public Object[] getSigners() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.628 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6CE533BDB8C398E4EA603859654ABC5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<? super T> getSuperclass() {
        return (Class<? super T>)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.628 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "426D92F7D6CA03D21E5118BEE1EAD14C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        TypeVariable<Class<T>>[] var20D0C92BB3F4AE0C52C8B71FE36CCC1C_1701785018 = (parser.formalTypeParameters.clone());
        return (TypeVariable<Class<T>>[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.629 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "E90590FB1BEC05DC86CE6016E52D1153")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAnnotation() {
        int ACC_ANNOTATION;
        ACC_ANNOTATION = 0x2000;
        int mod;
        mod = getModifiers(this, true);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.629 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "BF5C3EC7845618B47E01B37EC7FA5566")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        {
            boolean varEEBC1240FDA40BFAEAACBFB89D6281AF_2106916453 = (isDeclaredAnnotationPresent(annotationType));
        } //End collapsed parenthetic
        {
            boolean var29D87B80E530DF4C50E30AC2EB8C6CFB_1965050865 = (annotationType.isDeclaredAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        {
                            boolean var9601F0FC9454A2DF6984664914F9F810_1767496591 = (sup.isDeclaredAnnotationPresent(annotationType));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.629 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "63EEC030E57880B195F0E374DE98937D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAnonymousClass() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.629 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "647EE8847F4D4826B81C0A2BB6577259")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isArray() {
        boolean var9F61AD98F70F910DD07C7CB078A688AE_131581708 = (getComponentType() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "33FB8BAA12AC102F66DFA55F8FBAFE73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAssignableFrom(Class<?> cls) {
        dsTaint.addTaint(cls.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "405E44CFF23A5AAE92026DBD3F36380D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnum() {
        boolean var12ECA463BB0095D0882BCBC30CA80AD1_847577575 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "627A958D01F25053AC782C96E61B6C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInstance(Object object) {
        dsTaint.addTaint(object.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "AC0150E7866D027C68A0A462BF8BF83D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInterface() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "FD66C89A1DF227F33322CBA3A6698641")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLocalClass() {
        boolean enclosed;
        enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean varAA6243A3A6D5A82E5F77D3D9BE30067E_1981376664 = (enclosed && !isAnonymousClass());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.630 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "BF2F3250B92390640C7467F78E1F7FBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isMemberClass() {
        boolean varD300F2653B6225A244F27A67DCB40753_1264173638 = (getDeclaringClass() != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "F7238C4411B43BEAA55C91C7EFE06F63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrimitive() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "EC3C82A89EAA278A6C02D06DD33D9805")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSynthetic() {
        int ACC_SYNTHETIC;
        ACC_SYNTHETIC = 0x1000;
        int mod;
        mod = getModifiers(this, true);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "4C1BBF5433CE90CC456C9581DA34BE3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T newInstance() throws InstantiationException, IllegalAccessException {
        T var6B0AF93340035BE4719AAF7B81234ACF_970866485 = (newInstanceImpl());
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "4E7BDE936A156B31C4654D2D2CA2863B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
        return (T)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "98752FEDF8F284C5C195615C8AAD1217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_1997556434 = (isPrimitive());
            {
                String var01879E8AA4D55D19DB236152CD3C9E64_751334325 = (getSimpleName());
            } //End block
            {
                String varD6D9AA0F56AA5E586233E7D1D841854F_334127647 = ((isInterface() ? "interface " : "class ") + getName()); //DSFIXME:  CODE0008: Nested ternary operator in expression
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.631 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "3E7370958D8B5EA70C2100968C9B67CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Package getPackage() {
        ClassLoader loader;
        loader = getClassLoader();
        {
            String name;
            name = getName();
            int dot;
            dot = name.lastIndexOf('.');
            Package var5BBC31560BD38AEC7F2ADA0B162BFC8B_1514728979 = ((dot != -1 ? loader.getPackage(name.substring(0, dot)) : null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return (Package)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.632 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "4FBCE2E5E30D51151BC5C1AC7BCA038F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean desiredAssertionStatus() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.632 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "0A33D46B6D026DA2D4695652B9937957")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        dsTaint.addTaint(clazz.dsTaint);
        {
            boolean varE62FF236193AD694C6D580397D58A801_298946190 = (clazz.isAssignableFrom(this));
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = this.getName();
        String desiredClassName;
        desiredClassName = clazz.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        return (Class<? extends U>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.632 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "5BD5C18486B9EBF4474BC41E2B98E64E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var907E47EFDDB74A366DA8DC9B84DCA605_1033726772 = (this.isInstance(obj));
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = obj.getClass().getName();
        String desiredClassName;
        desiredClassName = this.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        return (T)dsTaint.getTaint();
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

    
    private static final long serialVersionUID = 3206093459760846163L;
}

