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
    private String string;
    private transient String scheme;
    private transient String schemeSpecificPart;
    private transient String authority;
    private transient String userInfo;
    private transient String host;
    private transient int port = -1;
    private transient String path;
    private transient String query;
    private transient String fragment;
    private transient boolean opaque;
    private transient boolean absolute;
    private transient boolean serverAuthority = false;
    private transient int hash = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.249 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "1BF7E280541A2A445B26B3247430EA17")
    @DSModeled(DSC.SAFE)
    private URI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.249 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "06D9449139F0BE40A10B4587AD3A624D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String spec) throws URISyntaxException {
        dsTaint.addTaint(spec);
        parseURI(spec, false);
        // ---------- Original Method ----------
        //parseURI(spec, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.249 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "F0A1EDB796C3A3F271119AD35D86EB93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String schemeSpecificPart, String fragment) throws URISyntaxException {
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(fragment);
        dsTaint.addTaint(schemeSpecificPart);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.250 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "67794DE9B5A61C7D1C053894A3FD16A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String userInfo, String host, int port, String path, String query,
            String fragment) throws URISyntaxException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(query);
        dsTaint.addTaint(path);
        dsTaint.addTaint(userInfo);
        dsTaint.addTaint(fragment);
        {
            this.path = "";
        } //End block
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_2094005004 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
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
                boolean var550E64C193B5291AD437B9B1D9496F50_370605076 = (host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.250 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "114DE7CA164A0E7AB4DB8001104DAE88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        dsTaint.addTaint(host);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fragment);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.250 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "A1D54373C0AC37AD92FB8927768DA291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(query);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fragment);
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_1545002745 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.251 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "1FE99D0705697BE9071456F1D2E2264C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        dsTaint.addTaint(forceServer);
        dsTaint.addTaint(uri);
        int fragmentStart;
        fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
        {
            boolean var14906E87F75C4EB9DB697B7FC771BD9F_692804092 = (fragmentStart < uri.length());
            {
                fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
            } //End block
        } //End collapsed parenthetic
        int start;
        int colon;
        colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
        {
            boolean varA7FDD5A6BBA9720FEB70A13E43618B16_320012886 = (colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart));
            {
                absolute = true;
                scheme = validateScheme(uri, colon);
                start = colon + 1;
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme-specific part expected", start);
                } //End block
                {
                    boolean varEBC930CB1CD455F7868E4252B2B7D45B_166040085 = (!uri.regionMatches(start, "/", 0, 1));
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
            boolean var5757BFA7159BA6600285D2DC55CA28A4_497896866 = (uri.regionMatches(start, "//", 0, 2));
            {
                int authorityStart;
                authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
                {
                    boolean var1B2B73CCD1123E5D8F07A549A84A962C_990226376 = (authorityStart == uri.length());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.252 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "41E40DF239B2788CDC350CAE0E9C44F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String validateScheme(String uri, int end) throws URISyntaxException {
        dsTaint.addTaint(uri);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme expected", 0);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    boolean varF659B01EBB7D3C509A86E3BFA39CC1B5_1407298574 = (!UrlUtils.isValidSchemeChar(i, uri.charAt(i)));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in scheme", 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varE30E35E4F02CF3489E82DF39B786C8EE_564782975 = (uri.substring(0, end));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.252 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "EEB25A5DF26713D8DBBD458B58B3D008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseAuthority(boolean forceServer) throws URISyntaxException {
        dsTaint.addTaint(forceServer);
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
                boolean var471C201E222440759958E44C5A2F8C2C_1487382216 = (index < (temp.length() - 1));
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
            boolean var07D9E4585E11834C381219EB624A85F7_2049135763 = (tempHost.isEmpty());
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority, "Expected host", hostIndex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var158075BD2E1D16639FB8BCBA31A90016_2094588669 = (!isValidHost(forceServer, tempHost));
        } //End collapsed parenthetic
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.252 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "BCD4DE3E53F55EEEA11A5DC8C7A3CB52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(userInfo);
        dsTaint.addTaint(uri);
        {
            int i;
            i = 0;
            boolean var61BE23789239FB4C090D5853B97C62FB_1136870900 = (i < userInfo.length());
            {
                char ch;
                ch = userInfo.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < userInfo.length(); i++) {
            //char ch = userInfo.charAt(i);
            //if (ch == ']' || ch == '[') {
                //throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.253 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "647E5BEA3E270B8F3E192AE91C66B8FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        dsTaint.addTaint(host);
        dsTaint.addTaint(forceServer);
        {
            boolean varFCCCD9BDBC603228D4710DD2E5A9B32F_1031883208 = (host.startsWith("["));
            {
                {
                    boolean varF9599A0F269A93198F48A20A694972EC_358080080 = (!host.endsWith("]"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD5E87321776926869A9F8CCC6C3D14FA_1591381860 = (InetAddress.isNumeric(host));
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv6 address");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var36FFAEAF88FC26FFC5276B550B24D5DE_2069132268 = (host.indexOf('[') != -1 || host.indexOf(']') != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = host.lastIndexOf('.');
        {
            boolean var62B5BEA078C6AF897DE86B7C91F4DAEC_239105766 = (index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)));
            {
                {
                    boolean var60D4AC8ED4B08A7A4E9E67A3B8F29C40_1355604570 = (isValidDomainName(host));
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.257 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "005CE3E57F823AB487F7ADAA81113077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidDomainName(String host) {
        dsTaint.addTaint(host);
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
                    boolean var092620AA3BCBDBEC4B02F610B8967169_1469996823 = (lastLabel.startsWith("-") || lastLabel.endsWith("-"));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var62581F9350E01C0148C5B044A3636F9A_1054655152 = (!lastLabel.equals(host));
            {
                char ch;
                ch = lastLabel.charAt(0);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.258 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "8EC777D86125E27137CC06929F36FC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.258 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "E29FEDFA2AA6CA87BE987104A8A297A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private URI duplicate() {
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
        return (URI)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.259 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "84091249CEC39875360543C66E6820B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String convertHexToLowerCase(String s) {
        dsTaint.addTaint(s);
        StringBuilder result;
        result = new StringBuilder("");
        {
            boolean varEB6442064EDBB8B51A5716AA5B8E92B3_1236954478 = (s.indexOf('%') == -1);
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var3FA97A1C7FD8BD3DFDFB4FA1562BC71E_961239700 = ((index = s.indexOf('%', prevIndex)) != -1);
            {
                result.append(s.substring(prevIndex, index + 1));
                result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
                index += 3;
                prevIndex = index;
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_411888424 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.259 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "617AA85948AEB09A39DFDE8CA72CB0AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean escapedEquals(String first, String second) {
        dsTaint.addTaint(second);
        dsTaint.addTaint(first);
        {
            boolean var1F61A1CA58188B3C323B0BC1A8DADBE6_472782702 = (first.indexOf('%') != second.indexOf('%'));
            {
                boolean var9A92D953275813B0E21E2ACB41134B3B_1205909820 = (first.equals(second));
            } //End block
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var9722F6B33E3926CBF63854BB7D6FD389_1725177316 = ((index = first.indexOf('%', prevIndex)) != -1
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
        boolean var82012BF29BC079AE3198FB95B5CF6151_200399165 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.260 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "C341ADB11724C6DDE53E120F8198AF20")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        URI uri;
        uri = (URI) o;
        {
            {
                boolean var60CDEB48A7F58F8237D705D7C40D17CC_1139058525 = (!escapedEquals(uri.fragment, fragment));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var38EA33084FCA86881E8FD72A38A7749C_1847306870 = (!uri.scheme.equalsIgnoreCase(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var7E67A78714F419D789626F935DC27349_88434760 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
        } //End block
        {
            {
                boolean varA8C91154088202E89FE7FC4E6E5FD0C6_1272924770 = (!escapedEquals(path, uri.path));
            } //End collapsed parenthetic
            {
                {
                    boolean var7C1AA47824584214BA2C304C225799C2_1261931711 = (!escapedEquals(uri.query, query));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varCFCD5A99259213E0C97153FBD1F01864_759856442 = (escapedEquals(uri.authority, authority));
                } //End block
                {
                    {
                        boolean var157801492CF3B05F03DFA16E5EB86961_313299637 = (!host.equalsIgnoreCase(uri.host));
                    } //End collapsed parenthetic
                    {
                        boolean varB9E57D7781CD81877C81BF504253B25D_106517228 = (escapedEquals(userInfo, uri.userInfo));
                    } //End block
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.260 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "FA0BB2BEE07FE20A886DD0258ABDE91D")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.260 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "BD77B3B6F5C2D390D52DA2B71A705F84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSchemeSpecificPart() {
        String var7875D41A22421B5A304A7CD3C5AB8974_619331832 = (decode(schemeSpecificPart));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(schemeSpecificPart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.260 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "9F241102F2CB5473620757AE00F4B5B6")
    @DSModeled(DSC.SAFE)
    public String getRawSchemeSpecificPart() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return schemeSpecificPart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "154F00C8D6D992E0B146425AD4908144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAuthority() {
        String varF4C7A08ADB065D139D1BB7B58F758350_636876773 = (decode(authority));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(authority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "1CBD7659967EEA95ED39A8FAE1D2BFA9")
    @DSModeled(DSC.SAFE)
    public String getRawAuthority() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "75C66DC7B42FE9448502A23BAFF57D9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserInfo() {
        String var9C6358D0890AD3F5593691ED1A446F7E_597412790 = (decode(userInfo));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(userInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "34959120F412409B6B343740E03823AE")
    @DSModeled(DSC.SAFE)
    public String getRawUserInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "5963FFD88478AF2B93ECD8C406035DCE")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.261 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8BF4A6FA909B3C248D759F576AC567CD")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "2A640965B2A1EF7730E7F2E19ED03ACA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getEffectivePort() {
        int var12709C286048EEEA3C7AFAA905EEAD9D_2131794866 = (getEffectivePort(scheme, port));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "DBA86EE18C217D1847FAC22304B53AD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPath() {
        String var3DFD2ABA068496EC30FEDDF853DF5DE9_525873475 = (decode(path));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "82DE8AB9831371119D428812307AA419")
    @DSModeled(DSC.SAFE)
    public String getRawPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "EE02CCC73132845CD63675036C53CE42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuery() {
        String var9B0A08ED8AB1A015FDF838C8B0A427EC_1211128781 = (decode(query));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(query);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "9A095F333EB175562B749CE507BEACA5")
    @DSModeled(DSC.SAFE)
    public String getRawQuery() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "8B775E24765CB11B19FE04C27708E570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFragment() {
        String var88CBC913E182725BFF1DA3351FDEDD88_1667831362 = (decode(fragment));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(fragment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.262 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "2321D4D5C8E69B415BE2FD142BED8CFA")
    @DSModeled(DSC.SAFE)
    public String getRawFragment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.263 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "7909F5CF0CB02B7AF85C6CE998BD6B89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            hash = getHashString().hashCode();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hash == -1) {
            //hash = getHashString().hashCode();
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.263 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "C0FACF095F8B66983772E72872488FF8")
    @DSModeled(DSC.SAFE)
    public boolean isAbsolute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return absolute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.263 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "AA3837BCB662C81B615B8BF91DBF486E")
    @DSModeled(DSC.SAFE)
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.263 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "430E76287CB039397EE2318307AE4381")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String normalize(String path, boolean discardRelativePrefix) {
        dsTaint.addTaint(discardRelativePrefix);
        dsTaint.addTaint(path);
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.264 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "974AE3F0C81363C32A567833D40A70D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI normalize() {
        String normalizedPath;
        normalizedPath = normalize(path, false);
        {
            boolean varED6BB76AF8F0E8C24432884623407A00_851364857 = (path.equals(normalizedPath));
        } //End collapsed parenthetic
        URI result;
        result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
        return (URI)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.264 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "46E86C6E7DE2E6E5BE9E85ED9644F295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI parseServerAuthority() throws URISyntaxException {
        {
            parseAuthority(true);
        } //End block
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!serverAuthority) {
            //parseAuthority(true);
        //}
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.265 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "8BB7A79181F16C4F7F366ED66F5024E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI relativize(URI relative) {
        dsTaint.addTaint(relative.dsTaint);
        {
            {
                boolean varC865ACA7FB0CCF69283F042F0DB61312_496536703 = (!scheme
                .equals(relative.scheme));
            } //End flattened ternary
        } //End collapsed parenthetic
        {
            {
                boolean varE0036196913086AF15703499E78ECF8B_1891423084 = (!authority
                .equals(relative.authority));
            } //End flattened ternary
        } //End collapsed parenthetic
        String thisPath;
        thisPath = normalize(path, false);
        String relativePath;
        relativePath = normalize(relative.path, false);
        {
            boolean varEDBF7EABD9E353975E483312E9BAC550_509178420 = (!thisPath.equals(relativePath));
            {
                thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
                {
                    boolean varDC148464305F08DF1780EDF47FFC747D_983011490 = (!relativePath.startsWith(thisPath));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        URI result;
        result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.266 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "EA7710B3A886EA02F3D07C03544A6174")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI resolve(URI relative) {
        dsTaint.addTaint(relative.dsTaint);
        {
            URI result;
            result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
        } //End block
        {
            boolean var03F21B31825B83006AD962520A46A4CC_425708012 = (relative.path.isEmpty() && relative.scheme == null && relative.query == null);
            {
                URI result;
                result = duplicate();
                result.fragment = relative.fragment;
            } //End block
        } //End collapsed parenthetic
        URI result;
        result = duplicate();
        result.fragment = relative.fragment;
        result.query = relative.query;
        String resolvedPath;
        {
            boolean varEC53DB095CB8776983E38D0B1831503B_1734822479 = (relative.path.startsWith("/"));
            {
                resolvedPath = relative.path;
            } //End block
            {
                boolean var64B3618E3CF5D0DE8D9BCC96B26D0E61_331943008 = (relative.path.isEmpty());
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
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.266 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "83048E188DCD9D71CE4F86BF0AE83995")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.267 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "FE082B362E6F75EA205B494F3CEFB211")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI resolve(String relative) {
        dsTaint.addTaint(relative);
        URI var5A7A8223936F4960FA1E9C098A207BC6_1175080557 = (resolve(create(relative)));
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resolve(create(relative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.267 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "ECF4DABEBBAD406DA46FF5C486AED84E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String decode(String s) {
        dsTaint.addTaint(s);
        {
            Object var5ADA1A15FA20C8D504B488D0D2BCF9C4_1986707571 = (UriCodec.decode(s));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s != null ? UriCodec.decode(s) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.267 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "0E898753D304E11873C5AB44329C9CB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toASCIIString() {
        StringBuilder result;
        result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        String varEA70154FDA28CC59402440C6317B57EF_951846110 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //ASCII_ONLY.appendEncoded(result, toString());
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.267 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "0965A3F72DBCFD7AB2BD654A2CCBBEC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.268 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "4B7A4E0177E532EDA03DE20162AFF30E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getHashString() {
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
        String var52FF3CFAC0CF240166E68B4792BA0D90_1987034105 = (convertHexToLowerCase(result.toString()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.268 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "F47312A23F21AE54AA9805DD4D7C0073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL toURL() throws MalformedURLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI is not absolute: " + toString());
        } //End block
        URL var65628859BF01FE50778C4D6D55A80A22_238857033 = (new URL(toString()));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!absolute) {
            //throw new IllegalArgumentException("URI is not absolute: " + toString());
        //}
        //return new URL(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.268 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "055AC99CAE78ACE409339BCD599CEF72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
        in.defaultReadObject();
        try 
        {
            parseURI(string, false);
        } //End block
        catch (URISyntaxException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException(e.toString());
        } //End block
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //try {
            //parseURI(string, false);
        //} catch (URISyntaxException e) {
            //throw new IOException(e.toString());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.268 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "B4025707D6EECA1B2EA9DE3C6682D04F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(out.dsTaint);
        toString();
        out.defaultWriteObject();
        // ---------- Original Method ----------
        //toString();
        //out.defaultWriteObject();
    }

    
    private static class PartEncoder extends UriCodec {
        private String extraLegalCharacters;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.269 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "959C0ADAC08985380FB548C243D42C8F")
        @DSModeled(DSC.SAFE)
         PartEncoder(String extraLegalCharacters) {
            dsTaint.addTaint(extraLegalCharacters);
            // ---------- Original Method ----------
            //this.extraLegalCharacters = extraLegalCharacters;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.269 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "4DE468A53C9ABC68BB007077721FE14A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            boolean var0AABE6B03E9E209976286093DF507BCC_2114884367 = (UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c)));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return UNRESERVED.indexOf(c) != -1
                    //|| PUNCTUATION.indexOf(c) != -1
                    //|| extraLegalCharacters.indexOf(c) != -1
                    //|| (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c));
        }

        
    }


    
    private static final long serialVersionUID = -6052424284110960213l;
    static final String UNRESERVED = "_-!.~\'()*";
    static final String PUNCTUATION = ",;:$&+=";
    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    static final UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    private static final UriCodec ASCII_ONLY = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.269 -0400", hash_original_method = "02ABED517C80D26C77E9E33853271AB3", hash_generated_method = "E9808475BBCDEE2703E5A2C63CDF75E7")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c <= 127;
        }

        
}; //Transformed anonymous class
}

