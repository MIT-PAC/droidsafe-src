package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class DateParseException extends Exception {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.814 -0400", hash_original_method = "0DFD241FD26282310774337DBB864354", hash_generated_method = "46CBFA588965752E74CF7AC631DE7478")
    public  DateParseException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.814 -0400", hash_original_method = "53C5731479F0FA5FDE74FB1046876E6C", hash_generated_method = "335F377DD9E363064EDB0665BD0B0ED4")
    public  DateParseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.815 -0400", hash_original_field = "277883C1114430472BF2C0AD9B0EB862", hash_generated_field = "C87C16CCA5CA74DC00990FE42921A886")

    private static final long serialVersionUID = 4417696455000643370L;
}

