/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/params/ConnPerRouteBean.java $
 * $Revision: 652947 $
 * $Date: 2008-05-02 16:15:40 -0700 (Fri, 02 May 2008) $
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

package org.apache.http.conn.params;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.conn.routing.HttpRoute;

/**
 * This class maintains a map of HTTP routes to maximum number of connections allowed 
 * for those routes. This class can be used by pooling 
 * {@link org.apache.http.conn.ClientConnectionManager connection managers} for 
 * a fine-grained control of connections on a per route basis. 
 * 
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 * 
 * @version $Revision: 652947 $
 * 
 * @since 4.0
 */
public final class ConnPerRouteBean implements ConnPerRoute {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.112 -0400", hash_original_field = "2CF747B884D5D17D7A96604ADFD75ABB", hash_generated_field = "00475B25526F9312DAE1EE3224F14272")

    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.114 -0400", hash_original_field = "CC6BCB8868DAA4A6C82713377156C716", hash_generated_field = "0806EEC8724A95C0B07E6AE8944A7F73")

    
    private  Map<HttpRoute, Integer> maxPerHostMap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.115 -0400", hash_original_field = "F64CCB323223E0B6FDCAA82BC0ADADF8", hash_generated_field = "BFD0CCFF042679B67CB807161D35F213")

    
    private int defaultMax;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.116 -0400", hash_original_method = "A8CD37A72EF9544FE7F0FE65C5D44127", hash_generated_method = "972576ABD26EC6E4128AE493B6EEFAFF")
    
public ConnPerRouteBean(int defaultMax) {
        super();
        this.maxPerHostMap = new HashMap<HttpRoute, Integer>();
        setDefaultMaxPerRoute(defaultMax);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.118 -0400", hash_original_method = "276A9406F631DFA19B974E58C8D781CA", hash_generated_method = "B647EFFC7A49F5205AF491D4EACBF07F")
    
public ConnPerRouteBean() {
        this(DEFAULT_MAX_CONNECTIONS_PER_ROUTE);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.119 -0400", hash_original_method = "C28FE1156D91883B642C4F5487FC263E", hash_generated_method = "9A7736CC18E17C64023842B0E7537E92")
    
public int getDefaultMax() {
        return this.defaultMax;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.120 -0400", hash_original_method = "A7B911399D61455E75355192C3077DF5", hash_generated_method = "DFC53649FF4736CC9069236AA7C5047E")
    
public void setDefaultMaxPerRoute(int max) {
        if (max < 1) {
            throw new IllegalArgumentException
                ("The maximum must be greater than 0.");
        }
        this.defaultMax = max;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.122 -0400", hash_original_method = "05A2919387325F6651E9A97C28799002", hash_generated_method = "591222D9523372C86818B9A207916186")
    
public void setMaxForRoute(final HttpRoute route, int max) {
        if (route == null) {
            throw new IllegalArgumentException
                ("HTTP route may not be null.");
        }
        if (max < 1) {
            throw new IllegalArgumentException
                ("The maximum must be greater than 0.");
        }
        this.maxPerHostMap.put(route, Integer.valueOf(max));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.123 -0400", hash_original_method = "8BCCA28E68C4349A39A5F16D95EAD42E", hash_generated_method = "ECCCE80B233330EC45AE9C8E224DDB8C")
    
public int getMaxForRoute(final HttpRoute route) {
        if (route == null) {
            throw new IllegalArgumentException
                ("HTTP route may not be null.");
        }
        Integer max = this.maxPerHostMap.get(route);
        if (max != null) {
            return max.intValue();
        } else {
            return this.defaultMax;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.124 -0400", hash_original_method = "A36F35874182718616C9EC16E2602628", hash_generated_method = "5F584FE6E1A831E0F236A26E778857F6")
    
public void setMaxForRoutes(final Map<HttpRoute, Integer> map) {
        if (map == null) {
            return;
        }
        this.maxPerHostMap.clear();
        this.maxPerHostMap.putAll(map);
    }
    
}
