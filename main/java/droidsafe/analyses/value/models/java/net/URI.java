package droidsafe.analyses.value.models.java.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Set;

import soot.jimple.spark.pag.AllocNode;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.ValueAnalysisModelingSet;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;

public final class URI extends ValueAnalysisModeledObject {

    public Set<String> string = new ValueAnalysisModelingSet<String>();

    public URI(AllocNode allocNode) {
        super(allocNode);
    }

    private URI() {
    }

    // need this - called by the static method create(Set<String>) in this model
    public URI(Set<String> spec) throws URISyntaxException {
        this.string.addAll(spec);
        /*
        parseURI(spec, false);
        */
    }

    /**
     * Creates a new URI instance by parsing {@code spec}.
     *
     * @param spec a URI whose illegal characters have all been encoded.
     */
    public void _init_(Set<String> spec) throws URISyntaxException {
        this.string.addAll(spec);
        /*
        parseURI(spec, false);
        */
    }

    /**
     * Creates a new URI instance of the given unencoded component parts.
     *
     * @param scheme the URI scheme, or null for a non-absolute URI.
     */
    public void _init_(Set<String> scheme, Set<String> schemeSpecificPart, Set<String> fragment) throws URISyntaxException {
        __ds__invalidate();
        /*
        StringBuilder uri = new StringBuilder();
        if (scheme != null) {
            uri.append(scheme);
            uri.append(':');
        }
        if (schemeSpecificPart != null) {
            ALL_LEGAL_ENCODER.appendEncoded(uri, schemeSpecificPart);
        }
        if (fragment != null) {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        }

        parseURI(uri.toString(), false);
        */
    }

    /**
     * Creates a new URI instance of the given unencoded component parts.
     *
     * @param scheme the URI scheme, or null for a non-absolute URI.
     */
    public void _init_(Set<String> scheme, Set<String> userInfo, Set<String> host, Set<ValueAnalysisInt> port, Set<String> path, Set<String> query, Set<String> fragment) throws URISyntaxException {
        __ds__invalidate();
        /*
        if (scheme == null && userInfo == null && host == null && path == null
                && query == null && fragment == null) {
            this.path = "";
            return;
        }

        if (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/') {
            throw new URISyntaxException(path, "Relative path");
        }

        StringBuilder uri = new StringBuilder();
        if (scheme != null) {
            uri.append(scheme);
            uri.append(':');
        }

        if (userInfo != null || host != null || port != -1) {
            uri.append("//");
        }

        if (userInfo != null) {
            USER_INFO_ENCODER.appendEncoded(uri, userInfo);
            uri.append('@');
        }

        if (host != null) {
            // check for IPv6 addresses that hasn't been enclosed in square brackets
            if (host.indexOf(':') != -1 && host.indexOf(']') == -1 && host.indexOf('[') == -1) {
                host = "[" + host + "]";
            }
            uri.append(host);
        }

        if (port != -1) {
            uri.append(':');
            uri.append(port);
        }

        if (path != null) {
            PATH_ENCODER.appendEncoded(uri, path);
        }

        if (query != null) {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        }

        if (fragment != null) {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        }

        parseURI(uri.toString(), true);
        */
    }

    /**
     * Creates a new URI instance of the given unencoded component parts.
     *
     * @param scheme the URI scheme, or null for a non-absolute URI.
     */
    public void _init_(Set<String> scheme, Set<String> host, Set<String> path, Set<String> fragment) throws URISyntaxException {
        __ds__invalidate();
        /*
        this(scheme, null, host, -1, path, null, fragment);
        */
    }

