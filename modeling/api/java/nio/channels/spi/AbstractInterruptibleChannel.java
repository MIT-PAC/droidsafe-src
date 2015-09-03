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


package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.Channel;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.InterruptibleChannel;

public abstract class AbstractInterruptibleChannel implements Channel, InterruptibleChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.843 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "ACA7C061F36840D4F0EB869DD1E1AB7C")

    private volatile boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.845 -0500", hash_original_field = "0D4EE7030B7F215071386480E00E3511", hash_generated_field = "40A458BD5C00C50CD6C70C9B2D7F702B")

    volatile boolean interrupted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.733 -0400", hash_original_field = "EABFBB4303F4F38DE6361EA110D0C225", hash_generated_field = "3241E21A4D9EDA17FAE674120F4A600D")

    private final Runnable interruptAndCloseRunnable = new Runnable() {
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:56.733 -0400", hash_original_method = "AE7E9C29A12236996DA74E23561B6760", hash_generated_method = "A82EC148D3A353CBA856B48EDD1EC897")
        @Override
        public void run() {
            try 
            {
                interrupted = true;
                AbstractInterruptibleChannel.this.close();
            } 
            catch (IOException ignored)
            { }
            
        }
        
};

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.853 -0500", hash_original_method = "8D566223F7B6A201818F5E4BFCF4F6EB", hash_generated_method = "AEB2875D39F3451BA1CDF86D6F8E0B58")
    
protected AbstractInterruptibleChannel() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.856 -0500", hash_original_method = "EEF08D7C99E69679C24335EC336EDE1D", hash_generated_method = "9219E403A6D1F3A8FA8DD293570F10D1")
    
@Override public synchronized final boolean isOpen() {
        return !closed;
    }

    /**
     * Closes an open channel. If the channel is already closed then this method
     * has no effect, otherwise it closes the receiver via the
     * {@code implCloseChannel} method.
     * <p>
     * If an attempt is made to perform an operation on a closed channel then a
     * {@link java.nio.channels.ClosedChannelException} is thrown.
     * <p>
     * If multiple threads attempt to simultaneously close a channel, then only
     * one thread will run the closure code and the others will be blocked until
     * the first one completes.
     *
     * @throws IOException
     *             if a problem occurs while closing this channel.
     * @see java.nio.channels.Channel#close()
     */
    @DSComment("no suspicious activity")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.859 -0500", hash_original_method = "4C9E4AC237D7628755D560FFD1AA5234", hash_generated_method = "6C2DE299C40C17EBC93A0618727B6ABB")
    
@Override public final void close() throws IOException {
        if (!closed) {
            synchronized (this) {
                if (!closed) {
                    closed = true;
                    implCloseChannel();
                }
            }
        }
    }

    /**
     * Indicates the beginning of a code section that includes an I/O operation
     * that is potentially blocking. After this operation, the application
     * should invoke the corresponding {@code end(boolean)} method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.862 -0500", hash_original_method = "F0AA56CB3350B0CEA7EF4FF29453D45D", hash_generated_method = "11944B49B489B7A4BFA697FDFBC45991")
    
protected final void begin() {
        Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
    }

    /**
     * Indicates the end of a code section that has been started with
     * {@code begin()} and that includes a potentially blocking I/O operation.
     *
     * @param success
     *            pass {@code true} if the blocking operation has succeeded and
     *            has had a noticeable effect; {@code false} otherwise.
     * @throws AsynchronousCloseException
     *             if this channel is closed by another thread while this method
     *             is executing.
     * @throws ClosedByInterruptException
     *             if another thread interrupts the calling thread while this
     *             method is executing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.864 -0500", hash_original_method = "9F919A15107680D02C9F3C07FD906976", hash_generated_method = "1B681B64DF5EE267DB1B0CD7E83BA291")
    
protected final void end(boolean success) throws AsynchronousCloseException {
        Thread.currentThread().popInterruptAction$(interruptAndCloseRunnable);
        if (interrupted) {
            interrupted = false;
            throw new ClosedByInterruptException();
        }
        if (!success && closed) {
            throw new AsynchronousCloseException();
        }
    }

    /**
     * Implements the channel closing behavior.
     * <p>
     * Closes the channel with a guarantee that the channel is not currently
     * closed through another invocation of {@code close()} and that the method
     * is thread-safe.
     * <p>
     * Any outstanding threads blocked on I/O operations on this channel must be
     * released with either a normal return code, or by throwing an
     * {@code AsynchronousCloseException}.
     *
     * @throws IOException
     *             if a problem occurs while closing the channel.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:57.867 -0500", hash_original_method = "9762B902A56F50AF9CDE8E96A06F4D65", hash_generated_method = "F2284707C3F560D4B31581090601831F")
    
protected abstract void implCloseChannel() throws IOException;
    
}

