package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;

import libcore.net.UriCodec;
import libcore.net.url.UrlUtils;

public final class URI implements Comparable<URI>, Serializable {

    /**
     * Returns the URI formed by parsing {@code uri}. This method behaves
     * identically to the string constructor but throws a different exception
     * on failure. The constructor fails with a checked {@link
     * URISyntaxException}; this method fails with an unchecked {@link
     * IllegalArgumentException}.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.853 -0500", hash_original_method = "01A5D2BAF7448F542F0C842BB71CF77A", hash_generated_method = "5CFE6B8E723650D4BB791547D5DBF394")
    
public static URI create(String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Returns the port to use for {@code scheme} connections will use when
     * {@link #getPort} returns {@code specifiedPort}.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.891 -0500", hash_original_method = "288F4243CB2CAE5D0A19FF04182F1452", hash_generated_method = "0459D8510EE02E0CD1B881E8D341B39B")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.743 -0500", hash_original_field = "7B5DAF5B25DDE92E79435E9688C53AA1", hash_generated_field = "D9F851BAB07F16ADC844C00A2D076DA4")

    private static final long serialVersionUID = -6052424284110960213l;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.745 -0500", hash_original_field = "21104962F157B18A9116A01D9AE62088", hash_generated_field = "708B5C1D2A5145AAE93B4DCBD1DBB016")

    static final String UNRESERVED = "_-!.~\'()*";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.747 -0500", hash_original_field = "855B2EA6FFE940839797A4A9922D1C4B", hash_generated_field = "58ACB5067A7BC64309A3619F3AD62CBB")

    static final String PUNCTUATION = ",;:$&+=";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.750 -0500", hash_original_field = "8F70600D7190EA3AE3A4BF8C6F7F3A0B", hash_generated_field = "E178400A95CCD95D53BB193CEC75CD16")

    static final UriCodec USER_INFO_ENCODER = new PartEncoder("");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.752 -0500", hash_original_field = "4563B3FCE54152FF1701A2B92655DFCF", hash_generated_field = "BA21C0891E8446409D9F3F2B417FABAD")

    static final UriCodec PATH_ENCODER = new PartEncoder("/@");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.755 -0500", hash_original_field = "C3E51DA2F6BB493AC3B97920048DCD38", hash_generated_field = "B3691C302E4EAFC49A0C65C2815D1A13")

    static final UriCodec AUTHORITY_ENCODER = new PartEncoder("@[]");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.758 -0500", hash_original_field = "56C1118A2E8824B2659BB82D33C3CF9D", hash_generated_field = "67FAF76CD518CC63640B971FB53CFC1C")

    static final UriCodec FILE_AND_QUERY_ENCODER = new PartEncoder("/@?");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.760 -0500", hash_original_field = "92093BFE5C150674C90365B5E635BB86", hash_generated_field = "E7C042F6DFADEFFCB60303B26B28DAD0")

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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.778 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")

    @DSVAModeled
    private String string;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.781 -0500", hash_original_field = "AF5A968572CEFDCD6FE22E7345201E0B", hash_generated_field = "A77350C36FACC15543B26BF9F179A70D")

    private transient String scheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.783 -0500", hash_original_field = "1FCDA958859B7FDF7080A30A31C4E067", hash_generated_field = "14DBC9168C32C9C014586FA7F0B8A107")

    private transient String schemeSpecificPart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.786 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "57D185265731B43622C0B461510772A9")

    private transient String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.788 -0500", hash_original_field = "10F5F4BA00300524BD223470F05A568F", hash_generated_field = "BED672F8886D4042083406EE52B803AE")

    private transient String userInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.790 -0500", hash_original_field = "3EBF9FC23C14AE1E55EAA4D77C46C987", hash_generated_field = "0A24F4A69DB662BA59F12A9B09B3CA7F")

    private transient String host;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.792 -0500", hash_original_field = "BAF684EECB20D799A434AFCF1B13F01D", hash_generated_field = "D5EC92E1B3465138D54142DB3E99F34E")

    private transient int port = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.795 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "1E845389D3352EECA0945BADE902EA26")

    private transient String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.797 -0500", hash_original_field = "088250EB717186C03CE550061F0A72FD", hash_generated_field = "296DE38AE03D10320738C7EA0F932C4A")

    private transient String query;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.801 -0500", hash_original_field = "1351A4AFA5B1F9B1204BBA65A76690AC", hash_generated_field = "172D3480DA0AFB6E023B26EA00955132")

    private transient String fragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.803 -0500", hash_original_field = "701D992AF7D80999C8F28FA4B550CAAD", hash_generated_field = "EDD34009E3CB727B5445D7F24CB35623")

    private transient boolean opaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.805 -0500", hash_original_field = "8D99C38C1F5F78A9DC744EC1145B5599", hash_generated_field = "8B0AF94FA16DD5DBCAA078866E853806")

    private transient boolean absolute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.808 -0500", hash_original_field = "6077079CEE69C5B5634476D61973B1F5", hash_generated_field = "D4CE8185ED9C0ACE43C0C010B0E562F4")

    private transient boolean serverAuthority = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.810 -0500", hash_original_field = "0E9CC8489A4FBB9FA510FC03CD2752A3", hash_generated_field = "F58223E1E1183B179891344C3FD7FA57")

    private transient int hash = -1;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.813 -0500", hash_original_method = "73A80A2F92FBB785BC19E418E6230F90", hash_generated_method = "885DD97D94BD9686697CE4ED277E398A")
    
private URI() {}
    
    @DSComment("no suspicious activity, just calls class function")
    @DSSafe(DSCat.SAFE_OTHERS)
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

    /**
     * Creates a new URI instance of the given unencoded component parts.
     *
     * @param scheme the URI scheme, or null for a non-absolute URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.825 -0500", hash_original_method = "3ADDFDCD3FB84301D1E5780B2C0B6096", hash_generated_method = "AABE4865C1CC5E636F585E88017D1892")
    
public URI(String scheme, String host, String path, String fragment) throws URISyntaxException {
        this(scheme, null, host, -1, path, null, fragment);
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
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.834 -0400", hash_original_method = "A6104B5B1EE0EDAB23A12CFEC06EAA04", hash_generated_method = "DA9CABC9B9E9A98017F63ABE4B6F2FF1")
    private void parseURI(String uri, boolean forceServer) throws URISyntaxException {
        addTaint(forceServer);
        string = uri;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.835 -0500", hash_original_method = "7C3EE07FDCFF0269213047D1214B9B32", hash_generated_method = "EE559D9689264ACE4ECC01549C08C86C")
    
private String validateScheme(String uri, int end) throws URISyntaxException {
        if (end == 0) {
            throw new URISyntaxException(uri, "Scheme expected", 0);
        }

        for (int i = 0; i < end; i++) {
            if (!UrlUtils.isValidSchemeChar(i, uri.charAt(i))) {
                throw new URISyntaxException(uri, "Illegal character in scheme", 0);
            }
        }

        return uri.substring(0, end);
    }

    /**
     * Breaks this URI's authority into user info, host and port parts.
     *   [user-info@][host][:port]
     * If any part of this fails this method will give up and potentially leave
     * these fields with their default values.
     *
     * @param forceServer true to always throw if the authority cannot be
     *     parsed. If false, this method may still throw for some kinds of
     *     errors; this unpredictable behavior is consistent with the RI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.838 -0500", hash_original_method = "C0C315FFD2F67C196D4E9EC4D3711FBC", hash_generated_method = "BBDFD43E7F896F68E59BC90EEFEB6C27")
    
private void parseAuthority(boolean forceServer) throws URISyntaxException {
        if (authority == null) {
            return;
        }

        String tempUserInfo = null;
        String temp = authority;
        int index = temp.indexOf('@');
        int hostIndex = 0;
        if (index != -1) {
            // remove user info
            tempUserInfo = temp.substring(0, index);
            validateUserInfo(authority, tempUserInfo, 0);
            temp = temp.substring(index + 1); // host[:port] is left
            hostIndex = index + 1;
        }

        index = temp.lastIndexOf(':');
        int endIndex = temp.indexOf(']');

        String tempHost;
        int tempPort = -1;
        if (index != -1 && endIndex < index) {
            // determine port and host
            tempHost = temp.substring(0, index);

            if (index < (temp.length() - 1)) { // port part is not empty
                try {
                    tempPort = Integer.parseInt(temp.substring(index + 1));
                    if (tempPort < 0) {
                        if (forceServer) {
                            throw new URISyntaxException(authority,
                                    "Invalid port number", hostIndex + index + 1);
                        }
                        return;
                    }
                } catch (NumberFormatException e) {
                    if (forceServer) {
                        throw new URISyntaxException(authority,
                                "Invalid port number", hostIndex + index + 1);
                    }
                    return;
                }
            }
        } else {
            tempHost = temp;
        }

        if (tempHost.isEmpty()) {
            if (forceServer) {
                throw new URISyntaxException(authority, "Expected host", hostIndex);
            }
            return;
        }

        if (!isValidHost(forceServer, tempHost)) {
            return;
        }

        // this is a server based uri,
        // fill in the userInfo, host and port fields
        userInfo = tempUserInfo;
        host = tempHost;
        port = tempPort;
        serverAuthority = true;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.841 -0500", hash_original_method = "7C8CF37E6F7B87B68C0DE679D5852184", hash_generated_method = "18596FFC45CBCE8FB48752B763BB4135")
    
private void validateUserInfo(String uri, String userInfo, int index)
            throws URISyntaxException {
        for (int i = 0; i < userInfo.length(); i++) {
            char ch = userInfo.charAt(i);
            if (ch == ']' || ch == '[') {
                throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
            }
        }
    }

    /**
     * Returns true if {@code host} is a well-formed host name or IP address.
     *
     * @param forceServer true to always throw if the host cannot be parsed. If
     *     false, this method may still throw for some kinds of errors; this
     *     unpredictable behavior is consistent with the RI.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.844 -0500", hash_original_method = "A181BC4B37A51E9F8D899B7902CC2A7C", hash_generated_method = "8994C7368A32BDBD0080A7B5DC4B6CE2")
    
private boolean isValidHost(boolean forceServer, String host) throws URISyntaxException {
        if (host.startsWith("[")) {
            // IPv6 address
            if (!host.endsWith("]")) {
                throw new URISyntaxException(host,
                        "Expected a closing square bracket for IPv6 address", 0);
            }
            if (InetAddress.isNumeric(host)) {
                // If it's numeric, the presence of square brackets guarantees
                // that it's a numeric IPv6 address.
                return true;
            }
            throw new URISyntaxException(host, "Malformed IPv6 address");
        }

        // '[' and ']' can only be the first char and last char
        // of the host name
        if (host.indexOf('[') != -1 || host.indexOf(']') != -1) {
            throw new URISyntaxException(host, "Illegal character in host name", 0);
        }

        int index = host.lastIndexOf('.');
        if (index < 0 || index == host.length() - 1
                || !Character.isDigit(host.charAt(index + 1))) {
            // domain name
            if (isValidDomainName(host)) {
                return true;
            }
            if (forceServer) {
                throw new URISyntaxException(host, "Illegal character in host name", 0);
            }
            return false;
        }

        // IPv4 address?
        try {
            InetAddress ia = InetAddress.parseNumericAddress(host);
            if (ia instanceof Inet4Address) {
                return true;
            }
        } catch (IllegalArgumentException ignored) {
        }

        if (forceServer) {
            throw new URISyntaxException(host, "Malformed IPv4 address", 0);
        }
        return false;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.847 -0500", hash_original_method = "2E78BBD0316E5BD424863A1938BE67AE", hash_generated_method = "A98CBD01136C9A75AA28E59A54D9D549")
    
private boolean isValidDomainName(String host) {
        try {
            UriCodec.validateSimple(host, "-.");
        } catch (URISyntaxException e) {
            return false;
        }

        String lastLabel = null;
        for (String token : host.split("\\.")) {
            lastLabel = token;
            if (lastLabel.startsWith("-") || lastLabel.endsWith("-")) {
                return false;
            }
        }

        if (lastLabel == null) {
            return false;
        }

        if (!lastLabel.equals(host)) {
            char ch = lastLabel.charAt(0);
            if (ch >= '0' && ch <= '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares this URI with the given argument {@code uri}. This method will
     * return a negative value if this URI instance is less than the given
     * argument and a positive value if this URI instance is greater than the
     * given argument. The return value {@code 0} indicates that the two
     * instances represent the same URI. To define the order the single parts of
     * the URI are compared with each other. String components will be ordered
     * in the natural case-sensitive way. A hierarchical URI is less than an
     * opaque URI and if one part is {@code null} the URI with the undefined
     * part is less than the other one.
     *
     * @param uri
     *            the URI this instance has to compare with.
     * @return the value representing the order of the two instances.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.851 -0500", hash_original_method = "5881C9F5255DAD71BFE55D2C48CC4082", hash_generated_method = "08258B28A3BC2E919D01C10494EE2CEA")
    
public int compareTo(URI uri) {
        int ret;

        // compare schemes
        if (scheme == null && uri.scheme != null) {
            return -1;
        } else if (scheme != null && uri.scheme == null) {
            return 1;
        } else if (scheme != null && uri.scheme != null) {
            ret = scheme.compareToIgnoreCase(uri.scheme);
            if (ret != 0) {
                return ret;
            }
        }

        // compare opacities
        if (!opaque && uri.opaque) {
            return -1;
        } else if (opaque && !uri.opaque) {
            return 1;
        } else if (opaque && uri.opaque) {
            ret = schemeSpecificPart.compareTo(uri.schemeSpecificPart);
            if (ret != 0) {
                return ret;
            }
        } else {

            // otherwise both must be hierarchical

            // compare authorities
            if (authority != null && uri.authority == null) {
                return 1;
            } else if (authority == null && uri.authority != null) {
                return -1;
            } else if (authority != null && uri.authority != null) {
                if (host != null && uri.host != null) {
                    // both are server based, so compare userInfo, host, port
                    if (userInfo != null && uri.userInfo == null) {
                        return 1;
                    } else if (userInfo == null && uri.userInfo != null) {
                        return -1;
                    } else if (userInfo != null && uri.userInfo != null) {
                        ret = userInfo.compareTo(uri.userInfo);
                        if (ret != 0) {
                            return ret;
                        }
                    }

                    // userInfo's are the same, compare hostname
                    ret = host.compareToIgnoreCase(uri.host);
                    if (ret != 0) {
                        return ret;
                    }

                    // compare port
                    if (port != uri.port) {
                        return port - uri.port;
                    }
                } else { // one or both are registry based, compare the whole
                    // authority
                    ret = authority.compareTo(uri.authority);
                    if (ret != 0) {
                        return ret;
                    }
                }
            }

            // authorities are the same
            // compare paths
            ret = path.compareTo(uri.path);
            if (ret != 0) {
                return ret;
            }

            // compare queries

            if (query != null && uri.query == null) {
                return 1;
            } else if (query == null && uri.query != null) {
                return -1;
            } else if (query != null && uri.query != null) {
                ret = query.compareTo(uri.query);
                if (ret != 0) {
                    return ret;
                }
            }
        }

        // everything else is identical, so compare fragments
        if (fragment != null && uri.fragment == null) {
            return 1;
        } else if (fragment == null && uri.fragment != null) {
            return -1;
        } else if (fragment != null && uri.fragment != null) {
            ret = fragment.compareTo(uri.fragment);
            if (ret != 0) {
                return ret;
            }
        }

        // identical
        return 0;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.856 -0500", hash_original_method = "A98420F05D15A307D401E461EEAC37D0", hash_generated_method = "5687AEEC8E159769E50811B66E9C86A8")
    
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
        return clone;
    }

    /*
     * Takes a string that may contain hex sequences like %F1 or %2b and
     * converts the hex values following the '%' to lowercase
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.858 -0500", hash_original_method = "FCD362BE8E93703CF564A6DF1A0DE711", hash_generated_method = "2C6EDF9EF730E53C0245458634CF65C0")
    
private String convertHexToLowerCase(String s) {
        StringBuilder result = new StringBuilder("");
        if (s.indexOf('%') == -1) {
            return s;
        }

        int index, prevIndex = 0;
        while ((index = s.indexOf('%', prevIndex)) != -1) {
            result.append(s.substring(prevIndex, index + 1));
            result.append(s.substring(index + 1, index + 3).toLowerCase(Locale.US));
            index += 3;
            prevIndex = index;
        }
        return result.toString();
    }

    /**
     * Returns true if {@code first} and {@code second} are equal after
     * unescaping hex sequences like %F1 and %2b.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.861 -0500", hash_original_method = "6D42C9BDBF773AFA30CCB9F3B2C418F1", hash_generated_method = "BDEC43497CD126F6BAF4CDD6DD043F9B")
    
private boolean escapedEquals(String first, String second) {
        if (first.indexOf('%') != second.indexOf('%')) {
            return first.equals(second);
        }

        int index, prevIndex = 0;
        while ((index = first.indexOf('%', prevIndex)) != -1
                && second.indexOf('%', prevIndex) == index) {
            boolean match = first.substring(prevIndex, index).equals(
                    second.substring(prevIndex, index));
            if (!match) {
                return false;
            }

            match = first.substring(index + 1, index + 3).equalsIgnoreCase(
                    second.substring(index + 1, index + 3));
            if (!match) {
                return false;
            }

            index += 3;
            prevIndex = index;
        }
        return first.substring(prevIndex).equals(second.substring(prevIndex));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.865 -0500", hash_original_method = "DB7C53AF9EACD0E0331CDA9F529DED49", hash_generated_method = "94E9D99A301365B092DEF6BEE6C6EFF6")
    
@Override public boolean equals(Object o) {
        if (!(o instanceof URI)) {
            return false;
        }
        URI uri = (URI) o;

        if (uri.fragment == null && fragment != null || uri.fragment != null
                && fragment == null) {
            return false;
        } else if (uri.fragment != null && fragment != null) {
            if (!escapedEquals(uri.fragment, fragment)) {
                return false;
            }
        }

        if (uri.scheme == null && scheme != null || uri.scheme != null
                && scheme == null) {
            return false;
        } else if (uri.scheme != null && scheme != null) {
            if (!uri.scheme.equalsIgnoreCase(scheme)) {
                return false;
            }
        }

        if (uri.opaque && opaque) {
            return escapedEquals(uri.schemeSpecificPart,
                    schemeSpecificPart);
        } else if (!uri.opaque && !opaque) {
            if (!escapedEquals(path, uri.path)) {
                return false;
            }

            if (uri.query != null && query == null || uri.query == null
                    && query != null) {
                return false;
            } else if (uri.query != null && query != null) {
                if (!escapedEquals(uri.query, query)) {
                    return false;
                }
            }

            if (uri.authority != null && authority == null
                    || uri.authority == null && authority != null) {
                return false;
            } else if (uri.authority != null && authority != null) {
                if (uri.host != null && host == null || uri.host == null
                        && host != null) {
                    return false;
                } else if (uri.host == null && host == null) {
                    // both are registry based, so compare the whole authority
                    return escapedEquals(uri.authority, authority);
                } else { // uri.host != null && host != null, so server-based
                    if (!host.equalsIgnoreCase(uri.host)) {
                        return false;
                    }

                    if (port != uri.port) {
                        return false;
                    }

                    if (uri.userInfo != null && userInfo == null
                            || uri.userInfo == null && userInfo != null) {
                        return false;
                    } else if (uri.userInfo != null && userInfo != null) {
                        return escapedEquals(userInfo, uri.userInfo);
                    } else {
                        return true;
                    }
                }
            } else {
                // no authority
                return true;
            }

        } else {
            // one is opaque, the other hierarchical
            return false;
        }
    }

    /**
     * Returns the scheme of this URI, or null if this URI has no scheme. This
     * is also known as the protocol.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.868 -0500", hash_original_method = "C01635CAE84CEFF188CA85B1E841E2AF", hash_generated_method = "9D11AD0B611F352DC84C8E1A6B825617")
    
public String getScheme() {
        return scheme;
    }

    /**
     * Returns the decoded scheme-specific part of this URI, or null if this URI
     * has no scheme-specific part.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.870 -0500", hash_original_method = "38320513FEDFF9F58DEA1E075C778208", hash_generated_method = "38815444E27955D92D1ECC864169EFFB")
    
public String getSchemeSpecificPart() {
        return decode(schemeSpecificPart);
    }

    /**
     * Returns the encoded scheme-specific part of this URI, or null if this URI
     * has no scheme-specific part.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.873 -0500", hash_original_method = "86531F78EA1B0DD0E474B0280C353B39", hash_generated_method = "9E9EB7CDAC25885B08CC44A5BBEE7762")
    
public String getRawSchemeSpecificPart() {
        return schemeSpecificPart;
    }

    /**
     * Returns the decoded authority part of this URI, or null if this URI has
     * no authority.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.875 -0500", hash_original_method = "4FA84E8B57858A7AED973819C0FBFA33", hash_generated_method = "FBBDD060B77EAC76E5B14CFDB0CEC4C8")
    
public String getAuthority() {
        return decode(authority);
    }

    /**
     * Returns the encoded authority of this URI, or null if this URI has no
     * authority.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.877 -0500", hash_original_method = "D7819D822B599F6322BA89A8602769F8", hash_generated_method = "6F0A90091BEA2A0248D6310DCFBD4A25")
    
public String getRawAuthority() {
        return authority;
    }

    /**
     * Returns the decoded user info of this URI, or null if this URI has no
     * user info.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.879 -0500", hash_original_method = "A9FAB4D519B7225CD37F806FC9DB8527", hash_generated_method = "532249EA71A87CA78C7C326ACC4A1357")
    
public String getUserInfo() {
        return decode(userInfo);
    }

    /**
     * Returns the encoded user info of this URI, or null if this URI has no
     * user info.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.881 -0500", hash_original_method = "DAA16275F755FA7272E7A6BF143307B3", hash_generated_method = "58C0D75C1A5C7F1EB00F10A6C966B380")
    
public String getRawUserInfo() {
        return userInfo;
    }

    /**
     * Returns the host of this URI, or null if this URI has no host.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.884 -0500", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1B655222E0C0F88C57DF58BCA9BFA498")
    
public String getHost() {
        return host;
    }

    /**
     * Returns the port number of this URI, or {@code -1} if this URI has no
     * explicit port.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.887 -0500", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "8D4984D37D0017078DF4701090E35F25")
    
public int getPort() {
        return port;
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.889 -0500", hash_original_method = "06FADD20E42E3EC8160E0651D1C1C356", hash_generated_method = "897C9AD6910952C18BE3A8651DD7E36A")
    
public int getEffectivePort() {
        return getEffectivePort(scheme, port);
    }

    /**
     * Returns the decoded path of this URI, or null if this URI has no path.
     */
    @DSComment("no suspicious activity, just calls class function")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.894 -0500", hash_original_method = "69A276867D65FB87E2E914A462B7AF91", hash_generated_method = "6E21F7B60172D61B590581CB1F93CE0D")
    
public String getPath() {
        return decode(path);
    }

