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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.691 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.691 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
    private  Class() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.692 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "3001CB7B7A306258539434A0E6D81BEA")
    private String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_88911164 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1284755577 = null; //Variable for return #2
        Object[] annotation = getSignatureAnnotation();
        {
            varB4EAC82CA7396A68D541C85D26508E83_88911164 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1284755577 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_1338689118; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1338689118 = varB4EAC82CA7396A68D541C85D26508E83_88911164;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1338689118 = varB4EAC82CA7396A68D541C85D26508E83_1284755577;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1338689118.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1338689118;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation();
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.692 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "580560D142C0CD8EEA5AC831F856A095")
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
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.693 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "F16009EA723C6DF0F859908E8B7F68B5")
    public Class<?>[] getClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_2049530432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2049530432 = getFullListOfClasses(true);
        varB4EAC82CA7396A68D541C85D26508E83_2049530432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2049530432;
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.694 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "222F16B37F844C3649AE9F45FFF41568")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_1937587652 = null; //Variable for return #1
        A varB4EAC82CA7396A68D541C85D26508E83_1939667638 = null; //Variable for return #2
        A varB4EAC82CA7396A68D541C85D26508E83_316031706 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A annotation = getDeclaredAnnotation(annotationType);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1937587652 = annotation;
        } //End block
        {
            boolean varCCAC4519E608D500F2E0324B93A2EBDD_1769699024 = (annotationType.isAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        annotation = sup.getDeclaredAnnotation(annotationType);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1939667638 = annotation;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_316031706 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_1768708961; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1768708961 = varB4EAC82CA7396A68D541C85D26508E83_1937587652;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1768708961 = varB4EAC82CA7396A68D541C85D26508E83_1939667638;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1768708961 = varB4EAC82CA7396A68D541C85D26508E83_316031706;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1768708961.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1768708961;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.696 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "F5FFD592FC2DED948D84951974DB521C")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_927075989 = null; //Variable for return #1
        HashMap<Class, Annotation> map = new HashMap<Class, Annotation>();
        Annotation[] declaredAnnotations = getDeclaredAnnotations();
        {
            int i = declaredAnnotations.length-1;
            {
                map.put(declaredAnnotations[i].annotationType(), declaredAnnotations[i]);
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> sup = getSuperclass();
            sup = sup.getSuperclass();
            {
                declaredAnnotations = sup.getDeclaredAnnotations();
                {
                    int i = declaredAnnotations.length-1;
                    {
                        Class<?> clazz = declaredAnnotations[i].annotationType();
                        {
                            boolean varA676920B63F28FB0E69E5ABA9D7FBE4E_413172900 = (!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class));
                            {
                                map.put(clazz, declaredAnnotations[i]);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        Collection<Annotation> coll = map.values();
        varB4EAC82CA7396A68D541C85D26508E83_927075989 = coll.toArray(new Annotation[coll.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_927075989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_927075989;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.697 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "6CD5F322494D683BBAC3A2E1FB6B4716")
    public String getCanonicalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_405875732 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1821751656 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2062196986 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_529732290 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1687048032 = null; //Variable for return #5
        {
            boolean var86589E80A626B28167A55C52F3C71EC5_1110762882 = (isLocalClass() || isAnonymousClass());
            varB4EAC82CA7396A68D541C85D26508E83_405875732 = null;
        } //End collapsed parenthetic
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_963568720 = (isArray());
            {
                String name = getComponentType().getCanonicalName();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1821751656 = name + "[]";
                } //End block
            } //End block
            {
                boolean var12FA39E2BB4D752CA1488728A8FD727B_836891993 = (isMemberClass());
                {
                    String name = getDeclaringClass().getCanonicalName();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2062196986 = name + "." + getSimpleName();
                    } //End block
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_529732290 = getName();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1687048032 = null;
        String varA7E53CE21691AB073D9660D615818899_1477294678; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1477294678 = varB4EAC82CA7396A68D541C85D26508E83_405875732;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1477294678 = varB4EAC82CA7396A68D541C85D26508E83_1821751656;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1477294678 = varB4EAC82CA7396A68D541C85D26508E83_2062196986;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1477294678 = varB4EAC82CA7396A68D541C85D26508E83_529732290;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1477294678 = varB4EAC82CA7396A68D541C85D26508E83_1687048032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1477294678.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1477294678;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.698 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "D74A7938E49DD87E8948A41E18E9A2A2")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1603149560 = null; //Variable for return #1
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1225453347 = null; //Variable for return #2
        {
            boolean var0551DFDC1AC60955441420F1F8D72D3E_1943979786 = (this.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1603149560 = null;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader = getClassLoaderImpl();
        {
            loader = BootClassLoader.getInstance();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1225453347 = loader;
        ClassLoader varA7E53CE21691AB073D9660D615818899_363133795; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_363133795 = varB4EAC82CA7396A68D541C85D26508E83_1603149560;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_363133795 = varB4EAC82CA7396A68D541C85D26508E83_1225453347;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_363133795.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_363133795;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.698 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "C22B9DD8D635AED9FF67605473D8C013")
     ClassLoader getClassLoaderImpl() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_550581525 = null; //Variable for return #1
        ClassLoader loader = getClassLoader(this);
        varB4EAC82CA7396A68D541C85D26508E83_550581525 = loader == null ? BootClassLoader.getInstance() : loader;
        varB4EAC82CA7396A68D541C85D26508E83_550581525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_550581525;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
    private static ClassLoader getClassLoader(Class<?> clazz) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.699 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "CDEED6F065A507A7FECB927A85CD4D66")
    public Class<?> getComponentType() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.699 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "BB2B17CE52EC00B976117D823896BDA1")
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_1619099432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1619099432 = (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1619099432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619099432;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.703 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "84A1A1A674C3941B62291FCE1018ADD7")
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        Member varB4EAC82CA7396A68D541C85D26508E83_1834751945 = null; //Variable for return #1
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
            boolean var2D792DB07DAD7428A386450E26B1B0F6_1236305571 = (result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1834751945 = result;
        addTaint(name.getTaint());
        addTaint(recursive);
        addTaint(publicOnly);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1834751945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834751945;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.708 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "87645F53B12F21649B110F37D89E0F2D")
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        Member varB4EAC82CA7396A68D541C85D26508E83_1570425538 = null; //Variable for return #1
        Member varB4EAC82CA7396A68D541C85D26508E83_499216245 = null; //Variable for return #2
        Member varB4EAC82CA7396A68D541C85D26508E83_1415768464 = null; //Variable for return #3
        {
            Class<?> c = this;
            c = c.getSuperclass();
            {
                Member result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_1336732328 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1570425538 = result;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c = this;
            c = c.getSuperclass();
            {
                {
                    c.getInterfaces().iterator().hasNext();
                    Class<?> ifc = c.getInterfaces().iterator().next();
                    {
                        Member result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_1973820068 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_499216245 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1415768464 = null;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        Member varA7E53CE21691AB073D9660D615818899_908063341; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_908063341 = varB4EAC82CA7396A68D541C85D26508E83_1570425538;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_908063341 = varB4EAC82CA7396A68D541C85D26508E83_499216245;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_908063341 = varB4EAC82CA7396A68D541C85D26508E83_1415768464;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_908063341.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_908063341;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "AA49B0B28888F7A8221428731FA8AD30")
    public Constructor<?>[] getConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_131342569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_131342569 = getDeclaredConstructors(this, true);
        varB4EAC82CA7396A68D541C85D26508E83_131342569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_131342569;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "2A0D770C788AFD3292AC02E319E3DDE7", hash_generated_method = "DB9C61E181111C55768DF3409E22B2FA")
    public Annotation[] getDeclaredAnnotations() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "097083D90BBF2FCC58AC81DB8664E54F", hash_generated_method = "33C06C0DC63918D788913C928E9A0C55")
    private <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.710 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "D31E99A4F7D42138847DEE299E3D358B")
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_917915473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_917915473;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.711 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "DA51B42292704AA37725EBBBC3393390")
    public Class<?>[] getDeclaredClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_651075343 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_651075343 = getDeclaredClasses(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_651075343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651075343;
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.712 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "9B1997F803B13C2808A7451802DF6985")
    private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_2007491857 = null; //Variable for return #1
        Class<?>[] result = getDeclaredClasses(this, publicOnly);
        Class<?> clazz = this.getSuperclass();
        {
            Class<?>[] temp = getDeclaredClasses(clazz, publicOnly);
            {
                result = arraycopy(new Class[result.length + temp.length], result, temp);
            } //End block
            clazz = clazz.getSuperclass();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2007491857 = result;
        addTaint(publicOnly);
        varB4EAC82CA7396A68D541C85D26508E83_2007491857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2007491857;
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
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.712 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "D4379A62FE7C99569DC18DA896FD6DA9")
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_165978911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_165978911 = (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_165978911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_165978911;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.713 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "BB7D75E9CE3B87DF892FAED74B705526")
    public Constructor<?>[] getDeclaredConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_1077527532 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1077527532 = getDeclaredConstructors(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1077527532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1077527532;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, false);
    }

    
    private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.714 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "23D33270CB547CC35C96184FE40DDA8D")
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_792623338 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result = getDeclaredField(this, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_792623338 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_792623338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_792623338;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.714 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "6C2C0184C266A602A7FDF841E4932595")
    public Field[] getDeclaredFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_519434362 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_519434362 = getDeclaredFields(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_519434362.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519434362;
        // ---------- Original Method ----------
        //return getDeclaredFields(this, false);
    }

    
    static Field[] getDeclaredFields(Class<?> clazz, boolean publicOnly) {
                //DSFIXME:  This shouldn't happen!
    }

    
    static Field getDeclaredField(Class<?> clazz, String name) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.715 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "075A599BCA93C420D8A875EE5351101C")
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_1625619485 = null; //Variable for return #1
        Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1625619485 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1625619485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1625619485;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.716 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "094BDFE715FA7F43CB67CE5A3F276AED")
    public Method[] getDeclaredMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_1222789881 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1222789881 = getDeclaredMethods(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1222789881.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1222789881;
        // ---------- Original Method ----------
        //return getDeclaredMethods(this, false);
    }

    
    static Method[] getDeclaredMethods(Class<?> clazz, boolean publicOnly) {
                //DSFIXME:  This shouldn't happen!
    }

    
    static Member getDeclaredConstructorOrMethod(Class clazz, String name, Class[] args) {
                //DSFIXME:  This shouldn't happen!
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.716 -0400", hash_original_method = "67DCCE022B38EF56E621E9F7C3410002", hash_generated_method = "A08735CEB9F08341039B8C54A1BD5E61")
    public Class<?> getDeclaringClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "B183618DCECD1DBBC6B77A8041AAB5FF", hash_generated_method = "E19B04C40918C59F801E144F365A783E")
    public Class<?> getEnclosingClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "66CD711920ADA841CC04EC44C476AA92", hash_generated_method = "E9EFFA224CF0890C33C432913B5CDC4A")
    public Constructor<?> getEnclosingConstructor() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.717 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "42F609F6A3577ECAA8EE5F0164C83C69")
    public Method getEnclosingMethod() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.718 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "96F2411F5A112D6A19769F9C7D8161B3")
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1621060875 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_1329103049 = null; //Variable for return #2
        {
            boolean var6E8389F5338F7F2F41F0B21F08A19A46_2146259883 = (!isEnum());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1621060875 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1329103049 = (T[]) Enum.getSharedConstants((Class) this).clone();
        T[] varA7E53CE21691AB073D9660D615818899_548407936; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_548407936 = varB4EAC82CA7396A68D541C85D26508E83_1621060875;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_548407936 = varB4EAC82CA7396A68D541C85D26508E83_1329103049;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_548407936.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_548407936;
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.719 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "E94B810F9CEFF058980538B3F4FC71E1")
    public Field getField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_1110633585 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result = getPublicFieldRecursive(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1110633585 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1110633585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1110633585;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.729 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "BFF6806013DBCA394A4C44FA652A7DCE")
    private Field getPublicFieldRecursive(String name) {
        Field varB4EAC82CA7396A68D541C85D26508E83_764784757 = null; //Variable for return #1
        Field varB4EAC82CA7396A68D541C85D26508E83_554783988 = null; //Variable for return #2
        Field varB4EAC82CA7396A68D541C85D26508E83_1804654737 = null; //Variable for return #3
        {
            Class<?> c = this;
            c = c.getSuperclass();
            {
                Field result = Class.getDeclaredField(c, name);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_972721808 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_764784757 = result;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> c = this;
            c = c.getSuperclass();
            {
                {
                    Class<?> ifc = c.getInterfaces()[0];
                    {
                        Field result = ifc.getPublicFieldRecursive(name);
                        {
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_392810284 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_554783988 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1804654737 = null;
        addTaint(name.getTaint());
        Field varA7E53CE21691AB073D9660D615818899_945321209; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_945321209 = varB4EAC82CA7396A68D541C85D26508E83_764784757;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_945321209 = varB4EAC82CA7396A68D541C85D26508E83_554783988;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_945321209 = varB4EAC82CA7396A68D541C85D26508E83_1804654737;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_945321209.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_945321209;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.732 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "D5170549BE401A42DCCB5E9D7436B247")
    public Field[] getFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_1553434824 = null; //Variable for return #1
        List<Field> fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        varB4EAC82CA7396A68D541C85D26508E83_1553434824 = fields.toArray(new Field[fields.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1553434824.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1553434824;
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.739 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "8B917A2A359609BB103403301BA37344")
    private void getPublicFieldsRecursive(List<Field> result) {
        {
            Class<?> c = this;
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
            Class<?> c = this;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.740 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "60311FB62B1E8E45FCD3FFF4941B7230")
    public Type[] getGenericInterfaces() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_1450689875 = null; //Variable for return #1
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1450689875 = Types.getClonedTypeArray(parser.interfaceTypes);
        varB4EAC82CA7396A68D541C85D26508E83_1450689875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1450689875;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.741 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "E5DEE202FCD8D8758E2DEFBA0384E163")
    public Type getGenericSuperclass() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1829067052 = null; //Variable for return #1
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1829067052 = Types.getType(parser.superclassType);
        varB4EAC82CA7396A68D541C85D26508E83_1829067052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1829067052;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getType(parser.superclassType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.741 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "2692A665379A2F86FF3326F5F5EB1B7B")
    public Class<?>[] getInterfaces() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.741 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "B52698A5496C6395FC71DBC4C61E91AD")
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_1291542343 = null; //Variable for return #1
        Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1291542343 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1291542343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291542343;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.742 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "F7E615CAD1E7DB823CCBBE09F7B3429A")
    public Method[] getMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_671429982 = null; //Variable for return #1
        List<Method> methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_671429982 = methods.toArray(new Method[methods.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_671429982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671429982;
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.750 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "4E3C74E9DAAB5C043AF243A474086ABB")
    private void getPublicMethodsRecursive(List<Method> result) {
        {
            Class<?> c = this;
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
            Class<?> c = this;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.752 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "2EC40AD6935DE316FE5A5A537A9DAEF2")
    public int getModifiers() {
        int varE142A374AC768972DB237647A19C42B9_220961056 = (getModifiers(this, false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525873152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525873152;
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
    private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.755 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "E83570BA1752D0389D94CA38D40AE78E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_619149225 = null; //Variable for return #1
        String result = name;
        varB4EAC82CA7396A68D541C85D26508E83_619149225 = (result == null) ? (name = getNameNative()) : result;
        varB4EAC82CA7396A68D541C85D26508E83_619149225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_619149225;
        // ---------- Original Method ----------
        //String result = name;
        //return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.755 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "D2A1F2570A688E342CB66374B5D563FA")
    private String getNameNative() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.757 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "D62C2BF8055FBD41EA115DDE4119DF8F")
    public String getSimpleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_690781059 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_505515128 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2100469544 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1245211977 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_648707971 = null; //Variable for return #5
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_179022835 = (isArray());
            {
                varB4EAC82CA7396A68D541C85D26508E83_690781059 = getComponentType().getSimpleName() + "[]";
            } //End block
        } //End collapsed parenthetic
        String name = getName();
        {
            boolean var6C53121FEDEDDD465179821F892D8557_1741807999 = (isAnonymousClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_505515128 = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1710CE004786B2172BA7D8655CC10CDC_958518374 = (isMemberClass() || isLocalClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2100469544 = getInnerClassName();
            } //End block
        } //End collapsed parenthetic
        int dot = name.lastIndexOf('.');
        {
            varB4EAC82CA7396A68D541C85D26508E83_1245211977 = name.substring(dot + 1);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_648707971 = name;
        String varA7E53CE21691AB073D9660D615818899_980598788; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_980598788 = varB4EAC82CA7396A68D541C85D26508E83_690781059;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_980598788 = varB4EAC82CA7396A68D541C85D26508E83_505515128;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_980598788 = varB4EAC82CA7396A68D541C85D26508E83_2100469544;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_980598788 = varB4EAC82CA7396A68D541C85D26508E83_1245211977;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_980598788 = varB4EAC82CA7396A68D541C85D26508E83_648707971;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_980598788.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_980598788;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.757 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "E15F8A7CFFBAA6A8E91B4004366ED98B")
    private String getInnerClassName() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.758 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "6AD6524253815947B43A04D461B38C42")
    public ProtectionDomain getProtectionDomain() {
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_2072828871 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2072828871 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2072828871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072828871;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.760 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "EB54F132698F109A009E475B07E54629")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_2099622185 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1393441326 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1694234924 = (resName.startsWith("/"));
            {
                resName = resName.substring(1);
            } //End block
            {
                String pkg = getName();
                int dot = pkg.lastIndexOf('.');
                {
                    pkg = pkg.substring(0, dot).replace('.', '/');
                } //End block
                {
                    pkg = "";
                } //End block
                resName = pkg + "/" + resName;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader = getClassLoader();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2099622185 = loader.getResource(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1393441326 = ClassLoader.getSystemResource(resName);
        } //End block
        addTaint(resName.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_550148960; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_550148960 = varB4EAC82CA7396A68D541C85D26508E83_2099622185;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_550148960 = varB4EAC82CA7396A68D541C85D26508E83_1393441326;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_550148960.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_550148960;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.761 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "69007C28C3711AF2ABFC853C78757AEF")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_270688702 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_539028323 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1601682806 = (resName.startsWith("/"));
            {
                resName = resName.substring(1);
            } //End block
            {
                String pkg = getName();
                int dot = pkg.lastIndexOf('.');
                {
                    pkg = pkg.substring(0, dot).replace('.', '/');
                } //End block
                {
                    pkg = "";
                } //End block
                resName = pkg + "/" + resName;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader = getClassLoader();
        {
            varB4EAC82CA7396A68D541C85D26508E83_270688702 = loader.getResourceAsStream(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_539028323 = ClassLoader.getSystemResourceAsStream(resName);
        } //End block
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1301041655; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1301041655 = varB4EAC82CA7396A68D541C85D26508E83_270688702;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301041655 = varB4EAC82CA7396A68D541C85D26508E83_539028323;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301041655.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1301041655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.761 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "E7462F1BDCA341B5DCB08DA1E75C3FB1")
    public Object[] getSigners() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_355299679 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_355299679 = null;
        varB4EAC82CA7396A68D541C85D26508E83_355299679.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_355299679;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "792E704BA339F799A62D747A09647119")
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        TypeVariable<Class<T>>[] varB4EAC82CA7396A68D541C85D26508E83_1196263087 = null; //Variable for return #1
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1196263087 = parser.formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1196263087.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1196263087;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "7FC744D3EC1B6879F5698C6F3C8AF820")
    public boolean isAnnotation() {
        final int ACC_ANNOTATION = 0x2000;
        int mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2020245757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2020245757;
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.763 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "4D5D5E257479A2B1933D46FC9D9C1707")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        {
            boolean varEEBC1240FDA40BFAEAACBFB89D6281AF_207571385 = (isDeclaredAnnotationPresent(annotationType));
        } //End collapsed parenthetic
        {
            boolean var29D87B80E530DF4C50E30AC2EB8C6CFB_1391136539 = (annotationType.isDeclaredAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        {
                            boolean var9601F0FC9454A2DF6984664914F9F810_1318893530 = (sup.isDeclaredAnnotationPresent(annotationType));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625254162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625254162;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.763 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "2AF25431B992ECAA074CC8C120705518")
    public boolean isAnonymousClass() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766824952 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766824952;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.763 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "0522E001463D0E62BABDAEE656BA6636")
    public boolean isArray() {
        boolean var9F61AD98F70F910DD07C7CB078A688AE_432665467 = (getComponentType() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2117322122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2117322122;
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.763 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "B52484DE5C84A00D433065FE506E734C")
    public boolean isAssignableFrom(Class<?> cls) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705012425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705012425;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.763 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "F9CEE741AA54C78934EAF86A0B5D342A")
    public boolean isEnum() {
        boolean var12ECA463BB0095D0882BCBC30CA80AD1_1645078635 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920015567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920015567;
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.764 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "AE8AD508E3233CB4C53DD90BDB5A3FB2")
    public boolean isInstance(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220066417 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220066417;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.764 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "1D9671C5ACCB264876BDED285E661700")
    public boolean isInterface() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365506430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365506430;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.764 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "AED154CB714DBD59E392AEE4607BB322")
    public boolean isLocalClass() {
        boolean enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean varAA6243A3A6D5A82E5F77D3D9BE30067E_875923918 = (enclosed && !isAnonymousClass());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126737555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126737555;
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.764 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "4FD0375D0EA604485E8465C9F909189B")
    public boolean isMemberClass() {
        boolean varD300F2653B6225A244F27A67DCB40753_1831196672 = (getDeclaringClass() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573998764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573998764;
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.765 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "79586B2EEA7716888A12A00449ED0D6D")
    public boolean isPrimitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044177983 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044177983;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.765 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "0C5ADCABEBFC16336B568DB79DE54AF2")
    public boolean isSynthetic() {
        final int ACC_SYNTHETIC = 0x1000;
        int mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640119705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640119705;
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.765 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "C5119DB65A046DB42370749B6FE23486")
    public T newInstance() throws InstantiationException, IllegalAccessException {
        T varB4EAC82CA7396A68D541C85D26508E83_1044058545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1044058545 = newInstanceImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1044058545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044058545;
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.766 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.766 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "2D620EF649017D7CBC92B7EDD244CD4F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1723585622 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1966204543 = null; //Variable for return #2
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_786999154 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1723585622 = getSimpleName();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1966204543 = (isInterface() ? "interface " : "class ") + getName();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_548021674; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_548021674 = varB4EAC82CA7396A68D541C85D26508E83_1723585622;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_548021674 = varB4EAC82CA7396A68D541C85D26508E83_1966204543;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_548021674.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_548021674;
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.767 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "05E92DE50E56C21DF4296F4C1D7A545A")
    public Package getPackage() {
        Package varB4EAC82CA7396A68D541C85D26508E83_1156744829 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_140887520 = null; //Variable for return #2
        ClassLoader loader = getClassLoader();
        {
            String name = getName();
            int dot = name.lastIndexOf('.');
            varB4EAC82CA7396A68D541C85D26508E83_1156744829 = (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_140887520 = null;
        Package varA7E53CE21691AB073D9660D615818899_1733813569; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1733813569 = varB4EAC82CA7396A68D541C85D26508E83_1156744829;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1733813569 = varB4EAC82CA7396A68D541C85D26508E83_140887520;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1733813569.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1733813569;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.767 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "1C2D310A9A2856D40F4163E9CB4EC999")
    public boolean desiredAssertionStatus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108875613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108875613;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.768 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "DDB99FC4A0F9A5D5E1E4EDA577A64EE3")
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        Class<? extends U> varB4EAC82CA7396A68D541C85D26508E83_1027386347 = null; //Variable for return #1
        {
            boolean varE62FF236193AD694C6D580397D58A801_203844547 = (clazz.isAssignableFrom(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1027386347 = (Class<? extends U>)this;
            } //End block
        } //End collapsed parenthetic
        String actualClassName = this.getName();
        String desiredClassName = clazz.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(clazz.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1027386347.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027386347;
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.770 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "B805C6ED01E19426A6B4C989C4641319")
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        T varB4EAC82CA7396A68D541C85D26508E83_1757861669 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_715522132 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1757861669 = null;
        } //End block
        {
            boolean var907E47EFDDB74A366DA8DC9B84DCA605_13016359 = (this.isInstance(obj));
            {
                varB4EAC82CA7396A68D541C85D26508E83_715522132 = (T)obj;
            } //End block
        } //End collapsed parenthetic
        String actualClassName = obj.getClass().getName();
        String desiredClassName = this.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(obj.getTaint());
        T varA7E53CE21691AB073D9660D615818899_794130230; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_794130230 = varB4EAC82CA7396A68D541C85D26508E83_1757861669;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_794130230 = varB4EAC82CA7396A68D541C85D26508E83_715522132;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_794130230.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_794130230;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.770 -0400", hash_original_field = "07BD6CDA090731A5E103F68AD0EAE9F3", hash_generated_field = "A2E36971CC30DE91D1AF4E9C02F420A3")

    private static final long serialVersionUID = 3206093459760846163L;
}

