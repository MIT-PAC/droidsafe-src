/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A functional, light weight {@link InputStream} that emulates
 * a stream of a specified size.
 * <p>
 * This implementation provides a light weight
 * object for testing with an {@link InputStream}
 * where the contents don't matter.
 * <p>
 * One use case would be for testing the handling of
 * large {@link InputStream} as it can emulate that
 * scenario without the overhead of actually processing
 * large numbers of bytes - significantly speeding up
 * test execution times.
 * <p>
 * This implementation returns zero from the method that
 * reads a byte and leaves the array unchanged in the read
 * methods that are passed a byte array.
 * If alternative data is required the <code>processByte()</code> and
 * <code>processBytes()</code> methods can be implemented to generate
 * data, for example:
 *
 * <pre>
 *  public class TestInputStream extends NullInputStream {
 *      public TestInputStream(int size) {
 *          super(size);
 *      }
 *      protected int processByte() {
 *          return ... // return required value here
 *      }
 *      protected void processBytes(byte[] bytes, int offset, int length) {
 *          for (int i = offset; i < length; i++) {
 *              bytes[i] = ... // set array value here
 *          }
 *      }
 *  }
 * </pre>
 *
 * @since 1.3
 * @version $Id: NullInputStream.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class NullInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.806 -0400", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private  long size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.806 -0400", hash_original_field = "52DF2E6914C34BE1E271C4366CA6267D", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.807 -0400", hash_original_field = "3863EE780FA482243DACC4207FAAD902", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.807 -0400", hash_original_field = "6A438BF03A20CC2FAB38F535859AC15F", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.808 -0400", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.808 -0400", hash_original_field = "B3CDE10D77EC585C9BCECC460F473D4F", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private  boolean throwEofException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.809 -0400", hash_original_field = "DD7DBA10CBEF467890A2C2BD241C7FF7", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private  boolean markSupported;

    /**
     * Create an {@link InputStream} that emulates a specified size
     * which supports marking and does not throw EOFException.
     *
     * @param size The size of the input stream to emulate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.809 -0400", hash_original_method = "E86AC9DEB16682D41BCA3DC804FCEE8E", hash_generated_method = "429DFABE1047D3D9A588B74E22B72F87")
    
public NullInputStream(long size) {
       this(size, true, false);
    }

    /**
     * Create an {@link InputStream} that emulates a specified
     * size with option settings.
     *
     * @param size The size of the input stream to emulate.
     * @param markSupported Whether this instance will support
     * the <code>mark()</code> functionality.
     * @param throwEofException Whether this implementation
     * will throw an {@link EOFException} or return -1 when the
     * end of file is reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.810 -0400", hash_original_method = "830F103A96EA74148B0B8535C89D1AF0", hash_generated_method = "5A10F966298D89294A25BC18B8CDB047")
    
public NullInputStream(long size, boolean markSupported, boolean throwEofException) {
       this.size = size;
       this.markSupported = markSupported;
       this.throwEofException = throwEofException;
    }

    /**
     * Return the current position.
     *
     * @return the current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.810 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "EEE0772972AB1657C28DA68A7C7AA05F")
    
public long getPosition() {
        return position;
    }

    /**
     * Return the size this {@link InputStream} emulates.
     *
     * @return The size of the input stream to emulate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.811 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "EB3DBFDE453A5D88801767E17B680EEE")
    
public long getSize() {
        return size;
    }

    /**
     * Return the number of bytes that can be read.
     *
     * @return The number of bytes that can be read.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.811 -0400", hash_original_method = "7F3FA848D774B0E8E97D2C379EE0C684", hash_generated_method = "224DD502B8D64AE54B9B850DB5F4777F")
    
@Override
    public int available() {
        long avail = size - position;
        if (avail <= 0) {
            return 0;
        } else if (avail > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)avail;
        }
    }

    /**
     * Close this input stream - resets the internal state to
     * the initial values.
     *
     * @throws IOException If an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.812 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "E96997EF41B5EE4DD2D315BC127B1E7A")
    
@Override
    public void close() throws IOException {
        eof = false;
        position = 0;
        mark = -1;
    }

    /**
     * Mark the current position.
     *
     * @param readlimit The number of bytes before this marked position
     * is invalid.
     * @throws UnsupportedOperationException if mark is not supported.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.813 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "112EB2C413E4179B843715E34640BB86")
    
@Override
    public synchronized void mark(int readlimit) {
        if (!markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        mark = position;
        this.readlimit = readlimit;
    }

    /**
     * Indicates whether <i>mark</i> is supported.
     *
     * @return Whether <i>mark</i> is supported or not.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.813 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "E8E4BDB926E9E2747B073CF25256C0EE")
    
@Override
    public boolean markSupported() {
        return markSupported;
    }

    /**
     * Read a byte.
     *
     * @return Either The byte value returned by <code>processByte()</code>
     * or <code>-1</code> if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.814 -0400", hash_original_method = "58A7A50486EDC9346A5D459542A5BDB7", hash_generated_method = "56B74626BE81A12F04EB89EA486FC9FD")
    
@Override
    public int read() throws IOException {
        if (eof) {
            throw new IOException("Read after end of file");
        }
        if (position == size) {
            return doEndOfFile();
        }
        position++;
        return processByte();
    }

    /**
     * Read some bytes into the specified array.
     *
     * @param bytes The byte array to read into
     * @return The number of bytes read or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.814 -0400", hash_original_method = "1E949846598722C79E2F0E8E4DF0AE25", hash_generated_method = "DBD45AE7C79C3D96484923938B09E477")
    
@Override
    public int read(byte[] bytes) throws IOException {
        return read(bytes, 0, bytes.length);
    }

    /**
     * Read the specified number bytes into an array.
     *
     * @param bytes The byte array to read into.
     * @param offset The offset to start reading bytes into.
     * @param length The number of bytes to read.
     * @return The number of bytes read or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.815 -0400", hash_original_method = "05A90D0FB660BAF10AD4D61031A72FD9", hash_generated_method = "4BBF2732884EE85DD846B0E6BB60AB12")
    
@Override
    public int read(byte[] bytes, int offset, int length) throws IOException {
        if (eof) {
            throw new IOException("Read after end of file");
        }
        if (position == size) {
            return doEndOfFile();
        }
        position += length;
        int returnLength = length;
        if (position > size) {
            returnLength = length - (int)(position - size);
            position = size;
        }
        processBytes(bytes, offset, returnLength);
        return returnLength;
    }

    /**
     * Reset the stream to the point when mark was last called.
     *
     * @throws UnsupportedOperationException if mark is not supported.
     * @throws IOException If no position has been marked
     * or the read limit has been exceed since the last position was
     * marked.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.816 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "808C5618E8DCBABF47C90F606652224D")
    
@Override
    public synchronized void reset() throws IOException {
        if (!markSupported) {
            throw new UnsupportedOperationException("Mark not supported");
        }
        if (mark < 0) {
            throw new IOException("No position has been marked");
        }
        if (position > mark + readlimit) {
            throw new IOException("Marked position [" + mark +
                    "] is no longer valid - passed the read limit [" +
                    readlimit + "]");
        }
        position = mark;
        eof = false;
    }

    /**
     * Skip a specified number of bytes.
     *
     * @param numberOfBytes The number of bytes to skip.
     * @return The number of bytes skipped or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.817 -0400", hash_original_method = "9210FB6C78C901008C5A67E434CB9A0B", hash_generated_method = "786E77D872575F47B0AF55657DA8A37D")
    
@Override
    public long skip(long numberOfBytes) throws IOException {
        if (eof) {
            throw new IOException("Skip after end of file");
        }
        if (position == size) {
            return doEndOfFile();
        }
        position += numberOfBytes;
        long returnLength = numberOfBytes;
        if (position > size) {
            returnLength = numberOfBytes - (position - size);
            position = size;
        }
        return returnLength;
    }

    /**
     * Return a byte value for the  <code>read()</code> method.
     * <p>
     * This implementation returns zero.
     *
     * @return This implementation always returns zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.818 -0400", hash_original_method = "F722CD05EE5576BABE566E57360BDAA4", hash_generated_method = "3C0F1395BED2A6E0D07718D78A4C00FC")
    
protected int processByte() {
        // do nothing - overridable by subclass
        return 0;
    }

    /**
     * Process the bytes for the <code>read(byte[], offset, length)</code>
     * method.
     * <p>
     * This implementation leaves the byte array unchanged.
     *
     * @param bytes The byte array
     * @param offset The offset to start at.
     * @param length The number of bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.818 -0400", hash_original_method = "8351070DA7823031FCCA3BE9B1CDBB4D", hash_generated_method = "5E144588AF176953A74CB8C14F71C89C")
    
protected void processBytes(byte[] bytes, int offset, int length) {
        // do nothing - overridable by subclass
    }

    /**
     * Handle End of File.
     *
     * @return <code>-1</code> if <code>throwEofException</code> is
     * set to {@code false}
     * @throws EOFException if <code>throwEofException</code> is set
     * to {@code true}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.819 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "380899F3E1EB67D55FF8A375DB8A9EC3")
    
private int doEndOfFile() throws EOFException {
        eof = true;
        if (throwEofException) {
            throw new EOFException();
        }
        return -1;
    }

}
