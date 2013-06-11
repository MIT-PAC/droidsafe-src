package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FileHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.518 -0400", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "217A43A39A4BB70F8FD631875A222015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URLConnection openConnection(URL url) throws IOException {
        dsTaint.addTaint(url.dsTaint);
        URLConnection varFD54908712CF087470ED69248D87FB8F_761767424 = (openConnection(url, null));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openConnection(url, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.518 -0400", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "8A0848C5DC5BA47C1A4AB218C49CED84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(url.dsTaint);
        {
            throw new IllegalArgumentException("url == null");
        } //End block
        String host;
        host = url.getHost();
        {
            boolean var58FB74E7C7902299B2BF0C1488A5F499_507496776 = (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost"));
        } //End collapsed parenthetic
        URL ftpURL;
        ftpURL = new URL("ftp", host, url.getFile());
        {
            Object varD5A6AD6CFF82CE2C6ECD32649D267E27_1460471295 = (ftpURL.openConnection());
            Object var72C526E122ED4E1B0219103E206F1023_1251501125 = (ftpURL.openConnection(proxy));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.518 -0400", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "758CB5B5F5558DD0BC1350ED12566F20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void parseURL(URL url, String spec, int start, int end) {
        dsTaint.addTaint(spec);
        dsTaint.addTaint(start);
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(end);
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


