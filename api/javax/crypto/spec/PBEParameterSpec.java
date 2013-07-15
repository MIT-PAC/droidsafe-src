package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.AlgorithmParameterSpec;

public class PBEParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.424 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.424 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private int iterationCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.424 -0400", hash_original_method = "E4AD3F6E1F8504EC055E33BFD3FD6D04", hash_generated_method = "9C545AB176C6828D2FA841ECC1BF43D5")
    public  PBEParameterSpec(byte[] salt, int iterationCount) {
    if(salt == null)        
        {
            NullPointerException var45C61F92CD76DA675E3D6C31BD095F94_1180105900 = new NullPointerException("salt == null");
            var45C61F92CD76DA675E3D6C31BD095F94_1180105900.addTaint(taint);
            throw var45C61F92CD76DA675E3D6C31BD095F94_1180105900;
        } //End block
        this.salt = new byte[salt.length];
        System.arraycopy(salt, 0, this.salt, 0, salt.length);
        this.iterationCount = iterationCount;
        // ---------- Original Method ----------
        //if (salt == null) {
            //throw new NullPointerException("salt == null");
        //}
        //this.salt = new byte[salt.length];
        //System.arraycopy(salt, 0, this.salt, 0, salt.length);
        //this.iterationCount = iterationCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.425 -0400", hash_original_method = "DE7716C6003A9CBA24C4421C19D5F40E", hash_generated_method = "74DC688218AD1B93BA9BBDE4A873B1D0")
    public byte[] getSalt() {
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1087061168 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_413799286 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_413799286;
        // ---------- Original Method ----------
        //byte[] result = new byte[salt.length];
        //System.arraycopy(salt, 0, result, 0, salt.length);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.425 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "854A6027AD221D386852FE528BCE2C3D")
    public int getIterationCount() {
        int var40E092B298D076325C38C773B2D9BBAA_3428728 = (iterationCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301261037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301261037;
        // ---------- Original Method ----------
        //return iterationCount;
    }

    
}

