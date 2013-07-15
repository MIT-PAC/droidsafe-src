package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class DERObject extends ASN1Encodable implements DERTags {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.107 -0400", hash_original_method = "75E493BEC3007387001199C11DB165C7", hash_generated_method = "75E493BEC3007387001199C11DB165C7")
    public DERObject ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.107 -0400", hash_original_method = "E2D1E8CC85ED259FA016D4CED2E671CA", hash_generated_method = "93B92DE4621D5D98BC11B3D37D19333A")
    public DERObject toASN1Object() {
DERObject var72A74007B2BE62B849F475C7BDA4658B_184107308 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_184107308.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_184107308;
        // ---------- Original Method ----------
        //return this;
    }

    
    public abstract int hashCode();

    
    public abstract boolean equals(Object o);

    
    abstract void encode(DEROutputStream out)
        throws IOException;

    
}

