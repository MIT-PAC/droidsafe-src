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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/conn/DefaultClientConnectionOperator.java $
 * $Revision: 652193 $
 * $Date: 2008-04-29 17:10:36 -0700 (Tue, 29 Apr 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
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
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import org.apache.http.HttpHost;
import org.apache.http.conn.ClientConnectionOperator;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;






public class DefaultClientConnectionOperator implements ClientConnectionOperator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.424 -0500", hash_original_field = "016661333E85B4B0D4E37C42367B4F10", hash_generated_field = "117D19A17E0FA862F4540CD5E143142A")


    private static final PlainSocketFactory staticPlainSocketFactory = new PlainSocketFactory();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.427 -0500", hash_original_field = "FFCBB3FF9A8B5221F5621A7A590508B0", hash_generated_field = "262A27B6B6B1CBF25439CFECC3909997")

    protected SchemeRegistry schemeRegistry;


    /**
     * Creates a new client connection operator for the given scheme registry.
     *
     * @param schemes   the scheme registry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.429 -0500", hash_original_method = "564A7128C5B00F982644F6E1BD9B5118", hash_generated_method = "CA381C39136474BC252F3F016835318F")
    
public DefaultClientConnectionOperator(SchemeRegistry schemes) {
        if (schemes == null) {
            throw new IllegalArgumentException
                ("Scheme registry must not be null.");
        }
        schemeRegistry = schemes;
    }


    // non-javadoc, see interface ClientConnectionOperator
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.431 -0500", hash_original_method = "A7AF136A36340299371F158C25AED0D2", hash_generated_method = "58CEAAE32D1F5ECD407C9AC056AB72D6")
    
public OperatedClientConnection createConnection() {
        return new DefaultClientConnection();
    }


    // non-javadoc, see interface ClientConnectionOperator
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.435 -0500", hash_original_method = "3035FF1473A97381B4AFABBF5B73F76A", hash_generated_method = "57D276C4DAD0725F9DEA8C8D8CC5F8CA")
    
public void openConnection(OperatedClientConnection conn,
                               HttpHost target,
                               InetAddress local,
                               HttpContext context,
                               HttpParams params)
        throws IOException {

        if (conn == null) {
            throw new IllegalArgumentException
                ("Connection must not be null.");
        }
        if (target == null) {
            throw new IllegalArgumentException
                ("Target host must not be null.");
        }
        // local address may be null
        //@@@ is context allowed to be null?
        if (params == null) {
            throw new IllegalArgumentException
                ("Parameters must not be null.");
        }
        if (conn.isOpen()) {
            throw new IllegalArgumentException
                ("Connection must not be open.");
        }

        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        final SocketFactory sf = schm.getSocketFactory();
        final SocketFactory plain_sf;
        final LayeredSocketFactory layered_sf;
        if (sf instanceof LayeredSocketFactory) {
            plain_sf = staticPlainSocketFactory;
            layered_sf = (LayeredSocketFactory)sf;
        } else {
            plain_sf = sf;
            layered_sf = null;
        }
        InetAddress[] addresses = InetAddress.getAllByName(target.getHostName());

        for (int i = 0; i < addresses.length; ++i) {
            Socket sock = plain_sf.createSocket();
            conn.opening(sock, target);

            try {
                Socket connsock = plain_sf.connectSocket(sock,
                    addresses[i].getHostAddress(),
                    schm.resolvePort(target.getPort()),
                    local, 0, params);
                if (sock != connsock) {
                    sock = connsock;
                    conn.opening(sock, target);
                }
                /*
                 * prepareSocket is called on the just connected
                 * socket before the creation of the layered socket to
                 * ensure that desired socket options such as
                 * TCP_NODELAY, SO_RCVTIMEO, SO_LINGER will be set
                 * before any I/O is performed on the socket. This
                 * happens in the common case as
                 * SSLSocketFactory.createSocket performs hostname
                 * verification which requires that SSL handshaking be
                 * performed.
                 */
                prepareSocket(sock, context, params);
                if (layered_sf != null) {
                    Socket layeredsock = layered_sf.createSocket(sock,
                        target.getHostName(),
                        schm.resolvePort(target.getPort()),
                        true);
                    if (layeredsock != sock) {
                        conn.opening(layeredsock, target);
                    }
                    conn.openCompleted(sf.isSecure(layeredsock), params);
                } else {
                    conn.openCompleted(sf.isSecure(sock), params);
                }
                break;
            // BEGIN android-changed
            //       catch SocketException to cover any kind of connect failure
            } catch (SocketException ex) {
                if (i == addresses.length - 1) {
                    ConnectException cause = ex instanceof ConnectException
                            ? (ConnectException) ex : new ConnectException(ex.getMessage(), ex);
                    throw new HttpHostConnectException(target, cause);
                }
            // END android-changed
            } catch (ConnectTimeoutException ex) {
                if (i == addresses.length - 1) {
                    throw ex;
                }
            }
        }
    } // openConnection


    // non-javadoc, see interface ClientConnectionOperator
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.438 -0500", hash_original_method = "B263843ECB367B56A8B3543219BABBA8", hash_generated_method = "8C6B777C24337E1FE667E3677ED69F33")
    
public void updateSecureConnection(OperatedClientConnection conn,
                                       HttpHost target,
                                       HttpContext context,
                                       HttpParams params)
        throws IOException {


        if (conn == null) {
            throw new IllegalArgumentException
                ("Connection must not be null.");
        }
        if (target == null) {
            throw new IllegalArgumentException
                ("Target host must not be null.");
        }
        //@@@ is context allowed to be null?
        if (params == null) {
            throw new IllegalArgumentException
                ("Parameters must not be null.");
        }
        if (!conn.isOpen()) {
            throw new IllegalArgumentException
                ("Connection must be open.");
        }

        final Scheme schm = schemeRegistry.getScheme(target.getSchemeName());
        if (!(schm.getSocketFactory() instanceof LayeredSocketFactory)) {
            throw new IllegalArgumentException
                ("Target scheme (" + schm.getName() +
                 ") must have layered socket factory.");
        }

        final LayeredSocketFactory lsf = (LayeredSocketFactory) schm.getSocketFactory();
        final Socket sock;
        try {
            sock = lsf.createSocket
                (conn.getSocket(), target.getHostName(), schm.resolvePort(target.getPort()), true);
        } catch (ConnectException ex) {
            throw new HttpHostConnectException(target, ex);
        }
        prepareSocket(sock, context, params);
        conn.update(sock, target, lsf.isSecure(sock), params);
        //@@@ error handling: close the layered socket in case of exception?

    } // updateSecureConnection


    /**
     * Performs standard initializations on a newly created socket.
     *
     * @param sock      the socket to prepare
     * @param context   the context for the connection
     * @param params    the parameters from which to prepare the socket
     *
     * @throws IOException      in case of an IO problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:35.441 -0500", hash_original_method = "EEE63DC836F5AA81B1ECC566DDEA88C5", hash_generated_method = "E82CEC69A1F5D37810182A3E91AD9916")
    
protected void prepareSocket(Socket sock, HttpContext context,
                                 HttpParams params)
        throws IOException {

        // context currently not used, but derived classes may need it
        //@@@ is context allowed to be null?

        sock.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        sock.setSoTimeout(HttpConnectionParams.getSoTimeout(params));

        int linger = HttpConnectionParams.getLinger(params);
        if (linger >= 0) {
            sock.setSoLinger(linger > 0, linger);
        }

    }
}

