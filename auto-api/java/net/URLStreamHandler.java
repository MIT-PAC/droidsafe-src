package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import libcore.net.url.UrlUtils;
import libcore.util.Objects;

public abstract class URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.668 -0400", hash_original_method = "2DD01D30EAA2A038CBAA0D570E27B35E", hash_generated_method = "2DD01D30EAA2A038CBAA0D570E27B35E")
    public URLStreamHandler ()
    {
        //Synthesized constructor
    }


    protected abstract URLConnection openConnection(URL u) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.669 -0400", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "235086DD597D7F1149FEF0E40FBBBF03")
    protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
    	throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.671 -0400", hash_original_method = "5B20F12B631910788308FABDC13B25A0", hash_generated_method = "55BD37E80D1C44E22D625B4B23C21402")
    protected void parseURL(URL url, String spec, int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException("Only a URL's stream handler is permitted to mutate it");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(spec, start, end - start);
        } //End block
        int fileStart;
        String authority;
        String userInfo;
        String host;
        int port = -1;
        String path;
        String query;
        String ref;
        {
            boolean varC28F71AE0377A5B89EE543B4A9138ADF_343053596 = (spec.regionMatches(start, "//", 0, 2));
            {
                int authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(spec, "/?#", authorityStart, end);
                authority = spec.substring(authorityStart, fileStart);
                int userInfoEnd = UrlUtils.findFirstOf(spec, "@", authorityStart, fileStart);
                int hostStart;
                {
                    userInfo = spec.substring(authorityStart, userInfoEnd);
                    hostStart = userInfoEnd + 1;
                } //End block
                {
                    userInfo = null;
                    hostStart = authorityStart;
                } //End block
                int colonSearchFrom = hostStart;
                int ipv6End = UrlUtils.findFirstOf(spec, "]", hostStart, fileStart);
                {
                    {
                        boolean var94751DC0C0DBFE32ADF3E9F980ED4A0D_148390025 = (UrlUtils.findFirstOf(spec, ":", hostStart, ipv6End) == ipv6End);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Expected an IPv6 address: "
                            + spec.substring(hostStart, ipv6End + 1));
                        } //End block
                    } //End collapsed parenthetic
                    colonSearchFrom = ipv6End;
                } //End block
                int hostEnd = UrlUtils.findFirstOf(spec, ":", colonSearchFrom, fileStart);
                host = spec.substring(hostStart, hostEnd);
                int portStart = hostEnd + 1;
                {
                    port = Integer.parseInt(spec.substring(portStart, fileStart));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("port < 0: " + port);
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
        int pos = fileStart;
        {
            int nextPos;
            {
                Object var37FBD7EC15D4DF88223F1C260149F042_1555821893 = (spec.charAt(pos));
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
        addTaint(url.getTaint());
        addTaint(spec.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.672 -0400", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "A49F6FA388F40A960402A4D32793391F")
    @Deprecated
    protected void setURL(URL u, String protocol, String host, int port,
            String file, String ref) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException();
        } //End block
        u.set(protocol, host, port, file, ref);
        addTaint(u.getTaint());
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(file.getTaint());
        addTaint(ref.getTaint());
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, file, ref);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.672 -0400", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "7F9780E78C86DA90CCEF66488000D14C")
    protected void setURL(URL u, String protocol, String host, int port,
            String authority, String userInfo, String path, String query,
            String ref) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException();
        } //End block
        u.set(protocol, host, port, authority, userInfo, path, query, ref);
        addTaint(u.getTaint());
        addTaint(protocol.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(authority.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(path.getTaint());
        addTaint(query.getTaint());
        addTaint(ref.getTaint());
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, authority, userInfo, path, query, ref);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.676 -0400", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "7F26CA652E30D7F74610948B9499E25B")
    protected String toExternalForm(URL url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1751096096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1751096096 = toExternalForm(url, false);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1751096096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1751096096;
        // ---------- Original Method ----------
        //return toExternalForm(url, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.678 -0400", hash_original_method = "629852CED0E76D3D83A14B3CB57F0652", hash_generated_method = "4C2A9D467EEFCFB8C84AE0B429B15407")
     String toExternalForm(URL url, boolean escapeIllegalCharacters) {
        String varB4EAC82CA7396A68D541C85D26508E83_964297640 = null; //Variable for return #1
        StringBuilder result = new StringBuilder();
        result.append(url.getProtocol());
        result.append(':');
        String authority = url.getAuthority();
        {
            result.append("//");
            {
                URI.AUTHORITY_ENCODER.appendPartiallyEncoded(result, authority);
            } //End block
            {
                result.append(authority);
            } //End block
        } //End block
        String fileAndQuery = url.getFile();
        {
            {
                URI.FILE_AND_QUERY_ENCODER.appendPartiallyEncoded(result, fileAndQuery);
            } //End block
            {
                result.append(fileAndQuery);
            } //End block
        } //End block
        String ref = url.getRef();
        {
            result.append('#');
            {
                URI.ALL_LEGAL_ENCODER.appendPartiallyEncoded(result, ref);
            } //End block
            {
                result.append(ref);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_964297640 = result.toString();
        addTaint(url.getTaint());
        addTaint(escapeIllegalCharacters);
        varB4EAC82CA7396A68D541C85D26508E83_964297640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_964297640;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.679 -0400", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "4A09208C6C658C7D40902CA921F39479")
    protected boolean equals(URL a, URL b) {
        boolean var2605B69A8297093AF445A28C99C6DA19_1638402319 = (sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery()));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731901616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731901616;
        // ---------- Original Method ----------
        //return sameFile(a, b)
                //&& Objects.equal(a.getRef(), b.getRef())
                //&& Objects.equal(a.getQuery(), b.getQuery());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.679 -0400", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "1B675B76DBAF1A7BBAA3BE811A4334CC")
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659048355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659048355;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.680 -0400", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "997A30195CA2394C1B9FA1EEAEEF4BF0")
    protected InetAddress getHostAddress(URL url) {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_668314281 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_226474005 = null; //Variable for return #2
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1151645235 = null; //Variable for return #3
        try 
        {
            String host = url.getHost();
            {
                boolean varE80B7F8F5DF3C0E96BEA9E404FDFEC5D_1185543631 = (host == null || host.length() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_668314281 = null;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_226474005 = InetAddress.getByName(host);
        } //End block
        catch (UnknownHostException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1151645235 = null;
        } //End block
        addTaint(url.getTaint());
        InetAddress varA7E53CE21691AB073D9660D615818899_1692611983; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692611983 = varB4EAC82CA7396A68D541C85D26508E83_668314281;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1692611983 = varB4EAC82CA7396A68D541C85D26508E83_226474005;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692611983 = varB4EAC82CA7396A68D541C85D26508E83_1151645235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692611983.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692611983;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.682 -0400", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "902AAC850ED69B19E7E3A4EAEA45C386")
    protected int hashCode(URL url) {
        int var48425AB4600D15902F703B9031278502_1933047303 = (toExternalForm(url).hashCode());
        addTaint(url.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170644101 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_170644101;
        // ---------- Original Method ----------
        //return toExternalForm(url).hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.682 -0400", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "76A0FDDCBA2BA9EA09B3BDBFFAC9D1D2")
    protected boolean hostsEqual(URL a, URL b) {
        String aHost = a.getHost();
        String bHost = b.getHost();
        boolean var146AC139A61EB6606DF27A5A6CF8C6E7_481438616 = ((aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1001883706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1001883706;
        // ---------- Original Method ----------
        //String aHost = a.getHost();
        //String bHost = b.getHost();
        //return (aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.683 -0400", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "CC97C212AF2CE7BF085A2A6CFD7C624F")
    protected boolean sameFile(URL a, URL b) {
        boolean var58D8CC8800DB2F4FEEA36EE340F18B83_1209310462 = (Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile()));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120662140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120662140;
        // ---------- Original Method ----------
        //return Objects.equal(a.getProtocol(), b.getProtocol())
                //&& hostsEqual(a, b)
                //&& a.getEffectivePort() == b.getEffectivePort()
                //&& Objects.equal(a.getFile(), b.getFile());
    }

    
}

