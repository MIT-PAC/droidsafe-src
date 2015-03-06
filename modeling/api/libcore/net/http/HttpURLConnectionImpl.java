/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.nio.charset.Charsets;
import java.security.Permission;
import java.util.List;
import java.util.Map;

import libcore.io.Base64;

class HttpURLConnectionImpl extends HttpURLConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.477 -0500", hash_original_field = "47331465E462A0CF223A67E4F658AFC0", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private  int defaultPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.479 -0500", hash_original_field = "CA775536D3A7F4013C2E9C464BE24463", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

    private Proxy proxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.482 -0500", hash_original_field = "EEFFD738A722C43ED09048A0C45C67C3", hash_generated_field = "8901C38E8957C4A2EFEC6534B9EB9BEE")

    private final RawHeaders rawRequestHeaders = new RawHeaders();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.484 -0500", hash_original_field = "9A432EFC6EA3EB58D5A662A405B8695B", hash_generated_field = "EC2EBB12D4ECEAB53DC00655B16FEA0F")

    private int redirectionCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.487 -0500", hash_original_field = "75250CF3B6F9AA5DD6EB86C7BAD77367", hash_generated_field = "7A97BD477901CB40BE3809D713545FCF")

    protected IOException httpEngineFailure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.489 -0500", hash_original_field = "04E98FAE9CC901E38788E48C2AC65903", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected HttpEngine httpEngine;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.491 -0500", hash_original_method = "728F41C3EA57BB4820711A693EC4FE30", hash_generated_method = "E61114A270D757026FE0AB81F947F4A9")
    
