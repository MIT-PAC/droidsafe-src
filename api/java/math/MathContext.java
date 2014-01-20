package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public final class MathContext implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.323 -0500", hash_original_field = "D6C5EC8C483A1D8D440F91E4C407CE00", hash_generated_field = "AE26DFE059ADEEF6717365717079903C")

    private static final long serialVersionUID = 5579720004786848255L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.326 -0500", hash_original_field = "F2864B3AC673BA1732001A84A1D4B0C6", hash_generated_field = "53D7CD734ABD47C72DC3ACC9D1BD8A94")

    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.329 -0500", hash_original_field = "77E36F71A95DD745631BF2918EF6F414", hash_generated_field = "1A095316CBCE3D002966EC9687CD9B47")

    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.332 -0500", hash_original_field = "BB74C7E7D63668DB5D2F573AC5889E10", hash_generated_field = "C40CEDED9A18EAB0E8CB718E3F11A448")

    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.335 -0500", hash_original_field = "2CDF3D82F2B9B922D496C6A1AE0E5D7B", hash_generated_field = "BD670CA769A14674CDA6883CCDBF3384")

    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.337 -0500", hash_original_field = "302048F8E900E0D551C37EB8EF5936C1", hash_generated_field = "549991DA880D86C6AEB7236C4321FF98")

    private  int precision;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.339 -0500", hash_original_field = "3E5F0C041BE2DD9C7EAEBC662C46D014", hash_generated_field = "11B15080BF4B303F429EBEF56C22234F")

    private  RoundingMode roundingMode;

    /**
     * Constructs a new {@code MathContext} with the specified precision and
     * with the rounding mode {@link RoundingMode#HALF_UP HALF_UP}. If the
     * precision passed is zero, then this implies that the computations have to
     * be performed exact, the rounding mode in this case is irrelevant.
     *
     * @param precision
     *            the precision for the new {@code MathContext}.
     * @throws IllegalArgumentException
     *             if {@code precision < 0}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.342 -0500", hash_original_method = "F106BE9E01EEA929163197AB20FC2E93", hash_generated_method = "ED48F58267616074573C93A116EF135D")
    
public MathContext(int precision) {
        this(precision, RoundingMode.HALF_UP);
    }

    /**
     * Constructs a new {@code MathContext} with the specified precision and
     * with the specified rounding mode. If the precision passed is zero, then
     * this implies that the computations have to be performed exact, the
     * rounding mode in this case is irrelevant.
     *
     * @param precision
     *            the precision for the new {@code MathContext}.
     * @param roundingMode
     *            the rounding mode for the new {@code MathContext}.
     * @throws IllegalArgumentException
     *             if {@code precision < 0}.
     * @throws NullPointerException
     *             if {@code roundingMode} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.345 -0500", hash_original_method = "8370E5A41DB25B2BD130B4958C97346D", hash_generated_method = "326C198F27A28956CF1D6E22903C6750")
    
public MathContext(int precision, RoundingMode roundingMode) {
        this.precision = precision;
        this.roundingMode = roundingMode;
        checkValid();
    }

    /**
     * Constructs a new {@code MathContext} from a string. The string has to
     * specify the precision and the rounding mode to be used and has to follow
     * the following syntax: "precision=&lt;precision&gt; roundingMode=&lt;roundingMode&gt;"
     * This is the same form as the one returned by the {@link #toString}
     * method.
     *
     * @throws IllegalArgumentException
     *             if the string is not in the correct format or if the
     *             precision specified is < 0.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.348 -0500", hash_original_method = "1D8B76B7C700FBF158167DD4C05A3C30", hash_generated_method = "96CB7A0DB097A7BF33DE16B65A96E3E8")
    
public MathContext(String s) {
        int precisionLength = "precision=".length();
        int roundingModeLength = "roundingMode=".length();

        int spaceIndex;
        if (!s.startsWith("precision=") || (spaceIndex = s.indexOf(' ', precisionLength)) == -1) {
            throw invalidMathContext("Missing precision", s);
        }
        String precisionString = s.substring(precisionLength, spaceIndex);
        try {
            this.precision = Integer.parseInt(precisionString);
        } catch (NumberFormatException nfe) {
            throw invalidMathContext("Bad precision", s);
        }

        int roundingModeStart = spaceIndex + 1;
        if (!s.regionMatches(roundingModeStart, "roundingMode=", 0, roundingModeLength)) {
            throw invalidMathContext("Missing rounding mode", s);
        }
        roundingModeStart += roundingModeLength;
        this.roundingMode = RoundingMode.valueOf(s.substring(roundingModeStart));

        checkValid();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.352 -0500", hash_original_method = "426953F7355AB3CD325EF2685FB1287C", hash_generated_method = "71E5194BC4611C1B71D7A4670C0EE195")
    
private IllegalArgumentException invalidMathContext(String reason, String s) {
        throw new IllegalArgumentException(reason + ": " + s);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.354 -0500", hash_original_method = "D8DAE7CCCFF0DCEAE4D1ED9221F38BDC", hash_generated_method = "8D5FCA96363B89E55239D1C0C0DF3190")
    
private void checkValid() {
        if (precision < 0) {
            throw new IllegalArgumentException("Negative precision: " + precision);
        }
        if (roundingMode == null) {
            throw new NullPointerException("roundingMode == null");
        }
    }

    /**
     * Returns the precision. The precision is the number of digits used for an
     * operation. Results are rounded to this precision. The precision is
     * guaranteed to be non negative. If the precision is zero, then the
     * computations have to be performed exact, results are not rounded in this
     * case.
     *
     * @return the precision.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.357 -0500", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "A8933D1A9891189E4D69EEFC50A2F6A3")
    
public int getPrecision() {
        return precision;
    }

    /**
     * Returns the rounding mode. The rounding mode is the strategy to be used
     * to round results.
     * <p>
     * The rounding mode is one of
     * {@link RoundingMode#UP},
     * {@link RoundingMode#DOWN},
     * {@link RoundingMode#CEILING},
     * {@link RoundingMode#FLOOR},
     * {@link RoundingMode#HALF_UP},
     * {@link RoundingMode#HALF_DOWN},
     * {@link RoundingMode#HALF_EVEN}, or
     * {@link RoundingMode#UNNECESSARY}.
     *
     * @return the rounding mode.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.359 -0500", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "6D523F860AF5DA84DA6E20F0C7E0AAFA")
    
public RoundingMode getRoundingMode() {
        return roundingMode;
    }

    /**
     * Returns true if x is a {@code MathContext} with the same precision
     * setting and the same rounding mode as this {@code MathContext} instance.
     *
     * @param x
     *            object to be compared.
     * @return {@code true} if this {@code MathContext} instance is equal to the
     *         {@code x} argument; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.361 -0500", hash_original_method = "297627CFD1856C2678820F72FEC54301", hash_generated_method = "42CFCBB47BC16705E38674A80E91B3F9")
    
@Override
    public boolean equals(Object x) {
        return ((x instanceof MathContext)
                && (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                .getRoundingMode() == roundingMode));
    }

    /**
     * Returns the hash code for this {@code MathContext} instance.
     *
     * @return the hash code for this {@code MathContext}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.364 -0500", hash_original_method = "CDDF05FC589C0F0146B62DD26D215A30", hash_generated_method = "B195C6308746B1DAC1EA450308C3E284")
    
@Override
    public int hashCode() {
        // Make place for the necessary bits to represent 8 rounding modes
        return ((precision << 3) | roundingMode.ordinal());
    }

    /**
     * Returns the string representation for this {@code MathContext} instance.
     * The string has the form
     * {@code
     * "precision=<precision> roundingMode=<roundingMode>"
     * } where {@code <precision>} is an integer describing the number
     * of digits used for operations and {@code <roundingMode>} is the
     * string representation of the rounding mode.
     *
     * @return a string representation for this {@code MathContext} instance
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.366 -0500", hash_original_method = "537ED30546F81713B44C66AB9FEB6470", hash_generated_method = "6DC8430757F134AB039D50B3DD0CF7F7")
    
@Override
    public String toString() {
        return "precision=" + precision + " roundingMode=" + roundingMode;
    }

    /**
     * Makes checks upon deserialization of a {@code MathContext} instance.
     * Checks whether {@code precision >= 0} and {@code roundingMode != null}
     *
     * @throws StreamCorruptedException
     *             if {@code precision < 0}
     * @throws StreamCorruptedException
     *             if {@code roundingMode == null}
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:34.369 -0500", hash_original_method = "323BCE51E980C267DF7F7C47AD5D1D50", hash_generated_method = "0C99EEF0C4D6801AF7A92F869AD842C8")
    
private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        try {
            checkValid();
        } catch (Exception ex) {
            throw new StreamCorruptedException(ex.getMessage());
        }
    }
}

