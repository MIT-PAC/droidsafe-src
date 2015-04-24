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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/RouteSpecificPool.java $
 * $Revision: 677240 $
 * $Date: 2008-07-16 04:25:47 -0700 (Wed, 16 Jul 2008) $
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
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.util.LangUtils;

public class RouteSpecificPool {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.765 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.767 -0500", hash_original_field = "8824947D446181E666F5CCE159788709", hash_generated_field = "082455967E4D3C7BAE7FAA337B8F6279")

    protected  HttpRoute route;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.774 -0500", hash_original_field = "7CCA90D5ED70EFC6992F927A16D3D119", hash_generated_field = "B16B544ABBD3A4529A473E69C2437062")

    protected  int maxEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.777 -0500", hash_original_field = "999D1209C4CFC2454F7A66CCE817A937", hash_generated_field = "CCBF9696EA0BD792BC0BF375C338D5EA")

    protected  LinkedList<BasicPoolEntry> freeEntries;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.780 -0500", hash_original_field = "BDF0A61E4197385E0D2E24DFD51B36B8", hash_generated_field = "E267A7FAC4E8E5B414A36EEBC5A1B7B4")

    protected  Queue<WaitingThread> waitingThreads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.782 -0500", hash_original_field = "D022F7C15275DDDE8D834E3F1AE0531A", hash_generated_field = "E0B89688F125EDBE00AAE3D04B90A8C2")

    protected int numEntries;

