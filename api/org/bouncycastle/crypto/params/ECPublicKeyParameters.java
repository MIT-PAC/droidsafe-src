package org.bouncycastle.crypto.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.math.ec.ECPoint;

public class ECPublicKeyParameters extends ECKeyParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.564 -0400", hash_original_field = "F09564C9CA56850D4CD6B3319E541AEE", hash_generated_field = "C8FB6318BAABD4F6A26A5EED185B9361")

    ECPoint Q;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.564 -0400", hash_original_method = "845DC3600A042D0F2C7658EA402A255C", hash_generated_method = "9C8790916BCBB854D7707A0FA7272A70")
    public  ECPublicKeyParameters(
        ECPoint             Q,
        ECDomainParameters  params) {
        super(false, params);
        addTaint(params.getTaint());
        this.Q = Q;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.564 -0400", hash_original_method = "F25B4564BF3696B648923BDEC0167553", hash_generated_method = "1D912A6E3C60785C86ACBCC8DC7F9B13")
    public ECPoint getQ() {
ECPoint varFE1D50A5AC7258DF41CB3678D0A2753B_541741214 =         Q;
        varFE1D50A5AC7258DF41CB3678D0A2753B_541741214.addTaint(taint);
        return varFE1D50A5AC7258DF41CB3678D0A2753B_541741214;
        
        
    }

    
}

