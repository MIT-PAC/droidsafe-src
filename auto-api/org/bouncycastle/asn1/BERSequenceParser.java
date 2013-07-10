package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class BERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.154 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.155 -0400", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "C654E682B02E53A6F891C99264E7B745")
      BERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.155 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "760063CA828CE5FC40EF6100E2384375")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_290520566 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_290520566 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_290520566.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_290520566;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.155 -0400", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "D4C323955EBB572E9CFE733C16708C94")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_796374645 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_796374645 = new BERSequence(_parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_796374645.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_796374645;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.156 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "ABBF930291686CA801407F24BF053EB7")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_699079306 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_699079306 = getLoadedObject();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.getMessage());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_699079306.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_699079306;
        
        
        
            
        
        
        
            
        
    }

    
}

