package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;




public class CertificateException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.722 -0400", hash_original_method = "B94F5C9247EB09D2A3B5F93CD6C3CCDF", hash_generated_method = "CA8DC42717F9257D4E33DE097DDBCEB4")
    public  CertificateException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.722 -0400", hash_original_method = "FF458EF7F95F357456B3AFD0871B002E", hash_generated_method = "A2AF1A669908D746BA2B02B73E8AC2C3")
    public  CertificateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.722 -0400", hash_original_method = "3E71F41626D2D81134C9C58E70BA9CC7", hash_generated_method = "B2E603AD116BB127821115629724D908")
    public  CertificateException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.722 -0400", hash_original_method = "E2FE45CCAA1ECBB72042149ECF15B312", hash_generated_method = "5E7EB8DD5D990BB5CAF5F8E63796DEC0")
    public  CertificateException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.723 -0400", hash_original_field = "9C9D7BBC19E3A8B91E389BEBA83D82D6", hash_generated_field = "EF8006469A2B3A811310EC8372238772")

    private static final long serialVersionUID = 3192535253797119798L;
}

