package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;



public class NoSuchProviderException extends GeneralSecurityException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.112 -0400", hash_original_method = "3C5B15FD24DC972B9113D489948D5082", hash_generated_method = "37593C1A4207E041B2587D3F15BD57BB")
    public  NoSuchProviderException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.113 -0400", hash_original_method = "1FDB64EF55F9EB878F5C396A65C339B8", hash_generated_method = "5A5F1EF7E3BC459EED9DE2EE9A1DDE35")
    public  NoSuchProviderException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.113 -0400", hash_original_field = "190D8C747A23D7E82ABCFE5899AE3331", hash_generated_field = "41B196F33547FACADC7087FC11AAB4CB")

    private static final long serialVersionUID = 8488111756688534474L;
}

