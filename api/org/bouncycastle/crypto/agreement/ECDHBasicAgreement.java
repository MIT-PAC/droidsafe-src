package org.bouncycastle.crypto.agreement;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECPoint;






public class ECDHBasicAgreement implements BasicAgreement {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:56.045 -0500", hash_original_field = "CF6232C3E0511A4B7D31E1B88F324CFB", hash_generated_field = "33F61DD1418CAC13EC66C645A8578DF2")

    private ECPrivateKeyParameters key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.493 -0400", hash_original_method = "96D932906701A5168A9F039F437639FE", hash_generated_method = "96D932906701A5168A9F039F437639FE")
    public ECDHBasicAgreement ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:56.046 -0500", hash_original_method = "C673BA12443BA4859FBCFCA898D52D2A", hash_generated_method = "39917E5490CC18BD63A70FFCADE7E15B")
    public void init(
        CipherParameters key)
    {
        this.key = (ECPrivateKeyParameters)key;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:56.047 -0500", hash_original_method = "A4626478FBEED8D6DC4BEF1AE35576B3", hash_generated_method = "E57B437FB90F9CA071355CDDABF453E6")
    public BigInteger calculateAgreement(
        CipherParameters pubKey)
    {
        ECPublicKeyParameters pub = (ECPublicKeyParameters)pubKey;
        ECPoint P = pub.getQ().multiply(key.getD());

        // if (p.isInfinity()) throw new RuntimeException("d*Q == infinity");

        return P.getX().toBigInteger();
    }

    
}

