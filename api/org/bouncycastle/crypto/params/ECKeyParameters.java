package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ECKeyParameters extends AsymmetricKeyParameter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.558 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "1AFC7445D28E654B0EF1545F8475DF56")

    ECDomainParameters params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.558 -0400", hash_original_method = "E2FB354EFDC926847445A1310061C03E", hash_generated_method = "278C2837D59666701ED80499EDC9B6F5")
    protected  ECKeyParameters(
        boolean             isPrivate,
        ECDomainParameters  params) {
        super(isPrivate);
        addTaint(isPrivate);
        this.params = params;
        // ---------- Original Method ----------
        //this.params = params;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.559 -0400", hash_original_method = "A9E3CC17704D8E2C00256D56DB37C3BF", hash_generated_method = "F04E910A26B61E09FA53770A42D6D4F0")
    public ECDomainParameters getParameters() {
ECDomainParameters varD15CEB6F45B18F7EB233792D020C6115_445500554 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_445500554.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_445500554;
        // ---------- Original Method ----------
        //return params;
    }

    
}

