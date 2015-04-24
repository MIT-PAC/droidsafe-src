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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/cookie/RFC2965VersionAttributeHandler.java $
 * $Revision: 590695 $
 * $Date: 2007-10-31 07:55:41 -0700 (Wed, 31 Oct 2007) $
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
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieAttributeHandler;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;
import org.apache.http.cookie.SetCookie2;

public class RFC2965VersionAttributeHandler implements CookieAttributeHandler {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.074 -0500", hash_original_method = "02086819EBBDDEB16B7B0CCCD949EDD6", hash_generated_method = "075DA2BCDF46547ECA372D2ADECFD138")
    
public RFC2965VersionAttributeHandler() {
        super();
    }
    
    /**
     * Parse cookie version attribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.076 -0500", hash_original_method = "0FDB9C61F8AE07052D8F8CD615F49E1D", hash_generated_method = "2493344E11F7398B57B9AAA7979140BA")
    
public void parse(final SetCookie cookie, final String value)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null) {
            throw new MalformedCookieException(
                    "Missing value for version attribute");
        }
        int version = -1;
        try {
            version = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            version = -1;
        }
        if (version < 0) {
            throw new MalformedCookieException("Invalid cookie version.");
        }
        cookie.setVersion(version);
    }

    /**
     * validate cookie version attribute. Version attribute is REQUIRED.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.079 -0500", hash_original_method = "918ECF249887C4F016B37391BBEA278F", hash_generated_method = "301F5C320490EF5686C8A09564CA9E06")
    
public void validate(final Cookie cookie, final CookieOrigin origin)
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (cookie instanceof SetCookie2) {
            if (cookie instanceof ClientCookie 
                    && !((ClientCookie) cookie).containsAttribute(ClientCookie.VERSION_ATTR)) {
                throw new MalformedCookieException(
                        "Violates RFC 2965. Version attribute is required.");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:37.081 -0500", hash_original_method = "768BC0018D608E66268B8C5C0AE76B3A", hash_generated_method = "D83CEB3751B5960131E4566E29C7FC53")
    
public boolean match(final Cookie cookie, final CookieOrigin origin) {
        return true;
    }
    
}

