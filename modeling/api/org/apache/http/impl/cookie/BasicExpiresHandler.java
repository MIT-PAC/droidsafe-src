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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/cookie/BasicExpiresHandler.java $
 * $Revision: 558519 $
 * $Date: 2007-07-22 11:19:49 -0700 (Sun, 22 Jul 2007) $
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
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SetCookie;




public class BasicExpiresHandler extends AbstractCookieAttributeHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.271 -0500", hash_original_field = "6ECCC683F151EE6CE57F2B5BB3F18FF6", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private  String[] datepatterns;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.274 -0500", hash_original_method = "E41CF253A9B9B5C6E744E06930B5B074", hash_generated_method = "EDA042B785A8AEB93E0BAB8B54D8755C")
    
public BasicExpiresHandler(final String[] datepatterns) {
        if (datepatterns == null) {
            throw new IllegalArgumentException("Array of date patterns may not be null");
        }
        this.datepatterns = datepatterns;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:38.276 -0500", hash_original_method = "E5515B48EDFE7B38CBDC32E74DAEC7F0", hash_generated_method = "38AA8BDA8DA76992E7E05D996072BEDE")
    
public void parse(final SetCookie cookie, final String value) 
            throws MalformedCookieException {
        if (cookie == null) {
            throw new IllegalArgumentException("Cookie may not be null");
        }
        if (value == null) {
            throw new MalformedCookieException("Missing value for expires attribute");
        }
        try {
            cookie.setExpiryDate(DateUtils.parseDate(value, this.datepatterns));
        } catch (DateParseException dpe) {
            throw new MalformedCookieException("Unable to parse expires attribute: " 
                + value);
        }
    }

    
}

