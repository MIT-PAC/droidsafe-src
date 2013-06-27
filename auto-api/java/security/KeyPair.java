package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public final class KeyPair implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.206 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "0BDA09A35A184B3500330A0D915760C1")

    private PrivateKey privateKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.206 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "597E676F0E34E7523D486C2FEA821479")

    private PublicKey publicKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.207 -0400", hash_original_method = "283304EE488E7CC511471A1BB564958E", hash_generated_method = "C50326B32CF00A6F329560774769F4F4")
    public  KeyPair(PublicKey publicKey, PrivateKey privateKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        // ---------- Original Method ----------
        //this.privateKey = privateKey;
        //this.publicKey = publicKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.207 -0400", hash_original_method = "3FFC913C725561B27B9684931E08C69F", hash_generated_method = "A73E5E6323808B49090720165A0BBB77")
    public PrivateKey getPrivate() {
        PrivateKey varB4EAC82CA7396A68D541C85D26508E83_1649526556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649526556 = privateKey;
        varB4EAC82CA7396A68D541C85D26508E83_1649526556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649526556;
        // ---------- Original Method ----------
        //return privateKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.213 -0400", hash_original_method = "6C6DB8409915627C7F2AEC2B5C46974F", hash_generated_method = "F32171ADA34A5ABAD189F131732D57D9")
    public PublicKey getPublic() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_1597725649 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1597725649 = publicKey;
        varB4EAC82CA7396A68D541C85D26508E83_1597725649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597725649;
        // ---------- Original Method ----------
        //return publicKey;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.213 -0400", hash_original_field = "F001F0D9A8033B3A0C703C7323DDB81F", hash_generated_field = "E908B1A47AEC7F9746E7CCA7073F35FF")

    private static long serialVersionUID = -7565189502268009837L;
}

