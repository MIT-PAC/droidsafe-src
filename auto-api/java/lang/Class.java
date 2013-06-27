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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.462 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.462 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
    private  Class() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.469 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "1018F0FA29D2C5582803688AF1218AC8")
    private String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1245095353 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_257799292 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1245095353 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_257799292 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_838532042; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_838532042 = varB4EAC82CA7396A68D541C85D26508E83_1245095353;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_838532042 = varB4EAC82CA7396A68D541C85D26508E83_257799292;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_838532042.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_838532042;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation();
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.469 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "580560D142C0CD8EEA5AC831F856A095")
    private Object[] getSignatureAnnotation() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.477 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "F2DF52A7CBCBAF9D4FAC54A6CCE2AA2A")
    public Class<?>[] getClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_846191994 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_846191994 = getFullListOfClasses(true);
        varB4EAC82CA7396A68D541C85D26508E83_846191994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846191994;
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.482 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "3DCB4C623ECCE28AF5A9B922CEAF4DDA")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_424421295 = null; //Variable for return #1
        A varB4EAC82CA7396A68D541C85D26508E83_605972274 = null; //Variable for return #2
        A varB4EAC82CA7396A68D541C85D26508E83_592219156 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A annotation;
        annotation = getDeclaredAnnotation(annotationType);
        {
            varB4EAC82CA7396A68D541C85D26508E83_424421295 = annotation;
        } //End block
        {
            boolean varCCAC4519E608D500F2E0324B93A2EBDD_2024475707 = (annotationType.isAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        annotation = sup.getDeclaredAnnotation(annotationType);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_605972274 = annotation;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_592219156 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_1650777616; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1650777616 = varB4EAC82CA7396A68D541C85D26508E83_424421295;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1650777616 = varB4EAC82CA7396A68D541C85D26508E83_605972274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1650777616 = varB4EAC82CA7396A68D541C85D26508E83_592219156;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1650777616.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1650777616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.492 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "F1A5EFC737E008258BA094C6C128CEB2")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1747301213 = null; //Variable for return #1
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
                            boolean varA676920B63F28FB0E69E5ABA9D7FBE4E_1181986816 = (!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class));
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
        varB4EAC82CA7396A68D541C85D26508E83_1747301213 = coll.toArray(new Annotation[coll.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1747301213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1747301213;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.503 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "EF8E6A2CBBAC1A921FAB839B4EE0FC3A")
    public String getCanonicalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_555603119 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1464873632 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2104558269 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_340184480 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1588533471 = null; //Variable for return #5
        {
            boolean var86589E80A626B28167A55C52F3C71EC5_1946091025 = (isLocalClass() || isAnonymousClass());
            varB4EAC82CA7396A68D541C85D26508E83_555603119 = null;
        } //End collapsed parenthetic
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_30977633 = (isArray());
            {
                String name;
                name = getComponentType().getCanonicalName();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1464873632 = name + "[]";
                } //End block
            } //End block
            {
                boolean var12FA39E2BB4D752CA1488728A8FD727B_343067285 = (isMemberClass());
                {
                    String name;
                    name = getDeclaringClass().getCanonicalName();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2104558269 = name + "." + getSimpleName();
                    } //End block
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_340184480 = getName();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1588533471 = null;
        String varA7E53CE21691AB073D9660D615818899_119587287; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_119587287 = varB4EAC82CA7396A68D541C85D26508E83_555603119;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_119587287 = varB4EAC82CA7396A68D541C85D26508E83_1464873632;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_119587287 = varB4EAC82CA7396A68D541C85D26508E83_2104558269;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_119587287 = varB4EAC82CA7396A68D541C85D26508E83_340184480;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_119587287 = varB4EAC82CA7396A68D541C85D26508E83_1588533471;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_119587287.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_119587287;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.519 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "6A54A95465FDD74678D24118A34D8EC8")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_622241176 = null; //Variable for return #1
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1066677896 = null; //Variable for return #2
        {
            boolean var0551DFDC1AC60955441420F1F8D72D3E_1843419576 = (this.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_622241176 = null;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader;
        loader = getClassLoaderImpl();
        {
            loader = BootClassLoader.getInstance();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1066677896 = loader;
        ClassLoader varA7E53CE21691AB073D9660D615818899_1923570808; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1923570808 = varB4EAC82CA7396A68D541C85D26508E83_622241176;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1923570808 = varB4EAC82CA7396A68D541C85D26508E83_1066677896;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1923570808.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1923570808;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.519 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "A83B730300728C43D6183209749545CD")
     ClassLoader getClassLoaderImpl() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_943007614 = null; //Variable for return #1
        ClassLoader loader;
        loader = getClassLoader(this);
        varB4EAC82CA7396A68D541C85D26508E83_943007614 = loader == null ? BootClassLoader.getInstance() : loader;
        varB4EAC82CA7396A68D541C85D26508E83_943007614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943007614;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
        private static ClassLoader getClassLoader(Class<?> clazz) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.520 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "CDEED6F065A507A7FECB927A85CD4D66")
    public Class<?> getComponentType() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.520 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "38D85C41E18721E53A94DD55BAE8C0A9")
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_138230455 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_138230455 = (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_138230455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138230455;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.571 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "5458AD72916E5B3E9855CD7066012DF4")
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        Member varB4EAC82CA7396A68D541C85D26508E83_1010944964 = null; //Variable for return #1
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
            boolean var2D792DB07DAD7428A386450E26B1B0F6_1737632046 = (result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1010944964 = result;
        addTaint(name.getTaint());
        addTaint(recursive);
        addTaint(publicOnly);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1010944964.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010944964;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.621 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "00191F3CA7F950037A1692212852F3FB")
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        Member varB4EAC82CA7396A68D541C85D26508E83_1351239318 = null; //Variable for return #1
        Member varB4EAC82CA7396A68D541C85D26508E83_1029104998 = null; //Variable for return #2
        Member varB4EAC82CA7396A68D541C85D26508E83_365774610 = null; //Variable for return #3
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Member result;
                result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_555762284 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1351239318 = result;
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
                    c.getInterfaces().iterator().hasNext();
                    Class<?> ifc = c.getInterfaces().iterator().next();
                    {
                        Member result;
                        result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_1955931327 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1029104998 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_365774610 = null;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        Member varA7E53CE21691AB073D9660D615818899_1685240671; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1685240671 = varB4EAC82CA7396A68D541C85D26508E83_1351239318;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1685240671 = varB4EAC82CA7396A68D541C85D26508E83_1029104998;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1685240671 = varB4EAC82CA7396A68D541C85D26508E83_365774610;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1685240671.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1685240671;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.623 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "132DE1819610D1934D3FB55499700B9F")
    public Constructor<?>[] getConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_1210249887 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1210249887 = getDeclaredConstructors(this, true);
        varB4EAC82CA7396A68D541C85D26508E83_1210249887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210249887;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.623 -0400", hash_original_method = "2A0D770C788AFD3292AC02E319E3DDE7", hash_generated_method = "DB9C61E181111C55768DF3409E22B2FA")
    public Annotation[] getDeclaredAnnotations() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.624 -0400", hash_original_method = "097083D90BBF2FCC58AC81DB8664E54F", hash_generated_method = "33C06C0DC63918D788913C928E9A0C55")
    private <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.629 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "6186B9FCAED9EEDA2FBE176B13F041EE")
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225204449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225204449;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.633 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "CAE52282D82510CFFB107FF25498EBC1")
    public Class<?>[] getDeclaredClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_97313464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97313464 = getDeclaredClasses(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_97313464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97313464;
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.637 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "EF0F6605E1470625A78AA10057FFCCCD")
    private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_75101495 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_75101495 = result;
        addTaint(publicOnly);
        varB4EAC82CA7396A68D541C85D26508E83_75101495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75101495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.638 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "4B55B19BEF5142CF2B4E41FD13041AFB")
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_1859865794 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1859865794 = (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1859865794.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1859865794;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.638 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "38D61BDF0D415562811F58F1D150BA70")
    public Constructor<?>[] getDeclaredConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_2048554047 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2048554047 = getDeclaredConstructors(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_2048554047.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048554047;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, false);
    }

    
        private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.643 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "B8CCD4CB7DAD66B42853D0AB83CEAA32")
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_582479192 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getDeclaredField(this, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_582479192 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_582479192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582479192;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.650 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "1437B85F6CF91264D4D9CC5392874E26")
    public Field[] getDeclaredFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_1539815614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1539815614 = getDeclaredFields(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1539815614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539815614;
        // ---------- Original Method ----------
        //return getDeclaredFields(this, false);
    }

    
        static Field[] getDeclaredFields(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Field getDeclaredField(Class<?> clazz, String name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.660 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "83083A86EAD553221D2E409AE5B7FE88")
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_27730337 = null; //Variable for return #1
        Member member;
        member = getConstructorOrMethod(name, false, false, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_27730337 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_27730337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_27730337;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.660 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "3F5E60A06B50EEF7F2556484397190E8")
    public Method[] getDeclaredMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_1132588584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1132588584 = getDeclaredMethods(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1132588584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1132588584;
        // ---------- Original Method ----------
        //return getDeclaredMethods(this, false);
    }

    
        static Method[] getDeclaredMethods(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Member getDeclaredConstructorOrMethod(Class clazz, String name, Class[] args) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.661 -0400", hash_original_method = "67DCCE022B38EF56E621E9F7C3410002", hash_generated_method = "A08735CEB9F08341039B8C54A1BD5E61")
    public Class<?> getDeclaringClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.661 -0400", hash_original_method = "B183618DCECD1DBBC6B77A8041AAB5FF", hash_generated_method = "E19B04C40918C59F801E144F365A783E")
    public Class<?> getEnclosingClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.662 -0400", hash_original_method = "66CD711920ADA841CC04EC44C476AA92", hash_generated_method = "E9EFFA224CF0890C33C432913B5CDC4A")
    public Constructor<?> getEnclosingConstructor() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.662 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "42F609F6A3577ECAA8EE5F0164C83C69")
    public Method getEnclosingMethod() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.666 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "C966503F03DC4A8ED8382FC739A8AE2F")
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
        T[] varB4EAC82CA7396A68D541C85D26508E83_298257550 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_1217972478 = null; //Variable for return #2
        {
            boolean var6E8389F5338F7F2F41F0B21F08A19A46_1077997663 = (!isEnum());
            {
                varB4EAC82CA7396A68D541C85D26508E83_298257550 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1217972478 = (T[]) Enum.getSharedConstants((Class) this).clone();
        T[] varA7E53CE21691AB073D9660D615818899_401729249; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_401729249 = varB4EAC82CA7396A68D541C85D26508E83_298257550;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_401729249 = varB4EAC82CA7396A68D541C85D26508E83_1217972478;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_401729249.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_401729249;
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.676 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "6137CAE8C897B636B0709F90BB69D2BB")
    public Field getField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_1940235974 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getPublicFieldRecursive(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1940235974 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1940235974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1940235974;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.722 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "42A55CC1BAE3658441D482FD3A196AAC")
    private Field getPublicFieldRecursive(String name) {
        Field varB4EAC82CA7396A68D541C85D26508E83_1688133073 = null; //Variable for return #1
        Field varB4EAC82CA7396A68D541C85D26508E83_1023809703 = null; //Variable for return #2
        Field varB4EAC82CA7396A68D541C85D26508E83_2006813310 = null; //Variable for return #3
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Field result;
                result = Class.getDeclaredField(c, name);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_2032921105 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1688133073 = result;
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
                        Field result;
                        result = ifc.getPublicFieldRecursive(name);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_2037491583 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1023809703 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2006813310 = null;
        addTaint(name.getTaint());
        Field varA7E53CE21691AB073D9660D615818899_423012394; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_423012394 = varB4EAC82CA7396A68D541C85D26508E83_1688133073;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_423012394 = varB4EAC82CA7396A68D541C85D26508E83_1023809703;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_423012394 = varB4EAC82CA7396A68D541C85D26508E83_2006813310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_423012394.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_423012394;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.722 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "A645012C14CB8DDEA3D21570AA24F35C")
    public Field[] getFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_1229284294 = null; //Variable for return #1
        List<Field> fields;
        fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        varB4EAC82CA7396A68D541C85D26508E83_1229284294 = fields.toArray(new Field[fields.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1229284294.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1229284294;
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.786 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "BD1276EBF58CD50457160465211412AC")
    private void getPublicFieldsRecursive(List<Field> result) {
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
        addTaint(result.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.797 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "27188C15DE1A9C8A61CFFEE43FB6BCB9")
    public Type[] getGenericInterfaces() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1173177591 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1173177591 = Types.getClonedTypeArray(parser.interfaceTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1173177591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1173177591;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.798 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "D32DC10506B82420CDAC850C3516B67D")
    public Type getGenericSuperclass() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1515729003 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1515729003 = Types.getType(parser.superclassType);
        varB4EAC82CA7396A68D541C85D26508E83_1515729003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1515729003;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getType(parser.superclassType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.798 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "2692A665379A2F86FF3326F5F5EB1B7B")
    public Class<?>[] getInterfaces() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.799 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "F3DDBE5B7C554A86FDD87C53F34203DD")
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_1367690458 = null; //Variable for return #1
        Member member;
        member = getConstructorOrMethod(name, true, true, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1367690458 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1367690458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367690458;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.806 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "618413ABBCF0C5E60B8213E58EE70521")
    public Method[] getMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_1437091589 = null; //Variable for return #1
        List<Method> methods;
        methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_1437091589 = methods.toArray(new Method[methods.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1437091589.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1437091589;
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.878 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "AD8116DAA5E68CA3B780C155EAA4FAD3")
    private void getPublicMethodsRecursive(List<Method> result) {
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
        addTaint(result.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.878 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "AD4872BB86A0463588DD5F832910B9FE")
    public int getModifiers() {
        int varE142A374AC768972DB237647A19C42B9_1891741035 = (getModifiers(this, false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797672691 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797672691;
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
        private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.880 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "120A2D7A4EBCABCB4CC868FE30218156")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_541829003 = null; //Variable for return #1
        String result;
        result = name;
        varB4EAC82CA7396A68D541C85D26508E83_541829003 = (result == null) ? (name = getNameNative()) : result;
        varB4EAC82CA7396A68D541C85D26508E83_541829003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541829003;
        // ---------- Original Method ----------
        //String result = name;
        //return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.880 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "D2A1F2570A688E342CB66374B5D563FA")
    private String getNameNative() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.891 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "E08457D1052E70C3E38F546245F61F4A")
    public String getSimpleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1005185203 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_378794731 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_437797482 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_317413192 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1292721023 = null; //Variable for return #5
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_1316712467 = (isArray());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1005185203 = getComponentType().getSimpleName() + "[]";
            } //End block
        } //End collapsed parenthetic
        String name;
        name = getName();
        {
            boolean var6C53121FEDEDDD465179821F892D8557_1281911126 = (isAnonymousClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_378794731 = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1710CE004786B2172BA7D8655CC10CDC_1882255056 = (isMemberClass() || isLocalClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_437797482 = getInnerClassName();
            } //End block
        } //End collapsed parenthetic
        int dot;
        dot = name.lastIndexOf('.');
        {
            varB4EAC82CA7396A68D541C85D26508E83_317413192 = name.substring(dot + 1);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1292721023 = name;
        String varA7E53CE21691AB073D9660D615818899_436365444; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_436365444 = varB4EAC82CA7396A68D541C85D26508E83_1005185203;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_436365444 = varB4EAC82CA7396A68D541C85D26508E83_378794731;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_436365444 = varB4EAC82CA7396A68D541C85D26508E83_437797482;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_436365444 = varB4EAC82CA7396A68D541C85D26508E83_317413192;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_436365444 = varB4EAC82CA7396A68D541C85D26508E83_1292721023;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_436365444.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_436365444;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.892 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "E15F8A7CFFBAA6A8E91B4004366ED98B")
    private String getInnerClassName() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.892 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "2594BEF49B229C026BBF271C51C41BB4")
    public ProtectionDomain getProtectionDomain() {
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_1088545961 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1088545961 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1088545961.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088545961;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.896 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "91EC78BD4DCC285B68EBF31DC0908CE6")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_215683243 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_727446998 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_520539254 = (resName.startsWith("/"));
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
            varB4EAC82CA7396A68D541C85D26508E83_215683243 = loader.getResource(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_727446998 = ClassLoader.getSystemResource(resName);
        } //End block
        addTaint(resName.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_551119714; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_551119714 = varB4EAC82CA7396A68D541C85D26508E83_215683243;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_551119714 = varB4EAC82CA7396A68D541C85D26508E83_727446998;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_551119714.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_551119714;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.904 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "7E9281AE64F4ACE66D9EA7FFFF43275A")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_575970426 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_436809791 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1428526143 = (resName.startsWith("/"));
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
            varB4EAC82CA7396A68D541C85D26508E83_575970426 = loader.getResourceAsStream(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_436809791 = ClassLoader.getSystemResourceAsStream(resName);
        } //End block
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1178010591; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1178010591 = varB4EAC82CA7396A68D541C85D26508E83_575970426;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1178010591 = varB4EAC82CA7396A68D541C85D26508E83_436809791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1178010591.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1178010591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.911 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "70E632FEDFF5107882B5A2730DFF32FC")
    public Object[] getSigners() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_353466899 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_353466899 = null;
        varB4EAC82CA7396A68D541C85D26508E83_353466899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_353466899;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.915 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.916 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "BD80D9719B2F849CBE70B4D604A31FE7")
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        TypeVariable<Class<T>>[] varB4EAC82CA7396A68D541C85D26508E83_894291555 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_894291555 = parser.formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_894291555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894291555;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.924 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "B1FA9B757E78A7886F11DA8678BE91D6")
    public boolean isAnnotation() {
        int ACC_ANNOTATION;
        ACC_ANNOTATION = 0x2000;
        int mod;
        mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621024010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_621024010;
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.925 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "27C94FE5C53857E1B68C4717D85B4D01")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        {
            boolean varEEBC1240FDA40BFAEAACBFB89D6281AF_871695181 = (isDeclaredAnnotationPresent(annotationType));
        } //End collapsed parenthetic
        {
            boolean var29D87B80E530DF4C50E30AC2EB8C6CFB_1093974824 = (annotationType.isDeclaredAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        {
                            boolean var9601F0FC9454A2DF6984664914F9F810_62957823 = (sup.isDeclaredAnnotationPresent(annotationType));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_132839488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_132839488;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.926 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "4CCCDBAACBF2765CB97D066BD1A9BDA8")
    public boolean isAnonymousClass() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1559313518 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1559313518;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.926 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "431609CC1C441F5B0D8563704951A99F")
    public boolean isArray() {
        boolean var9F61AD98F70F910DD07C7CB078A688AE_50834720 = (getComponentType() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1004723515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1004723515;
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.926 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "5CD5DD6A790B54833C3200D607C0EF92")
    public boolean isAssignableFrom(Class<?> cls) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36577213 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_36577213;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.926 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "3FF264C4818B0C438A4A4F4A655F175D")
    public boolean isEnum() {
        boolean var12ECA463BB0095D0882BCBC30CA80AD1_644473070 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116910994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116910994;
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.927 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "BA663A9DA92E79D37BF6DF82DD463AA9")
    public boolean isInstance(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359025834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359025834;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.927 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "E2ADC63AFCFFD853B749B4402FD1C1CE")
    public boolean isInterface() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598987471 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598987471;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.927 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "BACD3E1E57CF7815C1F6C455AD1D357F")
    public boolean isLocalClass() {
        boolean enclosed;
        enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean varAA6243A3A6D5A82E5F77D3D9BE30067E_450477271 = (enclosed && !isAnonymousClass());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1710566220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1710566220;
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.928 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "8F7EA6208D68CED4DED5493C5FECAF78")
    public boolean isMemberClass() {
        boolean varD300F2653B6225A244F27A67DCB40753_2028765946 = (getDeclaringClass() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263552218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_263552218;
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.938 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "69F525CDE7CD9B7B374D59B8FB163DB0")
    public boolean isPrimitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74374001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74374001;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.939 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "8A60251868BDC2B7AA1F8325B6C99BCF")
    public boolean isSynthetic() {
        int ACC_SYNTHETIC;
        ACC_SYNTHETIC = 0x1000;
        int mod;
        mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1607949514 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1607949514;
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.939 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "A5B00FF3C8185CDBE4D8708EF49A9BF9")
    public T newInstance() throws InstantiationException, IllegalAccessException {
        T varB4EAC82CA7396A68D541C85D26508E83_1843206226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1843206226 = newInstanceImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1843206226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1843206226;
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.939 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.944 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "EA656AC42725B00B8738F2B7B0AE42C3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1925258482 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_657630217 = null; //Variable for return #2
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_487088781 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1925258482 = getSimpleName();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_657630217 = (isInterface() ? "interface " : "class ") + getName();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_105642645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_105642645 = varB4EAC82CA7396A68D541C85D26508E83_1925258482;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_105642645 = varB4EAC82CA7396A68D541C85D26508E83_657630217;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_105642645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_105642645;
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.945 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "A81DD4769A987AD74DA57427863EB72C")
    public Package getPackage() {
        Package varB4EAC82CA7396A68D541C85D26508E83_317486006 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_1015805102 = null; //Variable for return #2
        ClassLoader loader;
        loader = getClassLoader();
        {
            String name;
            name = getName();
            int dot;
            dot = name.lastIndexOf('.');
            varB4EAC82CA7396A68D541C85D26508E83_317486006 = (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1015805102 = null;
        Package varA7E53CE21691AB073D9660D615818899_1793719735; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1793719735 = varB4EAC82CA7396A68D541C85D26508E83_317486006;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1793719735 = varB4EAC82CA7396A68D541C85D26508E83_1015805102;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1793719735.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1793719735;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.945 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "E54A6D79D06374032A250D780539AE50")
    public boolean desiredAssertionStatus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_358150022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_358150022;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.953 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "A7871F0839CAD1A2CD3E2F1615DAF849")
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        Class<? extends U> varB4EAC82CA7396A68D541C85D26508E83_1048302257 = null; //Variable for return #1
        {
            boolean varE62FF236193AD694C6D580397D58A801_1724966409 = (clazz.isAssignableFrom(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1048302257 = (Class<? extends U>)this;
            } //End block
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = this.getName();
        String desiredClassName;
        desiredClassName = clazz.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(clazz.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1048302257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1048302257;
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.954 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "58D20E2F06A55F493796EBD75C990AB2")
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        T varB4EAC82CA7396A68D541C85D26508E83_1989040385 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_142076837 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1989040385 = null;
        } //End block
        {
            boolean var907E47EFDDB74A366DA8DC9B84DCA605_1612290705 = (this.isInstance(obj));
            {
                varB4EAC82CA7396A68D541C85D26508E83_142076837 = (T)obj;
            } //End block
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = obj.getClass().getName();
        String desiredClassName;
        desiredClassName = this.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(obj.getTaint());
        T varA7E53CE21691AB073D9660D615818899_996975924; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_996975924 = varB4EAC82CA7396A68D541C85D26508E83_1989040385;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_996975924 = varB4EAC82CA7396A68D541C85D26508E83_142076837;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_996975924.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_996975924;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.954 -0400", hash_original_field = "07BD6CDA090731A5E103F68AD0EAE9F3", hash_generated_field = "79A8A79C6AD7FD652944D6250D95257F")

    private static long serialVersionUID = 3206093459760846163L;
}

