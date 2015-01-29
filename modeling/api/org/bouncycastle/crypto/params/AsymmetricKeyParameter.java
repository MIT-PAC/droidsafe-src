package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;






public class AsymmetricKeyParameter implements CipherParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.099 -0500", hash_original_field = "B7CB1A33B0CE83673F166D8478A09AB7", hash_generated_field = "B7CB1A33B0CE83673F166D8478A09AB7")

    boolean privateKey;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.102 -0500", hash_original_method = "DD522CA24B87E383EA27DC7A872D3AC1", hash_generated_method = "898C7CED24B393AF329032EDF86A00A2")
    
public AsymmetricKeyParameter(
        boolean privateKey)
    {
        this.privateKey = privateKey;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.104 -0500", hash_original_method = "47130025E2A64A0FEA07D9052329E298", hash_generated_method = "C8569D7CC05279C4DCB51755F3509364")
    
public boolean isPrivate()
    {
        return privateKey;
    }

    
}

