package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;



public class KeyException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.881 -0400", hash_original_method = "DF716A570A039E910D1B39CE7ED06D52", hash_generated_method = "0C4481BC34EF84589E3E6CBBA0125AC7")
    public  KeyException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.882 -0400", hash_original_method = "FF58C5A0C82C3954DB19F7723F0C2CA4", hash_generated_method = "974664EB1A4375B6CDF06EAAEE7EF681")
    public  KeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.882 -0400", hash_original_method = "93F87888548BE89CB4AA687EEDB8405D", hash_generated_method = "293E9BBAF08E07360AD40B5AEB4C138D")
    public  KeyException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.883 -0400", hash_original_method = "ED6FE96D5D1CB668863944D14AFF3EBE", hash_generated_method = "B61BDB6BD30DEED1E8037EFACDE6C4BD")
    public  KeyException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.883 -0400", hash_original_field = "ACFCA8838A3642C0C8A34B2202545F41", hash_generated_field = "BC3993799412C0E44E7504AF1A370A7B")

    private static final long serialVersionUID = -7483676942812432108L;
}