    /**
     * Returns the encoded path of this URI, or null if this URI has no path.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.896 -0500", hash_original_method = "C60E164890B13C98164350819EFAF732", hash_generated_method = "91FC1951C11DED3DB62B8464EAFEE386")
    
public String getRawPath() {
        return path;
    }

    /**
     * Returns the decoded query of this URI, or null if this URI has no query.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.898 -0500", hash_original_method = "630FC8264E2AC16B7C7C1CF5EE4E7165", hash_generated_method = "FA638F1C89104675473C43ECCFFED70F")
    
public String getQuery() {
        return decode(query);
    }

    /**
     * Returns the encoded query of this URI, or null if this URI has no query.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.900 -0500", hash_original_method = "1B73FD5BF97DE0B30570BEC9088948AD", hash_generated_method = "F9D24AD4BFFCA3BEDF79DDA7F06DE0E0")
    
public String getRawQuery() {
        return query;
    }

    /**
     * Returns the decoded fragment of this URI, or null if this URI has no
     * fragment.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.903 -0500", hash_original_method = "997A8F1DE06A015557806F06709A8E7B", hash_generated_method = "223D497BDC1D4ADD98DB0C413A60448B")
    
public String getFragment() {
        return decode(fragment);
    }

    /**
     * Gets the encoded fragment of this URI, or null if this URI has no
     * fragment.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.905 -0500", hash_original_method = "7B682CDC9E7215B6CAB5B55C992B88A5", hash_generated_method = "3C47879D55462CE0E125B568D982E5B7")
    
public String getRawFragment() {
        return fragment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.908 -0500", hash_original_method = "7F32815A976A993D04E3E3C7E39CEF39", hash_generated_method = "3A9B64656A6C71327BB5A2E8309713FA")
    
@Override public int hashCode() {
        if (hash == -1) {
            hash = getHashString().hashCode();
        }
        return hash;
    }

    /**
     * Returns true if this URI is absolute, which means that a scheme is
     * defined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.910 -0500", hash_original_method = "D85A39136D4004ABB79E6EE2109136C5", hash_generated_method = "D7805EB8A2CDCEA2528384E89880D303")
    
public boolean isAbsolute() {
        // TODO: simplify to 'scheme != null' ?
        return absolute;
    }

    /**
     * Returns true if this URI is opaque. Opaque URIs are absolute and have a
     * scheme-specific part that does not start with a slash character. All
     * parts except scheme, scheme-specific and fragment are undefined.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.912 -0500", hash_original_method = "E927F529D329E66C9C89B04CCA4C92BD", hash_generated_method = "2DB9AC0A20EA2F1287878FFD89410111")
    
public boolean isOpaque() {
        return opaque;
    }

    /**
     * Returns the normalized path.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.916 -0500", hash_original_method = "E5D7EFF0C51BEFD641F2F6FB80CD17F5", hash_generated_method = "F96D3A2403620B571D209F169558FE70")
    
private String normalize(String path, boolean discardRelativePrefix) {
        path = UrlUtils.canonicalizePath(path, discardRelativePrefix);

        /*
         * If the path contains a colon before the first colon, prepend
         * "./" to differentiate the path from a scheme prefix.
         */
        int colon = path.indexOf(':');
        if (colon != -1) {
            int slash = path.indexOf('/');
            if (slash == -1 || colon < slash) {
                path = "./" + path;
            }
        }

