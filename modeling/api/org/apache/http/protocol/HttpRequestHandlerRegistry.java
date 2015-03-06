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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/HttpRequestHandlerRegistry.java $
 * $Revision: 630662 $
 * $Date: 2008-02-24 11:40:51 -0800 (Sun, 24 Feb 2008) $
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
import java.util.Map;

/**
 * Maintains a map of HTTP request handlers keyed by a request URI pattern.
 * {@link HttpRequestHandler} instances can be looked up by request URI
 * using the {@link HttpRequestHandlerResolver} interface.<br/>
 * Patterns may have three formats:
 * <ul>
 *   <li><code>*</code></li>
 *   <li><code>*&lt;uri&gt;</code></li>
 *   <li><code>&lt;uri&gt;*</code></li>
 * </ul>
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 630662 $
 */
public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.518 -0400", hash_original_field = "15D8ACBE43D316AFFD774A07FBD4B061", hash_generated_field = "773B6EA638EE079E5A049A79FE1376AE")


    private  UriPatternMatcher matcher;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.519 -0400", hash_original_method = "0B425D4D0EFCD13FABC1DA3947BA125B", hash_generated_method = "C28AC51C98844F49180349A8E8973CF5")
    
public HttpRequestHandlerRegistry() {
        matcher = new UriPatternMatcher();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.520 -0400", hash_original_method = "40C76FC864CBA38FAA0E34DAA3309CB0", hash_generated_method = "DEA601CA5F753572824EF219384E4AB6")
    
public void register(final String pattern, final HttpRequestHandler handler) {
        matcher.register(pattern, handler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.520 -0400", hash_original_method = "85C722127436F22D8FCD42D335EE7904", hash_generated_method = "D004671FAEE8F8B56046EA11DE0A74FE")
    
public void unregister(final String pattern) {
        matcher.unregister(pattern);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.521 -0400", hash_original_method = "2AF598C4CBCFC975EFB08A02F0C19B15", hash_generated_method = "F896F11DC18ECEB2D2F80511C2CF07A1")
    
public void setHandlers(final Map map) {
        matcher.setHandlers(map);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.521 -0400", hash_original_method = "87912491840643F75CD4F2795905D82A", hash_generated_method = "613B458192E1FADB4377C3BCB29A0CA0")
    
public HttpRequestHandler lookup(final String requestURI) {
        return (HttpRequestHandler) matcher.lookup(requestURI);
    }

    /**
     * @deprecated use {@link UriPatternMatcher} directly
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.522 -0400", hash_original_method = "428DD8E5E4B76033CB415788A6F7FEEE", hash_generated_method = "74B338536E9A8BCDB8C9CC784EE026D9")
    
@Deprecated
    protected boolean matchUriRequestPattern(final String pattern, final String requestUri) {
        return matcher.matchUriRequestPattern(pattern, requestUri);
    }

}
