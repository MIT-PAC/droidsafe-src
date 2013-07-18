package org.bouncycastle.crypto;

// Droidsafe Imports
import java.security.SecureRandom;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class KeyGenerationParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.453 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.453 -0400", hash_original_field = "5177790AD6DF0EA98DB41B37B602367C", hash_generated_field = "20CB3AE7396E0BBC137DAE7BF087094C")

    private int strength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.453 -0400", hash_original_method = "939347762BF1A6E9C475E2B54A6ADF35", hash_generated_method = "AD192DC3D441BD723884BFD6F7F9EDDA")
    public  KeyGenerationParameters(
        SecureRandom    random,
        int             strength) {
        this.random = random;
        this.strength = strength;
        // ---------- Original Method ----------
        //this.random = random;
        //this.strength = strength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.454 -0400", hash_original_method = "4043DCC08234105D51A7E8CF51216DB5", hash_generated_method = "DDAB6573CB85DDA0DACE153956ABAB50")
    public SecureRandom getRandom() {
SecureRandom var891A210E71DB8175751C941BFF722D69_1203119792 =         random;
        var891A210E71DB8175751C941BFF722D69_1203119792.addTaint(taint);
        return var891A210E71DB8175751C941BFF722D69_1203119792;
        // ---------- Original Method ----------
        //return random;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.454 -0400", hash_original_method = "8279E3FC0561D58AA50F8E336B0E6AC1", hash_generated_method = "6584E24FE02286B5201668BCE0C121C9")
    public int getStrength() {
        int var5177790AD6DF0EA98DB41B37B602367C_787192451 = (strength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437253870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437253870;
        // ---------- Original Method ----------
        //return strength;
    }

    
}

