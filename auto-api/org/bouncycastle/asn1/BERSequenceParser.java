package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class BERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.900 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.901 -0400", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "C654E682B02E53A6F891C99264E7B745")
      BERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.902 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "AF0FF5A473490D50480DADD98F4CF9B1")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_843672541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_843672541 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_843672541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843672541;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.902 -0400", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "31E6D8AE123CCD16E40AB4E367D64834")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_614364137 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_614364137 = new BERSequence(_parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_614364137.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614364137;
        // ---------- Original Method ----------
        //return new BERSequence(_parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.913 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "1F04AED52B05C1CD9FD20A2BFA9B3D35")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1462002740 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1462002740 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.getMessage());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1462002740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462002740;
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new IllegalStateException(e.getMessage());
        //}
    }

    
}

