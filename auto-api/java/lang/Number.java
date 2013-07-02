package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class Number implements java.io.Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.407 -0400", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "D2CCD29F4D81AEE9EDFA9AD93C3B8CFB")
    public  Number() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.407 -0400", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "7C09507AF9E8118727E6CD25E6DCBF58")
    public byte byteValue() {
        byte varFCC80F7A65AFB8CF91E5EF47AAFACDED_1131833430 = ((byte) intValue());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1377275015 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1377275015;
        
        
    }

    
    public abstract double doubleValue();

    
    public abstract float floatValue();

    
    public abstract int intValue();

    
    public abstract long longValue();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.412 -0400", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "3B571258CE51114AA6B5B0657F4EC861")
    public short shortValue() {
        short var20931B4E90B4A9EEE9EA18D98303E5E7_1716306850 = ((short) intValue());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1665292220 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1665292220;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.412 -0400", hash_original_field = "0D4E270C7B9C46BB634D0A20D8CD57F0", hash_generated_field = "260B10B3E0C4A998D38D753F372E132A")

    private static final long serialVersionUID = -8742448824652078965L;
}

