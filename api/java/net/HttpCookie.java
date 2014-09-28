/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package java.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import libcore.net.http.HttpDate;
import libcore.util.Objects;

/**
 * An opaque key-value value pair held by an HTTP client to permit a stateful
 * session with an HTTP server. This class parses cookie headers for all three
 * commonly used HTTP cookie specifications:
 *
 * <ul>
 *     <li>The Netscape cookie spec is officially obsolete but widely used in
 *         practice. Each cookie contains one key-value pair and the following
 *         attributes: {@code Domain}, {@code Expires}, {@code Path}, and
 *         {@code Secure}. The {@link #getVersion() version} of cookies in this
 *         format is {@code 0}.
 *         <p>There are no accessors for the {@code Expires} attribute. When
 *         parsed, expires attributes are assigned to the {@link #getMaxAge()
 *         Max-Age} attribute as an offset from {@link System#currentTimeMillis()
 *         now}.
 *     <li><a href="http://www.ietf.org/rfc/rfc2109.txt">RFC 2109</a> formalizes
 *         the Netscape cookie spec. It replaces the {@code Expires} timestamp
 *         with a {@code Max-Age} duration and adds {@code Comment} and {@code
 *         Version} attributes. The {@link #getVersion() version} of cookies in
 *         this format is {@code 1}.
 *     <li><a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a> refines
 *         RFC 2109. It adds {@code Discard}, {@code Port}, and {@code
 *         CommentURL} attributes and renames the header from {@code Set-Cookie}
 *         to {@code Set-Cookie2}. The {@link #getVersion() version} of cookies
 *         in this format is {@code 1}.
 * </ul>
 *
 * <p>This implementation silently discards unrecognized attributes. In
 * particular, the {@code HttpOnly} attribute is widely served but isn't in any
 * of the above specs. It was introduced by Internet Explorer to prevent server
 * cookies from being exposed in the DOM to JavaScript, etc.
 *
 * @since 1.6
 */
