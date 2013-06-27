package org.bouncycastle.asn1.x9;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class X9ECParametersHolder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.368 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "4C1B71428688017C93ABE5D3E920C724")

    private X9ECParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.369 -0400", hash_original_method = "FD737115DECB7E666F320685834584A5", hash_generated_method = "FD737115DECB7E666F320685834584A5")
    public X9ECParametersHolder ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.369 -0400", hash_original_method = "DFAA4BD61A3833EE49852C9B8E577AF7", hash_generated_method = "C37FAA35FF896417A17038789C77B52E")
    public X9ECParameters getParameters() {
        X9ECParameters varB4EAC82CA7396A68D541C85D26508E83_851531360 = null; //Variable for return #1
        {
            params = createParameters();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_851531360 = params;
        varB4EAC82CA7396A68D541C85D26508E83_851531360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_851531360;
        // ---------- Original Method ----------
        //if (params == null)
        //{
            //params = createParameters();
        //}
        //return params;
    }

    
    protected abstract X9ECParameters createParameters();

    
}

