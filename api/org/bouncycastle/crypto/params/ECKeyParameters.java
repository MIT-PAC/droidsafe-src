package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ECKeyParameters extends AsymmetricKeyParameter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.180 -0500", hash_original_field = "1AFC7445D28E654B0EF1545F8475DF56", hash_generated_field = "1AFC7445D28E654B0EF1545F8475DF56")

    ECDomainParameters params;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.183 -0500", hash_original_method = "E2FB354EFDC926847445A1310061C03E", hash_generated_method = "BD596C858877A199D2BFDA0F10278585")
    
protected ECKeyParameters(
        boolean             isPrivate,
        ECDomainParameters  params)
    {
        super(isPrivate);

        this.params = params;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.185 -0500", hash_original_method = "A9E3CC17704D8E2C00256D56DB37C3BF", hash_generated_method = "E8DEC196FF6D0595E29B796E4C209271")
    
public ECDomainParameters getParameters()
    {
        return params;
    }

    
}

