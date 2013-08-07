package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.SecureRandom;

import org.bouncycastle.crypto.CipherParameters;






public class ParametersWithRandom implements CipherParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.127 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.127 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "37E4A1EB8E400F5F526111B05CB36773")

    private CipherParameters parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.128 -0400", hash_original_method = "162EA3D022385A6AFF8662AEA7C57194", hash_generated_method = "6DBBA1B8CAB3D2D83F264095417D4024")
    public  ParametersWithRandom(
        CipherParameters    parameters,
        SecureRandom        random) {
        this.random = random;
        this.parameters = parameters;
        // ---------- Original Method ----------
        //this.random = random;
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.128 -0400", hash_original_method = "FA9B58AB5748C567DC3BCB63E51890D5", hash_generated_method = "486E5542530E6BDF9614EEAA8E199E59")
    public  ParametersWithRandom(
        CipherParameters    parameters) {
        this(parameters, new SecureRandom());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.129 -0400", hash_original_method = "4043DCC08234105D51A7E8CF51216DB5", hash_generated_method = "1753BC46EA1BD78DCABEBC75AA23C73A")
    public SecureRandom getRandom() {
SecureRandom var891A210E71DB8175751C941BFF722D69_338702119 =         random;
        var891A210E71DB8175751C941BFF722D69_338702119.addTaint(taint);
        return var891A210E71DB8175751C941BFF722D69_338702119;
        // ---------- Original Method ----------
        //return random;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.129 -0400", hash_original_method = "4D76F2EFD1EF9C1CA864824F06254E67", hash_generated_method = "5D1CD951E62F3E90E9372DCAC5B637B0")
    public CipherParameters getParameters() {
CipherParameters var3CB0A38B794BDEDADB1F50256E0AE35B_1037256910 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_1037256910.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_1037256910;
        // ---------- Original Method ----------
        //return parameters;
    }

    
}

