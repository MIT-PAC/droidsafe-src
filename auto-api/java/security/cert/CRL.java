package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class CRL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.689 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.690 -0400", hash_original_method = "F343602788E22E62E7F41ECF989C2105", hash_generated_method = "61E7826751DBB365A55127637BE7FF03")
    protected  CRL(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.690 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "25852E0B398D8767FB07EE2F830D5F33")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1377032621 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1377032621 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1377032621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1377032621;
        // ---------- Original Method ----------
        //return type;
    }

    
    public abstract boolean isRevoked(Certificate cert);

    
    public abstract String toString();

    
}

