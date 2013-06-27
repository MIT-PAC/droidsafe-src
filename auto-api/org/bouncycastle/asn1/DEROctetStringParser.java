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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.071 -0400", hash_original_field = "F7B44CFAFD5C52223D5498196C8A2E7B", hash_generated_field = "B52609448A7FFECE6579BC5E2EF825EF")

    private DefiniteLengthInputStream stream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.072 -0400", hash_original_method = "18F90E7C8910F20983A0E830634FAC28", hash_generated_method = "9D5CE2CB595BD9C55B8D972104EAB19F")
      DEROctetStringParser(
        DefiniteLengthInputStream stream) {
        this.stream = stream;
        // ---------- Original Method ----------
        //this.stream = stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.072 -0400", hash_original_method = "18DABC7937263BD98D8856E466803052", hash_generated_method = "A81D40F3C258DB657618351A75AD829F")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1283465822 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1283465822 = stream;
        varB4EAC82CA7396A68D541C85D26508E83_1283465822.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1283465822;
        // ---------- Original Method ----------
        //return stream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.076 -0400", hash_original_method = "61774CD0E60B254BC7D8FDAA497BBCE4", hash_generated_method = "FEECB2E368CCEB217CA71E595BC96080")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1075052236 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1075052236 = new DEROctetString(stream.toByteArray());
        varB4EAC82CA7396A68D541C85D26508E83_1075052236.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1075052236;
        // ---------- Original Method ----------
        //return new DEROctetString(stream.toByteArray());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.088 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "CE6A8925FD85701DF3509123C5715269")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1958612568 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1958612568 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1958612568.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1958612568;
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

