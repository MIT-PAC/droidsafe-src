package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract class MacSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.337 -0400", hash_original_method = "EEBADA04ED7B15342A993162A4F56017", hash_generated_method = "8D6409E06ABF820FA39D434786DC17A2")
    public  MacSpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract int engineGetMacLength();

    
    protected abstract void engineInit(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.341 -0400", hash_original_method = "7BFE449B7BFB03ADBCFF5433860FD67B", hash_generated_method = "63823689C67BEE238B041BFC33C14571")
    protected void engineUpdate(ByteBuffer input) {
        addTaint(input.getTaint());
    if(!input.hasRemaining())        
        {
            return;
        } //End block
        byte[] bInput;
    if(input.hasArray())        
        {
            bInput = input.array();
            int offset = input.arrayOffset();
            int position = input.position();
            int limit = input.limit();
            engineUpdate(bInput, offset + position, limit - position);
            input.position(limit);
        } //End block
        else
        {
            bInput = new byte[input.limit() - input.position()];
            input.get(bInput);
            engineUpdate(bInput, 0, bInput.length);
        } //End block
        // ---------- Original Method ----------
        //if (!input.hasRemaining()) {
            //return;
        //}
        //byte[] bInput;
        //if (input.hasArray()) {
            //bInput = input.array();
            //int offset = input.arrayOffset();
            //int position = input.position();
            //int limit = input.limit();
            //engineUpdate(bInput, offset + position, limit - position);
            //input.position(limit);
        //} else {
            //bInput = new byte[input.limit() - input.position()];
            //input.get(bInput);
            //engineUpdate(bInput, 0, bInput.length);
        //}
    }

    
    protected abstract byte[] engineDoFinal();

    
    protected abstract void engineReset();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.342 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "3E0E8F2B535496DB86C5FE3AD67B7DA5")
    @Override
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_832995573 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_832995573.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_832995573;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

