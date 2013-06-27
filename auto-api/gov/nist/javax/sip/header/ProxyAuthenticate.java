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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.196 -0400", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "97DB8173897D34702A0D76F3A00F4117")
    public  ProxyAuthenticate() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.197 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "1A72FAC2DE56E2242F2EADFFAEDC7E8F")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_585173024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_585173024 = null;
        varB4EAC82CA7396A68D541C85D26508E83_585173024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585173024;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.197 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.197 -0400", hash_original_field = "668B5B019FE711679039DB48F6C9A48A", hash_generated_field = "E76AE14A82C76C591125EFC7F6D03EEA")

    private static long serialVersionUID = 3826145955463251116L;
}

