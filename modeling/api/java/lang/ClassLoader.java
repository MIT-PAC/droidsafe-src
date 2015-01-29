package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.PathClassLoader;

public abstract class ClassLoader {

    /**
     * Create the system class loader. Note this is NOT the bootstrap class
     * loader (which is managed by the VM). We use a null value for the parent
     * to indicate that the bootstrap loader is our parent.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.698 -0500", hash_original_method = "68A1F8E40482E8D5899E0A36610D7F57", hash_generated_method = "8DF30F2216A35375468497DB19BD60B0")
    
private static ClassLoader createSystemClassLoader() {
        //String classPath = System.getProperty("java.class.path", ".");

        // String[] paths = classPath.split(":");
        // URL[] urls = new URL[paths.length];
        // for (int i = 0; i < paths.length; i++) {
        // try {
        // urls[i] = new URL("file://" + paths[i]);
        // }
        // catch (Exception ex) {
        // ex.printStackTrace();
        // }
        // }
        //
        // return new java.net.URLClassLoader(urls, null);

        // TODO Make this a java.net.URLClassLoader once we have those?
        // return new PathClassLoader("java.class.path", BootClassLoader.getInstance());
        
        return BootClassLoader.getInstance();
    }

    /**
     * Returns the system class loader. This is the parent for new
     * {@code ClassLoader} instances and is typically the class loader used to
     * start the application.
     */
    @DSComment("Refelction/class loader")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.701 -0500", hash_original_method = "FA9BEFC0F6AFD8951E8DF1C896E1649A", hash_generated_method = "8DD818B5EED80F9656CDF38361BE49F8")
    
public static ClassLoader getSystemClassLoader() {
        return SystemClassLoader.loader;
    }

    /**
     * Finds the URL of the resource with the specified name. The system class
     * loader's resource lookup algorithm is used to find the resource.
     *
     * @return the {@code URL} object for the requested resource or {@code null}
     *         if the resource can not be found.
     * @param resName
     *            the name of the resource to find.
     * @see Class#getResource
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.703 -0500", hash_original_method = "5B4CC456A75A36B7FCF3EBF4EA91DA87", hash_generated_method = "B027BF8F1E2E34707D9F81B747EB6F5D")
    
public static URL getSystemResource(String resName) {
        return SystemClassLoader.loader.getResource(resName);
    }

    /**
     * Returns an enumeration of URLs for the resource with the specified name.
     * The system class loader's resource lookup algorithm is used to find the
     * resource.
     *
     * @return an enumeration of {@code URL} objects containing the requested
     *         resources.
     * @param resName
     *            the name of the resource to find.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.706 -0500", hash_original_method = "E1E9E39B1CF0FA83BA6E8BECA300CA49", hash_generated_method = "577320E4BD146E09A173164C148C8FEB")
    
public static Enumeration<URL> getSystemResources(String resName) throws IOException {
        return SystemClassLoader.loader.getResources(resName);
    }

    /**
     * Returns a stream for the resource with the specified name. The system
     * class loader's resource lookup algorithm is used to find the resource.
     * Basically, the contents of the java.class.path are searched in order,
     * looking for a path which matches the specified resource.
     *
     * @return a stream for the resource or {@code null}.
     * @param resName
     *            the name of the resource to find.
     * @see Class#getResourceAsStream
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.709 -0500", hash_original_method = "05C330432267C3CB2D525AEB5E4DBFBC", hash_generated_method = "A33A37C69D674218736BA9B9695F3584")
    
public static InputStream getSystemResourceAsStream(String resName) {
        //droidsafe short-circuiting
        try {
            return (new URL(resName)).openStream();
        } catch (Exception e) {
            
        }

        return null;

            /*
        return SystemClassLoader.loader.getResourceAsStream(resName);
            */
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.693 -0500", hash_original_field = "C6C9C9B9683A3ABEAA9A2585B1BD6899", hash_generated_field = "F21C7A33E41D98EA12963007269D2C47")

    private ClassLoader parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.695 -0500", hash_original_field = "E616742DDF39B8B80DE9338957960860", hash_generated_field = "D93E16E52D6392375771C09EA3DB6BEE")

    private Map<String, Package> packages = new HashMap<String, Package>();

