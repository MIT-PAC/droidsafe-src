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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/params/ClientParamBean.java $
 * $Revision: 659595 $
 * $Date: 2008-05-23 09:47:14 -0700 (Fri, 23 May 2008) $
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


package org.apache.http.client.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Collection;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

public class ClientParamBean extends HttpAbstractParamBean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.904 -0400", hash_original_method = "67B71D0521F1F83A599686B468506532", hash_generated_method = "9F990B80D2B9CEA150AD3924706640A4")
    
public ClientParamBean (final HttpParams params) {
        super(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.906 -0400", hash_original_method = "04F478ED464B676C0528E3F136AFFCDF", hash_generated_method = "AB2477FAC2FA552DD6C17B461DFA06CD")
    
public void setConnectionManagerFactoryClassName (final String factory) {
        params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME, factory);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.907 -0400", hash_original_method = "BE99F8A74A99DA8D7D55662038A3332B", hash_generated_method = "C508E3FCE544D483B9DC9C7E30A04F2A")
    
public void setConnectionManagerFactory(ClientConnectionManagerFactory factory) {
        params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY, factory);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.908 -0400", hash_original_method = "F9ED6421486838F3446CDCA23919320A", hash_generated_method = "FFA4B8BEB02B14BAC8C0102B0547341F")
    
public void setHandleRedirects (final boolean handle) {
        params.setBooleanParameter(ClientPNames.HANDLE_REDIRECTS, handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.909 -0400", hash_original_method = "02625218840AE082D83C19AC7D7D28FD", hash_generated_method = "407B776838005F1E288490EDD27273FA")
    
public void setRejectRelativeRedirect (final boolean reject) {
        params.setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, reject);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.910 -0400", hash_original_method = "4EBBF97A816075C35F74E5C7445585A4", hash_generated_method = "513BBB9F9F40C5B51033D0846938D2EC")
    
public void setMaxRedirects (final int maxRedirects) {
        params.setIntParameter(ClientPNames.MAX_REDIRECTS, maxRedirects);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.912 -0400", hash_original_method = "9BA0D8E4D6455469A283A8E332208709", hash_generated_method = "4794FE0D45336C78E3D17BE7246A3C5C")
    
public void setAllowCircularRedirects (final boolean allow) {
        params.setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, allow);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.913 -0400", hash_original_method = "4F8CD67E74A0163533DD968A41295BA4", hash_generated_method = "890AEB2A2CBB2AA6F83887D314C5D64E")
    
public void setHandleAuthentication (final boolean handle) {
        params.setBooleanParameter(ClientPNames.HANDLE_AUTHENTICATION, handle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.914 -0400", hash_original_method = "E74E0EF32985D984B37CCDD85370E5D3", hash_generated_method = "AE916104D19621E1781FD0BA316E8A8A")
    
public void setCookiePolicy (final String policy) {
        params.setParameter(ClientPNames.COOKIE_POLICY, policy);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.915 -0400", hash_original_method = "177E95B49C3C177C156FBACA03E3535D", hash_generated_method = "B6AB26B2EA734FFCB26896619912C9C3")
    
public void setVirtualHost (final HttpHost host) {
        params.setParameter(ClientPNames.VIRTUAL_HOST, host);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.917 -0400", hash_original_method = "B52D1F4BE879A416648F9390A150DF99", hash_generated_method = "EF117099961CFEA80D214CBE1FAEF7ED")
    
public void setDefaultHeaders (final Collection <Header> headers) {
        params.setParameter(ClientPNames.DEFAULT_HEADERS, headers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.918 -0400", hash_original_method = "3ADF32EB1C78B42B467E990536094D00", hash_generated_method = "B59C3130F5E48102B2B6C415385E70D2")
    
public void setDefaultHost (final HttpHost host) {
        params.setParameter(ClientPNames.DEFAULT_HOST, host);
    }
    
}
