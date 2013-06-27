package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;

public class DEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.189 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.190 -0400", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "9D5CE2CB595BD9C55B8D972104EAB19F")
      DEROctetStringParser(
        DefiniteLengthInputStream stream) {
        this.stream = stream;
        // ---------- Original Method ----------
        //this.stream = stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.190 -0400", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "CBA423892DA80853D41D83B517F8584A")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_147585314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_147585314 = stream;
        varB4EAC82CA7396A68D541C85D26508E83_147585314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147585314;
        // ---------- Original Method ----------
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.198 -0400", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "CF2910A43826306E03AEEA28D56E1CEF")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1840229647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1840229647 = new DEROctetString(stream.toByteArray());
        varB4EAC82CA7396A68D541C85D26508E83_1840229647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1840229647;
        // ---------- Original Method ----------
        //return new DEROctetString(stream.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.199 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "38CBCB8912ABC1F9446AAB5A3F6F8F66")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1824761261 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1824761261 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1824761261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824761261;
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        //}
    }

    
}

