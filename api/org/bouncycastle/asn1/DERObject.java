package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class DERObject extends ASN1Encodable implements DERTags {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.404 -0400", hash_original_method = "75E493BEC3007387001199C11DB165C7", hash_generated_method = "75E493BEC3007387001199C11DB165C7")
    public DERObject ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.405 -0400", hash_original_method = "E2D1E8CC85ED259FA016D4CED2E671CA", hash_generated_method = "17E8C6329E310989818333AE8524AEE4")
    public DERObject toASN1Object() {
DERObject var72A74007B2BE62B849F475C7BDA4658B_1418859672 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1418859672.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1418859672;
        // ---------- Original Method ----------
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int hashCode();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean equals(Object o);

    
    @DSModeled(DSC.SAFE)
    abstract void encode(DEROutputStream out)
        throws IOException;

    
}

