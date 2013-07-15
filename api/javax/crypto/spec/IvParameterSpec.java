package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

public class IvParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.397 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.398 -0400", hash_original_method = "D9A5990E9ED63A0A9D454C79A44593C3", hash_generated_method = "A139254C8054C2476F56A9776864AF91")
    public  IvParameterSpec(byte[] iv) {
    if(iv == null)        
        {
            NullPointerException varFA3A74DCB59559DB05915F890BBC8166_1746848073 = new NullPointerException("iv == null");
            varFA3A74DCB59559DB05915F890BBC8166_1746848073.addTaint(taint);
            throw varFA3A74DCB59559DB05915F890BBC8166_1746848073;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.399 -0400", hash_original_method = "60CA42675AB74B8A2A3519AD856C2D26", hash_generated_method = "FA9A6C1E5C35729CC5F616693B0C9338")
    public  IvParameterSpec(byte[] iv, int offset, int byteCount) {
        addTaint(offset);
    if((iv == null) || (iv.length - offset < byteCount))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_243689281 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_243689281.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_243689281;
        } //End block
        Arrays.checkOffsetAndCount(iv.length, offset, byteCount);
        this.iv = new byte[byteCount];
        System.arraycopy(iv, offset, this.iv, 0, byteCount);
        // ---------- Original Method ----------
        //if ((iv == null) || (iv.length - offset < byteCount)) {
            //throw new IllegalArgumentException();
        //}
        //Arrays.checkOffsetAndCount(iv.length, offset, byteCount);
        //this.iv = new byte[byteCount];
        //System.arraycopy(iv, offset, this.iv, 0, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.400 -0400", hash_original_method = "A92FDD2E910AFCA63CE828A3161FD7A9", hash_generated_method = "1812D8ED37F0FED1C1C08BF5F179A186")
    public byte[] getIV() {
        byte[] res = new byte[iv.length];
        System.arraycopy(iv, 0, res, 0, iv.length);
        byte[] var9B207167E5381C47682C6B4F58A623FB_700806137 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_495602951 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_495602951;
        // ---------- Original Method ----------
        //byte[] res = new byte[iv.length];
        //System.arraycopy(iv, 0, res, 0, iv.length);
        //return res;
    }

    
}

