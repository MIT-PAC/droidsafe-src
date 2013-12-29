package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;



public class ZipException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.442 -0500", hash_original_field = "4A2D351F8B38814F4292A15EFC49EC22", hash_generated_field = "7A3B8D4739EACA05C4F8E66A30715AB1")


    private static final long serialVersionUID = 8000196834066748623L;

    /**
     * Constructs a new {@code ZipException} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.443 -0500", hash_original_method = "2167A1F4D125B524620850E643449987", hash_generated_method = "E5CE709B923AF08AC6458F4922EAC2D3")
    public ZipException() {
    }

    /**
     * Constructs a new {@code ZipException} instance with the specified
     * message.
     *
     * @param detailMessage
     *            the detail message for the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:49.444 -0500", hash_original_method = "594D1061F67CD3EF6F4592503B4204F0", hash_generated_method = "BEB746CBC91CB5D7CA094315F0C2C9E2")
    public ZipException(String detailMessage) {
        super(detailMessage);
    }
}

