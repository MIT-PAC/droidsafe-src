package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Number implements java.io.Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.039 -0400", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "D2CCD29F4D81AEE9EDFA9AD93C3B8CFB")
    public  Number() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.040 -0400", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "2C1E6F9F599C017F441CDF386E423B10")
    public byte byteValue() {
        byte varFCC80F7A65AFB8CF91E5EF47AAFACDED_795552345 = ((byte) intValue());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_438129087 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_438129087;
        // ---------- Original Method ----------
        //return (byte) intValue();
    }

    
    public abstract double doubleValue();

    
    public abstract float floatValue();

    
    public abstract int intValue();

    
    public abstract long longValue();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.041 -0400", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "CD0B4A03C9B84AC8334EC3DDC732315C")
    public short shortValue() {
        short var20931B4E90B4A9EEE9EA18D98303E5E7_2107782540 = ((short) intValue());
        short var4F09DAA9D95BCB166A302407A0E0BABE_47849811 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_47849811;
        // ---------- Original Method ----------
        //return (short) intValue();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:40.042 -0400", hash_original_field = "0D4E270C7B9C46BB634D0A20D8CD57F0", hash_generated_field = "36FE7B7EB4F4EC02C231143F2A3F8954")

    private static long serialVersionUID = -8742448824652078965L;
}

