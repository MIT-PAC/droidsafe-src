package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchProviderException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.072 -0400", hash_original_method = "3C5B15FD24DC972B9113D489948D5082", hash_generated_method = "37593C1A4207E041B2587D3F15BD57BB")
    public  NoSuchProviderException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.072 -0400", hash_original_method = "1FDB64EF55F9EB878F5C396A65C339B8", hash_generated_method = "5A5F1EF7E3BC459EED9DE2EE9A1DDE35")
    public  NoSuchProviderException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.072 -0400", hash_original_field = "190D8C747A23D7E82ABCFE5899AE3331", hash_generated_field = "FDBEDACD92193935E5F651B68CC6D53D")

    private static long serialVersionUID = 8488111756688534474L;
}