        return path;
    }

    /**
     * Normalizes the path part of this URI.
     *
     * @return an URI object which represents this instance with a normalized
     *         path.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.918 -0500", hash_original_method = "516FFF274D5A3C3904BD2A35075D82E5", hash_generated_method = "C003D4D15FB3B793E0C405F27DCF0A14")
    
public URI normalize() {
        if (opaque) {
            return this;
        }
        String normalizedPath = normalize(path, false);
        // if the path is already normalized, return this
        if (path.equals(normalizedPath)) {
            return this;
        }
        // get an exact copy of the URI re-calculate the scheme specific part
        // since the path of the normalized URI is different from this URI.
        URI result = duplicate();
        result.path = normalizedPath;
        result.setSchemeSpecificPart();
        return result;
    }

    /**
     * Tries to parse the authority component of this URI to divide it into the
     * host, port, and user-info. If this URI is already determined as a
     * ServerAuthority this instance will be returned without changes.
     *
     * @return this instance with the components of the parsed server authority.
     * @throws URISyntaxException
     *             if the authority part could not be parsed as a server-based
     *             authority.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.920 -0500", hash_original_method = "561A780B99BF7A4044A2E8788BD03387", hash_generated_method = "E3764ABE4D36BE19BCC27AB1D9DDAF59")
    
public URI parseServerAuthority() throws URISyntaxException {
        if (!serverAuthority) {
            parseAuthority(true);
        }
        return this;
    }

    /**
     * Makes the given URI {@code relative} to a relative URI against the URI
     * represented by this instance.
     *
     * @param relative
     *            the URI which has to be relativized against this URI.
     * @return the relative URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.923 -0500", hash_original_method = "BFE2EB4322D518CCAA638FC4B16C8964", hash_generated_method = "D04D134C70C2BDE3A7BDBC775701635E")
    
public URI relativize(URI relative) {
        if (relative.opaque || opaque) {
            return relative;
        }

        if (scheme == null ? relative.scheme != null : !scheme
                .equals(relative.scheme)) {
            return relative;
        }

        if (authority == null ? relative.authority != null : !authority
                .equals(relative.authority)) {
            return relative;
        }

        // normalize both paths
        String thisPath = normalize(path, false);
        String relativePath = normalize(relative.path, false);

        /*
         * if the paths aren't equal, then we need to determine if this URI's
         * path is a parent path (begins with) the relative URI's path
         */
        if (!thisPath.equals(relativePath)) {
            // drop everything after the last slash in this path
            thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);

            /*
             * if the relative URI's path doesn't start with this URI's path,
             * then just return the relative URI; the URIs have nothing in
             * common
             */
            if (!relativePath.startsWith(thisPath)) {
                return relative;
            }
        }

        URI result = new URI();
        result.fragment = relative.fragment;
        result.query = relative.query;
        // the result URI is the remainder of the relative URI's path
        result.path = relativePath.substring(thisPath.length());
        result.setSchemeSpecificPart();
        return result;
    }

    /**
     * Resolves the given URI {@code relative} against the URI represented by
     * this instance.
     *
     * @param relative
     *            the URI which has to be resolved against this URI.
     * @return the resolved URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.926 -0500", hash_original_method = "0C14666D7307A46BF860740DE5247B99", hash_generated_method = "623B37269A3688F1C678C990D996BFA9")
    
public URI resolve(URI relative) {
        if (relative.absolute || opaque) {
            return relative;
        }

        if (relative.authority != null) {
            // If the relative URI has an authority, the result is the relative
            // with this URI's scheme.
            URI result = relative.duplicate();
            result.scheme = scheme;
            result.absolute = absolute;
            return result;
        }

        if (relative.path.isEmpty() && relative.scheme == null && relative.query == null) {
            // if the relative URI only consists of at most a fragment,
            URI result = duplicate();
            result.fragment = relative.fragment;
            return result;
        }

        URI result = duplicate();
        result.fragment = relative.fragment;
        result.query = relative.query;
        String resolvedPath;
        if (relative.path.startsWith("/")) {
            // The relative URI has an absolute path; use it.
            resolvedPath = relative.path;
        } else if (relative.path.isEmpty()) {
            // The relative URI has no path; use the base path.
            resolvedPath = path;
        } else {
            // The relative URI has a relative path; combine the paths.
            int endIndex = path.lastIndexOf('/') + 1;
            resolvedPath = path.substring(0, endIndex) + relative.path;
        }
        result.path = UrlUtils.authoritySafePath(result.authority, normalize(resolvedPath, true));
        result.setSchemeSpecificPart();
        return result;
    }
    
    private static class PartEncoder extends UriCodec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.769 -0500", hash_original_field = "42FB1E2F74D9ECA5422E07223B33B9E1", hash_generated_field = "926C47E1AC0B012F194CBD99C1600D74")

        private  String extraLegalCharacters;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.772 -0500", hash_original_method = "4347DCA156D9FED6289ADFF2BB08A2D3", hash_generated_method = "4347DCA156D9FED6289ADFF2BB08A2D3")
        
PartEncoder(String extraLegalCharacters) {
            this.extraLegalCharacters = extraLegalCharacters;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.775 -0500", hash_original_method = "AEEAAE9B7BA17A8A3158EAAD8BCDF90F", hash_generated_method = "844F9231016D004A58B7DC3DED53DDF2")
        
@Override protected boolean isRetained(char c) {
            return UNRESERVED.indexOf(c) != -1
                    || PUNCTUATION.indexOf(c) != -1
                    || extraLegalCharacters.indexOf(c) != -1
                    || (c > 127 && !Character.isSpaceChar(c) && !Character.isISOControl(c));
        }
        
    }

    /**
     * Helper method used to re-calculate the scheme specific part of the
     * resolved or normalized URIs
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.928 -0500", hash_original_method = "18729C902DFE2D59F18768C35CD0C59E", hash_generated_method = "615B181DE98859175E035CDE95E9ADA3")
    
private void setSchemeSpecificPart() {
        // ssp = [//authority][path][?query]
        StringBuilder ssp = new StringBuilder();
        if (authority != null) {
            ssp.append("//" + authority);
        }
        if (path != null) {
            ssp.append(path);
        }
        if (query != null) {
            ssp.append("?" + query);
        }
        schemeSpecificPart = ssp.toString();
        // reset string, so that it can be re-calculated correctly when asked.
        string = null;
    }

    /**
     * Creates a new URI instance by parsing the given string {@code relative}
     * and resolves the created URI against the URI represented by this
     * instance.
     *
     * @param relative
     *            the given string to create the new URI instance which has to
     *            be resolved later on.
     * @return the created and resolved URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.931 -0500", hash_original_method = "9168A9B8145DCA1D2A5ADCFF78018EA4", hash_generated_method = "DBEB961001843748FD02789EDA642DF7")
    
public URI resolve(String relative) {
        return resolve(create(relative));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.933 -0500", hash_original_method = "630095D6548B2B3A1441046549437B77", hash_generated_method = "7C0636640FEC89FC35436475E0DC07DD")
    
private String decode(String s) {
        return s != null ? UriCodec.decode(s) : null;
    }

    /**
     * Returns the textual string representation of this URI instance using the
     * US-ASCII encoding.
     *
     * @return the US-ASCII string representation of this URI.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.936 -0500", hash_original_method = "5974D900C8CF23409F32E47268086AF9", hash_generated_method = "217ABE8AEB5449B572546775659A5A95")
    
public String toASCIIString() {
        StringBuilder result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        return result.toString();
    }
    
    @DSComment("no suspicious activity, just gets string")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.846 -0400", hash_original_method = "17490955FE7D32C9695E89CDD3A294E6", hash_generated_method = "27D4065BF46968E70B80EE5A339BC58E")
    @Override
    public String toString() {
     return string;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
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

    /**
     * Converts this URI instance to a URL.
     *
     * @return the created URL representing the same resource as this URI.
     * @throws MalformedURLException
     *             if an error occurs while creating the URL or no protocol
     *             handler could be found.
     */
    @DSComment("no suspicious activity, just creates object")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.945 -0500", hash_original_method = "61498548735D8100B59ED3B549CA2D7D", hash_generated_method = "8FEC3AB94E860C562C0D31C07152B7D5")
    
public URL toURL() throws MalformedURLException {
        if (!absolute) {
            throw new IllegalArgumentException("URI is not absolute: " + toString());
        }
        return new URL(toString());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.947 -0500", hash_original_method = "B129014206D9E37AE762E15B64782F43", hash_generated_method = "D65A56B578E4F4F3D3903DC9F7A90D66")
    
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        try {
            parseURI(string, false);
        } catch (URISyntaxException e) {
            throw new IOException(e.toString());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:14.949 -0500", hash_original_method = "85F695901967363D4183474FCAC9E200", hash_generated_method = "42A3215A0D666F56C85AB5B404E3A328")
    
private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        // call toString() to ensure the value of string field is calculated
        toString();
        out.defaultWriteObject();
    }
}

