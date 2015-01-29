/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/SocketHttpServerConnection.java $
 * $Revision: 561083 $
 * $Date: 2007-07-30 11:31:17 -0700 (Mon, 30 Jul 2007) $
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

package org.apache.http.impl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import org.apache.http.HttpInetConnection;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * Implementation of a server-side HTTP connection that can be bound to a 
 * network Socket in order to receive and transmit data.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 561083 $
 * 
 * @since 4.0
 */
public class SocketHttpServerConnection extends 
        AbstractHttpServerConnection implements HttpInetConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.494 -0400", hash_original_field = "B4185B849AB8251A0F1052DF377DB9A2", hash_generated_field = "F8642D5396CC441E503E603D20259781")


    private volatile boolean open;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.495 -0400", hash_original_field = "E7F90F41B90C8A055F53F64B106EF2DC", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.495 -0400", hash_original_method = "789798C1009BE09CCCA4BCE858132AD8", hash_generated_method = "0023BF0AF18DF4F7E81E7DB9FC30959D")
    
public SocketHttpServerConnection() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.496 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "919400152E63DA2E6B748C48EF7E35F5")
    
protected void assertNotOpen() {
        if (this.open) {
            throw new IllegalStateException("Connection is already open");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.496 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "FFDD4DF53A09A80EDFF51162C703EFE5")
    
protected void assertOpen() {
        if (!this.open) {
            throw new IllegalStateException("Connection is not open");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.497 -0400", hash_original_method = "63DC28D949CCD6DA3FD5AF52B74788DB", hash_generated_method = "EF9C94921943F432F9DA8D4C2D91CA99")
    
protected SessionInputBuffer createHttpDataReceiver(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        return new SocketInputBuffer(socket, buffersize, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.497 -0400", hash_original_method = "2F0F8E3757356F4F57A29BB499B7F6D1", hash_generated_method = "75D9451BA0D628D40985C194A458BE5B")
    
protected SessionOutputBuffer createHttpDataTransmitter(
            final Socket socket, 
            int buffersize,
            final HttpParams params) throws IOException {
        return new SocketOutputBuffer(socket, buffersize, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.498 -0400", hash_original_method = "DE4CCA8D563A1688E323FBAE6D73ADE6", hash_generated_method = "650039526492526CCC469A088E18B6DC")
    
protected void bind(final Socket socket, final HttpParams params) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.socket = socket;
        
        int buffersize = HttpConnectionParams.getSocketBufferSize(params);
        
        init(
                createHttpDataReceiver(socket, buffersize, params), 
                createHttpDataTransmitter(socket, buffersize, params),
                params);
        
        this.open = true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.498 -0400", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "39B5114475E69C5D8CA323CEC1163514")
    
protected Socket getSocket() {
        return this.socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.499 -0400", hash_original_method = "38867CD3C8042DC0E4B0EAE08D88273F", hash_generated_method = "4B65C01A0DE7D3AF867EAB51C8BCEB29")
    
public boolean isOpen() {
        return this.open;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.499 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "EA530790EC409832EC35D8CAE50145BF")
    
public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.500 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "3A0C54C4A483F7C7ABC3323E7544AA7B")
    
public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.500 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "A53D10A004E6582D7D26BD15F7A46312")
    
public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.501 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "E09502CC817CBCDCE2D379B1FD8CEA55")
    
public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.501 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "EE9131719BF4079CA96A25DB7FDB04A8")
    
public void setSocketTimeout(int timeout) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(timeout);
            } catch (SocketException ignore) {
                // It is not quite clear from the Sun's documentation if there are any 
                // other legitimate cases for a socket exception to be thrown when setting 
                // SO_TIMEOUT besides the socket being already closed
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.502 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "655443F0128AABC6EA28FA9B52CC5D57")
    
public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            } catch (SocketException ignore) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.502 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "C3605AB6514A2B9C5B898F69DC37D353")
    
public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
        if (tmpsocket != null) {
            tmpsocket.close();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:41.504 -0400", hash_original_method = "17EB8B4DF870014AFB738603AE114C76", hash_generated_method = "E5998153CE928613C5BF7CDEFF6472A0")
    
public void close() throws IOException {
        if (!this.open) {
            return;
        }
        this.open = false;
        doFlush();
        try {
            this.socket.shutdownOutput();
        } catch (IOException ignore) {
        }
        try {
            this.socket.shutdownInput();
        } catch (IOException ignore) {
        }
        this.socket.close();
    }
    
}
