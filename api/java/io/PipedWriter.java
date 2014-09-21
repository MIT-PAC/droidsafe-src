/*
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

package java.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Arrays;

/**
 * Places information on a communications pipe. When two threads want to pass
 * data back and forth, one creates a piped writer and the other creates a piped
 * reader.
 *
 * @see PipedReader
 */
public class PipedWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.825 -0400", hash_original_field = "F4667C1A5C3A34CDE0FC1CFCE84A421A", hash_generated_field = "6106E4D838ADECE7E0CE07C6C6BDA9C6")


    private PipedReader destination;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.826 -0400", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;

    /**
     * Constructs a new unconnected {@code PipedWriter}. The resulting writer
     * must be connected to a {@code PipedReader} before data may be written to
     * it.
     *
     * @see PipedReader
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.828 -0400", hash_original_method = "AF15732C11112F568DB193A6297432AC", hash_generated_method = "14245DFDA43075C0EFDD40457133ED8C")
    
public PipedWriter() {
    }

    /**
     * Constructs a new {@code PipedWriter} connected to {@code destination}.
     * Any data written to this writer can be read from {@code destination}.
     *
     * @param destination
     *            the {@code PipedReader} to connect to.
     * @throws IOException
     *             if {@code destination} is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.829 -0400", hash_original_method = "59530B90FE1ECD23B9779A5898273441", hash_generated_method = "C45123C53A16AF990E91B4E82AD50C38")
    
public PipedWriter(PipedReader destination) throws IOException {
        super(destination);
        connect(destination);
    }

    /**
     * Closes this writer. If a {@link PipedReader} is connected to this writer,
     * it is closed as well and the pipe is disconnected. Any data buffered in
     * the reader can still be read.
     *
     * @throws IOException
     *             if an error occurs while closing this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.830 -0400", hash_original_method = "EA9FB10088BB3AE60C92B6639C401766", hash_generated_method = "F4BE8A4B2C9F3FF766131D16A0B24C86")
    
@Override
    public void close() throws IOException {
        PipedReader reader = destination;
        if (reader != null) {
            reader.done();
            isClosed = true;
            destination = null;
        }
    }

    /**
     * Connects this {@code PipedWriter} to a {@link PipedReader}. Any data
     * written to this writer becomes readable in the reader.
     *
     * @param reader
     *            the reader to connect to.
     * @throws IOException
     *             if this writer is closed or already connected, or if {@code
     *             reader} is already connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.832 -0400", hash_original_method = "22B9CF190EAC492F97DA48B8A2944B45", hash_generated_method = "B275AB2F196A20EFB5A9F2C968D19419")
    
public void connect(PipedReader reader) throws IOException {
        if (reader == null) {
            throw new NullPointerException();
        }
        synchronized (reader) {
            if (this.destination != null) {
                throw new IOException("Pipe already connected");
            }
            reader.establishConnection();
            this.lock = reader;
            this.destination = reader;
        }
    }

    /**
     * Notifies the readers of this {@code PipedReader} that characters can be read. This
     * method does nothing if this Writer is not connected.
     *
     * @throws IOException
     *             if an I/O error occurs while flushing this writer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.833 -0400", hash_original_method = "B1EF10C5BF228CD46C095797CFF94D68", hash_generated_method = "C37B4B786003030C7830A0338AC55E09")
    
@Override
    public void flush() throws IOException {
        PipedReader reader = destination;
        if (isClosed) {
            throw new IOException("Pipe is closed");
        }
        if (reader == null) {
            return;
        }

        synchronized (reader) {
            reader.notifyAll();
        }
    }

    /**
     * Writes {@code count} characters from the character array {@code buffer}
     * starting at offset {@code index} to this writer. The written data can
     * then be read from the connected {@link PipedReader} instance.
     * <p>
     * Separate threads should be used to write to a {@code PipedWriter} and to
     * read from the connected {@code PipedReader}. If the same thread is used,
     * a deadlock may occur.
     *
     * @param buffer
     *            the buffer to write.
     * @param offset
     *            the index of the first character in {@code buffer} to write.
     * @param count
     *            the number of characters from {@code buffer} to write to this
     *            writer.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if {@code
     *             offset + count} is bigger than the length of {@code buffer}.
     * @throws InterruptedIOException
     *             if the pipe is full and the current thread is interrupted
     *             waiting for space to write data. This case is not currently
     *             handled correctly.
     * @throws IOException
     *             if this writer is closed or not connected, if the target
     *             reader is closed or if the thread reading from the target
     *             reader is no longer alive. This case is currently not handled
     *             correctly.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.834 -0400", hash_original_method = "65D0C1FB85C32C2C64DB52F42F1CAC1F", hash_generated_method = "717EF9FD56283C2BB087C167DA0A5024")
    
@Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        PipedReader reader = destination;
        if (reader == null) {
            throw new IOException("Pipe not connected");
        }
        reader.receive(buffer, offset, count);
    }

    /**
     * Writes a single character {@code c} to this writer. This character can
     * then be read from the connected {@link PipedReader} instance.
     * <p>
     * Separate threads should be used to write to a {@code PipedWriter} and to
     * read from the connected {@code PipedReader}. If the same thread is used,
     * a deadlock may occur.
     *
     * @param c
     *            the character to write.
     * @throws InterruptedIOException
     *             if the pipe is full and the current thread is interrupted
     *             waiting for space to write data. This case is not currently
     *             handled correctly.
     * @throws IOException
     *             if this writer is closed or not connected, if the target
     *             reader is closed or if the thread reading from the target
     *             reader is no longer alive. This case is currently not handled
     *             correctly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.837 -0400", hash_original_method = "8A6D899560577A82609A2E072438CED2", hash_generated_method = "C47589E396BFEFD568FD26B37C4CFF74")
    
@Override
    public void write(int c) throws IOException {
        PipedReader reader = destination;
        if (reader == null) {
            throw new IOException("Pipe not connected");
        }
        reader.receive((char) c);
    }
}
