package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.address.URI;
import javax.sip.header.*;

public class ProxyAuthenticate extends AuthenticationHeader implements ProxyAuthenticateHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.917 -0400", hash_original_method = "B80D256AA9E947492E2C0A1F4B8ED695", hash_generated_method = "97DB8173897D34702A0D76F3A00F4117")
    public  ProxyAuthenticate() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.918 -0400", hash_original_method = "415F36F94D5D5AF0B0B417563353646C", hash_generated_method = "9B2B20708278F982FCC58804583E24EC")
    public URI getURI() {
        URI varB4EAC82CA7396A68D541C85D26508E83_591851341 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_591851341 = null;
        varB4EAC82CA7396A68D541C85D26508E83_591851341.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_591851341;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.918 -0400", hash_original_method = "4B2EBAFE6DAB8E15456CC1135D4262EB", hash_generated_method = "EFB37CFD85A05AB0A4932DBCB802E4F4")
    public void setURI(URI uri) {
        addTaint(uri.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.918 -0400", hash_original_field = "668B5B019FE711679039DB48F6C9A48A", hash_generated_field = "08ABAB95072FCF7B3E4A2200DCD67ACD")

    private static final long serialVersionUID = 3826145955463251116L;
}

