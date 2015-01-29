package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolException;

public class NonRepeatableRequestException extends ProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.931 -0500", hash_original_field = "AFFA6C6BD215171C8C2709B4F0002176", hash_generated_field = "CBAF5D482FD12BECD83779ACC6D0F5A0")

    private static final long serialVersionUID = 82685265288806048L;

    /**
     * Creates a new NonRepeatableEntityException with a <tt>null</tt> detail message. 
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.934 -0500", hash_original_method = "14DECFA9FD444F48F1267DE5834D3279", hash_generated_method = "507046DDE19EC846305CEFA119CDCD0F")
    
public NonRepeatableRequestException() {
        super();
    }

    /**
     * Creates a new NonRepeatableEntityException with the specified detail message.
     * 
     * @param message The exception detail message
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.936 -0500", hash_original_method = "4B87CBDD18691A2F7063A9BFE6EBFE62", hash_generated_method = "F45DEE8C578CC0C333B599092F37CC4F")
    
public NonRepeatableRequestException(String message) {
        super(message);
    }
}

