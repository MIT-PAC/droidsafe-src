package org.apache.http.cookie;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Locale;

public final class CookieOrigin {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.508 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.508 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.508 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.508 -0400", hash_original_field = "1C0B76FCE779F78F51BE339C49445C49", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.509 -0400", hash_original_method = "FC001BCC5683C2BE05FA1882BEE28B67", hash_generated_method = "EEAEAE55717BA34238352D89BACDE1FA")
    public  CookieOrigin(final String host, int port, final String path, boolean secure) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Host of origin may not be null");
        } 
        {
            boolean var38D5D932AA4F9C313FE6D4227A1EDA26_821235923 = (host.trim().length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Host of origin may not be blank");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid port: " + port);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Path of origin may not be null.");
        } 
        this.host = host.toLowerCase(Locale.ENGLISH);
        this.port = port;
        {
            boolean var18EA4D7CF05FC60A9FE5C172FC0380F5_1747997213 = (path.trim().length() != 0);
            {
                this.path = path;
            } 
            {
                this.path = "/";
            } 
        } 
        this.secure = secure;
        
        
            
                    
        
        
            
                    
        
        
            
        
        
            
                    
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.510 -0400", hash_original_method = "052AA62CF2AFB76178CB036EF4B7BAB4", hash_generated_method = "B89FF9B81446B7DB8325C12268E3465F")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_133494978 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_133494978 = this.host;
        varB4EAC82CA7396A68D541C85D26508E83_133494978.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_133494978;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.510 -0400", hash_original_method = "1447F7E138124D077576DF2B2413D348", hash_generated_method = "3433EBE88FF5A59B21EBDCDA735744AF")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1119133560 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1119133560 = this.path;
        varB4EAC82CA7396A68D541C85D26508E83_1119133560.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1119133560;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.510 -0400", hash_original_method = "1804D4B8ED6914D43C8BF926A65BA4F9", hash_generated_method = "70215788FE58D7D50BF75795F42E4154")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313733232 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313733232;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.511 -0400", hash_original_method = "F448B780707B5356535204966A8ECD14", hash_generated_method = "A3DFB6A777A55C6D0A1760C8E9273484")
    public boolean isSecure() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362776238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_362776238;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.511 -0400", hash_original_method = "04B66E71C7D8EF5D2D79480EE2BA7CE8", hash_generated_method = "B93638A3295F5D92ACB56797C234E3FE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_360534532 = null; 
        StringBuilder buffer = new StringBuilder();
        buffer.append('[');
        {
            buffer.append("(secure)");
        } 
        buffer.append(this.host);
        buffer.append(':');
        buffer.append(Integer.toString(this.port));
        buffer.append(this.path);
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_360534532 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_360534532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_360534532;
        
        
        
        
            
        
        
        
        
        
        
        
    }

    
}

