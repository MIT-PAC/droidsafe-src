package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;





public class FileHandler extends URLStreamHandler {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.158 -0400", hash_original_method = "6784E94C0D30F3330B20FF566B070BF0", hash_generated_method = "6784E94C0D30F3330B20FF566B070BF0")
    public FileHandler ()
    {
        //Synthesized constructor
    }

    /**
     * Returns a connection to the a file pointed by this <code>URL</code> in
     * the file system
     *
     * @return A connection to the resource pointed by this url.
     * @param url
     *            URL The URL to which the connection is pointing to
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.294 -0500", hash_original_method = "9E19C679A0152E7A481321FB9FD94041", hash_generated_method = "E3EDDDAF09AFFD3D0D388E24CA868D38")
    
@Override
    public URLConnection openConnection(URL url) throws IOException {
        return openConnection(url, null);
    }

    /**
     * The behavior of this method is the same as openConnection(URL).
     * <code>proxy</code> is not used in FileURLConnection.
     *
     * @param url
     *            the URL which the connection is pointing to
     * @param proxy
     *            Proxy
     * @return a connection to the resource pointed by this url.
     *
     * @throws IOException
     *             if this handler fails to establish a connection.
     * @throws IllegalArgumentException
     *             if the url argument is null.
     * @throws UnsupportedOperationException
     *             if the protocol handler doesn't support this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.297 -0500", hash_original_method = "3680F869AEF91A8B3F794811BFCF54E6", hash_generated_method = "130B732D567D20D7C7A1B763509FA203")
    
@Override
    public URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException("url == null");
        }

        String host = url.getHost();
        if (host == null || host.isEmpty() || host.equalsIgnoreCase("localhost")) {
            return new FileURLConnection(url);
        }

        // If a hostname is specified try to get the resource using FTP
        URL ftpURL = new URL("ftp", host, url.getFile());
        return (proxy == null) ? ftpURL.openConnection() : ftpURL.openConnection(proxy);
    }

    /**
     * Parse the <code>string</code>str into <code>URL</code> u which
     * already have the context properties. The string generally have the
     * following format: <code><center>/c:/windows/win.ini</center></code>.
     *
     * @param url
     *            The URL object that's parsed into
     * @param spec
     *            The string equivalent of the specification URL
     * @param start
     *            The index in the spec string from which to begin parsing
     * @param end
     *            The index to stop parsing
     *
     * @see java.net.URLStreamHandler#toExternalForm(URL)
     * @see java.net.URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.300 -0500", hash_original_method = "F97A1055288731314CAAC8F3AEEE2191", hash_generated_method = "C12CAABAF7BDF9DF44CAFF756EE456D1")
    
@Override
    protected void parseURL(URL url, String spec, int start, int end) {
        if (end < start) {
            return;
        }
        String parseString = "";
        if (start < end) {
            parseString = spec.substring(start, end).replace('\\', '/');
        }
        super.parseURL(url, parseString, 0, parseString.length());
    }

    
}

