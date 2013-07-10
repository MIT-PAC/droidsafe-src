package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.*;
import javax.sip.header.*;

public class SIPDateHeader extends SIPHeader implements DateHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.272 -0400", hash_original_field = "5FC732311905CB27E82D67F4F6511F7F", hash_generated_field = "E6B895F7293606CA8C9A3D5102653BE1")

    protected SIPDate date;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.272 -0400", hash_original_method = "1EECE0587E859340DA3FB0354A4B8225", hash_generated_method = "82F22B1EC104F5553333AC52A87327F2")
    public  SIPDateHeader() {
        super(DATE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.273 -0400", hash_original_method = "C034912C24C8AA492A55E1DAB6749820", hash_generated_method = "9445A49038F48D6FDCCBB29AD24A3EEB")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_447870795 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_447870795 = date.encode();
        varB4EAC82CA7396A68D541C85D26508E83_447870795.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_447870795;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.273 -0400", hash_original_method = "6C9EAA9AEBF2DE9AF857C9766729F95B", hash_generated_method = "79D01558A8C4EA0E589F8A4773D04A84")
    public void setDate(SIPDate d) {
        date = d;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.274 -0400", hash_original_method = "593883A7F1E198F7FABAA636FE37D3D4", hash_generated_method = "E27CE2D49553237C3437214A4BA4B89B")
    public void setDate(Calendar dat) {
        date = new SIPDate(dat.getTime().getTime());
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.274 -0400", hash_original_method = "8348440FA7E2BF46CE5F14E959934430", hash_generated_method = "4BD9B68C806FA874D14CB8CC5A5FAB6C")
    public Calendar getDate() {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_1062161483 = null; 
        Calendar varB4EAC82CA7396A68D541C85D26508E83_1463533822 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1062161483 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1463533822 = date.getJavaCal();
        Calendar varA7E53CE21691AB073D9660D615818899_1850905593; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1850905593 = varB4EAC82CA7396A68D541C85D26508E83_1062161483;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1850905593 = varB4EAC82CA7396A68D541C85D26508E83_1463533822;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1850905593.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1850905593;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.275 -0400", hash_original_method = "D8FA67BA672B59A2560C827929374032", hash_generated_method = "0CA453662003FC661D77F89996374D47")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1036004249 = null; 
        SIPDateHeader retval = (SIPDateHeader) super.clone();
        retval.date = (SIPDate) this.date.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1036004249 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1036004249.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1036004249;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.275 -0400", hash_original_field = "1A67EF30C59B59085B13D3BAF5F6DFA1", hash_generated_field = "FB9F215913247CD3C2C1FF9CAC7EC54C")

    private static final long serialVersionUID = 1734186339037274664L;
}

