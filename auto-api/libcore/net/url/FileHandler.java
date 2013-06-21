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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.570 -0400", hash_original_method = "64F82705F8BFE391905F6C5A9493442F", hash_generated_method = "64F82705F8BFE391905F6C5A9493442F")
        public FileHandler ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.570 -0400", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "AF9955A44F6987788FC61159871B6AC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URLConnection openConnection(URL url) throws IOException {
        dsTaint.addTaint(url.dsTaint);
        URLConnection varFD54908712CF087470ED69248D87FB8F_995984468 = (openConnection(url, null));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openConnection(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.570 -0400", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "41DAA606396C01C9A5EC54E9C612199E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("url == null");
        } //End block
        String host;
        host = url.getHost();
        {
            boolean var58FB74E7C7902299B2BF0C1488A5F499_2021295648 = (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost"));
            {
                URLConnection var728921EE81B700E2BC2650E6446370AA_143182440 = (new FileURLConnection(url));
            } //End block
        } //End collapsed parenthetic
        URL ftpURL;
        ftpURL = new URL("ftp", host, url.getFile());
        {
            Object varD5A6AD6CFF82CE2C6ECD32649D267E27_1660200065 = (ftpURL.openConnection());
            Object var72C526E122ED4E1B0219103E206F1023_487264119 = (ftpURL.openConnection(proxy));
        } //End flattened ternary
        return (URLConnection)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.571 -0400", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "F2390413E39FE9AA174D3F24BFA9C0C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void parseURL(URL url, String spec, int start, int end) {
        dsTaint.addTaint(spec);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        dsTaint.addTaint(url.dsTaint);
        String parseString;
        parseString = "";
        {
            parseString = spec.substring(start, end).replace('\\', '/');
        } //End block
        super.parseURL(url, parseString, 0, parseString.length());
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