    /**
     * Creates a new route-specific pool.
     *
     * @param route the route for which to pool
     * @param maxEntries the maximum number of entries allowed for this pool
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.785 -0500", hash_original_method = "CD96C9BBB654EF18C372B5A0EBA556A4", hash_generated_method = "A73B8541DE31A33ED9FC1F4ABEBF931E")
    
public RouteSpecificPool(HttpRoute route, int maxEntries) {
        this.route = route;
        this.maxEntries = maxEntries;
        this.freeEntries = new LinkedList<BasicPoolEntry>();
        this.waitingThreads = new LinkedList<WaitingThread>();
        this.numEntries = 0;
    }

    /**
     * Obtains the route for which this pool is specific.
     *
     * @return  the route
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.787 -0500", hash_original_method = "A51AC1237DD43D471744BBD4E881146C", hash_generated_method = "34C7DA051C58A0672C915D7D35F32FE9")
    
public final HttpRoute getRoute() {
        return route;
    }
    
    /**
     * Obtains the maximum number of entries allowed for this pool.
     *
     * @return  the max entry number
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.789 -0500", hash_original_method = "3F262A29EAD0FCC787330E9B7CECC306", hash_generated_method = "29982F68BA84381BBC4A777EF5615517")
    
public final int getMaxEntries() {
        return maxEntries;
    }
    
    /**
     * Indicates whether this pool is unused.
     * A pool is unused if there is neither an entry nor a waiting thread.
     * All entries count, not only the free but also the allocated ones.
     *
     * @return  <code>true</code> if this pool is unused,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.791 -0500", hash_original_method = "039A6CD61F0359B07E2C6E71E77BA3EE", hash_generated_method = "B0E5F09CC052C2167859B5F72C3B00F9")
    
public boolean isUnused() {
        return (numEntries < 1) && waitingThreads.isEmpty();
    }

    /**
     * Return remaining capacity of this pool
     * 
     * @return capacity
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.793 -0500", hash_original_method = "177416E45C86DBFDF7EC5AE9EA15CB02", hash_generated_method = "F0DFF1961BD32A1338C25D83E9AEA40C")
    
public int getCapacity() {
        return maxEntries - numEntries;
    }
    
    /**
     * Obtains the number of entries.
     * This includes not only the free entries, but also those that
     * have been created and are currently issued to an application.
     *
     * @return  the number of entries for the route of this pool
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.796 -0500", hash_original_method = "3C2F8D494E1F1F56A9CA8A3544522ED0", hash_generated_method = "832ACF3C58DED2CDE81F031A3C668545")
    
public final int getEntryCount() {
        return numEntries;
    }

    /**
     * Obtains a free entry from this pool, if one is available.
     *
     * @return an available pool entry, or <code>null</code> if there is none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.798 -0500", hash_original_method = "7F86BE46F7391BA2A7A5B9B0529BB73E", hash_generated_method = "C94EF398B26B265A9421D39EA14441C9")
    
public BasicPoolEntry allocEntry(final Object state) {
        if (!freeEntries.isEmpty()) {
            ListIterator<BasicPoolEntry> it = freeEntries.listIterator(freeEntries.size());
            while (it.hasPrevious()) {
                BasicPoolEntry entry = it.previous();
                if (LangUtils.equals(state, entry.getState())) {
                    it.remove();
                    return entry;
                }
            }
        }
        if (!freeEntries.isEmpty()) {
            BasicPoolEntry entry = freeEntries.remove();   
            entry.setState(null);
            OperatedClientConnection conn = entry.getConnection();
            try {
                conn.close();
            } catch (IOException ex) {
                log.debug("I/O error closing connection", ex);
            }
            return entry;
        }
        return null;
    }

    /**
     * Returns an allocated entry to this pool.
     *
     * @param entry     the entry obtained from {@link #allocEntry allocEntry}
     *                  or presented to {@link #createdEntry createdEntry}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.801 -0500", hash_original_method = "1F2F8066B3FF3FBE25C7998F0003547E", hash_generated_method = "DF38118D654870147DE2EFB32742E376")
    
public void freeEntry(BasicPoolEntry entry) {

        if (numEntries < 1) {
            throw new IllegalStateException
                ("No entry created for this pool. " + route);
        }
        if (numEntries <= freeEntries.size()) {
            throw new IllegalStateException
                ("No entry allocated from this pool. " + route);
        }
        freeEntries.add(entry);
    }

    /**
     * Indicates creation of an entry for this pool.
     * The entry will <i>not</i> be added to the list of free entries,
     * it is only recognized as belonging to this pool now. It can then
     * be passed to {@link #freeEntry freeEntry}.
     *
     * @param entry     the entry that was created for this pool
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.803 -0500", hash_original_method = "89E23A0834C1E349262FA5BF4999548A", hash_generated_method = "CEA2E02AEEA8EB93611BDF62DDA11907")
    
public void createdEntry(BasicPoolEntry entry) {

        if (!route.equals(entry.getPlannedRoute())) {
            throw new IllegalArgumentException
                ("Entry not planned for this pool." +
                 "\npool: " + route +
                 "\nplan: " + entry.getPlannedRoute());
        }

        numEntries++;
    }

    /**
     * Deletes an entry from this pool.
     * Only entries that are currently free in this pool can be deleted.
     * Allocated entries can not be deleted.
     *
     * @param entry     the entry to delete from this pool
     *
     * @return  <code>true</code> if the entry was found and deleted, or
     *          <code>false</code> if the entry was not found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.806 -0500", hash_original_method = "77FA36706319170F1442C426C0507BB4", hash_generated_method = "1CB38EB5AED1A18DF23CAF51879B8B68")
    
public boolean deleteEntry(BasicPoolEntry entry) {

        final boolean found = freeEntries.remove(entry);
        if (found)
            numEntries--;
        return found;
    }

    /**
     * Forgets about an entry from this pool.
     * This method is used to indicate that an entry
     * {@link #allocEntry allocated}
     * from this pool has been lost and will not be returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.808 -0500", hash_original_method = "E1123D840A968B4EB04AEFB90EABFC3B", hash_generated_method = "6E0E0B27EE18F3AA747F34A40FB342FD")
    
public void dropEntry() {
        if (numEntries < 1) {
            throw new IllegalStateException
                ("There is no entry that could be dropped.");
        }
        numEntries--;
    }

    /**
     * Adds a waiting thread.
     * This pool makes no attempt to match waiting threads with pool entries.
     * It is the caller's responsibility to check that there is no entry
     * before adding a waiting thread.
     *
     * @param wt        the waiting thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.810 -0500", hash_original_method = "5F9CEBE3D4D005B8F7D968A4703E6CB7", hash_generated_method = "FC0E2F7D719C81ACB77FB17655FB5789")
    
public void queueThread(WaitingThread wt) {
        if (wt == null) {
            throw new IllegalArgumentException
                ("Waiting thread must not be null.");
        }
        this.waitingThreads.add(wt);
    }

    /**
     * Checks whether there is a waiting thread in this pool.
     *
     * @return  <code>true</code> if there is a waiting thread,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.812 -0500", hash_original_method = "C6B8ECCB9FBEF4C7E1D5D0DF0E82610C", hash_generated_method = "ABA6ECAD9458CDC7CAA93DA9AC75DEA5")
    
public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    /**
     * Returns the next thread in the queue.
     *
     * @return  a waiting thread, or <code>null</code> if there is none
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.814 -0500", hash_original_method = "AB0F908D6786932ABD8D14E657997D12", hash_generated_method = "FC19AAF618DB17FDDA3CD8A5BD924F10")
    
public WaitingThread nextThread() {
        return this.waitingThreads.peek();
    }

    /**
     * Removes a waiting thread, if it is queued.
     *
     * @param wt        the waiting thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.816 -0500", hash_original_method = "E4B9C02A964F427588494E2D80051654", hash_generated_method = "F4CF70BBF2317907ED04AB7E23356B39")
    
public void removeThread(WaitingThread wt) {
        if (wt == null)
            return;

        this.waitingThreads.remove(wt);
    }
    
}

