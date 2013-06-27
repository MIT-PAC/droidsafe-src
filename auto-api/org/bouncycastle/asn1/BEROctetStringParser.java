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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.800 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.801 -0400", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "D0CEB2B3AD1C579896D18B795405F0C8")
      BEROctetStringParser(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.801 -0400", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "458561756F53DB90A0B41714D87A9EBC")
    public InputStream getOctetStream() {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_646326331 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_646326331 = new ConstructedOctetStream(_parser);
        varB4EAC82CA7396A68D541C85D26508E83_646326331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_646326331;
        // ---------- Original Method ----------
        //return new ConstructedOctetStream(_parser);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.802 -0400", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "FD1FC6A7EB4F6B612B26D671DEF897A8")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1287101669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1287101669 = new BERConstructedOctetString(Streams.readAll(getOctetStream()));
        varB4EAC82CA7396A68D541C85D26508E83_1287101669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1287101669;
        // ---------- Original Method ----------
        //return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.803 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "D70C2EA38791C93355F63DBA1D8A2B79")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_942261797 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_942261797 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_942261797.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_942261797;
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

