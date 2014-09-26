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
import java.io.Reader;

/**
 * A functional, light weight {@link Reader} that emulates
 * a reader of a specified size.
 * <p>
 * This implementation provides a light weight
 * object for testing with an {@link Reader}
 * where the contents don't matter.
 * <p>
 * One use case would be for testing the handling of
 * large {@link Reader} as it can emulate that
 * scenario without the overhead of actually processing
 * large numbers of characters - significantly speeding up
 * test execution times.
 * <p>
 * This implementation returns a space from the method that
 * reads a character and leaves the array unchanged in the read
 * methods that are passed a character array.
 * If alternative data is required the <code>processChar()</code> and
 * <code>processChars()</code> methods can be implemented to generate
 * data, for example:
 *
 * <pre>
 *  public class TestReader extends NullReader {
 *      public TestReader(int size) {
 *          super(size);
 *      }
 *      protected char processChar() {
 *          return ... // return required value here
 *      }
 *      protected void processChars(char[] chars, int offset, int length) {
 *          for (int i = offset; i < length; i++) {
 *              chars[i] = ... // set array value here
 *          }
 *      }
 *  }
 * </pre>
 *
 * @since 1.3
 * @version $Id: NullReader.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class NullReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.432 -0400", hash_original_field = "298A39EB1E059FD1DCE8DF5205BAB3E6", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private  long size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.433 -0400", hash_original_field = "52DF2E6914C34BE1E271C4366CA6267D", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.434 -0400", hash_original_field = "3863EE780FA482243DACC4207FAAD902", hash_generated_field = "D1E0F56B583923CB5E6B889CBA9E43DD")

    private long mark = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.434 -0400", hash_original_field = "6A438BF03A20CC2FAB38F535859AC15F", hash_generated_field = "46E59163904A8500BBCD8FB336955372")

    private long readlimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.434 -0400", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.435 -0400", hash_original_field = "B3CDE10D77EC585C9BCECC460F473D4F", hash_generated_field = "470C7A20C05392D09467E0B6AE3E34BA")

    private  boolean throwEofException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.435 -0400", hash_original_field = "DD7DBA10CBEF467890A2C2BD241C7FF7", hash_generated_field = "D1D7DACB2C9F2116ACC3AAD64C509D2F")

    private  boolean markSupported;

    /**
     * Create a {@link Reader} that emulates a specified size
     * which supports marking and does not throw EOFException.
     *
     * @param size The size of the reader to emulate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.436 -0400", hash_original_method = "FC4346B115F208CCA0C91C96990142D1", hash_generated_method = "5DE7B06646C4B1B5CB538B2D8FF1278B")
    
public NullReader(long size) {
       this(size, true, false);
    }

    /**
     * Create a {@link Reader} that emulates a specified
     * size with option settings.
     *
     * @param size The size of the reader to emulate.
     * @param markSupported Whether this instance will support
     * the <code>mark()</code> functionality.
     * @param throwEofException Whether this implementation
     * will throw an {@link EOFException} or return -1 when the
     * end of file is reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.436 -0400", hash_original_method = "D4F800CDE3B717C1CE3877D05130C0A3", hash_generated_method = "69BE6D49DBF7AF0D46595F8550EF68A4")
    
public NullReader(long size, boolean markSupported, boolean throwEofException) {
       this.size = size;
       this.markSupported = markSupported;
       this.throwEofException = throwEofException;
    }

    /**
     * Return the current position.
     *
     * @return the current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.437 -0400", hash_original_method = "1760B71EAFD51B63FDFEE5AB7AC5FEE9", hash_generated_method = "EEE0772972AB1657C28DA68A7C7AA05F")
    
public long getPosition() {
        return position;
    }

    /**
     * Return the size this {@link Reader} emulates.
     *
     * @return The size of the reader to emulate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.437 -0400", hash_original_method = "25EF411BA02CBCB0F772C5374653B5E7", hash_generated_method = "EB3DBFDE453A5D88801767E17B680EEE")
    
public long getSize() {
        return size;
    }

    /**
     * Close this Reader - resets the internal state to
     * the initial values.
     *
     * @throws IOException If an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.438 -0400", hash_original_method = "EEFDACC2C301B42650B1064C3D4059CC", hash_generated_method = "E96997EF41B5EE4DD2D315BC127B1E7A")
    
@Override
    public void close() throws IOException {
        eof = false;
        position = 0;
        mark = -1;
    }

    /**
     * Mark the current position.
     *
     * @param readlimit The number of characters before this marked position
     * is invalid.
     * @throws UnsupportedOperationException if mark is not supported.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.439 -0400", hash_original_method = "7AEF2C3B62C677DC9FD1211BE4D4F4EB", hash_generated_method = "112EB2C413E4179B843715E34640BB86")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.439 -0400", hash_original_method = "0829B6DA23F89F75CF76B7CF84C00C9F", hash_generated_method = "E8E4BDB926E9E2747B073CF25256C0EE")
    
@Override
    public boolean markSupported() {
        return markSupported;
    }

    /**
     * Read a character.
     *
     * @return Either The character value returned by <code>processChar()</code>
     * or <code>-1</code> if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.440 -0400", hash_original_method = "FBA121B80064AD99E30C613A90CFA3D6", hash_generated_method = "78E79B0ADA1605C9FAFD14A005E06430")
    
@Override
    public int read() throws IOException {
        if (eof) {
            throw new IOException("Read after end of file");
        }
        if (position == size) {
            return doEndOfFile();
        }
        position++;
        return processChar();
    }

    /**
     * Read some characters into the specified array.
     *
     * @param chars The character array to read into
     * @return The number of characters read or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.440 -0400", hash_original_method = "4AD28164B3ED3B60A2412B4E7DEDB826", hash_generated_method = "7B97829D7327FE16832AC140D8159784")
    
@Override
    public int read(char[] chars) throws IOException {
        return read(chars, 0, chars.length);
    }

    /**
     * Read the specified number characters into an array.
     *
     * @param chars The character array to read into.
     * @param offset The offset to start reading characters into.
     * @param length The number of characters to read.
     * @return The number of characters read or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSpec(DSCat.IO)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.441 -0400", hash_original_method = "C70C3A95CC69C815CEA97A11A597B28A", hash_generated_method = "04972A776A6CFDACEFE618F29818A262")
    
@Override
    public int read(char[] chars, int offset, int length) throws IOException {
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
        processChars(chars, offset, returnLength);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.442 -0400", hash_original_method = "DA70D8E8EFCF4CE896E4E17AB2D27792", hash_generated_method = "808C5618E8DCBABF47C90F606652224D")
    
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
     * Skip a specified number of characters.
     *
     * @param numberOfChars The number of characters to skip.
     * @return The number of characters skipped or <code>-1</code>
     * if the end of file has been reached and
     * <code>throwEofException</code> is set to {@code false}.
     * @throws EOFException if the end of file is reached and
     * <code>throwEofException</code> is set to {@code true}.
     * @throws IOException if trying to read past the end of file.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.443 -0400", hash_original_method = "438CF302A21CA34274E9B0DDF0F4C413", hash_generated_method = "BFD86699D1955E07B67B93B74D5CA719")
    
@Override
    public long skip(long numberOfChars) throws IOException {
        if (eof) {
            throw new IOException("Skip after end of file");
        }
        if (position == size) {
            return doEndOfFile();
        }
        position += numberOfChars;
        long returnLength = numberOfChars;
        if (position > size) {
            returnLength = numberOfChars - (position - size);
            position = size;
        }
        return returnLength;
    }

    /**
     * Return a character value for the  <code>read()</code> method.
     * <p>
     * This implementation returns zero.
     *
     * @return This implementation always returns zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.443 -0400", hash_original_method = "A737830B6A2B6F6C2620CA3298757069", hash_generated_method = "9D8868FD69A1D6291C9E6928B0842C7B")
    
protected int processChar() {
        // do nothing - overridable by subclass
        return 0;
    }

    /**
     * Process the characters for the <code>read(char[], offset, length)</code>
     * method.
     * <p>
     * This implementation leaves the character array unchanged.
     *
     * @param chars The character array
     * @param offset The offset to start at.
     * @param length The number of characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.444 -0400", hash_original_method = "CECA15CD5926CD1CCF5DBC543CFC909D", hash_generated_method = "159894D458809E73B0695BC5746BF16C")
    
protected void processChars(char[] chars, int offset, int length) {
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.444 -0400", hash_original_method = "19CB45ABF7C0C1D656700921E322A527", hash_generated_method = "380899F3E1EB67D55FF8A375DB8A9EC3")
    
private int doEndOfFile() throws EOFException {
        eof = true;
        if (throwEofException) {
            throw new EOFException();
        }
        return -1;
    }

}
