package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Number implements java.io.Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.898 -0400", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "D2CCD29F4D81AEE9EDFA9AD93C3B8CFB")
    @DSModeled(DSC.SAFE)
    public Number() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.898 -0400", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "9F262B50A6D20BFCFB1E930CB95A1164")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte byteValue() {
        byte varFCC80F7A65AFB8CF91E5EF47AAFACDED_1355111559 = ((byte) intValue());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) intValue();
    }

    
    public abstract double doubleValue();

    
    public abstract float floatValue();

    
    public abstract int intValue();

    
    public abstract long longValue();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.899 -0400", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "162B0AF5CD82B5D058437EAD72238E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short shortValue() {
        short var20931B4E90B4A9EEE9EA18D98303E5E7_1276394684 = ((short) intValue());
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) intValue();
    }

    
    private static final long serialVersionUID = -8742448824652078965L;
}

