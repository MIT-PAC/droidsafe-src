package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.address.URI;
import javax.sip.header.ProxyAuthenticateHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ProxyAuthenticate extends AuthenticationHeader implements ProxyAuthenticateHeader {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.743 -0400", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "97DB8173897D34702A0D76F3A00F4117")
    public  ProxyAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.743 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "08214E20273B5E4C672F541B445F92EE")
    public URI getURI() {
URI var540C13E9E156B687226421B24F2DF178_1229759784 =         null;
        var540C13E9E156B687226421B24F2DF178_1229759784.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1229759784;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.743 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.743 -0400", hash_original_field = "668B5B019FE711679039DB48F6C9A48A", hash_generated_field = "08ABAB95072FCF7B3E4A2200DCD67ACD")

    private static final long serialVersionUID = 3826145955463251116L;
}

