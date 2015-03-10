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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/cookie/RFC2965DomainAttributeHandler.java $
 * $Revision: 653041 $
 * $Date: 2008-05-03 03:39:28 -0700 (Sat, 03 May 2008) $
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
import java.util.Locale;

import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;

public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.243 -0500", hash_original_method = "5C926F9EE1EA6288872238281D019BE6", hash_generated_method = "CF3A76679EF46895931226F828AC53C7")
    
public RFC2965DomainAttributeHandler() {
        super();
    }

    /**
     * Parse cookie domain attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.246 -0500", hash_original_method = "CA7EEF802D39DD35821E8C5DF292BB9E", hash_generated_method = "920F6FBF2CA4E75ED27B7EB38BB24898")
    
public void parse(final SetCookie cookie, String domain)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (domain == null) {
            throw new MalformedCookieException(
                    "Missing value for domain attribute");
        }
        if (domain.trim().length() == 0) {
            throw new MalformedCookieException(
                    "Blank value for domain attribute");
        }
        domain = domain.toLowerCase(Locale.ENGLISH);
        if (!domain.startsWith(".")) {
            // Per RFC 2965 section 3.2.2
            // "... If an explicitly specified value does not start with
            // a dot, the user agent supplies a leading dot ..."
            // That effectively implies that the domain attribute 
            // MAY NOT be an IP address of a host name
            domain = '.' + domain;
        }
        cookie.setDomain(domain);
    }

    /**
     * Performs domain-match as defined by the RFC2965.
     * <p>
     * Host A's name domain-matches host B's if
     * <ol>
     *   <ul>their host name strings string-compare equal; or</ul>
     *   <ul>A is a HDN string and has the form NB, where N is a non-empty
     *       name string, B has the form .B', and B' is a HDN string.  (So,
     *       x.y.com domain-matches .Y.com but not Y.com.)</ul>
     * </ol>
     *
     * @param host host name where cookie is received from or being sent to.
     * @param domain The cookie domain attribute.
     * @return true if the specified host matches the given domain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.248 -0500", hash_original_method = "63286152494B19CF26590FA425B39B18", hash_generated_method = "F9C67CEB7FC05B284B157EA7E1FC8FFF")
    
public boolean domainMatch(String host, String domain) {
        boolean match = host.equals(domain)
                        || (domain.startsWith(".") && host.endsWith(domain));

        return match;
    }

    /**
     * Validate cookie domain attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.251 -0500", hash_original_method = "CABE0CDEFEE66B5261D13BB72FC54CFF", hash_generated_method = "175B4AFDAB0348B0677E41D1C24635BB")
    
public void validate(final Cookie cookie, final CookieOrigin origin)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        if (cookie.getDomain() == null) {
            throw new MalformedCookieException("Invalid cookie state: " +
                                               "domain not specified");
        }
        String cookieDomain = cookie.getDomain().toLowerCase(Locale.ENGLISH);

        if (cookie instanceof ClientCookie 
                && ((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
            // Domain attribute must start with a dot
            if (!cookieDomain.startsWith(".")) {
                throw new MalformedCookieException("Domain attribute \"" +
                    cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
            }

            // Domain attribute must contain at least one embedded dot,
            // or the value must be equal to .local.
            int dotIndex = cookieDomain.indexOf('.', 1);
            if (((dotIndex < 0) || (dotIndex == cookieDomain.length() - 1))
                && (!cookieDomain.equals(".local"))) {
                throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: the value contains no embedded dots "
                        + "and the value is not .local");
            }

            // The effective host name must domain-match domain attribute.
            if (!domainMatch(host, cookieDomain)) {
                throw new MalformedCookieException(
                        "Domain attribute \"" + cookie.getDomain()
                        + "\" violates RFC 2965: effective host name does not "
                        + "domain-match domain attribute.");
            }

            // effective host name minus domain must not contain any dots
            String effectiveHostWithoutDomain = host.substring(
                    0, host.length() - cookieDomain.length());
            if (effectiveHostWithoutDomain.indexOf('.') != -1) {
                throw new MalformedCookieException("Domain attribute \""
                                                   + cookie.getDomain() + "\" violates RFC 2965: "
                                                   + "effective host minus domain may not contain any dots");
            }
        } else {
            // Domain was not specified in header. In this case, domain must
            // string match request host (case-insensitive).
            if (!cookie.getDomain().equals(host)) {
                throw new MalformedCookieException("Illegal domain attribute: \""
                                                   + cookie.getDomain() + "\"."
                                                   + "Domain of origin: \""
                                                   + host + "\"");
            }
        }
    }

    /**
     * Match cookie domain attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.254 -0500", hash_original_method = "C7211512AD90131E871DA498CB7C5AD4", hash_generated_method = "DA584F5F25762FF40F97F84C56ADD308")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (origin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        }
        String host = origin.getHost().toLowerCase(Locale.ENGLISH);
        String cookieDomain = cookie.getDomain();

        // The effective host name MUST domain-match the Domain
        // attribute of the cookie.
        if (!domainMatch(host, cookieDomain)) {
            return false;
        }
        // effective host name minus domain must not contain any dots
        String effectiveHostWithoutDomain = host.substring(
                0, host.length() - cookieDomain.length());
        return effectiveHostWithoutDomain.indexOf('.') == -1;
    }
    
}

