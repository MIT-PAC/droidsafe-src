package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.310 -0500", hash_original_field = "566D79FEB7CB217592C90DBD6DA1897B", hash_generated_field = "6CD7B1F210CD187D17EA805F9FEEEB81")


    private static final long serialVersionUID = -5116101128118950844L;

    /**
     * Constructs a new {@code ArrayIndexOutOfBoundsException} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.311 -0500", hash_original_method = "2927C5AB3FFF56BF1DCC2EADE5C9261A", hash_generated_method = "65F8B1FA2FF7E4237F7FDCDC7C8B69C0")
    public ArrayIndexOutOfBoundsException() {
    }

    /**
     * Constructs a new {@code ArrayIndexOutOfBoundsException} with the current
     * stack trace and a detail message that is based on the specified invalid
     * {@code index}.
     *
     * @param index
     *            the invalid index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.312 -0500", hash_original_method = "A2D257A78FEA506C4C8D36FA0F1793DA", hash_generated_method = "34CB6BF1BD7FA95D7940472389E46EA0")
    public ArrayIndexOutOfBoundsException(int index) {
        super("index=" + index);
    }

    /**
     * Constructs a new {@code ArrayIndexOutOfBoundsException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.313 -0500", hash_original_method = "1D48A4D94F5DE13F2F12604B33D446C2", hash_generated_method = "06D642AEB32C683B4075FC89AB279941")
    public ArrayIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.314 -0500", hash_original_method = "FD6957908D778700DE2EEE696A8B754C", hash_generated_method = "D118BA6F916221C8B09E2997DCAB4C14")
    public ArrayIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:22.315 -0500", hash_original_method = "5D0675654F8D9644AC21F8916F1DF9DD", hash_generated_method = "6DB83B372C9D247F9FDD886D033FB4E8")
    public ArrayIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
    }
}

