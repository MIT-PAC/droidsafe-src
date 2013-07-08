package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public abstract class BasicPermission extends Permission implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.112 -0400", hash_original_method = "D7C15085897CB0E8D87B48429476636B", hash_generated_method = "EBDBEF6EF7CE8B0F1566EF95CE070D5E")
    public  BasicPermission(String name) {
        super("");
        addTaint(name.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.113 -0400", hash_original_method = "70983AE2C4FC471A8D797105AE850E32", hash_generated_method = "21930165FB8CCC2AD7D53977F13A8084")
    public  BasicPermission(String name, String action) {
        super("");
        addTaint(name.getTaint());
        addTaint(action.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.115 -0400", hash_original_method = "1D3A92DE09AD9A3275C68C126C1F0E4E", hash_generated_method = "1A36F98901685622475B27784A722A69")
    @Override
    public String getActions() {
        String varB4EAC82CA7396A68D541C85D26508E83_1043416305 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1043416305 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1043416305.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1043416305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.116 -0400", hash_original_method = "15107D2478EB5CA607140B3E4F96BD4D", hash_generated_method = "1CD8629F59BF8DDBC90BB9AAE49F1CAD")
    @Override
    public boolean implies(Permission permission) {
        addTaint(permission.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912392885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912392885;
        
        
    }

    
}

