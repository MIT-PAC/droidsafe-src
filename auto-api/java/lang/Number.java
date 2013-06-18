package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Number implements java.io.Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:17:06.811 -0400", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "D2CCD29F4D81AEE9EDFA9AD93C3B8CFB")
    @DSModeled(DSC.SAFE)
    public Number() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:17:06.824 -0400", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "0ACC1D24CAA7711FB15C7FE20B253EAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte byteValue() {
        byte varFCC80F7A65AFB8CF91E5EF47AAFACDED_1918612262 = ((byte) intValue());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return (byte) intValue();
    }

    
    public abstract double doubleValue();

    
    public abstract float floatValue();

    
    public abstract int intValue();

    
    public abstract long longValue();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-18 16:17:06.848 -0400", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "EE678CD09BE07482A1B1FA8ED5B9DEEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short shortValue() {
        short var20931B4E90B4A9EEE9EA18D98303E5E7_1866213439 = ((short) intValue());
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return (short) intValue();
    }

    
    private static final long serialVersionUID = -8742448824652078965L;
}

