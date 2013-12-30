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





public class FtpHandler extends URLStreamHandler {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.195 -0400", hash_original_method = "D147DA8ADE52659E6B675F3FCB66ABA5", hash_generated_method = "D147DA8ADE52659E6B675F3FCB66ABA5")
    public FtpHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Open a URLConnection on the given URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.663 -0500", hash_original_method = "3C5B2D25E22696E048ED7556D298C58C", hash_generated_method = "950BA299B573064452A86E0E53D88336")
    
@Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new FtpURLConnection(u);
    }

    /**
     * Returns a connection, which is established via the <code>proxy</code>,
     * to the FTP server specified by this <code>URL</code>. If
     * <code>proxy</code> is DIRECT type, the connection is made in normal
     * way.
     *
     * @param url
     *            the URL which the connection is pointing to
     * @param proxy
     *            the proxy which is used to make the connection
     * @return a connection to the resource pointed by this url.
     *
     * @throws IOException
     *             if this handler fails to establish a connection.
     * @throws IllegalArgumentException
     *             if any argument is null or the type of proxy is wrong.
     * @throws UnsupportedOperationException
     *             if the protocol handler doesn't support this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.666 -0500", hash_original_method = "1D737A935EF21FF08B15C0F0950C4FF6", hash_generated_method = "C5D04284015278F1AA31C6B17625F949")
    
@Override
    protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
        if (url == null || proxy == null) {
            throw new IllegalArgumentException("url == null || proxy == null");
        }
        return new FtpURLConnection(url, proxy);
    }

    /**
     * Return the default port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:37.669 -0500", hash_original_method = "EEF2A707E6AE293A2B045747E5BC7948", hash_generated_method = "837E1A89ED5DEE7DBC3C424F105290DF")
    
@Override
    protected int getDefaultPort() {
        return 21;
    }

    
}

