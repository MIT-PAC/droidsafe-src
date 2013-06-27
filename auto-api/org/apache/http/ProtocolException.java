package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ProtocolException extends HttpException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.634 -0400", hash_original_method = "CB5496AEB6C4A3E562F8F77722FABABF", hash_generated_method = "7F6827B044705C39557299953AEA8024")
    public  ProtocolException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.634 -0400", hash_original_method = "4EA2FDECEBB843A0FFF4778186BBC741", hash_generated_method = "9284E30E04008AE54E2F9FA9808BBC9E")
    public  ProtocolException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.635 -0400", hash_original_method = "3D82246BF1BA99079EA7B971F6EA0CE7", hash_generated_method = "14AC5DA4AF430450202070B3C2FC87AD")
    public  ProtocolException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.635 -0400", hash_original_field = "34C20F9BAEDB0CD35B470A84F6429C26", hash_generated_field = "D16CA07D777E817A87653E015E446B62")

    private static long serialVersionUID = -2143571074341228994L;
}

