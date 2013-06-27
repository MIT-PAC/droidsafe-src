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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.920 -0400", hash_original_method = "2DD01D30EAA2A038CBAA0D570E27B35E", hash_generated_method = "2DD01D30EAA2A038CBAA0D570E27B35E")
    public URLStreamHandler ()
    {
        //Synthesized constructor
    }


    protected abstract URLConnection openConnection(URL u) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.935 -0400", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "235086DD597D7F1149FEF0E40FBBBF03")
    protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(u.getTaint());
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.940 -0400", hash_original_method = "5B20F12B631910788308FABDC13B25A0", hash_generated_method = "7F136672F74C68BAFE88AC929872E69B")
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
        int port;
        port = -1;
        String path;
        String query;
        String ref;
        {
            boolean varC28F71AE0377A5B89EE543B4A9138ADF_348094381 = (spec.regionMatches(start, "//", 0, 2));
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
                        boolean var94751DC0C0DBFE32ADF3E9F980ED4A0D_1834824402 = (UrlUtils.findFirstOf(spec, ":", hostStart, ipv6End) == ipv6End);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Expected an IPv6 address: "
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
        int pos;
        pos = fileStart;
        {
            int nextPos;
            {
                Object var37FBD7EC15D4DF88223F1C260149F042_2041043528 = (spec.charAt(pos));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.964 -0400", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "A49F6FA388F40A960402A4D32793391F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.965 -0400", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "7F9780E78C86DA90CCEF66488000D14C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.965 -0400", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "2D788A93500F8440212C23420097C9F6")
    protected String toExternalForm(URL url) {
        String varB4EAC82CA7396A68D541C85D26508E83_1330218921 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1330218921 = toExternalForm(url, false);
        addTaint(url.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1330218921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1330218921;
        // ---------- Original Method ----------
        //return toExternalForm(url, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.966 -0400", hash_original_method = "629852CED0E76D3D83A14B3CB57F0652", hash_generated_method = "4D6F8A45BC511496BB2F5C03EB151980")
     String toExternalForm(URL url, boolean escapeIllegalCharacters) {
        String varB4EAC82CA7396A68D541C85D26508E83_1045327733 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1045327733 = result.toString();
        addTaint(url.getTaint());
        addTaint(escapeIllegalCharacters);
        varB4EAC82CA7396A68D541C85D26508E83_1045327733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1045327733;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.970 -0400", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "31D5025C514A6D03BF0AB336105CA791")
    protected boolean equals(URL a, URL b) {
        boolean var2605B69A8297093AF445A28C99C6DA19_235006333 = (sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery()));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068009892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068009892;
        // ---------- Original Method ----------
        //return sameFile(a, b)
                //&& Objects.equal(a.getRef(), b.getRef())
                //&& Objects.equal(a.getQuery(), b.getQuery());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.974 -0400", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "AAD1B24F043CC43AE3114DB2328C5308")
    protected int getDefaultPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096734847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1096734847;
        // ---------- Original Method ----------
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.975 -0400", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "F264F145BD2E172F71F7668A808BA0B5")
    protected InetAddress getHostAddress(URL url) {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_931237501 = null; //Variable for return #1
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1957548960 = null; //Variable for return #2
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1558865643 = null; //Variable for return #3
        try 
        {
            String host;
            host = url.getHost();
            {
                boolean varE80B7F8F5DF3C0E96BEA9E404FDFEC5D_169605497 = (host == null || host.length() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_931237501 = null;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1957548960 = InetAddress.getByName(host);
        } //End block
        catch (UnknownHostException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1558865643 = null;
        } //End block
        addTaint(url.getTaint());
        InetAddress varA7E53CE21691AB073D9660D615818899_1995838574; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1995838574 = varB4EAC82CA7396A68D541C85D26508E83_931237501;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1995838574 = varB4EAC82CA7396A68D541C85D26508E83_1957548960;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1995838574 = varB4EAC82CA7396A68D541C85D26508E83_1558865643;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1995838574.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1995838574;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.975 -0400", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "976E486FDC1AC288888B96CE05F2AE23")
    protected int hashCode(URL url) {
        int var48425AB4600D15902F703B9031278502_1619626828 = (toExternalForm(url).hashCode());
        addTaint(url.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105644177 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105644177;
        // ---------- Original Method ----------
        //return toExternalForm(url).hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.976 -0400", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "D5EDB2ECB57220359A0D52D5CA4D0A36")
    protected boolean hostsEqual(URL a, URL b) {
        String aHost;
        aHost = a.getHost();
        String bHost;
        bHost = b.getHost();
        boolean var146AC139A61EB6606DF27A5A6CF8C6E7_138340586 = ((aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_519131515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_519131515;
        // ---------- Original Method ----------
        //String aHost = a.getHost();
        //String bHost = b.getHost();
        //return (aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.998 -0400", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "7EE285355410BE101EEE30D28D497C57")
    protected boolean sameFile(URL a, URL b) {
        boolean var58D8CC8800DB2F4FEEA36EE340F18B83_1517957845 = (Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile()));
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167148202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167148202;
        // ---------- Original Method ----------
        //return Objects.equal(a.getProtocol(), b.getProtocol())
                //&& hostsEqual(a, b)
                //&& a.getEffectivePort() == b.getEffectivePort()
                //&& Objects.equal(a.getFile(), b.getFile());
    }

    
}

