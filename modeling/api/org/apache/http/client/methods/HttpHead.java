/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/methods/HttpHead.java $
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
 * HTTP HEAD method.
 * <p>
 * The HTTP HEAD method is defined in section 9.4 of 
 * <a href="http://www.ietf.org/rfc/rfc2616.txt">RFC2616</a>:
 * <blockquote>
 * The HEAD method is identical to GET except that the server MUST NOT
 * return a message-body in the response. The metainformation contained
 * in the HTTP headers in response to a HEAD request SHOULD be identical
 * to the information sent in response to a GET request. This method can
 * be used for obtaining metainformation about the entity implied by the
 * request without transferring the entity-body itself. This method is
 * often used for testing hypertext links for validity, accessibility,
 * and recent modification.
 * </blockquote>
 * </p>
 *
 * @version $Revision: 664505 $
 * 
 * @since 4.0
 */
public class HttpHead extends HttpRequestBase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.626 -0400", hash_original_field = "BCF9F9143992ED6BD0A180F33A9CDD01", hash_generated_field = "B852C5619D6489CDBA1416AE6488A528")


    public final static String METHOD_NAME = "HEAD";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.626 -0400", hash_original_method = "7AE3C3BCBFB95C4A873D97A4D653939C", hash_generated_method = "1B39800CC6E8E090392FDE46496FC170")
    
public HttpHead() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.627 -0400", hash_original_method = "B5E291CA739E8A630085E019A4DAC34B", hash_generated_method = "0BBDF6BA61E1731F4FA95B36CAE408E1")
    
public HttpHead(final URI uri) {
        super();
        setURI(uri);
    }

    /**
     * @throws IllegalArgumentException if the uri is invalid. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.627 -0400", hash_original_method = "FF3B9045EACA657FA87C0A39D45E9C30", hash_generated_method = "05C0A22609E0D6ED57CCE596F3D7E6BC")
    
public HttpHead(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:29.628 -0400", hash_original_method = "E4A43B2F65721A683997A037549396C3", hash_generated_method = "5FCF2FB47A767785DCEA247A24F7E8BC")
    
@Override
    public String getMethod() {
        return METHOD_NAME;
    }
    
}
