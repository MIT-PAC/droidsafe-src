package org.bouncycastle.crypto.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class ECKeyGenerationParameters extends KeyGenerationParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.339 -0400", hash_original_field = "E493415599EE10166D7B1C21C42971B0", hash_generated_field = "0E984BA2637E301559F63FEE7970E25A")

    private ECDomainParameters domainParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.339 -0400", hash_original_method = "8B1957EBD2FBE03865E88F3FCA63A5D4", hash_generated_method = "D8609F05E0DE5788B1008F756A93EC1E")
    public  ECKeyGenerationParameters(
        ECDomainParameters      domainParams,
        SecureRandom            random) {
        super(random, domainParams.getN().bitLength());
        addTaint(random.getTaint());
        this.domainParams = domainParams;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.340 -0400", hash_original_method = "40F55F2249A14F0DC46DF54508E5891A", hash_generated_method = "432EF20AABA852F19C09869EDFC94A9E")
    public ECDomainParameters getDomainParameters() {
ECDomainParameters varFB5FA83EE5A4C33D9E4B0FA79BF6936D_68564566 =         domainParams;
        varFB5FA83EE5A4C33D9E4B0FA79BF6936D_68564566.addTaint(taint);
        return varFB5FA83EE5A4C33D9E4B0FA79BF6936D_68564566;
        
        
    }

    
}

