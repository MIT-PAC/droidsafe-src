package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
        
    }


    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.346 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "A89A65FBF102E03ED87FE2032994B668")
    public ClassLoader getClassLoader(String zip, String libPath, ClassLoader parent) {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_939439511 = null; 
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_2122673270 = null; 
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_920869119 = null; 
        ClassLoader baseParent = ClassLoader.getSystemClassLoader().getParent();
        {
            {
                parent = baseParent;
            } 
            {
                ClassLoader loader = mLoaders.get(zip);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_939439511 = loader;
                } 
                PathClassLoader pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
                varB4EAC82CA7396A68D541C85D26508E83_2122673270 = pathClassloader;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_920869119 = new PathClassLoader(zip, parent);
        } 
        addTaint(zip.getTaint());
        addTaint(libPath.getTaint());
        addTaint(parent.getTaint());
        ClassLoader varA7E53CE21691AB073D9660D615818899_1658515325; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_939439511;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_2122673270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1658515325 = varB4EAC82CA7396A68D541C85D26508E83_920869119;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1658515325.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1658515325;
        
        
        
            
                
            
            
                
                
                    
                
                
                    
                
                
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.346 -0400", hash_original_field = "601B3B02B74793AF6319AF165B317296", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
}

