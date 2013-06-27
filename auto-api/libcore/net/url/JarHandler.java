package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class JarHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.143 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.144 -0400", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "FF0457411E63557C4ED8CA29ED4A8C3B")
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        URLConnection varB4EAC82CA7396A68D541C85D26508E83_1006962757 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1006962757 = new JarURLConnectionImpl(u);
        addTaint(u.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1006962757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1006962757;
        // ---------- Original Method ----------
        //return new JarURLConnectionImpl(u);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.159 -0400", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "CDD0B636E220E137C7D079D4B07A8271")
    @Override
    protected void parseURL(URL url, String spec, int start, int limit) {
        String file;
        file = url.getFile();
        {
            file = "";
        } //End block
        {
            spec = spec.substring(start, limit);
        } //End block
        {
            spec = "";
        } //End block
        {
            boolean var3948E0BE2774036E4123DB53B312CCF1_1478966755 = (spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1));
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Cannot find \"!/\"");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var663670DD1E5C39043C69A7F64A2C1292_459807972 = (file.isEmpty());
            {
                file = spec;
            } //End block
            {
                boolean varE8C8F246188348661A8B133D5E9D1FF7_417129276 = (spec.charAt(0) == '/');
                {
                    file = file.substring(0, file.indexOf('!') + 1) + spec;
                } //End block
                {
                    int idx;
                    idx = file.indexOf('!');
                    String tmpFile;
                    tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
                    tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
                    file = file.substring(0, idx + 1) + tmpFile;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        try 
        {
            new URL(file);
        } //End block
        catch (MalformedURLException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException(e.toString());
        } //End block
        setURL(url, "jar", "", -1, null, null, file, null, null);
        addTaint(url.getTaint());
        addTaint(spec.getTaint());
        addTaint(start);
        addTaint(limit);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.164 -0400", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "C7F89E6604F8DBCAC485C42320ACF789")
    @Override
    protected String toExternalForm(URL url) {
        String varB4EAC82CA7396A68D541C85D26508E83_2047598891 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref;
        ref = url.getRef();
        {
            sb.append(ref);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2047598891 = sb.toString();
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2047598891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047598891;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder();
        //sb.append("jar:");
        //sb.append(url.getFile());
        //String ref = url.getRef();
        //if (ref != null) {
            //sb.append(ref);
        //}
        //return sb.toString();
    }

    
}

