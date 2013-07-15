package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.SecureRandom;

public class KeyGenerationParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.790 -0400", hash_original_field = "7DDF32E17A6AC5CE04A8ECBF782CA509", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom random;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.790 -0400", hash_original_field = "5177790AD6DF0EA98DB41B37B602367C", hash_generated_field = "20CB3AE7396E0BBC137DAE7BF087094C")

    private int strength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.791 -0400", hash_original_method = "939347762BF1A6E9C475E2B54A6ADF35", hash_generated_method = "AD192DC3D441BD723884BFD6F7F9EDDA")
    public  KeyGenerationParameters(
        SecureRandom    random,
        int             strength) {
        this.random = random;
        this.strength = strength;
        // ---------- Original Method ----------
        //this.random = random;
        //this.strength = strength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.791 -0400", hash_original_method = "4043DCC08234105D51A7E8CF51216DB5", hash_generated_method = "AF8BE454AB7BD4E56281460B47873B94")
    public SecureRandom getRandom() {
SecureRandom var891A210E71DB8175751C941BFF722D69_170673823 =         random;
        var891A210E71DB8175751C941BFF722D69_170673823.addTaint(taint);
        return var891A210E71DB8175751C941BFF722D69_170673823;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.792 -0400", hash_original_method = "8279E3FC0561D58AA50F8E336B0E6AC1", hash_generated_method = "DFCE7700BE389164046E3430CDF1F524")
    public int getStrength() {
        int var5177790AD6DF0EA98DB41B37B602367C_1314582049 = (strength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771941365 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771941365;
        // ---------- Original Method ----------
        //return strength;
    }

    
}