    /**
     * Constructs a new instance of this class with the system class loader as
     * its parent.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.712 -0500", hash_original_method = "8E76514466172FE6741D8A4C6661DD70", hash_generated_method = "35CA469B9DE7E16FED58BBDA37322DDE")
    
protected ClassLoader() {
        this(getSystemClassLoader(), false);
    }

    /**
     * Constructs a new instance of this class with the specified class loader
     * as its parent.
     *
     * @param parentLoader
     *            The {@code ClassLoader} to use as the new class loader's
     *            parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.715 -0500", hash_original_method = "DB0BF52E0FA8D43D630F9D86095EF243", hash_generated_method = "5F18944EBAE7154972B6B00CE8D5680D")
    
protected ClassLoader(ClassLoader parentLoader) {
        this(parentLoader, false);
    }

    /*
     * constructor for the BootClassLoader which needs parent to be null.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.718 -0500", hash_original_method = "B3E4E8C3A704386E61A8D58325A9E2B7", hash_generated_method = "B3E4E8C3A704386E61A8D58325A9E2B7")
    
ClassLoader(ClassLoader parentLoader, boolean nullAllowed) {
        if (parentLoader == null && !nullAllowed) {
            throw new NullPointerException("Parent ClassLoader may not be null");
        }
        parent = parentLoader;
    }

    /**
     * Constructs a new class from an array of bytes containing a class
     * definition in class file format.
     *
     * @param classRep
     *            the memory image of a class file.
     * @param offset
     *            the offset into {@code classRep}.
     * @param length
     *            the length of the class file.
     * @return the {@code Class} object created from the specified subset of
     *         data in {@code classRep}.
     * @throws ClassFormatError
     *             if {@code classRep} does not contain a valid class.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0}, {@code length < 0} or if
     *             {@code offset + length} is greater than the length of
     *             {@code classRep}.
     * @deprecated Use {@link #defineClass(String, byte[], int, int)}
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.721 -0500", hash_original_method = "EDBCEB3B7F6159932B32B9FEC39C429A", hash_generated_method = "F83615DC3001F584D48CE6D91F8FD1C5")
    
@Deprecated
    protected final Class<?> defineClass(byte[] classRep, int offset, int length)
            throws ClassFormatError {

        return VMClassLoader.defineClass(this, classRep, offset, length);
    }

    /**
     * Constructs a new class from an array of bytes containing a class
     * definition in class file format.
     *
     * @param className
     *            the expected name of the new class, may be {@code null} if not
     *            known.
     * @param classRep
     *            the memory image of a class file.
     * @param offset
     *            the offset into {@code classRep}.
     * @param length
     *            the length of the class file.
     * @return the {@code Class} object created from the specified subset of
     *         data in {@code classRep}.
     * @throws ClassFormatError
     *             if {@code classRep} does not contain a valid class.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0}, {@code length < 0} or if
     *             {@code offset + length} is greater than the length of
     *             {@code classRep}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.723 -0500", hash_original_method = "0F0A39CE7574A7CD22D1B4668E39A889", hash_generated_method = "4546FFCB3C8AE2EF28CE2409D3B3D54C")
    
protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length)
            throws ClassFormatError {

        // TODO Define a default ProtectionDomain on first use
        return defineClass(className, classRep, offset, length, null);
    }

    /**
     * Constructs a new class from an array of bytes containing a class
     * definition in class file format and assigns the specified protection
     * domain to the new class. If the provided protection domain is
     * {@code null} then a default protection domain is assigned to the class.
     *
     * @param className
     *            the expected name of the new class, may be {@code null} if not
     *            known.
     * @param classRep
     *            the memory image of a class file.
     * @param offset
     *            the offset into {@code classRep}.
     * @param length
     *            the length of the class file.
     * @param protectionDomain
     *            the protection domain to assign to the loaded class, may be
     *            {@code null}.
     * @return the {@code Class} object created from the specified subset of
     *         data in {@code classRep}.
     * @throws ClassFormatError
     *             if {@code classRep} does not contain a valid class.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0}, {@code length < 0} or if
     *             {@code offset + length} is greater than the length of
     *             {@code classRep}.
     * @throws NoClassDefFoundError
     *             if {@code className} is not equal to the name of the class
     *             contained in {@code classRep}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.726 -0500", hash_original_method = "EBF70D1CA87DA01178FDB05EE0827744", hash_generated_method = "D023E5F162F392947CF3954F6D9621BC")
    
protected final Class<?> defineClass(String className, byte[] classRep, int offset, int length,
            ProtectionDomain protectionDomain) throws java.lang.ClassFormatError {

        return VMClassLoader.defineClass(this, className, classRep, offset, length);
    }

    /**
     * Defines a new class with the specified name, byte code from the byte
     * buffer and the optional protection domain. If the provided protection
     * domain is {@code null} then a default protection domain is assigned to
     * the class.
     *
     * @param name
     *            the expected name of the new class, may be {@code null} if not
     *            known.
     * @param b
     *            the byte buffer containing the byte code of the new class.
     * @param protectionDomain
     *            the protection domain to assign to the loaded class, may be
     *            {@code null}.
     * @return the {@code Class} object created from the data in {@code b}.
     * @throws ClassFormatError
     *             if {@code b} does not contain a valid class.
     * @throws NoClassDefFoundError
     *             if {@code className} is not equal to the name of the class
     *             contained in {@code b}.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.729 -0500", hash_original_method = "05D340D0AFD0A4A41A098B1B021596A9", hash_generated_method = "16D970D66C9DD032C2EEFED4A3EFCBDB")
    
protected final Class<?> defineClass(String name, ByteBuffer b,
            ProtectionDomain protectionDomain) throws ClassFormatError {

        byte[] temp = new byte[b.remaining()];
        b.get(temp);
        return defineClass(name, temp, 0, temp.length, protectionDomain);
    }

    /**
     * Overridden by subclasses, throws a {@code ClassNotFoundException} by
     * default. This method is called by {@code loadClass} after the parent
     * {@code ClassLoader} has failed to find a loaded class of the same name.
     *
     * @param className
     *            the name of the class to look for.
     * @return the {@code Class} object that is found.
     * @throws ClassNotFoundException
     *             if the class cannot be found.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.732 -0500", hash_original_method = "FDF53ED54BA8389D30C48D1E15C39772", hash_generated_method = "FB82C2D99F4742B00541560CA9A07E36")
    
protected Class<?> findClass(String className) throws ClassNotFoundException {
        throw new ClassNotFoundException(className);
    }

    /**
     * Returns the class with the specified name if it has already been loaded
     * by the VM or {@code null} if it has not yet been loaded.
     *
     * @param className
     *            the name of the class to look for.
     * @return the {@code Class} object or {@code null} if the requested class
     *         has not been loaded.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.734 -0500", hash_original_method = "1BCB441A83D111A7AA8FEC24C2456543", hash_generated_method = "06FE2523C098362515141DF792BFCDF0")
    
protected final Class<?> findLoadedClass(String className) {
        ClassLoader loader;
        if (this == BootClassLoader.getInstance())
            loader = null;
        else
            loader = this;
        return VMClassLoader.findLoadedClass(loader, className);
    }

    /**
     * Finds the class with the specified name, loading it using the system
     * class loader if necessary.
     *
     * @param className
     *            the name of the class to look for.
     * @return the {@code Class} object with the requested {@code className}.
     * @throws ClassNotFoundException
     *             if the class can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.736 -0500", hash_original_method = "8781F33C8E67EE4404420C5C91B2F2B8", hash_generated_method = "87140C85C67216BE036BC30AAD49D863")
    
protected final Class<?> findSystemClass(String className) throws ClassNotFoundException {
        return Class.forName(className, false, getSystemClassLoader());
    }

    /**
     * Returns this class loader's parent.
     *
     * @return this class loader's parent or {@code null}.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.739 -0500", hash_original_method = "C41AD9124585D3AEE85EC6C2F13127B8", hash_generated_method = "ED57FFEBF397EEE0D2DCFDFD8C2655BA")
    
public final ClassLoader getParent() {
        return parent;
    }

    /**
     * Returns the URL of the resource with the specified name. This
     * implementation first tries to use the parent class loader to find the
     * resource; if this fails then {@link #findResource(String)} is called to
     * find the requested resource.
     *
     * @param resName
     *            the name of the resource to find.
     * @return the {@code URL} object for the requested resource or {@code null}
     *         if the resource can not be found
     * @see Class#getResource
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.741 -0500", hash_original_method = "51B198FC24245E471F59AEE285D4917F", hash_generated_method = "ED3E9B74C8F3F28021F3B2BF37C09FDD")
    
public URL getResource(String resName) {
        URL resource = parent.getResource(resName);
        if (resource == null) {
            resource = findResource(resName);
        }
        return resource;
    }

    /**
     * Returns an enumeration of URLs for the resource with the specified name.
     * This implementation first uses this class loader's parent to find the
     * resource, then it calls {@link #findResources(String)} to get additional
     * URLs. The returned enumeration contains the {@code URL} objects of both
     * find operations.
     *
     * @return an enumeration of {@code URL} objects for the requested resource.
     * @param resName
     *            the name of the resource to find.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.744 -0500", hash_original_method = "A1AC2BF370A36ABB9B1EEF5C25CA87C9", hash_generated_method = "7CDD0CBB2F959FF3262CA4A39BA2D2D4")
    
@SuppressWarnings("unchecked")
    public Enumeration<URL> getResources(String resName) throws IOException {

        Enumeration first = parent.getResources(resName);
        Enumeration second = findResources(resName);

        return new TwoEnumerationsInOne(first, second);
    }

    /**
     * Returns a stream for the resource with the specified name. See
     * {@link #getResource(String)} for a description of the lookup algorithm
     * used to find the resource.
     *
     * @return a stream for the resource or {@code null} if the resource can not be found
     * @param resName
     *            the name of the resource to find.
     * @see Class#getResourceAsStream
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.747 -0500", hash_original_method = "D8955CCF86190424763C439F9FDF42B6", hash_generated_method = "23CB9B395B84F49B6BEEC8C70F6D582B")
    
public InputStream getResourceAsStream(String resName) {
        //droidsafe short-circuiting
        try {
            return (new URL(resName)).openStream();
        } catch (Exception e) {
            
        }

        return null;

        /*
        try {
            URL url = getResource(resName);
            if (url != null) {
                return url.openStream();
            }
        } catch (IOException ex) {
            // Don't want to see the exception.
        }
        
        return null;
        */
    }

    /**
     * Loads the class with the specified name. Invoking this method is
     * equivalent to calling {@code loadClass(className, false)}.
     * <p>
     * <strong>Note:</strong> In the Android reference implementation, the
     * second parameter of {@link #loadClass(String, boolean)} is ignored
     * anyway.
     * </p>
     *
     * @return the {@code Class} object.
     * @param className
     *            the name of the class to look for.
     * @throws ClassNotFoundException
     *             if the class can not be found.
     */
    @DSComment("Refelction/class loader")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.750 -0500", hash_original_method = "B81E0F32DC432F0B3276D4B4E41F12D0", hash_generated_method = "2C14505DFAF9AA253FE895FDE3C6A4AA")
    
