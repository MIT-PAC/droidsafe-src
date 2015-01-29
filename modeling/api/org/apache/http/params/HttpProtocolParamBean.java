/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/params/HttpProtocolParamBean.java $
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
import org.apache.http.HttpVersion;

public class HttpProtocolParamBean extends HttpAbstractParamBean {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.381 -0400", hash_original_method = "58C7F9CABACF5B3A97B3D33439356421", hash_generated_method = "F5544FC06536D545686AF63E403D3362")
    
public HttpProtocolParamBean (final HttpParams params) {
        super(params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.382 -0400", hash_original_method = "B011C2B17042756AA341BB5B64FAAC49", hash_generated_method = "D959ACD1BF6DA73DEC30C88B453AC693")
    
public void setHttpElementCharset (final String httpElementCharset) {
        HttpProtocolParams.setHttpElementCharset(params, httpElementCharset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.384 -0400", hash_original_method = "F72CD4C1FDBC12234687CD67CE32BC77", hash_generated_method = "78E1645A9B747A6DDF17D53DE6CE2AE5")
    
public void setContentCharset (final String contentCharset) {
        HttpProtocolParams.setContentCharset(params, contentCharset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.385 -0400", hash_original_method = "3ABFC5D93813B92020A5498A011E2268", hash_generated_method = "2D5F493E126CE6E7778F8B08279AE7EE")
    
public void setVersion (final HttpVersion version) {
        HttpProtocolParams.setVersion(params, version);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.386 -0400", hash_original_method = "9D7423EEF1A77C7426DADEA61CF69BA6", hash_generated_method = "5AE17D5F447DA7B023745D0D319586F4")
    
public void setUserAgent (final String userAgent) {
        HttpProtocolParams.setUserAgent(params, userAgent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.387 -0400", hash_original_method = "99A8A3606B8C5D6C5386D32698634F98", hash_generated_method = "CCA35EDDC446E903679F16DCBC763136")
    
public void setUseExpectContinue (boolean useExpectContinue) {
        HttpProtocolParams.setUseExpectContinue(params, useExpectContinue);
    }
    
}
