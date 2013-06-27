package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateEncodingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.751 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "9AF12C7C6EFC4619DBB2BD1EE3112CE5")
    public  CertificateEncodingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.751 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C2D35BC07014BC3018532FA9B69AF7DE")
    public  CertificateEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.753 -0400", hash_original_method = "E243161DE39D22E4790DBE91A7D0CBA3", hash_generated_method = "D9317498643A244499BEA0E98C40553D")
    public  CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.754 -0400", hash_original_method = "A32D2B579DCEB6262CC5C2D0257C91FD", hash_generated_method = "FD7FB8602AB4B9B3545A4CE0F11FB9B6")
    public  CertificateEncodingException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.754 -0400", hash_original_field = "B846568D7F1C86CA2EEF25853C392457", hash_generated_field = "22D9D1E2E071DAE30C7D3E4E0D77D589")

    private static long serialVersionUID = 6219492851589449162L;
}

