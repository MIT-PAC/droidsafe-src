package java.net;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class PortUnreachableException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.278 -0400", hash_original_method = "A9512F39350C94C0C69735359EF3AADA", hash_generated_method = "833DA25EB598A13A50D06C4855FB8EF4")
    public  PortUnreachableException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.280 -0400", hash_original_method = "5D984FCFBC4DFCA56D23D59535D24C8C", hash_generated_method = "0F6D5D7C455854373B8D928BD38623F2")
    public  PortUnreachableException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.281 -0400", hash_original_method = "3045F383C8CE75FC18DF1FE38D9A0FBC", hash_generated_method = "4292B25864E56DF091B40D51645DFA7E")
    public  PortUnreachableException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.282 -0400", hash_original_field = "A12136CD914F7387B4C4F28A7380C3E3", hash_generated_field = "A4906FF1C1D822B7B0B02A02F86BC3CB")

    private static final long serialVersionUID = 8462541992376507323L;
}

