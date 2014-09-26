package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class Number implements java.io.Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.880 -0500", hash_original_field = "8ED2AB1A1A8D8066F1DD92F6C2FA309A", hash_generated_field = "260B10B3E0C4A998D38D753F372E132A")

    private static final long serialVersionUID = -8742448824652078965L;

    /**
     * Empty default constructor.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.884 -0500", hash_original_method = "AF006D3372C503951E85770849BA1AA0", hash_generated_method = "0DDED80C3C18CBC71A1EC7B1DDA781D2")
    
public Number() {
    }

    /**
     * Returns this object's value as a byte. Might involve rounding and/or
     * truncating the value, so it fits into a byte.
     *
     * @return the primitive byte value of this object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.886 -0500", hash_original_method = "CE1931476457BE311793F2D350973D7B", hash_generated_method = "CB98D0F615F6DB83A9C991B104749D4A")
    
public byte byteValue() {
        return (byte) intValue();
    }

    /**
     * Returns this object's value as a double. Might involve rounding.
     *
     * @return the primitive double value of this object.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.888 -0500", hash_original_method = "ECE731968B529334C266D08292398822", hash_generated_method = "7EA53A2B2C1AC2DDAC0C53F7D9305ADA")
    
public abstract double doubleValue();

    /**
     * Returns this object's value as a float. Might involve rounding.
     *
     * @return the primitive float value of this object.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.891 -0500", hash_original_method = "28E8B58AB2C6301549A92ED9F41DD2A2", hash_generated_method = "D6B00E764949C7A1379BB92339FD15E8")
    
public abstract float floatValue();

    /**
     * Returns this object's value as an int. Might involve rounding and/or
     * truncating the value, so it fits into an int.
     *
     * @return the primitive int value of this object.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.893 -0500", hash_original_method = "A286406E26D7EBC018CE3A50287F7A12", hash_generated_method = "6DD28E435B306FA7438646E7A81055B0")
    
public abstract int intValue();

    /**
     * Returns this object's value as a long. Might involve rounding and/or
     * truncating the value, so it fits into a long.
     *
     * @return the primitive long value of this object.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.896 -0500", hash_original_method = "B671F368853851977CE77CF906828C6B", hash_generated_method = "BD142D8A949784DEE3CDE89C2828F00A")
    
public abstract long longValue();

    /**
     * Returns this object's value as a short. Might involve rounding and/or
     * truncating the value, so it fits into a short.
     *
     * @return the primitive short value of this object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:21.898 -0500", hash_original_method = "C1E7C69DF6DC74A923544E16C9C68CB8", hash_generated_method = "E060B506A3D8C38BFF0347DB2D1D55DB")
    
public short shortValue() {
        return (short) intValue();
    }
}

