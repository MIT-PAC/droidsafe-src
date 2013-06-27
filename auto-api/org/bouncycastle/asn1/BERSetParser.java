package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class BERSetParser implements ASN1SetParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.897 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.897 -0400", hash_original_method = "EF8530238239035799CD0A162B856113", hash_generated_method = "3CBB13114A6B7C956C1CC85AC277075B")
      BERSetParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.898 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "FC88CCE117073585A85DE0F612ED6FC1")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1142334240 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142334240 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1142334240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142334240;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.911 -0400", hash_original_method = "1B045C000E117296EF92C9846060EDEF", hash_generated_method = "DD116D55AAC18DE2EAD304EBA0908B4D")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1849677250 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1849677250 = new BERSet(_parser.readVector(), false);
        varB4EAC82CA7396A68D541C85D26508E83_1849677250.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1849677250;
        // ---------- Original Method ----------
        //return new BERSet(_parser.readVector(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.912 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "ABBEFAB8995DFA5DE0DFF32C0103434B")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_333176275 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_333176275 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_333176275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_333176275;
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

