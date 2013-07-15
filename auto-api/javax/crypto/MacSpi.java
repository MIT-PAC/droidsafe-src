package javax.crypto;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public abstract class MacSpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.150 -0400", hash_original_method = "EEBADA04ED7B15342A993162A4F56017", hash_generated_method = "8D6409E06ABF820FA39D434786DC17A2")
    public  MacSpi() {
        
    }

    
    protected abstract int engineGetMacLength();

    
    protected abstract void engineInit(Key key, AlgorithmParameterSpec params)
            throws InvalidKeyException, InvalidAlgorithmParameterException;

    
    protected abstract void engineUpdate(byte input);

    
    protected abstract void engineUpdate(byte[] input, int offset, int len);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.153 -0400", hash_original_method = "7BFE449B7BFB03ADBCFF5433860FD67B", hash_generated_method = "EBF55002B771D3CB70C27BDD909394D6")
    protected void engineUpdate(ByteBuffer input) {
        {
            boolean varE54245A319FB90E6E4BB7E9A96B716C3_238655920 = (!input.hasRemaining());
        } 
        byte[] bInput;
        {
            boolean var011961AA1A198646CB962085FB0562D5_260849424 = (input.hasArray());
            {
                bInput = input.array();
                int offset = input.arrayOffset();
                int position = input.position();
                int limit = input.limit();
                engineUpdate(bInput, offset + position, limit - position);
                input.position(limit);
            } 
            {
                bInput = new byte[input.limit() - input.position()];
                input.get(bInput);
                engineUpdate(bInput, 0, bInput.length);
            } 
        } 
        addTaint(input.getTaint());
        
        
            
        
        
        
            
            
            
            
            
            
        
            
            
            
        
    }

    
    protected abstract byte[] engineDoFinal();

    
    protected abstract void engineReset();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.154 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "1C3E985E19B3ACCD97BF172AF011D81C")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2096285350 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2096285350 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2096285350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2096285350;
        
        
    }

    
}

