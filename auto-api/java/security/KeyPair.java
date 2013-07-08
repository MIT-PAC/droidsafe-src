package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public final class KeyPair implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.204 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private PrivateKey privateKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.204 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.206 -0400", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "C50326B32CF00A6F329560774769F4F4")
    public  KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.207 -0400", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "27E48F9754E45EEDD94898D9B1717ED4")
    public PrivateKey getPrivate() {
        PrivateKey varB4EAC82CA7396A68D541C85D26508E83_1547358738 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1547358738 = privateKey;
        varB4EAC82CA7396A68D541C85D26508E83_1547358738.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1547358738;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.207 -0400", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "CE2D16345DF0ED526B93DDDE7E0431BE")
    public PublicKey getPublic() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_1622256019 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1622256019 = publicKey;
        varB4EAC82CA7396A68D541C85D26508E83_1622256019.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1622256019;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.207 -0400", hash_original_field = "F001F0D9A8033B3A0C703C7323DDB81F", hash_generated_field = "07AAFE09296E79DE4CD9DDFF85CB5BFC")

    private static final long serialVersionUID = -7565189502268009837L;
}

