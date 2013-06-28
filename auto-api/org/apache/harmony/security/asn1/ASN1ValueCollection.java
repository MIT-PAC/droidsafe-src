package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Collection;

public abstract class ASN1ValueCollection extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.704 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public ASN1Type type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.704 -0400", hash_original_method = "50DEBE44F0AD632419D22CF3D0ACBF84", hash_generated_method = "F41295BB5AF12CD5DB16FA98915466CC")
    public  ASN1ValueCollection(int tagNumber, ASN1Type type) {
        super(tagNumber);
        this.type = type;
        addTaint(tagNumber);
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.705 -0400", hash_original_method = "738CC0DE26C0029C09ABE092A492DCB2", hash_generated_method = "A50572932670E6D9AA7D169C913544C9")
    public Collection<?> getValues(Object object) {
        Collection<?> varB4EAC82CA7396A68D541C85D26508E83_1015187185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1015187185 = (Collection<?>) object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1015187185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015187185;
        // ---------- Original Method ----------
        //return (Collection<?>) object;
    }

    
}

