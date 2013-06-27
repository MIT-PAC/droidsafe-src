package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FileHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.796 -0400", hash_original_method = "6784E94C0D30F3330B20FF566B070BF0", hash_generated_method = "6784E94C0D30F3330B20FF566B070BF0")
    public FileHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.797 -0400", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "4246E8A6B97A3245119F17076A03D13D")
    @Override
    public URLConnection openConnection(URL url) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1654686831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1654686831 = openConnection(url, null);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1654686831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1654686831;
        // ---------- Original Method ----------
        //return openConnection(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.814 -0400", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "8A24540A1EF1C1C2F7F99644650241EC")
    @Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_680293067 = null; //Variable for return #1
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_919830932 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null");
        } //End block
        String host;
        host = url.getHost();
        {
            boolean var58FB74E7C7902299B2BF0C1488A5F499_781269481 = (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_680293067 = new FileURLConnection(url);
            } //End block
        } //End collapsed parenthetic
        URL ftpURL;
        ftpURL = new URL("ftp", host, url.getFile());
        varB4EAC82CA7396A68D541C85D26508E83_919830932 = (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
        addTaint(url.getTaint());
        addTaint(proxy.getTaint());
        URLConnection varA7E53CE21691AB073D9660D615818899_1142360350; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1142360350 = varB4EAC82CA7396A68D541C85D26508E83_680293067;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1142360350 = varB4EAC82CA7396A68D541C85D26508E83_919830932;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1142360350.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1142360350;
        // ---------- Original Method ----------
        //if (url == null) {
            //throw new IllegalArgumentException("url == null");
        //}
        //String host = url.getHost();
        //if (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost")) {
            //return new FileURLConnection(url);
        //}
        //URL ftpURL = new URL("ftp", host, url.getFile());
        //return (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.815 -0400", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "9D6D115B93D16B055EB06DC793260A86")
    @Override
    protected void parseURL(URL url, String spec, int start, int end) {
        String parseString;
        parseString = "";
        {
            parseString = spec.substring(start, end).replace('\\', '/');
        } //End block
        super.parseURL(url, parseString, 0, parseString.length());
        addTaint(url.getTaint());
        addTaint(spec.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (end < start) {
            //return;
        //}
        //String parseString = "";
        //if (start < end) {
            //parseString = spec.substring(start, end).replace('\\', '/');
        //}
        //super.parseURL(url, parseString, 0, parseString.length());
    }

    
}

