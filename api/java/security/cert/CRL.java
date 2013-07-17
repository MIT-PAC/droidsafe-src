package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class CRL {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.589 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.589 -0400", hash_original_method = "F343602788E22E62E7F41ECF989C2105", hash_generated_method = "61E7826751DBB365A55127637BE7FF03")
    protected  CRL(String type) {
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.590 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "2C8C8E7F8DE017B63C46726F4267CD7D")
    public final String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1161594478 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1161594478.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1161594478;
        // ---------- Original Method ----------
        //return type;
    }

    
    public abstract boolean isRevoked(Certificate cert);

    
    public abstract String toString();

    
}

