package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import dalvik.system.PathClassLoader;





class ApplicationLoaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.315 -0400", hash_original_field = "384EB772DF8EAF619DFA5F79B74771D8", hash_generated_field = "8341D47F664C030006757000CF63480B")

    private final Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.316 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.321 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "C0151DF1CCD25F8DD9BAB049BC0A8388")
    public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent) {
        addTaint(parent.getTaint());
        addTaint(libPath.getTaint());
        addTaint(zip.getTaint());
        ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();
        synchronized
(mLoaders)        {
            if(parent == null)            
            {
                parent = baseParent;
            } //End block
            if(parent == baseParent)            
            {
                ClassLoader loader = mLoaders.get(zip);
                if(loader != null)                
                {
ClassLoader var556906CF8230EF926A9ABDA8D8CDBEFA_536238637 =                     loader;
                    var556906CF8230EF926A9ABDA8D8CDBEFA_536238637.addTaint(taint);
                    return var556906CF8230EF926A9ABDA8D8CDBEFA_536238637;
                } //End block
                PathClassLoader pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
ClassLoader var11BD277B934D6BB854C5E9693754CBD2_1974034617 =                 pathClassloader;
                var11BD277B934D6BB854C5E9693754CBD2_1974034617.addTaint(taint);
                return var11BD277B934D6BB854C5E9693754CBD2_1974034617;
            } //End block
ClassLoader var5C909D560907FF186591EB06317A564A_155378792 =             new PathClassLoader(zip, parent);
            var5C909D560907FF186591EB06317A564A_155378792.addTaint(taint);
            return var5C909D560907FF186591EB06317A564A_155378792;
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.322 -0400", hash_original_field = "601B3B02B74793AF6319AF165B317296", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
}

