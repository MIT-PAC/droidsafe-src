package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class X9ECParametersHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.360 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "4C1B71428688017C93ABE5D3E920C724")

    private X9ECParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.360 -0400", hash_original_method = "FD737115DECB7E666F320685834584A5", hash_generated_method = "FD737115DECB7E666F320685834584A5")
    public X9ECParametersHolder ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.363 -0400", hash_original_method = "DFAA4BD61A3833EE49852C9B8E577AF7", hash_generated_method = "C7E2511341AB90EBC6CEFD1040715326")
    public X9ECParameters getParameters() {
        X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_743501075 = null; //Variable for return #1
        {
            params = createParameters();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_743501075 = params;
        varB4EAC82CA7396A68D541C85D26508E83_743501075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_743501075;
        // ---------- Original Method ----------
        //if (params == null)
        //{
            //params = createParameters();
        //}
        //return params;
    }

    
    protected abstract X9ECParameters createParameters();

    
}

