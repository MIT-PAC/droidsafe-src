package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.math.ec.ECPoint;






public class ECPublicKeyParameters extends ECKeyParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.903 -0500", hash_original_field = "C8FB6318BAABD4F6A26A5EED185B9361", hash_generated_field = "C8FB6318BAABD4F6A26A5EED185B9361")

    ECPoint Q;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.904 -0500", hash_original_method = "845DC3600A042D0F2C7658EA402A255C", hash_generated_method = "BF53373BD331D8F640D742826AA8301D")
    public ECPublicKeyParameters(
        ECPoint             Q,
        ECDomainParameters  params)
    {
        super(false, params);
        this.Q = Q;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.905 -0500", hash_original_method = "F25B4564BF3696B648923BDEC0167553", hash_generated_method = "34102DCD05D4531D1316298630225166")
    public ECPoint getQ()
    {
        return Q;
    }

    
}

