package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class ShortBufferException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.250 -0400", hash_original_method = "B367994EA3C91134C8AE078ED740A290", hash_generated_method = "923FC6F005F9993CF73822E290DD331A")
    public  ShortBufferException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.250 -0400", hash_original_method = "05E1544DF68BDE9AA8F5198F627D7727", hash_generated_method = "83333DD006AC3C65758F9A113F150A4A")
    public  ShortBufferException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.250 -0400", hash_original_field = "11816BF6CF73D5589323EC2E45E610C5", hash_generated_field = "9FF5FB340DBCE0D919FDCD655D9CE10C")

    private static long serialVersionUID = 8427718640832943747L;
}