protected HttpURLConnectionImpl(URL url, int port) {
        super(url);
        defaultPort = port;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.494 -0500", hash_original_method = "77B9035B2943659FD08A151F360F3F70", hash_generated_method = "67C013E246197F37018D56CCC73D8414")
    
protected HttpURLConnectionImpl(URL url, int port, Proxy proxy) {
        this(url, port);
        this.proxy = proxy;
    }

    @DSSpec(DSCat.INTERNET)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.497 -0500", hash_original_method = "07B4C440A95D9405D35DB78948CBC089", hash_generated_method = "0896A3457DB910274CD957E12A356867")
    
@Override public final void connect() throws IOException {
        initHttpEngine();
        try {
            httpEngine.sendRequest();
        } catch (IOException e) {
            httpEngineFailure = e;
            throw e;
        }
    }

    @DSSafe(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.500 -0500", hash_original_method = "4F701A35ACBE562FB824E28633AD60E1", hash_generated_method = "BF9D464DBC2E9802325FA66A8043C490")
    
@Override public final void disconnect() {
        // Calling disconnect() before a connection exists should have no effect.
        if (httpEngine != null) {
            httpEngine.release(false);
        }
    }

    /**
     * Returns an input stream from the server in the case of error such as the
     * requested file (txt, htm, html) is not found on the remote server.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.502 -0500", hash_original_method = "1368F0D99A95C3E16EFCFEF5107A78C1", hash_generated_method = "1B71739BD68938AC170DF5E2779ED614")
    
@Override public final InputStream getErrorStream() {
        try {
            HttpEngine response = getResponse();
            if (response.hasResponseBody()
                    && response.getResponseCode() >= HTTP_BAD_REQUEST) {
                return response.getResponseBody();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Returns the value of the field at {@code position}. Returns null if there
     * are fewer than {@code position} headers.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.505 -0500", hash_original_method = "2FDBF8E663ECDF1396771B3FB2E938AE", hash_generated_method = "06437FA6B22B1A855ACD6C65696EC4F8")
    
@Override public final String getHeaderField(int position) {
        try {
            return getResponse().getResponseHeaders().getHeaders().getValue(position);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Returns the value of the field corresponding to the {@code fieldName}, or
     * null if there is no such field. If the field has multiple values, the
     * last value is returned.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.507 -0500", hash_original_method = "8E358A78EB7A8F16DBAC360C5AE52593", hash_generated_method = "E975B3413BF7B4CBEA3B72CCBD80757D")
    
@Override public final String getHeaderField(String fieldName) {
        try {
            RawHeaders rawHeaders = getResponse().getResponseHeaders().getHeaders();
            return fieldName == null
                    ? rawHeaders.getStatusLine()
                    : rawHeaders.get(fieldName);
        } catch (IOException e) {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.510 -0500", hash_original_method = "6CE04EB06299A563E0E12D5A9A984EA5", hash_generated_method = "E220698974C6945E17F6F852C89C1663")
    
@Override public final String getHeaderFieldKey(int position) {
        try {
            return getResponse().getResponseHeaders().getHeaders().getFieldName(position);
        } catch (IOException e) {
            return null;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.513 -0500", hash_original_method = "D21D6124D988B0F314746165ED1B208D", hash_generated_method = "BDCA0198F73E91F2C4C60ADD544DC1AE")
    
@Override public final Map<String, List<String>> getHeaderFields() {
        try {
            return getResponse().getResponseHeaders().getHeaders().toMultimap();
        } catch (IOException e) {
            return null;
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.516 -0500", hash_original_method = "AC69DF55837DC027461A6B3E8E60D121", hash_generated_method = "25DC35D916AF1079C8F909E7064F1A2B")
    
@Override public final Map<String, List<String>> getRequestProperties() {
        if (connected) {
            throw new IllegalStateException(
                    "Cannot access request header fields after connection is set");
        }
        return rawRequestHeaders.toMultimap();
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.519 -0500", hash_original_method = "45F412B75FA838EAF632FEA7E5AD9CE7", hash_generated_method = "1471DC304138D06A38141012D0B8ABF1")
    
@Override public final InputStream getInputStream() throws IOException {
        if (!doInput) {
            throw new ProtocolException("This protocol does not support input");
        }

        HttpEngine response = getResponse();

        /*
         * if the requested file does not exist, throw an exception formerly the
         * Error page from the server was returned if the requested file was
         * text/html this has changed to return FileNotFoundException for all
         * file types
         */
        if (getResponseCode() >= HTTP_BAD_REQUEST) {
            throw new FileNotFoundException(url.toString());
        }

        InputStream result = response.getResponseBody();
        if (result == null) {
            throw new IOException("No response body exists; responseCode=" + getResponseCode());
        }
        return result;
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.521 -0500", hash_original_method = "37EC8C214191B016BC801CEDA20A2C80", hash_generated_method = "90A3BD13B64C0D5D9A78F0CA7D768269")
    
@Override public final OutputStream getOutputStream() throws IOException {
        connect();

        OutputStream result = httpEngine.getRequestBody();
        if (result == null) {
            throw new ProtocolException("method does not support a request body: " + method);
        } else if (httpEngine.hasResponse()) {
            throw new ProtocolException("cannot write request body after response has been read");
        }

        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.524 -0500", hash_original_method = "E4EEF5ABFFEA53BFCAB2562386B86E28", hash_generated_method = "0E17726F952DBEA475F530E2B61086B6")
    
@Override public final Permission getPermission() throws IOException {
        String connectToAddress = getConnectToHost() + ":" + getConnectToPort();
        return new SocketPermission(connectToAddress, "connect, resolve");
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.526 -0500", hash_original_method = "B5D2FEB67E0E8EA367DFCE05C581AB69", hash_generated_method = "AE775710081CF2C9094FA821E4D19F53")
    
private String getConnectToHost() {
        return usingProxy()
                ? ((InetSocketAddress) proxy.address()).getHostName()
                : getURL().getHost();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.528 -0500", hash_original_method = "D34A028DDA4370B463B41421A37DF230", hash_generated_method = "2E8CACF616E0FA4CDCA4BE6131CE565A")
    
private int getConnectToPort() {
        int hostPort = usingProxy()
                ? ((InetSocketAddress) proxy.address()).getPort()
                : getURL().getPort();
        return hostPort < 0 ? getDefaultPort() : hostPort;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.532 -0500", hash_original_method = "8A514716C0CABE10C77E4E0516E7C928", hash_generated_method = "0A40F819DA3C6228938F5A719204351F")
    
@Override public final String getRequestProperty(String field) {
        if (field == null) {
            return null;
        }
        return rawRequestHeaders.get(field);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.534 -0500", hash_original_method = "D46D1C92B88A5C8C0BC8F8E633D4D9BD", hash_generated_method = "EFE388E63F589AA39FB5F13634CA5D47")
    
private void initHttpEngine() throws IOException {
        if (httpEngineFailure != null) {
            throw httpEngineFailure;
        } else if (httpEngine != null) {
            return;
        }

        connected = true;
        try {
            if (doOutput) {
                if (method == HttpEngine.GET) {
                    // they are requesting a stream to write to. This implies a POST method
                    method = HttpEngine.POST;
                } else if (method != HttpEngine.POST && method != HttpEngine.PUT) {
                    // If the request method is neither POST nor PUT, then you're not writing
                    throw new ProtocolException(method + " does not support writing");
                }
            }
            httpEngine = newHttpEngine(method, rawRequestHeaders, null, null);
        } catch (IOException e) {
            httpEngineFailure = e;
            throw e;
        }
    }

    /**
     * Create a new HTTP engine. This hook method is non-final so it can be
     * overridden by HttpsURLConnectionImpl.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.537 -0500", hash_original_method = "AFF3FB19470EAA9A5BE239431B6A906A", hash_generated_method = "9614F1989B30184E7DCC8B780A34FCCC")
    
protected HttpEngine newHttpEngine(String method, RawHeaders requestHeaders,
            HttpConnection connection, RetryableOutputStream requestBody) throws IOException {
        return new HttpEngine(this, method, requestHeaders, connection, requestBody);
    }

    /**
     * Aggressively tries to get the final HTTP response, potentially making
     * many HTTP requests in the process in order to cope with redirects and
     * authentication.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.540 -0500", hash_original_method = "DF359A1395A825950E7AA2723E1FBB6D", hash_generated_method = "2B109151B6C631F562FC32636EA2FDF9")
    
private HttpEngine getResponse() throws IOException {
        initHttpEngine();

        if (httpEngine.hasResponse()) {
            return httpEngine;
        }

        try {
            while (true) {
                httpEngine.sendRequest();
                httpEngine.readResponse();

                Retry retry = processResponseHeaders();
                if (retry == Retry.NONE) {
                    httpEngine.automaticallyReleaseConnectionToPool();
                    break;
                }

                /*
                 * The first request was insufficient. Prepare for another...
                 */
                String retryMethod = method;
                OutputStream requestBody = httpEngine.getRequestBody();

                /*
                 * Although RFC 2616 10.3.2 specifies that a HTTP_MOVED_PERM
                 * redirect should keep the same method, Chrome, Firefox and the
                 * RI all issue GETs when following any redirect.
                 */
                int responseCode = getResponseCode();
                if (responseCode == HTTP_MULT_CHOICE || responseCode == HTTP_MOVED_PERM
                        || responseCode == HTTP_MOVED_TEMP || responseCode == HTTP_SEE_OTHER) {
                    retryMethod = HttpEngine.GET;
                    requestBody = null;
                }

                if (requestBody != null && !(requestBody instanceof RetryableOutputStream)) {
                    throw new HttpRetryException("Cannot retry streamed HTTP body",
                            httpEngine.getResponseCode());
                }

                if (retry == Retry.DIFFERENT_CONNECTION) {
                    httpEngine.automaticallyReleaseConnectionToPool();
                }

                httpEngine.release(true);

                httpEngine = newHttpEngine(retryMethod, rawRequestHeaders,
                        httpEngine.getConnection(), (RetryableOutputStream) requestBody);
            }
            return httpEngine;
        } catch (IOException e) {
            httpEngineFailure = e;
            throw e;
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.542 -0500", hash_original_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B", hash_generated_method = "1D777298E2B9DEBB3E2DB7ADA4E2C95B")
    
HttpEngine getHttpEngine() {
        return httpEngine;
    }

    /**
     * Returns the retry action to take for the current response headers. The
     * headers, proxy and target URL or this connection may be adjusted to
     * prepare for a follow up request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.547 -0500", hash_original_method = "CCC24799A0A4E36EF41D9DC91181B3F5", hash_generated_method = "CCA099F176C13ED8EEA04F95F200FB2A")
    
private Retry processResponseHeaders() throws IOException {
        switch (getResponseCode()) {
        case HTTP_PROXY_AUTH:
            if (!usingProxy()) {
                throw new IOException(
                        "Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            // fall-through
        case HTTP_UNAUTHORIZED:
            boolean credentialsFound = processAuthHeader(getResponseCode(),
                    httpEngine.getResponseHeaders(), rawRequestHeaders);
            return credentialsFound ? Retry.SAME_CONNECTION : Retry.NONE;

        case HTTP_MULT_CHOICE:
        case HTTP_MOVED_PERM:
        case HTTP_MOVED_TEMP:
        case HTTP_SEE_OTHER:
            if (!getInstanceFollowRedirects()) {
                return Retry.NONE;
            }
            if (++redirectionCount > HttpEngine.MAX_REDIRECTS) {
                throw new ProtocolException("Too many redirects");
            }
            String location = getHeaderField("Location");
            if (location == null) {
                return Retry.NONE;
            }
            URL previousUrl = url;
            url = new URL(previousUrl, location);
            if (!previousUrl.getProtocol().equals(url.getProtocol())) {
                return Retry.NONE; // the scheme changed; don't retry.
            }
            if (previousUrl.getHost().equals(url.getHost())
                    && previousUrl.getEffectivePort() == url.getEffectivePort()) {
                return Retry.SAME_CONNECTION;
            } else {
                return Retry.DIFFERENT_CONNECTION;
            }

        default:
            return Retry.NONE;
        }
    }

    /**
     * React to a failed authorization response by looking up new credentials.
     *
     * @return true if credentials have been added to successorRequestHeaders
     *     and another request should be attempted.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.549 -0500", hash_original_method = "823D52F347E7C18D3A6EC0D6C7FA9FFF", hash_generated_method = "55742085A6820587CDC5C085AB86C7B6")
    
final boolean processAuthHeader(int responseCode, ResponseHeaders response,
            RawHeaders successorRequestHeaders) throws IOException {
        if (responseCode != HTTP_PROXY_AUTH && responseCode != HTTP_UNAUTHORIZED) {
            throw new IllegalArgumentException();
        }

        // keep asking for username/password until authorized
        String challenge = responseCode == HTTP_PROXY_AUTH
                ? response.getProxyAuthenticate()
                : response.getWwwAuthenticate();
        if (challenge == null) {
            throw new IOException("Received authentication challenge is null");
        }
        String credentials = getAuthorizationCredentials(challenge);
        if (credentials == null) {
            return false; // could not find credentials, end request cycle
        }

        // add authorization credentials, bypassing the already-connected check
        String fieldName = responseCode == HTTP_PROXY_AUTH
                ? "Proxy-Authorization"
                : "Authorization";
        successorRequestHeaders.set(fieldName, credentials);
        return true;
    }

    /**
     * Returns the authorization credentials on the base of provided challenge.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.552 -0500", hash_original_method = "3D7D8508CEE0817C42F7A7AE8F461D7F", hash_generated_method = "185023FCB2973AB99FB044341A02CB50")
    
private String getAuthorizationCredentials(String challenge) throws IOException {
        int idx = challenge.indexOf(" ");
        if (idx == -1) {
            return null;
        }
        String scheme = challenge.substring(0, idx);
        int realm = challenge.indexOf("realm=\"") + 7;
        String prompt = null;
        if (realm != -1) {
            int end = challenge.indexOf('"', realm);
            if (end != -1) {
                prompt = challenge.substring(realm, end);
            }
        }
        // use the global authenticator to get the password
        PasswordAuthentication pa = Authenticator.requestPasswordAuthentication(
                getConnectToInetAddress(), getConnectToPort(), url.getProtocol(), prompt, scheme);
        if (pa == null) {
            return null;
        }
        // base64 encode the username and password
        String usernameAndPassword = pa.getUserName() + ":" + new String(pa.getPassword());
        byte[] bytes = usernameAndPassword.getBytes(Charsets.ISO_8859_1);
        String encoded = Base64.encode(bytes);
        return scheme + " " + encoded;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.555 -0500", hash_original_method = "1B9895D1709534856DAC9B7A8958AAC2", hash_generated_method = "4C0DEE0E044FD3A376B1832AA6C8DD4F")
    
private InetAddress getConnectToInetAddress() throws IOException {
        return usingProxy()
                ? ((InetSocketAddress) proxy.address()).getAddress()
                : InetAddress.getByName(getURL().getHost());
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.557 -0500", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "431F6F7E489BFBF7FB4816405A638734")
    
final int getDefaultPort() {
        return defaultPort;
    }

    /** @see HttpURLConnection#setFixedLengthStreamingMode(int) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.560 -0500", hash_original_method = "3D0FB6F793A38CF78094814B08E28C50", hash_generated_method = "2A9DBFC0881B3259DBC4AD6354DE3A0C")
    
final int getFixedContentLength() {
        return fixedContentLength;
    }

    /** @see HttpURLConnection#setChunkedStreamingMode(int) */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.562 -0500", hash_original_method = "4A001CCB8DCF47A598AF69D3AEEFDD47", hash_generated_method = "1011AF34A3D83F6E28A597C3774FCCF9")
    
final int getChunkLength() {
        return chunkLength;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.564 -0500", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "571B5CF73C69A11B0F3ACD2ECA862227")
    
final Proxy getProxy() {
        return proxy;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.566 -0500", hash_original_method = "AA3CF596E23C06E2ACCB3F9CB3C07696", hash_generated_method = "6BFEE1F0907ACC2B40F8FB84044505F8")
    
final void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.569 -0500", hash_original_method = "A58A957A50BCFC01E0E67FBE67235F98", hash_generated_method = "25D29ED1AFAB3B9F2E1A5498D73E0342")
    
@Override public final boolean usingProxy() {
        return (proxy != null && proxy.type() != Proxy.Type.DIRECT);
    }

    @DSSafe(DSCat.IO)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.571 -0500", hash_original_method = "9D8B4374AC98844408DFFFE370FDA266", hash_generated_method = "0B499DF550BA661FCA1181BB7DFA6E19")
    
@Override public String getResponseMessage() throws IOException {
        return getResponse().getResponseHeaders().getHeaders().getResponseMessage();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.573 -0500", hash_original_method = "721B81AA4282A5EC0FCB04AA341634A3", hash_generated_method = "60A77DCA9BF2BED0D957882C1E30A07F")
    
@Override public final int getResponseCode() throws IOException {
        return getResponse().getResponseCode();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.576 -0500", hash_original_method = "7F130ED52470D904C9FF4F495D6529EB", hash_generated_method = "403D82FE89DCF2C5B341CE7EB21CF163")
    
@Override public final void setRequestProperty(String field, String newValue) {
        if (connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
        if (field == null) {
            throw new NullPointerException("field == null");
        }
        rawRequestHeaders.set(field, newValue);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.579 -0500", hash_original_method = "7F83225C975C5F17C1596781844ADD1B", hash_generated_method = "3055422F5B2C0F0ECA56E6824CDB085A")
    
@Override public final void addRequestProperty(String field, String value) {
        if (connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
        if (field == null) {
            throw new NullPointerException("field == null");
        }
        rawRequestHeaders.add(field, value);
    }
    
    enum Retry {
        NONE,
        SAME_CONNECTION,
        DIFFERENT_CONNECTION
    }
    
}

