/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/BasicEofSensorWatcher.java $
 * $Revision $
 * $Date: 2008-06-27 12:49:20 -0700 (Fri, 27 Jun 2008) $
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

package org.apache.http.conn;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.InputStream;
import java.io.IOException;


/**
 * Basic implementation of {@link EofSensorWatcher EofSensorWatcher}.
 * The underlying connection is released on close or EOF.
 *
 * @author <a href="mailto:rolandw at apache.org">Roland Weber</a>
 *
 *
 * <!-- empty lines to avoid svn diff problems -->
 * @version $Revision: 672367 $
 *
 * @since 4.0
 */
public class BasicEofSensorWatcher implements EofSensorWatcher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.005 -0400", hash_original_field = "ECC1A1A1F3BB31DE20717F98D44EFC60", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.006 -0400", hash_original_field = "F6FDC975DEEC1249FFD0EA5446B40A56", hash_generated_field = "E3C3E883F50FA4994DDE044495909683")

    protected boolean attemptReuse;



    /**
     * Creates a new watcher for auto-releasing a connection.
     *
     * @param conn      the connection to auto-release
     * @param reuse     whether the connection should be re-used
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.008 -0400", hash_original_method = "F543AA1F4DBF00D18D9D4D2FDBFC9A99", hash_generated_method = "F7FA3A6330E39A2196CD6D9D6EE4D179")
    
public BasicEofSensorWatcher(ManagedClientConnection conn,
                                 boolean reuse) {
        if (conn == null)
            throw new IllegalArgumentException
                ("Connection may not be null.");

        managedConn = conn;
        attemptReuse = reuse;
    }


    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.010 -0400", hash_original_method = "1908450CB7EB4800763A1A3CE7DF28F7", hash_generated_method = "F04790F061B0614B402DD064B1AA2C62")
    
public boolean eofDetected(InputStream wrapped)
        throws IOException {

        try {
            if (attemptReuse) {
                // there may be some cleanup required, such as
                // reading trailers after the response body:
                wrapped.close();
                managedConn.markReusable();
            }
        } finally {
            managedConn.releaseConnection();
        }
        return false;
    }


    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.011 -0400", hash_original_method = "E048F4361D6D5EB777AA7B357DACDC43", hash_generated_method = "BFD5F5E3F71BF2D53D966C84F91BBFF1")
    
public boolean streamClosed(InputStream wrapped)
        throws IOException {

        try {
            if (attemptReuse) {
                // this assumes that closing the stream will
                // consume the remainder of the response body:
                wrapped.close();
                managedConn.markReusable();
            }
        } finally {
            managedConn.releaseConnection();
        }
        return false;
    }


    // non-javadoc, see interface EofSensorWatcher
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.012 -0400", hash_original_method = "EE13B8ADD712E865C9409E4044C71FDA", hash_generated_method = "41E4D481841F2F7696E281F5E132894D")
    
public boolean streamAbort(InputStream wrapped)
        throws IOException {

        managedConn.abortConnection();
        return false;
    }

} // class BasicEofSensorWatcher
