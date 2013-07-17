package org.bouncycastle.math.ec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

class ZTauElement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.931 -0400", hash_original_field = "7B774EFFE4A349C6DD82AD4F4F21D34C", hash_generated_field = "40CFD1A249FCA5B191A31B3219FCE18D")

    public BigInteger u;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.931 -0400", hash_original_field = "9E3669D19B675BD57058FD4664205D2A", hash_generated_field = "4AF300B5ED0FE2C906C983063C9150AB")

    public BigInteger v;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.932 -0400", hash_original_method = "A3D4CB97AD018D8DBE3665C338C0704B", hash_generated_method = "9C00FBE4B2049A69994EC1F561802173")
    public  ZTauElement(BigInteger u, BigInteger v) {
        this.u = u;
        this.v = v;
        // ---------- Original Method ----------
        //this.u = u;
        //this.v = v;
    }

    
}

