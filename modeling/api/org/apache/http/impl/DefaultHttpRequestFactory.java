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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/DefaultHttpRequestFactory.java $
 * $Revision: 618367 $
 * $Date: 2008-02-04 10:26:06 -0800 (Mon, 04 Feb 2008) $
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


package org.apache.http.impl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.RequestLine;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.apache.http.message.BasicHttpRequest;

/**
 * Default implementation of a factory for creating request objects.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 618367 $
 * 
 * @since 4.0
 */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.486 -0400", hash_original_field = "155AFEABBD34F5FA746AE00B4AE30C7E", hash_generated_field = "69CE6FA8131D26E434BD11A5F1534A70")

    
    private static final String[] RFC2616_COMMON_METHODS = {
        "GET"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.486 -0400", hash_original_field = "4EEEE53F82B8B392C295A07C08111D60", hash_generated_field = "777A988A2C2A80FC49EAB03FE198BB25")

    
    private static final String[] RFC2616_ENTITY_ENC_METHODS = {
        "POST",
        "PUT"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.487 -0400", hash_original_field = "3A0A345A44F0A1F4FB4650D060E78439", hash_generated_field = "AE089264EAAB880552639753D1EBC682")


    private static final String[] RFC2616_SPECIAL_METHODS = {
        "HEAD",
        "OPTIONS",
        "DELETE",
        "TRACE"
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.488 -0400", hash_original_method = "C66A4C0F1AEBE26D1166356C8E2531F9", hash_generated_method = "2FE06563F1CD16499EB8BD46195A9B4C")
    
private static boolean isOneOf(final String[] methods, final String method) {
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].equalsIgnoreCase(method)) {
                return true;
            }
        }
        return false;
    }
    
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.487 -0400", hash_original_method = "FFBA7A94A9174CA6D30BD277D8D34B09", hash_generated_method = "DB62D1004E25D453D114BFD7031BC62A")
    
public DefaultHttpRequestFactory() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.488 -0400", hash_original_method = "4F6BA9DBF7A328097644920BC93D32B9", hash_generated_method = "194BA164741B6614EBA8BB4FA95DAE9B")
    
public HttpRequest newHttpRequest(final RequestLine requestline)
            throws MethodNotSupportedException {
        if (requestline == null) {
            throw new IllegalArgumentException("Request line may not be null");
        }
        String method = requestline.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(requestline); 
        } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(requestline); 
        } else if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(requestline); 
        } else { 
            throw new MethodNotSupportedException(method +  " method not supported");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:43.489 -0400", hash_original_method = "42571F4638E6827FB3A9DCCC38F6D4A6", hash_generated_method = "C8CEE34737C100AE80EC557A2886272E")
    
public HttpRequest newHttpRequest(final String method, final String uri)
            throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(method, uri); 
        } else if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(method, uri); 
        } else if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(method, uri); 
        } else {
            throw new MethodNotSupportedException(method
                    + " method not supported");
        }
    }
    
}
