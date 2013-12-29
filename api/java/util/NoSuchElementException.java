package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class NoSuchElementException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:57.449 -0500", hash_original_field = "58B4976E288E6E7EACE55A374EB168F2", hash_generated_field = "2F8B5DF88AA8723E0C5AAA5627E38C1C")


    private static final long serialVersionUID = 6769829250639411880L;

    /**
     * Constructs a new {@code NoSuchElementException} with the current stack
     * trace filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:57.450 -0500", hash_original_method = "7511719788F886A7A8274E764953E7B7", hash_generated_method = "AD76BD1596748EFB1E4BF409E01B323E")
    public NoSuchElementException() {
    }

    /**
     * Constructs a new {@code NoSuchElementException} with the current stack
     * trace and message filled in.
     *
     * @param detailMessage
     *           the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:57.451 -0500", hash_original_method = "7D966D3BE675039003302E31B0D249C5", hash_generated_method = "DECCC69A8C5185F5C46B264ED37D6FB5")
    public NoSuchElementException(String detailMessage) {
        super(detailMessage);
    }
}

