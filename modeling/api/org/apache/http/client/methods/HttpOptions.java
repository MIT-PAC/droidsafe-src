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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpOptions.java $
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;

/**
 * HTTP OPTIONS method.
 * <p>
 * The HTTP OPTIONS method is defined in section 9.2 of 
 * <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC2616</a>:
 * <blockquote>
 *  The OPTIONS method represents a request for information about the
 *  communication options available on the request/response chain
 *  identified by the Request-URI. This method allows the client to
 *  determine the options and/or requirements associated with a resource,
 *  or the capabilities of a server, without implying a resource action
 *  or initiating a resource retrieval.
 * </blockquote>
 * </p>
 * 
 * @version $Revision: 664505 $
 * 
 * @since 4.0
 */
public class HttpOptions extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.840 -0400", hash_original_field = "BAA1D73F83207CFA11D315BF70F50424", hash_generated_field = "E4F5C6CAB6CBE1DDF516059C95CB726E")


    public final static String METHOD_NAME = "OPTIONS";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.842 -0400", hash_original_method = "491296DC5FAD60677B254ACCE592ED9F", hash_generated_method = "72E79B7235915A7E88A5184849D42F60")
    
public HttpOptions() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.843 -0400", hash_original_method = "16B6DB69B98537A1086B4DD3446D1D0D", hash_generated_method = "EFCC37AA380581ACFAEAB79FD2B63B4E")
    
public HttpOptions(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.844 -0400", hash_original_method = "EF23F7BB0052B341A75F0E82F9D797D4", hash_generated_method = "D153FFA109AAE4821A20937EF09E8592")
    
public HttpOptions(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.845 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.847 -0400", hash_original_method = "AC94060075C6FF6BA648508103F7E98C", hash_generated_method = "6FEB73F97B4A162EDB6A309E9D0DA124")
    
public Set<String> getAllowedMethods(final HttpResponse response) {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        
        HeaderIterator it = response.headerIterator("Allow");
        Set<String> methods = new HashSet<String>();
        while (it.hasNext()) {
            Header header = it.nextHeader();
            HeaderElement[] elements = header.getElements();
            for (HeaderElement element : elements) {
                methods.add(element.getName());
            }
        }
        return methods;
    }
    
}
