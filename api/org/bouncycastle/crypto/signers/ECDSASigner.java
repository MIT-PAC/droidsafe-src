package org.bouncycastle.crypto.signers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

public class ECDSASigner implements ECConstants, DSA {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.994 -0500", hash_original_field = "7932DEDC4CDEDAFB3B5643FD9FB304D6", hash_generated_field = "7932DEDC4CDEDAFB3B5643FD9FB304D6")

    ECKeyParameters key;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.996 -0500", hash_original_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9", hash_generated_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9")

    SecureRandom    random;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.158 -0400", hash_original_method = "C1322FCAE454F44B8363BD2382FAD546", hash_generated_method = "C1322FCAE454F44B8363BD2382FAD546")
    public ECDSASigner ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.999 -0500", hash_original_method = "7C8BB5DB49DEBEADD4F3AE9B9DC1372A", hash_generated_method = "88EC3284FBB4741014395966666AB541")
    
public void init(
        boolean                 forSigning,
        CipherParameters        param)
    {
        if (forSigning)
        {
            if (param instanceof ParametersWithRandom)
            {
                ParametersWithRandom    rParam = (ParametersWithRandom)param;

                this.random = rParam.getRandom();
                this.key = (ECPrivateKeyParameters)rParam.getParameters();
            }
            else
            {
                this.random = new SecureRandom();
                this.key = (ECPrivateKeyParameters)param;
            }
        }
        else
        {
            this.key = (ECPublicKeyParameters)param;
        }
    }

    // 5.3 pg 28
    /**
     * generate a signature for the given message using the key we were
     * initialised with. For conventional DSA the message should be a SHA-1
     * hash of the message of interest.
     *
     * @param message the message that will be verified later.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.001 -0500", hash_original_method = "FB5DF316F460707F8207D2FB11462865", hash_generated_method = "1E12FE92F1A6015CF45623C67A4786B3")
    
public BigInteger[] generateSignature(
        byte[] message)
    {
        BigInteger n = key.getParameters().getN();
        BigInteger e = calculateE(n, message);
        BigInteger r = null;
        BigInteger s = null;

        // 5.3.2
        do // generate s
        {
            BigInteger k = null;
            int        nBitLength = n.bitLength();

            do // generate r
            {
                do
                {
                    k = new BigInteger(nBitLength, random);
                }
                while (k.equals(ZERO) || k.compareTo(n) >= 0);

                ECPoint p = key.getParameters().getG().multiply(k);

                // 5.3.3
                BigInteger x = p.getX().toBigInteger();

                r = x.mod(n);
            }
            while (r.equals(ZERO));

            BigInteger d = ((ECPrivateKeyParameters)key).getD();

            s = k.modInverse(n).multiply(e.add(d.multiply(r))).mod(n);
        }
        while (s.equals(ZERO));

        BigInteger[]  res = new BigInteger[2];

        res[0] = r;
        res[1] = s;

        return res;
    }

    // 5.4 pg 29
    /**
     * return true if the value r and s represent a DSA signature for
     * the passed in message (for standard DSA the message should be
     * a SHA-1 hash of the real message to be verified).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.004 -0500", hash_original_method = "16EB9D1F1ED26940A9147EEAE266AF00", hash_generated_method = "319815EF84D49A0963FB89C5F675344D")
    
public boolean verifySignature(
        byte[]      message,
        BigInteger  r,
        BigInteger  s)
    {
        BigInteger n = key.getParameters().getN();
        BigInteger e = calculateE(n, message);

        // r in the range [1,n-1]
        if (r.compareTo(ONE) < 0 || r.compareTo(n) >= 0)
        {
            return false;
        }

        // s in the range [1,n-1]
        if (s.compareTo(ONE) < 0 || s.compareTo(n) >= 0)
        {
            return false;
        }

        BigInteger c = s.modInverse(n);

        BigInteger u1 = e.multiply(c).mod(n);
        BigInteger u2 = r.multiply(c).mod(n);

        ECPoint G = key.getParameters().getG();
        ECPoint Q = ((ECPublicKeyParameters)key).getQ();

        ECPoint point = ECAlgorithms.sumOfTwoMultiplies(G, u1, Q, u2);

        BigInteger v = point.getX().toBigInteger().mod(n);

        return v.equals(r);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.007 -0500", hash_original_method = "D79E78A694EF1FC7CCC97532E7031B66", hash_generated_method = "DB253561ABCDFC0B002646CAA76B0434")
    
private BigInteger calculateE(BigInteger n, byte[] message)
    {  
        if (n.bitLength() > message.length * 8)
        {
            return new BigInteger(1, message);
        }
        else
        {
            int messageBitLength = message.length * 8;
            BigInteger trunc = new BigInteger(1, message);

            if (messageBitLength - n.bitLength() > 0)
            {
                trunc = trunc.shiftRight(messageBitLength - n.bitLength());
            }

            return trunc;
        }
    }
    
}

