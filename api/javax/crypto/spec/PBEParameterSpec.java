package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.spec.AlgorithmParameterSpec;






public class PBEParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.393 -0400", hash_original_field = "CEB20772E0C9D240C75EB26B0E37ABEE", hash_generated_field = "8E8CA6A0D4A78C798E95C91BD86EA51C")

    private byte[] salt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.394 -0400", hash_original_field = "40E092B298D076325C38C773B2D9BBAA", hash_generated_field = "98D2C6D733D1F0E9FD9E8AD73AA86C06")

    private int iterationCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.395 -0400", hash_original_method = "E4AD3F6E1F8504EC055E33BFD3FD6D04", hash_generated_method = "0486B8A35C4287AEB15F68B86900E1E2")
    public  PBEParameterSpec(byte[] salt, int iterationCount) {
        if(salt == null)        
        {
            NullPointerException var45C61F92CD76DA675E3D6C31BD095F94_1637854901 = new NullPointerException("salt == null");
            var45C61F92CD76DA675E3D6C31BD095F94_1637854901.addTaint(taint);
            throw var45C61F92CD76DA675E3D6C31BD095F94_1637854901;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.396 -0400", hash_original_method = "DE7716C6003A9CBA24C4421C19D5F40E", hash_generated_method = "0DBB7AA6EB9DF12C34A0307B10F00F18")
    public byte[] getSalt() {
        byte[] result = new byte[salt.length];
        System.arraycopy(salt, 0, result, 0, salt.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_466847347 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1598322030 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1598322030;
        // ---------- Original Method ----------
        //byte[] result = new byte[salt.length];
        //System.arraycopy(salt, 0, result, 0, salt.length);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.396 -0400", hash_original_method = "3E24EA64DC831AAEDCCD9EAD88FFC369", hash_generated_method = "49BD7777FF5FC50C1BBBD5B54425AA0F")
    public int getIterationCount() {
        int var40E092B298D076325C38C773B2D9BBAA_174231332 = (iterationCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645381970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645381970;
        // ---------- Original Method ----------
        //return iterationCount;
    }

    
}

