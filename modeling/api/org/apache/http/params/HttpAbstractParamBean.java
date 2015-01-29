/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/HttpAbstractParamBean.java $
 * $Revision: 593937 $
 * $Date: 2007-11-11 10:44:12 -0800 (Sun, 11 Nov 2007) $
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

package org.apache.http.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract class HttpAbstractParamBean {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.643 -0400", hash_original_field = "E1952F00A693661EA0D1C7B3D836F77E", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    
    protected  HttpParams params;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:28.644 -0400", hash_original_method = "8327F19DC02DCF23EF3F2B7E95A3A579", hash_generated_method = "A98AC6431B5AADFD1265BD44F20E56E2")
    
public HttpAbstractParamBean (final HttpParams params) {
        if (params == null)
            throw new IllegalArgumentException("HTTP parameters may not be null");
        this.params = params;
    }
    
}
