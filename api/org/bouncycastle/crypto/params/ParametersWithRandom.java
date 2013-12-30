package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.SecureRandom;

import org.bouncycastle.crypto.CipherParameters;






public class ParametersWithRandom implements CipherParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.342 -0500", hash_original_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom        random;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.345 -0500", hash_original_field = "95B98FE0C5601A91715393CB954CA53B", hash_generated_field = "37E4A1EB8E400F5F526111B05CB36773")

    private CipherParameters    parameters;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.347 -0500", hash_original_method = "162EA3D022385A6AFF8662AEA7C57194", hash_generated_method = "86929D8592312676A676AC9FD18A7F05")
    
public ParametersWithRandom(
        CipherParameters    parameters,
        SecureRandom        random)
    {
        this.random = random;
        this.parameters = parameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.351 -0500", hash_original_method = "FA9B58AB5748C567DC3BCB63E51890D5", hash_generated_method = "6C5374204EFBBE20540721904581AF3D")
    
public ParametersWithRandom(
        CipherParameters    parameters)
    {
        this(parameters, new SecureRandom());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.353 -0500", hash_original_method = "4043DCC08234105D51A7E8CF51216DB5", hash_generated_method = "64F11FB95A2345CEB8786E6CF35F4C4F")
    
public SecureRandom getRandom()
    {
        return random;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.355 -0500", hash_original_method = "4D76F2EFD1EF9C1CA864824F06254E67", hash_generated_method = "574A09DACE341E4A2632E93FD70A2C75")
    
public CipherParameters getParameters()
    {
        return parameters;
    }

    
}

