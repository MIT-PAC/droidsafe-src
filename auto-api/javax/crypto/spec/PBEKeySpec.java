package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.security.spec.KeySpec;
import java.util.Arrays;
import libcore.util.EmptyArray;

public class PBEKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.276 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.276 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.276 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private int iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.276 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "7D855D8BBB39CFD5FBF8BAF908C01D42")

    private int keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.277 -0400", hash_original_method = "2E3022EA9F0D00958A95EEBC25ADD120", hash_generated_method = "7CF6F573D8462DDE6942277BEC562EA5")
    public  PBEKeySpec(char[] password) {
        {
            this.password = EmptyArray.CHAR;
        } 
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        salt = null;
        iterationCount = 0;
        keyLength = 0;
        
        
            
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.278 -0400", hash_original_method = "3A4DB6943FB30203AAE55BF43F989AF0", hash_generated_method = "3CF2C93569E0E60E283F2EAAF5ECBB79")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount,
                      int keyLength) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("salt == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("salt.length == 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iterationCount <= 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("keyLength <= 0");
        } 
        {
            this.password = EmptyArray.CHAR;
        } 
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = keyLength;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.278 -0400", hash_original_method = "55AE5096776E3EC3786EB41522B2BAD8", hash_generated_method = "812D39DC53709AB10B443444C86BDA9B")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("salt == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("salt.length == 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iterationCount <= 0");
        } 
        {
            this.password = EmptyArray.CHAR;
        } 
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = 0;
        
        
            
        
        
            
        
        
            
        
        
            
        
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.278 -0400", hash_original_method = "F4F3467BB97348451E47DFFA6F639AA9", hash_generated_method = "CA41C809F464A252165431EA99C7DB11")
    public final void clearPassword() {
        Arrays.fill(password, '?');
        password = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.279 -0400", hash_original_method = "E0FB32D7B704A3B37DF97B967BD643AC", hash_generated_method = "37A465B58B23F373EF724B8DF0DFFD38")
    public final char[] getPassword() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("The password has been cleared");
        } 
        char[] result = new char[password.length];
        System.arraycopy(password, 0, result, 0, password.length);
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1106156273 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1106156273;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.280 -0400", hash_original_method = "D4AADBC0A48F11BB68A855C1713E52DB", hash_generated_method = "85D5698412BD762DAA3F6864DA6714F2")
    public final byte[] getSalt() {
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_506254553 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_506254553;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.280 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "5E814AA61B439269BD6C5BE27EB06D04")
    public final int getIterationCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837992590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837992590;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.281 -0400", hash_original_method = "20994892EFF6499C10F6429275E73A4B", hash_generated_method = "AD6911C78B8CC6FC9A973271A9B04A30")
    public final int getKeyLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501323705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_501323705;
        
        
    }

    
}

