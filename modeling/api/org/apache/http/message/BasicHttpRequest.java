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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/message/BasicHttpRequest.java $
 * $Revision: 573864 $
 * $Date: 2007-09-08 08:53:25 -0700 (Sat, 08 Sep 2007) $
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


package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.params.HttpProtocolParams;

public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.543 -0500", hash_original_field = "BB7A5ADC85895E8229C34E0A6FE732F6", hash_generated_field = "1A948EEF4738D8B68129911C16DED26C")
    
    private  RequestLine requestline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.546 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private  String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.549 -0500", hash_original_field = "EDEBE52DCF191A03299D02F6C51FE39B", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private  String uri;
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.552 -0500", hash_original_method = "D336B902E966467A394D4F5E82995C23", hash_generated_method = "E5A9BDAAC5E7D027DBBA71615ACA6A1B")
    
public BasicHttpRequest(final String method, final String uri) {
        super();
        if (method == null) {
            throw new IllegalArgumentException("Method name may not be null");
        }
        if (uri == null) {
            throw new IllegalArgumentException("Request URI may not be null");
        }
        this.method = method;
        this.uri = uri;
        this.requestline = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.555 -0500", hash_original_method = "32D970961D566BAF565D674274EE91DF", hash_generated_method = "CD839F8D2AE59D3E9A42445099A6994B")
    
public BasicHttpRequest(final String method, final String uri, final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.557 -0500", hash_original_method = "6934C052A0F550106B98ACB21507F0F6", hash_generated_method = "1498B1ADC9262FBA213A6CB02876A3A2")
    
public BasicHttpRequest(final RequestLine requestline) {
        super();
        if (requestline == null) {
            throw new IllegalArgumentException("Request line may not be null");
        }
        this.requestline = requestline;
        this.method = requestline.getMethod();
        this.uri = requestline.getUri();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.560 -0500", hash_original_method = "6D74E90047F33871E1F46E26807064EE", hash_generated_method = "A8CF03EA6002AD71099B37468C7ADB19")
    
public ProtocolVersion getProtocolVersion() {
        if (this.requestline != null) {
            return this.requestline.getProtocolVersion();
        } else {
            return HttpProtocolParams.getVersion(getParams());
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.563 -0500", hash_original_method = "C42D62E680F5FCF6E09789DDCB998F05", hash_generated_method = "B9BB611E2F486CBE5BAF525A101C1752")
    
public RequestLine getRequestLine() {
        if (this.requestline != null) {
            return this.requestline;
        } else {
            ProtocolVersion ver = HttpProtocolParams.getVersion(getParams());
            return new BasicRequestLine(this.method, this.uri, ver);
        }
    }
    
}

