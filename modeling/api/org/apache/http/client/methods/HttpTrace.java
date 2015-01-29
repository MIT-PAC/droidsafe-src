/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpTrace.java $
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

package org.apache.http.client.methods;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.net.URI;

/**
 * HTTP TRACE method.
 * <p>
 * The HTTP TRACE method is defined in section 9.6 of 
 * <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC2616</a>:
 * <blockquote>
 *  The TRACE method is used to invoke a remote, application-layer loop-
 *  back of the request message. The final recipient of the request
 *  SHOULD reflect the message received back to the client as the
 *  entity-body of a 200 (OK) response. The final recipient is either the
 *  origin server or the first proxy or gateway to receive a Max-Forwards
 *  value of zero (0) in the request (see section 14.31). A TRACE request
 *  MUST NOT include an entity.
 * </blockquote>
 * </p>
 * 
 * @version $Revision: 664505 $
 * 
 * @since 4.0
 */
public class HttpTrace extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.865 -0400", hash_original_field = "9689D919BA1C086E8D2D482CC8D45853", hash_generated_field = "72C6B9E7A9E64E3F2AA8F43271BF6B15")


    public final static String METHOD_NAME = "TRACE";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.866 -0400", hash_original_method = "5CE645EF4A22436A7DFF47B62B1809C7", hash_generated_method = "194415561DF692E925CA54A62D8704A2")
    
public HttpTrace() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.867 -0400", hash_original_method = "D526F3797988FF3FEF876F8D3E6EA9CE", hash_generated_method = "E8D29CD0BCE0EA1ECFBBA216A8AAB509")
    
public HttpTrace(final URI uri) {
        super();
        setURI(uri);
    }
    
    /**
     * @throws IllegalArgumentException if the uri is invalid. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.869 -0400", hash_original_method = "7DE0C01D7C44F20F64FD5306703602AF", hash_generated_method = "9021914DC8D9B5790CF7FD343013E794")
    
public HttpTrace(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:21.870 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
    
}
