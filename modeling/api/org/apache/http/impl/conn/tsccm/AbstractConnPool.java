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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/AbstractConnPool.java $
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


package org.apache.http.impl.conn.tsccm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.IdleConnectionHandler;

public abstract class AbstractConnPool implements RefQueueHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.193 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.196 -0500", hash_original_field = "BD228968E2BFC0FF16EFA26B0026E962", hash_generated_field = "89BB43C794864E61314387B43B6FF59C")

    protected  Lock poolLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.198 -0500", hash_original_field = "02FF0515B148763072D746F66CE0655C", hash_generated_field = "A0FE2E9181E5A1497BEE93B62E29B3A1")

    protected Set<BasicPoolEntryRef> issuedConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.200 -0500", hash_original_field = "BF30BE0135BA282A7827B02FF018C8ED", hash_generated_field = "55EE522AC0C1CB0DA5968035C4BCC85D")

    protected IdleConnectionHandler idleConnHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.202 -0500", hash_original_field = "FC47E4AD0671BE6A24FCFD8E55426B1E", hash_generated_field = "329E7708843E3730009ED3B91C5F4D39")

    protected int numConnections;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.204 -0500", hash_original_field = "7DAB12BFD26E59D90D3C34132A5D7875", hash_generated_field = "60A7C2B675EA491A9BF5C18637CD724D")

    protected ReferenceQueue<Object> refQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.206 -0500", hash_original_field = "1041FBFF2CFBE250FB9D6B60CE11AD02", hash_generated_field = "E5D3DE402E8B1BA965AA00AC6191EDD8")

    private RefQueueWorker refWorker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.209 -0500", hash_original_field = "C61B3BDAAF84DD1FE911E77E1145E9CF", hash_generated_field = "F15F5E1E3CD7B6799921EE9E4A605FC3")

    protected volatile boolean isShutDown;

    /**
     * Creates a new connection pool.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.212 -0500", hash_original_method = "51DB8B1C7B1E70F4AD996E9EEB946CC0", hash_generated_method = "484A456A735BACED6F55D250DDE9F844")
    
protected AbstractConnPool() {
        issuedConnections = new HashSet<BasicPoolEntryRef>();
        idleConnHandler = new IdleConnectionHandler();

        boolean fair = false; //@@@ check parameters to decide
        poolLock = new ReentrantLock(fair);
    }

    /**
     * Enables connection garbage collection (GC).
     * This method must be called immediately after creating the
     * connection pool. It is not possible to enable connection GC
     * after pool entries have been created. Neither is it possible
     * to disable connection GC.
     *
     * @throws IllegalStateException
     *         if connection GC is already enabled, or if it cannot be
     *         enabled because there already are pool entries
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.214 -0500", hash_original_method = "68FD2DF4471AB38D5F7B2F768AE2EB0E", hash_generated_method = "29A53B043898E174F2FDB0D00E568B37")
    
public void enableConnectionGC()
        throws IllegalStateException {

        if (refQueue != null) {
            throw new IllegalStateException("Connection GC already enabled.");
        }
        poolLock.lock();
        try {
            if (numConnections > 0) { //@@@ is this check sufficient?
                throw new IllegalStateException("Pool already in use.");
            }
        } finally {
            poolLock.unlock();
        }

        refQueue  = new ReferenceQueue<Object>();
        refWorker = new RefQueueWorker(refQueue, this);
        Thread t = new Thread(refWorker); //@@@ use a thread factory
        t.setDaemon(true);
        t.setName("RefQueueWorker@" + this);
        t.start();
    }

    /**
     * Obtains a pool entry with a connection within the given timeout.
     *
     * @param route     the route for which to get the connection
     * @param timeout   the timeout, 0 or negative for no timeout
     * @param tunit     the unit for the <code>timeout</code>,
     *                  may be <code>null</code> only if there is no timeout
     *
     * @return  pool entry holding a connection for the route
     *
     * @throws ConnectionPoolTimeoutException
     *         if the timeout expired
     * @throws InterruptedException
     *         if the calling thread was interrupted
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.217 -0500", hash_original_method = "0742A6A1F2B8CF3FE44B75781825E20C", hash_generated_method = "7A9300082717AC1F8ACEB82037F3311E")
    
public final
        BasicPoolEntry getEntry(
                HttpRoute route, 
                Object state,
                long timeout, 
                TimeUnit tunit)
                    throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(route, state).getPoolEntry(timeout, tunit);
    }
    
    /**
     * Returns a new {@link PoolEntryRequest}, from which a {@link BasicPoolEntry}
     * can be obtained, or the request can be aborted.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.219 -0500", hash_original_method = "4C1A8087D76E51A267FB8C95EE16029B", hash_generated_method = "184E51382C38F1B7B0EE9D2E7BF8B1F6")
    
public abstract PoolEntryRequest requestPoolEntry(HttpRoute route, Object state);

    /**
     * Returns an entry into the pool.
     * The connection of the entry is expected to be in a suitable state,
     * either open and re-usable, or closed. The pool will not make any
     * attempt to determine whether it can be re-used or not.
     *
     * @param entry     the entry for the connection to release
     * @param reusable  <code>true</code> if the entry is deemed 
     *                  reusable, <code>false</code> otherwise.
     * @param validDuration The duration that the entry should remain free and reusable.
     * @param timeUnit The unit of time the duration is measured in.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.221 -0500", hash_original_method = "70C11B1DB13C02F46A7F0C16FC313271", hash_generated_method = "EFC5EC6B219100A61DD283E986AF08F9")
    
public abstract void freeEntry(BasicPoolEntry entry, boolean reusable, long validDuration, TimeUnit timeUnit)
        ;

    // non-javadoc, see interface RefQueueHandler
// BEGIN android-changed
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.224 -0500", hash_original_method = "005D09627953355817D3D23BD1B8063B", hash_generated_method = "95D0088A563E1C35132FDD79865B71EC")
    
public void handleReference(Reference ref) {
// END android-changed
        poolLock.lock();
        try {

            if (ref instanceof BasicPoolEntryRef) {
                // check if the GCed pool entry was still in use
                //@@@ find a way to detect this without lookup
                //@@@ flag in the BasicPoolEntryRef, to be reset when freed?
                final boolean lost = issuedConnections.remove(ref);
                if (lost) {
                    final HttpRoute route =
                        ((BasicPoolEntryRef)ref).getRoute();
                    if (log.isDebugEnabled()) {
                        log.debug("Connection garbage collected. " + route);
                    }
                    handleLostEntry(route);
                }
            }

        } finally {
            poolLock.unlock();
        }
    }

    /**
     * Handles cleaning up for a lost pool entry with the given route.
     * A lost pool entry corresponds to a connection that was
     * garbage collected instead of being properly released.
     *
     * @param route     the route of the pool entry that was lost
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.227 -0500", hash_original_method = "9972DFCB84008C041CDFC4D571B43DEE", hash_generated_method = "63DB68700ECADFDD0EF657F8E82E2A76")
    
protected abstract void handleLostEntry(HttpRoute route)
        ;

    /**
     * Closes idle connections.
     *
     * @param idletime  the time the connections should have been idle
     *                  in order to be closed now
     * @param tunit     the unit for the <code>idletime</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.229 -0500", hash_original_method = "B6A3F225A0D4D9B69A4C0D73B6FA8390", hash_generated_method = "2346D982A56FAD963B19CDF1D5B2DCB1")
    
public void closeIdleConnections(long idletime, TimeUnit tunit) {

        // idletime can be 0 or negative, no problem there
        if (tunit == null) {
            throw new IllegalArgumentException("Time unit must not be null.");
        }

        poolLock.lock();
        try {
            idleConnHandler.closeIdleConnections(tunit.toMillis(idletime));
        } finally {
            poolLock.unlock();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.232 -0500", hash_original_method = "9DA7FEECE19DD407DF46C6AFBD499B72", hash_generated_method = "F5443628C3E6EFD78F9B328370F5570B")
    
public void closeExpiredConnections() {
        poolLock.lock();
        try {
            idleConnHandler.closeExpiredConnections();
        } finally {
            poolLock.unlock();
        }
    }
        
    //@@@ revise this cleanup stuff (closeIdle+deleteClosed), it's not good

    /**
     * Deletes all entries for closed connections.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.234 -0500", hash_original_method = "3CE795F167F9259979B508D0B805A2F6", hash_generated_method = "60FDBB0426DED33426B062C3E2C8C421")
    
public abstract void deleteClosedConnections()
        ;

    /**
     * Shuts down this pool and all associated resources.
     * Overriding methods MUST call the implementation here!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.236 -0500", hash_original_method = "74B1E1F35A0ABEB335D073A37540DF82", hash_generated_method = "509813191DDD69B66276D4CB8D0D9B62")
    
public void shutdown() {

        poolLock.lock();
        try {

            if (isShutDown)
                return;

            // no point in monitoring GC anymore
            if (refWorker != null)
                refWorker.shutdown();

            // close all connections that are issued to an application
            Iterator<BasicPoolEntryRef> iter = issuedConnections.iterator();
            while (iter.hasNext()) {
                BasicPoolEntryRef per = iter.next();
                iter.remove();
                BasicPoolEntry entry = per.get();
                if (entry != null) {
                    closeConnection(entry.getConnection());
                }
            }

            // remove all references to connections
            //@@@ use this for shutting them down instead?
            idleConnHandler.removeAll();

            isShutDown = true;

        } finally {
            poolLock.unlock();
        }
    }

    /**
     * Closes a connection from this pool.
     *
     * @param conn      the connection to close, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.239 -0500", hash_original_method = "88CD04F545A262F2432C3D0F1CF09056", hash_generated_method = "D426022BE78AB0A516F549EF9926ADB1")
    
protected void closeConnection(final OperatedClientConnection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (IOException ex) {
                log.debug("I/O error closing connection", ex);
            }
        }
    }
    
}

