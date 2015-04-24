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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/params/ConnRouteParams.java $
 * $Revision: 658785 $
 * $Date: 2008-05-21 10:47:40 -0700 (Wed, 21 May 2008) $
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.conn.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.InetAddress;

import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;

public class ConnRouteParams implements ConnRoutePNames {

    /**
     * Obtains the {@link ConnRoutePNames#DEFAULT_PROXY DEFAULT_PROXY}
     * parameter value.
     * {@link #NO_HOST} will be mapped to <code>null</code>,
     * to allow unsetting in a hierarchy.
     *
     * @param params    the parameters in which to look up
     *
     * @return  the default proxy set in the argument parameters, or
     *          <code>null</code> if not set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.396 -0500", hash_original_method = "E75D121FDB3E170AE23E7EDECAF29000", hash_generated_method = "2285199BA93C1A8FCE16B62C1DB51DBB")
    
public static HttpHost getDefaultProxy(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        HttpHost proxy = (HttpHost)
            params.getParameter(DEFAULT_PROXY);
        if ((proxy != null) && NO_HOST.equals(proxy)) {
            // value is explicitly unset
            proxy = null;
        }
        return proxy;
    }

    /**
     * Sets the {@link ConnRoutePNames#DEFAULT_PROXY DEFAULT_PROXY}
     * parameter value.
     *
     * @param params    the parameters in which to set the value
     * @param proxy     the value to set, may be <code>null</code>.
     *                  Note that {@link #NO_HOST} will be mapped to
     *                  <code>null</code> by {@link #getDefaultProxy},
     *                  to allow for explicit unsetting in hierarchies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.399 -0500", hash_original_method = "49317954D5EBD5F28B2656B10CFB38A3", hash_generated_method = "81B11DD955AF9B9880F88DC4851DCDC3")
    
public static void setDefaultProxy(HttpParams params,
                                             HttpHost proxy) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(DEFAULT_PROXY, proxy);
    }

    /**
     * Obtains the {@link ConnRoutePNames#FORCED_ROUTE FORCED_ROUTE}
     * parameter value.
     * {@link #NO_ROUTE} will be mapped to <code>null</code>,
     * to allow unsetting in a hierarchy.
     *
     * @param params    the parameters in which to look up
     *
     * @return  the forced route set in the argument parameters, or
     *          <code>null</code> if not set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.401 -0500", hash_original_method = "5DAC36E561A1B4897EACF2D00E5FE007", hash_generated_method = "7287A29AD6F21E390C22B9647437B0C5")
    
public static HttpRoute getForcedRoute(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        HttpRoute route = (HttpRoute)
            params.getParameter(FORCED_ROUTE);
        if ((route != null) && NO_ROUTE.equals(route)) {
            // value is explicitly unset
            route = null;
        }
        return route;
    }

    /**
     * Sets the {@link ConnRoutePNames#FORCED_ROUTE FORCED_ROUTE}
     * parameter value.
     *
     * @param params    the parameters in which to set the value
     * @param route     the value to set, may be <code>null</code>.
     *                  Note that {@link #NO_ROUTE} will be mapped to
     *                  <code>null</code> by {@link #getForcedRoute},
     *                  to allow for explicit unsetting in hierarchies.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.405 -0500", hash_original_method = "07DB9F0458B5079746CBE9BE59C5E99C", hash_generated_method = "835399968526A6E79409D748AB4D1B44")
    
public static void setForcedRoute(HttpParams params,
                                            HttpRoute route) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(FORCED_ROUTE, route);
    }

    /**
     * Obtains the {@link ConnRoutePNames#LOCAL_ADDRESS LOCAL_ADDRESS}
     * parameter value.
     * There is no special value that would automatically be mapped to
     * <code>null</code>. You can use the wildcard address (0.0.0.0 for IPv4,
     * :: for IPv6) to override a specific local address in a hierarchy.
     *
     * @param params    the parameters in which to look up
     *
     * @return  the local address set in the argument parameters, or
     *          <code>null</code> if not set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.408 -0500", hash_original_method = "34B1651D44BDD2A6852C4B7591C5FF46", hash_generated_method = "C5700D76F513F5FBA42726FCEC28F83B")
    
public static InetAddress getLocalAddress(HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        InetAddress local = (InetAddress)
            params.getParameter(LOCAL_ADDRESS);
        // no explicit unsetting
        return local;
    }

    /**
     * Sets the {@link ConnRoutePNames#LOCAL_ADDRESS LOCAL_ADDRESS}
     * parameter value.
     *
     * @param params    the parameters in which to set the value
     * @param local     the value to set, may be <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.412 -0500", hash_original_method = "DD9D8CA6968C4F4E34A4098B9D14DC8D", hash_generated_method = "87730081EB8B7527793B3AB51E2E539E")
    
public static void setLocalAddress(HttpParams params,
                                             InetAddress local) {
        if (params == null) {
            throw new IllegalArgumentException("Parameters must not be null.");
        }
        params.setParameter(LOCAL_ADDRESS, local);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.388 -0500", hash_original_field = "6E1BC6DD450B3EFB2F846587AA84B117", hash_generated_field = "FAE323EF23E9AD73D7AF5D28E86E6ED7")

    public static final HttpHost NO_HOST =
        new HttpHost("127.0.0.255", 0, "no-host");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.391 -0500", hash_original_field = "2C7F2094748B6CA054A1E6E8226B6E9C", hash_generated_field = "21C3B0F0B6993EB3CF4E0DF755BE9E2A")

    public static final HttpRoute NO_ROUTE = new HttpRoute(NO_HOST);

    /** Disabled default constructor. */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:28.394 -0500", hash_original_method = "2F583F6C69B80DBD9155194B569BE764", hash_generated_method = "04E64CF0AA4E52F9C34273875D7B7927")
    
private ConnRouteParams() {
        // no body
    }
}

