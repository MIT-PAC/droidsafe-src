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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.639 -0400", hash_original_field = "384EB772DF8EAF619DFA5F79B74771D8", hash_generated_field = "86A3F778247ED24A2FDE98F7E9125B07")

    private Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.639 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        //Synthesized constructor
    }


        public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.671 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "ED4E2FBCF24AB435A33AE8A15CC2FEAA")
    public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent) {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1902468212 = null; //Variable for return #1
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1758441018 = null; //Variable for return #2
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1084544365 = null; //Variable for return #3
        ClassLoader baseParent;
        baseParent = ClassLoader.getSystemClassLoader().getParent();
        {
            {
                parent = baseParent;
            } //End block
            {
                ClassLoader loader;
                loader = mLoaders.get(zip);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1902468212 = loader;
                } //End block
                PathClassLoader pathClassloader;
                pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
                varB4EAC82CA7396A68D541C85D26508E83_1758441018 = pathClassloader;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1084544365 = new PathClassLoader(zip, parent);
        } //End block
        addTaint(zip.getTaint());
        addTaint(libPath.getTaint());
        addTaint(parent.getTaint());
        ClassLoader varA7E53CE21691AB073D9660D615818899_307855783; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_307855783 = varB4EAC82CA7396A68D541C85D26508E83_1902468212;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_307855783 = varB4EAC82CA7396A68D541C85D26508E83_1758441018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_307855783 = varB4EAC82CA7396A68D541C85D26508E83_1084544365;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_307855783.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_307855783;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.672 -0400", hash_original_field = "601B3B02B74793AF6319AF165B317296", hash_generated_field = "636B7873A56F2B01364617FE97DE0DBB")

    private static ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
}

