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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This class provides a concrete implementation of CookieHandler. It separates
 * the storage of cookies from the policy which decides to accept or deny
 * cookies. The constructor can have two arguments: a CookieStore and a
 * CookiePolicy. The former is in charge of cookie storage and the latter makes
 * decision on acceptance/rejection.
 *
 * CookieHandler is in the center of cookie management. User can make use of
 * CookieHandler.setDefault to set a CookieManager as the default one used.
 *
 * CookieManager.put uses CookiePolicy.shouldAccept to decide whether to put
 * some cookies into a cookie store. Three built-in CookiePolicy is defined:
 * ACCEPT_ALL, ACCEPT_NONE and ACCEPT_ORIGINAL_SERVER. Users can also customize
 * the policy by implementing CookiePolicy. Any accepted HTTP cookie is stored
 * in CookieStore and users can also have their own implementation. Up to now,
 * Only add(URI, HttpCookie) and get(URI) are used by CookieManager. Other
 * methods in this class may probably be used in a more complicated
 * implementation.
 *
 * There are many ways to customize user's own HTTP cookie management:
 *
 * First, call CookieHandler.setDefault to set a new CookieHandler
 * implementation. Second, call CookieHandler.getDefault to use CookieManager.
 * The CookiePolicy and CookieStore used are customized. Third, use the
 * customized CookiePolicy and the CookieStore.
 *
 * This implementation conforms to <a href="http://www.ietf.org/rfc/rfc2965.txt">RFC 2965</a> section 3.3.
 *
 * @since 1.6
 */
public class CookieManager extends CookieHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.562 -0400", hash_original_field = "C5C0B241D1D5D5D3E9C804FFB1A1F3DD", hash_generated_field = "34730E3F615C8AABDE07749FE6441D41")


    private static final String VERSION_ZERO_HEADER = "Set-cookie";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.564 -0400", hash_original_field = "7D32A40A4AE355AF1B2782B59F8C09EB", hash_generated_field = "FA52A655713EBED9FE84B17581AB8D6C")


    private static final String VERSION_ONE_HEADER = "Set-cookie2";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.570 -0400", hash_original_method = "87673B746385CB3658463682A889406D", hash_generated_method = "9C47171F2399E3D0CBF9AA3793A0EDAF")
    
