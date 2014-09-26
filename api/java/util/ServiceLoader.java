package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import libcore.io.IoUtils;

public final class ServiceLoader<S> implements Iterable<S> {
    
    public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<S>(service, classLoader);
    }
    
    public static <S> ServiceLoader<S> load(Class<S> service) {
        return ServiceLoader.load(service, Thread.currentThread().getContextClassLoader());
    }
    
    public static <S> ServiceLoader<S> loadInstalled(Class<S> service) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl != null) {
            while (cl.getParent() != null) {
                cl = cl.getParent();
            }
        }
        return ServiceLoader.load(service, cl);
    }
    
    public static <S> S loadFromSystemProperty(final Class<S> service) {
        try {
            final String className = System.getProperty(service.getName());
            if (className != null) {
                Class<?> c = ClassLoader.getSystemClassLoader().loadClass(className);
                return (S) c.newInstance();
            }
            return null;
        } catch (Exception e) {
            throw new Error(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.391 -0500", hash_original_field = "2D6ED9787641E6B28949C0A39DA102CA", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

    private  Class<S> service;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.393 -0500", hash_original_field = "DB93E4DB6045160743AC769A344DA267", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private  ClassLoader classLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.395 -0500", hash_original_field = "20AC8E97E9ADE044C70698A1025D7BD6", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

    private  Set<URL> services;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.398 -0500", hash_original_method = "94B9216B7758F0B227BA0C421F85C6AF", hash_generated_method = "EC21449AED08B55C5A66D03C5CACDA3D")
    
private ServiceLoader(Class<S> service, ClassLoader classLoader) {
        // It makes no sense for service to be null.
        // classLoader is null if you want the system class loader.
        if (service == null) {
            throw new NullPointerException();
        }
        this.service = service;
        this.classLoader = classLoader;
        this.services = new HashSet<URL>();
        reload();
    }

    /**
     * Invalidates the cache of known service provider class names.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.400 -0500", hash_original_method = "5DE3F3B80408315525994C211C4640EC", hash_generated_method = "633279BE735F9BF6F8A7B3923C9B6C0F")
    
public void reload() {
        internalLoad();
    }

    /**
     * Returns an iterator over all the service providers offered by this service loader.
     * Note that {@code hasNext} and {@code next} may throw if the configuration is invalid.
     *
     * <p>Each iterator will return new instances of the classes it iterates over, so callers
     * may want to cache the results of a single call to this method rather than call it
     * repeatedly.
     *
     * <p>The returned iterator does not support {@code remove}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.403 -0500", hash_original_method = "347C14FB6BD1E7714C96867577CC330D", hash_generated_method = "903E79232BB492D8486688E535217E3B")
    
public Iterator<S> iterator() {
        return new ServiceIterator(this);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.407 -0500", hash_original_method = "7DCE51783862B815D2BC789E6049F748", hash_generated_method = "636795A3BEE52517DBA37BF07028F4A4")
    
private void internalLoad() {
        services.clear();
        try {
            String name = "META-INF/services/" + service.getName();
            services.addAll(Collections.list(classLoader.getResources(name)));
        } catch (IOException e) {
            return;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.417 -0500", hash_original_method = "F8BFF902940FB319A126BEB71F562AF6", hash_generated_method = "E74C9B6A194B8542188350F2CA47D3FB")
    
@Override
    public String toString() {
        return "ServiceLoader for " + service.getName();
    }
    
    private class ServiceIterator implements Iterator<S> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.420 -0500", hash_original_field = "DB93E4DB6045160743AC769A344DA267", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

        private  ClassLoader classLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.422 -0500", hash_original_field = "2D6ED9787641E6B28949C0A39DA102CA", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

        private  Class<S> service;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.425 -0500", hash_original_field = "20AC8E97E9ADE044C70698A1025D7BD6", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

        private  Set<URL> services;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.428 -0500", hash_original_field = "50C457FF74D9C40288B48AEB440D50AE", hash_generated_field = "AF3FD4FB03AF670FF56C37A3383F4F8C")

        private boolean isRead = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.430 -0500", hash_original_field = "DEC57B84A4CD748354D1673FC02EFE30", hash_generated_field = "379E2423239498A389B9B242C49020D7")

        private LinkedList<String> queue = new LinkedList<String>();

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.433 -0500", hash_original_method = "9B12B690CA5F78312F729D80BAC6EFA1", hash_generated_method = "F64E3416AD50B6604085E6C8DB2B40D6")
        
public ServiceIterator(ServiceLoader<S> sl) {
            this.classLoader = sl.classLoader;
            this.service = sl.service;
            this.services = sl.services;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.435 -0500", hash_original_method = "DC8C57213B773C0EB2B0D98440591DD2", hash_generated_method = "93761BE42B0E7B4396883B779BF64698")
        
public boolean hasNext() {
            if (!isRead) {
                readClass();
            }
            return (queue != null && !queue.isEmpty());
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.438 -0500", hash_original_method = "B99394086046EF47562A5B63911931C2", hash_generated_method = "03938AB1B532DD7680A49FA14D21523A")
        
@SuppressWarnings("unchecked")
        public S next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String className = queue.remove();
            try {
                return service.cast(classLoader.loadClass(className).newInstance());
            } catch (Exception e) {
                throw new ServiceConfigurationError("Couldn't instantiate class " + className, e);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.441 -0500", hash_original_method = "D6C7FE21AC961E0461EEEE7A6B5E3796", hash_generated_method = "51319C8714A29158C166730309F225DA")
        
private void readClass() {
            for (URL url : services) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Strip comments and whitespace...
                        int commentStart = line.indexOf('#');
                        if (commentStart != -1) {
                            line = line.substring(0, commentStart);
                        }
                        line = line.trim();
                        // Ignore empty lines.
                        if (line.isEmpty()) {
                            continue;
                        }
                        String className = line;
                        checkValidJavaClassName(className);
                        if (!queue.contains(className)) {
                            queue.add(className);
                        }
                    }
                    isRead = true;
                } catch (Exception e) {
                    throw new ServiceConfigurationError("Couldn't read " + url, e);
                } finally {
                    IoUtils.closeQuietly(reader);
                }
            }
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.444 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
        
public void remove() {
            throw new UnsupportedOperationException();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:27.446 -0500", hash_original_method = "0BD3CD94707D253C58DB4E9194FF8BE6", hash_generated_method = "5884C35807929EC9767E1C51DDEC5DA4")
        
private void checkValidJavaClassName(String className) {
            for (int i = 0; i < className.length(); ++i) {
                char ch = className.charAt(i);
                if (!Character.isJavaIdentifierPart(ch) && ch != '.') {
                    throw new ServiceConfigurationError("Bad character '" + ch + "' in class name");
                }
            }
        }
        
    }
    
}

