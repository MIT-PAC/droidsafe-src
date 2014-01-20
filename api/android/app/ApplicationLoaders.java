package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.PathClassLoader;

class ApplicationLoaders {
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.968 -0500", hash_original_method = "76DB5D07DDEAAF71FF7BD101A2CCF328", hash_generated_method = "164C60B2F6F9D106EE1CEAF9EA0DCC60")
    
public static ApplicationLoaders getDefault()
    {
        return gApplicationLoaders;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.975 -0500", hash_original_field = "EAC090BECD5412DDCDEA99C0EA394D14", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders
        = new ApplicationLoaders();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.973 -0500", hash_original_field = "64F1E474B03EB6AA58F12CB4E98D2462", hash_generated_field = "8341D47F664C030006757000CF63480B")

    private final Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.316 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        //Synthesized constructor
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:58.971 -0500", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "CBA9A0CE4A50ED64B8154F5699F116CF")
    
public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent)
    {
        /*
         * This is the parent we use if they pass "null" in.  In theory
         * this should be the "system" class loader; in practice we
         * don't use that and can happily (and more efficiently) use the
         * bootstrap class loader.
         */
        ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();

        synchronized (mLoaders) {
            if (parent == null) {
                parent = baseParent;
            }

            /*
             * If we're one step up from the base class loader, find
             * something in our cache.  Otherwise, we create a whole
             * new ClassLoader for the zip archive.
             */
            if (parent == baseParent) {
                ClassLoader loader = mLoaders.get(zip);
                if (loader != null) {
                    return loader;
                }
    
                PathClassLoader pathClassloader =
                    new PathClassLoader(zip, libPath, parent);
                
                mLoaders.put(zip, pathClassloader);
                return pathClassloader;
            }

            return new PathClassLoader(zip, parent);
        }
    }
}

