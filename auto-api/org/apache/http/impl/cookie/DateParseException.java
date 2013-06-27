package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DateParseException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.230 -0400", hash_original_method = "0DFD241FD26282310774337DBB864354", hash_generated_method = "46CBFA588965752E74CF7AC631DE7478")
    public  DateParseException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.230 -0400", hash_original_method = "53C5731479F0FA5FDE74FB1046876E6C", hash_generated_method = "335F377DD9E363064EDB0665BD0B0ED4")
    public  DateParseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.230 -0400", hash_original_field = "277883C1114430472BF2C0AD9B0EB862", hash_generated_field = "51503DCDC5F4141B9338ADF91E2432E3")

    private static long serialVersionUID = 4417696455000643370L;
}

