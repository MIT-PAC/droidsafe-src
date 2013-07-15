package org.bouncycastle.jce.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.KeySpec;

public class ECKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.689 -0400", hash_original_field = "B979C2934AC0B4BA3F08DABFDD1B2299", hash_generated_field = "82AE92EF7773AA5ED9F82BE71242C394")

    private ECParameterSpec spec;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.690 -0400", hash_original_method = "26671DF5D8347FB8E2181E6D1CD58161", hash_generated_method = "33F8C75912C13380AEF70792CA92BEAA")
    protected  ECKeySpec(
        ECParameterSpec spec) {
        this.spec = spec;
        // ---------- Original Method ----------
        //this.spec = spec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.690 -0400", hash_original_method = "CAD2937E5922AD2A7FB69B4EF0F6DA5F", hash_generated_method = "D4946B2EB77D0360668E409F4A7D2483")
    public ECParameterSpec getParams() {
ECParameterSpec var3BF97C0C26DE0A5840A15BDE544612CA_1079899107 =         spec;
        var3BF97C0C26DE0A5840A15BDE544612CA_1079899107.addTaint(taint);
        return var3BF97C0C26DE0A5840A15BDE544612CA_1079899107;
        // ---------- Original Method ----------
        //return spec;
    }

    
}

