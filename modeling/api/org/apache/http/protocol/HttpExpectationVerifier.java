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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/HttpExpectationVerifier.java $
 * $Revision: 613298 $
 * $Date: 2008-01-18 14:09:22 -0800 (Fri, 18 Jan 2008) $
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

/**
 * Defines an interface to verify whether an incoming HTTP request meets 
 * the target server's expectations. 
 *<p>
 * The Expect request-header field is used to indicate that particular
 * server behaviors are required by the client.
 *</p>
 *<pre>
 *    Expect       =  "Expect" ":" 1#expectation
 *
 *    expectation  =  "100-continue" | expectation-extension
 *    expectation-extension =  token [ "=" ( token | quoted-string )
 *                             *expect-params ]
 *    expect-params =  ";" token [ "=" ( token | quoted-string ) ]
 *</pre>
 *<p>
 * A server that does not understand or is unable to comply with any of
 * the expectation values in the Expect field of a request MUST respond
 * with appropriate error status. The server MUST respond with a 417
 * (Expectation Failed) status if any of the expectations cannot be met
 * or, if there are other problems with the request, some other 4xx
 * status.
 *</p>
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 613298 $
 * 
 * @since 4.0
 */
public interface HttpExpectationVerifier {

    void verify(HttpRequest request, HttpResponse response, HttpContext context)
            throws HttpException;
    
}
