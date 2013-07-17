package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Number implements java.io.Serializable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.374 -0400", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "D2CCD29F4D81AEE9EDFA9AD93C3B8CFB")
    public  Number() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.374 -0400", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "D04404E8A01141F808A22C2F00CA8C9B")
    public byte byteValue() {
        byte varAB6A0977A2AC1051631C41A28EA37E35_843710953 = ((byte) intValue());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_943605194 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_943605194;
        // ---------- Original Method ----------
        //return (byte) intValue();
    }

    
    public abstract double doubleValue();

    
    public abstract float floatValue();

    
    public abstract int intValue();

    
    public abstract long longValue();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.374 -0400", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "5CE789C71F8CAC5865E90A917931ACA5")
    public short shortValue() {
        short var608412D86CCC90218FD932B136578864_1352530971 = ((short) intValue());
                short var4F09DAA9D95BCB166A302407A0E0BABE_1735555458 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1735555458;
        // ---------- Original Method ----------
        //return (short) intValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.374 -0400", hash_original_field = "0D4E270C7B9C46BB634D0A20D8CD57F0", hash_generated_field = "260B10B3E0C4A998D38D753F372E132A")

    private static final long serialVersionUID = -8742448824652078965L;
}

