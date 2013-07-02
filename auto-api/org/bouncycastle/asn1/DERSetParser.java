package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERSetParser implements ASN1SetParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.698 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.698 -0400", hash_original_method = "B88708124CC7F2028794AA77B282A272", hash_generated_method = "7DBB78AD8D03A8F35D2F6A96F8A8766A")
      DERSetParser(ASN1StreamParser parser) {
        this._parser = parser;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.699 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "C34A4985F9EABAAB5F046A65A2FB84C0")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1858644103 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1858644103 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1858644103.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1858644103;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.700 -0400", hash_original_method = "F95A7EBB89400171F1F3290B60410A1D", hash_generated_method = "4D612245ED5487082B1106F1A9BB7A4B")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_933981170 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_933981170 = new DERSet(_parser.readVector(), false);
        varB4EAC82CA7396A68D541C85D26508E83_933981170.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_933981170;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.700 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "B0B289A9F966D30B4496D2768A1E36C3")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_200928883 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_200928883 = getLoadedObject();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage(), e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_200928883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_200928883;
        
        
        
            
        
        
        
            
        
    }

    
}

