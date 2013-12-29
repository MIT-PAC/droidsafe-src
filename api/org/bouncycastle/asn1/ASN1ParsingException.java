package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ASN1ParsingException extends IllegalStateException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.926 -0500", hash_original_field = "E65D4B046C7E75D4305AF1275FC1F72B", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.927 -0500", hash_original_method = "A04BEE8A9A73EAD532708A0AE36FAA5C", hash_generated_method = "A04BEE8A9A73EAD532708A0AE36FAA5C")
    ASN1ParsingException(String message)
    {
        super(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.928 -0500", hash_original_method = "9ABB1845457B0FD65DC264E5CAAB1469", hash_generated_method = "9ABB1845457B0FD65DC264E5CAAB1469")
    ASN1ParsingException(String message, Throwable cause)
    {
        super(message);
        this.cause = cause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.929 -0500", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "7216169927F14A6BA3457BBD72FD53B3")
    public Throwable getCause()
    {
        return cause;
    }

    
}