private static Map<String, List<String>> cookiesToHeaders(List<HttpCookie> cookies) {
        if (cookies.isEmpty()) {
            return Collections.emptyMap();
        }

        StringBuilder result = new StringBuilder();

        // If all cookies are version 1, add a version 1 header. No header for version 0 cookies.
        int minVersion = 1;
        for (HttpCookie cookie : cookies) {
            minVersion = Math.min(minVersion, cookie.getVersion());
        }
        if (minVersion == 1) {
            result.append("$Version=\"1\"; ");
        }

        result.append(cookies.get(0).toString());
        for (int i = 1; i < cookies.size(); i++) {
            result.append("; ").append(cookies.get(i).toString());
        }

        return Collections.singletonMap("Cookie", Collections.singletonList(result.toString()));
    }

    /**
     * Returns a cookie-safe path by truncating everything after the last "/".
     * When request path like "/foo/bar.html" yields a cookie, that cookie's
     * default path is "/foo/".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.574 -0400", hash_original_method = "3C14C11CC4C50B1E61366E684AE79952", hash_generated_method = "21BA6282799D8C2FE0BC710B31353081")
    
static String pathToCookiePath(String path) {
        if (path == null) {
            return "/";
        }
        int lastSlash = path.lastIndexOf('/'); // -1 yields the empty string
        return path.substring(0, lastSlash + 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.576 -0400", hash_original_method = "815FB8E7045A78E1D1E81410642E411D", hash_generated_method = "7C9400AFE0C85EB02C613FB30B4AF3AB")
    
private static List<HttpCookie> parseCookie(Map<String, List<String>> responseHeaders) {
        List<HttpCookie> cookies = new ArrayList<HttpCookie>();
        for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
            String key = entry.getKey();
            // Only "Set-cookie" and "Set-cookie2" pair will be parsed
            if (key != null && (key.equalsIgnoreCase(VERSION_ZERO_HEADER)
                    || key.equalsIgnoreCase(VERSION_ONE_HEADER))) {
                // parse list elements one by one
                for (String cookieStr : entry.getValue()) {
                    try {
                        for (HttpCookie cookie : HttpCookie.parse(cookieStr)) {
                            cookies.add(cookie);
                        }
                    } catch (IllegalArgumentException ignored) {
                        // this string is invalid, jump to the next one.
                    }
                }
            }
        }
        return cookies;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.560 -0400", hash_original_field = "C37C43B8AD216947062B19EB96D94A13", hash_generated_field = "B4671C1EFA7C87E673A116B4E86AF411")

    private CookieStore store;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.561 -0400", hash_original_field = "0F9DB270B34391FCC06395C01F5353E2", hash_generated_field = "A66E92C14C46C15A3BF3C4BE05408210")


    private CookiePolicy policy;

    /**
     * Constructs a new cookie manager.
     *
     * The invocation of this constructor is the same as the invocation of
     * CookieManager(null, null).
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.565 -0400", hash_original_method = "3A04C32A8DE7D83F990538D0D88B62D1", hash_generated_method = "5D3E86335AA2E5464E6CEAECD645EC93")
    
public CookieManager() {
        this(null, null);
    }

    /**
     * Constructs a new cookie manager using a specified cookie store and a
     * cookie policy.
     *
     * @param store
     *            a CookieStore to be used by cookie manager. The manager will
     *            use a default one if the arg is null.
     * @param cookiePolicy
     *            a CookiePolicy to be used by cookie manager
     *            ACCEPT_ORIGINAL_SERVER will be used if the arg is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.567 -0400", hash_original_method = "E1AE690439B99186744061A6E3E661B4", hash_generated_method = "27A02049D54ADEE5D264F1C3D97D47CE")
    
public CookieManager(CookieStore store, CookiePolicy cookiePolicy) {
        this.store = store == null ? new CookieStoreImpl() : store;
        policy = cookiePolicy == null ? CookiePolicy.ACCEPT_ORIGINAL_SERVER
                : cookiePolicy;
    }

    /**
     * Searches and gets all cookies in the cache by the specified uri in the
     * request header.
     *
     * @param uri
     *            the specified uri to search for
     * @param requestHeaders
     *            a list of request headers
     * @return a map that record all such cookies, the map is unchangeable
     * @throws IOException
     *             if some error of I/O operation occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.568 -0400", hash_original_method = "7AD35AEE8B367CF99C5B76D9B3401385", hash_generated_method = "E301BFF67D4E9753E630A549198A67F2")
    
@Override
    public Map<String, List<String>> get(URI uri,
            Map<String, List<String>> requestHeaders) throws IOException {
        if (uri == null || requestHeaders == null) {
            throw new IllegalArgumentException();
        }

        List<HttpCookie> result = new ArrayList<HttpCookie>();
        for (HttpCookie cookie : store.get(uri)) {
            if (HttpCookie.pathMatches(cookie, uri)
                    && HttpCookie.secureMatches(cookie, uri)
                    && HttpCookie.portMatches(cookie, uri)) {
                result.add(cookie);
            }
        }

        return cookiesToHeaders(result);
    }

    /**
     * Sets cookies according to uri and responseHeaders
     *
     * @param uri
     *            the specified uri
     * @param responseHeaders
     *            a list of request headers
     * @throws IOException
     *             if some error of I/O operation occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.573 -0400", hash_original_method = "AA41ECB0FD8460C872351D9420D4F3BB", hash_generated_method = "436E622957C5CA1B703588F15453314A")
    
@Override
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
        if (uri == null || responseHeaders == null) {
            throw new IllegalArgumentException();
        }

        // parse and construct cookies according to the map
        List<HttpCookie> cookies = parseCookie(responseHeaders);
        for (HttpCookie cookie : cookies) {

            // if the cookie doesn't have a domain, set one. The policy will do validation.
            if (cookie.getDomain() == null) {
                cookie.setDomain(uri.getHost());
            }

            // if the cookie doesn't have a path, set one. If it does, validate it.
            if (cookie.getPath() == null) {
                cookie.setPath(pathToCookiePath(uri.getPath()));
            } else if (!HttpCookie.pathMatches(cookie, uri)) {
                continue;
            }

            // if the cookie has the placeholder port list "", set the port. Otherwise validate it.
            if ("".equals(cookie.getPortlist())) {
                cookie.setPortlist(Integer.toString(uri.getEffectivePort()));
            } else if (cookie.getPortlist() != null && !HttpCookie.portMatches(cookie, uri)) {
                continue;
            }

            // if the cookie conforms to the policy, add it into the store
            if (policy.shouldAccept(uri, cookie)) {
                store.add(uri, cookie);
            }
        }
    }

    /**
     * Sets the cookie policy of this cookie manager.
     *
     * ACCEPT_ORIGINAL_SERVER is the default policy for CookieManager.
     *
     * @param cookiePolicy
     *            the cookie policy. if null, the original policy will not be
     *            changed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.577 -0400", hash_original_method = "0CE095D1026654AC8B0527C3CDBD6118", hash_generated_method = "385499E2786816A055E8154313A2A12B")
    
public void setCookiePolicy(CookiePolicy cookiePolicy) {
        if (cookiePolicy != null) {
            policy = cookiePolicy;
        }
    }

    /**
     * Gets current cookie store.
     *
     * @return the cookie store currently used by cookie manager.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:13.579 -0400", hash_original_method = "B7A373D3599444524767DB420E315271", hash_generated_method = "FFF02FB4DBFF15D9E983D6B0A1EAF210")
    
public CookieStore getCookieStore() {
        return store;
    }
}
