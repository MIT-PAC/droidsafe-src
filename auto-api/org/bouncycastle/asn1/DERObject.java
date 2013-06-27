package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class DERObject extends ASN1Encodable implements DERTags {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.152 -0400", hash_original_method = "75E493BEC3007387001199C11DB165C7", hash_generated_method = "75E493BEC3007387001199C11DB165C7")
    public DERObject ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.153 -0400", hash_original_method = "E2D1E8CC85ED259FA016D4CED2E671CA", hash_generated_method = "36AA8E9D7A90FB2335A09AEFFBB69579")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1589432239 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589432239 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1589432239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589432239;
        // ---------- Original Method ----------
        //return this;
    }

    
    public abstract int hashCode();

    
    public abstract boolean equals(Object o);

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
}

