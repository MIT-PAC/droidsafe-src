package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.spec.KeySpec;
import java.util.Arrays;

import libcore.util.EmptyArray;

public class PBEKeySpec implements KeySpec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.941 -0500", hash_original_field = "21BCD293DE862031F898430214E88677", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.943 -0500", hash_original_field = "E37DC2BC2509FBBDB9429277FE4D77AB", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private  byte[] salt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.945 -0500", hash_original_field = "63985F5D8355AAA3166FE055813432C8", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private  int iterationCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.947 -0500", hash_original_field = "777B5E6CCBB60AB26BD875B5C1A8E437", hash_generated_field = "7D855D8BBB39CFD5FBF8BAF908C01D42")

    private  int keyLength;

    /**
     * Creates a new <code>PBEKeySpec</code> with the specified password.
     *
     * @param password
     *            the password.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.951 -0500", hash_original_method = "2E3022EA9F0D00958A95EEBC25ADD120", hash_generated_method = "6FBFE97612C133168C998DD2B51C9462")
    
public PBEKeySpec(char[] password) {
        if (password == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        }
        salt = null;
        iterationCount = 0;
        keyLength = 0;
    }

    /**
     * Creates a new <code>PBEKeySpec</code> with the specified password, salt,
     * iteration count and the desired length of the derived key.
     *
     * @param password
     *            the password.
     * @param salt
     *            the salt.
     * @param iterationCount
     *            the iteration count.
     * @param keyLength
     *            the desired key length of the derived key,
     * @throws NullPointerException
     *             if the salt is null.
     * @throws IllegalArgumentException
     *             if the salt is empty, iteration count is zero or negative or
     *             the key length is zero or negative.
     */
    @DSComment("not data related")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.954 -0500", hash_original_method = "3A4DB6943FB30203AAE55BF43F989AF0", hash_generated_method = "58A36CBF0329AE3E528072CFA778039D")
    
public PBEKeySpec(char[] password, byte[] salt, int iterationCount,
                      int keyLength) {
        if (salt == null) {
            throw new NullPointerException("salt == null");
        }
        if (salt.length == 0) {
            throw new IllegalArgumentException("salt.length == 0");
        }
        if (iterationCount <= 0) {
            throw new IllegalArgumentException("iterationCount <= 0");
        }
        if (keyLength <= 0) {
            throw new IllegalArgumentException("keyLength <= 0");
        }

        if (password == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        }
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = keyLength;
    }

    /**
     * Creates a new <code>PBEKeySpec</code> with the specified password, salt
     * and iteration count.
     *
     * @param password
     *            the password.
     * @param salt
     *            the salt.
     * @param iterationCount
     *            the iteration count.
     * @throws NullPointerException
     *             if salt is null.
     * @throws IllegalArgumentException
     *             if the salt is empty or iteration count is zero or negative.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.957 -0500", hash_original_method = "55AE5096776E3EC3786EB41522B2BAD8", hash_generated_method = "3552E8AF178ADE40DA7CD04443E650CD")
    
public PBEKeySpec(char[] password, byte[] salt, int iterationCount) {
        if (salt == null) {
            throw new NullPointerException("salt == null");
        }
        if (salt.length == 0) {
            throw new IllegalArgumentException("salt.length == 0");
        }
        if (iterationCount <= 0) {
            throw new IllegalArgumentException("iterationCount <= 0");
        }

        if (password == null) {
            this.password = EmptyArray.CHAR;
        } else {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        }
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = 0;
    }

    /**
     * Clears the password by overwriting it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.960 -0500", hash_original_method = "F4F3467BB97348451E47DFFA6F639AA9", hash_generated_method = "76EBC7E710B0D567D0D74BB124E00A63")
    
public final void clearPassword() {
        Arrays.fill(password, '?');
        password = null;
    }

    /**
     * Returns a copy of the password of this key specification.
     *
     * @return a copy of the password of this key specification.
     * @throws IllegalStateException
     *             if the password has been cleared before.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.963 -0500", hash_original_method = "E0FB32D7B704A3B37DF97B967BD643AC", hash_generated_method = "6991C49CA9449698DA2A16935CA87A4F")
    
public final char[] getPassword() {
        if (password == null) {
            throw new IllegalStateException("The password has been cleared");
        }
        char[] result = new char[password.length];
        System.arraycopy(password, 0, result, 0, password.length);
        return result;
    }

    /**
     * Returns a copy of the salt of this key specification.
     *
     * @return a copy of the salt of this key specification or null if none is
     *         specified.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.965 -0500", hash_original_method = "D4AADBC0A48F11BB68A855C1713E52DB", hash_generated_method = "0E7B09CAEB809E4021BE343FCDF48F32")
    
public final byte[] getSalt() {
        if (salt == null) {
            return null;
        }
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        return result;
    }

    /**
     * Returns the iteration count of this key specification.
     *
     * @return the iteration count of this key specification.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.967 -0500", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "91F578D92BF081EAB616F85199D7317E")
    
public final int getIterationCount() {
        return iterationCount;
    }

    /**
     * Returns the desired key length of the derived key.
     *
     * @return the desired key length of the derived key.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:54.969 -0500", hash_original_method = "20994892EFF6499C10F6429275E73A4B", hash_generated_method = "2C94C7878846EF7E42066740DB0FDC88")
    
public final int getKeyLength() {
        return keyLength;
    }
    
}

