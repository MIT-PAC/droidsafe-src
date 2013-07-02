package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.ims.WWWAuthenticateHeaderIms;
import javax.sip.address.URI;
import javax.sip.header.*;

public class WWWAuthenticate extends AuthenticationHeader implements WWWAuthenticateHeader, WWWAuthenticateHeaderIms {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.960 -0400", hash_original_method = "C9FB367FC796E0822ABA8EEBFAE5F2CF", hash_generated_method = "D5FB95D4E398FA874E7C2C8799EFCDB6")
    public  WWWAuthenticate() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.961 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "A52DC71B4559BDF9A6772678214F900A")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_2104278090 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2104278090 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2104278090.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2104278090;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.961 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.961 -0400", hash_original_field = "9144D43B36A4813BC6116E6DA4A3CB4A", hash_generated_field = "DB4C47D141CA98A5189ECDA08C3E0BC7")

    private static final long serialVersionUID = 115378648697363486L;
}

