package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;






public class ECPrivateKeyParameters extends ECKeyParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.989 -0500", hash_original_field = "847B0497A067F6BE25641FCE5CC53AC4", hash_generated_field = "847B0497A067F6BE25641FCE5CC53AC4")

    BigInteger d;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.990 -0500", hash_original_method = "3E1EB3A7DBE6ED84D84FB2E1282C4A30", hash_generated_method = "783232274A807330EAE16BE424B02293")
    public ECPrivateKeyParameters(
        BigInteger          d,
        ECDomainParameters  params)
    {
        super(true, params);
        this.d = d;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:55.991 -0500", hash_original_method = "B5E3561B233EAECFFADA1FA5EF03DD9A", hash_generated_method = "AC3B54BFF83DC9E4D4975D932DAAF3D4")
    public BigInteger getD()
    {
        return d;
    }

    
}

