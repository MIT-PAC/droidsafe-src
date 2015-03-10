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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/RefQueueWorker.java $
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
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RefQueueWorker implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.624 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.626 -0500", hash_original_field = "AF3F1BF62DD67A6204D4B99C3928DDE7", hash_generated_field = "40049CCA20E99139643BCB7890F78F90")

    protected  ReferenceQueue<?> refQueue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.628 -0500", hash_original_field = "C4D17D8E20F898203F5288742532355E", hash_generated_field = "7ABFD2CF4B63269B45DD287A5590324B")

    protected  RefQueueHandler refHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.631 -0500", hash_original_field = "E9FF103FC0FAC4762B85597770D9D323", hash_generated_field = "AD9424F71A9D950798ECA942D1D55E60")

    protected volatile Thread workerThread;

    /**
     * Instantiates a new worker to listen for lost connections.
     *
     * @param queue     the queue on which to wait for references
     * @param handler   the handler to pass the references to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.633 -0500", hash_original_method = "7CE59BC66C958C608E20B1EEC430162A", hash_generated_method = "CA85AE20212AFCDAED1E94900A261A2A")
    
public RefQueueWorker(ReferenceQueue<?> queue, RefQueueHandler handler) {
        if (queue == null) {
            throw new IllegalArgumentException("Queue must not be null.");
        }
        if (handler == null) {
            throw new IllegalArgumentException("Handler must not be null.");
        }

        refQueue   = queue;
        refHandler = handler;
    }

    /**
     * The main loop of this worker.
     * If initialization succeeds, this method will only return
     * after {@link #shutdown shutdown()}. Only one thread can
     * execute the main loop at any time.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.635 -0500", hash_original_method = "068901515EDCF67E719CCEED21C02CEA", hash_generated_method = "3D8D6E0C0D5DD7B4890A87101CA0C31F")
    
public void run() {

        if (this.workerThread == null) {
            this.workerThread = Thread.currentThread();
        }

        while (this.workerThread == Thread.currentThread()) {
            try {
                // remove the next reference and process it
                Reference<?> ref = refQueue.remove();
                refHandler.handleReference(ref);
            } catch (InterruptedException e) {
                //@@@ is logging really necessary? this here is the
                //@@@ only reason for having a log in this class
                if (log.isDebugEnabled()) {
                    log.debug(this.toString() + " interrupted", e);
                }
            }
        }
    }

    /**
     * Shuts down this worker.
     * It can be re-started afterwards by another call to {@link #run run()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.637 -0500", hash_original_method = "4BBB4A6394E78355577BCA1899518AA3", hash_generated_method = "6CE48C3E51E997E0D335B5113DBA95F1")
    
public void shutdown() {
        Thread wt = this.workerThread;
        if (wt != null) {
            this.workerThread = null; // indicate shutdown
            wt.interrupt();
        }
    }

    /**
     * Obtains a description of this worker.
     *
     * @return  a descriptive string for this worker
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.640 -0500", hash_original_method = "7EB957F4647F2E9AB09EE1A296B7BEEF", hash_generated_method = "4C820E660A2767B76BC387A5AB9B43EE")
    
@Override
    public String toString() {
        return "RefQueueWorker::" + this.workerThread;
    }
    
}

