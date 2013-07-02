package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.Permission;

public final class FilePermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.978 -0400", hash_original_method = "59DC5A74444A3A71F70AFFCCC541A824", hash_generated_method = "1D6ABE28C4E24AF0225E5E4D7FF3E26F")
    public  FilePermission(String path, String actions) {
        super("");
        addTaint(path.getTaint());
        addTaint(actions.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.978 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "1CC119C7F7519FED5F62824683A7F040")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_637985304 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_637985304 = null;
        varB4EAC82CA7396A68D541C85D26508E83_637985304.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_637985304;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.978 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "5CC6DD310A5ABBAA8EEF6037B235A6D2")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590606854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590606854;
        
        
    }

    
}

