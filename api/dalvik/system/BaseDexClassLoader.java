package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.net.URL;
import java.util.Enumeration;






public class BaseDexClassLoader extends ClassLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.056 -0500", hash_original_field = "591C7231D87F27EA57DB8A8DF440323B", hash_generated_field = "3A1905766FA74BE7F45BBB06C9F84A8F")

    private  String originalPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.057 -0500", hash_original_field = "BC73B6CB149F479B3FE55F580A986E0D", hash_generated_field = "139BAEC5E13F7EB5F6959327397357CD")

    private  DexPathList pathList;

    /**
     * Constructs an instance.
     *
     * @param dexPath the list of jar/apk files containing classes and
     * resources, delimited by {@code File.pathSeparator}, which
     * defaults to {@code ":"} on Android
     * @param optimizedDirectory directory where optimized dex files
     * should be written; may be {@code null}
     * @param libraryPath the list of directories containing native
     * libraries, delimited by {@code File.pathSeparator}; may be
     * {@code null}
     * @param parent the parent class loader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.058 -0500", hash_original_method = "ADD286CC7B907BF4568C827AC1E89193", hash_generated_method = "03E27195D3EF45CA8877FD845E83A195")
    public BaseDexClassLoader(String dexPath, File optimizedDirectory,
            String libraryPath, ClassLoader parent) {
        super(parent);

        this.originalPath = dexPath;
        this.pathList =
            new DexPathList(this, dexPath, libraryPath, optimizedDirectory);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.059 -0500", hash_original_method = "521C939EE5D3EB6850693DC0AA73197C", hash_generated_method = "DDAFA5C442C96740FC2386D85B5A3B8E")
    @Override
protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = pathList.findClass(name);

        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }

        return clazz;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.060 -0500", hash_original_method = "7470A380EF1D93E773CA71CCC45CC5DC", hash_generated_method = "BD6F8E123ED53123968052E60E624566")
    @Override
protected URL findResource(String name) {
        return pathList.findResource(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.061 -0500", hash_original_method = "7D0FB955FF80F0A3807920CE00840D77", hash_generated_method = "0E1C988330779AED9FEC90F03D5BC12D")
    @Override
protected Enumeration<URL> findResources(String name) {
        return pathList.findResources(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.061 -0500", hash_original_method = "C00307207743233EB6F3CC5C62BA4C3A", hash_generated_method = "72F3177A117D8994994E36C8CF57E1C1")
    @Override
public String findLibrary(String name) {
        return pathList.findLibrary(name);
    }

    /**
     * Returns package information for the given package.
     * Unfortunately, instances of this class don't really have this
     * information, and as a non-secure {@code ClassLoader}, it isn't
     * even required to, according to the spec. Yet, we want to
     * provide it, in order to make all those hopeful callers of
     * {@code myClass.getPackage().getName()} happy. Thus we construct
     * a {@code Package} object the first time it is being requested
     * and fill most of the fields with dummy values. The {@code
     * Package} object is then put into the {@code ClassLoader}'s
     * package cache, so we see the same one next time. We don't
     * create {@code Package} objects for {@code null} arguments or
     * for the default package.
     *
     * <p>There is a limited chance that we end up with multiple
     * {@code Package} objects representing the same package: It can
     * happen when when a package is scattered across different JAR
     * files which were loaded by different {@code ClassLoader}
     * instances. This is rather unlikely, and given that this whole
     * thing is more or less a workaround, probably not worth the
     * effort to address.
     *
     * @param name the name of the class
     * @return the package information for the class, or {@code null}
     * if there is no package information available for it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.062 -0500", hash_original_method = "CA22ACC2BBED318A2E853CC270258DF9", hash_generated_method = "1C71499B6A9BAE929FEA7A8293AB5740")
    @Override
protected synchronized Package getPackage(String name) {
        if (name != null && !name.isEmpty()) {
            Package pack = super.getPackage(name);

            if (pack == null) {
                pack = definePackage(name, "Unknown", "0.0", "Unknown",
                        "Unknown", "0.0", "Unknown", null);
            }

            return pack;
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:45.063 -0500", hash_original_method = "A4316A3AABC51F9CE057485DF0B501BC", hash_generated_method = "075B5B44C3B2C067E6CF57A89C67B78F")
    @Override
public String toString() {
        return getClass().getName() + "[" + originalPath + "]";
    }

    
}

