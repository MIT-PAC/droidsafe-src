package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class IvParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.940 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.941 -0400", hash_original_method = "D9A5990E9ED63A0A9D454C79A44593C3", hash_generated_method = "323675160905283E4A22A0D0E9068531")
    public  IvParameterSpec(byte[] iv) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("iv == null");
        } //End block
        this.iv = new byte[iv.length];
        System.arraycopy(iv, 0, this.iv, 0, iv.length);
        // ---------- Original Method ----------
        //if (iv == null) {
            //throw new NullPointerException("iv == null");
        //}
        //this.iv = new byte[iv.length];
        //System.arraycopy(iv, 0, this.iv, 0, iv.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.942 -0400", hash_original_method = "60CA42675AB74B8A2A3519AD856C2D26", hash_generated_method = "67E98522FE277E571A67C1E3B3291E07")
    public  IvParameterSpec(byte[] iv, int offset, int byteCount) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        Arrays.checkOffsetAndCount(iv.length, offset, byteCount);
        this.iv = new byte[byteCount];
        System.arraycopy(iv, offset, this.iv, 0, byteCount);
        addTaint(offset);
        // ---------- Original Method ----------
        //if ((iv == null) || (iv.length - offset < byteCount)) {
            //throw new IllegalArgumentException();
        //}
        //Arrays.checkOffsetAndCount(iv.length, offset, byteCount);
        //this.iv = new byte[byteCount];
        //System.arraycopy(iv, offset, this.iv, 0, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.942 -0400", hash_original_method = "A92FDD2E910AFCA63CE828A3161FD7A9", hash_generated_method = "E8D1F5535CB10AE3581E1BFE5BAF777D")
    public byte[] getIV() {
        byte[] res;
        res = new byte[iv.length];
        System.arraycopy(iv, 0, res, 0, iv.length);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_998383541 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_998383541;
        // ---------- Original Method ----------
        //byte[] res = new byte[iv.length];
        //System.arraycopy(iv, 0, res, 0, iv.length);
        //return res;
    }

    
}

