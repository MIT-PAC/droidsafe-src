package org.bouncycastle.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.util.Strings;

public abstract class PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.511 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "0D7984138564A3D3CFA67A8682828033")

    protected byte[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.512 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "6FFE86D5F61D563FB2584E26D096D036")

    protected byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.512 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "34A0857BA933BFA60BC0532B6CFA4FA1")

    protected int iterationCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.512 -0400", hash_original_method = "1EFCFCAED54D10FE929FE2EAEA704D32", hash_generated_method = "3C2B98B5AB2577359A7BA81A6CF7EC83")
    protected  PBEParametersGenerator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.512 -0400", hash_original_method = "456931D8AD64BF8B12B053CDCE877455", hash_generated_method = "01B1CD85345AB39CEDE2B8C2C414A255")
    public void init(
        byte[]  password,
        byte[]  salt,
        int     iterationCount) {
        this.password = password;
        this.salt = salt;
        this.iterationCount = iterationCount;
        // ---------- Original Method ----------
        //this.password = password;
        //this.salt = salt;
        //this.iterationCount = iterationCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.524 -0400", hash_original_method = "FF883C507377D40DD9B6A3EE36BF823C", hash_generated_method = "BE5282707B5CDC3F81EF825020157950")
    public byte[] getPassword() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_670211489 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_670211489;
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.524 -0400", hash_original_method = "440AD26E5D605624C1EF028F9AB658FA", hash_generated_method = "2E4E8A1D30B07EA63FE84D37F313EFAD")
    public byte[] getSalt() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_775013057 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_775013057;
        // ---------- Original Method ----------
        //return salt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.525 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "99198C87CC3C1026A4E2E78708A5B92D")
    public int getIterationCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056906122 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056906122;
        // ---------- Original Method ----------
        //return iterationCount;
    }

    
    public abstract CipherParameters generateDerivedParameters(int keySize);

    
    public abstract CipherParameters generateDerivedParameters(int keySize, int ivSize);

    
    public abstract CipherParameters generateDerivedMacParameters(int keySize);

    
        public static byte[] PKCS5PasswordToBytes(
        char[]  password) {
        byte[]  bytes = new byte[password.length];
        for (int i = 0; i != bytes.length; i++)
        {
            bytes[i] = (byte)password[i];
        }
        return bytes;
    }

    
        public static byte[] PKCS5PasswordToUTF8Bytes(
        char[]  password) {
        return Strings.toUTF8ByteArray(password);
    }

    
        public static byte[] PKCS12PasswordToBytes(
        char[]  password) {
        if (password != null && password.length > 0)
        {
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
    }

    
}

