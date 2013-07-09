package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FileHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.734 -0400", hash_original_method = "6784E94C0D30F3330B20FF566B070BF0", hash_generated_method = "6784E94C0D30F3330B20FF566B070BF0")
    public FileHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.735 -0400", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "F0546E94D721ADC1F7C9BDEE72D95AC4")
    @Override
    public URLConnection openConnection(URL url) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_806954959 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_806954959 = openConnection(url, null);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_806954959.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_806954959;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.735 -0400", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "8A5E3CFEA1DB9853485C98BA78F2CDCC")
    @Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_373331398 = null; 
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_969208466 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null");
        } 
        String host = url.getHost();
        {
            boolean var58FB74E7C7902299B2BF0C1488A5F499_1730985916 = (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_373331398 = new FileURLConnection(url);
            } 
        } 
        URL ftpURL = new URL("ftp", host, url.getFile());
        varB4EAC82CA7396A68D541C85D26508E83_969208466 = (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        URLConnection varA7E53CE21691AB073D9660D615818899_2011031290; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2011031290 = varB4EAC82CA7396A68D541C85D26508E83_373331398;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2011031290 = varB4EAC82CA7396A68D541C85D26508E83_969208466;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2011031290.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2011031290;
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.736 -0400", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "27F9C1FA91C4CBFBDEFA7A07001F56F9")
    @Override
    protected void parseURL(URL url, String spec, int start, int end) {
        String parseString = "";
        {
            parseString = spec.substring(start, end).replace('\\', '/');
        } 
        super.parseURL(url, parseString, 0, parseString.length());
        addTaint(url.getTaint());
        addTaint(spec.getTaint());
        addTaint(start);
        addTaint(end);
        
        
            
        
        
        
            
        
        
    }

    
}

