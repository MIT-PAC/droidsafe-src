package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PortUnreachableException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.641 -0400", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "833DA25EB598A13A50D06C4855FB8EF4")
    public  PortUnreachableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.641 -0400", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "0F6D5D7C455854373B8D928BD38623F2")
    public  PortUnreachableException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.641 -0400", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "263BA3768D69A249DF57033DB0058818")
    public  PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.641 -0400", hash_original_field = "A12136CD914F7387B4C4F28A7380C3E3", hash_generated_field = "A4906FF1C1D822B7B0B02A02F86BC3CB")

    private static final long serialVersionUID = 8462541992376507323L;
}

