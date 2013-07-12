package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import libcore.net.url.UrlUtils;
import libcore.util.Objects;

public abstract class URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.849 -0400", hash_original_method = "2DD01D30EAA2A038CBAA0D570E27B35E", hash_generated_method = "2DD01D30EAA2A038CBAA0D570E27B35E")
    public URLStreamHandler ()
    {
        
    }


    protected abstract URLConnection openConnection(URL u) throws IOException;

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.849 -0400", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "A139E3987A08FCD790DB657C9F8C34FE")
    protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(u.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_632673561 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_632673561.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_632673561;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.854 -0400", hash_original_method = "5B20F12B631910788308FABDC13B25A0", hash_generated_method = "85A54D9473FF0A5955B5C9039D79F097")
    protected void parseURL(URL url, String spec, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(spec.getTaint());
        addTaint(url.getTaint());
    if(this != url.streamHandler)        
        {
            SecurityException var487662ABA0BC6C0C1954C4C7EC919428_2008012379 = new SecurityException("Only a URL's stream handler is permitted to mutate it");
            var487662ABA0BC6C0C1954C4C7EC919428_2008012379.addTaint(taint);
            throw var487662ABA0BC6C0C1954C4C7EC919428_2008012379;
        } 
    if(end < start)        
        {
            StringIndexOutOfBoundsException varA141A5C099CCE115319C69142BCBF8CE_576269739 = new StringIndexOutOfBoundsException(spec, start, end - start);
            varA141A5C099CCE115319C69142BCBF8CE_576269739.addTaint(taint);
            throw varA141A5C099CCE115319C69142BCBF8CE_576269739;
        } 
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
            } 
            else
            {
                userInfo = null;
                hostStart = authorityStart;
            } 
            int colonSearchFrom = hostStart;
            int ipv6End = UrlUtils.findFirstOf(spec, "]", hostStart, fileStart);
    if(ipv6End != fileStart)            
            {
    if(UrlUtils.findFirstOf(spec, ":", hostStart, ipv6End) == ipv6End)                
                {
                    IllegalArgumentException var7AD0952D33BE3CCF5494213CD4BA84BF_1306784533 = new IllegalArgumentException("Expected an IPv6 address: "
                            + spec.substring(hostStart, ipv6End + 1));
                    var7AD0952D33BE3CCF5494213CD4BA84BF_1306784533.addTaint(taint);
                    throw var7AD0952D33BE3CCF5494213CD4BA84BF_1306784533;
                } 
                colonSearchFrom = ipv6End;
            } 
            int hostEnd = UrlUtils.findFirstOf(spec, ":", colonSearchFrom, fileStart);
            host = spec.substring(hostStart, hostEnd);
            int portStart = hostEnd + 1;
    if(portStart < fileStart)            
            {
                port = Integer.parseInt(spec.substring(portStart, fileStart));
    if(port < 0)                
                {
                    IllegalArgumentException var13CB96733FDAAE67690AEC1B839973F5_307914766 = new IllegalArgumentException("port < 0: " + port);
                    var13CB96733FDAAE67690AEC1B839973F5_307914766.addTaint(taint);
                    throw var13CB96733FDAAE67690AEC1B839973F5_307914766;
                } 
            } 
            path = null;
            query = null;
            ref = null;
        } 
        else
        {
            fileStart = start;
            authority = url.getAuthority();
            userInfo = url.getUserInfo();
            host = url.getHost();
    if(host == null)            
            {
                host = "";
            } 
            port = url.getPort();
            path = url.getPath();
            query = url.getQuery();
            ref = url.getRef();
        } 
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
        } 
    if(path == null)        
        {
            path = "";
        } 
        path = UrlUtils.authoritySafePath(authority, path);
        setURL(url, url.getProtocol(), host, port, authority, userInfo, path, query, ref);
        
        
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.856 -0400", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "373F74A2E14FD15EA622542FA2AA474D")
    @Deprecated
    protected void setURL(URL u, String protocol, String host, int port,
            String file, String ref) {
        addTaint(ref.getTaint());
        addTaint(file.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        addTaint(u.getTaint());
    if(this != u.streamHandler)        
        {
            SecurityException varB852468C35D2E03DAD2B62E566755C8A_2124786639 = new SecurityException();
            varB852468C35D2E03DAD2B62E566755C8A_2124786639.addTaint(taint);
            throw varB852468C35D2E03DAD2B62E566755C8A_2124786639;
        } 
        u.set(protocol, host, port, file, ref);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.857 -0400", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "2C91DCB13998726761DF21DA9C44F003")
    protected void setURL(URL u, String protocol, String host, int port,
            String authority, String userInfo, String path, String query,
            String ref) {
        addTaint(ref.getTaint());
        addTaint(query.getTaint());
        addTaint(path.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(authority.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(protocol.getTaint());
        addTaint(u.getTaint());
    if(this != u.streamHandler)        
        {
            SecurityException varB852468C35D2E03DAD2B62E566755C8A_2119910892 = new SecurityException();
            varB852468C35D2E03DAD2B62E566755C8A_2119910892.addTaint(taint);
            throw varB852468C35D2E03DAD2B62E566755C8A_2119910892;
        } 
        u.set(protocol, host, port, authority, userInfo, path, query, ref);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.858 -0400", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "E9EEB13AF3D8B8CC3CE0EFE0828433B8")
    protected String toExternalForm(URL url) {
        addTaint(url.getTaint());
String varF0A5B50B9B05198AEACF658792F51D87_427063333 =         toExternalForm(url, false);
        varF0A5B50B9B05198AEACF658792F51D87_427063333.addTaint(taint);
        return varF0A5B50B9B05198AEACF658792F51D87_427063333;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.858 -0400", hash_original_method = "629852CED0E76D3D83A14B3CB57F0652", hash_generated_method = "4FCFA8CA9A8C25B2B043D26FE54CEECF")
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
            } 
            else
            {
                result.append(authority);
            } 
        } 
        String fileAndQuery = url.getFile();
    if(fileAndQuery != null)        
        {
    if(escapeIllegalCharacters)            
            {
                URI.FILE_AND_QUERY_ENCODER.appendPartiallyEncoded(result, fileAndQuery);
            } 
            else
            {
                result.append(fileAndQuery);
            } 
        } 
        String ref = url.getRef();
    if(ref != null)        
        {
            result.append('#');
    if(escapeIllegalCharacters)            
            {
                URI.ALL_LEGAL_ENCODER.appendPartiallyEncoded(result, ref);
            } 
            else
            {
                result.append(ref);
            } 
        } 
String varE65B3A02759122992CB82C0E651AD408_1935096299 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1935096299.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1935096299;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.860 -0400", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "809701EC78B4E4FF18E2CAB732F1AA4D")
    protected boolean equals(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        boolean var5E7B6A8AED2844D8870E6C807E7E29CD_1742115860 = (sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_198593871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_198593871;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.860 -0400", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "B0C49E9F5CBB1595C8F82AC29B831B87")
    protected int getDefaultPort() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_433745337 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435317579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435317579;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.861 -0400", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "1843FFDD9979CE1099F56FEF78FE1426")
    protected InetAddress getHostAddress(URL url) {
        addTaint(url.getTaint());
        try 
        {
            String host = url.getHost();
    if(host == null || host.length() == 0)            
            {
InetAddress var540C13E9E156B687226421B24F2DF178_792146964 =                 null;
                var540C13E9E156B687226421B24F2DF178_792146964.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_792146964;
            } 
InetAddress varBA3F67A3315C99351F90CC7409293FF6_1285850406 =             InetAddress.getByName(host);
            varBA3F67A3315C99351F90CC7409293FF6_1285850406.addTaint(taint);
            return varBA3F67A3315C99351F90CC7409293FF6_1285850406;
        } 
        catch (UnknownHostException e)
        {
InetAddress var540C13E9E156B687226421B24F2DF178_1727335945 =             null;
            var540C13E9E156B687226421B24F2DF178_1727335945.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1727335945;
        } 
        
        
            
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.861 -0400", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "8DC388CB1DE38447F47CECFF6E022C4F")
    protected int hashCode(URL url) {
        addTaint(url.getTaint());
        int varCEAA4042EE6001B769433E8B340E945D_1282916286 = (toExternalForm(url).hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429407151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_429407151;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.862 -0400", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "FFC792975A0D3860E4A939DCB4991E57")
    protected boolean hostsEqual(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        String aHost = a.getHost();
        String bHost = b.getHost();
        boolean varE8A88DD4C02265C4EC2A178592FDA6F3_1386859715 = ((aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512053480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512053480;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.862 -0400", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "7E8B8B9C3A61B52BE595420721E3C078")
    protected boolean sameFile(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        boolean varDE0A2B7F9F658B1B03EECE051D178B33_183039594 = (Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109621829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109621829;
        
        
                
                
                
    }

    
}

