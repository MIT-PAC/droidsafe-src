package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class X9ECParametersHolder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.920 -0500", hash_original_field = "37AA3699F4FE156A9A0A215FC5C0C392", hash_generated_field = "4C1B71428688017C93ABE5D3E920C724")

    private X9ECParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.355 -0400", hash_original_method = "FD737115DECB7E666F320685834584A5", hash_generated_method = "FD737115DECB7E666F320685834584A5")
    public X9ECParametersHolder ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.922 -0500", hash_original_method = "DFAA4BD61A3833EE49852C9B8E577AF7", hash_generated_method = "320F47292033ED73B66AEF19CC9C30D9")
    
public X9ECParameters getParameters()
    {
        if (params == null)
        {
            params = createParameters();
        }

        return params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:25.925 -0500", hash_original_method = "1F1693C301D27181EAB1FFC1D645AFDA", hash_generated_method = "CA79BF06048E9D1AF0018F6F3A4B479B")
    
protected abstract X9ECParameters createParameters();
    
}

