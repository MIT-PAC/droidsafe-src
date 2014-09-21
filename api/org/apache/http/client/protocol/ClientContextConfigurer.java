/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/protocol/ClientContextConfigurer.java $
 * $Revision: 654886 $
 * $Date: 2008-05-09 10:06:12 -0700 (Fri, 09 May 2008) $
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

package org.apache.http.client.protocol;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;

import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;

public class ClientContextConfigurer implements ClientContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.968 -0400", hash_original_field = "6F38A9A6A355A7E00FD5BA62150FB1E8", hash_generated_field = "243D12B8F3ED6AC0C831151E142E6CD4")

    
    private  HttpContext context;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.969 -0400", hash_original_method = "4712A08D6DDA2604DE13ADF5183EBCC2", hash_generated_method = "D71FF227F1E01FE22FD295F735C82B9A")
    
public ClientContextConfigurer (final HttpContext context) {
        if (context == null)
            throw new IllegalArgumentException("HTTP context may not be null");
        this.context = context;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.970 -0400", hash_original_method = "5C02B918A57083D6F5A955DF3D10B1DB", hash_generated_method = "68A73569D8568918C331EC5DFB81CD1F")
    
public void setCookieSpecRegistry(final CookieSpecRegistry registry) {
        this.context.setAttribute(COOKIESPEC_REGISTRY, registry);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.972 -0400", hash_original_method = "A88227DAFB99D4BC492A8CB533626848", hash_generated_method = "BC1CF57999B26712D6E95A4A4A912578")
    
public void setAuthSchemeRegistry(final AuthSchemeRegistry registry) {
        this.context.setAttribute(AUTHSCHEME_REGISTRY, registry);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.973 -0400", hash_original_method = "5A6A71895372866C0BAED4B3F3D2E1A8", hash_generated_method = "7DB26C3598E7F1D3AAA08FCA06076AB3")
    
public void setCookieStore(final CookieStore store) {
        this.context.setAttribute(COOKIE_STORE, store);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.974 -0400", hash_original_method = "0182D8CBD192E33A697D8A25BC9891BD", hash_generated_method = "D491F51522B49BEA71F395E14EF3B477")
    
public void setCredentialsProvider(final CredentialsProvider provider) {
        this.context.setAttribute(CREDS_PROVIDER, provider);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.975 -0400", hash_original_method = "53FACBD9A13032E4E4C0761E4BF7CAD7", hash_generated_method = "5D872FBA153D89B2E9B49E8A7867D46F")
    
public void setAuthSchemePref(final List<String> list) {
        this.context.setAttribute(AUTH_SCHEME_PREF, list);
    }

}
