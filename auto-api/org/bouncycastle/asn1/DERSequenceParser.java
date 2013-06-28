package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.682 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.682 -0400", hash_original_method = "8848C9C8ECB0CA0AB2FE0EC7BB14F901", hash_generated_method = "0F5A98184A067094E1008BF346904948")
      DERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.683 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "80C11A5D0B23EF949E72148BFDC7FF9C")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1307994286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307994286 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1307994286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307994286;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.683 -0400", hash_original_method = "6CB3748BA1DF3221B502A0BCD2F9C771", hash_generated_method = "B165B1AA203C84C8D78EF2DE0C346B9A")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2134555902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2134555902 = new DERSequence(_parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_2134555902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2134555902;
        // ---------- Original Method ----------
        //return new DERSequence(_parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.684 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "03E5CB2EE4DDDBD492681038E8C93AC0")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_150606213 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_150606213 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.getMessage());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_150606213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_150606213;
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

