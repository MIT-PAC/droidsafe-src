package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Proxy implements Serializable {
    private static final long serialVersionUID = -2222568056686623797L;
    private static final Map<ClassLoader, Map<String, WeakReference<Class<?>>>> loaderCache = new WeakHashMap<ClassLoader, Map<String, WeakReference<Class<?>>>>();
    private static final Map<Class<?>, String> proxyCache = new WeakHashMap<Class<?>, String>();
    private static int NextClassNameIndex = 0;
    protected InvocationHandler h;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.875 -0400", hash_original_method = "1299DC7DDC1977A0E223548A22BEB1B2", hash_generated_method = "FB43E00434676ACEFA16B9DD82D1CEAF")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unused")
    private Proxy() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.875 -0400", hash_original_method = "4536AE1A64E0852F0920CAD3D2F2C594", hash_generated_method = "8DEC5C4D1E7F26EDE9D589CA9A4B3341")
    @DSModeled(DSC.SAFE)
    protected Proxy(InvocationHandler h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //this.h = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "4E746CE0495D3DB0FF249BFCBD025F6A", hash_generated_method = "6702610A565CD0334F3F14D01485CB89")
    public static Class<?> getProxyClass(ClassLoader loader,
            Class<?>... interfaces) throws IllegalArgumentException {
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
                interfaceCache.put(interfaceKey, new WeakReference<Class<?>>(newClass));
                synchronized (proxyCache) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "4375560191FF9AF2AD66AAFC6EDA1910", hash_generated_method = "403419D6FE97EEEE4440D238B61372F5")
    public static Object newProxyInstance(ClassLoader loader,
            Class<?>[] interfaces, InvocationHandler h) throws IllegalArgumentException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "03238E01E6CC0C4AD4BEE1E476C6E17D", hash_generated_method = "C5EA26D411549E035FF02BE748611EEB")
    public static boolean isProxyClass(Class<?> cl) {
        if (cl == null) {
            throw new NullPointerException();
        }
        synchronized (proxyCache) {
            return proxyCache.containsKey(cl);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "BDB130E146D4EEE1EE2A0139344DF6E4", hash_generated_method = "004214B75F0803A84DB8B6AEAF156188")
    public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if (isProxyClass(proxy.getClass())) {
            return ((Proxy) proxy).h;
        }
        throw new IllegalArgumentException("not a proxy instance");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "35C55DB5A48B0F395569B015D68669C8", hash_generated_method = "1A3962981E1F8C3737CB48271654C757")
    private static Class generateProxy(String name, Class[] interfaces,
        ClassLoader loader) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.876 -0400", hash_original_method = "EBFFD66DCB885BD74568982AE6528CDF", hash_generated_method = "A39B025F0D8154CF32A1BE4D6867642B")
    private static void constructorPrototype(InvocationHandler h) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
}


