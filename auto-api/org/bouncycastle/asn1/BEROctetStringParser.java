package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class BEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.125 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.126 -0400", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "D0CEB2B3AD1C579896D18B795405F0C8")
      BEROctetStringParser(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.126 -0400", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "70A638B3A56E27B32619ED0233D6D98C")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_275504075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_275504075 = new ConstructedOctetStream(_parser);
        varB4EAC82CA7396A68D541C85D26508E83_275504075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275504075;
        // ---------- Original Method ----------
        //return new ConstructedOctetStream(_parser);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.127 -0400", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "BAE8F98127F8505BC0158BD5C76FD0FD")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_306432594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_306432594 = new BERConstructedOctetString(Streams.readAll(getOctetStream()));
        varB4EAC82CA7396A68D541C85D26508E83_306432594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_306432594;
        // ---------- Original Method ----------
        //return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.127 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "11B60792EECC7ABCEE630E2CD49A4D21")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1675867289 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1675867289 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1675867289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1675867289;
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

