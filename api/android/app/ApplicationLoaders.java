package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.PathClassLoader;
import java.util.HashMap;
import java.util.Map;

class ApplicationLoaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.321 -0400", hash_original_field = "384EB772DF8EAF619DFA5F79B74771D8", hash_generated_field = "8341D47F664C030006757000CF63480B")

    private final Map<String, ClassLoader> mLoaders = new HashMap<String, ClassLoader>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.321 -0400", hash_original_method = "B28ECCCB6DE1A645261BEF05FE1982E7", hash_generated_method = "B28ECCCB6DE1A645261BEF05FE1982E7")
    public ApplicationLoaders ()
    {
        
    }


        @DSModeled(DSC.SAFE)
    public static ApplicationLoaders getDefault() {
        return gApplicationLoaders;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.326 -0400", hash_original_method = "EA4DC0433A5C7A22C1BA1C659599A634", hash_generated_method = "296C8BAD2C692DA0E40F38799501CC8A")
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
            } 
    if(parent == baseParent)            
            {
                ClassLoader loader = mLoaders.get(zip);
    if(loader != null)                
                {
ClassLoader var556906CF8230EF926A9ABDA8D8CDBEFA_1959296254 =                     loader;
                    var556906CF8230EF926A9ABDA8D8CDBEFA_1959296254.addTaint(taint);
                    return var556906CF8230EF926A9ABDA8D8CDBEFA_1959296254;
                } 
                PathClassLoader pathClassloader = new PathClassLoader(zip, libPath, parent);
                mLoaders.put(zip, pathClassloader);
ClassLoader var11BD277B934D6BB854C5E9693754CBD2_1467601469 =                 pathClassloader;
                var11BD277B934D6BB854C5E9693754CBD2_1467601469.addTaint(taint);
                return var11BD277B934D6BB854C5E9693754CBD2_1467601469;
            } 
ClassLoader var5C909D560907FF186591EB06317A564A_1240203060 =             new PathClassLoader(zip, parent);
            var5C909D560907FF186591EB06317A564A_1240203060.addTaint(taint);
            return var5C909D560907FF186591EB06317A564A_1240203060;
        } 
        
        
        
            
                
            
            
                
                
                    
                
                
                    
                
                
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.327 -0400", hash_original_field = "601B3B02B74793AF6319AF165B317296", hash_generated_field = "FDBBA88BBDA6D0EE426E19208B3BA381")

    private static final ApplicationLoaders gApplicationLoaders = new ApplicationLoaders();
}

