/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/params/ConnManagerParamBean.java $
 * $Revision: 658781 $
 * $Date: 2008-05-21 10:42:13 -0700 (Wed, 21 May 2008) $
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

package org.apache.http.conn.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/**
 * Allows for setting parameters relating to connection managers on
 * {@link HttpParams}.  This class ensures that the values set on the params
 * are type-safe. 
 */
public class ConnManagerParamBean extends HttpAbstractParamBean {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.087 -0400", hash_original_method = "8A7A5EC8808F74979669A54AAE301BD8", hash_generated_method = "D2960C18043C4A371FEB18F7DB473159")
    
public ConnManagerParamBean (final HttpParams params) {
        super(params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.088 -0400", hash_original_method = "B87D39E165267BE09846FDFF9903FA2E", hash_generated_method = "06D0B89F2963C8D0FBAE3F0C2F63DABA")
    
public void setTimeout (final long timeout) {
        params.setLongParameter(ConnManagerPNames.TIMEOUT, timeout);
    }

    /** @see ConnManagerPNames#MAX_TOTAL_CONNECTIONS */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.090 -0400", hash_original_method = "0D60F9B7DEA0EDE36AA3E910DF4BA639", hash_generated_method = "4287754D46E2E18473F066242CD5839F")
    
public void setMaxTotalConnections (final int maxConnections) {
        params.setIntParameter(ConnManagerPNames.MAX_TOTAL_CONNECTIONS, maxConnections);
    }
    
    /** @see ConnManagerPNames#MAX_CONNECTIONS_PER_ROUTE */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.091 -0400", hash_original_method = "E9D05D41B064E61013063C5B1C4550BC", hash_generated_method = "CD91B2F4227DE10F3B2A43C7539C105A")
    
public void setConnectionsPerRoute(final ConnPerRouteBean connPerRoute) {
        params.setParameter(ConnManagerPNames.MAX_CONNECTIONS_PER_ROUTE, connPerRoute);
    }

}
