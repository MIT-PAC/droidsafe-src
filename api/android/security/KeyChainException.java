package android.security;

// Droidsafe Imports
import droidsafe.annotations.*;


public class KeyChainException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.064 -0400", hash_original_method = "07A073FF0F51A72901A8B28E6AC903AE", hash_generated_method = "23E3F1B8D4BA1176F337353CEEB0458D")
    public  KeyChainException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.065 -0400", hash_original_method = "0A58DB61FCFCEABE9058FC3092E58BF3", hash_generated_method = "44A8C69696CDC558A95F9EFE54E392EE")
    public  KeyChainException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.066 -0400", hash_original_method = "3E8EDDC6FC8719784A3F6D961EFA0DBF", hash_generated_method = "9A0F3A7C9FA8E815D2B6125688248C58")
    public  KeyChainException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.066 -0400", hash_original_method = "8CC23A5EEF616E11C5C7CDC0612B705F", hash_generated_method = "ECEDA574E6A3ECB23575DB9CD1F202E5")
    public  KeyChainException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

