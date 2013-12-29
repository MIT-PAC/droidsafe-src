package libcore.net.url;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;





public class JarHandler extends URLStreamHandler {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.324 -0400", hash_original_method = "0A284EE1D1173C3D5D1EE186B211FF85", hash_generated_method = "0A284EE1D1173C3D5D1EE186B211FF85")
    public JarHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Returns a connection to the jar file pointed by this <code>URL</code>
     * in the file system
     *
     * @return java.net.URLConnection A connection to the resource pointed by
     *         this url.
     * @param u
     *            java.net.URL The URL to which the connection is pointing to
     *
     * @throws IOException
     *             thrown if an IO error occurs when this method tries to
     *             establish connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.259 -0500", hash_original_method = "BD0D54E815B3E8434D2BE4AD1DDC7411", hash_generated_method = "78BB64D9372F21C949C4029C556A8131")
    @Override
protected URLConnection openConnection(URL u) throws IOException {
        return new JarURLConnectionImpl(u);
    }

    /**
     *
     * @param url
     *            URL the context URL
     * @param spec
     *            java.lang.String the spec string
     * @param start
     *            int the location to start parsing from
     * @param limit
     *            int the location where parsing ends
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.260 -0500", hash_original_method = "57C5D17E5E318F4D460452A0FAAB1E77", hash_generated_method = "CF416AC81ED16574D0269088E2D4D7CA")
    @Override
protected void parseURL(URL url, String spec, int start, int limit) {
        String file = url.getFile();
        if (file == null) {
            file = "";
        }
        if (limit > start) {
            spec = spec.substring(start, limit);
        } else {
            spec = "";
        }
        if (spec.indexOf("!/") == -1 && (file.indexOf("!/") == -1)) {
            throw new NullPointerException("Cannot find \"!/\"");
        }
        if (file.isEmpty()) {
            file = spec;
        } else if (spec.charAt(0) == '/') {
            file = file.substring(0, file.indexOf('!') + 1) + spec;
        } else {
            int idx = file.indexOf('!');
            String tmpFile = file.substring(idx + 1, file.lastIndexOf('/') + 1) + spec;
            tmpFile = UrlUtils.canonicalizePath(tmpFile, true);
            file = file.substring(0, idx + 1) + tmpFile;
        }
        try {
            // check that the embedded url is valid
            new URL(file);
        } catch (MalformedURLException e) {
            throw new NullPointerException(e.toString());
        }
        setURL(url, "jar", "", -1, null, null, file, null, null);
    }

    /**
     * Build and return the externalized string representation of url.
     *
     * @return String the externalized string representation of url
     * @param url
     *            a URL
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:43.261 -0500", hash_original_method = "F692A804EFA22D479A24DA08ED26F838", hash_generated_method = "14C560568D73D889123A33232020A01A")
    @Override
protected String toExternalForm(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append("jar:");
        sb.append(url.getFile());
        String ref = url.getRef();
        if (ref != null) {
            sb.append(ref);
        }
        return sb.toString();
    }

    
}

