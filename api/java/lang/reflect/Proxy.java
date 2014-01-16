package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Proxy implements Serializable {

    /**
     * Returns the dynamically built {@code Class} for the specified interfaces.
     * Creates a new {@code Class} when necessary. The order of the interfaces
     * is relevant. Invocations of this method with the same interfaces but
     * different order result in different generated classes. The interfaces
     * must be visible from the supplied class loader; no duplicates are
     * permitted. All non-public interfaces must be defined in the same package.
     *
     * @param loader
     *            the class loader that will define the proxy class
     * @param interfaces
     *            an array of {@code Class} objects, each one identifying an
     *            interface that will be implemented by the returned proxy
     *            class
     * @return a proxy class that implements all of the interfaces referred to
     *         in the contents of {@code interfaces}
     * @throws IllegalArgumentException
     *                if any of the interface restrictions are violated
     * @throws NullPointerException
     *                if either {@code interfaces} or any of its elements are
     *                {@code null}
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.184 -0500", hash_original_method = "4E746CE0495D3DB0FF249BFCBD025F6A", hash_generated_method = "A1DE847C342E34996B3F50A48F205721")
    
public static Class<?> getProxyClass(ClassLoader loader,
            Class<?>... interfaces) throws IllegalArgumentException {
        // check that interfaces are a valid array of visible interfaces
        if (interfaces == null) {
            throw new NullPointerException();
        }
        String commonPackageName = null;
        for (int i = 0, length = interfaces.length; i < length; i++) {
            Class<?> next = interfaces[i];
            if (next == null) {
                throw new NullPointerException();
            }
            String name = next.getName();
            if (!next.isInterface()) {
                throw new IllegalArgumentException(name + " is not an interface");
            }
            if (loader != next.getClassLoader()) {
                try {
                    if (next != Class.forName(name, false, loader)) {
                        throw new IllegalArgumentException(name +
                                " is not visible from class loader");
                    }
                } catch (ClassNotFoundException ex) {
                    throw new IllegalArgumentException(name + " is not visible from class loader");
                }
            }
            for (int j = i + 1; j < length; j++) {
                if (next == interfaces[j]) {
                    throw new IllegalArgumentException(name + " appears more than once");
                }
            }
            if (!Modifier.isPublic(next.getModifiers())) {
                int last = name.lastIndexOf('.');
                String p = last == -1 ? "" : name.substring(0, last);
                if (commonPackageName == null) {
                    commonPackageName = p;
                } else if (!commonPackageName.equals(p)) {
                    throw new IllegalArgumentException("non-public interfaces must be " +
                            "in the same package");
                }
            }
        }

        // search cache for matching proxy class using the class loader
        synchronized (loaderCache) {
            Map<String, WeakReference<Class<?>>> interfaceCache = loaderCache
                    .get(loader);
            if (interfaceCache == null) {
                loaderCache
                        .put(
                                loader,
                                (interfaceCache = new HashMap<String, WeakReference<Class<?>>>()));
            }

            String interfaceKey = "";
            if (interfaces.length == 1) {
                interfaceKey = interfaces[0].getName();
            } else {
                StringBuilder names = new StringBuilder();
                for (int i = 0, length = interfaces.length; i < length; i++) {
                    names.append(interfaces[i].getName());
                    names.append(' ');
                }
                interfaceKey = names.toString();
            }

            Class<?> newClass;
            WeakReference<Class<?>> ref = interfaceCache.get(interfaceKey);
            if (ref == null) {
                String nextClassName = "$Proxy" + NextClassNameIndex++;
                if (commonPackageName != null && commonPackageName.length() > 0) {
                    nextClassName = commonPackageName + "." + nextClassName;
                }
                if (loader == null) {
                    loader = ClassLoader.getSystemClassLoader();
                }
                newClass = generateProxy(nextClassName.replace('.', '/'), interfaces, loader);
                // Need a weak reference to the class so it can
                // be unloaded if the class loader is discarded
                interfaceCache.put(interfaceKey, new WeakReference<Class<?>>(newClass));
                synchronized (proxyCache) {
                    // the value is unused
                    proxyCache.put(newClass, "");
                }
            } else {
                newClass = ref.get();
                assert newClass != null : "\ninterfaceKey=\"" + interfaceKey + "\""
                                        + "\nloaderCache=\"" + loaderCache + "\""
                                        + "\nintfCache=\"" + interfaceCache + "\""
                                        + "\nproxyCache=\"" + proxyCache + "\"";
            }
            return newClass;
        }
    }

    /**
     * Returns an instance of the dynamically built class for the specified
     * interfaces. Method invocations on the returned instance are forwarded to
     * the specified invocation handler. The interfaces must be visible from the
     * supplied class loader; no duplicates are permitted. All non-public
     * interfaces must be defined in the same package.
     *
     * @param loader
     *            the class loader that will define the proxy class
     * @param interfaces
     *            an array of {@code Class} objects, each one identifying an
     *            interface that will be implemented by the returned proxy
     *            object
     * @param h
     *            the invocation handler that handles the dispatched method
     *            invocations
     * @return a new proxy object that delegates to the handler {@code h}
     * @throws IllegalArgumentException
     *                if any of the interface restrictions are violated
     * @throws NullPointerException
     *                if the interfaces or any of its elements are null
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.188 -0500", hash_original_method = "4375560191FF9AF2AD66AAFC6EDA1910", hash_generated_method = "403419D6FE97EEEE4440D238B61372F5")
    
public static Object newProxyInstance(ClassLoader loader,
            Class<?>[] interfaces, InvocationHandler h)
            throws IllegalArgumentException {
        if (h == null) {
            throw new NullPointerException();
        }
        try {
            return getProxyClass(loader, interfaces).getConstructor(
                    new Class<?>[] { InvocationHandler.class }).newInstance(
                    new Object[] { h });
        } catch (NoSuchMethodException ex) {
            throw (InternalError) (new InternalError(ex.toString())
                    .initCause(ex));
        } catch (IllegalAccessException ex) {
            throw (InternalError) (new InternalError(ex.toString())
                    .initCause(ex));
        } catch (InstantiationException ex) {
            throw (InternalError) (new InternalError(ex.toString())
                    .initCause(ex));
        } catch (InvocationTargetException ex) {
            Throwable target = ex.getTargetException();
            throw (InternalError) (new InternalError(target.toString())
                    .initCause(target));
        }
    }

    /**
     * Indicates whether or not the specified class is a dynamically generated
     * proxy class.
     *
     * @param cl
     *            the class
     * @return {@code true} if the class is a proxy class, {@code false}
     *         otherwise
     * @throws NullPointerException
     *                if the class is {@code null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.190 -0500", hash_original_method = "03238E01E6CC0C4AD4BEE1E476C6E17D", hash_generated_method = "C5EA26D411549E035FF02BE748611EEB")
    
public static boolean isProxyClass(Class<?> cl) {
        if (cl == null) {
            throw new NullPointerException();
        }
        synchronized (proxyCache) {
            return proxyCache.containsKey(cl);
        }
    }

    /**
     * Returns the invocation handler of the specified proxy instance.
     *
     * @param proxy
     *            the proxy instance
     * @return the invocation handler of the specified proxy instance
     * @throws IllegalArgumentException
     *                if the supplied {@code proxy} is not a proxy object
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.193 -0500", hash_original_method = "BDB130E146D4EEE1EE2A0139344DF6E4", hash_generated_method = "53B5EC9ED5B48FB9ADC94ECB944BF755")
    
public static InvocationHandler getInvocationHandler(Object proxy)
            throws IllegalArgumentException {

        if (isProxyClass(proxy.getClass())) {
            return ((Proxy) proxy).h;
        }

        throw new IllegalArgumentException("not a proxy instance");
    }
    
    private static Class generateProxy(String name, Class[] interfaces,
        ClassLoader loader) {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.taint);
    	ret.addTaint(interfaces[0].taint);
    	ret.addTaint(loader.taint);
    	return ret;
    }
    
    private static void constructorPrototype(InvocationHandler h) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.163 -0500", hash_original_field = "EE4DEE6FBD7EC29CC5158EA595047545", hash_generated_field = "FDC5D947F950CF597538724FB8BE4535")

    private static final long serialVersionUID = -2222568056686623797L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.166 -0500", hash_original_field = "4749BF434871D23E35ACEBA8F8693AE0", hash_generated_field = "1447B52A855471675EBE21031FFE881C")

    private static final Map<ClassLoader, Map<String, WeakReference<Class<?>>>> loaderCache = new WeakHashMap<ClassLoader, Map<String, WeakReference<Class<?>>>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.169 -0500", hash_original_field = "EC2DA36AD78112BF9AFD1A97F76AF8DC", hash_generated_field = "8DC55B920FA938417BE2632EE5DC1724")

    private static final Map<Class<?>, String> proxyCache = new WeakHashMap<Class<?>, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.171 -0500", hash_original_field = "36C395B6B8E86AB13D2AB8268BEB438B", hash_generated_field = "D9EF94FD4EC58A4FD3C03727E5FB6ABC")

    private static int NextClassNameIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.173 -0500", hash_original_field = "8746C20A5E189D22EA6D45D68E66DBE3", hash_generated_field = "89B0705CC0F6BF714E0545A8467AD6EB")

    protected InvocationHandler h;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.176 -0500", hash_original_method = "1299DC7DDC1977A0E223548A22BEB1B2", hash_generated_method = "A06C4E727DA1FC070318D01CB5C4DC02")
    
@SuppressWarnings("unused")
    private Proxy() {
    }

    /**
     * Constructs a new {@code Proxy} instance with the specified invocation
     * handler.
     *
     * @param h
     *            the invocation handler for the newly created proxy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.180 -0500", hash_original_method = "4536AE1A64E0852F0920CAD3D2F2C594", hash_generated_method = "D55E82A0DACA13735AFD1C4D3479792B")
    
protected Proxy(InvocationHandler h) {
        this.h = h;
    }
}

