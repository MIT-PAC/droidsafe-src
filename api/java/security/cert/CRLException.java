package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;




public class CRLException extends GeneralSecurityException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.598 -0400", hash_original_method = "60672CA36668A1D34242C570333ABE8C", hash_generated_method = "ECEE49851A4FE85A41C20EF996B73932")
    public  CRLException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.598 -0400", hash_original_method = "5E03B595357100C7FE02CA0C3CD0CBF1", hash_generated_method = "07FD205AE337C0D605903EA8F88E0A30")
    public  CRLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.599 -0400", hash_original_method = "529EF340AA7D68AE4AFE9D9F624919F8", hash_generated_method = "8121ED654826B3D2F3A638E9591473AE")
    public  CRLException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.599 -0400", hash_original_method = "DFA7CB52116B1FBFC93D3E254D1E3FDD", hash_generated_method = "8A8D8F44AB3346274B212345199549DE")
    public  CRLException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.599 -0400", hash_original_field = "B12068406B1F93CCA5EC32A74AF07D00", hash_generated_field = "D0A7C8EE3531577BE0E356C190759BFC")

    private static final long serialVersionUID = -6694728944094197147L;
}

