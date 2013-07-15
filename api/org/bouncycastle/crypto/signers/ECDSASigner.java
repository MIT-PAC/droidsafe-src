package org.bouncycastle.crypto.signers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.405 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "7932DEDC4CDEDAFB3B5643FD9FB304D6")

    ECKeyParameters key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.405 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9")

    SecureRandom random;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.405 -0400", hash_original_method = "C1322FCAE454F44B8363BD2382FAD546", hash_generated_method = "C1322FCAE454F44B8363BD2382FAD546")
    public ECDSASigner ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.406 -0400", hash_original_method = "7C8BB5DB49DEBEADD4F3AE9B9DC1372A", hash_generated_method = "5B9F3CECBEC5DD7F6FF9FEA0E90278F7")
    public void init(
        boolean                 forSigning,
        CipherParameters        param) {
        addTaint(forSigning);
    if(forSigning)        
        {
    if(param instanceof ParametersWithRandom)            
            {
                ParametersWithRandom rParam = (ParametersWithRandom)param;
                this.random = rParam.getRandom();
                this.key = (ECPrivateKeyParameters)rParam.getParameters();
            } //End block
            else
            {
                this.random = new SecureRandom();
                this.key = (ECPrivateKeyParameters)param;
            } //End block
        } //End block
        else
        {
            this.key = (ECPublicKeyParameters)param;
        } //End block
        // ---------- Original Method ----------
        //if (forSigning)
        //{
            //if (param instanceof ParametersWithRandom)
            //{
                //ParametersWithRandom    rParam = (ParametersWithRandom)param;
                //this.random = rParam.getRandom();
                //this.key = (ECPrivateKeyParameters)rParam.getParameters();
            //}
            //else
            //{
                //this.random = new SecureRandom();
                //this.key = (ECPrivateKeyParameters)param;
            //}
        //}
        //else
        //{
            //this.key = (ECPublicKeyParameters)param;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.407 -0400", hash_original_method = "FB5DF316F460707F8207D2FB11462865", hash_generated_method = "0AABF76A6417D157D90CE53565E0DB33")
    public BigInteger[] generateSignature(
        byte[] message) {
        addTaint(message[0]);
        BigInteger n = key.getParameters().getN();
        BigInteger e = calculateE(n, message);
        BigInteger r = null;
        BigInteger s = null;
        do {
            {
                BigInteger k = null;
                int nBitLength = n.bitLength();
                do {
                    {
                        do {
                            {
                                k = new BigInteger(nBitLength, random);
                            } //End block
} while (k.equals(ZERO) || k.compareTo(n) >= 0);
                        ECPoint p = key.getParameters().getG().multiply(k);
                        BigInteger x = p.getX().toBigInteger();
                        r = x.mod(n);
                    } //End block
} while (r.equals(ZERO));
                BigInteger d = ((ECPrivateKeyParameters)key).getD();
                s = k.modInverse(n).multiply(e.add(d.multiply(r))).mod(n);
            } //End block
} while (s.equals(ZERO));
        BigInteger[] res = new BigInteger[2];
        res[0] = r;
        res[1] = s;
BigInteger[] varB5053E025797B3BF768F5C37934C244D_733768322 =         res;
        varB5053E025797B3BF768F5C37934C244D_733768322.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_733768322;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.408 -0400", hash_original_method = "16EB9D1F1ED26940A9147EEAE266AF00", hash_generated_method = "582FB93F4E7A9C8CDA7A9863E5D05F36")
    public boolean verifySignature(
        byte[]      message,
        BigInteger  r,
        BigInteger  s) {
        addTaint(s.getTaint());
        addTaint(r.getTaint());
        addTaint(message[0]);
        BigInteger n = key.getParameters().getN();
        BigInteger e = calculateE(n, message);
    if(r.compareTo(ONE) < 0 || r.compareTo(n) >= 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_178620004 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942402946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_942402946;
        } //End block
    if(s.compareTo(ONE) < 0 || s.compareTo(n) >= 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1208822641 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139230099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139230099;
        } //End block
        BigInteger c = s.modInverse(n);
        BigInteger u1 = e.multiply(c).mod(n);
        BigInteger u2 = r.multiply(c).mod(n);
        ECPoint G = key.getParameters().getG();
        ECPoint Q = ((ECPublicKeyParameters)key).getQ();
        ECPoint point = ECAlgorithms.sumOfTwoMultiplies(G, u1, Q, u2);
        BigInteger v = point.getX().toBigInteger().mod(n);
        boolean var0DB0FBCFAB98A173AE959039A84C881B_1496540495 = (v.equals(r));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_328756327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_328756327;
        // ---------- Original Method ----------
        //BigInteger n = key.getParameters().getN();
        //BigInteger e = calculateE(n, message);
        //if (r.compareTo(ONE) < 0 || r.compareTo(n) >= 0)
        //{
            //return false;
        //}
        //if (s.compareTo(ONE) < 0 || s.compareTo(n) >= 0)
        //{
            //return false;
        //}
        //BigInteger c = s.modInverse(n);
        //BigInteger u1 = e.multiply(c).mod(n);
        //BigInteger u2 = r.multiply(c).mod(n);
        //ECPoint G = key.getParameters().getG();
        //ECPoint Q = ((ECPublicKeyParameters)key).getQ();
        //ECPoint point = ECAlgorithms.sumOfTwoMultiplies(G, u1, Q, u2);
        //BigInteger v = point.getX().toBigInteger().mod(n);
        //return v.equals(r);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.409 -0400", hash_original_method = "D79E78A694EF1FC7CCC97532E7031B66", hash_generated_method = "A5BC2AEF217DF04E15FFFD02C5C5A995")
    private BigInteger calculateE(BigInteger n, byte[] message) {
        addTaint(message[0]);
        addTaint(n.getTaint());
    if(n.bitLength() > message.length * 8)        
        {
BigInteger var2A58862D25CF80D0C74EED713D3F25E0_1221433584 =             new BigInteger(1, message);
            var2A58862D25CF80D0C74EED713D3F25E0_1221433584.addTaint(taint);
            return var2A58862D25CF80D0C74EED713D3F25E0_1221433584;
        } //End block
        else
        {
            int messageBitLength = message.length * 8;
            BigInteger trunc = new BigInteger(1, message);
    if(messageBitLength - n.bitLength() > 0)            
            {
                trunc = trunc.shiftRight(messageBitLength - n.bitLength());
            } //End block
BigInteger varAB34F6DE565C1B6F3B64505651718BEC_1776318518 =             trunc;
            varAB34F6DE565C1B6F3B64505651718BEC_1776318518.addTaint(taint);
            return varAB34F6DE565C1B6F3B64505651718BEC_1776318518;
        } //End block
        // ---------- Original Method ----------
        //if (n.bitLength() > message.length * 8)
        //{
            //return new BigInteger(1, message);
        //}
        //else
        //{
            //int messageBitLength = message.length * 8;
            //BigInteger trunc = new BigInteger(1, message);
            //if (messageBitLength - n.bitLength() > 0)
            //{
                //trunc = trunc.shiftRight(messageBitLength - n.bitLength());
            //}
            //return trunc;
        //}
    }

    
}

