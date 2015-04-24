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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/HttpVersion.java $
 * $Revision: 609106 $
 * $Date: 2008-01-05 01:15:42 -0800 (Sat, 05 Jan 2008) $
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


package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;




public final class HttpVersion extends ProtocolVersion implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.464 -0500", hash_original_field = "01F148CBDB86DDF387E346F2838AA78F", hash_generated_field = "4AA18FBAD714C83CF6883EBA6D23F39C")


    private static final long serialVersionUID = -5856653513894415344L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.467 -0500", hash_original_field = "A408819B2827C93EEEA90464C629D6B2", hash_generated_field = "BD0B770B1DA58B440FD2A9FDBB7EFD6F")

    public static final String HTTP = "HTTP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.469 -0500", hash_original_field = "2D524F7E6D361C466BBEF889DEF44936", hash_generated_field = "F13F8B26DBE79268EEE81DDB7ABECF4F")

    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.473 -0500", hash_original_field = "9C89AA70F9ED76719651C26F0C166D0F", hash_generated_field = "16A7185B0988E5CE22D3E365290FDDBF")

    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.475 -0500", hash_original_field = "DE14E2C4CC0480E1DE36B655FBF6D442", hash_generated_field = "E158A70472CF43C3AF1C153DDD6B4EF4")

    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);  

    
    /**
     * Create an HTTP protocol version designator.
     *
     * @param major   the major version number of the HTTP protocol
     * @param minor   the minor version number of the HTTP protocol
     * 
     * @throws IllegalArgumentException if either major or minor version number is negative
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.478 -0500", hash_original_method = "150D62CB24782FBFD68E18019E7202DB", hash_generated_method = "01059C04D62A95D12C039037E6C7745F")
    
public HttpVersion(int major, int minor) {
        super(HTTP, major, minor);
    }


    /**
     * Obtains a specific HTTP version.
     *
     * @param major     the major version
     * @param minor     the minor version
     *
     * @return  an instance of {@link HttpVersion} with the argument version
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.480 -0500", hash_original_method = "102B5DD63D8812CA09E006716DE254FA", hash_generated_method = "8F6F3C9693BC4D9B4767F4CC00A265E3")
    
public ProtocolVersion forVersion(int major, int minor) {

        if ((major == this.major) && (minor == this.minor)) {
            return this;
        }

        if (major == 1) {
            if (minor == 0) {
                return HTTP_1_0;
            }
            if (minor == 1) {
                return HTTP_1_1;
            }
        }
        if ((major == 0) && (minor == 9)) {
            return HTTP_0_9;
        }

        // argument checking is done in the constructor
        return new HttpVersion(major, minor);
    }
}

