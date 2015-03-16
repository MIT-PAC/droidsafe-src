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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpPost.java $
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
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import java.net.*;

import droidsafe.runtime.*;
import java.net.URI;

public class HttpPost extends HttpEntityEnclosingRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.325 -0500", hash_original_field = "C6D1332D7E2FBBF1CFD284F30D60129A", hash_generated_field = "93D97E8CFD3DD4E05FB1997B1AF38224")

    public final static String METHOD_NAME = "POST";
    
    @DSVAModeled
    private URI theURI;

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.328 -0500", hash_original_method = "034A352FF9B05AAB848E440712ABE34B", hash_generated_method = "8731034ED4B7D7C5F2C0F73BBAB5A4A9")
    
public HttpPost() {
        super();
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.331 -0500", hash_original_method = "160A4A8C6AAC5C78A2F503FA797FE66F", hash_generated_method = "B46316C1B560DDE61F4B685238FCB29F")
    
public HttpPost(final URI uri) {
        super();
        setURI(uri);
    }
    
	@DSSafe(DSCat.SAFE_OTHERS)
    public HttpPost(final String uri) {
        super();
        try {
            setURI(new URI(uri));
        } catch (URISyntaxException e) {
            
        }
        addTaint(uri.getTaint());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.335 -0500", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }

    @DSSafe()
    @DSSink(DSSinkKind.NETWORK)
    public void setURI(final URI uri) {
        this.theURI = uri;
    }
    
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_OTHERS)
    public URI getURI() {
        return this.theURI;
    }

}

