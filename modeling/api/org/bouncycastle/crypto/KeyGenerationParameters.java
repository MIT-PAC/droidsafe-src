package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.SecureRandom;






public class KeyGenerationParameters {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.797 -0500", hash_original_field = "DB0BFD07E76FA22D79EF92D3D20AD0C9", hash_generated_field = "47462950F1DBF0D228B8D6FE202BDA9F")

    private SecureRandom    random;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.799 -0500", hash_original_field = "D8E33FC3815E94E9BD28F778D73C56C8", hash_generated_field = "20CB3AE7396E0BBC137DAE7BF087094C")

    private int             strength;

    /**
     * initialise the generator with a source of randomness
     * and a strength (in bits).
     *
     * @param random the random byte source.
     * @param strength the size, in bits, of the keys we want to produce.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.802 -0500", hash_original_method = "939347762BF1A6E9C475E2B54A6ADF35", hash_generated_method = "60127D7162D992757C5B241F8DE55F4B")
    
public KeyGenerationParameters(
        SecureRandom    random,
        int             strength)
    {
        this.random = random;
        this.strength = strength;
    }

    /**
     * return the random source associated with this
     * generator.
     *
     * @return the generators random source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.805 -0500", hash_original_method = "4043DCC08234105D51A7E8CF51216DB5", hash_generated_method = "64F11FB95A2345CEB8786E6CF35F4C4F")
    
public SecureRandom getRandom()
    {
        return random;
    }

    /**
     * return the bit strength for keys produced by this generator,
     *
     * @return the strength of the keys this generator produces (in bits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.807 -0500", hash_original_method = "8279E3FC0561D58AA50F8E336B0E6AC1", hash_generated_method = "6A4205A795E9EC11B3DBB07FF702AF13")
    
public int getStrength()
    {
        return strength;
    }

    
}

