package javax.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CertificateEncodingException extends CertificateException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.437 -0400", hash_original_method = "7001A7B06C3C6F6A9AA79A4DDBDE06C1", hash_generated_method = "9AF12C7C6EFC4619DBB2BD1EE3112CE5")
    public  CertificateEncodingException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.438 -0400", hash_original_method = "4937F69C7A48975DF1EBD7F32A366CEE", hash_generated_method = "C2D35BC07014BC3018532FA9B69AF7DE")
    public  CertificateEncodingException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.438 -0400", hash_original_field = "DEEB62DF1D87842C4CFD50EADC007C04", hash_generated_field = "7BDA9FDE04C036DCE71C6E8CECDE246D")

    private static long serialVersionUID = -8187642723048403470L;
}

