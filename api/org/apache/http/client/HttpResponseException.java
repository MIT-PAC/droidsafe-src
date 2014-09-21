/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/client/HttpResponseException.java $
 * $Revision: 672425 $
 * $Date: 2008-06-27 16:33:05 -0700 (Fri, 27 Jun 2008) $
 *
 * ====================================================================
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.client;

/**
 * Signals a non 2xx HTTP response.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class HttpResponseException extends ClientProtocolException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:30.571 -0400", hash_original_field = "A760B8BDAE612093D0B796BF7FA7209C", hash_generated_field = "87BB67E37DADA1C43C717CC168BF2E18")

    
    private static final long serialVersionUID = -7186627969477257933L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:30.572 -0400", hash_original_field = "7D58E974091311E54CFA3738B5F585EF", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")


    private  int statusCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:30.573 -0400", hash_original_method = "3482E56A00F89E434F895E48781D8AC0", hash_generated_method = "A107D4BC90C63567A013D9A0F9261669")
    
public HttpResponseException(int statusCode, final String s) {
        super(s);
        this.statusCode = statusCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:30.574 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "5DD64D66E1754A99091F8C05EA6F76CC")
    
public int getStatusCode() {
        return this.statusCode;
    }
    
}
