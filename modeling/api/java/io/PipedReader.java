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


package java.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;

/**
 * Receives information on a communications pipe. When two threads want to pass
 * data back and forth, one creates a piped writer and the other creates a piped
 * reader.
 *
 * @see PipedWriter
 */
public class PipedReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.735 -0400", hash_original_field = "32272A849EA457522206621DB7551BDB", hash_generated_field = "FABD140D57D60A7ACF4E64F052C2F233")

    private static final int PIPE_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.727 -0400", hash_original_field = "0C274599D1E182E9646E850B1F54838C", hash_generated_field = "F5A62F451E05D22096D6EE6BA212D601")

    private Thread lastReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.728 -0400", hash_original_field = "11B82934C1097E36AA09E79AB8952C5D", hash_generated_field = "276A7969C85F5DE4B1F84464F2E355FA")

    private Thread lastWriter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.729 -0400", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.731 -0400", hash_original_field = "AF37951EAE101F357ACAF48FB7E85D88", hash_generated_field = "C5FBB54C5ACD68A27601FA9626F9BD71")

    private char[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.732 -0400", hash_original_field = "6C2A488AC6B0C698A8607CEA3B0A6CD5", hash_generated_field = "2F9A5D73F47370A21AE4A08085B153A1")

    private int in = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.733 -0400", hash_original_field = "F336AD514990B0A382A01CD56F41BE74", hash_generated_field = "BBF66E925C765324BC4F03EC2625E2E0")

    private int out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.736 -0400", hash_original_field = "63EA3415F69DFBAE1E285FCFD4110E54", hash_generated_field = "63EA3415F69DFBAE1E285FCFD4110E54")

    boolean isConnected;

    /**
     * Constructs a new unconnected {@code PipedReader}. The resulting reader
     * must be connected to a {@code PipedWriter} before data may be read from
     * it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.737 -0400", hash_original_method = "53799AAC3D67C4F54A45AACC008AC230", hash_generated_method = "329FCE671171CB83ACDC5123ED52E899")
    
public PipedReader() {}

    /**
     * Constructs a new {@code PipedReader} connected to the {@link PipedWriter}
     * {@code out}. Any data written to the writer can be read from the this
     * reader.
     *
     * @param out
     *            the {@code PipedWriter} to connect to.
     * @throws IOException
     *             if {@code out} is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.738 -0400", hash_original_method = "A0B768CF57E1F7DA94AFD19BF22227AD", hash_generated_method = "956415FFC2B0662879A67175A830D77B")
    
public PipedReader(PipedWriter out) throws IOException {
        connect(out);
    }

    /**
     * Constructs a new unconnected {@code PipedReader} with the given buffer size.
     * The resulting reader must be connected to a {@code PipedWriter} before
     * data may be read from it.
     *
     * @param pipeSize the size of the buffer in chars.
     * @throws IllegalArgumentException if pipeSize is less than or equal to zero.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.740 -0400", hash_original_method = "B0D8F9AB9DAE7643755A0FA1F6AF462B", hash_generated_method = "42F6BF27DF0009003C1C8CA7C236295B")
    
public PipedReader(int pipeSize) {
        if (pipeSize <= 0) {
            throw new IllegalArgumentException("pipe size " + pipeSize + " too small");
        }
        buffer = new char[pipeSize];
    }

    /**
     * Constructs a new {@code PipedReader} connected to the given {@code PipedWriter},
     * with the given buffer size. Any data written to the writer can be read from
     * this reader.
     *
     * @param out the {@code PipedWriter} to connect to.
     * @param pipeSize the size of the buffer in chars.
     * @throws IOException if an I/O error occurs
     * @throws IllegalArgumentException if pipeSize is less than or equal to zero.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.741 -0400", hash_original_method = "782234940FFFA3B01507A4A4C912C506", hash_generated_method = "18282E9E3BC3055A30647E26B510FE7C")
    
public PipedReader(PipedWriter out, int pipeSize) throws IOException {
        this(pipeSize);
        connect(out);
    }

    /**
     * Closes this reader. This implementation releases the buffer used for
     * the pipe and notifies all threads waiting to read or write.
     *
     * @throws IOException
     *             if an error occurs while closing this reader.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.742 -0400", hash_original_method = "5DC76D27E31809647AFF6A6935906F66", hash_generated_method = "63D6F39248A22F97220BB9163EFEE7DE")
    
@Override
    public synchronized void close() throws IOException {
        buffer = null;
        isClosed = true;
        notifyAll();
    }

    /**
     * Connects this {@code PipedReader} to a {@link PipedWriter}. Any data
     * written to the writer becomes readable in this reader.
     *
     * @param src
     *            the writer to connect to.
     * @throws IOException
     *             if this reader is closed or already connected, or if {@code
     *             src} is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.744 -0400", hash_original_method = "7F76EBED3F4915C265DC747261EC7DCA", hash_generated_method = "A0D9B84DE1C69F7252F02BAD08E3A6CD")
    
public void connect(PipedWriter src) throws IOException {
        src.connect(this);
    }

    /**
     * Establishes the connection to the PipedWriter.
     *
     * @throws IOException
     *             If this Reader is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.746 -0400", hash_original_method = "99AF6CDDF6475DC07C8A5DDBE48E63BD", hash_generated_method = "DEE778C02BD54ECA5AB0468163B8873F")
    
synchronized void establishConnection() throws IOException {
        if (isConnected) {
            throw new IOException("Pipe already connected");
        }
        if (isClosed) {
            throw new IOException("Pipe is closed");
        }
        if (buffer == null) { // We may already have allocated the buffer.
            buffer = new char[PIPE_SIZE];
        }
        isConnected = true;
    }

    /**
     * Reads a single character from this reader and returns it as an integer
     * with the two higher-order bytes set to 0. Returns -1 if the end of the
     * reader has been reached. If there is no data in the pipe, this method
     * blocks until data is available, the end of the reader is detected or an
     * exception is thrown.
     * <p>
     * Separate threads should be used to read from a {@code PipedReader} and to
     * write to the connected {@link PipedWriter}. If the same thread is used,
     * a deadlock may occur.
     *
     * @return the character read or -1 if the end of the reader has been
     *         reached.
     * @throws IOException
     *             if this reader is closed or some other I/O error occurs.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.747 -0400", hash_original_method = "3089A342CB577DB16E4C20E9D5F36203", hash_generated_method = "5BD3538831C37B4750C2FC5CAFF9845A")
    
@Override
    public int read() throws IOException {
        char[] chars = new char[1];
        int result = read(chars, 0, 1);
        return result != -1 ? chars[0] : result;
    }

    /**
     * Reads at most {@code count} characters from this reader and stores them
     * in the character array {@code buffer} starting at {@code offset}. If
     * there is no data in the pipe, this method blocks until at least one byte
     * has been read, the end of the reader is detected or an exception is
     * thrown.
     * <p>
     * Separate threads should be used to read from a {@code PipedReader} and to
     * write to the connected {@link PipedWriter}. If the same thread is used, a
     * deadlock may occur.
     *
     * @param buffer
     *            the character array in which to store the characters read.
     * @param offset
     *            the initial position in {@code bytes} to store the characters
     *            read from this reader.
     * @param count
     *            the maximum number of characters to store in {@code buffer}.
     * @return the number of characters read or -1 if the end of the reader has
     *         been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is greater than the size of {@code buffer}.
     * @throws InterruptedIOException
     *             if the thread reading from this reader is interrupted.
     * @throws IOException
     *             if this reader is closed or not connected to a writer, or if
     *             the thread writing to the connected writer is no longer
     *             alive.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.749 -0400", hash_original_method = "88E857352F305CC5B26FDAB2F16230FB", hash_generated_method = "F5C4C741FD5385AE848E2F6375B336D4")
    
@Override
    public synchronized int read(char[] buffer, int offset, int count) throws IOException {
        if (!isConnected) {
            throw new IOException("Pipe not connected");
        }
        if (this.buffer == null) {
            throw new IOException("Pipe is closed");
        }
        Arrays.checkOffsetAndCount(buffer.length, offset, count);
        if (count == 0) {
            return 0;
        }
        /**
         * Set the last thread to be reading on this PipedReader. If
         * lastReader dies while someone is waiting to write an IOException
         * of "Pipe broken" will be thrown in receive()
         */
        lastReader = Thread.currentThread();
        try {
            boolean first = true;
            while (in == -1) {
                // Are we at end of stream?
                if (isClosed) {
                    return -1;
                }
                if (!first && lastWriter != null && !lastWriter.isAlive()) {
                    throw new IOException("Pipe broken");
                }
                first = false;
                // Notify callers of receive()
                notifyAll();
                wait(1000);
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }

        int copyLength = 0;
        /* Copy chars from out to end of buffer first */
        if (out >= in) {
            copyLength = count > this.buffer.length - out ? this.buffer.length - out : count;
            System.arraycopy(this.buffer, out, buffer, offset, copyLength);
            out += copyLength;
            if (out == this.buffer.length) {
                out = 0;
            }
            if (out == in) {
                // empty buffer
                in = -1;
                out = 0;
            }
        }

        /*
         * Did the read fully succeed in the previous copy or is the buffer
         * empty?
         */
        if (copyLength == count || in == -1) {
            return copyLength;
        }

        int charsCopied = copyLength;
        /* Copy bytes from 0 to the number of available bytes */
        copyLength = in - out > count - copyLength ? count - copyLength : in - out;
        System.arraycopy(this.buffer, out, buffer, offset + charsCopied, copyLength);
        out += copyLength;
        if (out == in) {
            // empty buffer
            in = -1;
            out = 0;
        }
        return charsCopied + copyLength;
    }

    /**
     * Indicates whether this reader is ready to be read without blocking.
     * Returns {@code true} if this reader will not block when {@code read} is
     * called, {@code false} if unknown or blocking will occur. This
     * implementation returns {@code true} if the internal buffer contains
     * characters that can be read.
     *
     * @return always {@code false}.
     * @throws IOException
     *             if this reader is closed or not connected, or if some other
     *             I/O error occurs.
     * @see #read()
     * @see #read(char[], int, int)
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.751 -0400", hash_original_method = "97F3598D4AF720280352B5FB455E6AAF", hash_generated_method = "7F273DF1C43E9D89D63B738277FD676B")
    
@Override
    public synchronized boolean ready() throws IOException {
        if (!isConnected) {
            throw new IOException("Pipe not connected");
        }
        if (buffer == null) {
            throw new IOException("Pipe is closed");
        }
        return in != -1;
    }

    /**
     * Receives a char and stores it into the PipedReader. This called by
     * PipedWriter.write() when writes occur.
     * <P>
     * If the buffer is full and the thread sending #receive is interrupted, the
     * InterruptedIOException will be thrown.
     *
     * @param oneChar
     *            the char to store into the pipe.
     *
     * @throws IOException
     *             If the stream is already closed or another IOException
     *             occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.754 -0400", hash_original_method = "704AD8FAAAA6D050CB91ECF7DD8F01C8", hash_generated_method = "F7A44ECF235A01291AE90E3760F0FAC8")
    
synchronized void receive(char oneChar) throws IOException {
        if (buffer == null) {
            throw new IOException("Pipe is closed");
        }
        if (lastReader != null && !lastReader.isAlive()) {
            throw new IOException("Pipe broken");
        }
        /*
        * Set the last thread to be writing on this PipedWriter. If
        * lastWriter dies while someone is waiting to read an IOException
        * of "Pipe broken" will be thrown in read()
        */
        lastWriter = Thread.currentThread();
        try {
            while (buffer != null && out == in) {
                notifyAll();
                wait(1000);
                if (lastReader != null && !lastReader.isAlive()) {
                    throw new IOException("Pipe broken");
                }
            }
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
        if (buffer == null) {
            throw new IOException("Pipe is closed");
        }
        if (in == -1) {
            in = 0;
        }
        buffer[in++] = oneChar;
        if (in == buffer.length) {
            in = 0;
        }
    }

    /**
     * Receives a char array and stores it into the PipedReader. This called by
     * PipedWriter.write() when writes occur.
     * <P>
     * If the buffer is full and the thread sending #receive is interrupted, the
     * InterruptedIOException will be thrown.
     *
     * @throws IOException
     *             If the stream is already closed or another IOException
     *             occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.756 -0400", hash_original_method = "CE3822F666A61014064AFF57BDAE9612", hash_generated_method = "0D6727FBA02414B3EEF65BB9705ACCBF")
    
synchronized void receive(char[] chars, int offset, int count) throws IOException {
        Arrays.checkOffsetAndCount(chars.length, offset, count);
        if (buffer == null) {
            throw new IOException("Pipe is closed");
        }
        if (lastReader != null && !lastReader.isAlive()) {
            throw new IOException("Pipe broken");
        }
        /**
         * Set the last thread to be writing on this PipedWriter. If
         * lastWriter dies while someone is waiting to read an IOException
         * of "Pipe broken" will be thrown in read()
         */
        lastWriter = Thread.currentThread();
        while (count > 0) {
            try {
                while (buffer != null && out == in) {
                    notifyAll();
                    wait(1000);
                    if (lastReader != null && !lastReader.isAlive()) {
                        throw new IOException("Pipe broken");
                    }
                }
            } catch (InterruptedException e) {
                throw new InterruptedIOException();
            }
            if (buffer == null) {
                throw new IOException("Pipe is closed");
            }
            if (in == -1) {
                in = 0;
            }
            if (in >= out) {
                int length = buffer.length - in;
                if (count < length) {
                    length = count;
                }
                System.arraycopy(chars, offset, buffer, in, length);
                offset += length;
                count -= length;
                in += length;
                if (in == buffer.length) {
                    in = 0;
                }
            }
            if (count > 0 && in != out) {
                int length = out - in;
                if (count < length) {
                    length = count;
                }
                System.arraycopy(chars, offset, buffer, in, length);
                offset += length;
                count -= length;
                in += length;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.757 -0400", hash_original_method = "19BFAB2AD4E1A13AD9CB12419968F5AB", hash_generated_method = "0B05E6B5D4DC4B6BD624E8CCC3D31FDE")
    
synchronized void done() {
        isClosed = true;
        notifyAll();
    }
}
