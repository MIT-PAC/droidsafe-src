package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.ims.WWWAuthenticateHeaderIms;
import javax.sip.address.URI;
import javax.sip.header.*;

public class WWWAuthenticate extends AuthenticationHeader implements WWWAuthenticateHeader, WWWAuthenticateHeaderIms {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.484 -0400", hash_original_method = "C9FB367FC796E0822ABA8EEBFAE5F2CF", hash_generated_method = "D5FB95D4E398FA874E7C2C8799EFCDB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WWWAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.484 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "C44C6971347EA1017E6F63E7FB0A9A21")
    @DSModeled(DSC.SAFE)
    public URI getURI() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.484 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "9DEBA0A7D17C5AFCE62A1F81A9DD3720")
    @DSModeled(DSC.SAFE)
    public void setURI(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 115378648697363486L;
}

