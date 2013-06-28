package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyAuthorization extends AuthenticationHeader implements ProxyAuthorizationHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.931 -0400", hash_original_method = "4D6EF56A1C3453732D0F9A353B9A4089", hash_generated_method = "EAFE69677E4CD29F6950DC57C40DD2A6")
    public  ProxyAuthorization() {
        super(PROXY_AUTHORIZATION);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.931 -0400", hash_original_field = "A89D3C1F1A5CB108F36FBBF59CFFEEAA", hash_generated_field = "BA6BF9CE8BFECE5A05580B2B32C52A19")

    private static final long serialVersionUID = -6374966905199799098L;
}

