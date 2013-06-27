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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.873 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.874 -0400", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "D0CEB2B3AD1C579896D18B795405F0C8")
      BEROctetStringParser(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.874 -0400", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "38BEAA9B31859FC2B0F0731F763F80EC")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1739158428 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1739158428 = new ConstructedOctetStream(_parser);
        varB4EAC82CA7396A68D541C85D26508E83_1739158428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1739158428;
        // ---------- Original Method ----------
        //return new ConstructedOctetStream(_parser);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.883 -0400", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "FA0B92D5807D12D116B8662EC589B276")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1961231944 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1961231944 = new BERConstructedOctetString(Streams.readAll(getOctetStream()));
        varB4EAC82CA7396A68D541C85D26508E83_1961231944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1961231944;
        // ---------- Original Method ----------
        //return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.883 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "25E559F129258E9EC663C5948C2F618B")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_112293230 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_112293230 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_112293230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112293230;
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

