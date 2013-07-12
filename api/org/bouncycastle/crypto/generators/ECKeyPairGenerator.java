package org.bouncycastle.crypto.generators;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECPoint;

public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, ECConstants {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.276 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "1AFC7445D28E654B0EF1545F8475DF56")

    ECDomainParameters params;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.276 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9")

    SecureRandom random;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.277 -0400", hash_original_method = "179E873A290E5A119544D1E31906496A", hash_generated_method = "179E873A290E5A119544D1E31906496A")
    public ECKeyPairGenerator ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.277 -0400", hash_original_method = "D75087D014852658987FF99D82A818E7", hash_generated_method = "ED22A77DBCDF12909424D982E1B4C1E1")
    public void init(
        KeyGenerationParameters param) {
        addTaint(param.getTaint());
        ECKeyGenerationParameters ecP = (ECKeyGenerationParameters)param;
        this.random = ecP.getRandom();
        this.params = ecP.getDomainParameters();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.277 -0400", hash_original_method = "BE753751E7356A8E17BBC3B84C55A0A8", hash_generated_method = "F0D321308E27D97D93C8F1A50E9DA352")
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger n = params.getN();
        int nBitLength = n.bitLength();
        BigInteger d;
        do {
            {
                d = new BigInteger(nBitLength, random);
            } 
} while (d.equals(ZERO)  || (d.compareTo(n) >= 0));
        ECPoint Q = params.getG().multiply(d);
AsymmetricCipherKeyPair varF53F406CBD2E0867E11BA68B1CDE34E8_1529384770 =         new AsymmetricCipherKeyPair(
            new ECPublicKeyParameters(Q, params),
            new ECPrivateKeyParameters(d, params));
        varF53F406CBD2E0867E11BA68B1CDE34E8_1529384770.addTaint(taint);
        return varF53F406CBD2E0867E11BA68B1CDE34E8_1529384770;
        
        
        
        
        
        
            
        
        
        
        
            
            
    }

    
}

