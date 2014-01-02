package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.303 -0500", hash_original_field = "7EA43E41A744677334DE8C1359FD2961", hash_generated_field = "AC3AE2C28E52C0DAB3994D3DB41195D6")


    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * Constructs a new {@code StringIndexOutOfBoundsException} that includes
     * the current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.306 -0500", hash_original_method = "BFD818381E149072D6480C59814A950B", hash_generated_method = "A8FA3953400600EBEE112C798CD7D63C")
    
public StringIndexOutOfBoundsException() {
    }

    /**
     * Constructs a new {@code StringIndexOutOfBoundsException} with the current
     * stack trace and a detail message that is based on the specified invalid
     * {@code index}.
     *
     * @param index
     *            the index which is out of bounds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.309 -0500", hash_original_method = "7844EE32C07F0B5F2D2D2CE3133A8CE2", hash_generated_method = "69E728882E16FEC90BE86EE9741ABE2A")
    
public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }

    /**
     * Constructs a new {@code StringIndexOutOfBoundsException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.311 -0500", hash_original_method = "2720998883F0FDFEFA87A6BF1A5B67C6", hash_generated_method = "FD386D30AADE4B846F870C3EBD2DE165")
    
public StringIndexOutOfBoundsException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.314 -0500", hash_original_method = "FCCD2BDA38C43A03106A3DA5EA866DEA", hash_generated_method = "A8751CA0E6011BD377A71992646CC23F")
    
public StringIndexOutOfBoundsException(String s, int index) {
        this(s.length(), index);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.317 -0500", hash_original_method = "78176BEE1BF5E3D3E49AE6693FD0EBDF", hash_generated_method = "6670A1B97B49FE038CF2317C86D1B7D8")
    
public StringIndexOutOfBoundsException(int sourceLength, int index) {
        super("length=" + sourceLength + "; index=" + index);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.320 -0500", hash_original_method = "E66129678530AEEFFFBEABAD39F4532F", hash_generated_method = "FC5D27153C9486C901A5C24918336DC1")
    
public StringIndexOutOfBoundsException(String s, int offset, int count) {
        this(s.length(), offset, count);
    }

    /**
     * Used internally for consistent high-quality error reporting.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:19.322 -0500", hash_original_method = "47D615FB94A12D10BEA7B6CBBC941916", hash_generated_method = "0514F160BD4EA0E9C6FAFAF642F1790D")
    
public StringIndexOutOfBoundsException(int sourceLength, int offset,
            int count) {
        super("length=" + sourceLength + "; regionStart=" + offset
                + "; regionLength=" + count);
    }
}

