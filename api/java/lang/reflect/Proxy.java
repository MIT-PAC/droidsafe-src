package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;






public class Proxy implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.180 -0400", hash_original_field = "2510C39011C5BE704182423E3A695E91", hash_generated_field = "89B0705CC0F6BF714E0545A8467AD6EB")

    protected InvocationHandler h;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.180 -0400", hash_original_method = "1299DC7DDC1977A0E223548A22BEB1B2", hash_generated_method = "D647A7D612843DD58BA0B0DD89164A21")
    @SuppressWarnings("unused")
    private  Proxy() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.181 -0400", hash_original_method = "4536AE1A64E0852F0920CAD3D2F2C594", hash_generated_method = "698C4B548DC7670D8B6A3E54EBD2B093")
    protected  Proxy(InvocationHandler h) {
        this.h = h;
        // ---------- Original Method ----------
        //this.h = h;
    }

    
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

    
    @DSModeled(DSC.BAN)
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

    
    public static boolean isProxyClass(Class<?> cl) {
        if (cl == null) {
            throw new NullPointerException();
        }
        synchronized (proxyCache) {
            return proxyCache.containsKey(cl);
        }
    }

    
    public static InvocationHandler getInvocationHandler(Object proxy) throws IllegalArgumentException {
        if (isProxyClass(proxy.getClass())) {
            return ((Proxy) proxy).h;
        }
        throw new IllegalArgumentException("not a proxy instance");
    }

    
    @DSModeled(DSC.BAN)
    private static Class generateProxy(String name, Class[] interfaces,
        ClassLoader loader) {
    	Class ret = (Class)new Object();
    	ret.addTaint(name.taint);
    	ret.addTaint(interfaces[0].taint);
    	ret.addTaint(loader.taint);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    private static void constructorPrototype(InvocationHandler h) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.183 -0400", hash_original_field = "D386C92C7838EE8E51BC9D21FAEBA973", hash_generated_field = "FDC5D947F950CF597538724FB8BE4535")

    private static final long serialVersionUID = -2222568056686623797L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.183 -0400", hash_original_field = "6C950B76DEE3DAD7981B8D3EF12B636B", hash_generated_field = "1447B52A855471675EBE21031FFE881C")

    private static final Map<ClassLoader, Map<String, WeakReference<Class<?>>>> loaderCache = new WeakHashMap<ClassLoader, Map<String, WeakReference<Class<?>>>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.183 -0400", hash_original_field = "4C738840F7F4B6A87D2B79A8D35E9B6A", hash_generated_field = "8DC55B920FA938417BE2632EE5DC1724")

    private static final Map<Class<?>, String> proxyCache = new WeakHashMap<Class<?>, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.183 -0400", hash_original_field = "12B2C2F32FB453007DDBD4D3641ED421", hash_generated_field = "D9EF94FD4EC58A4FD3C03727E5FB6ABC")

    private static int NextClassNameIndex = 0;
}

