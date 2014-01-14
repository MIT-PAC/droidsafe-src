package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import libcore.net.url.UrlUtils;
import libcore.util.Objects;

public abstract class URLStreamHandler {

    /**
     * Returns a new path by resolving {@code path} relative to {@code base}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.483 -0500", hash_original_method = "A806CA7014E8BD9EACDE88341CB2140E", hash_generated_method = "9BE48AEDEDDA3DE7BD6115522CF4A620")
    
private static String relativePath(String base, String path) {
        if (path.startsWith("/")) {
            return UrlUtils.canonicalizePath(path, true);
        } else if (base != null) {
            String combined = base.substring(0, base.lastIndexOf('/') + 1) + path;
            return UrlUtils.canonicalizePath(combined, true);
        } else {
            return path;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.144 -0400", hash_original_method = "2DD01D30EAA2A038CBAA0D570E27B35E", hash_generated_method = "2DD01D30EAA2A038CBAA0D570E27B35E")
    public URLStreamHandler ()
    {
        //Synthesized constructor
    }
    /**
     * Establishes a new connection to the resource specified by the URL {@code
     * u}. Since different protocols also have unique ways of connecting, it
     * must be overwritten by the subclass.
     *
     * @param u
     *            the URL to the resource where a connection has to be opened.
     * @return the opened URLConnection to the specified resource.
     * @throws IOException
     *             if an I/O error occurs during opening the connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.472 -0500", hash_original_method = "041D500E1591B8A75B5DD1417FC123EC", hash_generated_method = "300967F6DD1F653B0B214BF830AB6C5B")
    
protected abstract URLConnection openConnection(URL u) throws IOException;

    /**
     * Establishes a new connection to the resource specified by the URL {@code
     * u} using the given {@code proxy}. Since different protocols also have
     * unique ways of connecting, it must be overwritten by the subclass.
     *
     * @param u
     *            the URL to the resource where a connection has to be opened.
     * @param proxy
     *            the proxy that is used to make the connection.
     * @return the opened URLConnection to the specified resource.
     * @throws IOException
     *             if an I/O error occurs during opening the connection.
     * @throws IllegalArgumentException
     *             if any argument is {@code null} or the type of proxy is
     *             wrong.
     * @throws UnsupportedOperationException
     *             if the protocol handler doesn't support this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.475 -0500", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "A9F14988D1A778777FC1E31E1759BC16")
    
protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
        throw new UnsupportedOperationException();
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.150 -0400", hash_original_method = "5B20F12B631910788308FABDC13B25A0", hash_generated_method = "336F439C1F833B32DEC8FA12E2EFD44D")
    protected void parseURL(URL url, String spec, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(spec.getTaint());
        addTaint(url.getTaint());
        if(this != url.streamHandler)        
        {
            SecurityException var487662ABA0BC6C0C1954C4C7EC919428_1134314017 = new SecurityException("Only a URL's stream handler is permitted to mutate it");
            var487662ABA0BC6C0C1954C4C7EC919428_1134314017.addTaint(taint);
            throw var487662ABA0BC6C0C1954C4C7EC919428_1134314017;
        } //End block
        if(end < start)        
        {
            StringIndexOutOfBoundsException varA141A5C099CCE115319C69142BCBF8CE_1432411299 = new StringIndexOutOfBoundsException(spec, start, end - start);
            varA141A5C099CCE115319C69142BCBF8CE_1432411299.addTaint(taint);
            throw varA141A5C099CCE115319C69142BCBF8CE_1432411299;
        } //End block
        int fileStart;
        String authority;
        String userInfo;
        String host;
        int port = -1;
        String path;
        String query;
        String ref;
        if(spec.regionMatches(start, "//", 0, 2))        
        {
            int authorityStart = start + 2;
            fileStart = UrlUtils.findFirstOf(spec, "/?#", authorityStart, end);
            authority = spec.substring(authorityStart, fileStart);
            int userInfoEnd = UrlUtils.findFirstOf(spec, "@", authorityStart, fileStart);
            int hostStart;
            if(userInfoEnd != fileStart)            
            {
                userInfo = spec.substring(authorityStart, userInfoEnd);
                hostStart = userInfoEnd + 1;
            } //End block
            else
            {
                userInfo = null;
                hostStart = authorityStart;
            } //End block
            int colonSearchFrom = hostStart;
            int ipv6End = UrlUtils.findFirstOf(spec, "]", hostStart, fileStart);
            if(ipv6End != fileStart)            
            {
                if(UrlUtils.findFirstOf(spec, ":", hostStart, ipv6End) == ipv6End)                
                {
                    IllegalArgumentException var7AD0952D33BE3CCF5494213CD4BA84BF_1080940106 = new IllegalArgumentException("Expected an IPv6 address: "
                            + spec.substring(hostStart, ipv6End + 1));
                    var7AD0952D33BE3CCF5494213CD4BA84BF_1080940106.addTaint(taint);
                    throw var7AD0952D33BE3CCF5494213CD4BA84BF_1080940106;
                } //End block
                colonSearchFrom = ipv6End;
            } //End block
            int hostEnd = UrlUtils.findFirstOf(spec, ":", colonSearchFrom, fileStart);
            host = spec.substring(hostStart, hostEnd);
            int portStart = hostEnd + 1;
            if(portStart < fileStart)            
            {
                port = Integer.parseInt(spec.substring(portStart, fileStart));
                if(port < 0)                
                {
                    IllegalArgumentException var13CB96733FDAAE67690AEC1B839973F5_1497837441 = new IllegalArgumentException("port < 0: " + port);
                    var13CB96733FDAAE67690AEC1B839973F5_1497837441.addTaint(taint);
                    throw var13CB96733FDAAE67690AEC1B839973F5_1497837441;
                } //End block
            } //End block
            path = null;
            query = null;
            ref = null;
        } //End block
        else
        {
            fileStart = start;
            authority = url.getAuthority();
            userInfo = url.getUserInfo();
            host = url.getHost();
            if(host == null)            
            {
                host = "";
            } //End block
            port = url.getPort();
            path = url.getPath();
            query = url.getQuery();
            ref = url.getRef();
        } //End block
        int pos = fileStart;
        while
(pos < end)        
        {
            int nextPos;
switch(spec.charAt(pos)){
            case '#':
            nextPos = end;
            ref = spec.substring(pos + 1, nextPos);
            break;
            case '?':
            nextPos = UrlUtils.findFirstOf(spec, "#", pos, end);
            query = spec.substring(pos + 1, nextPos);
            ref = null;
            break;
            default:
            nextPos = UrlUtils.findFirstOf(spec, "?#", pos, end);
            path = relativePath(path, spec.substring(pos, nextPos));
            query = null;
            ref = null;
            break;
}            pos = nextPos;
        } //End block
        if(path == null)        
        {
            path = "";
        } //End block
        path = UrlUtils.authoritySafePath(authority, path);
        setURL(url, url.getProtocol(), host, port, authority, userInfo, path, query, ref);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Sets the fields of the URL {@code u} to the values of the supplied
     * arguments.
     *
     * @param u
     *            the non-null URL object to be set.
     * @param protocol
     *            the protocol.
     * @param host
     *            the host name.
     * @param port
     *            the port number.
     * @param file
     *            the file component.
     * @param ref
     *            the reference.
     * @deprecated use setURL(URL, String String, int, String, String, String,
     *             String, String) instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.485 -0500", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "4A9BF45FB9BD6560FDF1FE1C146BD4D7")
    
@Deprecated
    protected void setURL(URL u, String protocol, String host, int port,
            String file, String ref) {
        if (this != u.streamHandler) {
            throw new SecurityException();
        }
        u.set(protocol, host, port, file, ref);
    }

    /**
     * Sets the fields of the URL {@code u} to the values of the supplied
     * arguments.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.488 -0500", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "BB8E807735BF8B37BD6D9D1A31362EC2")
    
protected void setURL(URL u, String protocol, String host, int port,
            String authority, String userInfo, String path, String query,
            String ref) {
        if (this != u.streamHandler) {
            throw new SecurityException();
        }
        u.set(protocol, host, port, authority, userInfo, path, query, ref);
    }

    /**
     * Returns the clear text representation of a given URL using HTTP format.
     *
     * @param url
     *            the URL object to be converted.
     * @return the clear text representation of the specified URL.
     * @see #parseURL
     * @see URL#toExternalForm()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.490 -0500", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "CA11A05DE26BB29DA87518A02206BA27")
    
protected String toExternalForm(URL url) {
        return toExternalForm(url, false);
    }
        
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.153 -0400", hash_original_method = "629852CED0E76D3D83A14B3CB57F0652", hash_generated_method = "EB3AD88B67334820582162A57C895ACB")
     String toExternalForm(URL url, boolean escapeIllegalCharacters) {
        addTaint(escapeIllegalCharacters);
        addTaint(url.getTaint());
        StringBuilder result = new StringBuilder();
        result.append(url.getProtocol());
        result.append(':');
        String authority = url.getAuthority();
        if(authority != null)        
        {
            result.append("//");
            if(escapeIllegalCharacters)            
            {
                URI.AUTHORITY_ENCODER.appendPartiallyEncoded(result, authority);
            } //End block
            else
            {
                result.append(authority);
            } //End block
        } //End block
        String fileAndQuery = url.getFile();
        if(fileAndQuery != null)        
        {
            if(escapeIllegalCharacters)            
            {
                URI.FILE_AND_QUERY_ENCODER.appendPartiallyEncoded(result, fileAndQuery);
            } //End block
            else
            {
                result.append(fileAndQuery);
            } //End block
        } //End block
        String ref = url.getRef();
        if(ref != null)        
        {
            result.append('#');
            if(escapeIllegalCharacters)            
            {
                URI.ALL_LEGAL_ENCODER.appendPartiallyEncoded(result, ref);
            } //End block
            else
            {
                result.append(ref);
            } //End block
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1238751379 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1238751379.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1238751379;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Returns true if {@code a} and {@code b} have the same protocol, host,
     * port, file, and reference.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.496 -0500", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "5CE74B9F6208391846C455088544C7EA")
    
protected boolean equals(URL a, URL b) {
        return sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery());
    }

    /**
     * Returns the default port of the protocol used by the handled URL. The
     * default implementation always returns {@code -1}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.499 -0500", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "205C6723B425D54E9B5A8C1AA4C8FA2F")
    
protected int getDefaultPort() {
        return -1;
    }

    /**
     * Returns the host address of {@code url}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.501 -0500", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "2215DE521BAD2D6AFEF78F79F87E6D9A")
    
protected InetAddress getHostAddress(URL url) {
        try {
            String host = url.getHost();
            if (host == null || host.length() == 0) {
                return null;
            }
            return InetAddress.getByName(host);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    /**
     * Returns the hash code of {@code url}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.504 -0500", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "3D67A5380D5954AFF1BAB48395A5ADB1")
    
protected int hashCode(URL url) {
        return toExternalForm(url).hashCode();
    }

    /**
     * Returns true if the hosts of {@code a} and {@code b} are equal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.506 -0500", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "0C94BC53A56883B931F9FB502EDD9033")
    
protected boolean hostsEqual(URL a, URL b) {
        // URLs with the same case-insensitive host name have equal hosts
        String aHost = a.getHost();
        String bHost = b.getHost();
        return (aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost);
    }

    /**
     * Returns true if {@code a} and {@code b} have the same protocol, host,
     * port and file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:13.509 -0500", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "23043EB8BE3FDBE60673B3EE851E2612")
    
protected boolean sameFile(URL a, URL b) {
        return Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile());
    }
    
}

