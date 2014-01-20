package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.WeakHashMap;

public class CoderResult {

    /**
     * Gets a <code>CoderResult</code> object indicating a malformed-input
     * error.
     *
     * @param length
     *            the length of the malformed-input.
     * @return a <code>CoderResult</code> object indicating a malformed-input
     *         error.
     * @throws IllegalArgumentException
     *             if <code>length</code> is non-positive.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.573 -0500", hash_original_method = "32B9309C5888D5D441E10DB420683F91", hash_generated_method = "EA5ABC13387F1533A05FEB74F9C87F72")
    
public static synchronized CoderResult malformedForLength(int length)
            throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_malformedErrors) {
                CoderResult r = _malformedErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_MALFORMED_INPUT, length);
                    _malformedErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }

    /**
     * Gets a <code>CoderResult</code> object indicating an unmappable
     * character error.
     *
     * @param length
     *            the length of the input unit sequence denoting the unmappable
     *            character.
     * @return a <code>CoderResult</code> object indicating an unmappable
     *         character error.
     * @throws IllegalArgumentException
     *             if <code>length</code> is non-positive.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.576 -0500", hash_original_method = "BBA6EC87D4C3AA6AD9F0D4B623871AE8", hash_generated_method = "D790B3ABAD493C64B831394CF1B5AB81")
    
public static synchronized CoderResult unmappableForLength(int length)
            throws IllegalArgumentException {
        if (length > 0) {
            Integer key = Integer.valueOf(length);
            synchronized (_unmappableErrors) {
                CoderResult r = _unmappableErrors.get(key);
                if (r == null) {
                    r = new CoderResult(TYPE_UNMAPPABLE_CHAR, length);
                    _unmappableErrors.put(key, r);
                }
                return r;
            }
        }
        throw new IllegalArgumentException("Length must be greater than 0; was " + length);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.545 -0500", hash_original_field = "736E556375BF1F49C683D73D8E175467", hash_generated_field = "5686A0817753AB01F5538639E94A3DB2")

    private static final int TYPE_UNDERFLOW = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.547 -0500", hash_original_field = "E086BC2C850EF8A448B3255248516DC3", hash_generated_field = "B613814D9EB59828D84474AB56824F80")

    private static final int TYPE_OVERFLOW = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.550 -0500", hash_original_field = "40BA49603CD831C4863E2168D2B6032A", hash_generated_field = "CEE082D95D99A5E2E7B86BB6C60A7BA8")

    private static final int TYPE_MALFORMED_INPUT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.553 -0500", hash_original_field = "ACEE1DF0ABAF89AE35BBE1D848D3087D", hash_generated_field = "257A8E9EEAB537C120C9FA5C89913FBC")

    private static final int TYPE_UNMAPPABLE_CHAR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.555 -0500", hash_original_field = "6DF9F9080668FD7DFB17F69A213609C0", hash_generated_field = "CED3245C886E68DD4C6FB67AC5FE6EEB")

    public static final CoderResult UNDERFLOW = new CoderResult(TYPE_UNDERFLOW,
            0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.557 -0500", hash_original_field = "6D5BA814E78079A7901219E2C3384246", hash_generated_field = "17DE0F56BB1CAD86851E26DC64EBFBED")

    public static final CoderResult OVERFLOW = new CoderResult(TYPE_OVERFLOW, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.560 -0500", hash_original_field = "51F14ADC46A8071C860A1C207D46EABE", hash_generated_field = "154F7BAB5D229D86020DFDB6943A833A")

    private static WeakHashMap<Integer, CoderResult> _malformedErrors = new WeakHashMap<Integer, CoderResult>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.562 -0500", hash_original_field = "2FF02050F13DE357D5DB07B728E09FDE", hash_generated_field = "4A3051E3D68AB1D3FECCCF1B94957C66")

    private static WeakHashMap<Integer, CoderResult> _unmappableErrors = new WeakHashMap<Integer, CoderResult>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.564 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "E1B24004551291FC3F431CA1B2F6785F")

    private  int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.567 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "C7D2E1B1F4403418CA216FC250689056")

    private  int length;

    /**
     * Constructs a <code>CoderResult</code> object with its text description.
     *
     * @param type
     *            the type of this result
     * @param length
     *            the length of the erroneous input
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.570 -0500", hash_original_method = "720E366141B1E6A3092F9CE363C44766", hash_generated_method = "FB49B0EB754E7FF4B7B137E2B4C0B486")
    
private CoderResult(int type, int length) {
        this.type = type;
        this.length = length;
    }

    /**
     * Returns true if this result is an underflow condition.
     *
     * @return true if an underflow, otherwise false.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.579 -0500", hash_original_method = "72D962B2D73E7D1A25E9E1AB76F037A1", hash_generated_method = "CAF9A4E111854F6FF7C687173E4F4809")
    
public boolean isUnderflow() {
        return this.type == TYPE_UNDERFLOW;
    }

    /**
     * Returns true if this result represents a malformed-input error or an
     * unmappable-character error.
     *
     * @return true if this is a malformed-input error or an
     *         unmappable-character error, otherwise false.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.581 -0500", hash_original_method = "6E4CD2CEA8B470E2711551FAF2632892", hash_generated_method = "1D64F760E3C6751142FF43E5BE9BABBC")
    
public boolean isError() {
        return this.type == TYPE_MALFORMED_INPUT
                || this.type == TYPE_UNMAPPABLE_CHAR;
    }

    /**
     * Returns true if this result represents a malformed-input error.
     *
     * @return true if this is a malformed-input error, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.583 -0500", hash_original_method = "A1FC6FBF45CD4662583E11635A563069", hash_generated_method = "889DBFFCEA6AA85967FA554415EFE20F")
    
public boolean isMalformed() {
        return this.type == TYPE_MALFORMED_INPUT;
    }

    /**
     * Returns true if this result is an overflow condition.
     *
     * @return true if this is an overflow, otherwise false.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.586 -0500", hash_original_method = "B611C5CE05597AA2840AB6FA98EFB1D0", hash_generated_method = "716A62D018BCE4DEC3B5E75C09F90BCC")
    
public boolean isOverflow() {
        return this.type == TYPE_OVERFLOW;
    }

    /**
     * Returns true if this result represents an unmappable-character error.
     *
     * @return true if this is an unmappable-character error, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.588 -0500", hash_original_method = "406F98BDE206F12612B0B50954C0A2D7", hash_generated_method = "7461A2B81E86EC49BAF71719D92CF9E9")
    
public boolean isUnmappable() {
        return this.type == TYPE_UNMAPPABLE_CHAR;
    }

    /**
     * Gets the length of the erroneous input. The length is only meaningful to
     * a malformed-input error or an unmappable character error.
     *
     * @return the length, as an integer, of this object's erroneous input.
     * @throws UnsupportedOperationException
     *             if this result is an overflow or underflow.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.590 -0500", hash_original_method = "9DF3E8EF203785D8A82D753745232C5B", hash_generated_method = "DE2957DCFEB66976F2236C529DEAD126")
    
public int length() throws UnsupportedOperationException {
        if (this.type == TYPE_MALFORMED_INPUT || this.type == TYPE_UNMAPPABLE_CHAR) {
            return this.length;
        }
        throw new UnsupportedOperationException("length meaningless for " + toString());
    }

    /**
     * Throws an exception corresponding to this coder result.
     *
     * @throws BufferUnderflowException
     *             in case this is an underflow.
     * @throws BufferOverflowException
     *             in case this is an overflow.
     * @throws UnmappableCharacterException
     *             in case this is an unmappable-character error.
     * @throws MalformedInputException
     *             in case this is a malformed-input error.
     * @throws CharacterCodingException
     *             the default exception.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.593 -0500", hash_original_method = "8994A4AB686221398F6DD6413AEB03CF", hash_generated_method = "F1C666256FC275EB16EDAF06C5753736")
    
public void throwException() throws BufferUnderflowException,
            BufferOverflowException, UnmappableCharacterException,
            MalformedInputException, CharacterCodingException {
        switch (this.type) {
            case TYPE_UNDERFLOW:
                throw new BufferUnderflowException();
            case TYPE_OVERFLOW:
                throw new BufferOverflowException();
            case TYPE_UNMAPPABLE_CHAR:
                throw new UnmappableCharacterException(this.length);
            case TYPE_MALFORMED_INPUT:
                throw new MalformedInputException(this.length);
            default:
                throw new CharacterCodingException();
        }
    }

    /**
     * Returns a text description of this result.
     *
     * @return a text description of this result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.596 -0500", hash_original_method = "1AD631AC990AF6BF0D5460B8B5F54BE7", hash_generated_method = "EDA28ADE4E57B024E9B8B348558ECB79")
    
@Override
    public String toString() {
        String dsc = null;
        switch (this.type) {
            case TYPE_UNDERFLOW:
                dsc = "UNDERFLOW error";
                break;
            case TYPE_OVERFLOW:
                dsc = "OVERFLOW error";
                break;
            case TYPE_UNMAPPABLE_CHAR:
                dsc = "Unmappable-character error with erroneous input length "
                        + this.length;
                break;
            case TYPE_MALFORMED_INPUT:
                dsc = "Malformed-input error with erroneous input length "
                        + this.length;
                break;
            default:
                dsc = "";
                break;
        }
        return getClass().getName() + "[" + dsc + "]";
    }
}

