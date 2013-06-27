package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.257 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.258 -0400", hash_original_method = "8848C9C8ECB0CA0AB2FE0EC7BB14F901", hash_generated_method = "0F5A98184A067094E1008BF346904948")
      DERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.259 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "25E441D222816065A1889D1683001517")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_40663265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_40663265 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_40663265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_40663265;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.259 -0400", hash_original_method = "6CB3748BA1DF3221B502A0BCD2F9C771", hash_generated_method = "7354E23300CABB5A3789B460908AC814")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1571048437 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1571048437 = new DERSequence(_parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_1571048437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1571048437;
        // ---------- Original Method ----------
        //return new DERSequence(_parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.260 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "FE928E88A4C35C34C2660486FBC073FB")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1530065090 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1530065090 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.getMessage());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1530065090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530065090;
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

