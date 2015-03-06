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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/params/AuthParams.java $
 * $Revision: 618365 $
 * $Date: 2008-02-04 10:20:08 -0800 (Mon, 04 Feb 2008) $
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


package org.apache.http.auth.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

public final class AuthParams {

    /**
     * Obtains the charset for encoding
     * {@link org.apache.http.auth.Credentials}.
     * If not configured,
     * {@link HTTP#DEFAULT_PROTOCOL_CHARSET HTTP.DEFAULT_PROTOCOL_CHARSET}
     * is used instead.
     * 
     * @return The charset
     *
     * @see AuthPNames#CREDENTIAL_CHARSET
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.227 -0500", hash_original_method = "83E68A1F7212025E177C44461A8681BF", hash_generated_method = "81D4B84D1CADC581B696FD91EF64DC1F")
    
public static String getCredentialCharset(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        String charset = (String) params.getParameter
            (AuthPNames.CREDENTIAL_CHARSET);
        //@@@ TODO: inconsistent with JavaDoc in AuthPNames,
        //@@@ TODO: check HTTP_ELEMENT_CHARSET first, or fix JavaDocs
        if (charset == null) {
            charset = HTTP.DEFAULT_PROTOCOL_CHARSET;
        }
        return charset;
    }

    /**
     * Sets the charset to be used when encoding
     * {@link org.apache.http.auth.Credentials}.
     * 
     * @param charset The charset
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.229 -0500", hash_original_method = "0A1029E7DE52A3D6B1434265A979992C", hash_generated_method = "898E77E22A3BF38038282A5B97758360")
    
public static void setCredentialCharset(final HttpParams params, final String charset) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setParameter(AuthPNames.CREDENTIAL_CHARSET, charset);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.224 -0500", hash_original_method = "EB9D982BD9B9623A4B896B6B8960ED16", hash_generated_method = "7F4E5802A312C1007D40C42C567D1ADC")
    
private AuthParams() {
        super();
    }
    
}

