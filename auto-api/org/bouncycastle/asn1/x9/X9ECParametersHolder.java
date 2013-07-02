package org.bouncycastle.asn1.x9;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class X9ECParametersHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.441 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "4C1B71428688017C93ABE5D3E920C724")

    private X9ECParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.441 -0400", hash_original_method = "FD737115DECB7E666F320685834584A5", hash_generated_method = "FD737115DECB7E666F320685834584A5")
    public X9ECParametersHolder ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.441 -0400", hash_original_method = "DFAA4BD61A3833EE49852C9B8E577AF7", hash_generated_method = "7CC1F1E1D02CD3A38AB708A553E3F4FF")
    public X9ECParameters getParameters() {
        X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_152578134 = null; 
        {
            params = createParameters();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_152578134 = params;
        varB4EAC82CA7396A68D541C85D26508E83_152578134.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_152578134;
        
        
        
            
        
        
    }

    
    protected abstract X9ECParameters createParameters();

    
}

