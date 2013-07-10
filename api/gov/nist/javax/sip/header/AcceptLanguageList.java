package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.header.*;

public class AcceptLanguageList extends SIPHeaderList<AcceptLanguage> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.835 -0400", hash_original_method = "240BB3B9B24C078BD16B4E527289E882", hash_generated_method = "11DB9C05848E7350775B5746176F17CF")
    public  AcceptLanguageList() {
        super(AcceptLanguage.class, AcceptLanguageHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.835 -0400", hash_original_method = "D59E3796661CC485086FCE096143E912", hash_generated_method = "9450EE83424D1517DC9C5E52B29C10A5")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_714673318 = null; 
        AcceptLanguageList retval = new AcceptLanguageList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_714673318 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_714673318.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_714673318;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.836 -0400", hash_original_method = "4EAA649C6A43B8603903A57164247286", hash_generated_method = "42145DA1276A926A47787A4211164668")
    public AcceptLanguage getFirst() {
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_910197985 = null; 
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_317330687 = null; 
        AcceptLanguage retval = (AcceptLanguage) super.getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_910197985 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_317330687 = new AcceptLanguage();
        AcceptLanguage varA7E53CE21691AB073D9660D615818899_429333918; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_429333918 = varB4EAC82CA7396A68D541C85D26508E83_910197985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_429333918 = varB4EAC82CA7396A68D541C85D26508E83_317330687;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_429333918.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_429333918;
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.836 -0400", hash_original_method = "D3074C13DEFE0D00E21551F82106E50D", hash_generated_method = "6EBFC1D5A283237FE9141ED518492330")
    public AcceptLanguage getLast() {
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_954742743 = null; 
        AcceptLanguage varB4EAC82CA7396A68D541C85D26508E83_2048869576 = null; 
        AcceptLanguage retval = (AcceptLanguage) super.getLast();
        varB4EAC82CA7396A68D541C85D26508E83_954742743 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2048869576 = new AcceptLanguage();
        AcceptLanguage varA7E53CE21691AB073D9660D615818899_1915165300; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1915165300 = varB4EAC82CA7396A68D541C85D26508E83_954742743;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1915165300 = varB4EAC82CA7396A68D541C85D26508E83_2048869576;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1915165300.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1915165300;
        
        
        
            
        
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.837 -0400", hash_original_field = "2DC0C9505B6601CC65D202A5B3F50DF0", hash_generated_field = "7EA90335ABAD53EEB534CFBDFF1F0433")

    private static final long serialVersionUID = -3289606805203488840L;
}

