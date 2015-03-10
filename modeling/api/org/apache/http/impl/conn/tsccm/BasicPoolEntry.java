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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/BasicPoolEntry.java $
 * $Revision: 652721 $
 * $Date: 2008-05-01 17:32:20 -0700 (Thu, 01 May 2008) $
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
import java.lang.ref.ReferenceQueue;

import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.AbstractPoolEntry;

public class BasicPoolEntry extends AbstractPoolEntry {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.127 -0500", hash_original_field = "E2AE6E9BDF0D1D36130AD506D608303E", hash_generated_field = "E34C8060B8024F897E4DE2DDC540C297")

    private  BasicPoolEntryRef reference;

    /**
     * Creates a new pool entry.
     *
     * @param op      the connection operator
     * @param route   the planned route for the connection
     * @param queue   the reference queue for tracking GC of this entry,
     *                or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.129 -0500", hash_original_method = "9CCB47DAF369299C60002AA9C328CEC6", hash_generated_method = "69726288CF275F5FB44F90DC86D658A5")
    
public BasicPoolEntry(ClientConnectionOperator op,
                          HttpRoute route,
                          ReferenceQueue<Object> queue) {
        super(op, route);
        if (route == null) {
            throw new IllegalArgumentException("HTTP route may not be null");
        }
        this.reference = new BasicPoolEntryRef(this, queue);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.132 -0500", hash_original_method = "833089AC155D5F0DD92B0C74A18F2763", hash_generated_method = "6DBABF868B1BA6B5FD49B300E658EAE5")
    
protected final OperatedClientConnection getConnection() {
        return super.connection;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.134 -0500", hash_original_method = "F928965F3078B3981FAC8F2BBDABCB11", hash_generated_method = "C2309A7A1D8F39717D367E98C52327E4")
    
protected final HttpRoute getPlannedRoute() {
        return super.route;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.136 -0500", hash_original_method = "A5F0662ECC443ACB4B44B4D02A3B5BBC", hash_generated_method = "BAFA0E95FBDC82B5121042D0E44E757B")
    
protected final BasicPoolEntryRef getWeakRef() {
        return this.reference;
    }
    
}

