package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolException;

public class NonRepeatableRequestException extends ProtocolException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.719 -0400", hash_original_method = "14DECFA9FD444F48F1267DE5834D3279", hash_generated_method = "4508DC95E498ADBE80B4E49F391FDFA0")
    public  NonRepeatableRequestException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.719 -0400", hash_original_method = "4B87CBDD18691A2F7063A9BFE6EBFE62", hash_generated_method = "CE5DF3FDD87E08FE883176C2ECCDCABC")
    public  NonRepeatableRequestException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.719 -0400", hash_original_field = "08871C21719A2A068B1F0EA6FEDB39BA", hash_generated_field = "CBAF5D482FD12BECD83779ACC6D0F5A0")

    private static final long serialVersionUID = 82685265288806048L;
}

