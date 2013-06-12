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
    private static final long serialVersionUID = -6052424284110960213l;
    static final String UNRESERVED = "_-!.~\'()*";
    static final String PUNCTUATION = ",;:$&+=";
    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
    static final UriCodec ALL_LEGAL_ENCODER = new PartEncoder("?/[]@");
    private static final UriCodec ASCII_ONLY = new UriCodec() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.379 -0400", hash_original_method = "02ABED517C80D26C77E9E33853271AB3", hash_generated_method = "4BEF00439CC6FE2E44C2B1669DD5C2DD")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return c <= 127;
        }

        
}; //Transformed anonymous class
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.382 -0400", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "E7D7E9FA73D900BE29E4463AA3AD503F")
    @DSModeled(DSC.SAFE)
    private URI() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.383 -0400", hash_original_method = "81BA8F3B1394F61F87D69C567F9782CA", hash_generated_method = "F0684554A5DB5FAD20CF13188E17D94C")
    @DSModeled(DSC.SAFE)
    public URI(String spec) throws URISyntaxException {
        dsTaint.addTaint(spec);
        parseURI(spec, false);
        // ---------- Original Method ----------
        //parseURI(spec, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.387 -0400", hash_original_method = "F4D6A57E88E582E23AEC47906A7180EC", hash_generated_method = "D276B361301A739FEEB206BFFB45E2D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.398 -0400", hash_original_method = "449C250DB61724F5848BC66D065240CA", hash_generated_method = "2684B7A24FE92C2402058C24F7E811B2")
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
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_131883587 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
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
                boolean var550E64C193B5291AD437B9B1D9496F50_1797295335 = (host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.406 -0400", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "DE8FDD6779C40788AD50B9896F281F85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
        dsTaint.addTaint(host);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fragment);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.411 -0400", hash_original_method = "71F6E3E8DB1B58D64CBF907E96A43001", hash_generated_method = "EC91A03633A120E2CEFFADE2D0FB6054")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI(String scheme, String authority, String path, String query,
            String fragment) throws URISyntaxException {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(scheme);
        dsTaint.addTaint(query);
        dsTaint.addTaint(path);
        dsTaint.addTaint(fragment);
        {
            boolean var6F10BFA78E13D64EEB10B899B0516A7F_1105589975 = (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.421 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "CB7CA2FA2E57B4ED3BC9F00B7A9936E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        dsTaint.addTaint(forceServer);
        dsTaint.addTaint(uri);
        int fragmentStart;
        fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
        {
            boolean var14906E87F75C4EB9DB697B7FC771BD9F_1313774049 = (fragmentStart < uri.length());
            {
                fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
            } //End block
        } //End collapsed parenthetic
        int start;
        int colon;
        colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
        {
            boolean varA7FDD5A6BBA9720FEB70A13E43618B16_1607196226 = (colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart));
            {
                absolute = true;
                scheme = validateScheme(uri, colon);
                start = colon + 1;
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Scheme-specific part expected", start);
                } //End block
                {
                    boolean varEBC930CB1CD455F7868E4252B2B7D45B_431972336 = (!uri.regionMatches(start, "/", 0, 1));
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
            boolean var5757BFA7159BA6600285D2DC55CA28A4_1468862934 = (uri.regionMatches(start, "//", 0, 2));
            {
                int authorityStart;
                authorityStart = start + 2;
                fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
                {
                    boolean var1B2B73CCD1123E5D8F07A549A84A962C_1424258037 = (authorityStart == uri.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.425 -0400", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "C802EA8971B97B11EEDBA500F887F273")
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
                    boolean varF659B01EBB7D3C509A86E3BFA39CC1B5_585054768 = (!UrlUtils.isValidSchemeChar(i, uri.charAt(i)));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(uri, "Illegal character in scheme", 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varE30E35E4F02CF3489E82DF39B786C8EE_676487356 = (uri.substring(0, end));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.439 -0400", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "6B29E8480B505AB84E953E08044E2A5F")
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
                boolean var471C201E222440759958E44C5A2F8C2C_1187012467 = (index < (temp.length() - 1));
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
            boolean var07D9E4585E11834C381219EB624A85F7_1371816120 = (tempHost.isEmpty());
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(authority, "Expected host", hostIndex);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var158075BD2E1D16639FB8BCBA31A90016_515481457 = (!isValidHost(forceServer, tempHost));
        } //End collapsed parenthetic
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.442 -0400", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "E2B03C82E634460C200581F8B714EB83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void validateUserInfo(String uri, String userInfo, int index) throws URISyntaxException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(userInfo);
        dsTaint.addTaint(uri);
        {
            int i;
            i = 0;
            boolean var61BE23789239FB4C090D5853B97C62FB_1373177270 = (i < userInfo.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.462 -0400", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "75B52856F8C1E1B702D2BC27F7330715")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        dsTaint.addTaint(host);
        dsTaint.addTaint(forceServer);
        {
            boolean varFCCCD9BDBC603228D4710DD2E5A9B32F_871331453 = (host.startsWith("["));
            {
                {
                    boolean varF9599A0F269A93198F48A20A694972EC_122325134 = (!host.endsWith("]"));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varD5E87321776926869A9F8CCC6C3D14FA_736026714 = (InetAddress.isNumeric(host));
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Malformed IPv6 address");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var36FFAEAF88FC26FFC5276B550B24D5DE_377016026 = (host.indexOf('[') != -1 || host.indexOf(']') != -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new URISyntaxException(host, "Illegal character in host name", 0);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = host.lastIndexOf('.');
        {
            boolean var62B5BEA078C6AF897DE86B7C91F4DAEC_1315539407 = (index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1)));
            {
                {
                    boolean var60D4AC8ED4B08A7A4E9E67A3B8F29C40_26161402 = (isValidDomainName(host));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.465 -0400", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "A02861CAED915244F0BF898BC00F7299")
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
                    boolean var092620AA3BCBDBEC4B02F610B8967169_386269498 = (lastLabel.startsWith("-") || lastLabel.endsWith("-"));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var62581F9350E01C0148C5B044A3636F9A_1987805957 = (!lastLabel.equals(host));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.477 -0400", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "25B0F7225E08ED49EE58AB55C22DDB1E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.479 -0400", hash_original_method = "01A5D2BAF7448F542F0C842BB71CF77A", hash_generated_method = "5CFE6B8E723650D4BB791547D5DBF394")
    public static URI create(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.485 -0400", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "C00B625355C1802F6158EF8AA189B180")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.487 -0400", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "B8E81FBB3001E299422FC378CED1833F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String convertHexToLowerCase(String s) {
        dsTaint.addTaint(s);
        StringBuilder result;
        result = new StringBuilder("");
        {
            boolean varEB6442064EDBB8B51A5716AA5B8E92B3_1730623767 = (s.indexOf('%') == -1);
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var3FA97A1C7FD8BD3DFDFB4FA1562BC71E_520899868 = ((index = s.indexOf('%', prevIndex)) != -1);
            {
                result.append(s.substring(prevIndex, index + 1));
                result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
                index += 3;
                prevIndex = index;
            } //End block
        } //End collapsed parenthetic
        String varEA70154FDA28CC59402440C6317B57EF_561647995 = (result.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.490 -0400", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "FA95A4684E57D8BB3E6ADE1C301C3F80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean escapedEquals(String first, String second) {
        dsTaint.addTaint(second);
        dsTaint.addTaint(first);
        {
            boolean var1F61A1CA58188B3C323B0BC1A8DADBE6_1351573196 = (first.indexOf('%') != second.indexOf('%'));
            {
                boolean var9A92D953275813B0E21E2ACB41134B3B_699527858 = (first.equals(second));
            } //End block
        } //End collapsed parenthetic
        int index, prevIndex;
        prevIndex = 0;
        {
            boolean var9722F6B33E3926CBF63854BB7D6FD389_830674318 = ((index = first.indexOf('%', prevIndex)) != -1
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
        boolean var82012BF29BC079AE3198FB95B5CF6151_1142200309 = (first.substring(prevIndex).equals(second.substring(prevIndex)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.504 -0400", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "0BADC39829643577C45DFCA8F99AA008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        URI uri;
        uri = (URI) o;
        {
            {
                boolean var60CDEB48A7F58F8237D705D7C40D17CC_1474287726 = (!escapedEquals(uri.fragment, fragment));
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var38EA33084FCA86881E8FD72A38A7749C_550491566 = (!uri.scheme.equalsIgnoreCase(scheme));
            } //End collapsed parenthetic
        } //End block
        {
            boolean var7E67A78714F419D789626F935DC27349_473791164 = (escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart));
        } //End block
        {
            {
                boolean varA8C91154088202E89FE7FC4E6E5FD0C6_1195777193 = (!escapedEquals(path, uri.path));
            } //End collapsed parenthetic
            {
                {
                    boolean var7C1AA47824584214BA2C304C225799C2_449051784 = (!escapedEquals(uri.query, query));
                } //End collapsed parenthetic
            } //End block
            {
                {
                    boolean varCFCD5A99259213E0C97153FBD1F01864_253107680 = (escapedEquals(uri.authority, authority));
                } //End block
                {
                    {
                        boolean var157801492CF3B05F03DFA16E5EB86961_752399089 = (!host.equalsIgnoreCase(uri.host));
                    } //End collapsed parenthetic
                    {
                        boolean varB9E57D7781CD81877C81BF504253B25D_828255660 = (escapedEquals(userInfo, uri.userInfo));
                    } //End block
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.506 -0400", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "6809119C812010AE912E08971A3DC4F5")
    @DSModeled(DSC.SAFE)
    public String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return scheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.507 -0400", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "30653E55D3DB7790F62F73471A443E7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSchemeSpecificPart() {
        String var7875D41A22421B5A304A7CD3C5AB8974_1424156631 = (decode(schemeSpecificPart));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(schemeSpecificPart);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.508 -0400", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "F2AC097D72C4945671E2D1439BB64476")
    @DSModeled(DSC.SAFE)
    public String getRawSchemeSpecificPart() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return schemeSpecificPart;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.509 -0400", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "793C44FC090A8C8032F9DA4F4182CF7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAuthority() {
        String varF4C7A08ADB065D139D1BB7B58F758350_647208359 = (decode(authority));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(authority);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.510 -0400", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "15A809D7CC28C250038926F48A97935C")
    @DSModeled(DSC.SAFE)
    public String getRawAuthority() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.511 -0400", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "50EFD5341FE2388D1534D49FC83DACF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getUserInfo() {
        String var9C6358D0890AD3F5593691ED1A446F7E_1439013888 = (decode(userInfo));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(userInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.514 -0400", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "89F555A211D3DA502838170F033A85C8")
    @DSModeled(DSC.SAFE)
    public String getRawUserInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.518 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1A7C3D805857A92DA91C7FDF3E76506B")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.518 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "17AF8596D6B7DC38593E7C5BC3B81881")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.519 -0400", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "46EAC37108585DC4ADD4B5AEDC80D1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getEffectivePort() {
        int var12709C286048EEEA3C7AFAA905EEAD9D_1110747375 = (getEffectivePort(scheme, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getEffectivePort(scheme, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.520 -0400", hash_original_method = "288F4243CB2CAE5D0A19FF04182F1452", hash_generated_method = "0459D8510EE02E0CD1B881E8D341B39B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.523 -0400", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "70646983E2A753392726A401869DFEBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPath() {
        String var3DFD2ABA068496EC30FEDDF853DF5DE9_2041617942 = (decode(path));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.526 -0400", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "0A78B931351B28B5329393629B843037")
    @DSModeled(DSC.SAFE)
    public String getRawPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.531 -0400", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "33F0BB1774DF22B2B543383E6617DBE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getQuery() {
        String var9B0A08ED8AB1A015FDF838C8B0A427EC_28223233 = (decode(query));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(query);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.533 -0400", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "D4B6715A22835A63380D02DD40221FB0")
    @DSModeled(DSC.SAFE)
    public String getRawQuery() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.534 -0400", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "585B055829CE12AB27A459C46E8B6CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFragment() {
        String var88CBC913E182725BFF1DA3351FDEDD88_945128673 = (decode(fragment));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return decode(fragment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.538 -0400", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "3290DAD5D83D2FD316D5D9E57FF380E4")
    @DSModeled(DSC.SAFE)
    public String getRawFragment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return fragment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.540 -0400", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "DC7AB5066FF1216FE2A8E74152877AFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.546 -0400", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "B0B0AED2ED8F5856E0B3EEFED4613DB1")
    @DSModeled(DSC.SAFE)
    public boolean isAbsolute() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return absolute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.547 -0400", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "4DA3BB9446989C1035436D8CE1815012")
    @DSModeled(DSC.SAFE)
    public boolean isOpaque() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.549 -0400", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "5733D9226DE5408E9BA8359A9E698F0C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.550 -0400", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "67C6700B4BEFD0BC15F2AAA1526F9CB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI normalize() {
        String normalizedPath;
        normalizedPath = normalize(path, false);
        {
            boolean varED6BB76AF8F0E8C24432884623407A00_935892984 = (path.equals(normalizedPath));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.551 -0400", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "7112AD6DAF0727980FEEEE10EB650801")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.555 -0400", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "0F109C09113B656846C2EA78FAD96AF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI relativize(URI relative) {
        dsTaint.addTaint(relative.dsTaint);
        {
            {
                boolean varC865ACA7FB0CCF69283F042F0DB61312_2109075224 = (!scheme
                .equals(relative.scheme));
            } //End flattened ternary
        } //End collapsed parenthetic
        {
            {
                boolean varE0036196913086AF15703499E78ECF8B_1309125611 = (!authority
                .equals(relative.authority));
            } //End flattened ternary
        } //End collapsed parenthetic
        String thisPath;
        thisPath = normalize(path, false);
        String relativePath;
        relativePath = normalize(relative.path, false);
        {
            boolean varEDBF7EABD9E353975E483312E9BAC550_1656536376 = (!thisPath.equals(relativePath));
            {
                thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);
                {
                    boolean varDC148464305F08DF1780EDF47FFC747D_1351663277 = (!relativePath.startsWith(thisPath));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.560 -0400", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "205DBFD0AF0C03E1541EB3AB6B7C9717")
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
            boolean var03F21B31825B83006AD962520A46A4CC_537234867 = (relative.path.isEmpty() && relative.scheme == null && relative.query == null);
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
            boolean varEC53DB095CB8776983E38D0B1831503B_580289203 = (relative.path.startsWith("/"));
            {
                resolvedPath = relative.path;
            } //End block
            {
                boolean var64B3618E3CF5D0DE8D9BCC96B26D0E61_1067670669 = (relative.path.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.562 -0400", hash_original_method = "3DD7E8659D07AF42D9C7F4A4AC66ED05", hash_generated_method = "F1B18679430B04329E9CB4E89087A0FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.563 -0400", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "2F280E927E7A0C6AD8EF3A72CDB46EAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI resolve(String relative) {
        dsTaint.addTaint(relative);
        URI var5A7A8223936F4960FA1E9C098A207BC6_2081037074 = (resolve(create(relative)));
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return resolve(create(relative));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.565 -0400", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "A363CC937BA3ADD0F77402F1F39B1990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String decode(String s) {
        dsTaint.addTaint(s);
        {
            Object var5ADA1A15FA20C8D504B488D0D2BCF9C4_104164739 = (UriCodec.decode(s));
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return s != null ? UriCodec.decode(s) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.567 -0400", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "C04C945095DACA8646803653896C37E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toASCIIString() {
        StringBuilder result;
        result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        String varEA70154FDA28CC59402440C6317B57EF_1730742464 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //ASCII_ONLY.appendEncoded(result, toString());
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.575 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "6086554AD890A18F085F9D32BF592FF5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.580 -0400", hash_original_method = "854CA4638ADB9894AD51F585C304D672", hash_generated_method = "4DA330FFFEB130E8BBEBF280046DDBD4")
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
        String var52FF3CFAC0CF240166E68B4792BA0D90_278624451 = (convertHexToLowerCase(result.toString()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.583 -0400", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "2C5CEF8C87C5FA73F63B82AD5E24CA2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL toURL() throws MalformedURLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("URI is not absolute: " + toString());
        } //End block
        URL var65628859BF01FE50778C4D6D55A80A22_1877456587 = (new URL(toString()));
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!absolute) {
            //throw new IllegalArgumentException("URI is not absolute: " + toString());
        //}
        //return new URL(toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.584 -0400", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "2D3AD1309C0E65385F157BAFF87A4E40")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.585 -0400", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "366A676DAE1D9353A7CD7E5F71A57AE7")
    @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.587 -0400", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "EE1E1D91CB165B518DDCAFCEC4B6898D")
        @DSModeled(DSC.SAFE)
         PartEncoder(String extraLegalCharacters) {
            dsTaint.addTaint(extraLegalCharacters);
            // ---------- Original Method ----------
            //this.extraLegalCharacters = extraLegalCharacters;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:54:21.589 -0400", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "2F0D11E38CAF32712672EDAA45BA54E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected boolean isRetained(char c) {
            dsTaint.addTaint(c);
            boolean var0AABE6B03E9E209976286093DF507BCC_1844861018 = (UNRESERVED.indexOf(c) != -1
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


    
}


