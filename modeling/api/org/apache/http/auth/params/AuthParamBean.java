/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/auth/params/AuthParamBean.java $
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

package org.apache.http.auth.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

public class AuthParamBean extends HttpAbstractParamBean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.822 -0400", hash_original_method = "B4EA8E619DCA21FFA6CDBFD7F372604B", hash_generated_method = "0E596499CBAE8036C7B1E5C8CB6C799E")
    
public AuthParamBean (final HttpParams params) {
        super(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.823 -0400", hash_original_method = "8F36CE57796771346D862EE4A1C63EB4", hash_generated_method = "101E28D9FCE84B000CA3E4F4B4A652CF")
    
public void setCredentialCharset (final String charset) {
        AuthParams.setCredentialCharset(params, charset);
    }
    
}
