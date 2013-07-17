package libcore.net.url;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class FileHandler extends URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.158 -0400", hash_original_method = "6784E94C0D30F3330B20FF566B070BF0", hash_generated_method = "6784E94C0D30F3330B20FF566B070BF0")
    public FileHandler ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.158 -0400", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "FCA1109FE1697C801FA7146456055FC1")
    @Override
    public URLConnection openConnection(URL url) throws IOException {
        addTaint(url.getTaint());
URLConnection varC7B56D70891864570C2950F90421920A_1380602706 =         openConnection(url, null);
        varC7B56D70891864570C2950F90421920A_1380602706.addTaint(taint);
        return varC7B56D70891864570C2950F90421920A_1380602706;
        // ---------- Original Method ----------
        //return openConnection(url, null);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.159 -0400", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "C15824E829C490F2A5A55DF0C4D243E2")
    @Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(url.getTaint());
        if(url == null)        
        {
            IllegalArgumentException var51E90DD83A5055CB9B1F9A4E2C3BCFA1_1011389326 = new IllegalArgumentException("url == null");
            var51E90DD83A5055CB9B1F9A4E2C3BCFA1_1011389326.addTaint(taint);
            throw var51E90DD83A5055CB9B1F9A4E2C3BCFA1_1011389326;
        } //End block
        String host = url.getHost();
        if(host == null || host.isEmpty() || host.equalsIgnoreCase("localhost"))        
        {
URLConnection var3B440E203A7BBFEF602C7128B9D19C0D_1160249732 =             new FileURLConnection(url);
            var3B440E203A7BBFEF602C7128B9D19C0D_1160249732.addTaint(taint);
            return var3B440E203A7BBFEF602C7128B9D19C0D_1160249732;
        } //End block
        URL ftpURL = new URL("ftp", host, url.getFile());
URLConnection varB1DC9B102F866A79AD790258FC9A0468_1412419626 =         (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
        varB1DC9B102F866A79AD790258FC9A0468_1412419626.addTaint(taint);
        return varB1DC9B102F866A79AD790258FC9A0468_1412419626;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.160 -0400", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "567ACC7846469F94C9CDB182E0EC3830")
    @Override
    protected void parseURL(URL url, String spec, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(spec.getTaint());
        addTaint(url.getTaint());
        if(end < start)        
        {
            return;
        } //End block
        String parseString = "";
        if(start < end)        
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

