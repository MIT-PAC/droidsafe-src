package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERSetParser implements ASN1SetParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.281 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.281 -0400", hash_original_method = "B88708124CC7F2028794AA77B282A272", hash_generated_method = "7DBB78AD8D03A8F35D2F6A96F8A8766A")
      DERSetParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.282 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "321895680A652148F09AF04A6CBA950E")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_130551484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_130551484 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_130551484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130551484;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.282 -0400", hash_original_method = "F95A7EBB89400171F1F3290B60410A1D", hash_generated_method = "15298E8D69BEAC8888C1E42918061575")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1303160373 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1303160373 = new DERSet(_parser.readVector(), false);
        varB4EAC82CA7396A68D541C85D26508E83_1303160373.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1303160373;
        // ---------- Original Method ----------
        //return new DERSet(_parser.readVector(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.283 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "ED35CADE37DD8062CC9B93245EAB2C18")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2126817156 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2126817156 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2126817156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2126817156;
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException(e.getMessage(), e);
        //}
    }

    
}

