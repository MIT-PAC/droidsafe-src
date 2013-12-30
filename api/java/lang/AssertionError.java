package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AssertionError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.872 -0500", hash_original_field = "23DC8363492CC647937818C0E00407BE", hash_generated_field = "A3497D23B93DF9E4AA64EF083CEEBD5B")


    private static final long serialVersionUID = -5013299493970297370L;

    /**
     * Constructs a new {@code AssertionError} with no message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.875 -0500", hash_original_method = "632C9A91920500ECFBFF7CDB1241885E", hash_generated_method = "693B1D496B276CC308C2F45C99B919C6")
    
public AssertionError() {
    }

    /**
     * Constructs a new {@code AssertionError} with the given detail message and cause.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.878 -0500", hash_original_method = "DB301E384A0E7AC0DA0AB52BDA1439A9", hash_generated_method = "B9E7AA1AB9CA3AD315D55ED90AFD873D")
    
public AssertionError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(Object)} with the specified object. If the object
     * is an instance of {@link Throwable}, then it also becomes the cause of
     * this error.
     *
     * @param detailMessage
     *            the object to be converted into the detail message and
     *            optionally the cause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.881 -0500", hash_original_method = "CD7903E922C4B27895502309BFA5EB07", hash_generated_method = "49E2E05E2EBA3C339CD09977A491E7B5")
    
public AssertionError(Object detailMessage) {
        super(String.valueOf(detailMessage),
                (detailMessage instanceof Throwable ? (Throwable) detailMessage : null));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(boolean)} with the specified boolean value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.884 -0500", hash_original_method = "BB55778BC77D5B95187F495DBBF45981", hash_generated_method = "C8DA077409E395566E29DC6A26A1E37F")
    
public AssertionError(boolean detailMessage) {
        this(String.valueOf(detailMessage));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(char)} with the specified character value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.887 -0500", hash_original_method = "0919D94AF324C3859333ED19301CBB4C", hash_generated_method = "18C13D659F8973297BF4C562E3FC882E")
    
public AssertionError(char detailMessage) {
        this(String.valueOf(detailMessage));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(int)} with the specified integer value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.890 -0500", hash_original_method = "462DB8F5A907CF4FAF9D9C058DE243DA", hash_generated_method = "9AE20776A7A65CA7C2AC898C0A3214B1")
    
public AssertionError(int detailMessage) {
        this(Integer.toString(detailMessage));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(long)} with the specified long value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.892 -0500", hash_original_method = "0B1F386E30482F841F5BBFF8DA2D4AD5", hash_generated_method = "618EDECF1CBBE73F265F3B66065DBD82")
    
public AssertionError(long detailMessage) {
        this(Long.toString(detailMessage));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(float)} with the specified float value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.895 -0500", hash_original_method = "00A378BEF68E5943BA88BAF8271D8A43", hash_generated_method = "204F3F53B1C828C3E14D2ECBE635FA94")
    
public AssertionError(float detailMessage) {
        this(Float.toString(detailMessage));
    }

    /**
     * Constructs a new {@code AssertionError} with a message based on calling
     * {@link String#valueOf(double)} with the specified double value.
     *
     * @param detailMessage
     *            the value to be converted into the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.897 -0500", hash_original_method = "7A2F5DA0FAF43875CE47806BEFC9388A", hash_generated_method = "D8DCE6824D8F179358E48109F73CA8D6")
    
public AssertionError(double detailMessage) {
        this(Double.toString(detailMessage));
    }
}

