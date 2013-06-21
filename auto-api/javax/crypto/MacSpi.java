package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract class MacSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.988 -0400", hash_original_method = "EEBADA04ED7B15342A993162A4F56017", hash_generated_method = "8D6409E06ABF820FA39D434786DC17A2")
    @DSModeled(DSC.SAFE)
    public MacSpi() {
        // ---------- Original Method ----------
    }

    
    protected abstract int engineGetMacLength();

    
    protected abstract void engineInit(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.988 -0400", hash_original_method = "7BFE449B7BFB03ADBCFF5433860FD67B", hash_generated_method = "EB6E780E07A64A1527483CDBB82DDD47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void engineUpdate(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_2027194709 = (!input.hasRemaining());
        } //End collapsed parenthetic
        byte[] bInput;
        {
            boolean var011961AA1A198646CB962085FB0562D5_383435706 = (input.hasArray());
            {
                bInput = input.array();
                int offset;
                offset = input.arrayOffset();
                int position;
                position = input.position();
                int limit;
                limit = input.limit();
                engineUpdate(bInput, offset + position, limit - position);
                input.position(limit);
            } //End block
            {
                bInput = new byte[input.limit() - input.position()];
                input.get(bInput);
                engineUpdate(bInput, 0, bInput.length);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.989 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "6A227C2D1D640F62C3CA336F7897C954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object var234434AAD2BC7C43140CB7A97B63D24C_431478187 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

