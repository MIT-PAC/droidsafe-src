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
    private byte[] iv;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.998 -0400", hash_original_method = "D9A5990E9ED63A0A9D454C79A44593C3", hash_generated_method = "8846104F206574A647C89FA5824E5FB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IvParameterSpec(byte[] iv) {
        dsTaint.addTaint(iv[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.998 -0400", hash_original_method = "60CA42675AB74B8A2A3519AD856C2D26", hash_generated_method = "632CEF97850EBF43354B0D9E6F017DDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IvParameterSpec(byte[] iv, int offset, int byteCount) {
        dsTaint.addTaint(iv[0]);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.998 -0400", hash_original_method = "A92FDD2E910AFCA63CE828A3161FD7A9", hash_generated_method = "014003342E34B60E4DF15CFADDC66893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getIV() {
        byte[] res;
        res = new byte[iv.length];
        System.arraycopy(iv, 0, res, 0, iv.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] res = new byte[iv.length];
        //System.arraycopy(iv, 0, res, 0, iv.length);
        //return res;
    }

    
}

