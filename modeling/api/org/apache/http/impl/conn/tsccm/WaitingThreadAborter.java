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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/WaitingThreadAborter.java $
 * $Revision: 649220 $
 * $Date: 2008-04-17 11:40:24 -0700 (Thu, 17 Apr 2008) $
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

public class WaitingThreadAborter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.342 -0500", hash_original_field = "F1A0AC4A2E7C774F3DAB11506EBBCA82", hash_generated_field = "C79D835D74C6AC2AE8A11E51B7EFA777")
    
    private WaitingThread waitingThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.344 -0500", hash_original_field = "D257EA6B1465C401242DE11DC61376AA", hash_generated_field = "7C8E769DDEE22768B70313CCC815CA01")

    private boolean aborted;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.510 -0400", hash_original_method = "41E9B73CB6D6B9988302B233DF5A4C64", hash_generated_method = "41E9B73CB6D6B9988302B233DF5A4C64")
    public WaitingThreadAborter ()
    {
        //Synthesized constructor
    }
    
    /**
     * If a waiting thread has been set, interrupts it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.346 -0500", hash_original_method = "27CF8733634F3CF20401DD1AFEAA91BD", hash_generated_method = "2BA036273BDA7B336FEB03EC4E817398")
    
public void abort() {
        aborted = true;
        
        if (waitingThread != null)
            waitingThread.interrupt();
        
    }
    
    /**
     * Sets the waiting thread.  If this has already been aborted,
     * the waiting thread is immediately interrupted.
     * 
     * @param waitingThread The thread to interrupt when aborting.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.349 -0500", hash_original_method = "BEF4BF67B8CAA8FFE4DAC439C25D6987", hash_generated_method = "C403637F10DB97F52E9C5FCC4872655C")
    
public void setWaitingThread(WaitingThread waitingThread) {
        this.waitingThread = waitingThread;
        if (aborted)
            waitingThread.interrupt();
    }
    
}

