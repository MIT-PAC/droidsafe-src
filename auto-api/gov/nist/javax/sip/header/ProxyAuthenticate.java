package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.address.URI;
import javax.sip.header.*;

public class ProxyAuthenticate extends AuthenticationHeader implements ProxyAuthenticateHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.076 -0400", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "97DB8173897D34702A0D76F3A00F4117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.076 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "C44C6971347EA1017E6F63E7FB0A9A21")
    @DSModeled(DSC.SAFE)
    public URI getURI() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.076 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "9DEBA0A7D17C5AFCE62A1F81A9DD3720")
    @DSModeled(DSC.SAFE)
    public void setURI(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 3826145955463251116L;
}

