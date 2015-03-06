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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/message/BasicRequestLine.java $
 * $Revision: 604625 $
 * $Date: 2007-12-16 06:11:11 -0800 (Sun, 16 Dec 2007) $
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
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

public class BasicRequestLine implements RequestLine, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.760 -0500", hash_original_field = "13562D9F74FFA1CC7E8C143377A3FB6C", hash_generated_field = "FB524F3C45513827A3D0C2FF3CDC9338")

    private  ProtocolVersion protoversion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.762 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private  String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.765 -0500", hash_original_field = "EDEBE52DCF191A03299D02F6C51FE39B", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private  String uri;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.767 -0500", hash_original_method = "C975E0C09D0E2EF1EBE9CA9605A59CBA", hash_generated_method = "C1CE0317F0F4B1E0033EC310B4C00990")
    
public BasicRequestLine(final String method,
                            final String uri,
                            final ProtocolVersion version) {
        super();
        if (method == null) {
            throw new IllegalArgumentException
                ("Method must not be null.");
        }
        if (uri == null) {
            throw new IllegalArgumentException
                ("URI must not be null.");
        }
        if (version == null) {
            throw new IllegalArgumentException
                ("Protocol version must not be null.");
        }
        this.method = method;
        this.uri = uri;
        this.protoversion = version;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.770 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7472B5026828D1D5EB47237766CBDA14")
    
public String getMethod() {
        return this.method;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.772 -0500", hash_original_method = "96B8CBD1E6801618947DE1A14DEAA69F", hash_generated_method = "55024CD90D2ECAD5CDA12A5A8B3254BE")
    
public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.774 -0500", hash_original_method = "638E54DC35C58AE1ED57DF94E885B4C7", hash_generated_method = "8857A4DB81E344D0C9514C8654CCFB43")
    
public String getUri() {
        return this.uri;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.777 -0500", hash_original_method = "DE48B9AC65FB9CF013FEA7278BE0E864", hash_generated_method = "A51B2F4332CB3FF013F07CB238AFB447")
    
public String toString() {
        // no need for non-default formatting in toString()
        return BasicLineFormatter.DEFAULT
            .formatRequestLine(null, this).toString();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.782 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    
public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    
}

