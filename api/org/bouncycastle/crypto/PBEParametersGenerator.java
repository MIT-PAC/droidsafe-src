package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.util.Strings;

public abstract class PBEParametersGenerator {

    /**
     * converts a password to a byte array according to the scheme in
     * PKCS5 (ascii, no padding)
     *
     * @param password a character array reqpresenting the password.
     * @return a byte array representing the password.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.554 -0500", hash_original_method = "F35BDD5F2AA3CB24D9C789703DBAD11E", hash_generated_method = "7DA78B8441E4158B5A95EE867CFDD247")
    
public static byte[] PKCS5PasswordToBytes(
        char[]  password)
    {
        byte[]  bytes = new byte[password.length];

        for (int i = 0; i != bytes.length; i++)
        {
            bytes[i] = (byte)password[i];
        }

        return bytes;
    }

    /**
     * converts a password to a byte array according to the scheme in
     * PKCS5 (UTF-8, no padding)
     *
     * @param password a character array reqpresenting the password.
     * @return a byte array representing the password.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.557 -0500", hash_original_method = "D233EA90DA0DA35A7E0DBA98505948D1", hash_generated_method = "FA4F10D2F11F090A94B97C334051F997")
    
public static byte[] PKCS5PasswordToUTF8Bytes(
        char[]  password)
    {
        return Strings.toUTF8ByteArray(password);
    }

    /**
     * converts a password to a byte array according to the scheme in
     * PKCS12 (unicode, big endian, 2 zero pad bytes at the end).
     *
     * @param password a character array representing the password.
     * @return a byte array representing the password.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.560 -0500", hash_original_method = "4A19C79E835AD7BD71DAD7DDD0B3C922", hash_generated_method = "C7A95EF7EC659C952E854B1385BE1448")
    
public static byte[] PKCS12PasswordToBytes(
        char[]  password)
    {
        // BEGIN android-changed
        if (password != null && password.length > 0)
        {
                                       // +1 for extra 2 pad bytes.
            byte[]  bytes = new byte[(password.length + 1) * 2];

            for (int i = 0; i != password.length; i ++)
            {
                bytes[i * 2] = (byte)(password[i] >>> 8);
                bytes[i * 2 + 1] = (byte)password[i];
            }

            return bytes;
        }
        else
        {
            return new byte[0];
        }
        // END android-changed
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.528 -0500", hash_original_field = "1ED93C07871790F1B05979F9657B13A2", hash_generated_field = "0D7984138564A3D3CFA67A8682828033")

    protected byte[]  password;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.531 -0500", hash_original_field = "E37DC2BC2509FBBDB9429277FE4D77AB", hash_generated_field = "6FFE86D5F61D563FB2584E26D096D036")

    protected byte[]  salt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.533 -0500", hash_original_field = "63985F5D8355AAA3166FE055813432C8", hash_generated_field = "34A0857BA933BFA60BC0532B6CFA4FA1")

    protected int     iterationCount;

    /**
     * base constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.536 -0500", hash_original_method = "1EFCFCAED54D10FE929FE2EAEA704D32", hash_generated_method = "B033747BF6995BE8502732A0A8B762BD")
    
protected PBEParametersGenerator()
    {
    }

    /**
     * initialise the PBE generator.
     *
     * @param password the password converted into bytes (see below).
     * @param salt the salt to be mixed with the password.
     * @param iterationCount the number of iterations the "mixing" function
     * is to be applied for.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.538 -0500", hash_original_method = "456931D8AD64BF8B12B053CDCE877455", hash_generated_method = "1D83E435073CFEC20178BCE846AE4ADC")
    
public void init(
        byte[]  password,
        byte[]  salt,
        int     iterationCount)
    {
        this.password = password;
        this.salt = salt;
        this.iterationCount = iterationCount;
    }

    /**
     * return the password byte array.
     *
     * @return the password byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.540 -0500", hash_original_method = "FF883C507377D40DD9B6A3EE36BF823C", hash_generated_method = "D81DB6C102923420AE887D9E26854CCE")
    
public byte[] getPassword()
    {
        return password;
    }

    /**
     * return the salt byte array.
     *
     * @return the salt byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.542 -0500", hash_original_method = "440AD26E5D605624C1EF028F9AB658FA", hash_generated_method = "32E27350E6D2911C021287061F1DF7F4")
    
public byte[] getSalt()
    {
        return salt;
    }

    /**
     * return the iteration count.
     *
     * @return the iteration count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.544 -0500", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "583EA89A4A01F3B828D69488C83B2B0E")
    
public int getIterationCount()
    {
        return iterationCount;
    }

    /**
     * generate derived parameters for a key of length keySize.
     *
     * @param keySize the length, in bits, of the key required.
     * @return a parameters object representing a key.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.547 -0500", hash_original_method = "98AFD8ECF9A0E600D41962C41C0FE43D", hash_generated_method = "8623FF622A8064A58FB3420841479B24")
    
public abstract CipherParameters generateDerivedParameters(int keySize);

    /**
     * generate derived parameters for a key of length keySize, and
     * an initialisation vector (IV) of length ivSize.
     *
     * @param keySize the length, in bits, of the key required.
     * @param ivSize the length, in bits, of the iv required.
     * @return a parameters object representing a key and an IV.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.550 -0500", hash_original_method = "9AFA4045D657BD87EACCE4FFD29B371E", hash_generated_method = "86FDA5F7A1A2AEF243E83937CCD85578")
    
public abstract CipherParameters generateDerivedParameters(int keySize, int ivSize);

    /**
     * generate derived parameters for a key of length keySize, specifically
     * for use with a MAC.
     *
     * @param keySize the length, in bits, of the key required.
     * @return a parameters object representing a key.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.552 -0500", hash_original_method = "4AC18EA0058B282F1B402876553ECFFB", hash_generated_method = "B3BAE818D4444A17AE5EF402720447EE")
    
public abstract CipherParameters generateDerivedMacParameters(int keySize);
    
}