    /**
     * Creates a new URI instance of the given unencoded component parts.
     *
     * @param scheme the URI scheme, or null for a non-absolute URI.
     */
    public void _init_(Set<String> scheme, Set<String> authority, Set<String> path, Set<String> query, Set<String> fragment) throws URISyntaxException {
        __ds__invalidate();
        /*
        if (scheme != null && path != null && !path.isEmpty() && path.charAt(0) != '/') {
            throw new URISyntaxException(path, "Relative path");
        }

        StringBuilder uri = new StringBuilder();
        if (scheme != null) {
            uri.append(scheme);
            uri.append(':');
        }
        if (authority != null) {
            uri.append("//");
            AUTHORITY_ENCODER.appendEncoded(uri, authority);
        }

        if (path != null) {
            PATH_ENCODER.appendEncoded(uri, path);
        }
        if (query != null) {
            uri.append('?');
            ALL_LEGAL_ENCODER.appendEncoded(uri, query);
        }
        if (fragment != null) {
            uri.append('#');
            ALL_LEGAL_ENCODER.appendEncoded(uri, fragment);
        }

        parseURI(uri.toString(), false);
        */
    }

    /**
     * Breaks uri into its component parts. This first splits URI into scheme,
     * scheme-specific part and fragment:
     *   [scheme:][scheme-specific part][#fragment]
     *
     * Then it breaks the scheme-specific part into authority, path and query:
     *   [//authority][path][?query]
     *
     * Finally it delegates to parseAuthority to break the authority into user
     * info, host and port:
     *   [user-info@][host][:port]
     */
    private void parseURI(Set<String> uri, Set<ValueAnalysisBoolean> forceServer) throws URISyntaxException {
        __ds__invalidate();
        /*
        string = uri;

        // "#fragment"
        int fragmentStart = UrlUtils.findFirstOf(uri, "#", 0, uri.length());
        if (fragmentStart < uri.length()) {
            fragment = ALL_LEGAL_ENCODER.validate(uri, fragmentStart + 1, uri.length(), "fragment");
        }

        // scheme:
        int start;
        int colon = UrlUtils.findFirstOf(uri, ":", 0, fragmentStart);
        if (colon < UrlUtils.findFirstOf(uri, "/?#", 0, fragmentStart)) {
            absolute = true;
            scheme = validateScheme(uri, colon);
            start = colon + 1;

            if (start == fragmentStart) {
                throw new URISyntaxException(uri, "Scheme-specific part expected", start);
            }

            // URIs with schemes followed by a non-/ char are opaque and need no further parsing.
            if (!uri.regionMatches(start, "/", 0, 1)) {
                opaque = true;
                schemeSpecificPart = ALL_LEGAL_ENCODER.validate(
                        uri, start, fragmentStart, "scheme specific part");
                return;
            }
        } else {
            absolute = false;
            start = 0;
        }

        opaque = false;
        schemeSpecificPart = uri.substring(start, fragmentStart);

        // "//authority"
        int fileStart;
        if (uri.regionMatches(start, "//", 0, 2)) {
            int authorityStart = start + 2;
            fileStart = UrlUtils.findFirstOf(uri, "/?", authorityStart, fragmentStart);
            if (authorityStart == uri.length()) {
                throw new URISyntaxException(uri, "Authority expected", uri.length());
            }
            if (authorityStart < fileStart) {
                authority = AUTHORITY_ENCODER.validate(uri, authorityStart, fileStart, "authority");
            }
        } else {
            fileStart = start;
        }

        // "path"
        int queryStart = UrlUtils.findFirstOf(uri, "?", fileStart, fragmentStart);
        path = PATH_ENCODER.validate(uri, fileStart, queryStart, "path");

        // "?query"
        if (queryStart < fragmentStart) {
            query = ALL_LEGAL_ENCODER.validate(uri, queryStart + 1, fragmentStart, "query");
        }

        parseAuthority(forceServer);
        */
    }

