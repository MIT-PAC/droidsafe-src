package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public abstract class SecureRandomSpi implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.912 -0500", hash_original_field = "09DA6963E46782ECF8E5B84B67CF4091", hash_generated_field = "FD60E79FCEB20AD629BA66BEC1122BB3")

    private static final long serialVersionUID = -2991854161009191830L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.358 -0400", hash_original_method = "80C7AF93ECB1E3D5135CFB765D8A9626", hash_generated_method = "80C7AF93ECB1E3D5135CFB765D8A9626")
    public SecureRandomSpi ()
    {
        //Synthesized constructor
    }

    /**
     * Reseeds this {@code SecureRandomSpi} instance with the specified {@code
     * seed}. The seed of this {@code SecureRandomSpi} instance is supplemented,
     * not replaced.
     *
     * @param seed
     *            the new seed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.914 -0500", hash_original_method = "7FE199E37C91EF883FEDEEC59A4F0D9C", hash_generated_method = "661CD6063137BBDB0CA31510BC048AE2")
    
protected abstract void engineSetSeed(byte[] seed);

    /**
     * Generates and stores random bytes in the given {@code byte[]} for each
     * array element.
     *
     * @param bytes
     *            the {@code byte[]} to be filled with random bytes.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.917 -0500", hash_original_method = "D21E53F019316BC34A671EC90C51D0AB", hash_generated_method = "AE35660397147350A644AC1047E5667C")
    
protected abstract void engineNextBytes(byte[] bytes);

    /**
     * Generates and returns the specified number of seed bytes, computed using
     * the seed generation algorithm used by this {@code SecureRandomSpi}.
     *
     * @param numBytes
     *            the number of seed bytes.
     * @return the seed bytes
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:54.919 -0500", hash_original_method = "0BF58C244EC1A63CD9FB6D644BB9E1DF", hash_generated_method = "4518F6157B93CA4061E5C1A868FC0DB7")
    
protected abstract byte[] engineGenerateSeed(int numBytes);
}

