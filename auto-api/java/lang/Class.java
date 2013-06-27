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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.540 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.540 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
    private  Class() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.550 -0400", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "AEDDABE240A6CF127A93629D5AA3774D")
    private String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_904893246 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_412851260 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation();
        {
            varB4EAC82CA7396A68D541C85D26508E83_904893246 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_412851260 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_883503834; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_883503834 = varB4EAC82CA7396A68D541C85D26508E83_904893246;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_883503834 = varB4EAC82CA7396A68D541C85D26508E83_412851260;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_883503834.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_883503834;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation();
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.550 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "580560D142C0CD8EEA5AC831F856A095")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.551 -0400", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "37B15D79DDB7078A016C7467A279A6CB")
    public Class<?>[] getClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_459819165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_459819165 = getFullListOfClasses(true);
        varB4EAC82CA7396A68D541C85D26508E83_459819165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_459819165;
        // ---------- Original Method ----------
        //return getFullListOfClasses(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.552 -0400", hash_original_method = "F78DA66084C503A2B491A95B3FBC8112", hash_generated_method = "DE24B64F41A5356FA31FE0701832C504")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_1039209030 = null; //Variable for return #1
        A varB4EAC82CA7396A68D541C85D26508E83_393441661 = null; //Variable for return #2
        A varB4EAC82CA7396A68D541C85D26508E83_677409418 = null; //Variable for return #3
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A annotation;
        annotation = getDeclaredAnnotation(annotationType);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1039209030 = annotation;
        } //End block
        {
            boolean varCCAC4519E608D500F2E0324B93A2EBDD_573097599 = (annotationType.isAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        annotation = sup.getDeclaredAnnotation(annotationType);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_393441661 = annotation;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_677409418 = null;
        addTaint(annotationType.getTaint());
        A varA7E53CE21691AB073D9660D615818899_399823738; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_399823738 = varB4EAC82CA7396A68D541C85D26508E83_1039209030;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_399823738 = varB4EAC82CA7396A68D541C85D26508E83_393441661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_399823738 = varB4EAC82CA7396A68D541C85D26508E83_677409418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_399823738.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_399823738;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.555 -0400", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "A32E10CF0E1CC1868078E95C5030C758")
    public Annotation[] getAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1610695256 = null; //Variable for return #1
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
                            boolean varA676920B63F28FB0E69E5ABA9D7FBE4E_406297887 = (!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class));
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
        varB4EAC82CA7396A68D541C85D26508E83_1610695256 = coll.toArray(new Annotation[coll.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1610695256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610695256;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.555 -0400", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "47E389F60DA419F0D75253B76F229FD1")
    public String getCanonicalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2098912856 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_711192184 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1715323269 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1013529705 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_584329157 = null; //Variable for return #5
        {
            boolean var86589E80A626B28167A55C52F3C71EC5_498330605 = (isLocalClass() || isAnonymousClass());
            varB4EAC82CA7396A68D541C85D26508E83_2098912856 = null;
        } //End collapsed parenthetic
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_793344320 = (isArray());
            {
                String name;
                name = getComponentType().getCanonicalName();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_711192184 = name + "[]";
                } //End block
            } //End block
            {
                boolean var12FA39E2BB4D752CA1488728A8FD727B_786490914 = (isMemberClass());
                {
                    String name;
                    name = getDeclaringClass().getCanonicalName();
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1715323269 = name + "." + getSimpleName();
                    } //End block
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1013529705 = getName();
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_584329157 = null;
        String varA7E53CE21691AB073D9660D615818899_1835214856; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1835214856 = varB4EAC82CA7396A68D541C85D26508E83_2098912856;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1835214856 = varB4EAC82CA7396A68D541C85D26508E83_711192184;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1835214856 = varB4EAC82CA7396A68D541C85D26508E83_1715323269;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1835214856 = varB4EAC82CA7396A68D541C85D26508E83_1013529705;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1835214856 = varB4EAC82CA7396A68D541C85D26508E83_584329157;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1835214856.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1835214856;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.556 -0400", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "13F0BFDB60E301BD1CD68D661A34C893")
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1215805343 = null; //Variable for return #1
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_682817109 = null; //Variable for return #2
        {
            boolean var0551DFDC1AC60955441420F1F8D72D3E_1550560424 = (this.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1215805343 = null;
            } //End block
        } //End collapsed parenthetic
        ClassLoader loader;
        loader = getClassLoaderImpl();
        {
            loader = BootClassLoader.getInstance();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_682817109 = loader;
        ClassLoader varA7E53CE21691AB073D9660D615818899_849365797; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_849365797 = varB4EAC82CA7396A68D541C85D26508E83_1215805343;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_849365797 = varB4EAC82CA7396A68D541C85D26508E83_682817109;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_849365797.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_849365797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.557 -0400", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "A0B734EB61D0C154C0B6D3CF60F1E1A5")
     ClassLoader getClassLoaderImpl() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1232642030 = null; //Variable for return #1
        ClassLoader loader;
        loader = getClassLoader(this);
        varB4EAC82CA7396A68D541C85D26508E83_1232642030 = loader == null ? BootClassLoader.getInstance() : loader;
        varB4EAC82CA7396A68D541C85D26508E83_1232642030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232642030;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader(this);
        //return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
        private static ClassLoader getClassLoader(Class<?> clazz) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.558 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "CDEED6F065A507A7FECB927A85CD4D66")
    public Class<?> getComponentType() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.572 -0400", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "DD93F0C4390AC613DC8957AAF737D159")
    @SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_235683074 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_235683074 = (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_235683074.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_235683074;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.608 -0400", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "6E5A6396AF5C854150A1C71DED4EEF56")
    private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        Member varB4EAC82CA7396A68D541C85D26508E83_1345904511 = null; //Variable for return #1
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
            boolean var2D792DB07DAD7428A386450E26B1B0F6_1959393155 = (result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1345904511 = result;
        addTaint(name.getTaint());
        addTaint(recursive);
        addTaint(publicOnly);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1345904511.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345904511;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.653 -0400", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "131871217F75396457738AB7657B37A9")
    private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        Member varB4EAC82CA7396A68D541C85D26508E83_1543835183 = null; //Variable for return #1
        Member varB4EAC82CA7396A68D541C85D26508E83_669676170 = null; //Variable for return #2
        Member varB4EAC82CA7396A68D541C85D26508E83_1830339933 = null; //Variable for return #3
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Member result;
                result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_1669047733 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1543835183 = result;
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
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_1616658480 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_669676170 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1830339933 = null;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        Member varA7E53CE21691AB073D9660D615818899_1468920305; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1468920305 = varB4EAC82CA7396A68D541C85D26508E83_1543835183;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1468920305 = varB4EAC82CA7396A68D541C85D26508E83_669676170;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1468920305 = varB4EAC82CA7396A68D541C85D26508E83_1830339933;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1468920305.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1468920305;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.665 -0400", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "61A51605933E5E7A2F15C606B864180A")
    public Constructor<?>[] getConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_241611157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_241611157 = getDeclaredConstructors(this, true);
        varB4EAC82CA7396A68D541C85D26508E83_241611157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_241611157;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.666 -0400", hash_original_method = "2A0D770C788AFD3292AC02E319E3DDE7", hash_generated_method = "DB9C61E181111C55768DF3409E22B2FA")
    public Annotation[] getDeclaredAnnotations() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.666 -0400", hash_original_method = "097083D90BBF2FCC58AC81DB8664E54F", hash_generated_method = "33C06C0DC63918D788913C928E9A0C55")
    private <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.667 -0400", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "A522550D6A78463155D9757632C18EE8")
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_219647537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_219647537;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.667 -0400", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "FF34FFACA2AAFEA2637C1B85EDA8AAA2")
    public Class<?>[] getDeclaredClasses() {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_1557591278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1557591278 = getDeclaredClasses(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1557591278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1557591278;
        // ---------- Original Method ----------
        //return getDeclaredClasses(this, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.676 -0400", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "CFCC06D8202D7E3EFEB6A2687ADB2906")
    private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        Class<?>[] varB4EAC82CA7396A68D541C85D26508E83_559690979 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_559690979 = result;
        addTaint(publicOnly);
        varB4EAC82CA7396A68D541C85D26508E83_559690979.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559690979;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.679 -0400", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "6647CC84249A941063256B3FC974439E")
    @SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        Constructor<T> varB4EAC82CA7396A68D541C85D26508E83_907758738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_907758738 = (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_907758738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_907758738;
        // ---------- Original Method ----------
        //return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.680 -0400", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "E1912351010CA16FFCBF4B323C3ACF27")
    public Constructor<?>[] getDeclaredConstructors() {
        Constructor<?>[] varB4EAC82CA7396A68D541C85D26508E83_778866849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_778866849 = getDeclaredConstructors(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_778866849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_778866849;
        // ---------- Original Method ----------
        //return getDeclaredConstructors(this, false);
    }

    
        private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.681 -0400", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "5C44BE72C977D1D0813F99F21A6A844F")
    public Field getDeclaredField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_1770187325 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getDeclaredField(this, name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1770187325 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1770187325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770187325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.681 -0400", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "857FE1215A5A4CAE3D95E73BFD5217DD")
    public Field[] getDeclaredFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_455324404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_455324404 = getDeclaredFields(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_455324404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_455324404;
        // ---------- Original Method ----------
        //return getDeclaredFields(this, false);
    }

    
        static Field[] getDeclaredFields(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Field getDeclaredField(Class<?> clazz, String name) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.682 -0400", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "8790435E4573C313585DDCBDC307D7F6")
    public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_1133930627 = null; //Variable for return #1
        Member member;
        member = getConstructorOrMethod(name, false, false, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1133930627 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1133930627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1133930627;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.682 -0400", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "F779AF2212E72FA17B2CEC1D45217B0A")
    public Method[] getDeclaredMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_1077391335 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1077391335 = getDeclaredMethods(this, false);
        varB4EAC82CA7396A68D541C85D26508E83_1077391335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1077391335;
        // ---------- Original Method ----------
        //return getDeclaredMethods(this, false);
    }

    
        static Method[] getDeclaredMethods(Class<?> clazz, boolean publicOnly) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        static Member getDeclaredConstructorOrMethod(Class clazz, String name, Class[] args) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.696 -0400", hash_original_method = "67DCCE022B38EF56E621E9F7C3410002", hash_generated_method = "A08735CEB9F08341039B8C54A1BD5E61")
    public Class<?> getDeclaringClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.698 -0400", hash_original_method = "B183618DCECD1DBBC6B77A8041AAB5FF", hash_generated_method = "E19B04C40918C59F801E144F365A783E")
    public Class<?> getEnclosingClass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.700 -0400", hash_original_method = "66CD711920ADA841CC04EC44C476AA92", hash_generated_method = "E9EFFA224CF0890C33C432913B5CDC4A")
    public Constructor<?> getEnclosingConstructor() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.700 -0400", hash_original_method = "D4C604D782CFEF7F67F7383F824B8549", hash_generated_method = "42F609F6A3577ECAA8EE5F0164C83C69")
    public Method getEnclosingMethod() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.703 -0400", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "4BB5AE83D899FB344F932ABFDAF05858")
    @SuppressWarnings("unchecked")
    public T[] getEnumConstants() {
        T[] varB4EAC82CA7396A68D541C85D26508E83_2043666399 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_191522010 = null; //Variable for return #2
        {
            boolean var6E8389F5338F7F2F41F0B21F08A19A46_2054881796 = (!isEnum());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2043666399 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_191522010 = (T[]) Enum.getSharedConstants((Class) this).clone();
        T[] varA7E53CE21691AB073D9660D615818899_167579751; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_167579751 = varB4EAC82CA7396A68D541C85D26508E83_2043666399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_167579751 = varB4EAC82CA7396A68D541C85D26508E83_191522010;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_167579751.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_167579751;
        // ---------- Original Method ----------
        //if (!isEnum()) {
            //return null;
        //}
        //return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.713 -0400", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "B296AB5A578FD3F5F519804E45EB2EF7")
    public Field getField(String name) throws NoSuchFieldException {
        Field varB4EAC82CA7396A68D541C85D26508E83_895753090 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("name == null");
        } //End block
        Field result;
        result = getPublicFieldRecursive(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_895753090 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_895753090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895753090;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.759 -0400", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "CCA134643AF6FCBB8548C8CDB1A6414B")
    private Field getPublicFieldRecursive(String name) {
        Field varB4EAC82CA7396A68D541C85D26508E83_604661622 = null; //Variable for return #1
        Field varB4EAC82CA7396A68D541C85D26508E83_1207764703 = null; //Variable for return #2
        Field varB4EAC82CA7396A68D541C85D26508E83_741746197 = null; //Variable for return #3
        {
            Class<?> c;
            c = this;
            c = c.getSuperclass();
            {
                Field result;
                result = Class.getDeclaredField(c, name);
                {
                    boolean varDAA8D8093BC51015EE1E5335F90A68C5_778849415 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_604661622 = result;
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
                            boolean varE4094BEEEEDC83883DF8987ED226FF8A_1457487840 = (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1207764703 = result;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_741746197 = null;
        addTaint(name.getTaint());
        Field varA7E53CE21691AB073D9660D615818899_178466940; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_178466940 = varB4EAC82CA7396A68D541C85D26508E83_604661622;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_178466940 = varB4EAC82CA7396A68D541C85D26508E83_1207764703;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_178466940 = varB4EAC82CA7396A68D541C85D26508E83_741746197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_178466940.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_178466940;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.767 -0400", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "78FED5C5EA30396D543750569493C6A7")
    public Field[] getFields() {
        Field[] varB4EAC82CA7396A68D541C85D26508E83_662228157 = null; //Variable for return #1
        List<Field> fields;
        fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        varB4EAC82CA7396A68D541C85D26508E83_662228157 = fields.toArray(new Field[fields.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_662228157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_662228157;
        // ---------- Original Method ----------
        //List<Field> fields = new ArrayList<Field>();
        //getPublicFieldsRecursive(fields);
        //CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        //return fields.toArray(new Field[fields.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.812 -0400", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "BD1276EBF58CD50457160465211412AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.813 -0400", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "15C9BCE7EAC8C38299BD0D8AB4AE8B2C")
    public Type[] getGenericInterfaces() {
        Type[] varB4EAC82CA7396A68D541C85D26508E83_445907053 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_445907053 = Types.getClonedTypeArray(parser.interfaceTypes);
        varB4EAC82CA7396A68D541C85D26508E83_445907053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_445907053;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.814 -0400", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "38425E6CDD625583722109CC1C7DE9E1")
    public Type getGenericSuperclass() {
        Type varB4EAC82CA7396A68D541C85D26508E83_40952422 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_40952422 = Types.getType(parser.superclassType);
        varB4EAC82CA7396A68D541C85D26508E83_40952422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40952422;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return Types.getType(parser.superclassType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.814 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "2692A665379A2F86FF3326F5F5EB1B7B")
    public Class<?>[] getInterfaces() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.815 -0400", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "107DE20202E4C1F54A8A685715076FD8")
    public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Method varB4EAC82CA7396A68D541C85D26508E83_1521660368 = null; //Variable for return #1
        Member member;
        member = getConstructorOrMethod(name, true, true, parameterTypes);
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchMethodException(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1521660368 = (Method) member;
        addTaint(name.getTaint());
        addTaint(parameterTypes[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1521660368.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521660368;
        // ---------- Original Method ----------
        //Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        //if (member instanceof Constructor) {
            //throw new NoSuchMethodException(name);
        //}
        //return (Method) member;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.820 -0400", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "061018B0ADA3021F8A1DF2EB21F3B92E")
    public Method[] getMethods() {
        Method[] varB4EAC82CA7396A68D541C85D26508E83_1288242721 = null; //Variable for return #1
        List<Method> methods;
        methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        varB4EAC82CA7396A68D541C85D26508E83_1288242721 = methods.toArray(new Method[methods.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1288242721.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1288242721;
        // ---------- Original Method ----------
        //List<Method> methods = new ArrayList<Method>();
        //getPublicMethodsRecursive(methods);
        //CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        //return methods.toArray(new Method[methods.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.874 -0400", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "AD8116DAA5E68CA3B780C155EAA4FAD3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.875 -0400", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "7D1317C8B7CBE63A6730046DA2769E21")
    public int getModifiers() {
        int varE142A374AC768972DB237647A19C42B9_416362394 = (getModifiers(this, false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995603907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995603907;
        // ---------- Original Method ----------
        //return getModifiers(this, false);
    }

    
        private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.881 -0400", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "87E3AADDF67CB423D61F3E2FF6AFCE1E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1206306022 = null; //Variable for return #1
        String result;
        result = name;
        varB4EAC82CA7396A68D541C85D26508E83_1206306022 = (result == null) ? (name = getNameNative()) : result;
        varB4EAC82CA7396A68D541C85D26508E83_1206306022.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206306022;
        // ---------- Original Method ----------
        //String result = name;
        //return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.881 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "D2A1F2570A688E342CB66374B5D563FA")
    private String getNameNative() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.884 -0400", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "BAB5F641550BBEE680EF2A88AC2DAA8A")
    public String getSimpleName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1217355801 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1568239607 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_861435990 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1856056090 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_275177125 = null; //Variable for return #5
        {
            boolean varFD05E39B7CB16BA8AEC93AE4E47F1C5F_988589114 = (isArray());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1217355801 = getComponentType().getSimpleName() + "[]";
            } //End block
        } //End collapsed parenthetic
        String name;
        name = getName();
        {
            boolean var6C53121FEDEDDD465179821F892D8557_16015264 = (isAnonymousClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1568239607 = "";
            } //End block
        } //End collapsed parenthetic
        {
            boolean var1710CE004786B2172BA7D8655CC10CDC_1494387025 = (isMemberClass() || isLocalClass());
            {
                varB4EAC82CA7396A68D541C85D26508E83_861435990 = getInnerClassName();
            } //End block
        } //End collapsed parenthetic
        int dot;
        dot = name.lastIndexOf('.');
        {
            varB4EAC82CA7396A68D541C85D26508E83_1856056090 = name.substring(dot + 1);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_275177125 = name;
        String varA7E53CE21691AB073D9660D615818899_645537645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_645537645 = varB4EAC82CA7396A68D541C85D26508E83_1217355801;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_645537645 = varB4EAC82CA7396A68D541C85D26508E83_1568239607;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_645537645 = varB4EAC82CA7396A68D541C85D26508E83_861435990;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_645537645 = varB4EAC82CA7396A68D541C85D26508E83_1856056090;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_645537645 = varB4EAC82CA7396A68D541C85D26508E83_275177125;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_645537645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_645537645;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.884 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "E15F8A7CFFBAA6A8E91B4004366ED98B")
    private String getInnerClassName() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.885 -0400", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "CD53A175CD6808A82BF8DE101B484254")
    public ProtectionDomain getProtectionDomain() {
        ProtectionDomain varB4EAC82CA7396A68D541C85D26508E83_978693878 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978693878 = null;
        varB4EAC82CA7396A68D541C85D26508E83_978693878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978693878;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.896 -0400", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "9384DB80FCF5AAB50E4284438139ED67")
    public URL getResource(String resName) {
        URL varB4EAC82CA7396A68D541C85D26508E83_516146959 = null; //Variable for return #1
        URL varB4EAC82CA7396A68D541C85D26508E83_1372754522 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1031529819 = (resName.startsWith("/"));
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
            varB4EAC82CA7396A68D541C85D26508E83_516146959 = loader.getResource(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1372754522 = ClassLoader.getSystemResource(resName);
        } //End block
        addTaint(resName.getTaint());
        URL varA7E53CE21691AB073D9660D615818899_1261214733; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1261214733 = varB4EAC82CA7396A68D541C85D26508E83_516146959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1261214733 = varB4EAC82CA7396A68D541C85D26508E83_1372754522;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1261214733.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1261214733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.907 -0400", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "81D17FDF8DF6ADEB0AE1F669794CD105")
    public InputStream getResourceAsStream(String resName) {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1457279556 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1910060305 = null; //Variable for return #2
        {
            boolean var718D9075DC8A20618F0410A875A157F6_1318602235 = (resName.startsWith("/"));
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
            varB4EAC82CA7396A68D541C85D26508E83_1457279556 = loader.getResourceAsStream(resName);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1910060305 = ClassLoader.getSystemResourceAsStream(resName);
        } //End block
        addTaint(resName.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1062662368; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1062662368 = varB4EAC82CA7396A68D541C85D26508E83_1457279556;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1062662368 = varB4EAC82CA7396A68D541C85D26508E83_1910060305;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1062662368.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1062662368;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.908 -0400", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "34BC5082522A9A912BB87286E15A0C3E")
    public Object[] getSigners() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1445801251 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1445801251 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1445801251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445801251;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.908 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.908 -0400", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "990A5DAB1E63EA2CFEB8516D05E09794")
    @SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        TypeVariable<Class<T>>[] varB4EAC82CA7396A68D541C85D26508E83_1602031427 = null; //Variable for return #1
        GenericSignatureParser parser;
        parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        varB4EAC82CA7396A68D541C85D26508E83_1602031427 = parser.formalTypeParameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1602031427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1602031427;
        // ---------- Original Method ----------
        //GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        //parser.parseForClass(this, getSignatureAttribute());
        //return parser.formalTypeParameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.911 -0400", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "1C3CA2D16DAC1EE13763EAAD26A57933")
    public boolean isAnnotation() {
        int ACC_ANNOTATION;
        ACC_ANNOTATION = 0x2000;
        int mod;
        mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_822614122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_822614122;
        // ---------- Original Method ----------
        //final int ACC_ANNOTATION = 0x2000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_ANNOTATION) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.912 -0400", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "42687E1943DDFF9FAFDBA230BFC9B70A")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        {
            boolean varEEBC1240FDA40BFAEAACBFB89D6281AF_1470494193 = (isDeclaredAnnotationPresent(annotationType));
        } //End collapsed parenthetic
        {
            boolean var29D87B80E530DF4C50E30AC2EB8C6CFB_329172642 = (annotationType.isDeclaredAnnotationPresent(Inherited.class));
            {
                {
                    Class<?> sup;
                    sup = getSuperclass();
                    sup = sup.getSuperclass();
                    {
                        {
                            boolean var9601F0FC9454A2DF6984664914F9F810_1773631726 = (sup.isDeclaredAnnotationPresent(annotationType));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116398143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116398143;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.912 -0400", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "D4CFF5143828BC39857A2EC884626033")
    public boolean isAnonymousClass() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1217930953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1217930953;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.912 -0400", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "600DEFD3DF156F902425D05A307EFFB2")
    public boolean isArray() {
        boolean var9F61AD98F70F910DD07C7CB078A688AE_401794276 = (getComponentType() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1662912992 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1662912992;
        // ---------- Original Method ----------
        //return getComponentType() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.913 -0400", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "47B700E6FBC572E8EAD28768ECC52EE7")
    public boolean isAssignableFrom(Class<?> cls) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1053936028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1053936028;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.913 -0400", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "57BD38C5F2BCDF142100EA360F77E94E")
    public boolean isEnum() {
        boolean var12ECA463BB0095D0882BCBC30CA80AD1_669955099 = (((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713647749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713647749;
        // ---------- Original Method ----------
        //return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.913 -0400", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "595F8268C953D5391CB7536850AAA3AD")
    public boolean isInstance(Object object) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698220474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698220474;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.913 -0400", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "9128A043E95CE5F1F11EC796AA35DC42")
    public boolean isInterface() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557594763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557594763;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.925 -0400", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "177183C54D8F5A2278B33727C55C8878")
    public boolean isLocalClass() {
        boolean enclosed;
        enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        boolean varAA6243A3A6D5A82E5F77D3D9BE30067E_921271256 = (enclosed && !isAnonymousClass());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345982263 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345982263;
        // ---------- Original Method ----------
        //boolean enclosed = (getEnclosingMethod() != null ||
                         //getEnclosingConstructor() != null);
        //return enclosed && !isAnonymousClass();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.926 -0400", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "3693EC67AE5723ABDCFD9E22E109C989")
    public boolean isMemberClass() {
        boolean varD300F2653B6225A244F27A67DCB40753_613804937 = (getDeclaringClass() != null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303712002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303712002;
        // ---------- Original Method ----------
        //return getDeclaringClass() != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.926 -0400", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "42D0A7A9C5B5DAF85740C2A46CFD7828")
    public boolean isPrimitive() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685476709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685476709;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.926 -0400", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "F296B11DAE5024A28F827127332D6DE5")
    public boolean isSynthetic() {
        int ACC_SYNTHETIC;
        ACC_SYNTHETIC = 0x1000;
        int mod;
        mod = getModifiers(this, true);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937602445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_937602445;
        // ---------- Original Method ----------
        //final int ACC_SYNTHETIC = 0x1000;
        //int mod = getModifiers(this, true);
        //return (mod & ACC_SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.927 -0400", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "F145DE504AA69A3726B3AFA47B385A9F")
    public T newInstance() throws InstantiationException, IllegalAccessException {
        T varB4EAC82CA7396A68D541C85D26508E83_310924844 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310924844 = newInstanceImpl();
        varB4EAC82CA7396A68D541C85D26508E83_310924844.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310924844;
        // ---------- Original Method ----------
        //return newInstanceImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.927 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.928 -0400", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "E95501A6A36B94CC4A31AB9CEFBFBC2D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1322646300 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_492181668 = null; //Variable for return #2
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_663765014 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1322646300 = getSimpleName();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_492181668 = (isInterface() ? "interface " : "class ") + getName();
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1805961392; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1805961392 = varB4EAC82CA7396A68D541C85D26508E83_1322646300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1805961392 = varB4EAC82CA7396A68D541C85D26508E83_492181668;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1805961392.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1805961392;
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return getSimpleName();
        //} else {
            //return (isInterface() ? "interface " : "class ") + getName();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.928 -0400", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "B3FCEBD9B8C88A58AC12F524F4DEDAF3")
    public Package getPackage() {
        Package varB4EAC82CA7396A68D541C85D26508E83_1112234009 = null; //Variable for return #1
        Package varB4EAC82CA7396A68D541C85D26508E83_758362673 = null; //Variable for return #2
        ClassLoader loader;
        loader = getClassLoader();
        {
            String name;
            name = getName();
            int dot;
            dot = name.lastIndexOf('.');
            varB4EAC82CA7396A68D541C85D26508E83_1112234009 = (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_758362673 = null;
        Package varA7E53CE21691AB073D9660D615818899_704303022; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_704303022 = varB4EAC82CA7396A68D541C85D26508E83_1112234009;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_704303022 = varB4EAC82CA7396A68D541C85D26508E83_758362673;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_704303022.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_704303022;
        // ---------- Original Method ----------
        //ClassLoader loader = getClassLoader();
        //if (loader != null) {
            //String name = getName();
            //int dot = name.lastIndexOf('.');
            //return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.929 -0400", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "CAD058543C47D260341AB7B5F1371B6B")
    public boolean desiredAssertionStatus() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190776129 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190776129;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.942 -0400", hash_original_method = "500D2CEF070061FBCB8343E3F70AD3A9", hash_generated_method = "5BD2AD12B2A9DEDFD6AF3691435AFECD")
    @SuppressWarnings("unchecked")
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        Class<? extends U> varB4EAC82CA7396A68D541C85D26508E83_2010490016 = null; //Variable for return #1
        {
            boolean varE62FF236193AD694C6D580397D58A801_1850405064 = (clazz.isAssignableFrom(this));
            {
                varB4EAC82CA7396A68D541C85D26508E83_2010490016 = (Class<? extends U>)this;
            } //End block
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = this.getName();
        String desiredClassName;
        desiredClassName = clazz.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(clazz.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2010490016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010490016;
        // ---------- Original Method ----------
        //if (clazz.isAssignableFrom(this)) {
            //return (Class<? extends U>)this;
        //}
        //String actualClassName = this.getName();
        //String desiredClassName = clazz.getName();
        //throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.944 -0400", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "9E4CFF06FDBDE325FA2B87CBEECF4D26")
    @SuppressWarnings("unchecked")
    public T cast(Object obj) {
        T varB4EAC82CA7396A68D541C85D26508E83_1015764805 = null; //Variable for return #1
        T varB4EAC82CA7396A68D541C85D26508E83_673380370 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1015764805 = null;
        } //End block
        {
            boolean var907E47EFDDB74A366DA8DC9B84DCA605_650670251 = (this.isInstance(obj));
            {
                varB4EAC82CA7396A68D541C85D26508E83_673380370 = (T)obj;
            } //End block
        } //End collapsed parenthetic
        String actualClassName;
        actualClassName = obj.getClass().getName();
        String desiredClassName;
        desiredClassName = this.getName();
        if (DroidSafeAndroidRuntime.control) throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
        addTaint(obj.getTaint());
        T varA7E53CE21691AB073D9660D615818899_388277674; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_388277674 = varB4EAC82CA7396A68D541C85D26508E83_1015764805;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_388277674 = varB4EAC82CA7396A68D541C85D26508E83_673380370;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_388277674.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_388277674;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.945 -0400", hash_original_field = "07BD6CDA090731A5E103F68AD0EAE9F3", hash_generated_field = "79A8A79C6AD7FD652944D6250D95257F")

    private static long serialVersionUID = 3206093459760846163L;
}

