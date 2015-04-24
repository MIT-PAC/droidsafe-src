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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/cookie/RFC2109Spec.java $
 * $Revision: 677240 $
 * $Date: 2008-07-16 04:25:47 -0700 (Wed, 16 Jul 2008) $
 * 
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookiePathComparator;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;

public class RFC2109Spec extends CookieSpecBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.996 -0500", hash_original_field = "C1E36DB80477C907988316C7AE3F2667", hash_generated_field = "858B7D4610C97949773EF50E93F05188")

    private final static CookiePathComparator PATH_COMPARATOR = new CookiePathComparator();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.998 -0500", hash_original_field = "9FDFAD601FA4700E0541EA552C868FB0", hash_generated_field = "FBD8DD687539DFF4AAFA7EAA45AC1BE6")
    
    private final static String[] DATE_PATTERNS = {
        DateUtils.PATTERN_RFC1123,
        DateUtils.PATTERN_RFC1036,
        DateUtils.PATTERN_ASCTIME 
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.001 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")
    
    private  String[] datepatterns;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.003 -0500", hash_original_field = "9FF87D24DBC0DA1B27533708A63D8684", hash_generated_field = "E82ADEB303AC7BD75F069F4A1A160C67")
 
    private  boolean oneHeader;
    
    /** Default constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.006 -0500", hash_original_method = "12A896738D34FDBE49C7AA7970841F81", hash_generated_method = "3A704C77A30EBEC9AB2363C5F2948123")
    
public RFC2109Spec(final String[] datepatterns, boolean oneHeader) {
        super();
        if (datepatterns != null) {
            this.datepatterns = datepatterns.clone();
        } else {
            this.datepatterns = DATE_PATTERNS;
        }
        this.oneHeader = oneHeader;
        registerAttribHandler(ClientCookie.VERSION_ATTR, new RFC2109VersionHandler());
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new RFC2109DomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
    }

    /** Default constructor */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.009 -0500", hash_original_method = "2854FB63A9A4FFE7625656D05E6D284B", hash_generated_method = "9300A0014D424ED468601EDD0D0C2BCD")
    
public RFC2109Spec() {
        this(null, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.011 -0500", hash_original_method = "FE34B3C1E0CEB3E28830FDDDCE3EDCF4", hash_generated_method = "1E69B302B79CA0BC5CD6955157C9E454")
    
public List<Cookie> parse(final Header header, final CookieOrigin origin) 
            throws MalformedCookieException {
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        HeaderElement[] elems = header.getElements();
        return parse(elems, origin);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.014 -0500", hash_original_method = "FA8C9B830274A9DE10C31E9A8EA08163", hash_generated_method = "EC51632981D547394900D24103F3E873")
    
@Override
    public void validate(final Cookie cookie, final CookieOrigin origin) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        String name = cookie.getName();
        if (name.indexOf(' ') != -1) {
            throw new MalformedCookieException("Cookie name may not contain blanks");
        }
        if (name.startsWith("$")) {
            throw new MalformedCookieException("Cookie name may not start with $");
        }
        super.validate(cookie, origin);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.016 -0500", hash_original_method = "67F48779D521683257B0CC0E930A401A", hash_generated_method = "CCCF8A733A763814B299D140058FDDBD")
    
public List<Header> formatCookies(List<Cookie> cookies) {
        if (cookies == null) {
            throw new IllegalArgumentException("List of cookies may not be null");
        }
        if (cookies.isEmpty()) {
            throw new IllegalArgumentException("List of cookies may not be empty");
        }
        if (cookies.size() > 1) {
            // Create a mutable copy and sort the copy.
            cookies = new ArrayList<Cookie>(cookies);
            Collections.sort(cookies, PATH_COMPARATOR);
        }
        if (this.oneHeader) {
            return doFormatOneHeader(cookies);
        } else {
            return doFormatManyHeaders(cookies);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.019 -0500", hash_original_method = "13FFFC492D1247BC18ED6817446ED518", hash_generated_method = "B8581BF2677F145960FF0E5498648A37")
    
private List<Header> doFormatOneHeader(final List<Cookie> cookies) {
        int version = Integer.MAX_VALUE;
        // Pick the lowest common denominator
        for (Cookie cookie : cookies) {
            if (cookie.getVersion() < version) {
                version = cookie.getVersion();
            }
        }
        CharArrayBuffer buffer = new CharArrayBuffer(40 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
        buffer.append("$Version=");
        buffer.append(Integer.toString(version));
        for (Cookie cooky : cookies) {
            buffer.append("; ");
            Cookie cookie = cooky;
            formatCookieAsVer(buffer, cookie, version);
        }
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
        return headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.021 -0500", hash_original_method = "8AE6C62AD6B7A2305FE4DC1EC3AC9430", hash_generated_method = "0EA964C60376BFCC5E572C317C5F4B1B")
    
private List<Header> doFormatManyHeaders(final List<Cookie> cookies) {
        List<Header> headers = new ArrayList<Header>(cookies.size());
        for (Cookie cookie : cookies) {
            int version = cookie.getVersion();
            CharArrayBuffer buffer = new CharArrayBuffer(40);
            buffer.append("Cookie: ");
            buffer.append("$Version=");
            buffer.append(Integer.toString(version));
            buffer.append("; ");
            formatCookieAsVer(buffer, cookie, version);
            headers.add(new BufferedHeader(buffer));
        }
        return headers;
    }
    
    /**
     * Return a name/value string suitable for sending in a <tt>"Cookie"</tt>
     * header as defined in RFC 2109 for backward compatibility with cookie
     * version 0
     * @param buffer The char array buffer to use for output
     * @param name The cookie name
     * @param value The cookie value
     * @param version The cookie version 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.024 -0500", hash_original_method = "06F97D44B0AB130D85C55056AFD5C23B", hash_generated_method = "715330B376520E3766CB28E7F6AB5E88")
    
protected void formatParamAsVer(final CharArrayBuffer buffer, 
            final String name, final String value, int version) {
        buffer.append(name);
        buffer.append("=");
        if (value != null) {
            if (version > 0) {
                buffer.append('\"');
                buffer.append(value);
                buffer.append('\"');
            } else {
                buffer.append(value);
            }
        }
    }

    /**
     * Return a string suitable for sending in a <tt>"Cookie"</tt> header 
     * as defined in RFC 2109 for backward compatibility with cookie version 0
     * @param buffer The char array buffer to use for output
     * @param cookie The {@link Cookie} to be formatted as string
     * @param version The version to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.027 -0500", hash_original_method = "FCDC82ACC7F918D2268FA007BF779A17", hash_generated_method = "5FD2C236158C26BC0F79AF7BB3B83840")
    
protected void formatCookieAsVer(final CharArrayBuffer buffer, 
            final Cookie cookie, int version) {
        formatParamAsVer(buffer, cookie.getName(), cookie.getValue(), version);
        if (cookie.getPath() != null) {
            if (cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.PATH_ATTR)) {
                buffer.append("; ");
                formatParamAsVer(buffer, "$Path", cookie.getPath(), version);
            }
        }
        if (cookie.getDomain() != null) {
            if (cookie instanceof ClientCookie 
                    && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
                buffer.append("; ");
                formatParamAsVer(buffer, "$Domain", cookie.getDomain(), version);
            }
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.029 -0500", hash_original_method = "48398E54A721F2ABBD2AD2C5ED75FBF5", hash_generated_method = "719DB27FE9B3080E562D1961E821ABAC")
    
public int getVersion() {
        return 1;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.032 -0500", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "1B200382D02120253E20B1BF08CC95D3")
    
public Header getVersionHeader() {
        return null;
    }
}

