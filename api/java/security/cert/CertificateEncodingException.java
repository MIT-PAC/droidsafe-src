package java.security.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class CertificateEncodingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.614 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "9AF12C7C6EFC4619DBB2BD1EE3112CE5")
    public  CertificateEncodingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.614 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C2D35BC07014BC3018532FA9B69AF7DE")
    public  CertificateEncodingException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.614 -0400", hash_original_method = "E243161DE39D22E4790DBE91A7D0CBA3", hash_generated_method = "687FB782969E389F6B0EE746BDD3B673")
    public  CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.615 -0400", hash_original_method = "A32D2B579DCEB6262CC5C2D0257C91FD", hash_generated_method = "FD7FB8602AB4B9B3545A4CE0F11FB9B6")
    public  CertificateEncodingException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.615 -0400", hash_original_field = "B846568D7F1C86CA2EEF25853C392457", hash_generated_field = "283D9FEE55079801531E0A45A4848707")

    private static final long serialVersionUID = 6219492851589449162L;
}

