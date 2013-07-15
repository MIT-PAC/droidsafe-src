package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;

public final class URI implements Comparable<URI>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.534 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.534 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "A77350C36FACC15543B26BF9F179A70D")

    private transient String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.534 -0400", hash_original_field = "97E7FA8F49FDF56AB2DF43BBC80E2476", hash_generated_field = "14DBC9168C32C9C014586FA7F0B8A107")

    private transient String schemeSpecificPart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.534 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "57D185265731B43622C0B461510772A9")

    private transient String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "0A24F4A69DB662BA59F12A9B09B3CA7F")

    private transient String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "D5EC92E1B3465138D54142DB3E99F34E")

    private transient int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "172D3480DA0AFB6E023B26EA00955132")

    private transient String fragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "94619F8A70068B2591C2EED622525B0E", hash_generated_field = "EDD34009E3CB727B5445D7F24CB35623")

    private transient boolean opaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "DC4D53AA0D117D8B189B36D161AF4E96", hash_generated_field = "8B0AF94FA16DD5DBCAA078866E853806")

    private transient boolean absolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.535 -0400", hash_original_field = "51622123728B411C7CCF75B702B58CC9", hash_generated_field = "D4CE8185ED9C0ACE43C0C010B0E562F4")

    private transient boolean serverAuthority = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.536 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "F58223E1E1183B179891344C3FD7FA57")

    private transient int hash = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.536 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "1BF7E280541A2A445B26B3247430EA17")
    private  URI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.536 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "14D9F285EF0C4143A3F21833924D8EC8")
    public  URI(String spec) throws URISyntaxException {
        addTaint(spec.getTaint());
        parseURI(spec, false);
        // ---------- Original Method ----------
        //parseURI(spec, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.537 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "7C807C9B2DDA0B26042D289002997F2A")
    public  URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(schemeSpecificPart.getTaint());
        addTaint(scheme.getTaint());
        StringBuilder uri = new StringBuilder();
    if(scheme != null)        
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
    if(schemeSpecificPart != null)        
        {
            ALL_LEGAL_ENCODER.appendEncoded(uri, schemeSpecificPart);
        } //End block
    if(fragment != null)        
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), false);
        // ---------- Original Method ----------
        //StringBuilder uri = new StringBuilder();
        //if (scheme != null) {
            //uri.append(scheme);
            //uri.append(':');
        //}
        //if (schemeSpecificPart != null) {
            //ALL_LEGAL_ENCODER.appendEncoded(uri, schemeSpecificPart);
        //}
        //if (fragment != null) {
            //uri.append('#');
            //ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        //}
        //parseURI(uri.toString(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.539 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "5CCEAC213837700433A63303C56A44A5")
    public  URI(String scheme, String userInfo, String host, int port, String path, String query,
            String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(query.getTaint());
        addTaint(port);
        addTaint(userInfo.getTaint());
        addTaint(scheme.getTaint());
    if(scheme == null && userInfo == null && host == null && path == null
                && query == null && fragment == null)        
        {
            this.path = "";
            return;
        } //End block
    if(scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/')        
        {
            URISyntaxException var606273C4AFC635374A21A2FA3E7D2253_299133583 = new URISyntaxException(path, "Relative path");
            var606273C4AFC635374A21A2FA3E7D2253_299133583.addTaint(taint);
            throw var606273C4AFC635374A21A2FA3E7D2253_299133583;
        } //End block
        StringBuilder uri = new StringBuilder();
    if(scheme != null)        
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
    if(userInfo != null || host != null || port != -1)        
        {
            uri.append("//");
        } //End block
    if(userInfo != null)        
        {
            USER_INFO_ENCODER.appendEncoded(uri, userInfo);
            uri.append('@');
        } //End block
    if(host != null)        
        {
    if(host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1)            
            {
                host = "[" + host + "]";
            } //End block
            uri.append(host);
        } //End block
    if(port != -1)        
        {
            uri.append(':');
            uri.append(port);
        } //End block
    if(path != null)        
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } //End block
    if(query != null)        
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } //End block
    if(fragment != null)        
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.540 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "E815DFD836DFCFACE19AD6B9025BD865")
    public  URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        addTaint(fragment.getTaint());
        addTaint(path.getTaint());
        addTaint(host.getTaint());
        addTaint(scheme.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.541 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "B9E63E0A342F38E7331ABFC3DBD4F28A")
    public  URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(query.getTaint());
        addTaint(path.getTaint());
        addTaint(authority.getTaint());
        addTaint(scheme.getTaint());
    if(scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/')        
        {
            URISyntaxException var606273C4AFC635374A21A2FA3E7D2253_558190956 = new URISyntaxException(path, "Relative path");
            var606273C4AFC635374A21A2FA3E7D2253_558190956.addTaint(taint);
            throw var606273C4AFC635374A21A2FA3E7D2253_558190956;
        } //End block
        StringBuilder uri = new StringBuilder();
    if(scheme != null)        
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
    if(authority != null)        
        {
            uri.append("//");
            AUTHORITY_ENCODER.appendEncoded(uri, authority);
        } //End block
    if(path != null)        
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } //End block
    if(query != null)        
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } //End block
    if(fragment != null)        
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.544 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "73A0C20EB6B9BFECDA4A0FFA60EA8C9F")
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        addTaint(forceServer);
        string = uri;
        int fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
    if(fragmentStart < uri.length())        
        {
            fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
        } //End block
        int start;
        int colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
    if(colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart))        
        {
            absolute = true;
            scheme = validateScheme(uri, colon);
            start = colon + 1;
    if(start == fragmentStart)            
            {
                URISyntaxException varE6BD178EC809A2E5E6292ECB2EFD9959_1371872198 = new URISyntaxException(uri, "Scheme-specific part expected", start);
                varE6BD178EC809A2E5E6292ECB2EFD9959_1371872198.addTaint(taint);
                throw varE6BD178EC809A2E5E6292ECB2EFD9959_1371872198;
            } //End block
    if(!uri.regionMatches(start, "/", 0, 1))            
            {
                opaque = true;
                schemeSpecificPart = ALL_LEGAL_ENCODER.validate(
                        uri, start, fragmentStart, "scheme specific part");
                return;
            } //End block
        } //End block
        else
        {
            absolute = false;
            start = 0;
        } //End block
        opaque = false;
        schemeSpecificPart = uri.substring(start, fragmentStart);
        int fileStart;
    if(uri.regionMatches(start, "//", 0, 2))        
        {
            int authorityStart = start + 2;
            fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
    if(authorityStart == uri.length())            
            {
                URISyntaxException varE5F5DDDD4DF3054651CDAC5E21D37F76_616144959 = new URISyntaxException(uri, "Authority expected", uri.length());
                varE5F5DDDD4DF3054651CDAC5E21D37F76_616144959.addTaint(taint);
                throw varE5F5DDDD4DF3054651CDAC5E21D37F76_616144959;
            } //End block
    if(authorityStart < fileStart)            
            {
                authority = AUTHORITY_ENCODER.validate(uri, authorityStart, fileStart, "authority");
            } //End block
        } //End block
        else
        {
            fileStart = start;
        } //End block
        int queryStart = UrlUtils.findFirstOf(uri, "?", fileStart, fragmentStart);
        path = PATH_ENCODER.validate(uri, fileStart, queryStart, "path");
    if(queryStart < fragmentStart)        
        {
            query = ALL_LEGAL_ENCODER.validate(uri, queryStart + 1, fragmentStart, "query");
        } //End block
        parseAuthority(forceServer);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.546 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "FBA1D24796F91F35C59DF12896957285")
    private String validateScheme(String uri, int end) throws URISyntaxException {
        addTaint(end);
        addTaint(uri.getTaint());
    if(end == 0)        
        {
            URISyntaxException varF39D04FAAC46BA194DC2D08E88133A73_1388609834 = new URISyntaxException(uri, "Scheme expected", 0);
            varF39D04FAAC46BA194DC2D08E88133A73_1388609834.addTaint(taint);
            throw varF39D04FAAC46BA194DC2D08E88133A73_1388609834;
        } //End block
for(int i = 0;i < end;i++)
        {
    if(!UrlUtils.isValidSchemeChar(i, uri.charAt(i)))            
            {
                URISyntaxException var4329D13E8196CBD83322FA5835D436A2_525007476 = new URISyntaxException(uri, "Illegal character in scheme", 0);
                var4329D13E8196CBD83322FA5835D436A2_525007476.addTaint(taint);
                throw var4329D13E8196CBD83322FA5835D436A2_525007476;
            } //End block
        } //End block
String var88B91DAB7AF172446DA0405A25DCBF5D_1514057416 =         uri.substring(0, end);
        var88B91DAB7AF172446DA0405A25DCBF5D_1514057416.addTaint(taint);
        return var88B91DAB7AF172446DA0405A25DCBF5D_1514057416;
        // ---------- Original Method ----------
        //if (end == 0) {
            //throw new URISyntaxException(uri, "Scheme expected", 0);
        //}
        //for (int i = 0; i < end; i++) {
            //if (!UrlUtils.isValidSchemeChar(i, uri.charAt(i))) {
                //throw new URISyntaxException(uri, "Illegal character in scheme", 0);
            //}
        //}
        //return uri.substring(0, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.548 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "0FA46C5F7BCC9C521F5AE307DCBFEE45")
    private void parseAuthority(boolean forceServer) throws URISyntaxException {
        addTaint(forceServer);
    if(authority == null)        
        {
            return;
        } //End block
        String tempUserInfo = null;
        String temp = authority;
        int index = temp.indexOf('@');
        int hostIndex = 0;
    if(index != -1)        
        {
            tempUserInfo = temp.substring(0, index);
            validateUserInfo(authority, tempUserInfo, 0);
            temp = temp.substring(index + 1);
            hostIndex = index + 1;
        } //End block
        index = temp.lastIndexOf(':');
        int endIndex = temp.indexOf(']');
        String tempHost;
        int tempPort = -1;
    if(index != -1 && endIndex < index)        
        {
            tempHost = temp.substring(0, index);
    if(index < (temp.length() - 1))            
            {
                try 
                {
                    tempPort = Integer.parseInt(temp.substring(index + 1));
    if(tempPort < 0)                    
                    {
    if(forceServer)                        
                        {
                            URISyntaxException var875316DF600DADF6C46615B2301670D8_1677449167 = new URISyntaxException(authority,
                                    "Invalid port number", hostIndex + index + 1);
                            var875316DF600DADF6C46615B2301670D8_1677449167.addTaint(taint);
                            throw var875316DF600DADF6C46615B2301670D8_1677449167;
                        } //End block
                        return;
                    } //End block
                } //End block
                catch (NumberFormatException e)
                {
    if(forceServer)                    
                    {
                        URISyntaxException var875316DF600DADF6C46615B2301670D8_1572231529 = new URISyntaxException(authority,
                                "Invalid port number", hostIndex + index + 1);
                        var875316DF600DADF6C46615B2301670D8_1572231529.addTaint(taint);
                        throw var875316DF600DADF6C46615B2301670D8_1572231529;
                    } //End block
                    return;
                } //End block
            } //End block
        } //End block
        else
        {
            tempHost = temp;
        } //End block
    if(tempHost.isEmpty())        
        {
    if(forceServer)            
            {
                URISyntaxException var6DEAE446D6E737D9D883161D87D0DED6_1226483997 = new URISyntaxException(authority, "Expected host", hostIndex);
                var6DEAE446D6E737D9D883161D87D0DED6_1226483997.addTaint(taint);
                throw var6DEAE446D6E737D9D883161D87D0DED6_1226483997;
            } //End block
            return;
        } //End block
    if(!isValidHost(forceServer, tempHost))        
        {
            return;
        } //End block
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.550 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "E5E7DF7F2D1088B709FFE82B99D90985")
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        addTaint(index);
        addTaint(userInfo.getTaint());
        addTaint(uri.getTaint());
for(int i = 0;i < userInfo.length();i++)
        {
            char ch = userInfo.charAt(i);
    if(ch == ']' || ch == '[')            
            {
                URISyntaxException varE4506A46BBF0B22912FF3B9B37349283_664498856 = new URISyntaxException(uri, "Illegal character in userInfo", index + i);
                varE4506A46BBF0B22912FF3B9B37349283_664498856.addTaint(taint);
                throw varE4506A46BBF0B22912FF3B9B37349283_664498856;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < userInfo.length(); i++) {
            //char ch = userInfo.charAt(i);
            //if (ch == ']' || ch == '[') {
                //throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.551 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "E0A263A2D5F8138EB21901CEFA632F56")
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        addTaint(host.getTaint());
        addTaint(forceServer);
    if(host.startsWith("["))        
        {
    if(!host.endsWith("]"))            
            {
                URISyntaxException varC1CCDA9CFD7EE67C26CEDAE7521698F7_144798359 = new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                varC1CCDA9CFD7EE67C26CEDAE7521698F7_144798359.addTaint(taint);
                throw varC1CCDA9CFD7EE67C26CEDAE7521698F7_144798359;
            } //End block
    if(InetAddress.isNumeric(host))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1449994457 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897524540 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897524540;
            } //End block
            URISyntaxException var7228BA494CF7AE9687C906DCE9FBD0F2_553920456 = new URISyntaxException(host, "Malformed IPv6 address");
            var7228BA494CF7AE9687C906DCE9FBD0F2_553920456.addTaint(taint);
            throw var7228BA494CF7AE9687C906DCE9FBD0F2_553920456;
        } //End block
    if(host.indexOf('[') != -1 || host.indexOf(']') != -1)        
        {
            URISyntaxException var3FFDA397BC70C9FDEB6CE98FF6268C41_1228619970 = new URISyntaxException(host, "Illegal character in host name", 0);
            var3FFDA397BC70C9FDEB6CE98FF6268C41_1228619970.addTaint(taint);
            throw var3FFDA397BC70C9FDEB6CE98FF6268C41_1228619970;
        } //End block
        int index = host.lastIndexOf('.');
    if(index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)))        
        {
    if(isValidDomainName(host))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_639510088 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_66231116 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_66231116;
            } //End block
    if(forceServer)            
            {
                URISyntaxException var3FFDA397BC70C9FDEB6CE98FF6268C41_264104513 = new URISyntaxException(host, "Illegal character in host name", 0);
                var3FFDA397BC70C9FDEB6CE98FF6268C41_264104513.addTaint(taint);
                throw var3FFDA397BC70C9FDEB6CE98FF6268C41_264104513;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2062897297 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1694243701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1694243701;
        } //End block
        try 
        {
            InetAddress ia = InetAddress.parseNumericAddress(host);
    if(ia instanceof Inet4Address)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1629372832 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192474856 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_192474856;
            } //End block
        } //End block
        catch (IllegalArgumentException ignored)
        {
        } //End block
    if(forceServer)        
        {
            URISyntaxException varFCF2313EDE5F2D7FB102130F5B76D8D0_401679066 = new URISyntaxException(host, "Malformed IPv4 address", 0);
            varFCF2313EDE5F2D7FB102130F5B76D8D0_401679066.addTaint(taint);
            throw varFCF2313EDE5F2D7FB102130F5B76D8D0_401679066;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_147823468 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274347310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274347310;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.552 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "E11E443A9D81DE328C664E27E608B043")
    private boolean isValidDomainName(String host) {
        addTaint(host.getTaint());
        try 
        {
            UriCodec.validateSimple(host, "-.");
        } //End block
        catch (URISyntaxException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_344406793 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480104835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_480104835;
        } //End block
        String lastLabel = null;
for(String token : host.split("\\."))
        {
            lastLabel = token;
    if(lastLabel.startsWith("-") || lastLabel.endsWith("-"))            
            {
                boolean var68934A3E9455FA72420237EB05902327_770688265 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714167585 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714167585;
            } //End block
        } //End block
    if(lastLabel == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1721110407 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2009727902 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2009727902;
        } //End block
    if(!lastLabel.equals(host))        
        {
            char ch = lastLabel.charAt(0);
    if(ch >= '0' && ch <= '9')            
            {
                boolean var68934A3E9455FA72420237EB05902327_869312080 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155604764 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_155604764;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_364620521 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_409838788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_409838788;
        // ---------- Original Method ----------
        //try {
            //UriCodec.validateSimple(host, "-.");
        //} catch (URISyntaxException e) {
            //return false;
        //}
        //String lastLabel = null;
        //for (String token : host.split("\\.")) {
            //lastLabel = token;
            //if (lastLabel.startsWith("-") || lastLabel.endsWith("-")) {
                //return false;
            //}
        //}
        //if (lastLabel == null) {
            //return false;
        //}
        //if (!lastLabel.equals(host)) {
            //char ch = lastLabel.charAt(0);
            //if (ch >= '0' && ch <= '9') {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.555 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "FEEF6B517AA1D875A0A91484DAF5570B")
    public int compareTo(URI uri) {
        addTaint(uri.getTaint());
        int ret;
    if(scheme == null && uri.scheme != null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_827154282 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456911281 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456911281;
        } //End block
        else
    if(scheme != null && uri.scheme == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1322891829 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007786168 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1007786168;
        } //End block
        else
    if(scheme != null && uri.scheme != null)        
        {
            ret = scheme.compareToIgnoreCase(uri.scheme);
    if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1574387591 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282439876 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282439876;
            } //End block
        } //End block
    if(!opaque && uri.opaque)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_690156747 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734318512 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734318512;
        } //End block
        else
    if(opaque && !uri.opaque)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_2047521786 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667582393 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667582393;
        } //End block
        else
    if(opaque && uri.opaque)        
        {
            ret = schemeSpecificPart.compareTo(uri.schemeSpecificPart);
    if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1900522747 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850435985 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_850435985;
            } //End block
        } //End block
        else
        {
    if(authority != null && uri.authority == null)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_239631564 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260880641 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260880641;
            } //End block
            else
    if(authority == null && uri.authority != null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_443570790 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040372254 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040372254;
            } //End block
            else
    if(authority != null && uri.authority != null)            
            {
    if(host != null && uri.host != null)                
                {
    if(userInfo != null && uri.userInfo == null)                    
                    {
                        int varC4CA4238A0B923820DCC509A6F75849B_216965635 = (1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409817646 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409817646;
                    } //End block
                    else
    if(userInfo == null && uri.userInfo != null)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_837026541 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454243753 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454243753;
                    } //End block
                    else
    if(userInfo != null && uri.userInfo != null)                    
                    {
                        ret = userInfo.compareTo(uri.userInfo);
    if(ret != 0)                        
                        {
                            int var2CB9DF9898E55FD0AD829DC202DDBD1C_1836990207 = (ret);
                                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039392930 = getTaintInt();
                            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1039392930;
                        } //End block
                    } //End block
                    ret = host.compareToIgnoreCase(uri.host);
    if(ret != 0)                    
                    {
                        int var2CB9DF9898E55FD0AD829DC202DDBD1C_791601179 = (ret);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274444658 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274444658;
                    } //End block
    if(port != uri.port)                    
                    {
                        int varDD6C6EDB19D8E1AAD69DC537A4FCF8F9_754444941 = (port - uri.port);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251604154 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1251604154;
                    } //End block
                } //End block
                else
                {
                    ret = authority.compareTo(uri.authority);
    if(ret != 0)                    
                    {
                        int var2CB9DF9898E55FD0AD829DC202DDBD1C_208525964 = (ret);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805065288 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805065288;
                    } //End block
                } //End block
            } //End block
            ret = path.compareTo(uri.path);
    if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_182720357 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028600145 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028600145;
            } //End block
    if(query != null && uri.query == null)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_567235178 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796340794 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_796340794;
            } //End block
            else
    if(query == null && uri.query != null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1969880309 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431001512 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431001512;
            } //End block
            else
    if(query != null && uri.query != null)            
            {
                ret = query.compareTo(uri.query);
    if(ret != 0)                
                {
                    int var2CB9DF9898E55FD0AD829DC202DDBD1C_1055413601 = (ret);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624348123 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624348123;
                } //End block
            } //End block
        } //End block
    if(fragment != null && uri.fragment == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_1709966899 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510189435 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_510189435;
        } //End block
        else
    if(fragment == null && uri.fragment != null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1766412739 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702712356 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702712356;
        } //End block
        else
    if(fragment != null && uri.fragment != null)        
        {
            ret = fragment.compareTo(uri.fragment);
    if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1267347865 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863107260 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1863107260;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_2033620098 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480452284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480452284;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.560 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "D1BBD3EFF676BD63C1B95FFCFD7D8D37")
    private URI duplicate() {
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
URI var3DE52045BFD3C1BF3742F994ED6139AD_1705365246 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1705365246.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1705365246;
        // ---------- Original Method ----------
        //URI clone = new URI();
        //clone.absolute = absolute;
        //clone.authority = authority;
        //clone.fragment = fragment;
        //clone.host = host;
        //clone.opaque = opaque;
        //clone.path = path;
        //clone.port = port;
        //clone.query = query;
        //clone.scheme = scheme;
        //clone.schemeSpecificPart = schemeSpecificPart;
        //clone.userInfo = userInfo;
        //clone.serverAuthority = serverAuthority;
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.561 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "F6B2CDF7B9512ECDD96F131266FD7B19")
    private String convertHexToLowerCase(String s) {
        addTaint(s.getTaint());
        StringBuilder result = new StringBuilder("");
    if(s.indexOf('%') == -1)        
        {
String var0478718F0636FB61899C13801CE9FE09_65081000 =             s;
            var0478718F0636FB61899C13801CE9FE09_65081000.addTaint(taint);
            return var0478718F0636FB61899C13801CE9FE09_65081000;
        } //End block
        int index;
        int prevIndex = 0;
        while
((index = s.indexOf('%', prevIndex)) != -1)        
        {
            result.append(s.substring(prevIndex, index + 1));
            result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
            index += 3;
            prevIndex = index;
        } //End block
String varE65B3A02759122992CB82C0E651AD408_1979074586 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1979074586.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1979074586;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder("");
        //if (s.indexOf('%') == -1) {
            //return s;
        //}
        //int index, prevIndex = 0;
        //while ((index = s.indexOf('%', prevIndex)) != -1) {
            //result.append(s.substring(prevIndex, index + 1));
            //result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
            //index += 3;
            //prevIndex = index;
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.562 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "9905400A5EB28EB60A009A8DFBD0A41F")
    private boolean escapedEquals(String first, String second) {
        addTaint(second.getTaint());
        addTaint(first.getTaint());
    if(first.indexOf('%') != second.indexOf('%'))        
        {
            boolean varB5C53BB4DB8EB6DAAFEEDCD0A507388F_1050320551 = (first.equals(second));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486296161 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_486296161;
        } //End block
        int index;
        int prevIndex = 0;
        while
((index = first.indexOf('%', prevIndex)) != -1
                && second.indexOf('%', prevIndex) == index)        
        {
            boolean match = first.substring(prevIndex, index).equals(
                    second.substring(prevIndex, index));
    if(!match)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1317283354 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42199909 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_42199909;
            } //End block
            match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    second.substring(index + 1, index + 3));
    if(!match)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2091818481 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485651382 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485651382;
            } //End block
            index += 3;
            prevIndex = index;
        } //End block
        boolean varED569683216E14F3CFB3CA8A61796E45_652279459 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938328668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938328668;
        // ---------- Original Method ----------
        //if (first.indexOf('%') != second.indexOf('%')) {
            //return first.equals(second);
        //}
        //int index, prevIndex = 0;
        //while ((index = first.indexOf('%', prevIndex)) != -1
                //&& second.indexOf('%', prevIndex) == index) {
            //boolean match = first.substring(prevIndex, index).equals(
                    //second.substring(prevIndex, index));
            //if (!match) {
                //return false;
            //}
            //match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    //second.substring(index + 1, index + 3));
            //if (!match) {
                //return false;
            //}
            //index += 3;
            //prevIndex = index;
        //}
        //return first.substring(prevIndex).equals(second.substring(prevIndex));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.564 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "1659D4A27B68A73E7D33391B83E416D9")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(!(o instanceof URI))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1575024959 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186830266 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186830266;
        } //End block
        URI uri = (URI) o;
    if(uri.fragment == null && fragment != null || uri.fragment != null
                && fragment == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2122535054 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567796744 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_567796744;
        } //End block
        else
    if(uri.fragment != null && fragment != null)        
        {
    if(!escapedEquals(uri.fragment, fragment))            
            {
                boolean var68934A3E9455FA72420237EB05902327_462756483 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681899752 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681899752;
            } //End block
        } //End block
    if(uri.scheme == null && scheme != null || uri.scheme != null
                && scheme == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_517961764 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1386285100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1386285100;
        } //End block
        else
    if(uri.scheme != null && scheme != null)        
        {
    if(!uri.scheme.equalsIgnoreCase(scheme))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1631469556 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310292736 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_310292736;
            } //End block
        } //End block
    if(uri.opaque && opaque)        
        {
            boolean var6D9222B04D62DA36DCAC0690D493E874_271426347 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662432273 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_662432273;
        } //End block
        else
    if(!uri.opaque && !opaque)        
        {
    if(!escapedEquals(path, uri.path))            
            {
                boolean var68934A3E9455FA72420237EB05902327_258558286 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1952018020 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1952018020;
            } //End block
    if(uri.query != null && query == null || uri.query == null
                    && query != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1581407667 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006989959 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006989959;
            } //End block
            else
    if(uri.query != null && query != null)            
            {
    if(!escapedEquals(uri.query, query))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_471820468 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171551746 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171551746;
                } //End block
            } //End block
    if(uri.authority != null && authority == null
                    || uri.authority == null && authority != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1927080845 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1810238490 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1810238490;
            } //End block
            else
    if(uri.authority != null && authority != null)            
            {
    if(uri.host != null && host == null || uri.host == null
                        && host != null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1724875073 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880665056 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_880665056;
                } //End block
                else
    if(uri.host == null && host == null)                
                {
                    boolean var09D1470271758B38F312B862FE8D30AD_2143525151 = (escapedEquals(uri.authority, authority));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_487310564 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_487310564;
                } //End block
                else
                {
    if(!host.equalsIgnoreCase(uri.host))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1915327905 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036293304 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036293304;
                    } //End block
    if(port != uri.port)                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_229239521 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328683669 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328683669;
                    } //End block
    if(uri.userInfo != null && userInfo == null
                            || uri.userInfo == null && userInfo != null)                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1871648746 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1566046379 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1566046379;
                    } //End block
                    else
    if(uri.userInfo != null && userInfo != null)                    
                    {
                        boolean var84DA869F5BA462D6C714D326C9E483DA_1015662329 = (escapedEquals(userInfo, uri.userInfo));
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835706581 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835706581;
                    } //End block
                    else
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1941705976 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157663639 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157663639;
                    } //End block
                } //End block
            } //End block
            else
            {
                boolean varB326B5062B2F0E69046810717534CB09_1936017247 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1481540963 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1481540963;
            } //End block
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1354548740 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666996880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_666996880;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.566 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "655AEC31BC89CA3B72163B3CB1E08856")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_490847828 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_490847828.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_490847828;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.567 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "7A164749CF6244887683058314C0E14D")
    public String getSchemeSpecificPart() {
String varC6891B577A1C9793B536A8E2A5E5B0A7_689700436 =         decode(schemeSpecificPart);
        varC6891B577A1C9793B536A8E2A5E5B0A7_689700436.addTaint(taint);
        return varC6891B577A1C9793B536A8E2A5E5B0A7_689700436;
        // ---------- Original Method ----------
        //return decode(schemeSpecificPart);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.567 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "0F17116FC4C74C3DDB86CCA6B831A1ED")
    public String getRawSchemeSpecificPart() {
String var6A488C495296D95C007DD8841ED3DB90_294689183 =         schemeSpecificPart;
        var6A488C495296D95C007DD8841ED3DB90_294689183.addTaint(taint);
        return var6A488C495296D95C007DD8841ED3DB90_294689183;
        // ---------- Original Method ----------
        //return schemeSpecificPart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.567 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "2AC8AAD12072F3662390B875FEDDCB4D")
    public String getAuthority() {
String var4595EB5232C608FD9B0E97F8A52EE93B_565316463 =         decode(authority);
        var4595EB5232C608FD9B0E97F8A52EE93B_565316463.addTaint(taint);
        return var4595EB5232C608FD9B0E97F8A52EE93B_565316463;
        // ---------- Original Method ----------
        //return decode(authority);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.568 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "3B483260D259650B53344C0E5D89C548")
    public String getRawAuthority() {
String var9A4A00E403B4898E9807F68E9EBE5A8B_547192880 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_547192880.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_547192880;
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.568 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "8895845315AE774F6F9C809803656BA0")
    public String getUserInfo() {
String var220FF434DED02F904CA93C9E15F5EAFD_1052707741 =         decode(userInfo);
        var220FF434DED02F904CA93C9E15F5EAFD_1052707741.addTaint(taint);
        return var220FF434DED02F904CA93C9E15F5EAFD_1052707741;
        // ---------- Original Method ----------
        //return decode(userInfo);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.569 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "EDC49DC4300F01D9A127389F3EC7F2E2")
    public String getRawUserInfo() {
String varBCE8ED9572054839A8E4DF19F3B230E6_1585112790 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_1585112790.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_1585112790;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.569 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "2F1E55A5E1C66218DE172029ED083FF2")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_1998688286 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1998688286.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1998688286;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.570 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "1F3843BDBB3862C56C9220B936D14D38")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1533647290 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848001552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848001552;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.571 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "0CAAB522F9063881CF3A8921A88A3D32")
    public int getEffectivePort() {
        int varCF83DA2DFAE878CA65F5EB1895EB625B_1606395952 = (getEffectivePort(scheme, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770730353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770730353;
        // ---------- Original Method ----------
        //return getEffectivePort(scheme, port);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.572 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "D1D1190CDE4EC789FF9A6DB097C388AE")
    public String getPath() {
String var64989F1F1EC3D2DC04453CC11928305C_913880697 =         decode(path);
        var64989F1F1EC3D2DC04453CC11928305C_913880697.addTaint(taint);
        return var64989F1F1EC3D2DC04453CC11928305C_913880697;
        // ---------- Original Method ----------
        //return decode(path);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.572 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "E82C6CF3E875E0D116211A0BB7B752FC")
    public String getRawPath() {
String var535F4D9720F3B0C96D8143873CE0638C_1235467089 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1235467089.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1235467089;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.573 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "93DF37ADF112A730F75AF0B98DE17AE3")
    public String getQuery() {
String var2B26850B9DB4168E47BD99701BF2A235_599706735 =         decode(query);
        var2B26850B9DB4168E47BD99701BF2A235_599706735.addTaint(taint);
        return var2B26850B9DB4168E47BD99701BF2A235_599706735;
        // ---------- Original Method ----------
        //return decode(query);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.573 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "8092495DB4A9A22CB4C3FCF39704FD69")
    public String getRawQuery() {
String varA8A0683638E4CE91D85122D8CD8F3BAC_106240863 =         query;
        varA8A0683638E4CE91D85122D8CD8F3BAC_106240863.addTaint(taint);
        return varA8A0683638E4CE91D85122D8CD8F3BAC_106240863;
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.573 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "CF6CFB58EF8278126A40F0CB98855C52")
    public String getFragment() {
String var51C0FF9344635D0490DC1E1E0E46B240_394864323 =         decode(fragment);
        var51C0FF9344635D0490DC1E1E0E46B240_394864323.addTaint(taint);
        return var51C0FF9344635D0490DC1E1E0E46B240_394864323;
        // ---------- Original Method ----------
        //return decode(fragment);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.574 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "99ACB2A2E4B615876788106091EE3CEB")
    public String getRawFragment() {
String varD266FB1A901BB0D9A16D45416C785B25_381920564 =         fragment;
        varD266FB1A901BB0D9A16D45416C785B25_381920564.addTaint(taint);
        return varD266FB1A901BB0D9A16D45416C785B25_381920564;
        // ---------- Original Method ----------
        //return fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.574 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "244870AD1A142F955421D1B362282883")
    @Override
    public int hashCode() {
    if(hash == -1)        
        {
            hash = getHashString().hashCode();
        } //End block
        int var0800FC577294C34E0B28AD2839435945_427979866 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334751890 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334751890;
        // ---------- Original Method ----------
        //if (hash == -1) {
            //hash = getHashString().hashCode();
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.575 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "C7D6D4E030EF52EDF8A11B3CD7C28265")
    public boolean isAbsolute() {
        boolean varDC4D53AA0D117D8B189B36D161AF4E96_380285902 = (absolute);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1610853676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1610853676;
        // ---------- Original Method ----------
        //return absolute;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.575 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "EC63E5D9ED026D12F3541C10721D6D17")
    public boolean isOpaque() {
        boolean var94619F8A70068B2591C2EED622525B0E_228132305 = (opaque);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618567589 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_618567589;
        // ---------- Original Method ----------
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.576 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "17258A0F02FABF382FD42012F701EC11")
    private String normalize(String path, boolean discardRelativePrefix) {
        path = UrlUtils.canonicalizePath(path, discardRelativePrefix);
        int colon = path.indexOf(':');
    if(colon != -1)        
        {
            int slash = path.indexOf('/');
    if(slash == -1 || colon < slash)            
            {
                path = "./" + path;
            } //End block
        } //End block
String var535F4D9720F3B0C96D8143873CE0638C_2137389656 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_2137389656.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_2137389656;
        // ---------- Original Method ----------
        //path = UrlUtils.canonicalizePath(path, discardRelativePrefix);
        //int colon = path.indexOf(':');
        //if (colon != -1) {
            //int slash = path.indexOf('/');
            //if (slash == -1 || colon < slash) {
                //path = "./" + path;
            //}
        //}
        //return path;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.577 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "D23B88FF9B805808C2A041A18F379E18")
    public URI normalize() {
    if(opaque)        
        {
URI var72A74007B2BE62B849F475C7BDA4658B_182753933 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_182753933.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_182753933;
        } //End block
        String normalizedPath = normalize(path, false);
    if(path.equals(normalizedPath))        
        {
URI var72A74007B2BE62B849F475C7BDA4658B_1964301345 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1964301345.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1964301345;
        } //End block
        URI result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
URI varDC838461EE2FA0CA4C9BBB70A15456B0_1633991486 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1633991486.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1633991486;
        // ---------- Original Method ----------
        //if (opaque) {
            //return this;
        //}
        //String normalizedPath = normalize(path, false);
        //if (path.equals(normalizedPath)) {
            //return this;
        //}
        //URI result = duplicate();
        //result.path = normalizedPath;
        //result.setSchemeSpecificPart();
        //return result;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.577 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "BAB3A1B4ADF32C8C75501B50A8942928")
    public URI parseServerAuthority() throws URISyntaxException {
    if(!serverAuthority)        
        {
            parseAuthority(true);
        } //End block
URI var72A74007B2BE62B849F475C7BDA4658B_702739041 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_702739041.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_702739041;
        // ---------- Original Method ----------
        //if (!serverAuthority) {
            //parseAuthority(true);
        //}
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.578 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "0DA7991D102A56AB72D51250D0D19338")
    public URI relativize(URI relative) {
    if(relative.opaque || opaque)        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1170877675 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1170877675.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1170877675;
        } //End block
    if(scheme == null ? relative.scheme != null : !scheme
                .equals(relative.scheme))        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1520031335 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1520031335.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1520031335;
        } //End block
    if(authority == null ? relative.authority != null : !authority
                .equals(relative.authority))        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1615251404 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1615251404.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1615251404;
        } //End block
        String thisPath = normalize(path, false);
        String relativePath = normalize(relative.path, false);
    if(!thisPath.equals(relativePath))        
        {
            thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
    if(!relativePath.startsWith(thisPath))            
            {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_547672043 =                 relative;
                varB3C4240352FFC7610A1E6B6AEE4AC9E6_547672043.addTaint(taint);
                return varB3C4240352FFC7610A1E6B6AEE4AC9E6_547672043;
            } //End block
        } //End block
        URI result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
URI varDC838461EE2FA0CA4C9BBB70A15456B0_971106085 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_971106085.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_971106085;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.580 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "6E861AD58069F8B44CE6EC80D209815E")
    public URI resolve(URI relative) {
    if(relative.absolute || opaque)        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_168239523 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_168239523.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_168239523;
        } //End block
    if(relative.authority != null)        
        {
            URI result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
URI varDC838461EE2FA0CA4C9BBB70A15456B0_350642938 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_350642938.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_350642938;
        } //End block
    if(relative.path.isEmpty() && relative.scheme == null && relative.query == null)        
        {
            URI result = duplicate();
            result.fragment = relative.fragment;
URI varDC838461EE2FA0CA4C9BBB70A15456B0_886175728 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_886175728.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_886175728;
        } //End block
        URI result = duplicate();
        result.fragment = relative.fragment;
        result.query = relative.query;
        String resolvedPath;
    if(relative.path.startsWith("/"))        
        {
            resolvedPath = relative.path;
        } //End block
        else
    if(relative.path.isEmpty())        
        {
            resolvedPath = path;
        } //End block
        else
        {
            int endIndex = path.lastIndexOf('/') + 1;
            resolvedPath = path.substring(0, endIndex) + relative.path;
        } //End block
        result.path = UrlUtils.authoritySafePath(result.authority, normalize(resolvedPath, true));
        result.setSchemeSpecificPart();
URI varDC838461EE2FA0CA4C9BBB70A15456B0_256002272 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_256002272.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_256002272;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.583 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "4ED8B0EDF42D95602712173E78B58A92")
    private void setSchemeSpecificPart() {
        StringBuilder ssp = new StringBuilder();
    if(authority != null)        
        {
            ssp.append("//" + authority);
        } //End block
    if(path != null)        
        {
            ssp.append(path);
        } //End block
    if(query != null)        
        {
            ssp.append("?" + query);
        } //End block
        schemeSpecificPart = ssp.toString();
        string = null;
        // ---------- Original Method ----------
        //StringBuilder ssp = new StringBuilder();
        //if (authority != null) {
            //ssp.append("//" + authority);
        //}
        //if (path != null) {
            //ssp.append(path);
        //}
        //if (query != null) {
            //ssp.append("?" + query);
        //}
        //schemeSpecificPart = ssp.toString();
        //string = null;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.583 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "F919B79F1190180D66422B203FEE8E33")
    public URI resolve(String relative) {
        addTaint(relative.getTaint());
URI var6EDC2CB917A200A202A3C7444E2D29E2_859199367 =         resolve(create(relative));
        var6EDC2CB917A200A202A3C7444E2D29E2_859199367.addTaint(taint);
        return var6EDC2CB917A200A202A3C7444E2D29E2_859199367;
        // ---------- Original Method ----------
        //return resolve(create(relative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.584 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "D5886D9554B1E4C3B32C800261D636D9")
    private String decode(String s) {
        addTaint(s.getTaint());
String var4CC69FF2A8688969A578CF3D5F5AE170_1573288330 =         s != null ? UriCodec.decode(s) : null;
        var4CC69FF2A8688969A578CF3D5F5AE170_1573288330.addTaint(taint);
        return var4CC69FF2A8688969A578CF3D5F5AE170_1573288330;
        // ---------- Original Method ----------
        //return s != null ? UriCodec.decode(s) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.584 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "DD783677282E2FAE38DF4695B34679FA")
    public String toASCIIString() {
        StringBuilder result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
String varE65B3A02759122992CB82C0E651AD408_282185878 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_282185878.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_282185878;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //ASCII_ONLY.appendEncoded(result, toString());
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.585 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "65622D5B2496F761A78DF5F2EB8EAFC9")
    @Override
    public String toString() {
    if(string != null)        
        {
String varDCF8A90B03379D9C1C8BF337A3879E0C_1424282453 =             string;
            varDCF8A90B03379D9C1C8BF337A3879E0C_1424282453.addTaint(taint);
            return varDCF8A90B03379D9C1C8BF337A3879E0C_1424282453;
        } //End block
        StringBuilder result = new StringBuilder();
    if(scheme != null)        
        {
            result.append(scheme);
            result.append(':');
        } //End block
    if(opaque)        
        {
            result.append(schemeSpecificPart);
        } //End block
        else
        {
    if(authority != null)            
            {
                result.append("//");
                result.append(authority);
            } //End block
    if(path != null)            
            {
                result.append(path);
            } //End block
    if(query != null)            
            {
                result.append('?');
                result.append(query);
            } //End block
        } //End block
    if(fragment != null)        
        {
            result.append('#');
            result.append(fragment);
        } //End block
        string = result.toString();
String varDCF8A90B03379D9C1C8BF337A3879E0C_247619897 =         string;
        varDCF8A90B03379D9C1C8BF337A3879E0C_247619897.addTaint(taint);
        return varDCF8A90B03379D9C1C8BF337A3879E0C_247619897;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.586 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "BE51ECD3F572B74DC6645AC129D1C1D3")
    private String getHashString() {
        StringBuilder result = new StringBuilder();
    if(scheme != null)        
        {
            result.append(scheme.toLowerCase(Locale.US));
            result.append(':');
        } //End block
    if(opaque)        
        {
            result.append(schemeSpecificPart);
        } //End block
        else
        {
    if(authority != null)            
            {
                result.append("//");
    if(host == null)                
                {
                    result.append(authority);
                } //End block
                else
                {
    if(userInfo != null)                    
                    {
                        result.append(userInfo + "@");
                    } //End block
                    result.append(host.toLowerCase(Locale.US));
    if(port != -1)                    
                    {
                        result.append(":" + port);
                    } //End block
                } //End block
            } //End block
    if(path != null)            
            {
                result.append(path);
            } //End block
    if(query != null)            
            {
                result.append('?');
                result.append(query);
            } //End block
        } //End block
    if(fragment != null)        
        {
            result.append('#');
            result.append(fragment);
        } //End block
String var6E684D9B8DA835CC8A13C4D3E99458C8_2144223290 =         convertHexToLowerCase(result.toString());
        var6E684D9B8DA835CC8A13C4D3E99458C8_2144223290.addTaint(taint);
        return var6E684D9B8DA835CC8A13C4D3E99458C8_2144223290;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.595 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "DE70C1E63A8F7F63A6996949EBC0B082")
    public URL toURL() throws MalformedURLException {
    if(!absolute)        
        {
            IllegalArgumentException varCA03E1D228906D4821F7E9CA2889020B_100999008 = new IllegalArgumentException("URI is not absolute: " + toString());
            varCA03E1D228906D4821F7E9CA2889020B_100999008.addTaint(taint);
            throw varCA03E1D228906D4821F7E9CA2889020B_100999008;
        } //End block
URL varDABA914D840E6D43A1E159EFF2D2A3B3_772498532 =         new URL(toString());
        varDABA914D840E6D43A1E159EFF2D2A3B3_772498532.addTaint(taint);
        return varDABA914D840E6D43A1E159EFF2D2A3B3_772498532;
        // ---------- Original Method ----------
        //if (!absolute) {
            //throw new IllegalArgumentException("URI is not absolute: " + toString());
        //}
        //return new URL(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.601 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "86D4916ECF3C36535597A0259CA73AA8")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        try 
        {
            parseURI(string, false);
        } //End block
        catch (URISyntaxException e)
        {
            IOException varD719BE8874BDDFB77470A93D35CFE9F1_1193313353 = new IOException(e.toString());
            varD719BE8874BDDFB77470A93D35CFE9F1_1193313353.addTaint(taint);
            throw varD719BE8874BDDFB77470A93D35CFE9F1_1193313353;
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //try {
            //parseURI(string, false);
        //} catch (URISyntaxException e) {
            //throw new IOException(e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.601 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "64ECA8697047437409628550606FC4E7")
    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        addTaint(out.getTaint());
        toString();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //toString();
        //out.defaultWriteObject();
    }

    
    private static class PartEncoder extends UriCodec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.602 -0400", hash_original_field = "CAEEB9F4CCB9D7B7E16A7116D7AFB0F9", hash_generated_field = "926C47E1AC0B012F194CBD99C1600D74")

        private String extraLegalCharacters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.604 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "A3E69B2622C1BE064BB82D32FBDEA2CF")
          PartEncoder(String extraLegalCharacters) {
            this.extraLegalCharacters = extraLegalCharacters;
            // ---------- Original Method ----------
            //this.extraLegalCharacters = extraLegalCharacters;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.606 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "86A69B09CB9F5D1D781A83D97AF8BDC2")
        @Override
        protected boolean isRetained(char c) {
            addTaint(c);
            boolean var71900A39755553C87F349ECDFF1CA04F_159120375 = (UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631653336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631653336;
            // ---------- Original Method ----------
            //return UNRESERVED.indexOf(c) != -1
                    //|| PUNCTUATION.indexOf(c) != -1
                    //|| extraLegalCharacters.indexOf(c) != -1
                    //|| (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c));
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.607 -0400", hash_original_field = "4CC2DF87C40203D819A0EB7194AEA8C8", hash_generated_field = "D9F851BAB07F16ADC844C00A2D076DA4")

    private static final long serialVersionUID = -6052424284110960213l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.607 -0400", hash_original_field = "E4565A1C7C15C116399C1B66D177CCAA", hash_generated_field = "708B5C1D2A5145AAE93B4DCBD1DBB016")

    static final String UNRESERVED = "_-!.~\'()*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.608 -0400", hash_original_field = "7827FCA6D68EBA110FDF7058ADDCAC6E", hash_generated_field = "58ACB5067A7BC64309A3619F3AD62CBB")

    static final String PUNCTUATION = ",;:$&+=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.608 -0400", hash_original_field = "3BA513EBF01781F5FE614A45355CD736", hash_generated_field = "E178400A95CCD95D53BB193CEC75CD16")

    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.608 -0400", hash_original_field = "FF5400DE12BEB032ADAE808997F25826", hash_generated_field = "BA21C0891E8446409D9F3F2B417FABAD")

    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.608 -0400", hash_original_field = "55B8B2D0D08ED9539700232F34BC29C6", hash_generated_field = "B3691C302E4EAFC49A0C65C2815D1A13")

    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.609 -0400", hash_original_field = "B5EAF2F5DF66BA195D74CD9F98F77B5D", hash_generated_field = "67FAF76CD518CC63640B971FB53CFC1C")

    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.609 -0400", hash_original_field = "256860EB365F0FECD50CC935A29DAE64", hash_generated_field = "E7C042F6DFADEFFCB60303B26B28DAD0")

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

