package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public final class KeyPair implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.061 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private PrivateKey privateKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.062 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.064 -0400", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "C50326B32CF00A6F329560774769F4F4")
    public  KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.064 -0400", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "D2D631F5B707A220937F4F99617F7CF6")
    public PrivateKey getPrivate() {
PrivateKey varEAD85D869E43E7A2ADE031F4AAD29487_966982082 =         privateKey;
        varEAD85D869E43E7A2ADE031F4AAD29487_966982082.addTaint(taint);
        return varEAD85D869E43E7A2ADE031F4AAD29487_966982082;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.065 -0400", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "4169F24E8988F5A2FDDE1F7DE6B9B931")
    public PublicKey getPublic() {
PublicKey var36BC502DA0D0F28A150F4A1969DBE960_1467046427 =         publicKey;
        var36BC502DA0D0F28A150F4A1969DBE960_1467046427.addTaint(taint);
        return var36BC502DA0D0F28A150F4A1969DBE960_1467046427;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.065 -0400", hash_original_field = "F001F0D9A8033B3A0C703C7323DDB81F", hash_generated_field = "07AAFE09296E79DE4CD9DDFF85CB5BFC")

    private static final long serialVersionUID = -7565189502268009837L;
}

