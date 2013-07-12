package javax.crypto.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.KeySpec;
import java.util.Arrays;
import libcore.util.EmptyArray;

public class PBEKeySpec implements KeySpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.409 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "E9D3F141738563A4D1D32A99D6434F98")

    private char[] password;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.409 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.410 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private int iterationCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.410 -0400", hash_original_field = "5AF8CF094F8763C1015439D66C86D8D4", hash_generated_field = "7D855D8BBB39CFD5FBF8BAF908C01D42")

    private int keyLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.411 -0400", hash_original_method = "2E3022EA9F0D00958A95EEBC25ADD120", hash_generated_method = "D24F71780D764A9EAF17B9FB4B315277")
    public  PBEKeySpec(char[] password) {
    if(password == null)        
        {
            this.password = EmptyArray.CHAR;
        } 
        else
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        salt = null;
        iterationCount = 0;
        keyLength = 0;
        
        
            
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.414 -0400", hash_original_method = "3A4DB6943FB30203AAE55BF43F989AF0", hash_generated_method = "BF80E924E1E049DE2A2B89D78BBC4AC4")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount,
                      int keyLength) {
    if(salt == null)        
        {
            NullPointerException var45C61F92CD76DA675E3D6C31BD095F94_869871572 = new NullPointerException("salt == null");
            var45C61F92CD76DA675E3D6C31BD095F94_869871572.addTaint(taint);
            throw var45C61F92CD76DA675E3D6C31BD095F94_869871572;
        } 
    if(salt.length == 0)        
        {
            IllegalArgumentException varE9478314C4F31D7B6E6EB35C0D5BC6F5_1203380612 = new IllegalArgumentException("salt.length == 0");
            varE9478314C4F31D7B6E6EB35C0D5BC6F5_1203380612.addTaint(taint);
            throw varE9478314C4F31D7B6E6EB35C0D5BC6F5_1203380612;
        } 
    if(iterationCount <= 0)        
        {
            IllegalArgumentException var302085A58927047C367219F806C30042_1959149632 = new IllegalArgumentException("iterationCount <= 0");
            var302085A58927047C367219F806C30042_1959149632.addTaint(taint);
            throw var302085A58927047C367219F806C30042_1959149632;
        } 
    if(keyLength <= 0)        
        {
            IllegalArgumentException var35E1D112575D4A6F43BD7B3F6A32C682_384059194 = new IllegalArgumentException("keyLength <= 0");
            var35E1D112575D4A6F43BD7B3F6A32C682_384059194.addTaint(taint);
            throw var35E1D112575D4A6F43BD7B3F6A32C682_384059194;
        } 
    if(password == null)        
        {
            this.password = EmptyArray.CHAR;
        } 
        else
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = keyLength;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.417 -0400", hash_original_method = "55AE5096776E3EC3786EB41522B2BAD8", hash_generated_method = "531B969E09E5CAA635C90B3D9D21C0DF")
    public  PBEKeySpec(char[] password, byte[] salt, int iterationCount) {
    if(salt == null)        
        {
            NullPointerException var45C61F92CD76DA675E3D6C31BD095F94_594437475 = new NullPointerException("salt == null");
            var45C61F92CD76DA675E3D6C31BD095F94_594437475.addTaint(taint);
            throw var45C61F92CD76DA675E3D6C31BD095F94_594437475;
        } 
    if(salt.length == 0)        
        {
            IllegalArgumentException varE9478314C4F31D7B6E6EB35C0D5BC6F5_244433617 = new IllegalArgumentException("salt.length == 0");
            varE9478314C4F31D7B6E6EB35C0D5BC6F5_244433617.addTaint(taint);
            throw varE9478314C4F31D7B6E6EB35C0D5BC6F5_244433617;
        } 
    if(iterationCount <= 0)        
        {
            IllegalArgumentException var302085A58927047C367219F806C30042_770446769 = new IllegalArgumentException("iterationCount <= 0");
            var302085A58927047C367219F806C30042_770446769.addTaint(taint);
            throw var302085A58927047C367219F806C30042_770446769;
        } 
    if(password == null)        
        {
            this.password = EmptyArray.CHAR;
        } 
        else
        {
            this.password = new char[password.length];
            System.arraycopy(password, 0, this.password, 0, password.length);
        } 
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        this.keyLength = 0;
        
        
            
        
        
            
        
        
            
        
        
            
        
            
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.417 -0400", hash_original_method = "F4F3467BB97348451E47DFFA6F639AA9", hash_generated_method = "CA41C809F464A252165431EA99C7DB11")
    public final void clearPassword() {
        Arrays.fill(password, '?');
        password = null;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.418 -0400", hash_original_method = "E0FB32D7B704A3B37DF97B967BD643AC", hash_generated_method = "3DB92D25A54003CA6C8E064ADE939810")
    public final char[] getPassword() {
    if(password == null)        
        {
            IllegalStateException varE85A62D2E97CCDD90DF666E399D624BF_1895247341 = new IllegalStateException("The password has been cleared");
            varE85A62D2E97CCDD90DF666E399D624BF_1895247341.addTaint(taint);
            throw varE85A62D2E97CCDD90DF666E399D624BF_1895247341;
        } 
        char[] result = new char[password.length];
        System.arraycopy(password, 0, result, 0, password.length);
        char[] varB4A88417B3D0170D754C647C30B7216A_1991405846 = (result);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_1898795891 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1898795891;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.418 -0400", hash_original_method = "D4AADBC0A48F11BB68A855C1713E52DB", hash_generated_method = "CFD6DDD9FBF06D81B43E7461A98E37AC")
    public final byte[] getSalt() {
    if(salt == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1127931810 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1993847653 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1993847653;
        } 
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_46304051 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1277507415 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1277507415;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.418 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "33985ED5BC9EA7A86BAE79C6118E6FD4")
    public final int getIterationCount() {
        int var40E092B298D076325C38C773B2D9BBAA_366867727 = (iterationCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498507992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_498507992;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.419 -0400", hash_original_method = "20994892EFF6499C10F6429275E73A4B", hash_generated_method = "08DBBECF4F3B79455A2AC9D6B907674B")
    public final int getKeyLength() {
        int var5AF8CF094F8763C1015439D66C86D8D4_40926335 = (keyLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699919193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_699919193;
        
        
    }

    
}

