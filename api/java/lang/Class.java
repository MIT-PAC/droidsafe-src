package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * Returns a {@code Class} object which represents the class with the
     * specified name. The name should be the name of a class as described in
     * the {@link Class class definition}; however, {@code Class}es representing
     * primitive types can not be found using this method.
     * <p>
     * If the class has not been loaded so far, it is being loaded and linked
     * first. This is done through either the class loader of the calling class
     * or one of its parent class loaders. The class is also being initialized,
     * which means that a possible static initializer block is executed.
     *
     * @param className
     *            the name of the non-primitive-type class to find.
     * @return the named {@code Class} instance.
     * @throws ClassNotFoundException
     *             if the requested class can not be found.
     * @throws LinkageError
     *             if an error occurs during linkage
     * @throws ExceptionInInitializerError
     *             if an exception occurs during static initialization of a
     *             class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.871 -0500", hash_original_method = "9BF97E3639356761488C43790786ED6D", hash_generated_method = "22AAAEA8B777BEFA6A0FBF037144BB50")
    
public static Class<?> forName(String className) throws ClassNotFoundException {
        return forName(className, true, VMStack.getCallingClassLoader());
    }

    /**
     * Returns a {@code Class} object which represents the class with the
     * specified name. The name should be the name of a class as described in
     * the {@link Class class definition}, however {@code Class}es representing
     * primitive types can not be found using this method. Security rules will
     * be obeyed.
     * <p>
     * If the class has not been loaded so far, it is being loaded and linked
     * first. This is done through either the specified class loader or one of
     * its parent class loaders. The caller can also request the class to be
     * initialized, which means that a possible static initializer block is
     * executed.
     *
     * @param className
     *            the name of the non-primitive-type class to find.
     * @param initializeBoolean
     *            indicates whether the class should be initialized.
     * @param classLoader
     *            the class loader to use to load the class.
     * @return the named {@code Class} instance.
     * @throws ClassNotFoundException
     *             if the requested class can not be found.
     * @throws LinkageError
     *             if an error occurs during linkage
     * @throws ExceptionInInitializerError
     *             if an exception occurs during static initialization of a
     *             class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.874 -0500", hash_original_method = "007FA0806960DEBB516C0AC4BBAC43FF", hash_generated_method = "96F9103EAAF63D703BB0D402C06D3482")
    
public static Class<?> forName(String className, boolean initializeBoolean,
            ClassLoader classLoader) throws ClassNotFoundException {

        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        // Catch an Exception thrown by the underlying native code. It wraps
        // up everything inside a ClassNotFoundException, even if e.g. an
        // Error occurred during initialization. This as a workaround for
        // an ExceptionInInitilaizerError that's also wrapped. It is actually
        // expected to be thrown. Maybe the same goes for other errors.
        // Not wrapping up all the errors will break android though.
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

    
    @DSModeled(DSC.BAN)
    private static ClassLoader getClassLoader(Class<?> clazz) {
    	return clazz.getClassLoader();
    }

    
    @DSModeled(DSC.BAN)
    private static Class<?>[] getDeclaredClasses(Class<?> clazz, boolean publicOnly) {
    	Class[] ret = new Class[0];
    	ret.addTaint(clazz.taint);
    	ret.addTaint(publicOnly);
    	return ret;
    }

    
    @DSModeled(DSC.BAN)
    private static <T> Constructor<T>[] getDeclaredConstructors(
            Class<T> clazz, boolean publicOnly) {
    	Constructor[] ret = new Constructor[0];
    	ret.addTaint(clazz.taint);
    	ret.addTaint(publicOnly);
    	return ret;
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
    private static int getModifiers(Class<?> clazz, boolean ignoreInnerClassesAttrib) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_64442902;
    }

    
    @DSModeled(DSC.SAFE)
    private static <T extends Object> T[] arraycopy(T[] result, T[] head, T[] tail) {
        System.arraycopy(head, 0, result, 0, head.length);
        System.arraycopy(tail, 0, result, head.length, tail.length);
        return result;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.857 -0500", hash_original_field = "5345B2523025935E4E520B1555936347", hash_generated_field = "A2E36971CC30DE91D1AF4E9C02F420A3")


    private static final long serialVersionUID = 3206093459760846163L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.860 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "0C932604663D7874D47A840F24BC4843")

    private transient String name;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:44.490 -0400", hash_original_method = "290C4C92EA00F4559290C8F8CF6D9B35", hash_generated_method = "E946603C401B0F4C9A405067C69B1976")
	public  Class() {
        // ---------- Original Method ----------
    }

    /**
     * Get the Signature attribute for this class.  Returns null if not found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.865 -0500", hash_original_method = "D48BE9AB17D8906757B56E4D680A2C57", hash_generated_method = "B78AD642016FCC1825F3A1A209AE1A79")
    
private String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation();

        if (annotation == null) {
            return null;
        }

        return StringUtils.combineStrings(annotation);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.692 -0400", hash_original_method = "D517197DC7BA53960E7471B1FA197117", hash_generated_method = "580560D142C0CD8EEA5AC831F856A095")
    private Object[] getSignatureAnnotation() {
    	Object[] foo = new Object[0];
    	foo.addTaint(this.taint);
    	return foo;
    }

    /**
     * Returns an array containing {@code Class} objects for all public classes
     * and interfaces that are members of this class. This includes public
     * members inherited from super classes and interfaces. If there are no such
     * class members or if this object represents a primitive type then an array
     * of length 0 is returned.
     *
     * @return the public class members of the class represented by this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.881 -0500", hash_original_method = "0A5E0D64FA55612B299C6956628C149D", hash_generated_method = "D7203C509B77A1072C11ED193F651546")
    
public Class<?>[] getClasses() {
        return getFullListOfClasses(true);
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

    /**
     * Returns all the annotations of this class. If there are no annotations
     * then an empty array is returned.
     *
     * @return a copy of the array containing this class' annotations.
     * @see #getDeclaredAnnotations()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.887 -0500", hash_original_method = "214E042C121A5AA68E2A99AA55DE15AA", hash_generated_method = "6FD3E304A8DF098A20CB6436606F5062")
    
public Annotation[] getAnnotations() {
        /*
         * We need to get the annotations declared on this class, plus the
         * annotations from superclasses that have the "@Inherited" annotation
         * set.  We create a temporary map to use while we accumulate the
         * annotations and convert it to an array at the end.
         *
         * It's possible to have duplicates when annotations are inherited.
         * We use a Map to filter those out.
         *
         * HashMap might be overkill here.
         */
        HashMap<Class, Annotation> map = new HashMap<Class, Annotation>();
        Annotation[] declaredAnnotations = getDeclaredAnnotations();

        for (int i = declaredAnnotations.length-1; i >= 0; --i) {
            map.put(declaredAnnotations[i].annotationType(), declaredAnnotations[i]);
        }
        for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
            declaredAnnotations = sup.getDeclaredAnnotations();
            for (int i = declaredAnnotations.length-1; i >= 0; --i) {
                Class<?> clazz = declaredAnnotations[i].annotationType();
                if (!map.containsKey(clazz) && clazz.isAnnotationPresent(Inherited.class)) {
                    map.put(clazz, declaredAnnotations[i]);
                }
            }
        }

        /* convert annotation values from HashMap to array */
        Collection<Annotation> coll = map.values();
        return coll.toArray(new Annotation[coll.size()]);
    }

    /**
     * Returns the canonical name of this class. If this class does not have a
     * canonical name as defined in the Java Language Specification, then the
     * method returns {@code null}.
     *
     * @return this class' canonical name, or {@code null} if it does not have a
     *         canonical name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.889 -0500", hash_original_method = "79C3FAE0B22F6799153600E0BD41AE53", hash_generated_method = "D53A66E2D95F9FCB432551D2F3BDDC4D")
    
public String getCanonicalName() {
        if (isLocalClass() || isAnonymousClass())
            return null;

        if (isArray()) {
            /*
             * The canonical name of an array type depends on the (existence of)
             * the component type's canonical name.
             */
            String name = getComponentType().getCanonicalName();
            if (name != null) {
                return name + "[]";
            }
        } else if (isMemberClass()) {
            /*
             * The canonical name of an inner class depends on the (existence
             * of) the declaring class' canonical name.
             */
            String name = getDeclaringClass().getCanonicalName();
            if (name != null) {
                return name + "." + getSimpleName();
            }
        } else {
            /*
             * The canonical name of a top-level class or primitive type is
             * equal to the fully qualified name.
             */
            return getName();
        }

        /*
         * Other classes don't have a canonical name.
         */
        return null;
    }

    /**
     * Returns the class loader which was used to load the class represented by
     * this {@code Class}. Implementations are free to return {@code null} for
     * classes that were loaded by the bootstrap class loader. The Android
     * reference implementation, though, returns a reference to an actual
     * representation of the bootstrap class loader.
     *
     * @return the class loader for the represented class.
     * @see ClassLoader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.892 -0500", hash_original_method = "3030130FFB93A0C1BBA3E92339DE84EE", hash_generated_method = "B0FEF2208E9859EF6D970383264412F7")
    
public ClassLoader getClassLoader() {
        if (this.isPrimitive()) {
            return null;
        }

        ClassLoader loader = getClassLoaderImpl();
        if (loader == null) {
            loader = BootClassLoader.getInstance();
        }
        return loader;
    }

    /**
     * This must be provided by the VM vendor, as it is used by other provided
     * class implementations in this package. Outside of this class, it is used
     * by SecurityManager.classLoaderDepth(),
     * currentClassLoader() and currentLoadedClass(). Return the ClassLoader for
     * this Class without doing any security checks. The bootstrap ClassLoader
     * is returned, unlike getClassLoader() which returns null in place of the
     * bootstrap ClassLoader.
     *
     * @return the ClassLoader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.894 -0500", hash_original_method = "CA71AD82665CF5FC19F2861C6018C612", hash_generated_method = "CA71AD82665CF5FC19F2861C6018C612")
    
ClassLoader getClassLoaderImpl() {
        ClassLoader loader = getClassLoader(this);
        return loader == null ? BootClassLoader.getInstance() : loader;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.699 -0400", hash_original_method = "A6D69727DF0CDE095BD59CFD60FF06ED", hash_generated_method = "CDEED6F065A507A7FECB927A85CD4D66")
    public Class<?> getComponentType() {
    	Class<?> cl = (Class)new Object();
    	cl.addTaint(this.taint);
    	return cl;
    }

    /**
     * Returns a {@code Constructor} object which represents the public
     * constructor matching the specified parameter types.
     *
     * @param parameterTypes
     *            the parameter types of the requested constructor.
     *            {@code (Class[]) null} is equivalent to the empty array.
     * @return the constructor described by {@code parameterTypes}.
     * @throws NoSuchMethodException
     *             if the constructor can not be found.
     * @see #getDeclaredConstructor(Class[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.905 -0500", hash_original_method = "F0845B6DA735A4C36F51E7CB08D1D9A7", hash_generated_method = "2060266FA2D0F6DCF32A8D8414835B9B")
    
@SuppressWarnings("unchecked")
    public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException {
        return (Constructor) getConstructorOrMethod("<init>", false, true, parameterTypes);
    }

    /**
     * Returns a constructor or method with the specified name.
     *
     * @param name the method name, or "<init>" to return a constructor.
     * @param recursive true to search supertypes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.908 -0500", hash_original_method = "4EF95E7321A9A3F23E7914021D1D63A7", hash_generated_method = "98A59BB2F64617285B92F7E1C4D1EF02")
    
private Member getConstructorOrMethod(String name, boolean recursive,
            boolean publicOnly, Class<?>[] parameterTypes) throws NoSuchMethodException {
        if (recursive && !publicOnly) {
            throw new AssertionError(); // can't lookup non-public members recursively
        }
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        if (parameterTypes == null) {
            parameterTypes = EmptyArray.CLASS;
        }
        for (Class<?> c : parameterTypes) {
            if (c == null) {
                throw new NoSuchMethodException("parameter type is null");
            }
        }
        Member result = recursive
                ? getPublicConstructorOrMethodRecursive(name, parameterTypes)
                : Class.getDeclaredConstructorOrMethod(this, name, parameterTypes);
        if (result == null || publicOnly && (result.getModifiers() & Modifier.PUBLIC) == 0) {
            throw new NoSuchMethodException(name + " " + Arrays.toString(parameterTypes));
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.912 -0500", hash_original_method = "388841491B60993DDBB0AE9912E3B4BA", hash_generated_method = "619CFCA5B6AB6934299A174E960CA98B")
    
private Member getPublicConstructorOrMethodRecursive(String name, Class<?>[] parameterTypes) {
        // search superclasses
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            Member result = Class.getDeclaredConstructorOrMethod(c, name, parameterTypes);
            if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                return result;
            }
        }

        // search implemented interfaces
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Class<?> ifc : c.getInterfaces()) {
                Member result = ifc.getPublicConstructorOrMethodRecursive(name, parameterTypes);
                if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                    return result;
                }
            }
        }

        return null;
    }

    /**
     * Returns an array containing {@code Constructor} objects for all public
     * constructors for the class represented by this {@code Class}. If there
     * are no public constructors or if this {@code Class} represents an array
     * class, a primitive type or void then an empty array is returned.
     *
     * @return an array with the public constructors of the class represented by
     *         this {@code Class}.
     * @see #getDeclaredConstructors()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.914 -0500", hash_original_method = "A702CB469FC49B7BFA8C73D523E80DBC", hash_generated_method = "C6285A2293FC0FC9E24ABE031CAEAF52")
    
public Constructor<?>[] getConstructors() {
        return getDeclaredConstructors(this, true);
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

    /**
     * Returns true if the annotation exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.924 -0500", hash_original_method = "172017F5B780130A5E2B4C50427437CE", hash_generated_method = "BAF0A1CF7EF8BA29691E3C8313FFA064")
    
    private boolean isDeclaredAnnotationPresent(Class<? extends Annotation> annotationClass){
    	//Formerly a native method
    	addTaint(annotationClass.getTaint());
    	return getTaintBoolean();
    }


    /**
     * Returns an array containing {@code Class} objects for all classes and
     * interfaces that are declared as members of the class which this {@code
     * Class} represents. If there are no classes or interfaces declared or if
     * this class represents an array class, a primitive type or void, then an
     * empty array is returned.
     *
     * @return an array with {@code Class} objects for all the classes and
     *         interfaces that are used in member declarations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.928 -0500", hash_original_method = "0C6BF22DB8EB38DEB860C0E90FF64AEC", hash_generated_method = "7AE1F5EBD013B58268EBCB9E63397A2E")
    
public Class<?>[] getDeclaredClasses() {
        return getDeclaredClasses(this, false);
    }

    /*
     * Returns the list of member classes without performing any security checks
     * first. This includes the member classes inherited from superclasses. If no
     * member classes exist at all, an empty array is returned.
     *
     * @param publicOnly reflects whether we want only public members or all of them
     * @return the list of classes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.930 -0500", hash_original_method = "11EF0E91CA4D1D0CA140D53473DE14D1", hash_generated_method = "741370FF0451A2D498B788FAEA4EB5D6")
    
private Class<?>[] getFullListOfClasses(boolean publicOnly) {
        Class<?>[] result = getDeclaredClasses(this, publicOnly);

        // Traverse all superclasses
        Class<?> clazz = this.getSuperclass();
        while (clazz != null) {
            Class<?>[] temp = getDeclaredClasses(clazz, publicOnly);
            if (temp.length != 0) {
                result = arraycopy(new Class[result.length + temp.length], result, temp);
            }

            clazz = clazz.getSuperclass();
        }

        return result;
    }

    /**
     * Returns a {@code Constructor} object which represents the constructor
     * matching the specified parameter types that is declared by the class
     * represented by this {@code Class}.
     *
     * @param parameterTypes
     *            the parameter types of the requested constructor.
     *            {@code (Class[]) null} is equivalent to the empty array.
     * @return the constructor described by {@code parameterTypes}.
     * @throws NoSuchMethodException
     *             if the requested constructor can not be found.
     * @see #getConstructor(Class[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.937 -0500", hash_original_method = "BE852690AE0E27D0B9CC0DDC2FD443E4", hash_generated_method = "D0D731FB6821D6C0AB12837A56C6FE11")
    
@SuppressWarnings("unchecked")
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
            throws NoSuchMethodException {
        return (Constructor) getConstructorOrMethod("<init>", false, false, parameterTypes);
    }

    /**
     * Returns an array containing {@code Constructor} objects for all
     * constructors declared in the class represented by this {@code Class}. If
     * there are no constructors or if this {@code Class} represents an array
     * class, a primitive type or void then an empty array is returned.
     *
     * @return an array with the constructors declared in the class represented
     *         by this {@code Class}.
     * @see #getConstructors()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.939 -0500", hash_original_method = "689106DC2122D9CD807ABDF15BAA670D", hash_generated_method = "A5160AEFF05AA595A8F6FC2468B59CF6")
    
public Constructor<?>[] getDeclaredConstructors() {
        return getDeclaredConstructors(this, false);
    }

    /**
     * Returns a {@code Field} object for the field with the specified name
     * which is declared in the class represented by this {@code Class}.
     *
     * @param name the name of the requested field.
     * @return the requested field in the class represented by this class.
     * @throws NoSuchFieldException if the requested field can not be found.
     * @see #getField(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.945 -0500", hash_original_method = "8A682798BA4F3E7A7CABB0F16EFFEE4D", hash_generated_method = "C66D19B472FEF5D13D7F4877F2BBF29A")
    
public Field getDeclaredField(String name) throws NoSuchFieldException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        Field result = getDeclaredField(this, name);
        if (result == null) {
            throw new NoSuchFieldException(name);
        }
        return result;
    }

    /**
     * Returns an array containing {@code Field} objects for all fields declared
     * in the class represented by this {@code Class}. If there are no fields or
     * if this {@code Class} represents an array class, a primitive type or void
     * then an empty array is returned.
     *
     * @return an array with the fields declared in the class represented by
     *         this class.
     * @see #getFields()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.948 -0500", hash_original_method = "AA99B76B619CDC6E346F586A8911140C", hash_generated_method = "28B58F0009A6BCAB227105536EC99296")
    
public Field[] getDeclaredFields() {
        return getDeclaredFields(this, false);
    }

    /**
     * Returns a {@code Method} object which represents the method matching the
     * specified name and parameter types that is declared by the class
     * represented by this {@code Class}.
     *
     * @param name
     *            the requested method's name.
     * @param parameterTypes
     *            the parameter types of the requested method.
     *            {@code (Class[]) null} is equivalent to the empty array.
     * @return the method described by {@code name} and {@code parameterTypes}.
     * @throws NoSuchMethodException
     *             if the requested constructor can not be found.
     * @throws NullPointerException
     *             if {@code name} is {@code null}.
     * @see #getMethod(String, Class[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.959 -0500", hash_original_method = "03F26499B4401EE2D953FCB368DE68F4", hash_generated_method = "D43A7411BC634182976F9568E4280AC1")
    
public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
            throws NoSuchMethodException {
        Member member = getConstructorOrMethod(name, false, false, parameterTypes);
        if (member instanceof Constructor) {
            throw new NoSuchMethodException(name);
        }
        return (Method) member;
    }

    /**
     * Returns an array containing {@code Method} objects for all methods
     * declared in the class represented by this {@code Class}. If there are no
     * methods or if this {@code Class} represents an array class, a primitive
     * type or void then an empty array is returned.
     *
     * @return an array with the methods declared in the class represented by
     *         this {@code Class}.
     * @see #getMethods()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.961 -0500", hash_original_method = "76B8AECB3C8722E0C9050BEEFD88DA1C", hash_generated_method = "C0886B96300C43CFB5185B9FE17032D3")
    
public Method[] getDeclaredMethods() {
        return getDeclaredMethods(this, false);
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

    /**
     * Gets the {@code enum} constants associated with this {@code Class}.
     * Returns {@code null} if this {@code Class} does not represent an {@code
     * enum} type.
     *
     * @return an array with the {@code enum} constants or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.987 -0500", hash_original_method = "4BAB4756A542B5987CFE5A9EBB7771C0", hash_generated_method = "501C2BA0B65CD7CC10B3624A12BF9703")
    
@SuppressWarnings("unchecked") // we only cast after confirming that this class is an enum
    public T[] getEnumConstants() {
        if (!isEnum()) {
            return null;
        }
        return (T[]) Enum.getSharedConstants((Class) this).clone();
    }

    /**
     * Returns a {@code Field} object which represents the public field with the
     * specified name. This method first searches the class C represented by
     * this {@code Class}, then the interfaces implemented by C and finally the
     * superclasses of C.
     *
     * @param name
     *            the name of the requested field.
     * @return the public field specified by {@code name}.
     * @throws NoSuchFieldException
     *             if the field can not be found.
     * @see #getDeclaredField(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.990 -0500", hash_original_method = "FA8DAD805A6C401E4747A9C743D605D2", hash_generated_method = "DFB95ADC3E3E5C8B3666944FA264C214")
    
public Field getField(String name) throws NoSuchFieldException {
        if (name == null) {
            throw new NullPointerException("name == null");
        }
        Field result = getPublicFieldRecursive(name);
        if (result == null) {
            throw new NoSuchFieldException(name);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.992 -0500", hash_original_method = "5B7CAA69F62F801E9329410682C5B334", hash_generated_method = "F3676BC6F341EBA853F3C761606E9195")
    
private Field getPublicFieldRecursive(String name) {
        // search superclasses
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            Field result = Class.getDeclaredField(c, name);
            if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                return result;
            }
        }

        // search implemented interfaces
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Class<?> ifc : c.getInterfaces()) {
                Field result = ifc.getPublicFieldRecursive(name);
                if (result != null && (result.getModifiers() & Modifier.PUBLIC) != 0) {
                    return result;
                }
            }
        }

        return null;
    }

    /**
     * Returns an array containing {@code Field} objects for all public fields
     * for the class C represented by this {@code Class}. Fields may be declared
     * in C, the interfaces it implements or in the superclasses of C. The
     * elements in the returned array are in no particular order.
     *
     * <p>If there are no public fields or if this class represents an array class,
     * a primitive type or {@code void} then an empty array is returned.
     *
     * @return an array with the public fields of the class represented by this
     *         {@code Class}.
     * @see #getDeclaredFields()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.995 -0500", hash_original_method = "EE852D72665161D6434FA53D37832A51", hash_generated_method = "B8AF57BF684DA5AEB97D474BC198A0CA")
    
public Field[] getFields() {
        List<Field> fields = new ArrayList<Field>();
        getPublicFieldsRecursive(fields);

        /*
         * The result may include duplicates when clazz implements an interface
         * through multiple paths. Remove those duplicates.
         */
        CollectionUtils.removeDuplicates(fields, Field.ORDER_BY_NAME_AND_DECLARING_CLASS);
        return fields.toArray(new Field[fields.size()]);
    }

    /**
     * Populates {@code result} with public fields defined by this class, its
     * superclasses, and all implemented interfaces.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.998 -0500", hash_original_method = "CCD964C4509A9C827773CB1F1BD75566", hash_generated_method = "22B82B382902708AC3C30359D5ED8391")
    
private void getPublicFieldsRecursive(List<Field> result) {
        // search superclasses
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Field field : Class.getDeclaredFields(c, true)) {
                result.add(field);
            }
        }

        // search implemented interfaces
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Class<?> ifc : c.getInterfaces()) {
                ifc.getPublicFieldsRecursive(result);
            }
        }
    }

    /**
     * Gets the {@link Type}s of the interfaces that this {@code Class} directly
     * implements. If the {@code Class} represents a primitive type or {@code
     * void} then an empty array is returned.
     *
     * @return an array of {@link Type} instances directly implemented by the
     *         class represented by this {@code class}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.001 -0500", hash_original_method = "A82263350C71E60DCD37A3953DD0C780", hash_generated_method = "A29F8C52D29EEC64FFAED8E112A51280")
    
public Type[] getGenericInterfaces() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        return Types.getClonedTypeArray(parser.interfaceTypes);
    }

    /**
     * Gets the {@code Type} that represents the superclass of this {@code
     * class}.
     *
     * @return an instance of {@code Type} representing the superclass.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.003 -0500", hash_original_method = "F49B4034A49DCE93E76B5D95ACE6523A", hash_generated_method = "F60C4EB1F233218BED00254491D8F23F")
    
public Type getGenericSuperclass() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        return Types.getType(parser.superclassType);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.741 -0400", hash_original_method = "CF68E335012F7245AD886A1F59EC18C3", hash_generated_method = "2692A665379A2F86FF3326F5F5EB1B7B")
    public Class<?>[] getInterfaces() {
    	Class[] ret = new Class[0];
    	return ret;
    }

    /**
     * Returns a {@code Method} object which represents the public method with
     * the specified name and parameter types. This method first searches the
     * class C represented by this {@code Class}, then the superclasses of C and
     * finally the interfaces implemented by C and finally the superclasses of C
     * for a method with matching name.
     *
     * @param name
     *            the requested method's name.
     * @param parameterTypes
     *            the parameter types of the requested method.
     *            {@code (Class[]) null} is equivalent to the empty array.
     * @return the public field specified by {@code name}.
     * @throws NoSuchMethodException
     *             if the method can not be found.
     * @see #getDeclaredMethod(String, Class[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.010 -0500", hash_original_method = "8DB3D81F35D9B25D91AF567693EFE9FF", hash_generated_method = "F6FE7925D7C8D66FCFBB28D88158DAE4")
    
public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException {
        Member member = getConstructorOrMethod(name, true, true, parameterTypes);
        if (member instanceof Constructor) {
            throw new NoSuchMethodException(name);
        }
        return (Method) member;
    }

    /**
     * Returns an array containing {@code Method} objects for all public methods
     * for the class C represented by this {@code Class}. Methods may be
     * declared in C, the interfaces it implements or in the superclasses of C.
     * The elements in the returned array are in no particular order.
     * <p>
     * If there are no public methods or if this {@code Class} represents a
     * primitive type or {@code void} then an empty array is returned.
     * </p>
     *
     * @return an array with the methods of the class represented by this
     *         {@code Class}.
     * @see #getDeclaredMethods()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.012 -0500", hash_original_method = "C97EB7E8DB296134D4BC8E9F9CBD0F21", hash_generated_method = "16F5EFC638AA638137B136FC5EE069E5")
    
public Method[] getMethods() {
        List<Method> methods = new ArrayList<Method>();
        getPublicMethodsRecursive(methods);

        /*
         * Remove methods defined by multiple types, preferring to keep methods
         * declared by derived types.
         */
        CollectionUtils.removeDuplicates(methods, Method.ORDER_BY_SIGNATURE);
        return methods.toArray(new Method[methods.size()]);
    }

    /**
     * Populates {@code result} with public methods defined by {@code clazz}, its
     * superclasses, and all implemented interfaces, including overridden methods.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.015 -0500", hash_original_method = "99CBF7E189E92697D7579B92856775ED", hash_generated_method = "F7C8E7FB5A1E5F59BD59B5D6B127FD35")
    
private void getPublicMethodsRecursive(List<Method> result) {
        // search superclasses
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Method method : Class.getDeclaredMethods(c, true)) {
                result.add(method);
            }
        }

        // search implemented interfaces
        for (Class<?> c = this; c != null; c = c.getSuperclass()) {
            for (Class<?> ifc : c.getInterfaces()) {
                ifc.getPublicMethodsRecursive(result);
            }
        }
    }

    /**
     * Returns an integer that represents the modifiers of the class represented
     * by this {@code Class}. The returned value is a combination of bits
     * defined by constants in the {@link Modifier} class.
     *
     * @return the modifiers of the class represented by this {@code Class}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.018 -0500", hash_original_method = "49C2E28E402D8BB5DB2322E2416CA9ED", hash_generated_method = "41DF567D91CEAD08F40DC4816EDC53B5")
    
public int getModifiers() {
        return getModifiers(this, false);
    }

    /**
     * Returns the name of the class represented by this {@code Class}. For a
     * description of the format which is used, see the class definition of
     * {@link Class}.
     *
     * @return the name of the class represented by this {@code Class}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.024 -0500", hash_original_method = "187913D585B2E6CDD83B5D111AE83BCF", hash_generated_method = "17A7776BBC6BDB5FF5C2292D74566F63")
    
public String getName() {
        String result = name;
        return (result == null) ? (name = getNameNative()) : result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.755 -0400", hash_original_method = "31D33A7314A957E536E7D171A57CAB24", hash_generated_method = "D2A1F2570A688E342CB66374B5D563FA")
    private String getNameNative() {
    	String ret = new String();
    	return ret;
    }

    /**
     * Returns the simple name of the class represented by this {@code Class} as
     * defined in the source code. If there is no name (that is, the class is
     * anonymous) then an empty string is returned. If the receiver is an array
     * then the name of the underlying type with square braces appended (for
     * example {@code "Integer[]"}) is returned.
     *
     * @return the simple name of the class represented by this {@code Class}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.030 -0500", hash_original_method = "74B632DBB542B67A6D43387B2BA8D973", hash_generated_method = "5F5DA6A35D4A0CEBE565D4944B684DD0")
    
public String getSimpleName() {
        if (isArray()) {
            return getComponentType().getSimpleName() + "[]";
        }

        String name = getName();

        if (isAnonymousClass()) {
            return "";
        }

        if (isMemberClass() || isLocalClass()) {
            return getInnerClassName();
        }

        int dot = name.lastIndexOf('.');
        if (dot != -1) {
            return name.substring(dot + 1);
        }

        return name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.757 -0400", hash_original_method = "0DFF052FEDA74158169D3F5C3A6A31A3", hash_generated_method = "E15F8A7CFFBAA6A8E91B4004366ED98B")
    private String getInnerClassName() {
    	String ret = new String();
    	return ret;
    }

    /**
     * Returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.036 -0500", hash_original_method = "82F23D377D0B35BD25A884E70716090D", hash_generated_method = "8028A3F866A0CBD6BC2B22F8EEDAE4A1")
    
public ProtectionDomain getProtectionDomain() {
        return null;
    }

    /**
     * Returns the URL of the resource specified by {@code resName}. The mapping
     * between the resource name and the URL is managed by the class' class
     * loader.
     *
     * @param resName
     *            the name of the resource.
     * @return the requested resource's {@code URL} object or {@code null} if
     *         the resource can not be found.
     * @see ClassLoader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.040 -0500", hash_original_method = "98759567E5146872E262AEC3A30D35ED", hash_generated_method = "473C6F76FA3F6B45C570D7E720A53585")
    
public URL getResource(String resName) {
        // Get absolute resource name, but without the leading slash
        if (resName.startsWith("/")) {
            resName = resName.substring(1);
        } else {
            String pkg = getName();
            int dot = pkg.lastIndexOf('.');
            if (dot != -1) {
                pkg = pkg.substring(0, dot).replace('.', '/');
            } else {
                pkg = "";
            }

            resName = pkg + "/" + resName;
        }

        // Delegate to proper class loader
        ClassLoader loader = getClassLoader();
        if (loader != null) {
            return loader.getResource(resName);
        } else {
            return ClassLoader.getSystemResource(resName);
        }
    }

    /**
     * Returns a read-only stream for the contents of the resource specified by
     * {@code resName}. The mapping between the resource name and the stream is
     * managed by the class' class loader.
     *
     * @param resName
     *            the name of the resource.
     * @return a stream for the requested resource or {@code null} if no
     *         resource with the specified name can be found.
     * @see ClassLoader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.042 -0500", hash_original_method = "A39605B8A15ACAEBE8FD794856699A1B", hash_generated_method = "86CEEF39D17B80ED6EB9C612DF444F82")
    
public InputStream getResourceAsStream(String resName) {
        // Get absolute resource name, but without the leading slash
        if (resName.startsWith("/")) {
            resName = resName.substring(1);
        } else {
            String pkg = getName();
            int dot = pkg.lastIndexOf('.');
            if (dot != -1) {
                pkg = pkg.substring(0, dot).replace('.', '/');
            } else {
                pkg = "";
            }

            resName = pkg + "/" + resName;
        }

        // Delegate to proper class loader
        ClassLoader loader = getClassLoader();
        if (loader != null) {
            return loader.getResourceAsStream(resName);
        } else {
            return ClassLoader.getSystemResourceAsStream(resName);
        }
    }

    /**
     * Returns null. (On Android, a {@code ClassLoader} can load classes from multiple dex files.
     * All classes from any given dex file will have the same signers, but different dex
     * files may have different signers. This does not fit well with the original
     * {@code ClassLoader}-based model of {@code getSigners}.)
     *
     * @return null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.045 -0500", hash_original_method = "23E1DD471F041FCBD863FD07CDFD9C50", hash_generated_method = "0FEDCEA57B2FDA4E2741434B8D686EE1")
    
public Object[] getSigners() {
        // See http://code.google.com/p/android/issues/detail?id=1766.
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.762 -0400", hash_original_method = "D842DF476A1BD7D94C0F81A98F8160A2", hash_generated_method = "6D7E91A123530C9789871A175E332FE3")
    public Class<? super T> getSuperclass() {
    	Class ret = (Class)new Object();
    	return ret;
    }

    /**
     * Returns an array containing {@code TypeVariable} objects for type
     * variables declared by the generic class represented by this {@code
     * Class}. Returns an empty array if the class is not generic.
     *
     * @return an array with the type variables of the class represented by this
     *         class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.051 -0500", hash_original_method = "6787AAB5FB05E26F36F8582CB719E4B5", hash_generated_method = "FB368A623C43001AF0F281EC8C9BB200")
    
@SuppressWarnings("unchecked")
    public synchronized TypeVariable<Class<T>>[] getTypeParameters() {
        GenericSignatureParser parser = new GenericSignatureParser(getClassLoader());
        parser.parseForClass(this, getSignatureAttribute());
        return parser.formalTypeParameters.clone();
    }

    /**
     * Indicates whether this {@code Class} represents an annotation class.
     *
     * @return {@code true} if this {@code Class} represents an annotation
     *         class; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.054 -0500", hash_original_method = "4ABCCCB32AED1EA36AB75BC1C1D6F00F", hash_generated_method = "0B1CE4556A32614313477B12988F56FD")
    
public boolean isAnnotation() {
        final int ACC_ANNOTATION = 0x2000;  // not public in reflect.Modifiers
        int mod = getModifiers(this, true);
        return (mod & ACC_ANNOTATION) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.056 -0500", hash_original_method = "0543735514B2514B55E5A7CA82A68F41", hash_generated_method = "16BE0F77EC97D1B9B2C1E188F15C5E73")
    
@Override public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        if (annotationType == null) {
            throw new NullPointerException("annotationType == null");
        }

        if (isDeclaredAnnotationPresent(annotationType)) {
            return true;
        }

        if (annotationType.isDeclaredAnnotationPresent(Inherited.class)) {
            for (Class<?> sup = getSuperclass(); sup != null; sup = sup.getSuperclass()) {
                if (sup.isDeclaredAnnotationPresent(annotationType)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Indicates whether the class represented by this {@code Class} is
     * anonymously declared.
     *
     * @return {@code true} if the class represented by this {@code Class} is
     *         anonymous; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.060 -0500", hash_original_method = "0B2F9CB5B3D3F1E238437E8B96C9A5C6", hash_generated_method = "6890CE8E012769B06F8E5B2F096E744B")
    
    public boolean isAnonymousClass(){
    	//Formerly a native method
    	return getTaintBoolean();
    }


    /**
     * Indicates whether the class represented by this {@code Class} is an array
     * class.
     *
     * @return {@code true} if the class represented by this {@code Class} is an
     *         array class; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.063 -0500", hash_original_method = "AA0408A05BAE9726C68A16303FDDA1C2", hash_generated_method = "295B3FD7BCB14D1F140029116A5683AB")
    
public boolean isArray() {
        return getComponentType() != null;
    }

    /**
     * Indicates whether the specified class type can be converted to the class
     * represented by this {@code Class}. Conversion may be done via an identity
     * conversion or a widening reference conversion (if either the receiver or
     * the argument represent primitive types, only the identity conversion
     * applies).
     *
     * @param cls
     *            the class to check.
     * @return {@code true} if {@code cls} can be converted to the class
     *         represented by this {@code Class}; {@code false} otherwise.
     * @throws NullPointerException
     *             if {@code cls} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.067 -0500", hash_original_method = "A1982F53FFC7DDA0FE0A72AB5EB8A2B7", hash_generated_method = "7D4144660EDDFA20785744BA037E6F04")
    
    public boolean isAssignableFrom(Class<?> cls){
    	//Formerly a native method
    	addTaint(cls.getTaint());
    	return getTaintBoolean();
    }


    /**
     * Indicates whether the class represented by this {@code Class} is an
     * {@code enum}.
     *
     * @return {@code true} if the class represented by this {@code Class} is an
     *         {@code enum}; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.069 -0500", hash_original_method = "52EC957E82FBDA76529AFBCF943E6548", hash_generated_method = "433854292DBBE11D1B7A199C41DDB4FD")
    
public boolean isEnum() {
        return ((getModifiers() & 0x4000) != 0) && (getSuperclass() == Enum.class);
    }

    /**
     * Indicates whether the specified object can be cast to the class
     * represented by this {@code Class}. This is the runtime version of the
     * {@code instanceof} operator.
     *
     * @param object
     *            the object to check.
     * @return {@code true} if {@code object} can be cast to the type
     *         represented by this {@code Class}; {@code false} if {@code
     *         object} is {@code null} or cannot be cast.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.073 -0500", hash_original_method = "D7FA1612842AB24E73A4821AC9A1116F", hash_generated_method = "A26710A54E7215882856758239B85A71")
    
    public boolean isInstance(Object object){
    	//Formerly a native method
    	addTaint(object.getTaint());
    	return getTaintBoolean();
    }


    /**
     * Indicates whether this {@code Class} represents an interface.
     *
     * @return {@code true} if this {@code Class} represents an interface;
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.076 -0500", hash_original_method = "FC0FA8D38BCF14F0E529954D267C8D44", hash_generated_method = "08D704271A4540C93EEA278831C40C7C")
    
    public boolean isInterface(){
    	//Formerly a native method
    	return getTaintBoolean();
    }


    /**
     * Indicates whether the class represented by this {@code Class} is defined
     * locally.
     *
     * @return {@code true} if the class represented by this {@code Class} is
     *         defined locally; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.079 -0500", hash_original_method = "3F7BF71CE24DC5396B729F24C64FF6F5", hash_generated_method = "106134B6F1D2F0617972FF12F0A7C885")
    
public boolean isLocalClass() {
        boolean enclosed = (getEnclosingMethod() != null ||
                         getEnclosingConstructor() != null);
        return enclosed && !isAnonymousClass();
    }

    /**
     * Indicates whether the class represented by this {@code Class} is a member
     * class.
     *
     * @return {@code true} if the class represented by this {@code Class} is a
     *         member class; {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.081 -0500", hash_original_method = "C60F72E8D565680EAC577743F2D63678", hash_generated_method = "ED77BF92668C44C3CF8FD9420EB90C99")
    
public boolean isMemberClass() {
        return getDeclaringClass() != null;
    }

    /**
     * Indicates whether this {@code Class} represents a primitive type.
     *
     * @return {@code true} if this {@code Class} represents a primitive type;
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.085 -0500", hash_original_method = "8FF8B3D321E9B47A5AC7E5D4DF30BFE3", hash_generated_method = "5DA70992F03DF30911CCCBF32E05030B")
    
    public boolean isPrimitive(){
    	//Formerly a native method
    	return getTaintBoolean();
    }


    /**
     * Indicates whether this {@code Class} represents a synthetic type.
     *
     * @return {@code true} if this {@code Class} represents a synthetic type;
     *         {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.088 -0500", hash_original_method = "022E776606079BC3CFEA0634201C3D50", hash_generated_method = "610ED7C0D1FA396EDA2EE5DFF7D56D3A")
    
public boolean isSynthetic() {
        final int ACC_SYNTHETIC = 0x1000;   // not public in reflect.Modifiers
        int mod = getModifiers(this, true);
        return (mod & ACC_SYNTHETIC) != 0;
    }

    /**
     * Returns a new instance of the class represented by this {@code Class},
     * created by invoking the default (that is, zero-argument) constructor. If
     * there is no such constructor, or if the creation fails (either because of
     * a lack of available memory or because an exception is thrown by the
     * constructor), an {@code InstantiationException} is thrown. If the default
     * constructor exists but is not accessible from the context where this
     * method is invoked, an {@code IllegalAccessException} is thrown.
     *
     * @return a new instance of the class represented by this {@code Class}.
     * @throws IllegalAccessException
     *             if the default constructor is not visible.
     * @throws InstantiationException
     *             if the instance can not be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.091 -0500", hash_original_method = "5CAD01C91ED82C15E838E91DCE6C6576", hash_generated_method = "FDDB42B0D188A0B956339356BF11732B")
    
public T newInstance() throws InstantiationException, IllegalAccessException {
        return newInstanceImpl();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.766 -0400", hash_original_method = "15EE5A43120338A96CD2B5DEA980891C", hash_generated_method = "53D1094C8103497B4EEB5236AC886608")
    private T newInstanceImpl() throws IllegalAccessException, InstantiationException {
    	T ret = (T)new Object();
    	return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.097 -0500", hash_original_method = "EB1BF1C423B147859F4E7C903D1661B8", hash_generated_method = "7292E9E5EDF7CF3E16FDA7C8739C03F9")
    
@Override
    public String toString() {
        if (isPrimitive()) {
            return getSimpleName();
        } else {
            return (isInterface() ? "interface " : "class ") + getName();
        }
    }

    /**
     * Returns the {@code Package} of which the class represented by this
     * {@code Class} is a member. Returns {@code null} if no {@code Package}
     * object was created by the class loader of the class.
     *
     * @return Package the {@code Package} of which this {@code Class} is a
     *         member or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.099 -0500", hash_original_method = "AFC08E4F788A8A715582FE5BCDA4146B", hash_generated_method = "99264132046FF3CADEE61A42634D3476")
    
public Package getPackage() {
        // TODO This might be a hack, but the VM doesn't have the necessary info.
        ClassLoader loader = getClassLoader();
        if (loader != null) {
            String name = getName();
            int dot = name.lastIndexOf('.');
            return (dot != -1 ? loader.getPackage(name.substring(0, dot)) : null);
        }
        return null;
    }

    /**
     * Returns the assertion status for the class represented by this {@code
     * Class}. Assertion is enabled / disabled based on the class loader,
     * package or class default at runtime.
     *
     * @return the assertion status for the class represented by this {@code
     *         Class}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.102 -0500", hash_original_method = "979945A4786597A7E7ECDDD9487DBA25", hash_generated_method = "550D874087B9E936358B5AA79DF78671")
    
    public boolean desiredAssertionStatus(){
    	//Formerly a native method
    	return getTaintBoolean();
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

    /**
     * Casts the specified object to the type represented by this {@code Class}.
     * If the object is {@code null} then the result is also {@code null}.
     *
     * @param obj
     *            the object to cast.
     * @return the object that has been cast.
     * @throws ClassCastException
     *             if the object cannot be cast to the specified type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:26.108 -0500", hash_original_method = "E0CC08D19733748B74C939DEAB4797E1", hash_generated_method = "66593E0828C148F6EA2B3EEA96365AB6")
    
@SuppressWarnings("unchecked")
    public T cast(Object obj) {
        if (obj == null) {
            return null;
        } else if (this.isInstance(obj)) {
            return (T)obj;
        }
        String actualClassName = obj.getClass().getName();
        String desiredClassName = this.getName();
        throw new ClassCastException(actualClassName + " cannot be cast to " + desiredClassName);
    }
}

