package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class CRL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.906 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.907 -0400", hash_original_method = "F343602788E22E62E7F41ECF989C2105", hash_generated_method = "61E7826751DBB365A55127637BE7FF03")
    protected  CRL(String type) {
        this.type = type;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.908 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "4BEF4141F669F27D3DFD0848E73EEE3A")
    public final String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_600751078 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_600751078 = type;
        varB4EAC82CA7396A68D541C85D26508E83_600751078.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_600751078;
        
        
    }

    
    public abstract boolean isRevoked(Certificate cert);

    
    public abstract String toString();

    
}

