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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/BasicHttpContext.java $
 * $Revision: 654882 $
 * $Date: 2008-05-09 09:58:59 -0700 (Fri, 09 May 2008) $
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


package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpContext implements HttpContext {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.448 -0500", hash_original_field = "AE9AEAD8987EA62C0A77312800FC6E06", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")
    
    private  HttpContext parentContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.450 -0500", hash_original_field = "CBF5F9A9A24239AF2E2DA4DE606EC2D7", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSComment("edits networking object")
    @DSSpec(DSCat.NETWORKING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.453 -0500", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "12A7496AFEC164E290DB967A345FD4D7")
    
public BasicHttpContext() {
        this(null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.455 -0500", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "DA55BE8CFECDFAA75EFE22E59F427E43")
    
public BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.458 -0500", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "DAC84FC07D0A474AF9D1588FD5723CE3")
    
public Object getAttribute(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        Object obj = null;
        if (this.map != null) {
            obj = this.map.get(id);
        }
        if (obj == null && this.parentContext != null) {
            obj = this.parentContext.getAttribute(id);
        }
        return obj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.460 -0500", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "E65B164F0E43B1CB569F163EC1B26840")
    
public void setAttribute(final String id, final Object obj) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(id, obj);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:46.463 -0500", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "12C51558FEC591831921FA9B2649D535")
    
public Object removeAttribute(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id may not be null");
        }
        if (this.map != null) {
            return this.map.remove(id);
        } else {
            return null;
        }
    }
    
}

