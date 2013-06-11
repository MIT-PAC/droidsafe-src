package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import libcore.net.url.UrlUtils;
import libcore.util.Objects;

public abstract class URLStreamHandler {
    
    protected abstract URLConnection openConnection(URL u) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.457 -0400", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "29CCF907ACEE9977428AA4C1ACCD7BEC")
    @DSModeled(DSC.SAFE)
    protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
        dsTaint.addTaint(u.dsTaint);
        dsTaint.addTaint(proxy.dsTaint);
        throw new UnsupportedOperationException();
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.457 -0400", hash_original_method = "5B20F12B631910788308FABDC13B25A0", hash_generated_method = "3413A1DF00EF89079A494BEC7486C2E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void parseURL(URL url, String spec, int start, int end) {
        dsTaint.addTaint(spec);
        dsTaint.addTaint(start);
        dsTaint.addTaint(url.dsTaint);
        dsTaint.addTaint(end);
        {
            throw new SecurityException("Only a URL's stream handler is permitted to mutate it");
        } //End block
        {
            throw new StringIndexOutOfBoundsException(spec, start, end - start);
        } //End block
        int fileStart;
        String authority;
        String userInfo;
        String host;
        int port;
        port = -1;
        String path;
        String query;
        String ref;
        {
            boolean varC28F71AE0377A5B89EE543B4A9138ADF_294832586 = (spec.regionMatches(start, "//", 0, 2));
            {
                int authorityStart;
                authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(spec, "/?#", authorityStart, end);
                authority = spec.substring(authorityStart, fileStart);
                int userInfoEnd;
                userInfoEnd = UrlUtils.findFirstOf(spec, "@", authorityStart, fileStart);
                int hostStart;
                {
                    userInfo = spec.substring(authorityStart, userInfoEnd);
                    hostStart = userInfoEnd + 1;
                } //End block
                {
                    userInfo = null;
                    hostStart = authorityStart;
                } //End block
                int colonSearchFrom;
                colonSearchFrom = hostStart;
                int ipv6End;
                ipv6End = UrlUtils.findFirstOf(spec, "]", hostStart, fileStart);
                {
                    {
                        boolean var94751DC0C0DBFE32ADF3E9F980ED4A0D_1543698637 = (UrlUtils.findFirstOf(spec, ":", hostStart, ipv6End) == ipv6End);
                        {
                            throw new IllegalArgumentException("Expected an IPv6 address: "
                            + spec.substring(hostStart, ipv6End + 1));
                        } //End block
                    } //End collapsed parenthetic
                    colonSearchFrom = ipv6End;
                } //End block
                int hostEnd;
                hostEnd = UrlUtils.findFirstOf(spec, ":", colonSearchFrom, fileStart);
                host = spec.substring(hostStart, hostEnd);
                int portStart;
                portStart = hostEnd + 1;
                {
                    port = Integer.parseInt(spec.substring(portStart, fileStart));
                    {
                        throw new IllegalArgumentException("port < 0: " + port);
                    } //End block
                } //End block
                path = null;
                query = null;
                ref = null;
            } //End block
            {
                fileStart = start;
                authority = url.getAuthority();
                userInfo = url.getUserInfo();
                host = url.getHost();
                {
                    host = "";
                } //End block
                port = url.getPort();
                path = url.getPath();
                query = url.getQuery();
                ref = url.getRef();
            } //End block
        } //End collapsed parenthetic
        int pos;
        pos = fileStart;
        {
            int nextPos;
            {
                Object var37FBD7EC15D4DF88223F1C260149F042_761117036 = (spec.charAt(pos));
                //Begin case '#' 
                nextPos = end;
                //End case '#' 
                //Begin case '#' 
                ref = spec.substring(pos + 1, nextPos);
                //End case '#' 
                //Begin case '?' 
                nextPos = UrlUtils.findFirstOf(spec, "#", pos, end);
                //End case '?' 
                //Begin case '?' 
                query = spec.substring(pos + 1, nextPos);
                //End case '?' 
                //Begin case '?' 
                ref = null;
                //End case '?' 
                //Begin case default 
                nextPos = UrlUtils.findFirstOf(spec, "?#", pos, end);
                //End case default 
                //Begin case default 
                path = relativePath(path, spec.substring(pos, nextPos));
                //End case default 
                //Begin case default 
                query = null;
                //End case default 
                //Begin case default 
                ref = null;
                //End case default 
            } //End collapsed parenthetic
            pos = nextPos;
        } //End block
        {
            path = "";
        } //End block
        path = UrlUtils.authoritySafePath(authority, path);
        setURL(url, url.getProtocol(), host, port, authority, userInfo, path, query, ref);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "A806CA7014E8BD9EACDE88341CB2140E", hash_generated_method = "9BE48AEDEDDA3DE7BD6115522CF4A620")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "E1AAE9F01C21EE1EFFABAC3C848E1259")
    @DSModeled(DSC.SAFE)
    @Deprecated
    protected void setURL(URL u, String protocol, String host, int port,
            String file, String ref) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(ref);
        dsTaint.addTaint(u.dsTaint);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(file);
        {
            throw new SecurityException();
        } //End block
        u.set(protocol, host, port, file, ref);
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, file, ref);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "4BDB20814386227A1113CD11486B7C2A")
    @DSModeled(DSC.SAFE)
    protected void setURL(URL u, String protocol, String host, int port,
            String authority, String userInfo, String path, String query,
            String ref) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(authority);
        dsTaint.addTaint(ref);
        dsTaint.addTaint(u.dsTaint);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(query);
        dsTaint.addTaint(path);
        dsTaint.addTaint(userInfo);
        {
            throw new SecurityException();
        } //End block
        u.set(protocol, host, port, authority, userInfo, path, query, ref);
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, authority, userInfo, path, query, ref);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "1F3456F91911AC0EC30F0C58F89DA68E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String toExternalForm(URL url) {
        dsTaint.addTaint(url.dsTaint);
        String var245DAA992E80995AE29BC0E02176D7A6_2036165992 = (toExternalForm(url, false));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toExternalForm(url, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "629852CED0E76D3D83A14B3CB57F0652", hash_generated_method = "B37A04EA18364CCC977FF0FBB7923ADB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String toExternalForm(URL url, boolean escapeIllegalCharacters) {
        dsTaint.addTaint(escapeIllegalCharacters);
        dsTaint.addTaint(url.dsTaint);
        StringBuilder result;
        result = new StringBuilder();
        result.append(url.getProtocol());
        result.append(':');
        String authority;
        authority = url.getAuthority();
        {
            result.append("//");
            {
                URI.AUTHORITY_ENCODER.appendPartiallyEncoded(result, authority);
            } //End block
            {
                result.append(authority);
            } //End block
        } //End block
        String fileAndQuery;
        fileAndQuery = url.getFile();
        {
            {
                URI.FILE_AND_QUERY_ENCODER.appendPartiallyEncoded(result, fileAndQuery);
            } //End block
            {
                result.append(fileAndQuery);
            } //End block
        } //End block
        String ref;
        ref = url.getRef();
        {
            result.append('#');
            {
                URI.ALL_LEGAL_ENCODER.appendPartiallyEncoded(result, ref);
            } //End block
            {
                result.append(ref);
            } //End block
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_1274018646 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "D0AA5266C515EC0B30219D54F2593B34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean equals(URL a, URL b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        boolean var2605B69A8297093AF445A28C99C6DA19_1714935234 = (sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sameFile(a, b)
                //&& Objects.equal(a.getRef(), b.getRef())
                //&& Objects.equal(a.getQuery(), b.getQuery());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "D55807BCEBF384B20B3EA556151BFC63")
    @DSModeled(DSC.SAFE)
    protected int getDefaultPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.458 -0400", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "3C5043EA0BF00B2BD5CBCD6F110F6554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InetAddress getHostAddress(URL url) {
        dsTaint.addTaint(url.dsTaint);
        try 
        {
            String host;
            host = url.getHost();
            {
                boolean varE80B7F8F5DF3C0E96BEA9E404FDFEC5D_2057735840 = (host == null || host.length() == 0);
            } //End collapsed parenthetic
            InetAddress var6E3A33EF0B7E1B243D0B854D532FE28E_1786171852 = (InetAddress.getByName(host));
        } //End block
        catch (UnknownHostException e)
        { }
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //String host = url.getHost();
            //if (host == null || host.length() == 0) {
                //return null;
            //}
            //return InetAddress.getByName(host);
        //} catch (UnknownHostException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.459 -0400", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "4A20D7651B3E31BCAE1EE67DE20C8F34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int hashCode(URL url) {
        dsTaint.addTaint(url.dsTaint);
        int var48425AB4600D15902F703B9031278502_1981673495 = (toExternalForm(url).hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return toExternalForm(url).hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.459 -0400", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "F4B38164611A081263B906818AE32A7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean hostsEqual(URL a, URL b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        String aHost;
        aHost = a.getHost();
        String bHost;
        bHost = b.getHost();
        boolean var146AC139A61EB6606DF27A5A6CF8C6E7_693204613 = ((aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String aHost = a.getHost();
        //String bHost = b.getHost();
        //return (aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.459 -0400", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "68AB93E18D8C910788347162BEB85621")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean sameFile(URL a, URL b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        boolean var58D8CC8800DB2F4FEEA36EE340F18B83_176656849 = (Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Objects.equal(a.getProtocol(), b.getProtocol())
                //&& hostsEqual(a, b)
                //&& a.getEffectivePort() == b.getEffectivePort()
                //&& Objects.equal(a.getFile(), b.getFile());
    }

    
}


