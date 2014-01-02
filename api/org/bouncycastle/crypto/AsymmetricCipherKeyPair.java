package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AsymmetricCipherKeyPair {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.746 -0500", hash_original_field = "6675824290038E644A5EB591E997DF70", hash_generated_field = "D38357BF57B4865D6AA01FDC8C1B6FE2")

    private CipherParameters    publicParam;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.748 -0500", hash_original_field = "8CEFD3BD6A180849E998CA4F6FADCF2F", hash_generated_field = "AB1F110C2888B18C0BF88D68B11659BF")

    private CipherParameters    privateParam;

    /**
     * basic constructor.
     *
     * @param publicParam a public key parameters object.
     * @param privateParam the corresponding private key parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.751 -0500", hash_original_method = "65CF8F80B3A8FEDFD01C4D97F9AE7A45", hash_generated_method = "A85315635EF53BE13475B6358A041D0D")
    
public AsymmetricCipherKeyPair(
        CipherParameters    publicParam,
        CipherParameters    privateParam)
    {
        this.publicParam = publicParam;
        this.privateParam = privateParam;
    }

    /**
     * return the public key parameters.
     *
     * @return the public key parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.753 -0500", hash_original_method = "3D299E49495FDEB066F19C28CA51812C", hash_generated_method = "D700F797610ED4AF3695B54C0914058B")
    
public CipherParameters getPublic()
    {
        return publicParam;
    }

    /**
     * return the private key parameters.
     *
     * @return the private key parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.756 -0500", hash_original_method = "E6E9A7462A68D5F39CC837AD8A41F899", hash_generated_method = "AF88F2DC07957F3BABE8BD46F48CAC31")
    
public CipherParameters getPrivate()
    {
        return privateParam;
    }

    
}

