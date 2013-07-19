package gov.nist.javax.sip.header;

// Droidsafe Imports
import gov.nist.javax.sip.header.ims.WWWAuthenticateHeaderIms;

import javax.sip.address.URI;
import javax.sip.header.WWWAuthenticateHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class WWWAuthenticate extends AuthenticationHeader implements WWWAuthenticateHeader, WWWAuthenticateHeaderIms {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.740 -0400", hash_original_method = "C9FB367FC796E0822ABA8EEBFAE5F2CF", hash_generated_method = "D5FB95D4E398FA874E7C2C8799EFCDB6")
    public  WWWAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.741 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "D7A21B7A7B4C8CF8289281BB00192979")
    public URI getURI() {
URI var540C13E9E156B687226421B24F2DF178_2130335811 =         null;
        var540C13E9E156B687226421B24F2DF178_2130335811.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2130335811;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.741 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.741 -0400", hash_original_field = "9144D43B36A4813BC6116E6DA4A3CB4A", hash_generated_field = "DB4C47D141CA98A5189ECDA08C3E0BC7")

    private static final long serialVersionUID = 115378648697363486L;
}

