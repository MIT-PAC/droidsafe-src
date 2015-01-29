package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.SecureRandom;

import org.bouncycastle.crypto.KeyGenerationParameters;






public class ECKeyGenerationParameters extends KeyGenerationParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.392 -0500", hash_original_field = "A68B78C473090548C3DD72FF7617D927", hash_generated_field = "0E984BA2637E301559F63FEE7970E25A")

    private ECDomainParameters  domainParams;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.395 -0500", hash_original_method = "8B1957EBD2FBE03865E88F3FCA63A5D4", hash_generated_method = "AD24DA3B3A8EA9434A4FB31D12C577A7")
    
public ECKeyGenerationParameters(
        ECDomainParameters      domainParams,
        SecureRandom            random)
    {
        super(random, domainParams.getN().bitLength());

        this.domainParams = domainParams;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.398 -0500", hash_original_method = "40F55F2249A14F0DC46DF54508E5891A", hash_generated_method = "005A78755D5505AD0C36A3D6C025BBD9")
    
public ECDomainParameters getDomainParameters()
    {
        return domainParams;
    }

    
}

