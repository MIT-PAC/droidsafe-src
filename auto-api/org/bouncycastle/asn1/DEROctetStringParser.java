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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.622 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.623 -0400", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "9D5CE2CB595BD9C55B8D972104EAB19F")
      DEROctetStringParser(
        DefiniteLengthInputStream stream) {
        this.stream = stream;
        // ---------- Original Method ----------
        //this.stream = stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.623 -0400", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "AE2A9848D1B9B552DFB5159F351E6D87")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_434998445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_434998445 = stream;
        varB4EAC82CA7396A68D541C85D26508E83_434998445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434998445;
        // ---------- Original Method ----------
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.624 -0400", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "78AB5D8980F14555B323D31ADFC0D274")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2097103004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2097103004 = new DEROctetString(stream.toByteArray());
        varB4EAC82CA7396A68D541C85D26508E83_2097103004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097103004;
        // ---------- Original Method ----------
        //return new DEROctetString(stream.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.624 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "15940F8860211603D78CC5DA1D3BA8D6")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1206563830 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1206563830 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1206563830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206563830;
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

