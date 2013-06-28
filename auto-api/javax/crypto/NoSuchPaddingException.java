package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class NoSuchPaddingException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.162 -0400", hash_original_method = "CC6456B5182239A839E31575FEF026A1", hash_generated_method = "4E7817D83D10A7B50450659AE3E32293")
    public  NoSuchPaddingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.162 -0400", hash_original_method = "5F9DD48C6EA25CAA15AA1C916D0EC0F1", hash_generated_method = "B8D5082D9F33AC5995CD41DEC14F9A50")
    public  NoSuchPaddingException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.163 -0400", hash_original_field = "5BB6037063024EBDC50B4094EE8DC183", hash_generated_field = "F7C5C54BD2F1DBD310D5E8F7775DD1AB")

    private static final long serialVersionUID = -4572885201200175466L;
}

