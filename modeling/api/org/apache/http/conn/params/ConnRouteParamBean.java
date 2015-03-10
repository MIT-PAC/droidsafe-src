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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/params/ConnRouteParamBean.java $
 * $Revision: 652020 $
 * $Date: 2008-04-27 14:23:31 -0700 (Sun, 27 Apr 2008) $
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


package org.apache.http.conn.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.net.InetAddress;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpAbstractParamBean;
import org.apache.http.params.HttpParams;

/**
 * Allows for setting parameters relating to connection routes on
 * {@link HttpParams}.  This class ensures that the values set on the params
 * are type-safe. 
 */
public class ConnRouteParamBean extends HttpAbstractParamBean {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.155 -0400", hash_original_method = "1AEC2EFCE67FC98DFF86D08E7A2981A9", hash_generated_method = "8A5ADF4E9B51EA36A2B5BCAEF33A74E9")
    
public ConnRouteParamBean (final HttpParams params) {
        super(params);
    }

    /** @see ConnRoutePNames#DEFAULT_PROXY */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.156 -0400", hash_original_method = "2794EF67A332ABF7AE16BCAA2A8ED275", hash_generated_method = "6E6E6130F08730D316768294833A3AE2")
    
public void setDefaultProxy (final HttpHost defaultProxy) {
        params.setParameter(ConnRoutePNames.DEFAULT_PROXY, defaultProxy);
    }

    /** @see ConnRoutePNames#LOCAL_ADDRESS */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.157 -0400", hash_original_method = "6B78E8CA681F8C715EDCE3F8AEA12BF7", hash_generated_method = "6053BB2D189084D336472B898AD06076")
    
public void setLocalAddress (final InetAddress address) {
        params.setParameter(ConnRoutePNames.LOCAL_ADDRESS, address);
    }

    /** @see ConnRoutePNames#FORCED_ROUTE */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.158 -0400", hash_original_method = "3BB091625F222671A1EC9CF735182D41", hash_generated_method = "8A5880098986A6507E05C3308B181771")
    
public void setForcedRoute (final HttpRoute route) {
        params.setParameter(ConnRoutePNames.FORCED_ROUTE, route);
    }
    
}
