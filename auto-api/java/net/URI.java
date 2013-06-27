package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;

public final class URI implements Comparable<URI>, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    private String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "A77350C36FACC15543B26BF9F179A70D")

    private transient String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "97E7FA8F49FDF56AB2DF43BBC80E2476", hash_generated_field = "14DBC9168C32C9C014586FA7F0B8A107")

    private transient String schemeSpecificPart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "57D185265731B43622C0B461510772A9")

    private transient String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "0A24F4A69DB662BA59F12A9B09B3CA7F")

    private transient String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "CAB9CCA4AFFBFB7ECB540E3002763641", hash_generated_field = "D5EC92E1B3465138D54142DB3E99F34E")

    private transient int port = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "1B1CC7F086B3F074DA452BC3129981EB", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "172D3480DA0AFB6E023B26EA00955132")

    private transient String fragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "94619F8A70068B2591C2EED622525B0E", hash_generated_field = "EDD34009E3CB727B5445D7F24CB35623")

    private transient boolean opaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "DC4D53AA0D117D8B189B36D161AF4E96", hash_generated_field = "8B0AF94FA16DD5DBCAA078866E853806")

    private transient boolean absolute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "51622123728B411C7CCF75B702B58CC9", hash_generated_field = "D4CE8185ED9C0ACE43C0C010B0E562F4")

    private transient boolean serverAuthority = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_field = "AA3BEAB45B8CACBD81EA40A719A8F3DA", hash_generated_field = "F58223E1E1183B179891344C3FD7FA57")

    private transient int hash = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.134 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "1BF7E280541A2A445B26B3247430EA17")
    private  URI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.135 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "DC5F33F54AA8A0DF7A12A5E0E0C0D494")
    public  URI(String spec) throws URISyntaxException {
        parseURI(spec, false);
        addTaint(spec.getTaint());
        // ---------- Original Method ----------
        //parseURI(spec, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.135 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "F9C0106F0C6ECDAA02575405A37E3658")
    public  URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException {
        StringBuilder uri;
        uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
        {
            ALL_LEGAL_ENCODER.appendEncoded(uri, schemeSpecificPart);
        } //End block
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), false);
        addTaint(scheme.getTaint());
        addTaint(schemeSpecificPart.getTaint());
        addTaint(fragment.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.139 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "753FBED39B890EF7450402088FA439BA")
    public  URI(String scheme, String userInfo, String host, int port, String path, String query,
            String fragment) throws URISyntaxException {
        {
            this.path = "";
        } //End block
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_660214430 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(path, "Relative path");
            } //End block
        } //End collapsed parenthetic
        StringBuilder uri;
        uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
        {
            uri.append("//");
        } //End block
        {
            USER_INFO_ENCODER.appendEncoded(uri, userInfo);
            uri.append('@');
        } //End block
        {
            {
                boolean var550E64C193B5291AD437B9B1D9496F50_2119779712 = (host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1);
                {
                    host = "[" + host + "]";
                } //End block
            } //End collapsed parenthetic
            uri.append(host);
        } //End block
        {
            uri.append(':');
            uri.append(port);
        } //End block
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } //End block
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } //End block
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), true);
        addTaint(scheme.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(port);
        addTaint(query.getTaint());
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.148 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "C223B3818AB1B450218A67BECCAB8872")
    public  URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        addTaint(scheme.getTaint());
        addTaint(host.getTaint());
        addTaint(path.getTaint());
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.151 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "CBB79A4050EF1A51CA12D6ED2D0E6C0F")
    public  URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_1656532216 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(path, "Relative path");
            } //End block
        } //End collapsed parenthetic
        StringBuilder uri;
        uri = new StringBuilder();
        {
            uri.append(scheme);
            uri.append(':');
        } //End block
        {
            uri.append("//");
            AUTHORITY_ENCODER.appendEncoded(uri, authority);
        } //End block
        {
            PATH_ENCODER.appendEncoded(uri, path);
        } //End block
        {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        } //End block
        {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        } //End block
        parseURI(uri.toString(), false);
        addTaint(scheme.getTaint());
        addTaint(authority.getTaint());
        addTaint(path.getTaint());
        addTaint(query.getTaint());
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.157 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "9C0501BEDEF61DCD44A47102664DB075")
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        string = uri;
        int fragmentStart;
        fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
        {
            boolean var14906E87F75C4EB9DB697B7FC771BD9F_2130639166 = (fragmentStart < uri.length());
            {
                fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
            } //End block
        } //End collapsed parenthetic
        int start;
        int colon;
        colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
        {
            boolean varA7FDD5A6BBA9720FEB70A13E43618B16_927941140 = (colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart));
            {
                absolute = true;
                scheme = validateScheme(uri, colon);
                start = colon + 1;
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme-specific part expected", start);
                } //End block
                {
                    boolean varEBC930CB1CD455F7868E4252B2B7D45B_1397924936 = (!uri.regionMatches(start, "/", 0, 1));
                    {
                        opaque = true;
                        schemeSpecificPart = ALL_LEGAL_ENCODER.validate(
                        uri, start, fragmentStart, "scheme specific part");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                absolute = false;
                start = 0;
            } //End block
        } //End collapsed parenthetic
        opaque = false;
        schemeSpecificPart = uri.substring(start, fragmentStart);
        int fileStart;
        {
            boolean var5757BFA7159BA6600285D2DC55CA28A4_1773430547 = (uri.regionMatches(start, "//", 0, 2));
            {
                int authorityStart;
                authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
                {
                    boolean var1B2B73CCD1123E5D8F07A549A84A962C_397761576 = (authorityStart == uri.length());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Authority expected", uri.length());
                    } //End block
                } //End collapsed parenthetic
                {
                    authority = AUTHORITY_ENCODER.validate(uri, authorityStart, fileStart, "authority");
                } //End block
            } //End block
            {
                fileStart = start;
            } //End block
        } //End collapsed parenthetic
        int queryStart;
        queryStart = UrlUtils.findFirstOf(uri, "?", fileStart, fragmentStart);
        path = PATH_ENCODER.validate(uri, fileStart, queryStart, "path");
        {
            query = ALL_LEGAL_ENCODER.validate(uri, queryStart + 1, fragmentStart, "query");
        } //End block
        parseAuthority(forceServer);
        addTaint(forceServer);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.158 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "ED078C6EF522020D5F0C34D2F166447C")
    private String validateScheme(String uri, int end) throws URISyntaxException {
        String varB4EAC82CA7396A68D541C85D26508E83_1937010742 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme expected", 0);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    boolean varF659B01EBB7D3C509A86E3BFA39CC1B5_1085220582 = (!UrlUtils.isValidSchemeChar(i, uri.charAt(i)));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in scheme", 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1937010742 = uri.substring(0, end);
        addTaint(uri.getTaint());
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1937010742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1937010742;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.183 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "BC2CBF44C44086C259E333D1C5DF7FA5")
    private void parseAuthority(boolean forceServer) throws URISyntaxException {
        String tempUserInfo;
        tempUserInfo = null;
        String temp;
        temp = authority;
        int index;
        index = temp.indexOf('@');
        int hostIndex;
        hostIndex = 0;
        {
            tempUserInfo = temp.substring(0, index);
            validateUserInfo(authority, tempUserInfo, 0);
            temp = temp.substring(index + 1);
            hostIndex = index + 1;
        } //End block
        index = temp.lastIndexOf(':');
        int endIndex;
        endIndex = temp.indexOf(']');
        String tempHost;
        int tempPort;
        tempPort = -1;
        {
            tempHost = temp.substring(0, index);
            {
                boolean var471C201E222440759958E44C5A2F8C2C_1115577414 = (index < (temp.length() - 1));
                {
                    try 
                    {
                        tempPort = Integer.parseInt(temp.substring(index + 1));
                        {
                            {
                                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority,
                                    "Invalid port number", hostIndex + index + 1);
                            } //End block
                        } //End block
                    } //End block
                    catch (NumberFormatException e)
                    {
                        {
                            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority,
                                "Invalid port number", hostIndex + index + 1);
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            tempHost = temp;
        } //End block
        {
            boolean var07D9E4585E11834C381219EB624A85F7_280004165 = (tempHost.isEmpty());
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority, "Expected host", hostIndex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var158075BD2E1D16639FB8BCBA31A90016_1788893114 = (!isValidHost(forceServer, tempHost));
        } //End collapsed parenthetic
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
        addTaint(forceServer);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.190 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "CDC67CC2C45296DC437AAAC6D24AF3F6")
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        {
            int i;
            i = 0;
            boolean var61BE23789239FB4C090D5853B97C62FB_228158681 = (i < userInfo.length());
            {
                char ch;
                ch = userInfo.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(userInfo.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //for (int i = 0; i < userInfo.length(); i++) {
            //char ch = userInfo.charAt(i);
            //if (ch == ']' || ch == '[') {
                //throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.191 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "79531C0B03C248D7EB6DED82D557C8D8")
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        {
            boolean varFCCCD9BDBC603228D4710DD2E5A9B32F_448997861 = (host.startsWith("["));
            {
                {
                    boolean varF9599A0F269A93198F48A20A694972EC_2112761235 = (!host.endsWith("]"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD5E87321776926869A9F8CCC6C3D14FA_760756320 = (InetAddress.isNumeric(host));
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv6 address");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var36FFAEAF88FC26FFC5276B550B24D5DE_857842001 = (host.indexOf('[') != -1 || host.indexOf(']') != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = host.lastIndexOf('.');
        {
            boolean var62B5BEA078C6AF897DE86B7C91F4DAEC_1396079578 = (index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)));
            {
                {
                    boolean var60D4AC8ED4B08A7A4E9E67A3B8F29C40_1952325691 = (isValidDomainName(host));
                } //End collapsed parenthetic
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        try 
        {
            InetAddress ia;
            ia = InetAddress.parseNumericAddress(host);
        } //End block
        catch (IllegalArgumentException ignored)
        { }
        {
            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv4 address", 0);
        } //End block
        addTaint(forceServer);
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1065114260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1065114260;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.254 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "290BD5131F9806437AC6213C04312D86")
    private boolean isValidDomainName(String host) {
        try 
        {
            UriCodec.validateSimple(host, "-.");
        } //End block
        catch (URISyntaxException e)
        { }
        String lastLabel;
        lastLabel = null;
        {
            String token = host.split("\\.")[0];
            {
                lastLabel = token;
                {
                    boolean var092620AA3BCBDBEC4B02F610B8967169_2095244925 = (lastLabel.startsWith("-") || lastLabel.endsWith("-"));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var62581F9350E01C0148C5B044A3636F9A_1333146575 = (!lastLabel.equals(host));
            {
                char ch;
                ch = lastLabel.charAt(0);
            } //End block
        } //End collapsed parenthetic
        addTaint(host.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834207478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834207478;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.273 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "E3FF4AB055CC4A9CB93B5F9FFEB712C8")
    public int compareTo(URI uri) {
        int ret;
        {
            ret = scheme.compareToIgnoreCase(uri.scheme);
        } //End block
        {
            ret = schemeSpecificPart.compareTo(uri.schemeSpecificPart);
        } //End block
        {
            {
                {
                    {
                        ret = userInfo.compareTo(uri.userInfo);
                    } //End block
                    ret = host.compareToIgnoreCase(uri.host);
                } //End block
                {
                    ret = authority.compareTo(uri.authority);
                } //End block
            } //End block
            ret = path.compareTo(uri.path);
            {
                ret = query.compareTo(uri.query);
            } //End block
        } //End block
        {
            ret = fragment.compareTo(uri.fragment);
        } //End block
        addTaint(uri.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26702831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_26702831;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static URI create(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.282 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "A69768B069703B5EAD2C26DE2EB6D96B")
    private URI duplicate() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1172508966 = null; //Variable for return #1
        URI clone;
        clone = new URI();
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
        varB4EAC82CA7396A68D541C85D26508E83_1172508966 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1172508966.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1172508966;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.283 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "990CFEABC6807A283163F90EA012943F")
    private String convertHexToLowerCase(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_1457470085 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_898554912 = null; //Variable for return #2
        StringBuilder result;
        result = new StringBuilder("");
        {
            boolean varEB6442064EDBB8B51A5716AA5B8E92B3_717199667 = (s.indexOf('%') == -1);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1457470085 = s;
            } //End block
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var3FA97A1C7FD8BD3DFDFB4FA1562BC71E_1378499733 = ((index = s.indexOf('%', prevIndex)) != -1);
            {
                result.append(s.substring(prevIndex, index + 1));
                result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
                index += 3;
                prevIndex = index;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_898554912 = result.toString();
        addTaint(s.getTaint());
        String varA7E53CE21691AB073D9660D615818899_868743431; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_868743431 = varB4EAC82CA7396A68D541C85D26508E83_1457470085;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_868743431 = varB4EAC82CA7396A68D541C85D26508E83_898554912;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_868743431.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_868743431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.284 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "1BF3AB3BBB69AD208B46DFFE10F8E59D")
    private boolean escapedEquals(String first, String second) {
        {
            boolean var1F61A1CA58188B3C323B0BC1A8DADBE6_1052688570 = (first.indexOf('%') != second.indexOf('%'));
            {
                boolean var9A92D953275813B0E21E2ACB41134B3B_1139570263 = (first.equals(second));
            } //End block
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var9722F6B33E3926CBF63854BB7D6FD389_484977561 = ((index = first.indexOf('%', prevIndex)) != -1
                && second.indexOf('%', prevIndex) == index);
            {
                boolean match;
                match = first.substring(prevIndex, index).equals(
                    second.substring(prevIndex, index));
                match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    second.substring(index + 1, index + 3));
                index += 3;
                prevIndex = index;
            } //End block
        } //End collapsed parenthetic
        boolean var82012BF29BC079AE3198FB95B5CF6151_223054861 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
        addTaint(first.getTaint());
        addTaint(second.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_284901963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_284901963;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.290 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "1F807BA30783C9C7718720EF94912178")
    @Override
    public boolean equals(Object o) {
        URI uri;
        uri = (URI) o;
        {
            {
                boolean var60CDEB48A7F58F8237D705D7C40D17CC_1089361487 = (!escapedEquals(uri.fragment, fragment));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var38EA33084FCA86881E8FD72A38A7749C_1940437635 = (!uri.scheme.equalsIgnoreCase(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var7E67A78714F419D789626F935DC27349_185168017 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
        } //End block
        {
            {
                boolean varA8C91154088202E89FE7FC4E6E5FD0C6_1116921753 = (!escapedEquals(path, uri.path));
            } //End collapsed parenthetic
            {
                {
                    boolean var7C1AA47824584214BA2C304C225799C2_1339422509 = (!escapedEquals(uri.query, query));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varCFCD5A99259213E0C97153FBD1F01864_607820854 = (escapedEquals(uri.authority, authority));
                } //End block
                {
                    {
                        boolean var157801492CF3B05F03DFA16E5EB86961_206234215 = (!host.equalsIgnoreCase(uri.host));
                    } //End collapsed parenthetic
                    {
                        boolean varB9E57D7781CD81877C81BF504253B25D_155551332 = (escapedEquals(userInfo, uri.userInfo));
                    } //End block
                } //End block
            } //End block
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1769842827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1769842827;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.290 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "6B9DE22C3D6F14A40F7E411FD8C86E94")
    public String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1802475894 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1802475894 = scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1802475894.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1802475894;
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.299 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "11FD4338E1D3FF5E99B787887000350D")
    public String getSchemeSpecificPart() {
        String varB4EAC82CA7396A68D541C85D26508E83_2017828300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2017828300 = decode(schemeSpecificPart);
        varB4EAC82CA7396A68D541C85D26508E83_2017828300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2017828300;
        // ---------- Original Method ----------
        //return decode(schemeSpecificPart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.299 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "9A273BA959AF34DA841F722633129AA3")
    public String getRawSchemeSpecificPart() {
        String varB4EAC82CA7396A68D541C85D26508E83_1067245344 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1067245344 = schemeSpecificPart;
        varB4EAC82CA7396A68D541C85D26508E83_1067245344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1067245344;
        // ---------- Original Method ----------
        //return schemeSpecificPart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.300 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "4A0D451A65501ABC15C0D564017473A4")
    public String getAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_794180086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_794180086 = decode(authority);
        varB4EAC82CA7396A68D541C85D26508E83_794180086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794180086;
        // ---------- Original Method ----------
        //return decode(authority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.300 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "5C2C7E24ED28A1D389C97CECC4DAEC15")
    public String getRawAuthority() {
        String varB4EAC82CA7396A68D541C85D26508E83_1747609446 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1747609446 = authority;
        varB4EAC82CA7396A68D541C85D26508E83_1747609446.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1747609446;
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.300 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "5298E912A5871C0998FAC886EF99DA36")
    public String getUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_213082461 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_213082461 = decode(userInfo);
        varB4EAC82CA7396A68D541C85D26508E83_213082461.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_213082461;
        // ---------- Original Method ----------
        //return decode(userInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.301 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "3DBC62996344D1BE7F90302F3643B2D2")
    public String getRawUserInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_1801197484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1801197484 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1801197484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1801197484;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.301 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "DAB76D836DDA52FB29CAA76229C193DF")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1847831047 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1847831047 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1847831047.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847831047;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.335 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "921065AEA14D5A881C9C4C386F6670DD")
    public int getPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213627487 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213627487;
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.336 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "6821619CB12225039E39D0BF6DC6BACC")
    public int getEffectivePort() {
        int var12709C286048EEEA3C7AFAA905EEAD9D_1183368276 = (getEffectivePort(scheme, port));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110959719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110959719;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.336 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "99FE4A43D5EA3287559211DD00CD7F69")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1254593248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1254593248 = decode(path);
        varB4EAC82CA7396A68D541C85D26508E83_1254593248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1254593248;
        // ---------- Original Method ----------
        //return decode(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.337 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "49D8CF0A51E41125A611AB8F0DA5283C")
    public String getRawPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1076085865 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1076085865 = path;
        varB4EAC82CA7396A68D541C85D26508E83_1076085865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076085865;
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.337 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "199F35CBA2DA5F73271E17418723A5F7")
    public String getQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_1514562326 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1514562326 = decode(query);
        varB4EAC82CA7396A68D541C85D26508E83_1514562326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514562326;
        // ---------- Original Method ----------
        //return decode(query);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.338 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "EBA6B046C6D918CDCD76FB4567DD6D0B")
    public String getRawQuery() {
        String varB4EAC82CA7396A68D541C85D26508E83_762670595 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_762670595 = query;
        varB4EAC82CA7396A68D541C85D26508E83_762670595.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_762670595;
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.357 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "ACFE58815633A54F32C14D0536D62749")
    public String getFragment() {
        String varB4EAC82CA7396A68D541C85D26508E83_147728123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_147728123 = decode(fragment);
        varB4EAC82CA7396A68D541C85D26508E83_147728123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147728123;
        // ---------- Original Method ----------
        //return decode(fragment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.357 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "25856C82C2F86AB440916BBDB1B1BBF0")
    public String getRawFragment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1724719916 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1724719916 = fragment;
        varB4EAC82CA7396A68D541C85D26508E83_1724719916.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1724719916;
        // ---------- Original Method ----------
        //return fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.358 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "9776E0DF3A668085566E271FBD5B42C1")
    @Override
    public int hashCode() {
        {
            hash = getHashString().hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612974500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1612974500;
        // ---------- Original Method ----------
        //if (hash == -1) {
            //hash = getHashString().hashCode();
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.358 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "D82451475B9F9AAB359D8B1223680726")
    public boolean isAbsolute() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_234933868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_234933868;
        // ---------- Original Method ----------
        //return absolute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.358 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "70A086ABA09C40611867015C7A9C07E7")
    public boolean isOpaque() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1842783688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1842783688;
        // ---------- Original Method ----------
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.378 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "3EA40A5060BBDF26A995CE9394CDCF25")
    private String normalize(String path, boolean discardRelativePrefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_2072491239 = null; //Variable for return #1
        path = UrlUtils.canonicalizePath(path, discardRelativePrefix);
        int colon;
        colon = path.indexOf(':');
        {
            int slash;
            slash = path.indexOf('/');
            {
                path = "./" + path;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2072491239 = path;
        varB4EAC82CA7396A68D541C85D26508E83_2072491239.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2072491239;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.379 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "E82D4EA640837FA60A9F0357214ACD7E")
    public URI normalize() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1687356688 = null; //Variable for return #1
        URI varB4EAC82CA7396A68D541C85D26508E83_1633899341 = null; //Variable for return #2
        URI varB4EAC82CA7396A68D541C85D26508E83_690332472 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1687356688 = this;
        } //End block
        String normalizedPath;
        normalizedPath = normalize(path, false);
        {
            boolean varED6BB76AF8F0E8C24432884623407A00_1276495051 = (path.equals(normalizedPath));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1633899341 = this;
            } //End block
        } //End collapsed parenthetic
        URI result;
        result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_690332472 = result;
        URI varA7E53CE21691AB073D9660D615818899_142392161; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_142392161 = varB4EAC82CA7396A68D541C85D26508E83_1687356688;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_142392161 = varB4EAC82CA7396A68D541C85D26508E83_1633899341;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_142392161 = varB4EAC82CA7396A68D541C85D26508E83_690332472;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_142392161.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_142392161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.381 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "8D13769777EDBBC0297CBD8963B6ED82")
    public URI parseServerAuthority() throws URISyntaxException {
        URI varB4EAC82CA7396A68D541C85D26508E83_164334899 = null; //Variable for return #1
        {
            parseAuthority(true);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_164334899 = this;
        varB4EAC82CA7396A68D541C85D26508E83_164334899.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_164334899;
        // ---------- Original Method ----------
        //if (!serverAuthority) {
            //parseAuthority(true);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.410 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "28DCB3720DDCF7585BADFF25901A1505")
    public URI relativize(URI relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_1778333286 = null; //Variable for return #1
        URI varB4EAC82CA7396A68D541C85D26508E83_359859345 = null; //Variable for return #2
        URI varB4EAC82CA7396A68D541C85D26508E83_580683542 = null; //Variable for return #3
        URI varB4EAC82CA7396A68D541C85D26508E83_1205875959 = null; //Variable for return #4
        URI varB4EAC82CA7396A68D541C85D26508E83_1294629213 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_1778333286 = relative;
        } //End block
        {
            {
                boolean varC865ACA7FB0CCF69283F042F0DB61312_1309071401 = (!scheme
                .equals(relative.scheme));
            } //End flattened ternary
            {
                varB4EAC82CA7396A68D541C85D26508E83_359859345 = relative;
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean varE0036196913086AF15703499E78ECF8B_416648809 = (!authority
                .equals(relative.authority));
            } //End flattened ternary
            {
                varB4EAC82CA7396A68D541C85D26508E83_580683542 = relative;
            } //End block
        } //End collapsed parenthetic
        String thisPath;
        thisPath = normalize(path, false);
        String relativePath;
        relativePath = normalize(relative.path, false);
        {
            boolean varEDBF7EABD9E353975E483312E9BAC550_1117238442 = (!thisPath.equals(relativePath));
            {
                thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
                {
                    boolean varDC148464305F08DF1780EDF47FFC747D_1858223072 = (!relativePath.startsWith(thisPath));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1205875959 = relative;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        URI result;
        result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_1294629213 = result;
        URI varA7E53CE21691AB073D9660D615818899_515588211; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_515588211 = varB4EAC82CA7396A68D541C85D26508E83_1778333286;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_515588211 = varB4EAC82CA7396A68D541C85D26508E83_359859345;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_515588211 = varB4EAC82CA7396A68D541C85D26508E83_580683542;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_515588211 = varB4EAC82CA7396A68D541C85D26508E83_1205875959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_515588211 = varB4EAC82CA7396A68D541C85D26508E83_1294629213;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_515588211.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_515588211;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.416 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "39458C2BC8817CF2E7BC9CDD846DFD4D")
    public URI resolve(URI relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_110073951 = null; //Variable for return #1
        URI varB4EAC82CA7396A68D541C85D26508E83_593252281 = null; //Variable for return #2
        URI varB4EAC82CA7396A68D541C85D26508E83_1099349697 = null; //Variable for return #3
        URI varB4EAC82CA7396A68D541C85D26508E83_1668449608 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_110073951 = relative;
        } //End block
        {
            URI result;
            result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
            varB4EAC82CA7396A68D541C85D26508E83_593252281 = result;
        } //End block
        {
            boolean var03F21B31825B83006AD962520A46A4CC_825867527 = (relative.path.isEmpty() && relative.scheme == null && relative.query == null);
            {
                URI result;
                result = duplicate();
                result.fragment = relative.fragment;
                varB4EAC82CA7396A68D541C85D26508E83_1099349697 = result;
            } //End block
        } //End collapsed parenthetic
        URI result;
        result = duplicate();
        result.fragment = relative.fragment;
        result.query = relative.query;
        String resolvedPath;
        {
            boolean varEC53DB095CB8776983E38D0B1831503B_2058609219 = (relative.path.startsWith("/"));
            {
                resolvedPath = relative.path;
            } //End block
            {
                boolean var64B3618E3CF5D0DE8D9BCC96B26D0E61_2139635640 = (relative.path.isEmpty());
                {
                    resolvedPath = path;
                } //End block
                {
                    int endIndex;
                    endIndex = path.lastIndexOf('/') + 1;
                    resolvedPath = path.substring(0, endIndex) + relative.path;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        result.path = UrlUtils.authoritySafePath(result.authority, normalize(resolvedPath, true));
        result.setSchemeSpecificPart();
        varB4EAC82CA7396A68D541C85D26508E83_1668449608 = result;
        URI varA7E53CE21691AB073D9660D615818899_1240210266; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1240210266 = varB4EAC82CA7396A68D541C85D26508E83_110073951;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1240210266 = varB4EAC82CA7396A68D541C85D26508E83_593252281;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1240210266 = varB4EAC82CA7396A68D541C85D26508E83_1099349697;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1240210266 = varB4EAC82CA7396A68D541C85D26508E83_1668449608;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1240210266.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1240210266;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.417 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "83048E188DCD9D71CE4F86BF0AE83995")
    private void setSchemeSpecificPart() {
        StringBuilder ssp;
        ssp = new StringBuilder();
        {
            ssp.append("//" + authority);
        } //End block
        {
            ssp.append(path);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.428 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "0D53ADEDC1FC3A18B5B1B2C3E6D18250")
    public URI resolve(String relative) {
        URI varB4EAC82CA7396A68D541C85D26508E83_2066561057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2066561057 = resolve(create(relative));
        addTaint(relative.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2066561057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2066561057;
        // ---------- Original Method ----------
        //return resolve(create(relative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.429 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "22B62C2B14904C91AF0D3D74C87B1871")
    private String decode(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_1668707663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1668707663 = s != null ? UriCodec.decode(s) : null;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1668707663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1668707663;
        // ---------- Original Method ----------
        //return s != null ? UriCodec.decode(s) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.432 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "335D89947B2E230AF941ABA242B9192F")
    public String toASCIIString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1770727156 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        varB4EAC82CA7396A68D541C85D26508E83_1770727156 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1770727156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1770727156;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //ASCII_ONLY.appendEncoded(result, toString());
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.447 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "7567CC96E00158E7A76A7000163A81AB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_627742435 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1191921779 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_627742435 = string;
        } //End block
        StringBuilder result;
        result = new StringBuilder();
        {
            result.append(scheme);
            result.append(':');
        } //End block
        {
            result.append(schemeSpecificPart);
        } //End block
        {
            {
                result.append("//");
                result.append(authority);
            } //End block
            {
                result.append(path);
            } //End block
            {
                result.append('?');
                result.append(query);
            } //End block
        } //End block
        {
            result.append('#');
            result.append(fragment);
        } //End block
        string = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1191921779 = string;
        String varA7E53CE21691AB073D9660D615818899_602581967; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_602581967 = varB4EAC82CA7396A68D541C85D26508E83_627742435;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_602581967 = varB4EAC82CA7396A68D541C85D26508E83_1191921779;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_602581967.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_602581967;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.448 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "FC10D95B8667EC69D5AC08D140F90123")
    private String getHashString() {
        String varB4EAC82CA7396A68D541C85D26508E83_61349740 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder();
        {
            result.append(scheme.toLowerCase(Locale.US));
            result.append(':');
        } //End block
        {
            result.append(schemeSpecificPart);
        } //End block
        {
            {
                result.append("//");
                {
                    result.append(authority);
                } //End block
                {
                    {
                        result.append(userInfo + "@");
                    } //End block
                    result.append(host.toLowerCase(Locale.US));
                    {
                        result.append(":" + port);
                    } //End block
                } //End block
            } //End block
            {
                result.append(path);
            } //End block
            {
                result.append('?');
                result.append(query);
            } //End block
        } //End block
        {
            result.append('#');
            result.append(fragment);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_61349740 = convertHexToLowerCase(result.toString());
        varB4EAC82CA7396A68D541C85D26508E83_61349740.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_61349740;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.451 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "3F8E89674ED7DBC6085676B23701D7DE")
    public URL toURL() throws MalformedURLException {
        URL varB4EAC82CA7396A68D541C85D26508E83_1322525160 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI is not absolute: " + toString());
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1322525160 = new URL(toString());
        varB4EAC82CA7396A68D541C85D26508E83_1322525160.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1322525160;
        // ---------- Original Method ----------
        //if (!absolute) {
            //throw new IllegalArgumentException("URI is not absolute: " + toString());
        //}
        //return new URL(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.451 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "D3AD0A1DDD255CC4A3D1C8112E2897A2")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try 
        {
            parseURI(string, false);
        } //End block
        catch (URISyntaxException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(e.toString());
        } //End block
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //try {
            //parseURI(string, false);
        //} catch (URISyntaxException e) {
            //throw new IOException(e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.454 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "C7D2ED12519D7749B75A0205622D47DB")
    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        toString();
        out.defaultWriteObject();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //toString();
        //out.defaultWriteObject();
    }

    
    private static class PartEncoder extends UriCodec {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.455 -0400", hash_original_field = "CAEEB9F4CCB9D7B7E16A7116D7AFB0F9", hash_generated_field = "926C47E1AC0B012F194CBD99C1600D74")

        private String extraLegalCharacters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.455 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "A3E69B2622C1BE064BB82D32FBDEA2CF")
          PartEncoder(String extraLegalCharacters) {
            this.extraLegalCharacters = extraLegalCharacters;
            // ---------- Original Method ----------
            //this.extraLegalCharacters = extraLegalCharacters;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.462 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "00DA6380BFDB20B0B09AD49C7E553102")
        @Override
        protected boolean isRetained(char c) {
            boolean var0AABE6B03E9E209976286093DF507BCC_773568833 = (UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c)));
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614732988 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614732988;
            // ---------- Original Method ----------
            //return UNRESERVED.indexOf(c) != -1
                    //|| PUNCTUATION.indexOf(c) != -1
                    //|| extraLegalCharacters.indexOf(c) != -1
                    //|| (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c));
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "4CC2DF87C40203D819A0EB7194AEA8C8", hash_generated_field = "6A16B588B11464DAEF66849BFBD620CE")

    private static long serialVersionUID = -6052424284110960213l;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "E4565A1C7C15C116399C1B66D177CCAA", hash_generated_field = "991EC205ABD8686D8623BBD0687FD249")

    static String UNRESERVED = "_-!.~\'()*";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "7827FCA6D68EBA110FDF7058ADDCAC6E", hash_generated_field = "88208BD64BD2FA05EADD4F49CF34DA94")

    static String PUNCTUATION = ",;:$&+=";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "3BA513EBF01781F5FE614A45355CD736", hash_generated_field = "D00419D9258B215F68B8887370E2F36A")

    static UriCodec USER_INFO_ENCODER = new PartEncoder("");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "FF5400DE12BEB032ADAE808997F25826", hash_generated_field = "8204C7B309B68AB7E829C4DAA59DADCC")

    static UriCodec PATH_ENCODER = new PartEncoder("/@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "55B8B2D0D08ED9539700232F34BC29C6", hash_generated_field = "3D546F69A2CF56B8504DA3CEB1C9D3E0")

    static UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "B5EAF2F5DF66BA195D74CD9F98F77B5D", hash_generated_field = "E40EEAD84F75F08E6E9B4F43291B0BC3")

    static UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.468 -0400", hash_original_field = "256860EB365F0FECD50CC935A29DAE64", hash_generated_field = "2A8BFC130A1B9C49F5E962CB018B12AE")

    static UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.471 -0400", hash_original_field = "28C996D087D0FFD51A4D86193699CE92", hash_generated_field = "42A0B70095B52C48DF721CFDF8F4461D")

    private static UriCodec ASCII_ONLY = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:44.471 -0400", hash_original_method = "02ABED517C80D26C77E9E33853271AB3", hash_generated_method = "92424787F9E80F3BB039B1A258564065")
        @Override
        protected boolean isRetained(char c) {
            addTaint(c);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055475899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055475899;
            // ---------- Original Method ----------
            //return c <= 127;
        }

        
};
}

