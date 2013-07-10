package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;

public class LazyDERSequence extends DERSequence {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.887 -0400", hash_original_field = "4B719ACEE4A1D5E30577F59E80D06205", hash_generated_field = "ED95B2E967E3B561D98D41FC80663441")

    private byte[] encoded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.887 -0400", hash_original_field = "0E27CA10ED218E22AD1B0B35F24A7764", hash_generated_field = "8C5EC66D29868A1962676316469FC881")

    private boolean parsed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.887 -0400", hash_original_field = "304D03889695AEE9913D341019E1E376", hash_generated_field = "10F76FD865BC4D8F6F2C3440897633F6")

    private int size = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.888 -0400", hash_original_method = "774E91359D875B822740E8694BBD0378", hash_generated_method = "F13296280E5E5D813549095EB53048EE")
      LazyDERSequence(
        byte[] encoded) throws IOException {
        this.encoded = encoded;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.888 -0400", hash_original_method = "F52BE1D6A2A2A6E978CE6B87E0C287FA", hash_generated_method = "13DF649BB38DF0B06745A8F196B26D91")
    private void parse() {
        Enumeration en = new LazyDERConstructionEnumeration(encoded);
        {
            boolean varB188EF125CE599069C2B3F78653D629C_1171728453 = (en.hasMoreElements());
            {
                addObject((DEREncodable)en.nextElement());
            } 
        } 
        parsed = true;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.889 -0400", hash_original_method = "D55432484A7204F62197A1C42F1222BB", hash_generated_method = "6DC260C6BEDE58B209CDE24197BD69ED")
    public synchronized DEREncodable getObjectAt(int index) {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1841347184 = null; 
        {
            parse();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1841347184 = super.getObjectAt(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1841347184.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1841347184;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.889 -0400", hash_original_method = "939539D3FCA2F2720237F25863622D9D", hash_generated_method = "AF08FABA26387515BA4C0E82E6B3E43C")
    public synchronized Enumeration getObjects() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1762479109 = null; 
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1041202027 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1762479109 = super.getObjects();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1041202027 = new LazyDERConstructionEnumeration(encoded);
        Enumeration varA7E53CE21691AB073D9660D615818899_1726710562; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1726710562 = varB4EAC82CA7396A68D541C85D26508E83_1762479109;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1726710562 = varB4EAC82CA7396A68D541C85D26508E83_1041202027;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1726710562.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1726710562;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.889 -0400", hash_original_method = "4DAF8F12C79E02A5B25C6CFF5DA9F3C5", hash_generated_method = "240401365FE05586DB5669ECA38434AE")
    public int size() {
        {
            Enumeration en = new LazyDERConstructionEnumeration(encoded);
            size = 0;
            {
                boolean var3500FA4D58FB8FB3E63D650C6AAEA7F5_955015270 = (en.hasMoreElements());
                {
                    en.nextElement();
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128554633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128554633;
        
        
        
            
            
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.890 -0400", hash_original_method = "46D9E51ED6BB4A9637D586153D86E513", hash_generated_method = "C2129C70203253B927C3BD855D6170C5")
     void encode(
        DEROutputStream out) throws IOException {
        out.writeEncoded(SEQUENCE | CONSTRUCTED, encoded);
        addTaint(out.getTaint());
        
        
    }

    
}