public final class HttpCookie implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.963 -0400", hash_original_field = "448B2E092B0FE23DEAF2A192598B4536", hash_generated_field = "ABF15EA817BE289AF666DD8B88FC13FE")

    private static final Set<String> RESERVED_NAMES = new HashSet<String>();

    static {
        RESERVED_NAMES.add("comment");    //           RFC 2109  RFC 2965
        RESERVED_NAMES.add("commenturl"); //                     RFC 2965
        RESERVED_NAMES.add("discard");    //                     RFC 2965
        RESERVED_NAMES.add("domain");     // Netscape  RFC 2109  RFC 2965
        RESERVED_NAMES.add("expires");    // Netscape
        RESERVED_NAMES.add("max-age");    //           RFC 2109  RFC 2965
        RESERVED_NAMES.add("path");       // Netscape  RFC 2109  RFC 2965
        RESERVED_NAMES.add("port");       //                     RFC 2965
        RESERVED_NAMES.add("secure");     // Netscape  RFC 2109  RFC 2965
        RESERVED_NAMES.add("version");    //           RFC 2109  RFC 2965
    }

    /**
     * Returns true if {@code host} matches the domain pattern {@code domain}.
     *
     * @param domainPattern a host name (like {@code android.com} or {@code
     *     localhost}), or a pattern to match subdomains of a domain name (like
     *     {@code .android.com}). A special case pattern is {@code .local},
     *     which matches all hosts without a TLD (like {@code localhost}).
     * @param host the host name or IP address from an HTTP request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.965 -0400", hash_original_method = "D10DB88A78CC84223A44F2C63FD4DFB0", hash_generated_method = "34336AF34722DF028BEE4F48A832A276")
    
public static boolean domainMatches(String domainPattern, String host) {
        if (domainPattern == null || host == null) {
            return false;
        }

        String a = host.toLowerCase(Locale.US);
        String b = domainPattern.toLowerCase(Locale.US);

        /*
         * From the spec: "both host names are IP addresses and their host name strings match
         * exactly; or both host names are FQDN strings and their host name strings match exactly"
         */
        if (a.equals(b) && (isFullyQualifiedDomainName(a, 0) || InetAddress.isNumeric(a))) {
            return true;
        }
        if (!isFullyQualifiedDomainName(a, 0)) {
            return b.equals(".local");
        }

        /*
         * Not in the spec! If prefixing a hostname with "." causes it to equal the domain pattern,
         * then it should match. This is necessary so that the pattern ".google.com" will match the
         * host "google.com".
         */
        if (b.length() == 1 + a.length()
                && b.startsWith(".")
                && b.endsWith(a)
                && isFullyQualifiedDomainName(b, 1)) {
            return true;
        }

        /*
         * From the spec: "A is a HDN string and has the form NB, where N is a
         * non-empty name string, B has the form .B', and B' is a HDN string.
         * (So, x.y.com domain-matches .Y.com but not Y.com.)
         */
        return a.length() > b.length()
                && a.endsWith(b)
                && ((b.startsWith(".") && isFullyQualifiedDomainName(b, 1)) || b.equals(".local"));
    }

    /**
     * Returns true if {@code cookie} should be sent to or accepted from {@code uri} with respect
     * to the cookie's path. Cookies match by directory prefix: URI "/foo" matches cookies "/foo",
     * "/foo/" and "/foo/bar", but not "/" or "/foobar".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.966 -0400", hash_original_method = "6CD8FE4832231EC345BCEB4905662548", hash_generated_method = "4B9CCBC71FD25D80F99FD3D0EF682E64")
    
static boolean pathMatches(HttpCookie cookie, URI uri) {
        String uriPath = matchablePath(uri.getPath());
        String cookiePath = matchablePath(cookie.getPath());
        return uriPath.startsWith(cookiePath);
    }

    /**
     * Returns true if {@code cookie} should be sent to {@code uri} with respect to the cookie's
     * secure attribute. Secure cookies should not be sent in insecure (ie. non-HTTPS) requests.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.968 -0400", hash_original_method = "C3BB0B2A0E74C2C550DC34C1CDF83661", hash_generated_method = "FD1EF423859A024110D8936543072202")
    
static boolean secureMatches(HttpCookie cookie, URI uri) {
        return !cookie.getSecure() || "https".equalsIgnoreCase(uri.getScheme());
    }

    /**
     * Returns true if {@code cookie} should be sent to {@code uri} with respect to the cookie's
     * port list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.969 -0400", hash_original_method = "32A19E33F5E319EDCAE98AC7D1C3C9B5", hash_generated_method = "033AAD7ED8FD8E7B38AA9BFAF6764272")
    
static boolean portMatches(HttpCookie cookie, URI uri) {
        if (cookie.getPortlist() == null) {
            return true;
        }
        return Arrays.asList(cookie.getPortlist().split(","))
                .contains(Integer.toString(uri.getEffectivePort()));
    }

    /**
     * Returns a non-null path ending in "/".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.971 -0400", hash_original_method = "F4A3D80B5A2814FAD6E3165323DA2B3F", hash_generated_method = "B9F4A18BC8F4B2B576F83CC8FC1247DB")
    
private static String matchablePath(String path) {
        if (path == null) {
            return "/";
        } else if (path.endsWith("/")) {
            return path;
        } else {
            return path + "/";
        }
    }

    /**
     * Returns true if {@code s.substring(firstCharacter)} contains a dot
     * between its first and last characters, exclusive. This considers both
     * {@code android.com} and {@code co.uk} to be fully qualified domain names,
     * but not {@code android.com.}, {@code .com}. or {@code android}.
     *
     * <p>Although this implements the cookie spec's definition of FQDN, it is
     * not general purpose. For example, this returns true for IPv4 addresses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.973 -0400", hash_original_method = "0EC79890A350750C20C61DDFADFBFD9E", hash_generated_method = "09A56270FC4791151E89A0BD1C21925E")
    
private static boolean isFullyQualifiedDomainName(String s, int firstCharacter) {
        int dotPosition = s.indexOf('.', firstCharacter + 1);
        return dotPosition != -1 && dotPosition < s.length() - 1;
    }

    /**
     * Constructs a cookie from a string. The string should comply with
     * set-cookie or set-cookie2 header format as specified in
     * <a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a>. Since
     * set-cookies2 syntax allows more than one cookie definitions in one
     * header, the returned object is a list.
     *
     * @param header
     *            a set-cookie or set-cookie2 header.
     * @return a list of constructed cookies
     * @throws IllegalArgumentException
     *             if the string does not comply with cookie specification, or
     *             the cookie name contains illegal characters, or reserved
     *             tokens of cookie specification appears
     * @throws NullPointerException
     *             if header is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.974 -0400", hash_original_method = "0395870E478DFE4BE47D7DC0433D30D9", hash_generated_method = "12DCF741D2D6B7403F48F75825292230")
    
public static List<HttpCookie> parse(String header) {
        return new CookieParser(header).parse();
    }

    static class CookieParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.977 -0400", hash_original_field = "10B13743A9F1DA1A45ECED1768B7556D", hash_generated_field = "C2BE5BD632A9E833C174E1F4DE738280")

        private static final String ATTRIBUTE_NAME_TERMINATORS = ",;= \t";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.978 -0400", hash_original_field = "95D3E99C21A42D33C1F67880DD76D064", hash_generated_field = "76987F1427E073016C1DE1206462A365")

        private static final String WHITESPACE = " \t";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.980 -0400", hash_original_field = "5C462996083F0F42B19C9D5F27993F9B", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

        private  String input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.981 -0400", hash_original_field = "2A5F97DEED0B1D239321851DFD9F2DC7", hash_generated_field = "ED635627F586727A96BE526F90732A2A")

        private  String inputLowerCase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.983 -0400", hash_original_field = "BEC7A604E336F37C0CC9A9336799291F", hash_generated_field = "1EE68ACB4780831F3183A1FA743520F8")

        private int pos = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.984 -0400", hash_original_field = "63D608B65290318866C209D81F59FB45", hash_generated_field = "63D608B65290318866C209D81F59FB45")

        boolean hasExpires = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.985 -0400", hash_original_field = "94999EE5125EBCFECFEFC4BDAAAA36D3", hash_generated_field = "94999EE5125EBCFECFEFC4BDAAAA36D3")

        boolean hasMaxAge = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.986 -0400", hash_original_field = "833D397F9916502D998F7335C0C085C8", hash_generated_field = "833D397F9916502D998F7335C0C085C8")

        boolean hasVersion = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.987 -0400", hash_original_method = "432CC9325472F1CFBA23917C79DEA47C", hash_generated_method = "432CC9325472F1CFBA23917C79DEA47C")
        
CookieParser(String input) {
            this.input = input;
            this.inputLowerCase = input.toLowerCase(Locale.US);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.991 -0400", hash_original_method = "779D4DB9C15A7DD4EF083DBF6221B20E", hash_generated_method = "93D6D4EF8399CAB31B8EC72BA2F71B1B")
        
public List<HttpCookie> parse() {
            List<HttpCookie> cookies = new ArrayList<HttpCookie>(2);

            // The RI permits input without either the "Set-Cookie:" or "Set-Cookie2" headers.
            boolean pre2965 = true;
            if (inputLowerCase.startsWith("set-cookie2:")) {
                pos += "set-cookie2:".length();
                pre2965 = false;
                hasVersion = true;
            } else if (inputLowerCase.startsWith("set-cookie:")) {
                pos += "set-cookie:".length();
            }

            /*
             * Read a comma-separated list of cookies. Note that the values may contain commas!
             *   <NAME> "=" <VALUE> ( ";" <ATTR NAME> ( "=" <ATTR VALUE> )? )*
             */
            while (true) {
                String name = readAttributeName(false);
                if (name == null) {
                    if (cookies.isEmpty()) {
                        throw new IllegalArgumentException("No cookies in " + input);
                    }
                    return cookies;
                }

                if (!readEqualsSign()) {
                    throw new IllegalArgumentException(
                            "Expected '=' after " + name + " in " + input);
                }

                String value = readAttributeValue(pre2965 ? ";" : ",;");
                HttpCookie cookie = new HttpCookie(name, value);
                cookie.version = pre2965 ? 0 : 1;
                cookies.add(cookie);

                /*
                 * Read the attributes of the current cookie. Each iteration of this loop should
                 * enter with input either exhausted or prefixed with ';' or ',' as in ";path=/"
                 * and ",COOKIE2=value2".
                 */
                while (true) {
                    skipWhitespace();
                    if (pos == input.length()) {
                        break;
                    }

                    if (input.charAt(pos) == ',') {
                        pos++;
                        break; // a true comma delimiter; the current cookie is complete.
                    } else if (input.charAt(pos) == ';') {
                        pos++;
                    }

                    String attributeName = readAttributeName(true);
                    if (attributeName == null) {
                        continue; // for empty attribute as in "Set-Cookie: foo=Foo;;path=/"
                    }

                    /*
                     * Since expires and port attributes commonly include comma delimiters, always
                     * scan until a semicolon when parsing these attributes.
                     */
                    String terminators = pre2965
                            || "expires".equals(attributeName) || "port".equals(attributeName)
                            ? ";"
                            : ";,";
                    String attributeValue = null;
                    if (readEqualsSign()) {
                        attributeValue = readAttributeValue(terminators);
                    }
                    setAttribute(cookie, attributeName, attributeValue);
                }

                if (hasExpires) {
                    cookie.version = 0;
                } else if (hasMaxAge) {
                    cookie.version = 1;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.993 -0400", hash_original_method = "787037B5780A68E5711C82A3A939A668", hash_generated_method = "824684FEA6A0033D9D95A535167D62D2")
        
private void setAttribute(HttpCookie cookie, String name, String value) {
            if (name.equals("comment") && cookie.comment == null) {
                cookie.comment = value;
            } else if (name.equals("commenturl") && cookie.commentURL == null) {
                cookie.commentURL = value;
            } else if (name.equals("discard")) {
                cookie.discard = true;
            } else if (name.equals("domain") && cookie.domain == null) {
                cookie.domain = value;
            } else if (name.equals("expires")) {
                hasExpires = true;
                if (cookie.maxAge == -1L) {
                    Date date = HttpDate.parse(value);
                    if (date != null) {
                        cookie.setExpires(date);
                    } else {
                        cookie.maxAge = 0;
                    }
                }
            } else if (name.equals("max-age") && cookie.maxAge == -1L) {
                hasMaxAge = true;
                cookie.maxAge = Long.parseLong(value);
            } else if (name.equals("path") && cookie.path == null) {
                cookie.path = value;
            } else if (name.equals("port") && cookie.portList == null) {
                cookie.portList = value != null ? value : "";
            } else if (name.equals("secure")) {
                cookie.secure = true;
            } else if (name.equals("version") && !hasVersion) {
                cookie.version = Integer.parseInt(value);
            }
        }

        /**
         * Returns the next attribute name, or null if the input has been
         * exhausted. Returns wth the cursor on the delimiter that follows.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.995 -0400", hash_original_method = "F701398B8DEFEDBDFC680CE7749E8EBC", hash_generated_method = "7C2EDC33E7104ECFDB7D7540B64FFCAF")
        
private String readAttributeName(boolean returnLowerCase) {
            skipWhitespace();
            int c = find(ATTRIBUTE_NAME_TERMINATORS);
            String forSubstring = returnLowerCase ? inputLowerCase : input;
            String result = pos < c ? forSubstring.substring(pos, c) : null;
            pos = c;
            return result;
        }

        /**
         * Returns true if an equals sign was read and consumed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.996 -0400", hash_original_method = "D7BFC2EA39FCC831C6746FE2E0E9F67F", hash_generated_method = "AA4C259171A5ACC7D75CC2D898116CCC")
        
private boolean readEqualsSign() {
            skipWhitespace();
            if (pos < input.length() && input.charAt(pos) == '=') {
                pos++;
                return true;
            }
            return false;
        }

        /**
         * Reads an attribute value, by parsing either a quoted string or until
         * the next character in {@code terminators}. The terminator character
         * is not consumed.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.998 -0400", hash_original_method = "4044E7C9997AD50387B0EEB7DA492656", hash_generated_method = "7EE95FD3BDF9FF45C7733E4624474333")
        
private String readAttributeValue(String terminators) {
            skipWhitespace();

            /*
             * Quoted string: read 'til the close quote. The spec mentions only "double quotes"
             * but RI bug 6901170 claims that 'single quotes' are also used.
             */
            if (pos < input.length() && (input.charAt(pos) == '"' || input.charAt(pos) == '\'')) {
                char quoteCharacter = input.charAt(pos++);
                int closeQuote = input.indexOf(quoteCharacter, pos);
                if (closeQuote == -1) {
                    throw new IllegalArgumentException("Unterminated string literal in " + input);
                }
                String result = input.substring(pos, closeQuote);
                pos = closeQuote + 1;
                return result;
            }

            int c = find(terminators);
            String result = input.substring(pos, c);
            pos = c;
            return result;
        }

        /**
         * Returns the index of the next character in {@code chars}, or the end
         * of the string.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.000 -0400", hash_original_method = "40F9BB148C63774623D6149068137682", hash_generated_method = "5805550F43BF334779605ED94BE92A82")
        
private int find(String chars) {
            for (int c = pos; c < input.length(); c++) {
                if (chars.indexOf(input.charAt(c)) != -1) {
                    return c;
                }
            }
            return input.length();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.001 -0400", hash_original_method = "F9C9EEC82D3828B93AE36B45AE9997C5", hash_generated_method = "48C75CE54CA2F6E03383C077A76C3CDC")
        
private void skipWhitespace() {
            for (; pos < input.length(); pos++) {
                if (WHITESPACE.indexOf(input.charAt(pos)) == -1) {
                    break;
                }
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.006 -0400", hash_original_field = "6C9FE4127C88B2FD28EFE861CA65A713", hash_generated_field = "3ED42D4B537F5FDB36FDF1EA0D6B44D6")

    private String comment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.008 -0400", hash_original_field = "3BBF3F64A34794B64FB53E371BD4F422", hash_generated_field = "6A2B50CEA40AC67F646E005F8BAEDBCB")

    private String commentURL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.009 -0400", hash_original_field = "C9E6907B1738BEE284DA1A383B85D7D1", hash_generated_field = "33439C2B9FDD0CF9B54F1993B130A7B9")

    private boolean discard;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.010 -0400", hash_original_field = "B45971700BE10ABC690F6ABCD38C274A", hash_generated_field = "5DD0748096DF7E459884FCD3EB6DD3AB")

    private String domain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.011 -0400", hash_original_field = "D447473E0C00B1B35ABB891F9AD6D982", hash_generated_field = "7E0E083D15A79D3E4F5DF98A36F2EC62")

    private long maxAge = -1l;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.013 -0400", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.014 -0400", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "E58B218DC2BC9CF2BD65F7BE2F7C20BE")

    private String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.015 -0400", hash_original_field = "72A3277F8E4DF81A8FF2D8F20436C1FB", hash_generated_field = "1446E7DBB8DDDC44F9A94E0CE325216C")

    private String portList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.016 -0400", hash_original_field = "63DC6869FF37EDAA23661806B080C4ED", hash_generated_field = "D17DE8BC324386A0F759A8245C34BC17")

    private boolean secure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.018 -0400", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.019 -0400", hash_original_field = "C9F615CDA103CA819E9CF48EDE296898", hash_generated_field = "D02C92BEFB56E93AECDC6D34F25DAE39")

    private int version = 1;

    /**
     * Creates a new cookie.
     *
     * @param name a non-empty string that contains only printable ASCII, no
     *     commas or semicolons, and is not prefixed with  {@code $}. May not be
     *     an HTTP attribute name.
     * @param value an opaque value from the HTTP server.
     * @throws IllegalArgumentException if {@code name} is invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.022 -0400", hash_original_method = "53DE123D2C6C56C9F3E091E35AEAA157", hash_generated_method = "22BE71A05B2A301ABC2AB109753163D3")
    
public HttpCookie(String name, String value) {
        String ntrim = name.trim(); // erase leading and trailing whitespace
        if (!isValidName(ntrim)) {
            throw new IllegalArgumentException();
        }

        this.name = ntrim;
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.023 -0400", hash_original_method = "8669D3908E84239A9A662EEF41DB36C5", hash_generated_method = "DD3E7A1B1F6D6E61ABE354E2763AEF6B")
    
private boolean isValidName(String n) {
        // name cannot be empty or begin with '$' or equals the reserved
        // attributes (case-insensitive)
        boolean isValid = !(n.length() == 0 || n.startsWith("$")
                || RESERVED_NAMES.contains(n.toLowerCase(Locale.US)));
        if (isValid) {
            for (int i = 0; i < n.length(); i++) {
                char nameChar = n.charAt(i);
                // name must be ASCII characters and cannot contain ';', ',' and
                // whitespace
                if (nameChar < 0
                        || nameChar >= 127
                        || nameChar == ';'
                        || nameChar == ','
                        || (Character.isWhitespace(nameChar) && nameChar != ' ')) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    /**
     * Returns the {@code Comment} attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.025 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E40F10878D62F1009133973700BC0B5C")
    
public String getComment() {
        return comment;
    }

    /**
     * Returns the value of {@code CommentURL} attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.026 -0400", hash_original_method = "8CC7549FE8AAE5E44D48059A883A1B56", hash_generated_method = "8B7D9010E44C8D96EE29CE378E2B5A54")
    
public String getCommentURL() {
        return commentURL;
    }

    /**
     * Returns the {@code Discard} attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.027 -0400", hash_original_method = "84069C4EB35CF330A7330813FB1773D6", hash_generated_method = "8F77BFEA65FD59A660B10F8094C192D0")
    
public boolean getDiscard() {
        return discard;
    }

    /**
     * Returns the {@code Domain} attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.029 -0400", hash_original_method = "B9C3C16EC5CA859E4C76119DF97C2A63", hash_generated_method = "669B7CF3515AC44DDC034952EFC199EF")
    
public String getDomain() {
        return domain;
    }

    /**
     * Returns the {@code Max-Age} attribute, in delta-seconds.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.030 -0400", hash_original_method = "16F0F27CEE9DF29D5188D11CC5CB02D6", hash_generated_method = "4EA035A5EB1E95236697D8D713BAC234")
    
public long getMaxAge() {
        return maxAge;
    }

    /**
     * Returns the name of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.031 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    /**
     * Returns the {@code Path} attribute. This cookie is visible to all
     * subpaths.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.032 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "685DA06B3205BF0988B63E7E0C7CEB6C")
    
public String getPath() {
        return path;
    }

    /**
     * Returns the {@code Port} attribute, usually containing comma-separated
     * port numbers. A null port indicates that the cookie may be sent to any
     * port. The empty string indicates that the cookie should only be sent to
     * the port of the originating request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.034 -0400", hash_original_method = "5DCC652E6365673706366549DA99C772", hash_generated_method = "B6EEBC637A02C8D032230D85766DFA82")
    
public String getPortlist() {
        return portList;
    }

    /**
     * Returns the {@code Secure} attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.035 -0400", hash_original_method = "7FE064CD9D052A9E6DFFC458C5DB4AA0", hash_generated_method = "D6FA5A23CB991D4AE0C4B1E846991942")
    
public boolean getSecure() {
        return secure;
    }

    /**
     * Returns the value of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.036 -0400", hash_original_method = "CFCF943D36987E569CAB72593E604904", hash_generated_method = "60823E74DAC88C5FAC14BD2BA786CA0E")
    
public String getValue() {
        return value;
    }

    /**
     * Returns the version of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.037 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    /**
     * Returns true if this cookie's Max-Age is 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.039 -0400", hash_original_method = "C9745E60A32FB8CF1BBD26BB2C1CD114", hash_generated_method = "254C1FE4A52017B981598738104F2DEA")
    
public boolean hasExpired() {
        // -1 indicates the cookie will persist until browser shutdown
        // so the cookie is not expired.
        if (maxAge == -1l) {
            return false;
        }

        boolean expired = false;
        if (maxAge <= 0l) {
            expired = true;
        }
        return expired;
    }

    /**
     * Set the {@code Comment} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.040 -0400", hash_original_method = "924C3E4E33BD39AA8177BE1304F7CDE1", hash_generated_method = "00C0DB3B8908C94882F70597D1374F20")
    
public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Set the {@code CommentURL} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.042 -0400", hash_original_method = "62E0AC9A97DDE843465964528011A2CC", hash_generated_method = "AF204DAAC03D8E21B1C9303F1EF2685F")
    
public void setCommentURL(String commentURL) {
        this.commentURL = commentURL;
    }

    /**
     * Set the {@code Discard} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.043 -0400", hash_original_method = "9446CEDD4455A1D30E4774BBDD3B750C", hash_generated_method = "8D6D7D1EF3AEBEAFC8809B6895343AE5")
    
public void setDiscard(boolean discard) {
        this.discard = discard;
    }

    /**
     * Set the {@code Domain} attribute of this cookie. HTTP clients send
     * cookies only to matching domains.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.044 -0400", hash_original_method = "407561D4181A2AEA44C7F63835778FBA", hash_generated_method = "13B7275DA9CCAF90785331703637C489")
    
public void setDomain(String pattern) {
        domain = pattern == null ? null : pattern.toLowerCase(Locale.US);
    }

    /**
     * Sets the {@code Max-Age} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.046 -0400", hash_original_method = "CE5BBD720C6AA785E876BB9CA0B8E8B4", hash_generated_method = "3C58003F1D98CEF2BF86A1A49ACC64EF")
    
public void setMaxAge(long deltaSeconds) {
        maxAge = deltaSeconds;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.047 -0400", hash_original_method = "01517B59F5C590A10CA725F9EB5DFB5C", hash_generated_method = "A24B5A8A4D45DB758C4E3B34010F8132")
    
private void setExpires(Date expires) {
        maxAge = (expires.getTime() - System.currentTimeMillis()) / 1000;
    }

    /**
     * Set the {@code Path} attribute of this cookie. HTTP clients send cookies
     * to this path and its subpaths.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.048 -0400", hash_original_method = "1A350C65642B2EB29265EFAF484B49DE", hash_generated_method = "A16BAE4C540787D460E0637A5BCF12AD")
    
public void setPath(String path) {
        this.path = path;
    }

    /**
     * Set the {@code Port} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.050 -0400", hash_original_method = "5E8464C59BCC5B3B680C2CAA03F5182E", hash_generated_method = "BCF2F3FBA21C2BB0DEC4A84EF3AC10B8")
    
public void setPortlist(String portList) {
        this.portList = portList;
    }

    /**
     * Sets the {@code Secure} attribute of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.051 -0400", hash_original_method = "8FED8077F6BB7A246406B3BD4DF647FA", hash_generated_method = "4C56A4241A24014F591F37FAE4638575")
    
public void setSecure(boolean secure) {
        this.secure = secure;
    }

    /**
     * Sets the opaque value of this cookie.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.052 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "D16B84EC55CE2A5D49D90AFF65736D9E")
    
public void setValue(String value) {
        // FIXME: According to spec, version 0 cookie value does not allow many
        // symbols. But RI does not implement it. Follow RI temporarily.
        this.value = value;
    }

    /**
     * Sets the {@code Version} attribute of the cookie.
     *
     * @throws IllegalArgumentException if v is neither 0 nor 1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.054 -0400", hash_original_method = "FD28440BB4DF9B867EC0A5E758EE7683", hash_generated_method = "CF5FC02250482643A72829BAB31E1536")
    
public void setVersion(int v) {
        if (v != 0 && v != 1) {
            throw new IllegalArgumentException();
        }
        version = v;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.055 -0400", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "D24BA659AA7D0E532593D4A64FAB7FBB")
    
@Override public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * Returns true if {@code object} is a cookie with the same domain, name and
     * path. Domain and name use case-insensitive comparison; path uses a
     * case-sensitive comparison.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.056 -0400", hash_original_method = "98767A4F6B6A8166A8FB90501C38F844", hash_generated_method = "2CF974D80532F26BB0EA1E280E8EDB8C")
    
@Override public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof HttpCookie) {
            HttpCookie that = (HttpCookie) object;
            return name.equalsIgnoreCase(that.getName())
                    && (domain != null ? domain.equalsIgnoreCase(that.domain) : that.domain == null)
                    && Objects.equal(path, that.path);
        }
        return false;
    }

    /**
     * Returns the hash code of this HTTP cookie: <pre>   {@code
     *   name.toLowerCase(Locale.US).hashCode()
     *       + (domain == null ? 0 : domain.toLowerCase(Locale.US).hashCode())
     *       + (path == null ? 0 : path.hashCode())
     * }</pre>
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.058 -0400", hash_original_method = "EA65C222B8E6846E4F4EA864678DF561", hash_generated_method = "5F1946E4124643572C427BBCEC045EB5")
    
@Override public int hashCode() {
        return name.toLowerCase(Locale.US).hashCode()
                + (domain == null ? 0 : domain.toLowerCase(Locale.US).hashCode())
                + (path == null ? 0 : path.hashCode());
    }

    /**
     * Returns a string representing this cookie in the format used by the
     * {@code Cookie} header line in an HTTP request.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.059 -0400", hash_original_method = "A6BA199B9FBC744F2FAD7704A47DCC59", hash_generated_method = "AD09D263DED54A4D9A75CF64F68A1CE9")
    
@Override public String toString() {
        if (version == 0) {
            return name + "=" + value;
        }

        StringBuilder result = new StringBuilder()
                .append(name)
                .append("=")
                .append("\"")
                .append(value)
                .append("\"");
        appendAttribute(result, "Path", path);
        appendAttribute(result, "Domain", domain);
        appendAttribute(result, "Port", portList);
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:14.061 -0400", hash_original_method = "60DF7693951D76A29A5699AF5E3CD3DE", hash_generated_method = "115F1B438E9E2C757FBCFE2A03406A9E")
    
private void appendAttribute(StringBuilder builder, String name, String value) {
        if (value != null && builder != null) {
            builder.append(";$");
            builder.append(name);
            builder.append("=\"");
            builder.append(value);
            builder.append("\"");
        }
    }
}
