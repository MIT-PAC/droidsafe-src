package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;

public final class URI implements Comparable<URI>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "A77350C36FACC15543B26BF9F179A70D")

    private transient String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "97E7FA8F49FDF56AB2DF43BBC80E2476", hash_generated_field = "14DBC9168C32C9C014586FA7F0B8A107")

    private transient String schemeSpecificPart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "57D185265731B43622C0B461510772A9")

    private transient String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "0A24F4A69DB662BA59F12A9B09B3CA7F")

    private transient String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "D5EC92E1B3465138D54142DB3E99F34E")

    private transient int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "172D3480DA0AFB6E023B26EA00955132")

    private transient String fragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "94619F8A70068B2591C2EED622525B0E", hash_generated_field = "EDD34009E3CB727B5445D7F24CB35623")

    private transient boolean opaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "DC4D53AA0D117D8B189B36D161AF4E96", hash_generated_field = "8B0AF94FA16DD5DBCAA078866E853806")

    private transient boolean absolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "51622123728B411C7CCF75B702B58CC9", hash_generated_field = "D4CE8185ED9C0ACE43C0C010B0E562F4")

    private transient boolean serverAuthority = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.106 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "F58223E1E1183B179891344C3FD7FA57")

    private transient int hash = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.107 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "1BF7E280541A2A445B26B3247430EA17")
    private  URI() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.107 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "DC5F33F54AA8A0DF7A12A5E0E0C0D494")
    public  URI(String spec) throws URISyntaxException {
        parseURI(spec, false);
        addTaint(spec.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.107 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "38DEF9C21DAF49E8E9A3B4F62EE64EE7")
    public  URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException {
        StringBuilder uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } 
        {
            ALL_LEGAL_ENCODER.appendEncoded(uri, schemeSpecificPart);
        } 
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } 
        parseURI(uri.toString(), false);
        addTaint(scheme.getTaint());
        addTaint(schemeSpecificPart.getTaint());
        addTaint(fragment.getTaint());
        
        
        
            
            
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.108 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "9B1150FF07634BAFB1EF08F6FB889480")
    public  URI(String scheme, String userInfo, String host, int port, String path, String query,
            String fragment) throws URISyntaxException {
        {
            this.path = "";
        } 
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_1964566631 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(path, "Relative path");
            } 
        } 
        StringBuilder uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } 
        {
            uri.append("//");
        } 
        {
            USER_INFO_ENCODER.appendEncoded(uri, userInfo);
            uri.append('@');
        } 
        {
            {
                boolean var550E64C193B5291AD437B9B1D9496F50_928590774 = (host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1);
                {
                    host = "[" + host + "]";
                } 
            } 
            uri.append(host);
        } 
        {
            uri.append(':');
            uri.append(port);
        } 
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } 
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } 
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } 
        parseURI(uri.toString(), true);
        addTaint(scheme.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(port);
        addTaint(query.getTaint());
        addTaint(fragment.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.108 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "C223B3818AB1B450218A67BECCAB8872")
    public  URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        addTaint(scheme.getTaint());
        addTaint(host.getTaint());
        addTaint(path.getTaint());
        addTaint(fragment.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.109 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "ED027690685423037527EEC711064850")
    public  URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_321077734 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(path, "Relative path");
            } 
        } 
        StringBuilder uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } 
        {
            uri.append("//");
            AUTHORITY_ENCODER.appendEncoded(uri, authority);
        } 
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } 
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } 
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } 
        parseURI(uri.toString(), false);
        addTaint(scheme.getTaint());
        addTaint(authority.getTaint());
        addTaint(path.getTaint());
        addTaint(query.getTaint());
        addTaint(fragment.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.111 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "F893FFA353AB7E2B907489343F187666")
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        string = uri;
        int fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
        {
            boolean var14906E87F75C4EB9DB697B7FC771BD9F_1158082650 = (fragmentStart < uri.length());
            {
                fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
            } 
        } 
        int start;
        int colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
        {
            boolean varA7FDD5A6BBA9720FEB70A13E43618B16_1140836835 = (colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart));
            {
                absolute = true;
                scheme = validateScheme(uri, colon);
                start = colon + 1;
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme-specific part expected", start);
                } 
                {
                    boolean varEBC930CB1CD455F7868E4252B2B7D45B_1376596204 = (!uri.regionMatches(start, "/", 0, 1));
                    {
                        opaque = true;
                        schemeSpecificPart = ALL_LEGAL_ENCODER.validate(
                        uri, start, fragmentStart, "scheme specific part");
                    } 
                } 
            } 
            {
                absolute = false;
                start = 0;
            } 
        } 
        opaque = false;
        schemeSpecificPart = uri.substring(start, fragmentStart);
        int fileStart;
        {
            boolean var5757BFA7159BA6600285D2DC55CA28A4_1003151749 = (uri.regionMatches(start, "//", 0, 2));
            {
                int authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
                {
                    boolean var1B2B73CCD1123E5D8F07A549A84A962C_863285700 = (authorityStart == uri.length());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Authority expected", uri.length());
                    } 
                } 
                {
                    authority = AUTHORITY_ENCODER.validate(uri, authorityStart, fileStart, "authority");
                } 
            } 
            {
                fileStart = start;
            } 
        } 
        int queryStart = UrlUtils.findFirstOf(uri, "?", fileStart, fragmentStart);
        path = PATH_ENCODER.validate(uri, fileStart, queryStart, "path");
        {
            query = ALL_LEGAL_ENCODER.validate(uri, queryStart + 1, fragmentStart, "query");
        } 
        parseAuthority(forceServer);
        addTaint(forceServer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.112 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "A5E046F824BBF26D3FDF01F7F0E5F69F")
    private String validateScheme(String uri, int end) throws URISyntaxException {
        String varB4EAC82CA7396A68D541C85D26508E83_785837994 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme expected", 0);
        } 
        {
            int i = 0;
            {
                {
                    boolean varF659B01EBB7D3C509A86E3BFA39CC1B5_1659502332 = (!UrlUtils.isValidSchemeChar(i, uri.charAt(i)));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in scheme", 0);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_785837994 = uri.substring(0, end);
        addTaint(uri.getTaint());
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_785837994.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_785837994;
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.112 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "AD020EBC1C41EE288E7C8B0E7C0D03E8")
    private void parseAuthority(boolean forceServer) throws URISyntaxException {
        String tempUserInfo = null;
        String temp = authority;
        int index = temp.indexOf('@');
        int hostIndex = 0;
        {
            tempUserInfo = temp.substring(0, index);
            validateUserInfo(authority, tempUserInfo, 0);
            temp = temp.substring(index + 1);
            hostIndex = index + 1;
        } 
        index = temp.lastIndexOf(':');
        int endIndex = temp.indexOf(']');
        String tempHost;
        int tempPort = -1;
        {
            tempHost = temp.substring(0, index);
            {
                boolean var471C201E222440759958E44C5A2F8C2C_365390767 = (index < (temp.length() - 1));
                {
                    try 
                    {
                        tempPort = Integer.parseInt(temp.substring(index + 1));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority,
                                    "Invalid port number", hostIndex + index + 1);
                            } 
                        } 
                    } 
                    catch (NumberFormatException e)
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority,
                                "Invalid port number", hostIndex + index + 1);
                        } 
                    } 
                } 
            } 
        } 
        {
            tempHost = temp;
        } 
        {
            boolean var07D9E4585E11834C381219EB624A85F7_1608237603 = (tempHost.isEmpty());
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority, "Expected host", hostIndex);
                } 
            } 
        } 
        {
            boolean var158075BD2E1D16639FB8BCBA31A90016_141250000 = (!isValidHost(forceServer, tempHost));
        } 
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
        addTaint(forceServer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.113 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "232C6F5E4B4B32D1202DC423DFB4386F")
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        {
            int i = 0;
            boolean var61BE23789239FB4C090D5853B97C62FB_1132584792 = (i < userInfo.length());
            {
                char ch = userInfo.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
                } 
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(index);
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.114 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "3A706F538731ED8BB621AB1B31AD9F41")
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        {
            boolean varFCCCD9BDBC603228D4710DD2E5A9B32F_1653052190 = (host.startsWith("["));
            {
                {
                    boolean varF9599A0F269A93198F48A20A694972EC_656603249 = (!host.endsWith("]"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                    } 
                } 
                {
                    boolean varD5E87321776926869A9F8CCC6C3D14FA_447741376 = (InetAddress.isNumeric(host));
                } 
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv6 address");
            } 
        } 
        {
            boolean var36FFAEAF88FC26FFC5276B550B24D5DE_1337602630 = (host.indexOf('[') != -1 || host.indexOf(']') != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
            } 
        } 
        int index = host.lastIndexOf('.');
        {
            boolean var62B5BEA078C6AF897DE86B7C91F4DAEC_1478392303 = (index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)));
            {
                {
                    boolean var60D4AC8ED4B08A7A4E9E67A3B8F29C40_1974782055 = (isValidDomainName(host));
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
                } 
            } 
        } 
        try 
        {
            InetAddress ia = InetAddress.parseNumericAddress(host);
        } 
        catch (IllegalArgumentException ignored)
        { }
        {
            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv4 address", 0);
        } 
        addTaint(forceServer);
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411264212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411264212;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.119 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "309CFDF0EADAFC3B116447CB2D7BEE01")
    private boolean isValidDomainName(String host) {
        try 
        {
            UriCodec.validateSimple(host, "-.");
        } 
        catch (URISyntaxException e)
        { }
        String lastLabel = null;
        {
            String token = host.split("\\.")[0];
            {
                lastLabel = token;
                {
                    boolean var092620AA3BCBDBEC4B02F610B8967169_1425918702 = (lastLabel.startsWith("-") || lastLabel.endsWith("-"));
                } 
            } 
        } 
        {
            boolean var62581F9350E01C0148C5B044A3636F9A_1590813256 = (!lastLabel.equals(host));
            {
                char ch = lastLabel.charAt(0);
            } 
        } 
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127145563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127145563;
        
        
            
        
            
        
        
        
            
            
                
            
        
        
            
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.121 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "98B7BC1CBD62F20E0076F8631D376ECA")
    public int compareTo(URI uri) {
        int ret;
        {
            ret = scheme.compareToIgnoreCase(uri.scheme);
        } 
        {
            ret = schemeSpecificPart.compareTo(uri.schemeSpecificPart);
        } 
        {
            {
                {
                    {
                        ret = userInfo.compareTo(uri.userInfo);
                    } 
                    ret = host.compareToIgnoreCase(uri.host);
                } 
                {
                    ret = authority.compareTo(uri.authority);
                } 
            } 
            ret = path.compareTo(uri.path);
            {
                ret = query.compareTo(uri.query);
            } 
        } 
        {
            ret = fragment.compareTo(uri.fragment);
        } 
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822302297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1822302297;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    public static URI create(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.124 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "006210AB8EE444DC69EB9EA78D301E3E")
    private URI duplicate() {
        URI varB4EAC82CA7396A68D541C85D26508E83_2100206278 = null; 
        URI clone = new URI();
        clone.absolute = absolute;
        clone.authority = authority;
        clone.fragment = fragment;
        clone.host = host;
        clone.opaque = opaque;
        clone.path = path;
        clone.port = port;
        clone.query = query;
        clone.scheme = scheme;
        clone.schemeSpecificPart = schemeSpecificPart;
        clone.userInfo = userInfo;
        clone.serverAuthority = serverAuthority;
        varB4EAC82CA7396A68D541C85D26508E83_2100206278 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_2100206278.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2100206278;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.128 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "92DC63121D96C77BE6ED0B174DA5F993")
    private String convertHexToLowerCase(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_1628926635 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2122428046 = null; 
        StringBuilder result = new StringBuilder("");
        {
            boolean varEB6442064EDBB8B51A5716AA5B8E92B3_801080568 = (s.indexOf('%') == -1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1628926635 = s;
            } 
        } 
        int index;
        int prevIndex = 0;
        {
            boolean var3FA97A1C7FD8BD3DFDFB4FA1562BC71E_1951816674 = ((index = s.indexOf('%', prevIndex)) != -1);
            {
                result.append(s.substring(prevIndex, index + 1));
                result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
                index += 3;
                prevIndex = index;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2122428046 = result.toString();
        addTaint(s.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1833563326; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1833563326 = varB4EAC82CA7396A68D541C85D26508E83_1628926635;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1833563326 = varB4EAC82CA7396A68D541C85D26508E83_2122428046;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1833563326.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1833563326;
        
        
        
            
        
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.129 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "29DCE033BD723E223C1E310920DE2F23")
    private boolean escapedEquals(String first, String second) {
        {
            boolean var1F61A1CA58188B3C323B0BC1A8DADBE6_205622643 = (first.indexOf('%') != second.indexOf('%'));
            {
                boolean var9A92D953275813B0E21E2ACB41134B3B_1421715569 = (first.equals(second));
            } 
        } 
        int index;
        int prevIndex = 0;
        {
            boolean var9722F6B33E3926CBF63854BB7D6FD389_42077728 = ((index = first.indexOf('%', prevIndex)) != -1
                && second.indexOf('%', prevIndex) == index);
            {
                boolean match = first.substring(prevIndex, index).equals(
                    second.substring(prevIndex, index));
                match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    second.substring(index + 1, index + 3));
                index += 3;
                prevIndex = index;
            } 
        } 
        boolean var82012BF29BC079AE3198FB95B5CF6151_1183317004 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
        addTaint(first.getTaint());
        addTaint(second.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608476937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608476937;
        
        
            
        
        
        
                
            
                    
            
                
            
            
                    
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.130 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "DC3B03C551AAC52DC74482456698A584")
    @Override
    public boolean equals(Object o) {
        URI uri = (URI) o;
        {
            {
                boolean var60CDEB48A7F58F8237D705D7C40D17CC_749148840 = (!escapedEquals(uri.fragment, fragment));
            } 
        } 
        {
            {
                boolean var38EA33084FCA86881E8FD72A38A7749C_1548275226 = (!uri.scheme.equalsIgnoreCase(scheme));
            } 
        } 
        {
            boolean var7E67A78714F419D789626F935DC27349_1947422663 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
        } 
        {
            {
                boolean varA8C91154088202E89FE7FC4E6E5FD0C6_540754415 = (!escapedEquals(path, uri.path));
            } 
            {
                {
                    boolean var7C1AA47824584214BA2C304C225799C2_595255236 = (!escapedEquals(uri.query, query));
                } 
            } 
            {
                {
                    boolean varCFCD5A99259213E0C97153FBD1F01864_1111440446 = (escapedEquals(uri.authority, authority));
                } 
                {
                    {
                        boolean var157801492CF3B05F03DFA16E5EB86961_616498460 = (!host.equalsIgnoreCase(uri.host));
                    } 
                    {
                        boolean varB9E57D7781CD81877C81BF504253B25D_819051154 = (escapedEquals(userInfo, uri.userInfo));
                    } 
                } 
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228577246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228577246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.131 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FD268BE32633FDD201B649D1E56D4CD2")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1173058395 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1173058395 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1173058395.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1173058395;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.131 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "78E2610247F3D3FF5D6198BB342C6308")
    public String getSchemeSpecificPart() {
        String varB4EAC82CA7396A68D541C85D26508E83_650677982 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_650677982 = decode(schemeSpecificPart);
        varB4EAC82CA7396A68D541C85D26508E83_650677982.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_650677982;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.132 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "20D206DF32E187BE702D94A62E3E8065")
    public String getRawSchemeSpecificPart() {
        String varB4EAC82CA7396A68D541C85D26508E83_741246032 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_741246032 = schemeSpecificPart;
        varB4EAC82CA7396A68D541C85D26508E83_741246032.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_741246032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.132 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "948054096BE9ADBF5C4D6FA9D9D92ED5")
    public String getAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_774766504 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_774766504 = decode(authority);
        varB4EAC82CA7396A68D541C85D26508E83_774766504.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_774766504;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.132 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "FECCA2CFB685F5C560DAE641F6317306")
    public String getRawAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1103661474 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1103661474 = authority;
        varB4EAC82CA7396A68D541C85D26508E83_1103661474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1103661474;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.133 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "2CC19891747CC7889A0A7683B39B64D4")
    public String getUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_657512654 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_657512654 = decode(userInfo);
        varB4EAC82CA7396A68D541C85D26508E83_657512654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_657512654;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.133 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "A68BC8AA11BB4E19AF07FCCDF26EC5DD")
    public String getRawUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_253722547 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_253722547 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_253722547.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_253722547;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.133 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "8861E8905D667BF71FE1E05946AF577E")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1491565030 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1491565030 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1491565030.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1491565030;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.134 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "4035B0F777121FA78F78DEC5A49ABE69")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736187878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_736187878;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.134 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "E39B1F2DFB9E2EC884783BB0B110E9D1")
    public int getEffectivePort() {
        int var12709C286048EEEA3C7AFAA905EEAD9D_381077486 = (getEffectivePort(scheme, port));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712894543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712894543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static int getEffectivePort(String scheme, int specifiedPort) {
        if (specifiedPort != -1) {
            return specifiedPort;
        }
        if ("http".equalsIgnoreCase(scheme)) {
            return 80;
        } else if ("https".equalsIgnoreCase(scheme)) {
            return 443;
        } else {
            return -1;
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.135 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "B6D5A17D8BE70917247CC4CA0B3806A5")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1804056963 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1804056963 = decode(path);
        varB4EAC82CA7396A68D541C85D26508E83_1804056963.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1804056963;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.135 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "49A5D0CF329D8D44A9DBE21CFD324F66")
    public String getRawPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1005410485 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1005410485 = path;
        varB4EAC82CA7396A68D541C85D26508E83_1005410485.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1005410485;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.136 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "86AF07851462EB55B11ECF87918506D0")
    public String getQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_1175114165 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1175114165 = decode(query);
        varB4EAC82CA7396A68D541C85D26508E83_1175114165.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1175114165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.136 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "DD945598FEFC5EE132DD3781C8DD5BA7")
    public String getRawQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_1275486503 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1275486503 = query;
        varB4EAC82CA7396A68D541C85D26508E83_1275486503.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1275486503;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.137 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "F7A438D65FC919348C22DA7A9FAF5320")
    public String getFragment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1200384823 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1200384823 = decode(fragment);
        varB4EAC82CA7396A68D541C85D26508E83_1200384823.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1200384823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.137 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "89756866266388B86D654DDBE736000F")
    public String getRawFragment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1806915368 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1806915368 = fragment;
        varB4EAC82CA7396A68D541C85D26508E83_1806915368.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1806915368;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.137 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "39F8D6E107A9D7E48E060FC26F237E45")
    @Override
    public int hashCode() {
        {
            hash = getHashString().hashCode();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33482200 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_33482200;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.138 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "E97E3B2D904A98776BE6240EFF3CC893")
    public boolean isAbsolute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567045015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567045015;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.138 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "0F6D3D8A3BDC9DB33A67ED2952C33F31")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1260990830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1260990830;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.139 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "9C946209BA42996397CF064C5A6D7938")
    private String normalize(String path, boolean discardRelativePrefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_137291176 = null; 
        path = UrlUtils.canonicalizePath(path, discardRelativePrefix);
        int colon = path.indexOf(':');
        {
            int slash = path.indexOf('/');
            {
                path = "./" + path;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_137291176 = path;
        varB4EAC82CA7396A68D541C85D26508E83_137291176.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_137291176;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.139 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "ADF0C4E1A568527AC721AC3CFE249DAF")
    public URI normalize() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1216712369 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_366934351 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_293523703 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1216712369 = this;
        } 
        String normalizedPath = normalize(path, false);
        {
            boolean varED6BB76AF8F0E8C24432884623407A00_1908471082 = (path.equals(normalizedPath));
            {
                varB4EAC82CA7396A68D541C85D26508E83_366934351 = this;
            } 
        } 
        URI result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_293523703 = result;
        URI varA7E53CE21691AB073D9660D615818899_1385681649; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1385681649 = varB4EAC82CA7396A68D541C85D26508E83_1216712369;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1385681649 = varB4EAC82CA7396A68D541C85D26508E83_366934351;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1385681649 = varB4EAC82CA7396A68D541C85D26508E83_293523703;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1385681649.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1385681649;
        
        
            
        
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.141 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "DF852AB46E71FD06166993C01CED13EC")
    public URI parseServerAuthority() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_1095445451 = null; 
        {
            parseAuthority(true);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1095445451 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1095445451.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1095445451;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.144 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "828ED8063689A74C57E1A8CAB50854D9")
    public URI relativize(URI relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_1365834865 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_237140008 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_1413038236 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_370030167 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_842394229 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1365834865 = relative;
        } 
        {
            {
                boolean varC865ACA7FB0CCF69283F042F0DB61312_469050526 = (!scheme
                .equals(relative.scheme));
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_237140008 = relative;
            } 
        } 
        {
            {
                boolean varE0036196913086AF15703499E78ECF8B_2054910849 = (!authority
                .equals(relative.authority));
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1413038236 = relative;
            } 
        } 
        String thisPath = normalize(path, false);
        String relativePath = normalize(relative.path, false);
        {
            boolean varEDBF7EABD9E353975E483312E9BAC550_1869184776 = (!thisPath.equals(relativePath));
            {
                thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
                {
                    boolean varDC148464305F08DF1780EDF47FFC747D_1344381572 = (!relativePath.startsWith(thisPath));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_370030167 = relative;
                    } 
                } 
            } 
        } 
        URI result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_842394229 = result;
        URI varA7E53CE21691AB073D9660D615818899_597963175; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_597963175 = varB4EAC82CA7396A68D541C85D26508E83_1365834865;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_597963175 = varB4EAC82CA7396A68D541C85D26508E83_237140008;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_597963175 = varB4EAC82CA7396A68D541C85D26508E83_1413038236;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_597963175 = varB4EAC82CA7396A68D541C85D26508E83_370030167;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_597963175 = varB4EAC82CA7396A68D541C85D26508E83_842394229;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_597963175.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_597963175;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.149 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "EA6B27CF0CADE2BB99584E2DE7E23832")
    public URI resolve(URI relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_266558614 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_1752798604 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_1230918481 = null; 
        URI varB4EAC82CA7396A68D541C85D26508E83_1858049928 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_266558614 = relative;
        } 
        {
            URI result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
            varB4EAC82CA7396A68D541C85D26508E83_1752798604 = result;
        } 
        {
            boolean var03F21B31825B83006AD962520A46A4CC_2038984772 = (relative.path.isEmpty() && relative.scheme == null && relative.query == null);
            {
                URI result = duplicate();
                result.fragment = relative.fragment;
                varB4EAC82CA7396A68D541C85D26508E83_1230918481 = result;
            } 
        } 
        URI result = duplicate();
        result.fragment = relative.fragment;
        result.query = relative.query;
        String resolvedPath;
        {
            boolean varEC53DB095CB8776983E38D0B1831503B_1303984944 = (relative.path.startsWith("/"));
            {
                resolvedPath = relative.path;
            } 
            {
                boolean var64B3618E3CF5D0DE8D9BCC96B26D0E61_1154707448 = (relative.path.isEmpty());
                {
                    resolvedPath = path;
                } 
                {
                    int endIndex = path.lastIndexOf('/') + 1;
                    resolvedPath = path.substring(0, endIndex) + relative.path;
                } 
            } 
        } 
        result.path = UrlUtils.authoritySafePath(result.authority, normalize(resolvedPath, true));
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_1858049928 = result;
        URI varA7E53CE21691AB073D9660D615818899_935260257; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_935260257 = varB4EAC82CA7396A68D541C85D26508E83_266558614;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_935260257 = varB4EAC82CA7396A68D541C85D26508E83_1752798604;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_935260257 = varB4EAC82CA7396A68D541C85D26508E83_1230918481;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_935260257 = varB4EAC82CA7396A68D541C85D26508E83_1858049928;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_935260257.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_935260257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.150 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "7DFF54882C0FCF3E04AF5B45DA6214CB")
    private void setSchemeSpecificPart() {
        StringBuilder ssp = new StringBuilder();
        {
            ssp.append("//" + authority);
        } 
        {
            ssp.append(path);
        } 
        {
            ssp.append("?" + query);
        } 
        schemeSpecificPart = ssp.toString();
        string = null;
        
        
        
            
        
        
            
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.153 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "86C116C74A74A3D7EA03F0642493797A")
    public URI resolve(String relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_1576134098 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1576134098 = resolve(create(relative));
        addTaint(relative.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1576134098.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1576134098;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.154 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "73284FDB1548C58A6F12849C83DB1412")
    private String decode(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_793484319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_793484319 = s != null ? UriCodec.decode(s) : null;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_793484319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_793484319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.155 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "827A890950FE30A00F6B7786B872C6F6")
    public String toASCIIString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2062765004 = null; 
        StringBuilder result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        varB4EAC82CA7396A68D541C85D26508E83_2062765004 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2062765004.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2062765004;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.156 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "86E0732E51F7711B57858EA0C1946F19")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2565386 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_551735533 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2565386 = string;
        } 
        StringBuilder result = new StringBuilder();
        {
            result.append(scheme);
            result.append(':');
        } 
        {
            result.append(schemeSpecificPart);
        } 
        {
            {
                result.append("//");
                result.append(authority);
            } 
            {
                result.append(path);
            } 
            {
                result.append('?');
                result.append(query);
            } 
        } 
        {
            result.append('#');
            result.append(fragment);
        } 
        string = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_551735533 = string;
        String varA7E53CE21691AB073D9660D615818899_1166463077; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1166463077 = varB4EAC82CA7396A68D541C85D26508E83_2565386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1166463077 = varB4EAC82CA7396A68D541C85D26508E83_551735533;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1166463077.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1166463077;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.159 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "F9D9ADE6CA8858DD1F15D8E12880FE4F")
    private String getHashString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1337571149 = null; 
        StringBuilder result = new StringBuilder();
        {
            result.append(scheme.toLowerCase(Locale.US));
            result.append(':');
        } 
        {
            result.append(schemeSpecificPart);
        } 
        {
            {
                result.append("//");
                {
                    result.append(authority);
                } 
                {
                    {
                        result.append(userInfo + "@");
                    } 
                    result.append(host.toLowerCase(Locale.US));
                    {
                        result.append(":" + port);
                    } 
                } 
            } 
            {
                result.append(path);
            } 
            {
                result.append('?');
                result.append(query);
            } 
        } 
        {
            result.append('#');
            result.append(fragment);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1337571149 = convertHexToLowerCase(result.toString());
        varB4EAC82CA7396A68D541C85D26508E83_1337571149.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1337571149;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.161 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "1644FD5B13CE85449A9E647216C258BC")
    public URL toURL() throws MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_118950948 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI is not absolute: " + toString());
        } 
        varB4EAC82CA7396A68D541C85D26508E83_118950948 = new URL(toString());
        varB4EAC82CA7396A68D541C85D26508E83_118950948.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_118950948;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.161 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "D3AD0A1DDD255CC4A3D1C8112E2897A2")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try 
        {
            parseURI(string, false);
        } 
        catch (URISyntaxException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(e.toString());
        } 
        addTaint(in.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.162 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "C7D2ED12519D7749B75A0205622D47DB")
    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        toString();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        
        
        
    }

    
    private static class PartEncoder extends UriCodec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.162 -0400", hash_original_field = "CAEEB9F4CCB9D7B7E16A7116D7AFB0F9", hash_generated_field = "926C47E1AC0B012F194CBD99C1600D74")

        private String extraLegalCharacters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.162 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "A3E69B2622C1BE064BB82D32FBDEA2CF")
          PartEncoder(String extraLegalCharacters) {
            this.extraLegalCharacters = extraLegalCharacters;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.162 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "04567BB4599B1C288EA310A6EEB71447")
        @Override
        protected boolean isRetained(char c) {
            boolean var0AABE6B03E9E209976286093DF507BCC_247364026 = (UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c)));
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2107339157 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2107339157;
            
            
                    
                    
                    
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "4CC2DF87C40203D819A0EB7194AEA8C8", hash_generated_field = "D9F851BAB07F16ADC844C00A2D076DA4")

    private static final long serialVersionUID = -6052424284110960213l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "E4565A1C7C15C116399C1B66D177CCAA", hash_generated_field = "708B5C1D2A5145AAE93B4DCBD1DBB016")

    static final String UNRESERVED = "_-!.~\'()*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "7827FCA6D68EBA110FDF7058ADDCAC6E", hash_generated_field = "58ACB5067A7BC64309A3619F3AD62CBB")

    static final String PUNCTUATION = ",;:$&+=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "3BA513EBF01781F5FE614A45355CD736", hash_generated_field = "E178400A95CCD95D53BB193CEC75CD16")

    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "FF5400DE12BEB032ADAE808997F25826", hash_generated_field = "BA21C0891E8446409D9F3F2B417FABAD")

    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "55B8B2D0D08ED9539700232F34BC29C6", hash_generated_field = "B3691C302E4EAFC49A0C65C2815D1A13")

    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "B5EAF2F5DF66BA195D74CD9F98F77B5D", hash_generated_field = "67FAF76CD518CC63640B971FB53CFC1C")

    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "256860EB365F0FECD50CC935A29DAE64", hash_generated_field = "E7C042F6DFADEFFCB60303B26B28DAD0")

    static final UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "28C996D087D0FFD51A4D86193699CE92", hash_generated_field = "4555E773DC35726B7DC0D99E5880A09D")

    private static final UriCodec ASCII_ONLY = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_method = "02ABED517C80D26C77E9E33853271AB3", hash_generated_method = "CA0223A78831679BA13FF2976C57894B")
        @Override
        protected boolean isRetained(char c) {
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241005729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_241005729;
            
            
        }

        
};
}

