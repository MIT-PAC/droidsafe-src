package org.apache.http.impl.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;

public class BestMatchSpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.017 -0400", hash_original_method = "17A5B3D05891EED9B20E49D2F5F89B97", hash_generated_method = "17A5B3D05891EED9B20E49D2F5F89B97")
    public BestMatchSpecFactory ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.017 -0400", hash_original_method = "2201EB1DC86453D4D2DD6749773278D9", hash_generated_method = "0024252A096D690AC4E0D38B66891179")
    public CookieSpec newInstance(final HttpParams params) {
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_2001210399 = null; 
        CookieSpec varB4EAC82CA7396A68D541C85D26508E83_1703456814 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2001210399 = new BestMatchSpec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1703456814 = new BestMatchSpec();
        } 
        addTaint(params.getTaint());
        CookieSpec varA7E53CE21691AB073D9660D615818899_838851417; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_838851417 = varB4EAC82CA7396A68D541C85D26508E83_2001210399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_838851417 = varB4EAC82CA7396A68D541C85D26508E83_1703456814;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_838851417.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_838851417;
        
        
            
                    
                    
        
            
        
    }

    
}

