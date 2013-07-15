package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class DERExternalParser implements DEREncodable, InMemoryRepresentable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.400 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.400 -0400", hash_original_method = "57CF5022A9E21A477DCDCEAF7C51B0D4", hash_generated_method = "7EDCED9947F31976FEF2A31F5A0A78AE")
    public  DERExternalParser(ASN1StreamParser parser) {
        this._parser = parser;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.401 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "B76BB95072D5948D0C4E9B3FB9D80A2C")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_463972363 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_463972363 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_463972363.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_463972363;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.403 -0400", hash_original_method = "E08AB982B1429E7FF32DFAFFCE3445B5", hash_generated_method = "99AB5BCA2FE2B843C8BAC324DD9025EF")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1630693766 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1630693766 = new DERExternal(_parser.readVector());
        } 
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception(e.getMessage(), e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1630693766.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1630693766;
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.404 -0400", hash_original_method = "E8FC5EC09DAB37CBF457EC44DD373FAE", hash_generated_method = "4979ECFD5D329B37B05FE6754B5D6B77")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_846462516 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_846462516 = getLoadedObject();
        } 
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("unable to get DER object", ioe);
        } 
        catch (IllegalArgumentException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("unable to get DER object", ioe);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_846462516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_846462516;
        
        
        
            
        
        
        
            
        
        
        
            
        
    }

    
}

