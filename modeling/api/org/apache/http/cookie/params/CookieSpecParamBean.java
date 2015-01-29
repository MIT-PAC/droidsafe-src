/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/cookie/params/CookieSpecParamBean.java $
 * $Revision: 632313 $
 * $Date: 2008-02-29 05:19:50 -0800 (Fri, 29 Feb 2008) $
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

package org.apache.http.cookie.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Collection;

import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

public class CookieSpecParamBean extends HttpAbstractParamBean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.171 -0400", hash_original_method = "167782F8CA9816413AFA8A6A56B73124", hash_generated_method = "B1D9A90FE7C1788EF58143055173C3A2")
    
public CookieSpecParamBean (final HttpParams params) {
        super(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.173 -0400", hash_original_method = "F9E6FF32373B54A53A0A1DFC7335EA2C", hash_generated_method = "9488C274BF0B1B3ADD81A3CF0C71CA8C")
    
public void setDatePatterns (final Collection <String> patterns) {
        params.setParameter(CookieSpecPNames.DATE_PATTERNS, patterns);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.175 -0400", hash_original_method = "5ADE5EE0B0D98008EAD057E1437239C3", hash_generated_method = "B2CCE9A4DAB493F4163310BCE7B59455")
    
public void setSingleHeader (final boolean singleHeader) {
        params.setBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, singleHeader);
    }
    
}
