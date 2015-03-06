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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class ServerSocketChannel extends AbstractSelectableChannel {

    /**
     * Creates an open and unbound server-socket channel.
     * <p>
     * This channel is created by calling {@code openServerSocketChannel} method
     * of the default {@code SelectorProvider} instance.
     *
     * @return the new channel which is open but unbound.
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.380 -0500", hash_original_method = "34D19E8F6CC7AE23963D26F15FC056F7", hash_generated_method = "82BC2C8DDAA1412A8ADF42B437FD7D7F")
    
public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    /**
     * Constructs a new {@link ServerSocketChannel}.
     *
     * @param selectorProvider
     *            an instance of SelectorProvider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.378 -0500", hash_original_method = "D01FB77CE4D99625B967A0B24C153D7F", hash_generated_method = "D1CAF59EE5D623AF472B9D7554336637")
    
protected ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
    }

    /**
     * Gets the valid operations of this channel. Server-socket channels support
     * accepting operation, so this method returns {@code
     * SelectionKey.OP_ACCEPT}.
     *
     * @see java.nio.channels.SelectableChannel#validOps()
     * @return the operations supported by this channel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.383 -0500", hash_original_method = "63BB8F155E94FEBA5DA1D0A1F3E44C8C", hash_generated_method = "93311AFBDA5C9F832C6547EFAF34981A")
    
@Override
    public final int validOps() {
        return SelectionKey.OP_ACCEPT;
    }

    /**
     * Return the server-socket assigned this channel, which does not declare
     * any public methods that are not declared in {@code ServerSocket}.
     *
     * @return the server-socket assigned to this channel.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.386 -0500", hash_original_method = "E46E31344319076C9803158D28BD500C", hash_generated_method = "632783B6BE4977774D73D2AA87CFFB62")
    
public abstract ServerSocket socket();

    /**
     * Accepts a connection to this server-socket channel.
     * <p>
     * This method returns {@code null} when this channel is non-blocking and no
     * connection is available, otherwise it blocks until a new connection is
     * available or an I/O error occurs. The socket channel returned by this
     * method will always be in blocking mode.
     * <p>
     * This method just executes the same security checks as the {@code
     * accept()} method of the {@link ServerSocket} class.
     *
     * @return the accepted {@code SocketChannel} instance, or {@code null} if
     *         the channel is non-blocking and no connection is available.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is in operation.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             operation is in progress. The interrupt state of the calling
     *             thread is set and the channel is closed.
     * @throws ClosedChannelException
     *             if this channel is closed.
     * @throws IOException
     *             if another I/O error occurs.
     * @throws NotYetBoundException
     *             if the socket has not yet been bound.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.389 -0500", hash_original_method = "F5741EF9698B4CF9EEEA6AE06A1F48D2", hash_generated_method = "D333A8257FEB8A1F812C98D1166ABF69")
    
public abstract SocketChannel accept() throws IOException;
    
}

