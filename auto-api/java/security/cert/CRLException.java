package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;

public class CRLException extends GeneralSecurityException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.683 -0400", hash_original_method = "60672CA36668A1D34242C570333ABE8C", hash_generated_method = "ECEE49851A4FE85A41C20EF996B73932")
    public  CRLException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.684 -0400", hash_original_method = "5E03B595357100C7FE02CA0C3CD0CBF1", hash_generated_method = "07FD205AE337C0D605903EA8F88E0A30")
    public  CRLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.684 -0400", hash_original_method = "529EF340AA7D68AE4AFE9D9F624919F8", hash_generated_method = "D9A83E42C6AFCFC276AB02514F8D00A7")
    public  CRLException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.684 -0400", hash_original_method = "DFA7CB52116B1FBFC93D3E254D1E3FDD", hash_generated_method = "8A8D8F44AB3346274B212345199549DE")
    public  CRLException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:46.684 -0400", hash_original_field = "B12068406B1F93CCA5EC32A74AF07D00", hash_generated_field = "3508FE592D791297118F25C3B0F218A3")

    private static long serialVersionUID = -6694728944094197147L;
}

