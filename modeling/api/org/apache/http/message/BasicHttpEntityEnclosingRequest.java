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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/message/BasicHttpEntityEnclosingRequest.java $
 * $Revision: 618017 $
 * $Date: 2008-02-03 08:42:22 -0800 (Sun, 03 Feb 2008) $
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
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.protocol.HTTP;

public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.132 -0500", hash_original_field = "84BEE3610D6DA557FD534AD24775E93F", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")
    
    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.135 -0500", hash_original_method = "3B9AEA8ADDBEE1D3D457706DB0027555", hash_generated_method = "869E502C9963B3F827FA872F7F3C4CD8")
    
public BasicHttpEntityEnclosingRequest(final String method, final String uri) {
        super(method, uri);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.138 -0500", hash_original_method = "81663ABF166B6EF77CF828F0FBB9FCD0", hash_generated_method = "D3C930EB45D595B30DC5B64D88C841FF")
    
public BasicHttpEntityEnclosingRequest(final String method, final String uri, 
            final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.142 -0500", hash_original_method = "411AD89842852D4D934BE04E93AC495C", hash_generated_method = "20C3F1A1E8B84983C1941564A9A0CF43")
    
public BasicHttpEntityEnclosingRequest(final RequestLine requestline) {
        super(requestline);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.145 -0500", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "F26E442D152B9CF496C6F072484628AD")
    
public HttpEntity getEntity() {
        return this.entity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.147 -0500", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "79AAFF6E92B5322E414271D0A9826A70")
    @DSSink(DSSinkKind.NETWORK)
public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:50.150 -0500", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "EC2F72FE5FD316F8F025D2DEB714BBEF")
    
public boolean expectContinue() {
        Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }
    
}

