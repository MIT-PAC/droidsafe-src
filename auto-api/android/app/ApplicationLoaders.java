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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.344 -0400", hash_original_field = "384EB772DF8EAF619DFA5F79B74771D8", hash_generated_field = "8341D47F664C030006757000CF63480B")

    private final Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.344 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        //Synthesized constructor
    }


    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.346 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "A89A65FBF102E03ED87FE2032994B668")
    public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent) {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_939439511 = null; //Variable for return #1
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_2122673270 = null; //Variable for return #2
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_920869119 = null; //Variable for return #3
        ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();
        {
            {
                parent = baseParent;
            } //End block
            {
                ClassLoader loader = mLoaders.get(zip);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_939439511 = loader;
                } //End block
                PathClassLoader pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
                varB4EAC82CA7396A68D541C85D26508E83_2122673270 = pathClassloader;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_920869119 = new PathClassLoader(zip, parent);
        } //End block
        addTaint(zip.getTaint());
        addTaint(libPath.getTaint());
        addTaint(parent.getTaint());
        ClassLoader varA7E53CE21691AB073D9660D615818899_1658515325; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_939439511;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_2122673270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_920869119;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1658515325.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1658515325;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.346 -0400", hash_original_field = "601B3B02B74793AF6319AF165B317296", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
}

