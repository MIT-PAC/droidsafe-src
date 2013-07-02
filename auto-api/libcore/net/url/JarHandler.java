package libcore.net.url;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.891 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.894 -0400", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "1F08495764047EE0CD4CE8973CB6B6CB")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1816153793 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1816153793 = new JarURLConnectionImpl(u);
        addTaint(u.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1816153793.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1816153793;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.897 -0400", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "D0B38D5B5EF3EB55353C3FEFEB8BB469")
    @Override
    protected void parseURL(URL url, String spec, int start, int limit) {
        String file = url.getFile();
        {
            file = "";
        } 
        {
            spec = spec.substring(start, limit);
        } 
        {
            spec = "";
        } 
        {
            boolean var3948E0BE2774036E4123DB53B312CCF1_688064122 = (spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1));
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Cannot find \"!/\"");
            } 
        } 
        {
            boolean var663670DD1E5C39043C69A7F64A2C1292_1276097675 = (file.isEmpty());
            {
                file = spec;
            } 
            {
                boolean varE8C8F246188348661A8B133D5E9D1FF7_867665937 = (spec.charAt(0) == '/');
                {
                    file = file.substring(0, file.indexOf('!') + 1) + spec;
                } 
                {
                    int idx = file.indexOf('!');
                    String tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
                    tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
                    file = file.substring(0, idx + 1) + tmpFile;
                } 
            } 
        } 
        try 
        {
            new URL(file);
        } 
        catch (MalformedURLException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(e.toString());
        } 
        setURL(url, "jar", "", -1, null, null, file, null, null);
        addTaint(url.getTaint());
        addTaint(spec.getTaint());
        addTaint(start);
        addTaint(limit);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.899 -0400", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "38C90E24407D462261B85566A8EDA562")
    @Override
    protected String toExternalForm(URL url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1204783351 = null; 
        StringBuilder sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref = url.getRef();
        {
            sb.append(ref);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1204783351 = sb.toString();
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1204783351.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1204783351;
        
        
        
        
        
        
            
        
        
    }

    
}

