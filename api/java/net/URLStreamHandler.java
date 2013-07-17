package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import libcore.net.url.UrlUtils;
import libcore.util.Objects;

public abstract class URLStreamHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.144 -0400", hash_original_method = "2DD01D30EAA2A038CBAA0D570E27B35E", hash_generated_method = "2DD01D30EAA2A038CBAA0D570E27B35E")
    public URLStreamHandler ()
    {
        //Synthesized constructor
    }


    protected abstract URLConnection openConnection(URL u) throws IOException;

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.145 -0400", hash_original_method = "E25BD4FE17DCB1FC5CA1FF6A9FF13CCB", hash_generated_method = "7F338EE41465D67EC95C60CBECEF919D")
    protected URLConnection openConnection(URL u, Proxy proxy) throws IOException {
        addTaint(proxy.getTaint());
        addTaint(u.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1554798531 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1554798531.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1554798531;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.152 -0400", hash_original_method = "9ADA0257B485782D9CE22060B8B1EC7F", hash_generated_method = "252A3D27C8043B49AEB5BC17241D4C3F")
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
            SecurityException varB852468C35D2E03DAD2B62E566755C8A_922462127 = new SecurityException();
            varB852468C35D2E03DAD2B62E566755C8A_922462127.addTaint(taint);
            throw varB852468C35D2E03DAD2B62E566755C8A_922462127;
        } //End block
        u.set(protocol, host, port, file, ref);
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, file, ref);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.152 -0400", hash_original_method = "CB2D373AEC994000865666F394E860FE", hash_generated_method = "DA1290EBDD2AD9B8B6E056A9BFC69AF2")
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
            SecurityException varB852468C35D2E03DAD2B62E566755C8A_1588654369 = new SecurityException();
            varB852468C35D2E03DAD2B62E566755C8A_1588654369.addTaint(taint);
            throw varB852468C35D2E03DAD2B62E566755C8A_1588654369;
        } //End block
        u.set(protocol, host, port, authority, userInfo, path, query, ref);
        // ---------- Original Method ----------
        //if (this != u.streamHandler) {
            //throw new SecurityException();
        //}
        //u.set(protocol, host, port, authority, userInfo, path, query, ref);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.153 -0400", hash_original_method = "D96D9FB5C1BC6194BEC4A07D1C2B48A4", hash_generated_method = "26BB931AC460441573BB21A671D43444")
    protected String toExternalForm(URL url) {
        addTaint(url.getTaint());
String varF0A5B50B9B05198AEACF658792F51D87_1120276935 =         toExternalForm(url, false);
        varF0A5B50B9B05198AEACF658792F51D87_1120276935.addTaint(taint);
        return varF0A5B50B9B05198AEACF658792F51D87_1120276935;
        // ---------- Original Method ----------
        //return toExternalForm(url, false);
    }

    
        @DSModeled(DSC.SPEC)
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.154 -0400", hash_original_method = "5273434A62CED7D2FFF6F02112157609", hash_generated_method = "E144997C1454B1E7017950E3721D0097")
    protected boolean equals(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        boolean var5E7B6A8AED2844D8870E6C807E7E29CD_816403627 = (sameFile(a, b)
                && Objects.equal(a.getRef(), b.getRef())
                && Objects.equal(a.getQuery(), b.getQuery()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_304474186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_304474186;
        // ---------- Original Method ----------
        //return sameFile(a, b)
                //&& Objects.equal(a.getRef(), b.getRef())
                //&& Objects.equal(a.getQuery(), b.getQuery());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.154 -0400", hash_original_method = "8D2F4C3352F1FCC45C0A9BA0F2D59609", hash_generated_method = "67F77D9DE20CA8A4479B2DE2BDDE5178")
    protected int getDefaultPort() {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1983076380 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1114748143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1114748143;
        // ---------- Original Method ----------
        //return -1;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.154 -0400", hash_original_method = "788D5B882334646F933829D465387DFF", hash_generated_method = "874491FB1854B17DD6B943C3E4425328")
    protected InetAddress getHostAddress(URL url) {
        addTaint(url.getTaint());
        try 
        {
            String host = url.getHost();
            if(host == null || host.length() == 0)            
            {
InetAddress var540C13E9E156B687226421B24F2DF178_930338959 =                 null;
                var540C13E9E156B687226421B24F2DF178_930338959.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_930338959;
            } //End block
InetAddress varBA3F67A3315C99351F90CC7409293FF6_211662793 =             InetAddress.getByName(host);
            varBA3F67A3315C99351F90CC7409293FF6_211662793.addTaint(taint);
            return varBA3F67A3315C99351F90CC7409293FF6_211662793;
        } //End block
        catch (UnknownHostException e)
        {
InetAddress var540C13E9E156B687226421B24F2DF178_128812053 =             null;
            var540C13E9E156B687226421B24F2DF178_128812053.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_128812053;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.155 -0400", hash_original_method = "1FF09FFC26156931BD17C23B3B706502", hash_generated_method = "1C905C89D52CB33140FFC5730C1E187D")
    protected int hashCode(URL url) {
        addTaint(url.getTaint());
        int varCEAA4042EE6001B769433E8B340E945D_127770077 = (toExternalForm(url).hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713520192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_713520192;
        // ---------- Original Method ----------
        //return toExternalForm(url).hashCode();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.155 -0400", hash_original_method = "41623183DD090D045D5E8C150A9F330D", hash_generated_method = "2CA47CC580AE46412351ADC383AF31EF")
    protected boolean hostsEqual(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        String aHost = a.getHost();
        String bHost = b.getHost();
        boolean varE8A88DD4C02265C4EC2A178592FDA6F3_495275944 = ((aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963094461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963094461;
        // ---------- Original Method ----------
        //String aHost = a.getHost();
        //String bHost = b.getHost();
        //return (aHost == bHost) || aHost != null && aHost.equalsIgnoreCase(bHost);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:52.155 -0400", hash_original_method = "995D235EB42F12C8FDC3FCC0E24D4349", hash_generated_method = "EA53FB06935EF444BF11BD55D1DC1CBB")
    protected boolean sameFile(URL a, URL b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        boolean varDE0A2B7F9F658B1B03EECE051D178B33_441779909 = (Objects.equal(a.getProtocol(), b.getProtocol())
                && hostsEqual(a, b)
                && a.getEffectivePort() == b.getEffectivePort()
                && Objects.equal(a.getFile(), b.getFile()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233488575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233488575;
        // ---------- Original Method ----------
        //return Objects.equal(a.getProtocol(), b.getProtocol())
                //&& hostsEqual(a, b)
                //&& a.getEffectivePort() == b.getEffectivePort()
                //&& Objects.equal(a.getFile(), b.getFile());
    }

    
}

