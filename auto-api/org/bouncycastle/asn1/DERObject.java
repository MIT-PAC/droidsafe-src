package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public abstract class DERObject extends ASN1Encodable implements DERTags {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.566 -0400", hash_original_method = "75E493BEC3007387001199C11DB165C7", hash_generated_method = "75E493BEC3007387001199C11DB165C7")
    public DERObject ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.567 -0400", hash_original_method = "E2D1E8CC85ED259FA016D4CED2E671CA", hash_generated_method = "0656ADF04C7060A5E0407A835BCDDB44")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1747163237 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1747163237 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1747163237.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1747163237;
        
        
    }

    
    public abstract int hashCode();

    
    public abstract boolean equals(Object o);

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
}

