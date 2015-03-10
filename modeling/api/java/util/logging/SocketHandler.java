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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.logging;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A handler that writes log messages to a socket connection.
 * <p>
 * This handler reads the following properties from the log manager to
 * initialize itself:
 * <ul>
 * <li>java.util.logging.ConsoleHandler.level specifies the logging level,
 * defaults to {@code Level.ALL} if this property is not found or has an invalid
 * value.
 * <li>java.util.logging.SocketHandler.filter specifies the name of the filter
 * class to be associated with this handler, defaults to {@code null} if this
 * property is not found or has an invalid value.
 * <li>java.util.logging.SocketHandler.formatter specifies the name of the
 * formatter class to be associated with this handler, defaults to
 * {@code java.util.logging.XMLFormatter} if this property is not found or has
 * an invalid value.
 * <li>java.util.logging.SocketHandler.encoding specifies the encoding this
 * handler will use to encode log messages, defaults to {@code null} if this
 * property is not found or has an invalid value.
 * <li>java.util.logging.SocketHandler.host specifies the name of the host that
 * this handler should connect to. There's no default value for this property.
 * <li>java.util.logging.SocketHandler.encoding specifies the port number that
 * this handler should connect to. There's no default value for this property.
 * </ul>
 * <p>
 * This handler buffers the outgoing messages, but flushes each time a log
 * record has been published.
 * <p>
 * This class is not thread-safe.
 */
public class SocketHandler extends StreamHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.885 -0400", hash_original_field = "F0F8FBDB82DE56E15CCB47D8D7ED0E17", hash_generated_field = "D520ED57224A6F9CE5187DA36C9AD6F8")

    private static final String DEFAULT_LEVEL = "ALL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.886 -0400", hash_original_field = "2A94DFCCBD95C14B1BC657A243C10B60", hash_generated_field = "E846F4DE46A15439AA20066FA114453F")

    private static final String DEFAULT_FORMATTER = "java.util.logging.XMLFormatter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.886 -0400", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;

    /**
     * Constructs a {@code SocketHandler} object using the properties read by
     * the log manager, including the host name and port number. Default
     * formatting uses the XMLFormatter class and level is set to ALL.
     *
     * @throws IOException
     *             if failed to connect to the specified host and port.
     * @throws IllegalArgumentException
     *             if the host name or port number is illegal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.887 -0400", hash_original_method = "228CD135B74BEE173DF1FDAA69CFF020", hash_generated_method = "EB0C0DE41E90A5E599DCA5BE118525E2")
    
public SocketHandler() throws IOException {
        super(DEFAULT_LEVEL, null, DEFAULT_FORMATTER, null);
        initSocket(LogManager.getLogManager().getProperty(
                "java.util.logging.SocketHandler.host"), LogManager
                .getLogManager().getProperty(
                        "java.util.logging.SocketHandler.port"));
    }

    /**
     * Constructs a {@code SocketHandler} object using the specified host name
     * and port number together with other properties read by the log manager.
     * Default formatting uses the XMLFormatter class and level is set to ALL.
     *
     * @param host
     *            the host name
     * @param port
     *            the port number
     * @throws IOException
     *             if failed to connect to the specified host and port.
     * @throws IllegalArgumentException
     *             if the host name or port number is illegal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.887 -0400", hash_original_method = "171636A38013579070C6C6BD5B6F9388", hash_generated_method = "1138EA470F4B7AC217C003773FAE5A53")
    
public SocketHandler(String host, int port) throws IOException {
        super(DEFAULT_LEVEL, null, DEFAULT_FORMATTER, null);
        initSocket(host, String.valueOf(port));
    }

    // Initialize the socket connection and prepare the output stream
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.888 -0400", hash_original_method = "9C7227006876AFB9EFBD186DF2971E2E", hash_generated_method = "F16237EEFB3B53A5F7E0F569F8A37A3F")
    
private void initSocket(String host, String port) throws IOException {
        // check the validity of the host name
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("host == null || host.isEmpty()");
        }
        // check the validity of the port number
        int p = 0;
        try {
            p = Integer.parseInt(port);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Illegal port argument");
        }
        if (p <= 0) {
            throw new IllegalArgumentException("Illegal port argument");
        }
        // establish the network connection
        try {
            this.socket = new Socket(host, p);
        } catch (IOException e) {
            getErrorManager().error("Failed to establish the network connection", e,
                    ErrorManager.OPEN_FAILURE);
            throw e;
        }
        super.internalSetOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
    }

    /**
     * Closes this handler. The network connection to the host is also closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.888 -0400", hash_original_method = "1F05D34A2502A67AE3C0DAE6B443988B", hash_generated_method = "72A39A6F445A48532946264EBD205A68")
    
@Override
    public void close() {
        try {
            super.close();
            if (this.socket != null) {
                this.socket.close();
                this.socket = null;
            }
        } catch (Exception e) {
            getErrorManager().error("Exception occurred when closing the socket handler", e,
                    ErrorManager.CLOSE_FAILURE);
        }
    }

    /**
     * Logs a record if necessary. A flush operation will be done afterwards.
     *
     * @param record
     *            the log record to be logged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.889 -0400", hash_original_method = "50E37064F43FB111250793273CC27B2F", hash_generated_method = "5EDB523FEB7611F8337B49DDF83B9BF4")
    
@Override
    public void publish(LogRecord record) {
        super.publish(record);
        super.flush();
    }
}