public Class<?> loadClass(String className) throws ClassNotFoundException {
        return loadClass(className, false);
    }

    /**
     * Loads the class with the specified name, optionally linking it after
     * loading. The following steps are performed:
     * <ol>
     * <li> Call {@link #findLoadedClass(String)} to determine if the requested
     * class has already been loaded.</li>
     * <li>If the class has not yet been loaded: Invoke this method on the
     * parent class loader.</li>
     * <li>If the class has still not been loaded: Call
     * {@link #findClass(String)} to find the class.</li>
     * </ol>
     * <p>
     * <strong>Note:</strong> In the Android reference implementation, the
     * {@code resolve} parameter is ignored; classes are never linked.
     * </p>
     *
     * @return the {@code Class} object.
     * @param className
     *            the name of the class to look for.
     * @param resolve
     *            Indicates if the class should be resolved after loading. This
     *            parameter is ignored on the Android reference implementation;
     *            classes are not resolved.
     * @throws ClassNotFoundException
     *             if the class can not be found.
     */
    @DSComment("Refelction/class loader")
    @DSSpec(DSCat.SPEC_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.752 -0500", hash_original_method = "733CC3AC678FE7D7ABDA5F1E7A258EB2", hash_generated_method = "7E554DAE64821C187FBA4D370660E9DF")
    
protected Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(className);

        if (clazz == null) {
            try {
                clazz = parent.loadClass(className, false);
            } catch (ClassNotFoundException e) {
                // Don't want to see this.
            }

            if (clazz == null) {
                clazz = findClass(className);
            }
        }

        return clazz;
    }

    /**
     * Forces a class to be linked (initialized). If the class has already been
     * linked this operation has no effect.
     * <p>
     * <strong>Note:</strong> In the Android reference implementation, this
     * method has no effect.
     * </p>
     *
     * @param clazz
     *            the class to link.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.755 -0500", hash_original_method = "87395C94E1724A33A91DB9FA52BA76C0", hash_generated_method = "60E3F41C72F85167B31502908A898E91")
    
protected final void resolveClass(Class<?> clazz) {
        // no-op, doesn't make sense on android.
    }

    /**
     * Finds the URL of the resource with the specified name. This
     * implementation just returns {@code null}; it should be overridden in
     * subclasses.
     *
     * @param resName
     *            the name of the resource to find.
     * @return the {@code URL} object for the requested resource.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.757 -0500", hash_original_method = "A0771382989D9347D13AB7091421D08A", hash_generated_method = "9482DAB9A6C5BF756E036D4F94DCBFCD")
    
protected URL findResource(String resName) {
        try {
            return new URL(resName);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Finds an enumeration of URLs for the resource with the specified name.
     * This implementation just returns an empty {@code Enumeration}; it should
     * be overridden in subclasses.
     *
     * @param resName
     *            the name of the resource to find.
     * @return an enumeration of {@code URL} objects for the requested resource.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.760 -0500", hash_original_method = "4B31BA177B6DE85B868949BABF9D20CF", hash_generated_method = "A4A0F26BC3DD0D1F886299CE7A6B5EF3")
    
@SuppressWarnings( {
            "unchecked", "unused"
    })
    protected Enumeration<URL> findResources(String resName) throws IOException {
        return Collections.emptyEnumeration();
    }

    /**
     * Returns the absolute path of the native library with the specified name,
     * or {@code null}. If this method returns {@code null} then the virtual
     * machine searches the directories specified by the system property
     * "java.library.path".
     * <p>
     * This implementation always returns {@code null}.
     * </p>
     *
     * @param libName
     *            the name of the library to find.
     * @return the absolute path of the library.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.762 -0500", hash_original_method = "77218157254CA1D97E6FAA91981AFD35", hash_generated_method = "CEE2AE9944CCEBF3D1F37FA8E1F90E58")
    
protected String findLibrary(String libName) {
        return null;
    }

    /**
     * Returns the package with the specified name. Package information is
     * searched in this class loader.
     *
     * @param name
     *            the name of the package to find.
     * @return the package with the requested name; {@code null} if the package
     *         can not be found.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.764 -0500", hash_original_method = "32CF87857A859A288886DD8F10CED2F8", hash_generated_method = "12ACE23971D0ED38D299760EA056F6C4")
    
protected Package getPackage(String name) {
        synchronized (packages) {
            return packages.get(name);
        }
    }

    /**
     * Returns all the packages known to this class loader.
     *
     * @return an array with all packages known to this class loader.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.767 -0500", hash_original_method = "9287CE4A0AED64937C82364D387BD57D", hash_generated_method = "26D15C80536358D215DBA86AFDB0E25E")
    
protected Package[] getPackages() {
        synchronized (packages) {
            Collection<Package> col = packages.values();
            Package[] result = new Package[col.size()];
            col.toArray(result);
            return result;
        }
    }

    /**
     * Defines and returns a new {@code Package} using the specified
     * information. If {@code sealBase} is {@code null}, the package is left
     * unsealed. Otherwise, the package is sealed using this URL.
     *
     * @param name
     *            the name of the package.
     * @param specTitle
     *            the title of the specification.
     * @param specVersion
     *            the version of the specification.
     * @param specVendor
     *            the vendor of the specification.
     * @param implTitle
     *            the implementation title.
     * @param implVersion
     *            the implementation version.
     * @param implVendor
     *            the specification vendor.
     * @param sealBase
     *            the URL used to seal this package or {@code null} to leave the
     *            package unsealed.
     * @return the {@code Package} object that has been created.
     * @throws IllegalArgumentException
     *             if a package with the specified name already exists.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.770 -0500", hash_original_method = "A43EE12FE4CCED7FFCD5E4E6E6B7450E", hash_generated_method = "EC0E3C57D46AF44E45ECEB327432AEDD")
    
protected Package definePackage(String name, String specTitle, String specVersion,
            String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase)
            throws IllegalArgumentException {

        synchronized (packages) {
            if (packages.containsKey(name)) {
                throw new IllegalArgumentException("Package " + name + " already defined");
            }

            Package newPackage = new Package(name, specTitle, specVersion, specVendor, implTitle,
                    implVersion, implVendor, sealBase);

            packages.put(name, newPackage);

            return newPackage;
        }
    }

    /**
     * Sets the signers of the specified class. This implementation does
     * nothing.
     *
     * @param c
     *            the {@code Class} object for which to set the signers.
     * @param signers
     *            the signers for {@code c}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.773 -0500", hash_original_method = "BAF7E3EE5C9000806386C90B3768A9FC", hash_generated_method = "03093ABC63DCEF836A2A1922E1B9F2F2")
    
protected final void setSigners(Class<?> c, Object[] signers) {
    }

    /**
     * Sets the assertion status of the class with the specified name.
     * <p>
     * <strong>Note: </strong>This method does nothing in the Android reference
     * implementation.
     * </p>
     *
     * @param cname
     *            the name of the class for which to set the assertion status.
     * @param enable
     *            the new assertion status.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.775 -0500", hash_original_method = "0651223F404879984496AF2BE37D7C48", hash_generated_method = "74A7819064E88BE4C1934049AC33D3A4")
    
public void setClassAssertionStatus(String cname, boolean enable) {
    }

    /**
     * Sets the assertion status of the package with the specified name.
     * <p>
     * <strong>Note: </strong>This method does nothing in the Android reference
     * implementation.
     * </p>
     *
     * @param pname
     *            the name of the package for which to set the assertion status.
     * @param enable
     *            the new assertion status.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.778 -0500", hash_original_method = "2F6CF0A6D7DAAB50984CC8577E0B6ED7", hash_generated_method = "2BC9E3872D1A31CB96DD87C27C6F9962")
    
public void setPackageAssertionStatus(String pname, boolean enable) {
    }

    /**
     * Sets the default assertion status for this class loader.
     * <p>
     * <strong>Note: </strong>This method does nothing in the Android reference
     * implementation.
     * </p>
     *
     * @param enable
     *            the new assertion status.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.780 -0500", hash_original_method = "F3C67BF009E262C5EF85B89EAEA54A8D", hash_generated_method = "30476EC8592EB59AE1131664F53EC04D")
    
public void setDefaultAssertionStatus(boolean enable) {
    }

    /**
     * Sets the default assertion status for this class loader to {@code false}
     * and removes any package default and class assertion status settings.
     * <p>
     * <strong>Note:</strong> This method does nothing in the Android reference
     * implementation.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.782 -0500", hash_original_method = "0F2B38C73B2795A58A5B8AC7764225D2", hash_generated_method = "15316E1A0C0AEDC2B81F05060E6DB509")
    
public void clearAssertionStatus() {
    }
    
    static private class SystemClassLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.689 -0500", hash_original_field = "4CBD9E687D788156518F29C886369AF0", hash_generated_field = "9F05049E5285C9256C3F77BCE2FFFB9C")

        public static ClassLoader loader = ClassLoader.createSystemClassLoader();
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.700 -0400", hash_original_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D", hash_generated_method = "5CAD2AFC0F0FA3887E4002E77FFD0C7D")
        public SystemClassLoader ()
        {
            //Synthesized constructor
        }
    }
    
}

class TwoEnumerationsInOne implements Enumeration<URL> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.785 -0500", hash_original_field = "FA07505D9B1F2FD435160CC237092029", hash_generated_field = "8251EE6159DCC0C25ACB4653E04140B7")

    private Enumeration<URL> first;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.787 -0500", hash_original_field = "562B9360D046C04E9AFC73B4DDFCBBB4", hash_generated_field = "48331890F3BE0E00347927CE21AF464F")

    private Enumeration<URL> second;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.790 -0500", hash_original_method = "D3D417A978FD13F0C9B8800DA2920B14", hash_generated_method = "BAFFE98862853651774FEA0F39D8CD8A")
    
public TwoEnumerationsInOne(Enumeration<URL> first, Enumeration<URL> second) {
        this.first = first;
        this.second = second;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.793 -0500", hash_original_method = "B34DCB72B1A55025C195F65FCCD0FE9D", hash_generated_method = "A94E2380B6A7F52B0BE684F6107F3B0C")
    
public boolean hasMoreElements() {
        return first.hasMoreElements() || second.hasMoreElements();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.795 -0500", hash_original_method = "CE040DB5C31CF9231E1B46430147AEAF", hash_generated_method = "F9B4890ADFD1503BAD6CB70E3C91AEFC")
    
public URL nextElement() {
        if (first.hasMoreElements()) {
            return first.nextElement();
        } else {
            return second.nextElement();
        }
    }
    
}

class BootClassLoader extends ClassLoader {

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.801 -0500", hash_original_method = "354050299413BC9510E0B883D1D25E7C", hash_generated_method = "C95A8B853C4808F36BF748064C237B87")
    
@FindBugsSuppressWarnings("DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED")
    public static synchronized BootClassLoader getInstance() {
        if (instance == null) {
            instance = new BootClassLoader();
        }

        return instance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.798 -0500", hash_original_field = "26F6885D53C00824E398268396DBAB03", hash_generated_field = "1B790D50CC69E7023CCCAB838EB40A4E")

    private static BootClassLoader instance;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.804 -0500", hash_original_method = "D3F85B3CE9250DAE48A2E24200FC3763", hash_generated_method = "863B004167717B564E5F1983A33B20B2")
    
public BootClassLoader() {
        super(null, true);
    }

/*  commented out by droidsafe
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.807 -0500", hash_original_method = "0FBC8B1C710D0CE61299895128455485", hash_generated_method = "32D6ECFE7C4B8FD34375E6F47B87EC79")
    
@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return VMClassLoader.loadClass(name, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.809 -0500", hash_original_method = "917FC7483F620F58EBF15901F64E5CCB", hash_generated_method = "E48B2E1ABBBFDB14A2E817AD71F11F66")
    
@Override
    protected URL findResource(String name) {
        return VMClassLoader.getResource(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.812 -0500", hash_original_method = "16CE054D9A07227EFDD5E4525389B0A1", hash_generated_method = "60637F18C842F9A0DE1718495955912E")
    
@SuppressWarnings("unused")
    @Override
    protected Enumeration<URL> findResources(String resName) throws IOException {
        return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    /**
     * Returns package information for the given package. Unfortunately, the
     * Android BootClassLoader doesn't really have this information, and as a
     * non-secure ClassLoader, it isn't even required to, according to the spec.
     * Yet, we want to provide it, in order to make all those hopeful callers of
     * {@code myClass.getPackage().getName()} happy. Thus we construct a Package
     * object the first time it is being requested and fill most of the fields
     * with dummy values. The Package object is then put into the ClassLoader's
     * Package cache, so we see the same one next time. We don't create Package
     * objects for null arguments or for the default package.
     * <p>
     * There a limited chance that we end up with multiple Package objects
     * representing the same package: It can happen when when a package is
     * scattered across different JAR files being loaded by different
     * ClassLoaders. Rather unlikely, and given that this whole thing is more or
     * less a workaround, probably not worth the effort.
     */
    /*
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.815 -0500", hash_original_method = "F97E0A3F9917A73A09E7D2F766F9C1D2", hash_generated_method = "851BDA5342BA91242176CAD96E2969A6")
    
@Override
    protected Package getPackage(String name) {
        if (name != null && !name.isEmpty()) {
            synchronized (this) {
                Package pack = super.getPackage(name);

                if (pack == null) {
                    pack = definePackage(name, "Unknown", "0.0", "Unknown", "Unknown", "0.0",
                            "Unknown", null);
                }

                return pack;
            }
        }

        return null;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.817 -0500", hash_original_method = "7C22470B48203835E4FECF5A2AF64904", hash_generated_method = "8B65E3A883CFA30DBA872517FDB220B1")
    
@Override
    public URL getResource(String resName) {
        return findResource(resName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.820 -0500", hash_original_method = "0851F7C9918489BAFB5B84B48223EC31", hash_generated_method = "7614BBA93651B81119F6F095CE02426E")
    
@Override
    protected Class<?> loadClass(String className, boolean resolve)
           throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(className);

        if (clazz == null) {
            clazz = findClass(className);
        }

        return clazz;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.823 -0500", hash_original_method = "606DC58E52051EDCF71806278059C734", hash_generated_method = "0400D68394620DA0F28F845E08333898")
    
@Override
    public Enumeration<URL> getResources(String resName) throws IOException {
        return findResources(resName);
    }
*/
}

