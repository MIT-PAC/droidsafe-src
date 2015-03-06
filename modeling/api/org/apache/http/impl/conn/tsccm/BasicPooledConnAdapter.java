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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/tsccm/BasicPooledConnAdapter.java $
 * $Revision: 653214 $
 * $Date: 2008-05-04 07:12:13 -0700 (Sun, 04 May 2008) $
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
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.conn.AbstractPoolEntry;
import org.apache.http.impl.conn.AbstractPooledConnAdapter;

public class BasicPooledConnAdapter extends AbstractPooledConnAdapter {

    /**
     * Creates a new adapter.
     *
     * @param tsccm   the connection manager
     * @param entry   the pool entry for the connection being wrapped
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.692 -0500", hash_original_method = "4CDC3279EB2015FFF1E8970655E8006E", hash_generated_method = "E942CE3FCDFD5B8FC3A18A55AD7302D6")
    
protected BasicPooledConnAdapter(ThreadSafeClientConnManager tsccm,
                               AbstractPoolEntry entry) {
        super(tsccm, entry);
        markReusable();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.695 -0500", hash_original_method = "278454090484FFAE87CB0693EDFEAA11", hash_generated_method = "7BE0FC895E550BB5A0B6208CB68CD71D")
    
@Override
    protected ClientConnectionManager getManager() {
        // override needed only to make method visible in this package
        return super.getManager();
    }

    /**
     * Obtains the pool entry.
     *
     * @return  the pool entry, or <code>null</code> if detached
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.697 -0500", hash_original_method = "4F37F2CEFFC0BA6EAEA2353029E03EE6", hash_generated_method = "131C894029FFCDCBAFAF169DB22826D9")
    
protected AbstractPoolEntry getPoolEntry() {
        return super.poolEntry;
    }

    // non-javadoc, see base class
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:34.699 -0500", hash_original_method = "E23AB51D98F88854411B8A5D5ACA9D05", hash_generated_method = "E5A0A89C9C7CC29013B36BFA6AAB281F")
    
@Override
    protected void detach() {
        // override needed only to make method visible in this package
        super.detach();
    }
    
}

