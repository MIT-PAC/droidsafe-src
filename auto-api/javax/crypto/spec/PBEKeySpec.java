package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.KeySpec;
import java.util.Arrays;
import libcore.util.EmptyArray;

public class PBEKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.308 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.308 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.308 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private int iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.308 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "7D855D8BBB39CFD5FBF8BAF908C01D42")

    private int keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.313 -0400", hash_original_method = "2E3022EA9F0D00958A95EEBC25ADD120", hash_generated_method = "7CF6F573D8462DDE6942277BEC562EA5")
    public  PBEKeySpec(char[] password) {
        {
            this.password = EmptyArray.CHAR;
        } //End block
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } //End block
        salt = null;
        iterationCount = 0;
        keyLength = 0;
        // ---------- Original Method ----------
        //if (password == null) {
            //this.password = EmptyArray.CHAR;
        //} else {
            //this.password = new char[password.length];
            //System.arraycopy(password, 0, this.password, 0, password.length);
        //}
        //salt = null;
        //iterationCount = 0;
        //keyLength = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.314 -0400", hash_original_method = "3A4DB6943FB30203AAE55BF43F989AF0", hash_generated_method = "3CF2C93569E0E60E283F2EAAF5ECBB79")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount,
                      int keyLength) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("salt == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("salt.length == 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iterationCount <= 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("keyLength <= 0");
        } //End block
        {
            this.password = EmptyArray.CHAR;
        } //End block
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } //End block
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = keyLength;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.322 -0400", hash_original_method = "55AE5096776E3EC3786EB41522B2BAD8", hash_generated_method = "812D39DC53709AB10B443444C86BDA9B")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("salt == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("salt.length == 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iterationCount <= 0");
        } //End block
        {
            this.password = EmptyArray.CHAR;
        } //End block
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } //End block
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = 0;
        // ---------- Original Method ----------
        //if (salt == null) {
            //throw new NullPointerException("salt == null");
        //}
        //if (salt.length == 0) {
            //throw new IllegalArgumentException("salt.length == 0");
        //}
        //if (iterationCount <= 0) {
            //throw new IllegalArgumentException("iterationCount <= 0");
        //}
        //if (password == null) {
            //this.password = EmptyArray.CHAR;
        //} else {
            //this.password = new char[password.length];
            //System.arraycopy(password, 0, this.password, 0, password.length);
        //}
        //this.salt = new byte[salt.length];
        //System.arraycopy(salt, 0, this.salt, 0, salt.length);
        //this.iterationCount = iterationCount;
        //this.keyLength = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.322 -0400", hash_original_method = "F4F3467BB97348451E47DFFA6F639AA9", hash_generated_method = "CA41C809F464A252165431EA99C7DB11")
    public final void clearPassword() {
        Arrays.fill(password, '?');
        password = null;
        // ---------- Original Method ----------
        //Arrays.fill(password, '?');
        //password = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.322 -0400", hash_original_method = "E0FB32D7B704A3B37DF97B967BD643AC", hash_generated_method = "0429D6C68CA9B6CB0CE757F49A85FE79")
    public final char[] getPassword() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The password has been cleared");
        } //End block
        char[] result;
        result = new char[password.length];
        System.arraycopy(password, 0, result, 0, password.length);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_419704494 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_419704494;
        // ---------- Original Method ----------
        //if (password == null) {
            //throw new IllegalStateException("The password has been cleared");
        //}
        //char[] result = new char[password.length];
        //System.arraycopy(password, 0, result, 0, password.length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.324 -0400", hash_original_method = "D4AADBC0A48F11BB68A855C1713E52DB", hash_generated_method = "CFF29EF98E4ADCFD00E4DC6B7DFB0960")
    public final byte[] getSalt() {
        byte[] result;
        result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1692450367 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1692450367;
        // ---------- Original Method ----------
        //if (salt == null) {
            //return null;
        //}
        //byte[] result = new byte[salt.length];
        //System.arraycopy(salt, 0, result, 0, salt.length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.324 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "4DD3BFFD31D149C45461785D273D3151")
    public final int getIterationCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736453895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736453895;
        // ---------- Original Method ----------
        //return iterationCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.324 -0400", hash_original_method = "20994892EFF6499C10F6429275E73A4B", hash_generated_method = "1AB54D84CE850C4E794154E8801439FD")
    public final int getKeyLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574903576 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574903576;
        // ---------- Original Method ----------
        //return keyLength;
    }

    
}

