package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class SocketException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.511 -0400", hash_original_method = "6370438F3E8FDAC390DBF5D95BB547E6", hash_generated_method = "16218E158583D4A8A5981F4E73EFCDEB")
    public  SocketException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.512 -0400", hash_original_method = "1136B1CF147D460660A0A79DDF1D5C0A", hash_generated_method = "DDE67733509D1360C97AF4D957306CA5")
    public  SocketException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.512 -0400", hash_original_method = "001E874571014D08FBFC41C7A23D02C6", hash_generated_method = "DE0A9D899FEC1F14602A6840D8DD9661")
    public  SocketException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.512 -0400", hash_original_method = "1ACC59770DF5E02FD5C6C8AE56F288AE", hash_generated_method = "91816ADDDBE039F2CBDBF57FB638A916")
    public  SocketException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.512 -0400", hash_original_field = "94B8E3B7316984B68B929FD795C024C5", hash_generated_field = "BE1537516AB0F006A5D38D1DF948ECB9")

    private static final long serialVersionUID = -5935874303556886934L;
}

