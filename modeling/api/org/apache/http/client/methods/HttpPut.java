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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpPut.java $
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
 * HTTP PUT method.
 * <p>
 * The HTTP PUT method is defined in section 9.6 of 
 * <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC2616</a>:
 * <blockquote>
 * The PUT method requests that the enclosed entity be stored under the
 * supplied Request-URI. If the Request-URI refers to an already
 * existing resource, the enclosed entity SHOULD be considered as a
 * modified version of the one residing on the origin server. 
 * </blockquote>
 * </p>
 *
 * @version $Revision: 664505 $
 * 
 * @since 4.0
 */
public class HttpPut extends HttpEntityEnclosingRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.899 -0400", hash_original_field = "F8A071128A852910CC092901F490F21A", hash_generated_field = "AEC26F5B08B9E4BFC9F74F1640AEBC7A")


    public final static String METHOD_NAME = "PUT";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.900 -0400", hash_original_method = "65FB3303ECDDCEBD83FCF8D28C73B48C", hash_generated_method = "B6936B287DE893937A8BA4FEDE41642D")
    
public HttpPut() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.900 -0400", hash_original_method = "934B5D460EE581BAC848BBB0C7AFCA8A", hash_generated_method = "32516FF7BBD5E9D0CFB90973691EE3B9")
    
public HttpPut(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.901 -0400", hash_original_method = "DA22494FB03D014DC10C335662BC42E0", hash_generated_method = "250DB8805CE84AE860B72098182A7C6F")
    
public HttpPut(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.901 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
    
}
