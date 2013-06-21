package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.PathClassLoader;
import java.util.HashMap;
import java.util.Map;

class ApplicationLoaders {
    private Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.595 -0400", hash_original_method = "D110D82EE084D23C0DEE561B95C3EC75", hash_generated_method = "D110D82EE084D23C0DEE561B95C3EC75")
        public ApplicationLoaders ()
    {
    }


        public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.596 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "AAAA01941C37B00A5C48B27CB568A255")
    @DSModeled(DSC.BAN)
    public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent) {
        dsTaint.addTaint(zip);
        dsTaint.addTaint(libPath);
        dsTaint.addTaint(parent.dsTaint);
        ClassLoader baseParent;
        baseParent = ClassLoader.getSystemClassLoader().getParent();
        {
            {
                parent = baseParent;
            } //End block
            {
                ClassLoader loader;
                loader = mLoaders.get(zip);
                PathClassLoader pathClassloader;
                pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
            } //End block
            ClassLoader varA43AB54FEB2B8C29024C782FEA07BF8A_1143886459 = (new PathClassLoader(zip, parent));
        } //End block
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();
        //synchronized (mLoaders) {
            //if (parent == null) {
                //parent = baseParent;
            //}
            //if (parent == baseParent) {
                //ClassLoader loader = mLoaders.get(zip);
                //if (loader != null) {
                    //return loader;
                //}
                //PathClassLoader pathClassloader =
                    //new PathClassLoader(zip, libPath, parent);
                //mLoaders.put(zip, pathClassloader);
                //return pathClassloader;
            //}
            //return new PathClassLoader(zip, parent);
        //}
    }

    
    private static final ApplicationLoaders gApplicationLoaders
        = new ApplicationLoaders();
}

