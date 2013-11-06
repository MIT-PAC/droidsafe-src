package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;

import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;





public final class URI implements Comparable<URI>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.825 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    @DSVAModeled
    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.825 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "A77350C36FACC15543B26BF9F179A70D")

    private transient String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.825 -0400", hash_original_field = "97E7FA8F49FDF56AB2DF43BBC80E2476", hash_generated_field = "14DBC9168C32C9C014586FA7F0B8A107")

    private transient String schemeSpecificPart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "57D185265731B43622C0B461510772A9")

    private transient String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "0A24F4A69DB662BA59F12A9B09B3CA7F")

    private transient String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "D5EC92E1B3465138D54142DB3E99F34E")

    private transient int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "172D3480DA0AFB6E023B26EA00955132")

    private transient String fragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "94619F8A70068B2591C2EED622525B0E", hash_generated_field = "EDD34009E3CB727B5445D7F24CB35623")

    private transient boolean opaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "DC4D53AA0D117D8B189B36D161AF4E96", hash_generated_field = "8B0AF94FA16DD5DBCAA078866E853806")

    private transient boolean absolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "51622123728B411C7CCF75B702B58CC9", hash_generated_field = "D4CE8185ED9C0ACE43C0C010B0E562F4")

    private transient boolean serverAuthority = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "F58223E1E1183B179891344C3FD7FA57")

    private transient int hash = -1;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.826 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "1BF7E280541A2A445B26B3247430EA17")
    private  URI() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.827 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "14D9F285EF0C4143A3F21833924D8EC8")
    public  URI(String spec) throws URISyntaxException {
        addTaint(spec.getTaint());
        string = spec;
       // parseURI(spec, false);
        // ---------- Original Method ----------
        //parseURI(spec, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.827 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "7C807C9B2DDA0B26042D289002997F2A")
    public  URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(schemeSpecificPart.getTaint());
        addTaint(scheme.getTaint());
        string = scheme + ":" + schemeSpecificPart + "#" + fragment;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.828 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "DF265733E36A95658C1C0396ED83E00D")
    public  URI(String scheme, String userInfo, String host, int port, String path, String query,
            String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(query.getTaint());
        addTaint(port);
        addTaint(userInfo.getTaint());
        addTaint(scheme.getTaint());
     
        string = scheme + " " + userInfo + " " + host + " " + port + " " + path + " " + query + " " + fragment;
        
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.829 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "E815DFD836DFCFACE19AD6B9025BD865")
    public  URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        addTaint(fragment.getTaint());
        addTaint(path.getTaint());
        addTaint(host.getTaint());
        addTaint(scheme.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.830 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "2ECCFC3325121242CFD04A6F46E193C8")
    public  URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        addTaint(fragment.getTaint());
        addTaint(query.getTaint());
        addTaint(path.getTaint());
        addTaint(authority.getTaint());
        addTaint(scheme.getTaint());
        string = scheme + " " + authority + " " + path + " " + query + " " + fragment;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.834 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "DA9CABC9B9E9A98017F63ABE4B6F2FF1")
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        addTaint(forceServer);
        string = uri;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.834 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "061C89AF9DF211EB75C8C127D4FCD155")
    private String validateScheme(String uri, int end) throws URISyntaxException {
        addTaint(end);
        addTaint(uri.getTaint());
        if(end == 0)        
        {
            URISyntaxException varF39D04FAAC46BA194DC2D08E88133A73_717582891 = new URISyntaxException(uri, "Scheme expected", 0);
            varF39D04FAAC46BA194DC2D08E88133A73_717582891.addTaint(taint);
            throw varF39D04FAAC46BA194DC2D08E88133A73_717582891;
        } //End block
for(int i = 0;i < end;i++)
        {
            if(!UrlUtils.isValidSchemeChar(i, uri.charAt(i)))            
            {
                URISyntaxException var4329D13E8196CBD83322FA5835D436A2_1405559940 = new URISyntaxException(uri, "Illegal character in scheme", 0);
                var4329D13E8196CBD83322FA5835D436A2_1405559940.addTaint(taint);
                throw var4329D13E8196CBD83322FA5835D436A2_1405559940;
            } //End block
        } //End block
String var88B91DAB7AF172446DA0405A25DCBF5D_1934527842 =         uri.substring(0, end);
        var88B91DAB7AF172446DA0405A25DCBF5D_1934527842.addTaint(taint);
        return var88B91DAB7AF172446DA0405A25DCBF5D_1934527842;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.835 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "B4534D2BF6486EA21365E262534DE5C2")
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
                            URISyntaxException var875316DF600DADF6C46615B2301670D8_1305274089 = new URISyntaxException(authority,
                                    "Invalid port number", hostIndex + index + 1);
                            var875316DF600DADF6C46615B2301670D8_1305274089.addTaint(taint);
                            throw var875316DF600DADF6C46615B2301670D8_1305274089;
                        } //End block
                        return;
                    } //End block
                } //End block
                catch (NumberFormatException e)
                {
                    if(forceServer)                    
                    {
                        URISyntaxException var875316DF600DADF6C46615B2301670D8_1218709919 = new URISyntaxException(authority,
                                "Invalid port number", hostIndex + index + 1);
                        var875316DF600DADF6C46615B2301670D8_1218709919.addTaint(taint);
                        throw var875316DF600DADF6C46615B2301670D8_1218709919;
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
                URISyntaxException var6DEAE446D6E737D9D883161D87D0DED6_1460065022 = new URISyntaxException(authority, "Expected host", hostIndex);
                var6DEAE446D6E737D9D883161D87D0DED6_1460065022.addTaint(taint);
                throw var6DEAE446D6E737D9D883161D87D0DED6_1460065022;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.835 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "8F2FC7A4C7DFBCB42F266BBF7E6E9245")
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        addTaint(index);
        addTaint(userInfo.getTaint());
        addTaint(uri.getTaint());
for(int i = 0;i < userInfo.length();i++)
        {
            char ch = userInfo.charAt(i);
            if(ch == ']' || ch == '[')            
            {
                URISyntaxException varE4506A46BBF0B22912FF3B9B37349283_1011366570 = new URISyntaxException(uri, "Illegal character in userInfo", index + i);
                varE4506A46BBF0B22912FF3B9B37349283_1011366570.addTaint(taint);
                throw varE4506A46BBF0B22912FF3B9B37349283_1011366570;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.836 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "D9F71D2E885D69732A7DD916D139AF49")
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        addTaint(host.getTaint());
        addTaint(forceServer);
        if(host.startsWith("["))        
        {
            if(!host.endsWith("]"))            
            {
                URISyntaxException varC1CCDA9CFD7EE67C26CEDAE7521698F7_635049625 = new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                varC1CCDA9CFD7EE67C26CEDAE7521698F7_635049625.addTaint(taint);
                throw varC1CCDA9CFD7EE67C26CEDAE7521698F7_635049625;
            } //End block
            if(InetAddress.isNumeric(host))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1089553991 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252877947 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252877947;
            } //End block
            URISyntaxException var7228BA494CF7AE9687C906DCE9FBD0F2_258458970 = new URISyntaxException(host, "Malformed IPv6 address");
            var7228BA494CF7AE9687C906DCE9FBD0F2_258458970.addTaint(taint);
            throw var7228BA494CF7AE9687C906DCE9FBD0F2_258458970;
        } //End block
        if(host.indexOf('[') != -1 || host.indexOf(']') != -1)        
        {
            URISyntaxException var3FFDA397BC70C9FDEB6CE98FF6268C41_447774913 = new URISyntaxException(host, "Illegal character in host name", 0);
            var3FFDA397BC70C9FDEB6CE98FF6268C41_447774913.addTaint(taint);
            throw var3FFDA397BC70C9FDEB6CE98FF6268C41_447774913;
        } //End block
        int index = host.lastIndexOf('.');
        if(index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)))        
        {
            if(isValidDomainName(host))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_639506120 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958049125 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958049125;
            } //End block
            if(forceServer)            
            {
                URISyntaxException var3FFDA397BC70C9FDEB6CE98FF6268C41_1153236948 = new URISyntaxException(host, "Illegal character in host name", 0);
                var3FFDA397BC70C9FDEB6CE98FF6268C41_1153236948.addTaint(taint);
                throw var3FFDA397BC70C9FDEB6CE98FF6268C41_1153236948;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1498884669 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_281967060 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_281967060;
        } //End block
        try 
        {
            InetAddress ia = InetAddress.parseNumericAddress(host);
            if(ia instanceof Inet4Address)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1972639284 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1970941860 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1970941860;
            } //End block
        } //End block
        catch (IllegalArgumentException ignored)
        {
        } //End block
        if(forceServer)        
        {
            URISyntaxException varFCF2313EDE5F2D7FB102130F5B76D8D0_504205144 = new URISyntaxException(host, "Malformed IPv4 address", 0);
            varFCF2313EDE5F2D7FB102130F5B76D8D0_504205144.addTaint(taint);
            throw varFCF2313EDE5F2D7FB102130F5B76D8D0_504205144;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2081879870 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147120095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147120095;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.836 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "58B3707B150D729C43551183F0556748")
    private boolean isValidDomainName(String host) {
        addTaint(host.getTaint());
        try 
        {
            UriCodec.validateSimple(host, "-.");
        } //End block
        catch (URISyntaxException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_462368297 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130293961 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130293961;
        } //End block
        String lastLabel = null;
for(String token : host.split("\\."))
        {
            lastLabel = token;
            if(lastLabel.startsWith("-") || lastLabel.endsWith("-"))            
            {
                boolean var68934A3E9455FA72420237EB05902327_69634831 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90966665 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_90966665;
            } //End block
        } //End block
        if(lastLabel == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_438042172 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946169590 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_946169590;
        } //End block
        if(!lastLabel.equals(host))        
        {
            char ch = lastLabel.charAt(0);
            if(ch >= '0' && ch <= '9')            
            {
                boolean var68934A3E9455FA72420237EB05902327_872321064 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427854809 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_427854809;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2033040171 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323608361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_323608361;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.838 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "BF679553DC4C5BFD702B8D4975B468AE")
    public int compareTo(URI uri) {
        addTaint(uri.getTaint());
        int ret;
        if(scheme == null && uri.scheme != null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_985998479 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198360613 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1198360613;
        } //End block
        else
        if(scheme != null && uri.scheme == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_395059393 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870506720 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_870506720;
        } //End block
        else
        if(scheme != null && uri.scheme != null)        
        {
            ret = scheme.compareToIgnoreCase(uri.scheme);
            if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1878782116 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122795759 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122795759;
            } //End block
        } //End block
        if(!opaque && uri.opaque)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1661058904 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237218196 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237218196;
        } //End block
        else
        if(opaque && !uri.opaque)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_436668576 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706560092 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_706560092;
        } //End block
        else
        if(opaque && uri.opaque)        
        {
            ret = schemeSpecificPart.compareTo(uri.schemeSpecificPart);
            if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1203343063 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117140130 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2117140130;
            } //End block
        } //End block
        else
        {
            if(authority != null && uri.authority == null)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1205536503 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778175986 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778175986;
            } //End block
            else
            if(authority == null && uri.authority != null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_2102141 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500691106 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500691106;
            } //End block
            else
            if(authority != null && uri.authority != null)            
            {
                if(host != null && uri.host != null)                
                {
                    if(userInfo != null && uri.userInfo == null)                    
                    {
                        int varC4CA4238A0B923820DCC509A6F75849B_1371292618 = (1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699682663 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699682663;
                    } //End block
                    else
                    if(userInfo == null && uri.userInfo != null)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_1611316830 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487278454 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487278454;
                    } //End block
                    else
                    if(userInfo != null && uri.userInfo != null)                    
                    {
                        ret = userInfo.compareTo(uri.userInfo);
                        if(ret != 0)                        
                        {
                            int var2CB9DF9898E55FD0AD829DC202DDBD1C_1003192562 = (ret);
                                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425720488 = getTaintInt();
                            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425720488;
                        } //End block
                    } //End block
                    ret = host.compareToIgnoreCase(uri.host);
                    if(ret != 0)                    
                    {
                        int var2CB9DF9898E55FD0AD829DC202DDBD1C_258941578 = (ret);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580214560 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_580214560;
                    } //End block
                    if(port != uri.port)                    
                    {
                        int varDD6C6EDB19D8E1AAD69DC537A4FCF8F9_467662231 = (port - uri.port);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992704772 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992704772;
                    } //End block
                } //End block
                else
                {
                    ret = authority.compareTo(uri.authority);
                    if(ret != 0)                    
                    {
                        int var2CB9DF9898E55FD0AD829DC202DDBD1C_637863680 = (ret);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539440980 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1539440980;
                    } //End block
                } //End block
            } //End block
            ret = path.compareTo(uri.path);
            if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1518301936 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537348600 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1537348600;
            } //End block
            if(query != null && uri.query == null)            
            {
                int varC4CA4238A0B923820DCC509A6F75849B_1455043080 = (1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424415018 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_424415018;
            } //End block
            else
            if(query == null && uri.query != null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1953400971 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993295028 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_993295028;
            } //End block
            else
            if(query != null && uri.query != null)            
            {
                ret = query.compareTo(uri.query);
                if(ret != 0)                
                {
                    int var2CB9DF9898E55FD0AD829DC202DDBD1C_794719807 = (ret);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193136097 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_193136097;
                } //End block
            } //End block
        } //End block
        if(fragment != null && uri.fragment == null)        
        {
            int varC4CA4238A0B923820DCC509A6F75849B_714793640 = (1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894947442 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_894947442;
        } //End block
        else
        if(fragment == null && uri.fragment != null)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_946103026 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875065174 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875065174;
        } //End block
        else
        if(fragment != null && uri.fragment != null)        
        {
            ret = fragment.compareTo(uri.fragment);
            if(ret != 0)            
            {
                int var2CB9DF9898E55FD0AD829DC202DDBD1C_1861576014 = (ret);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738557994 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_738557994;
            } //End block
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_752533997 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34278334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34278334;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.839 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "6062D929F5B1AFE9A883868ED62B6B07")
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
URI var3DE52045BFD3C1BF3742F994ED6139AD_155443741 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_155443741.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_155443741;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.840 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "047B63C630D92D15F9B63C64E6537ADF")
    private String convertHexToLowerCase(String s) {
        addTaint(s.getTaint());
        StringBuilder result = new StringBuilder("");
        if(s.indexOf('%') == -1)        
        {
String var0478718F0636FB61899C13801CE9FE09_1462795066 =             s;
            var0478718F0636FB61899C13801CE9FE09_1462795066.addTaint(taint);
            return var0478718F0636FB61899C13801CE9FE09_1462795066;
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
String varE65B3A02759122992CB82C0E651AD408_1864994828 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1864994828.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1864994828;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.840 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "E587029A7753CF14F7C1F89961A9CD8D")
    private boolean escapedEquals(String first, String second) {
        addTaint(second.getTaint());
        addTaint(first.getTaint());
        if(first.indexOf('%') != second.indexOf('%'))        
        {
            boolean varB5C53BB4DB8EB6DAAFEEDCD0A507388F_880989750 = (first.equals(second));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68620522 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_68620522;
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
                boolean var68934A3E9455FA72420237EB05902327_1008266388 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416269135 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416269135;
            } //End block
            match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    second.substring(index + 1, index + 3));
            if(!match)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1720414888 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309488192 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_309488192;
            } //End block
            index += 3;
            prevIndex = index;
        } //End block
        boolean varED569683216E14F3CFB3CA8A61796E45_204271103 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1056874436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1056874436;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.841 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "5E98C10F44BCEB7FE097B646DD5922B6")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(!(o instanceof URI))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1596062246 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921892831 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_921892831;
        } //End block
        URI uri = (URI) o;
        if(uri.fragment == null && fragment != null || uri.fragment != null
                && fragment == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2001729380 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460115831 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_460115831;
        } //End block
        else
        if(uri.fragment != null && fragment != null)        
        {
            if(!escapedEquals(uri.fragment, fragment))            
            {
                boolean var68934A3E9455FA72420237EB05902327_929216831 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956379467 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956379467;
            } //End block
        } //End block
        if(uri.scheme == null && scheme != null || uri.scheme != null
                && scheme == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_697589941 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839106563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839106563;
        } //End block
        else
        if(uri.scheme != null && scheme != null)        
        {
            if(!uri.scheme.equalsIgnoreCase(scheme))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1340251981 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843837711 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_843837711;
            } //End block
        } //End block
        if(uri.opaque && opaque)        
        {
            boolean var6D9222B04D62DA36DCAC0690D493E874_2001528112 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518269629 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518269629;
        } //End block
        else
        if(!uri.opaque && !opaque)        
        {
            if(!escapedEquals(path, uri.path))            
            {
                boolean var68934A3E9455FA72420237EB05902327_145994449 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_650837205 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_650837205;
            } //End block
            if(uri.query != null && query == null || uri.query == null
                    && query != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_777156765 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_23218783 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_23218783;
            } //End block
            else
            if(uri.query != null && query != null)            
            {
                if(!escapedEquals(uri.query, query))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1325038058 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048357849 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048357849;
                } //End block
            } //End block
            if(uri.authority != null && authority == null
                    || uri.authority == null && authority != null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_534057495 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736239874 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_736239874;
            } //End block
            else
            if(uri.authority != null && authority != null)            
            {
                if(uri.host != null && host == null || uri.host == null
                        && host != null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1105732387 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965993475 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965993475;
                } //End block
                else
                if(uri.host == null && host == null)                
                {
                    boolean var09D1470271758B38F312B862FE8D30AD_1088724987 = (escapedEquals(uri.authority, authority));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768396320 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768396320;
                } //End block
                else
                {
                    if(!host.equalsIgnoreCase(uri.host))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1665610679 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890148128 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890148128;
                    } //End block
                    if(port != uri.port)                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1346135070 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356567743 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356567743;
                    } //End block
                    if(uri.userInfo != null && userInfo == null
                            || uri.userInfo == null && userInfo != null)                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_138531579 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1563292925 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1563292925;
                    } //End block
                    else
                    if(uri.userInfo != null && userInfo != null)                    
                    {
                        boolean var84DA869F5BA462D6C714D326C9E483DA_1222932645 = (escapedEquals(userInfo, uri.userInfo));
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70119406 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70119406;
                    } //End block
                    else
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_171572015 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154672064 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154672064;
                    } //End block
                } //End block
            } //End block
            else
            {
                boolean varB326B5062B2F0E69046810717534CB09_63079239 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48704314 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_48704314;
            } //End block
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1314363260 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104456848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104456848;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "3B99013FEA1916337F028BB6F5863934")
    public String getScheme() {
String varFD3305CF8340E40F0AC0AB554909AEBC_815254694 =         scheme;
        varFD3305CF8340E40F0AC0AB554909AEBC_815254694.addTaint(taint);
        return varFD3305CF8340E40F0AC0AB554909AEBC_815254694;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "6CAF2315C4521FE957E187721A4FF4FC")
    public String getSchemeSpecificPart() {
String varC6891B577A1C9793B536A8E2A5E5B0A7_967730278 =         decode(schemeSpecificPart);
        varC6891B577A1C9793B536A8E2A5E5B0A7_967730278.addTaint(taint);
        return varC6891B577A1C9793B536A8E2A5E5B0A7_967730278;
        // ---------- Original Method ----------
        //return decode(schemeSpecificPart);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "8AD351C9920CD2492FAEC78A92E9AFCB")
    public String getRawSchemeSpecificPart() {
String var6A488C495296D95C007DD8841ED3DB90_381862790 =         schemeSpecificPart;
        var6A488C495296D95C007DD8841ED3DB90_381862790.addTaint(taint);
        return var6A488C495296D95C007DD8841ED3DB90_381862790;
        // ---------- Original Method ----------
        //return schemeSpecificPart;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "1CB4EDB74936F69097584936C8D355D6")
    public String getAuthority() {
String var4595EB5232C608FD9B0E97F8A52EE93B_2123579160 =         decode(authority);
        var4595EB5232C608FD9B0E97F8A52EE93B_2123579160.addTaint(taint);
        return var4595EB5232C608FD9B0E97F8A52EE93B_2123579160;
        // ---------- Original Method ----------
        //return decode(authority);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "81097E25EE0DDBCA5F7AAA7EB2839DBF")
    public String getRawAuthority() {
String var9A4A00E403B4898E9807F68E9EBE5A8B_1549770146 =         authority;
        var9A4A00E403B4898E9807F68E9EBE5A8B_1549770146.addTaint(taint);
        return var9A4A00E403B4898E9807F68E9EBE5A8B_1549770146;
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "F3EB51A38A6E8184F0CBA7B12F32AE93")
    public String getUserInfo() {
String var220FF434DED02F904CA93C9E15F5EAFD_1853738699 =         decode(userInfo);
        var220FF434DED02F904CA93C9E15F5EAFD_1853738699.addTaint(taint);
        return var220FF434DED02F904CA93C9E15F5EAFD_1853738699;
        // ---------- Original Method ----------
        //return decode(userInfo);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "64E7C9D4FB983DB36D1B1B3283BEBDBD")
    public String getRawUserInfo() {
String varBCE8ED9572054839A8E4DF19F3B230E6_181980778 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_181980778.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_181980778;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "5FA4242420DDF58890BF93429189055B")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_2069881997 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_2069881997.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_2069881997;
        // ---------- Original Method ----------
        //return host;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.842 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "B05F9CCDF4578A8898A736F8CF3DA1ED")
    public int getPort() {
        int var901555FB06E346CB065CEB9808DCFC25_1335563017 = (port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958478541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_958478541;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "50A54364BC122DB830BF80D6A12DE343")
    public int getEffectivePort() {
        int varCF83DA2DFAE878CA65F5EB1895EB625B_1667528691 = (getEffectivePort(scheme, port));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263221509 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263221509;
        // ---------- Original Method ----------
        //return getEffectivePort(scheme, port);
    }

    
    @DSModeled(DSC.BAN)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "D9DEBC3B747EF72A558CA77B7A8EF82F")
    public String getPath() {
String var64989F1F1EC3D2DC04453CC11928305C_213056145 =         decode(path);
        var64989F1F1EC3D2DC04453CC11928305C_213056145.addTaint(taint);
        return var64989F1F1EC3D2DC04453CC11928305C_213056145;
        // ---------- Original Method ----------
        //return decode(path);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "2E45E9D6556069F25EF1FC4BBA72F31A")
    public String getRawPath() {
String var535F4D9720F3B0C96D8143873CE0638C_247448192 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_247448192.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_247448192;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "F6FCBA81E4210548AE17B95FFA964425")
    public String getQuery() {
String var2B26850B9DB4168E47BD99701BF2A235_965897286 =         decode(query);
        var2B26850B9DB4168E47BD99701BF2A235_965897286.addTaint(taint);
        return var2B26850B9DB4168E47BD99701BF2A235_965897286;
        // ---------- Original Method ----------
        //return decode(query);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "863BAA4E09E68B0A2A58ED0F8FDC06E4")
    public String getRawQuery() {
String varA8A0683638E4CE91D85122D8CD8F3BAC_800970241 =         query;
        varA8A0683638E4CE91D85122D8CD8F3BAC_800970241.addTaint(taint);
        return varA8A0683638E4CE91D85122D8CD8F3BAC_800970241;
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "FACE759A9CA8ADCA088716722D290656")
    public String getFragment() {
String var51C0FF9344635D0490DC1E1E0E46B240_1729148347 =         decode(fragment);
        var51C0FF9344635D0490DC1E1E0E46B240_1729148347.addTaint(taint);
        return var51C0FF9344635D0490DC1E1E0E46B240_1729148347;
        // ---------- Original Method ----------
        //return decode(fragment);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "81964A06FCBF3CE923B069DBB945B599")
    public String getRawFragment() {
String varD266FB1A901BB0D9A16D45416C785B25_1022728937 =         fragment;
        varD266FB1A901BB0D9A16D45416C785B25_1022728937.addTaint(taint);
        return varD266FB1A901BB0D9A16D45416C785B25_1022728937;
        // ---------- Original Method ----------
        //return fragment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "65543983F39456BAB1098360CC235754")
    @Override
    public int hashCode() {
        if(hash == -1)        
        {
            hash = getHashString().hashCode();
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1341764189 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086577585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2086577585;
        // ---------- Original Method ----------
        //if (hash == -1) {
            //hash = getHashString().hashCode();
        //}
        //return hash;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "D9D6524FC26FA50747137F12D5C33159")
    public boolean isAbsolute() {
        boolean varDC4D53AA0D117D8B189B36D161AF4E96_17767121 = (absolute);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1254268912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1254268912;
        // ---------- Original Method ----------
        //return absolute;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.843 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "FCDCAF7937C2DBF71240215D1BDE58A4")
    public boolean isOpaque() {
        boolean var94619F8A70068B2591C2EED622525B0E_2131621175 = (opaque);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493650029 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493650029;
        // ---------- Original Method ----------
        //return opaque;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.844 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "D5E58ACC38AC33591A27F1EA16051FF8")
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
String var535F4D9720F3B0C96D8143873CE0638C_1767892533 =         path;
        var535F4D9720F3B0C96D8143873CE0638C_1767892533.addTaint(taint);
        return var535F4D9720F3B0C96D8143873CE0638C_1767892533;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.844 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "30999A4716A0C42737AF2EE2D9E1FF07")
    public URI normalize() {
        if(opaque)        
        {
URI var72A74007B2BE62B849F475C7BDA4658B_15447775 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_15447775.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_15447775;
        } //End block
        String normalizedPath = normalize(path, false);
        if(path.equals(normalizedPath))        
        {
URI var72A74007B2BE62B849F475C7BDA4658B_289724247 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_289724247.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_289724247;
        } //End block
        URI result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
URI varDC838461EE2FA0CA4C9BBB70A15456B0_2219793 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2219793.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2219793;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.844 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "4CD60E985FCF0E725045B1880EA1AF70")
    public URI parseServerAuthority() throws URISyntaxException {
        if(!serverAuthority)        
        {
            parseAuthority(true);
        } //End block
URI var72A74007B2BE62B849F475C7BDA4658B_490345487 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_490345487.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_490345487;
        // ---------- Original Method ----------
        //if (!serverAuthority) {
            //parseAuthority(true);
        //}
        //return this;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.844 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "F40681EC8CA2436F64E6036C860B1B89")
    public URI relativize(URI relative) {
        if(relative.opaque || opaque)        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1892574751 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1892574751.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1892574751;
        } //End block
        if(scheme == null ? relative.scheme != null : !scheme
                .equals(relative.scheme))        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1778060580 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1778060580.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1778060580;
        } //End block
        if(authority == null ? relative.authority != null : !authority
                .equals(relative.authority))        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_2131652122 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_2131652122.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_2131652122;
        } //End block
        String thisPath = normalize(path, false);
        String relativePath = normalize(relative.path, false);
        if(!thisPath.equals(relativePath))        
        {
            thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
            if(!relativePath.startsWith(thisPath))            
            {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1661191761 =                 relative;
                varB3C4240352FFC7610A1E6B6AEE4AC9E6_1661191761.addTaint(taint);
                return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1661191761;
            } //End block
        } //End block
        URI result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
URI varDC838461EE2FA0CA4C9BBB70A15456B0_729530825 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_729530825.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_729530825;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.845 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "DFA65B78C788E7E2869C4E31F6939F2A")
    public URI resolve(URI relative) {
        if(relative.absolute || opaque)        
        {
URI varB3C4240352FFC7610A1E6B6AEE4AC9E6_1460489703 =             relative;
            varB3C4240352FFC7610A1E6B6AEE4AC9E6_1460489703.addTaint(taint);
            return varB3C4240352FFC7610A1E6B6AEE4AC9E6_1460489703;
        } //End block
        if(relative.authority != null)        
        {
            URI result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
URI varDC838461EE2FA0CA4C9BBB70A15456B0_213080985 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_213080985.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_213080985;
        } //End block
        if(relative.path.isEmpty() && relative.scheme == null && relative.query == null)        
        {
            URI result = duplicate();
            result.fragment = relative.fragment;
URI varDC838461EE2FA0CA4C9BBB70A15456B0_1168186897 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1168186897.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1168186897;
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
URI varDC838461EE2FA0CA4C9BBB70A15456B0_1572670845 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1572670845.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1572670845;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.845 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "4ED8B0EDF42D95602712173E78B58A92")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.845 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "6272258828893938939194F4555EFA8E")
    public URI resolve(String relative) {
        addTaint(relative.getTaint());
URI var6EDC2CB917A200A202A3C7444E2D29E2_967310178 =         resolve(create(relative));
        var6EDC2CB917A200A202A3C7444E2D29E2_967310178.addTaint(taint);
        return var6EDC2CB917A200A202A3C7444E2D29E2_967310178;
        // ---------- Original Method ----------
        //return resolve(create(relative));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.845 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "4FA84E49228C19123AFE4551B42290F1")
    private String decode(String s) {
        addTaint(s.getTaint());
String var4CC69FF2A8688969A578CF3D5F5AE170_1727262325 =         s != null ? UriCodec.decode(s) : null;
        var4CC69FF2A8688969A578CF3D5F5AE170_1727262325.addTaint(taint);
        return var4CC69FF2A8688969A578CF3D5F5AE170_1727262325;
        // ---------- Original Method ----------
        //return s != null ? UriCodec.decode(s) : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.845 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "63D3B7D5C8B410BB6F51C958A674A475")
    public String toASCIIString() {
        StringBuilder result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
String varE65B3A02759122992CB82C0E651AD408_1611435310 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1611435310.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1611435310;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //ASCII_ONLY.appendEncoded(result, toString());
        //return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.846 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "27D4065BF46968E70B80EE5A339BC58E")
    @Override
    public String toString() {
     return string;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.846 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "0B60206631064AC9D3D17F0B2496CC55")
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
String var6E684D9B8DA835CC8A13C4D3E99458C8_563535807 =         convertHexToLowerCase(result.toString());
        var6E684D9B8DA835CC8A13C4D3E99458C8_563535807.addTaint(taint);
        return var6E684D9B8DA835CC8A13C4D3E99458C8_563535807;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.847 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "17E99B6ACC6AEC0B8C02A5B8818C48B1")
    public URL toURL() throws MalformedURLException {
        if(!absolute)        
        {
            IllegalArgumentException varCA03E1D228906D4821F7E9CA2889020B_1125715175 = new IllegalArgumentException("URI is not absolute: " + toString());
            varCA03E1D228906D4821F7E9CA2889020B_1125715175.addTaint(taint);
            throw varCA03E1D228906D4821F7E9CA2889020B_1125715175;
        } //End block
URL varDABA914D840E6D43A1E159EFF2D2A3B3_662114510 =         new URL(toString());
        varDABA914D840E6D43A1E159EFF2D2A3B3_662114510.addTaint(taint);
        return varDABA914D840E6D43A1E159EFF2D2A3B3_662114510;
        // ---------- Original Method ----------
        //if (!absolute) {
            //throw new IllegalArgumentException("URI is not absolute: " + toString());
        //}
        //return new URL(toString());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.847 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "4A15F9A54464884A8CE2DFEC0431ADCF")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        addTaint(in.getTaint());
        in.defaultReadObject();
        try 
        {
            parseURI(string, false);
        } //End block
        catch (URISyntaxException e)
        {
            IOException varD719BE8874BDDFB77470A93D35CFE9F1_1184335807 = new IOException(e.toString());
            varD719BE8874BDDFB77470A93D35CFE9F1_1184335807.addTaint(taint);
            throw varD719BE8874BDDFB77470A93D35CFE9F1_1184335807;
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //try {
            //parseURI(string, false);
        //} catch (URISyntaxException e) {
            //throw new IOException(e.toString());
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.847 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "64ECA8697047437409628550606FC4E7")
    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        addTaint(out.getTaint());
        toString();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //toString();
        //out.defaultWriteObject();
    }

    
    private static class PartEncoder extends UriCodec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.847 -0400", hash_original_field = "CAEEB9F4CCB9D7B7E16A7116D7AFB0F9", hash_generated_field = "926C47E1AC0B012F194CBD99C1600D74")

        private String extraLegalCharacters;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.847 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "A3E69B2622C1BE064BB82D32FBDEA2CF")
          PartEncoder(String extraLegalCharacters) {
            this.extraLegalCharacters = extraLegalCharacters;
            // ---------- Original Method ----------
            //this.extraLegalCharacters = extraLegalCharacters;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "B5E6D40559371DEDD5E2E439933412D8")
        @Override
        protected boolean isRetained(char c) {
            addTaint(c);
            boolean var71900A39755553C87F349ECDFF1CA04F_1307550059 = (UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403426821 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403426821;
            // ---------- Original Method ----------
            //return UNRESERVED.indexOf(c) != -1
                    //|| PUNCTUATION.indexOf(c) != -1
                    //|| extraLegalCharacters.indexOf(c) != -1
                    //|| (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c));
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "4CC2DF87C40203D819A0EB7194AEA8C8", hash_generated_field = "D9F851BAB07F16ADC844C00A2D076DA4")

    private static final long serialVersionUID = -6052424284110960213l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "E4565A1C7C15C116399C1B66D177CCAA", hash_generated_field = "708B5C1D2A5145AAE93B4DCBD1DBB016")

    static final String UNRESERVED = "_-!.~\'()*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "7827FCA6D68EBA110FDF7058ADDCAC6E", hash_generated_field = "58ACB5067A7BC64309A3619F3AD62CBB")

    static final String PUNCTUATION = ",;:$&+=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "3BA513EBF01781F5FE614A45355CD736", hash_generated_field = "E178400A95CCD95D53BB193CEC75CD16")

    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "FF5400DE12BEB032ADAE808997F25826", hash_generated_field = "BA21C0891E8446409D9F3F2B417FABAD")

    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "55B8B2D0D08ED9539700232F34BC29C6", hash_generated_field = "B3691C302E4EAFC49A0C65C2815D1A13")

    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.848 -0400", hash_original_field = "B5EAF2F5DF66BA195D74CD9F98F77B5D", hash_generated_field = "67FAF76CD518CC63640B971FB53CFC1C")

    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.854 -0400", hash_original_field = "256860EB365F0FECD50CC935A29DAE64", hash_generated_field = "E7C042F6DFADEFFCB60303B26B28DAD0")

    static final UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_field = "28C996D087D0FFD51A4D86193699CE92", hash_generated_field = "4555E773DC35726B7DC0D99E5880A09D")

    private static final UriCodec ASCII_ONLY = new UriCodec() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:54.163 -0400", hash_original_method = "02ABED517C80D26C77E9E33853271AB3", hash_generated_method = "CA0223A78831679BA13FF2976C57894B")
        @Override
        protected boolean isRetained(char c) {
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_241005729 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_241005729;
            
            
        }

        
};
}

