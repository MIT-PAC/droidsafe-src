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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpDelete.java $
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

/**
 * HTTP DELETE method
 * <p>
 * The HTTP DELETE method is defined in section 9.7 of
 * <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC2616</a>:
 * <blockquote>
 * The DELETE method requests that the origin server delete the resource
 * identified by the Request-URI. [...] The client cannot
 * be guaranteed that the operation has been carried out, even if the
 * status code returned from the origin server indicates that the action
 * has been completed successfully.
 * </blockquote>
 */
public class HttpDelete extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.833 -0400", hash_original_field = "1CF2942FB34F296F1C5557DDAB001C87", hash_generated_field = "B4A707997AB4E24A05C2365E26E61658")


    public final static String METHOD_NAME = "DELETE";

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.834 -0400", hash_original_method = "03D79BD5005C5037DBBB6BDBAF22A396", hash_generated_method = "45CD5CA75FABFCC27A52913A7849E76C")
    
public HttpDelete() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.835 -0400", hash_original_method = "B059D8891D2B6D66F6F737D0CA1836E9", hash_generated_method = "4870EE5C426F0C664E2AD8A91FC263ED")
    
public HttpDelete(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.835 -0400", hash_original_method = "CC54B4FE9B32472727F7FD8626A59374", hash_generated_method = "6EB48B06F6BFF7E9A7E9ECEA2CF4F363")
    
public HttpDelete(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.836 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }

}