    private String validateScheme(Set<String> uri, Set<ValueAnalysisInt> end) throws URISyntaxException {
        __ds__invalidate();
        return null;
        /*
        if (end == 0) {
            throw new URISyntaxException(uri, "Scheme expected", 0);
        }

        for (int i = 0; i < end; i++) {
            if (!UrlUtils.isValidSchemeChar(i, uri.charAt(i))) {
                throw new URISyntaxException(uri, "Illegal character in scheme", 0);
            }
        }

        return uri.substring(0, end);
        */
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
    private void parseAuthority(Set<ValueAnalysisBoolean> forceServer) throws URISyntaxException {
        __ds__invalidate();
        /*
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
        */
    }

    private void validateUserInfo(Set<String> uri, Set<String> userInfo, Set<ValueAnalysisInt> index) throws URISyntaxException {
        __ds__invalidate();
        /*
        for (int i = 0; i < userInfo.length(); i++) {
            char ch = userInfo.charAt(i);
            if (ch == ']' || ch == '[') {
                throw new URISyntaxException(uri, "Illegal character in userInfo", index + i);
            }
        }
        */
    }

    /**
     * Returns true if {@code host} is a well-formed host name or IP address.
     *
     * @param forceServer true to always throw if the host cannot be parsed. If
     *     false, this method may still throw for some kinds of errors; this
     *     unpredictable behavior is consistent with the RI.
     */
    private boolean isValidHost(Set<ValueAnalysisBoolean> forceServer, Set<String> host) throws URISyntaxException {
        __ds__invalidate();
        return false;
        /*
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
        */
    }

    private boolean isValidDomainName(Set<String> host) {
        __ds__invalidate();
        return false;
        /*
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
        */
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
    public int compareTo(URI uri) {
        __ds__invalidate();
        return 0;
        /*
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
        */
    }

    /**
     * Returns the URI formed by parsing {@code uri}. This method behaves
     * identically to the string constructor but throws a different exception
     * on failure. The constructor fails with a checked {@link
     * URISyntaxException}; this method fails with an unchecked {@link
     * IllegalArgumentException}.
     */
    public static URI create(Set<String> uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        /*
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        */
    }

    private URI duplicate() {
        __ds__invalidate();
        return null;
        /*
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
        */
    }

    /*
     * Takes a string that may contain hex sequences like %F1 or %2b and
     * converts the hex values following the '%' to lowercase
     */
    private String convertHexToLowerCase(Set<String> s) {
        __ds__invalidate();
        return null;
        /*
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
        */
    }

    /**
     * Returns true if {@code first} and {@code second} are equal after
     * unescaping hex sequences like %F1 and %2b.
     */
    private boolean escapedEquals(Set<String> first, Set<String> second) {
        __ds__invalidate();
        return false;
        /*
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
        */
    }

    @Override
    public boolean equals(Object o) {
        __ds__invalidate();
        return false;
        /*
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
        */
    }

    /**
     * Returns the scheme of this URI, or null if this URI has no scheme. This
     * is also known as the protocol.
     */
    public String getScheme() {
        __ds__invalidate();
        return null;
        /*
        return scheme;
        */
    }

    /**
     * Returns the decoded scheme-specific part of this URI, or null if this URI
     * has no scheme-specific part.
     */
    public String getSchemeSpecificPart() {
        __ds__invalidate();
        return null;
        /*
        return decode(schemeSpecificPart);
        */
    }

    /**
     * Returns the encoded scheme-specific part of this URI, or null if this URI
     * has no scheme-specific part.
     */
    public String getRawSchemeSpecificPart() {
        __ds__invalidate();
        return null;
        /*
        return schemeSpecificPart;
        */
    }

    /**
     * Returns the decoded authority part of this URI, or null if this URI has
     * no authority.
     */
    public String getAuthority() {
        __ds__invalidate();
        return null;
        /*
        return decode(authority);
        */
    }

    /**
     * Returns the encoded authority of this URI, or null if this URI has no
     * authority.
     */
    public String getRawAuthority() {
        __ds__invalidate();
        return null;
        /*
        return authority;
        */
    }

    /**
     * Returns the decoded user info of this URI, or null if this URI has no
     * user info.
     */
    public String getUserInfo() {
        __ds__invalidate();
        return null;
        /*
        return decode(userInfo);
        */
    }

    /**
     * Returns the encoded user info of this URI, or null if this URI has no
     * user info.
     */
    public String getRawUserInfo() {
        __ds__invalidate();
        return null;
        /*
        return userInfo;
        */
    }

    /**
     * Returns the host of this URI, or null if this URI has no host.
     */
    public String getHost() {
        __ds__invalidate();
        return null;
        /*
        return host;
        */
    }

    /**
     * Returns the port number of this URI, or {@code -1} if this URI has no
     * explicit port.
     */
    public int getPort() {
        __ds__invalidate();
        return 0;
        /*
        return port;
        */
    }

    /** @hide */
    public int getEffectivePort() {
        __ds__invalidate();
        return 0;
        /*
        return getEffectivePort(scheme, port);
        */
    }

    /**
     * Returns the port to use for {@code scheme} connections will use when
     * {@link #getPort} returns {@code specifiedPort}.
     *
     * @hide
     */
    public static int getEffectivePort(Set<String> scheme, Set<ValueAnalysisInt> specifiedPort) {
        return 0;
        /*
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
        */
    }

    /**
     * Returns the decoded path of this URI, or null if this URI has no path.
     */
    public String getPath() {
        __ds__invalidate();
        return null;
        /*
        return decode(path);
        */
    }

    /**
     * Returns the encoded path of this URI, or null if this URI has no path.
     */
    public String getRawPath() {
        __ds__invalidate();
        return null;
        /*
        return path;
        */
    }

    /**
     * Returns the decoded query of this URI, or null if this URI has no query.
     */
    public String getQuery() {
        __ds__invalidate();
        return null;
        /*
        return decode(query);
        */
    }

    /**
     * Returns the encoded query of this URI, or null if this URI has no query.
     */
    public String getRawQuery() {
        __ds__invalidate();
        return null;
        /*
        return query;
        */
    }

    /**
     * Returns the decoded fragment of this URI, or null if this URI has no
     * fragment.
     */
    public String getFragment() {
        __ds__invalidate();
        return null;
        /*
        return decode(fragment);
        */
    }

    /**
     * Gets the encoded fragment of this URI, or null if this URI has no
     * fragment.
     */
    public String getRawFragment() {
        __ds__invalidate();
        return null;
        /*
        return fragment;
        */
    }

    @Override
    public int hashCode() {
        __ds__invalidate();
        return 0;
        /*
        if (hash == -1) {
            hash = getHashString().hashCode();
        }
        return hash;
        */
    }

    /**
     * Returns true if this URI is absolute, which means that a scheme is
     * defined.
     */
    public boolean isAbsolute() {
        __ds__invalidate();
        return false;
        /*
        // TODO: simplify to 'scheme != null' ?
        return absolute;
        */
    }

    /**
     * Returns true if this URI is opaque. Opaque URIs are absolute and have a
     * scheme-specific part that does not start with a slash character. All
     * parts except scheme, scheme-specific and fragment are undefined.
     */
    public boolean isOpaque() {
        __ds__invalidate();
        return false;
        /*
        return opaque;
        */
    }

    /**
     * Returns the normalized path.
     */
    private String normalize(Set<String> path, Set<ValueAnalysisBoolean> discardRelativePrefix) {
        __ds__invalidate();
        return null;
        /*
        path = UrlUtils.canonicalizePath(path, discardRelativePrefix);

        //
        // If the path contains a colon before the first colon, prepend
        // "./" to differentiate the path from a scheme prefix.
        //
        int colon = path.indexOf(':');
        if (colon != -1) {
            int slash = path.indexOf('/');
            if (slash == -1 || colon < slash) {
                path = "./" + path;
            }
        }

        return path;
        */
    }

    /**
     * Normalizes the path part of this URI.
     *
     * @return an URI object which represents this instance with a normalized
     *         path.
     */
    public URI normalize() {
        __ds__invalidate();
        return null;
        /*
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
        */
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
    public URI parseServerAuthority() throws URISyntaxException {
        __ds__invalidate();
        return null;
        /*
        if (!serverAuthority) {
            parseAuthority(true);
        }
        return this;
        */
    }

    /**
     * Makes the given URI {@code relative} to a relative URI against the URI
     * represented by this instance.
     *
     * @param relative
     *            the URI which has to be relativized against this URI.
     * @return the relative URI.
     */
    public URI relativize(URI relative) {
        __ds__invalidate();
        return null;
        /*
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

        //
        // if the paths aren't equal, then we need to determine if this URI's
        // path is a parent path (begins with) the relative URI's path
        //
        if (!thisPath.equals(relativePath)) {
            // drop everything after the last slash in this path
            thisPath = thisPath.substring(0, thisPath.lastIndexOf('/') + 1);

            //
            // if the relative URI's path doesn't start with this URI's path,
            // then just return the relative URI; the URIs have nothing in
            // common
            //
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
        */
    }

    /**
     * Resolves the given URI {@code relative} against the URI represented by
     * this instance.
     *
     * @param relative
     *            the URI which has to be resolved against this URI.
     * @return the resolved URI.
     */
    public URI resolve(URI relative) {
        __ds__invalidate();
        return null;
        /*
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
        */
    }

    /**
     * Helper method used to re-calculate the scheme specific part of the
     * resolved or normalized URIs
     */
    private void setSchemeSpecificPart() {
        __ds__invalidate();
        /*
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
        */
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
    public URI resolve(Set<String> relative) {
        __ds__invalidate();
        return null;
        /*
        return resolve(create(relative));
        */
    }

    private String decode(Set<String> s) {
        __ds__invalidate();
        return null;
        /*
        return s != null ? UriCodec.decode(s) : null;
        */
    }

    /**
     * Returns the textual string representation of this URI instance using the
     * US-ASCII encoding.
     *
     * @return the US-ASCII string representation of this URI.
     */
    public String toASCIIString() {
        __ds__invalidate();
        return null;
        /*
        StringBuilder result = new StringBuilder();
        ASCII_ONLY.appendEncoded(result, toString());
        return result.toString();
        */
    }

    /**
     * Returns the encoded URI.
     */
    @Override
    public String toString() {
        __ds__invalidate();
        return null;
        /*
        if (string != null) {
            return string;
        }

        StringBuilder result = new StringBuilder();
        if (scheme != null) {
            result.append(scheme);
            result.append(':');
        }
        if (opaque) {
            result.append(schemeSpecificPart);
        } else {
            if (authority != null) {
                result.append("//");
                result.append(authority);
            }

            if (path != null) {
                result.append(path);
            }

            if (query != null) {
                result.append('?');
                result.append(query);
            }
        }

        if (fragment != null) {
            result.append('#');
            result.append(fragment);
        }

        string = result.toString();
        return string;
        */
    }

    /*
     * Form a string from the components of this URI, similarly to the
     * toString() method. But this method converts scheme and host to lowercase,
     * and converts escaped octets to lowercase.
     */
    private String getHashString() {
        __ds__invalidate();
        return null;
        /*
        StringBuilder result = new StringBuilder();
        if (scheme != null) {
            result.append(scheme.toLowerCase(Locale.US));
            result.append(':');
        }
        if (opaque) {
            result.append(schemeSpecificPart);
        } else {
            if (authority != null) {
                result.append("//");
                if (host == null) {
                    result.append(authority);
                } else {
                    if (userInfo != null) {
                        result.append(userInfo + "@");
                    }
                    result.append(host.toLowerCase(Locale.US));
                    if (port != -1) {
                        result.append(":" + port);
                    }
                }
            }

            if (path != null) {
                result.append(path);
            }

            if (query != null) {
                result.append('?');
                result.append(query);
            }
        }

        if (fragment != null) {
            result.append('#');
            result.append(fragment);
        }

        return convertHexToLowerCase(result.toString());
        */
    }

    /**
     * Converts this URI instance to a URL.
     *
     * @return the created URL representing the same resource as this URI.
     * @throws MalformedURLException
     *             if an error occurs while creating the URL or no protocol
     *             handler could be found.
     */
    public URL toURL() throws MalformedURLException {
        __ds__invalidate();
        return null;
        /*
        if (!absolute) {
            throw new IllegalArgumentException("URI is not absolute: " + toString());
        }
        return new URL(toString());
        */
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        __ds__invalidate();
        /*
        in.defaultReadObject();
        try {
            parseURI(string, false);
        } catch (URISyntaxException e) {
            throw new IOException(e.toString());
        }
        */
    }

    private void writeObject(ObjectOutputStream out) throws IOException, ClassNotFoundException {
        __ds__invalidate();
        /*
        // call toString() to ensure the value of string field is calculated
        toString();
        out.defaultWriteObject();
        */
    }
}
