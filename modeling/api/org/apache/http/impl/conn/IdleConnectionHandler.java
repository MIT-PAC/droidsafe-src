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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/IdleConnectionHandler.java $
 * $Revision: 673450 $
 * $Date: 2008-07-02 10:35:05 -0700 (Wed, 02 Jul 2008) $
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


package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpConnection;

public class IdleConnectionHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.989 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.992 -0500", hash_original_field = "5A16A1D9253FD3EC2F774F243B01F532", hash_generated_field = "2F5EF38A07EA6A9636288F530673294A")

    private  Map<HttpConnection,TimeValues> connectionToTimes;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.994 -0500", hash_original_method = "3E916BA1101D3583C84AA90CF4FC67D4", hash_generated_method = "A9AAD52CD1E2DDD3F31EE212EFDACC40")
    
public IdleConnectionHandler() {
        super();
        connectionToTimes = new HashMap<HttpConnection,TimeValues>();
    }
    
    /**
     * Registers the given connection with this handler.  The connection will be held until 
     * {@link #remove} or {@link #closeIdleConnections} is called.
     * 
     * @param connection the connection to add
     * 
     * @see #remove
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.997 -0500", hash_original_method = "3D4804DC68DE62BE888340914D1164A1", hash_generated_method = "24F97BFD87C3C334E62698C68465E51A")
    
public void add(HttpConnection connection, long validDuration, TimeUnit unit) {
        
        Long timeAdded = Long.valueOf(System.currentTimeMillis());
        
        if (log.isDebugEnabled()) {
            log.debug("Adding connection at: " + timeAdded);
        }
        
        connectionToTimes.put(connection, new TimeValues(timeAdded, validDuration, unit));
    }
    
    /**
     * Removes the given connection from the list of connections to be closed when idle.
     * This will return true if the connection is still valid, and false
     * if the connection should be considered expired and not used.
     * 
     * @param connection
     * @return True if the connection is still valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.999 -0500", hash_original_method = "1D31D4C3FCFC5F71DF82BB85794AF70A", hash_generated_method = "EDDC5D76963B1276225BF29A01A54E44")
    
public boolean remove(HttpConnection connection) {
        TimeValues times = connectionToTimes.remove(connection);
        if(times == null) {
            log.warn("Removing a connection that never existed!");
            return true;
        } else {
            return System.currentTimeMillis() <= times.timeExpires;
        }
    }

    /**
     * Removes all connections referenced by this handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.002 -0500", hash_original_method = "7AF66332DEC016DA2AA9D0945D3022F8", hash_generated_method = "05D689D3D04565F34680EC799289CFC7")
    
public void removeAll() {
        this.connectionToTimes.clear();
    }
    
    /**
     * Closes connections that have been idle for at least the given amount of time.
     * 
     * @param idleTime the minimum idle time, in milliseconds, for connections to be closed
     */
    //@@@ add TimeUnit argument here?
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.004 -0500", hash_original_method = "1B5843932F53A941705DBD73966AF816", hash_generated_method = "863FDB4C491566D032833131B577C955")
    
public void closeIdleConnections(long idleTime) {
        
        // the latest time for which connections will be closed
        long idleTimeout = System.currentTimeMillis() - idleTime;

        if (log.isDebugEnabled()) {
            log.debug("Checking for connections, idleTimeout: "  + idleTimeout);
        }
        
        Iterator<HttpConnection> connectionIter =
            connectionToTimes.keySet().iterator();
        
        while (connectionIter.hasNext()) {
            HttpConnection conn = connectionIter.next();
            TimeValues times = connectionToTimes.get(conn);
            Long connectionTime = times.timeAdded;
            if (connectionTime.longValue() <= idleTimeout) {
                if (log.isDebugEnabled()) {
                    log.debug("Closing connection, connection time: "  + connectionTime);
                }
                connectionIter.remove();
                try {
                    conn.close();
                } catch (IOException ex) {
                    log.debug("I/O error closing connection", ex);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.008 -0500", hash_original_method = "1F224929907ADC4A2755470D6C0EBC61", hash_generated_method = "0B4C5F9F88954254E42F6C9DF984799D")
    
public void closeExpiredConnections() {
        long now = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug("Checking for expired connections, now: "  + now);
        }
        
        Iterator<HttpConnection> connectionIter =
            connectionToTimes.keySet().iterator();
        
        while (connectionIter.hasNext()) {
            HttpConnection conn = connectionIter.next();
            TimeValues times = connectionToTimes.get(conn);
            if(times.timeExpires <= now) {
                if (log.isDebugEnabled()) {
                    log.debug("Closing connection, expired @: "  + times.timeExpires);
                }
                connectionIter.remove();
                try {
                    conn.close();
                } catch (IOException ex) {
                    log.debug("I/O error closing connection", ex);
                }
            }
        }        
    }
    
    private static class TimeValues {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.011 -0500", hash_original_field = "BBD74564EFA9375FCDE743AD03A476CE", hash_generated_field = "40BAAF0C7A31F5A05875046903303AFA")

        private  long timeAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.013 -0500", hash_original_field = "20845878310D2108675058988FE13017", hash_generated_field = "AB9F405E92086F3B1BDE350A1E939FA3")

        private  long timeExpires;

        /**
         * @param now The current time in milliseconds
         * @param validDuration The duration this connection is valid for
         * @param validUnit The unit of time the duration is specified in.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.016 -0500", hash_original_method = "3DD4099178F08AFF793AFE03575649DF", hash_generated_method = "3DD4099178F08AFF793AFE03575649DF")
        
TimeValues(long now, long validDuration, TimeUnit validUnit) {
            this.timeAdded = now;
            if(validDuration > 0) {
                this.timeExpires = now + validUnit.toMillis(validDuration);
            } else {
                this.timeExpires = Long.MAX_VALUE;
            }
        }
        
    }
    
}

