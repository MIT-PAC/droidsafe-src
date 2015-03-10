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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpGet.java $
 * $Revision: 664505 $
 * $Date: 2008-06-08 06:21:20 -0700 (Sun, 08 Jun 2008) $
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


package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.net.URI;

@DSVAModeled
public class HttpGet extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.038 -0500", hash_original_field = "FAA38044AD16F915890905B63FBBCA42", hash_generated_field = "BCFE29A06D4EB94143E09A5AED669A6C")

    public final static String METHOD_NAME = "GET";
    
    @DSVAModeled
    private URI theURI;
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.040 -0500", hash_original_method = "5037302FD966B72BDD781660024EF657", hash_generated_method = "0C8D3574F60C84033C0278476E55ECDE")
    
public HttpGet() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.043 -0500", hash_original_method = "31474A7F59CE66F27E23571A1F0DC0EA", hash_generated_method = "746BE47C6BCD631FEA7CF15494CB8B2C")
    @DSSafe(DSCat.DATA_STRUCTURE)
public HttpGet(final URI uri) {
        super();
        setURI(uri);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:33.426 -0400", hash_original_method = "DACE54F54F01CEE5FF3D25626E7EEBF2", hash_generated_method = "18E73CB6390DC2C709D6D3975107CA40")
    @DSSafe(DSCat.DATA_STRUCTURE)
    public  HttpGet(final String uri) {
        super();
        addTaint(uri.getTaint());
        try {
            setURI(new URI(uri));
        } catch (Exception e) {
            
        }
        // ---------- Original Method ----------
        //setURI(URI.create(uri));
    }
    
    public void setURI(final URI uri) {
        this.theURI = uri;
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    public URI getURI() {
        return this.theURI;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.048 -0500", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
}

