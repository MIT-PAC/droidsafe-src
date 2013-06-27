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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.815 -0400", hash_original_method = "C9FB367FC796E0822ABA8EEBFAE5F2CF", hash_generated_method = "D5FB95D4E398FA874E7C2C8799EFCDB6")
    public  WWWAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.816 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "E856953CFC5E0C5C23A0E6999FEA1544")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_479258569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_479258569 = null;
        varB4EAC82CA7396A68D541C85D26508E83_479258569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_479258569;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.816 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.816 -0400", hash_original_field = "9144D43B36A4813BC6116E6DA4A3CB4A", hash_generated_field = "31DE34230B90743CADCCF8AAE3955BA6")

    private static long serialVersionUID = 115378648697363486L;
}

