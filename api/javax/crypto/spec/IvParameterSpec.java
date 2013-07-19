package javax.crypto.spec;

// Droidsafe Imports
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class IvParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.351 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.351 -0400", hash_original_method = "D9A5990E9ED63A0A9D454C79A44593C3", hash_generated_method = "D3454F8EE869766B950A764ABBC8E98C")
    public  IvParameterSpec(byte[] iv) {
        if(iv == null)        
        {
            NullPointerException varFA3A74DCB59559DB05915F890BBC8166_663969900 = new NullPointerException("iv == null");
            varFA3A74DCB59559DB05915F890BBC8166_663969900.addTaint(taint);
            throw varFA3A74DCB59559DB05915F890BBC8166_663969900;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.352 -0400", hash_original_method = "60CA42675AB74B8A2A3519AD856C2D26", hash_generated_method = "4584EFD6725626B756AA66218621D28D")
    public  IvParameterSpec(byte[] iv, int offset, int byteCount) {
        addTaint(offset);
        if((iv == null) || (iv.length - offset < byteCount))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_767505419 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_767505419.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_767505419;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.352 -0400", hash_original_method = "A92FDD2E910AFCA63CE828A3161FD7A9", hash_generated_method = "A8396867AB1176299F53BB8519C57504")
    public byte[] getIV() {
        byte[] res = new byte[iv.length];
        System.arraycopy(iv, 0, res, 0, iv.length);
        byte[] var9B207167E5381C47682C6B4F58A623FB_2114203903 = (res);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2081490066 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2081490066;
        // ---------- Original Method ----------
        //byte[] res = new byte[iv.length];
        //System.arraycopy(iv, 0, res, 0, iv.length);
        //return res;
    }

    
}

