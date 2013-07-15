package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;

public class ECPrivateKeyParameters extends ECKeyParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.561 -0400", hash_original_field = "8277E0910D750195B448797616E091AD", hash_generated_field = "847B0497A067F6BE25641FCE5CC53AC4")

    BigInteger d;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.561 -0400", hash_original_method = "3E1EB3A7DBE6ED84D84FB2E1282C4A30", hash_generated_method = "2AE77BD1AA996B0448C63F955C16315B")
    public  ECPrivateKeyParameters(
        BigInteger          d,
        ECDomainParameters  params) {
        super(true, params);
        addTaint(params.getTaint());
        this.d = d;
        // ---------- Original Method ----------
        //this.d = d;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.562 -0400", hash_original_method = "B5E3561B233EAECFFADA1FA5EF03DD9A", hash_generated_method = "3737E7505ACAF9A8152926B32DF3EF17")
    public BigInteger getD() {
BigInteger varBE245B24E7ED509FDFAAA6CD39E35D89_1821606250 =         d;
        varBE245B24E7ED509FDFAAA6CD39E35D89_1821606250.addTaint(taint);
        return varBE245B24E7ED509FDFAAA6CD39E35D89_1821606250;
        // ---------- Original Method ----------
        //return d;
    }

    
}

