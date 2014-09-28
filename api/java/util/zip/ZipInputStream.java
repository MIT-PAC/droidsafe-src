/*
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

package java.util.zip;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.Arrays;
import libcore.io.Memory;
import libcore.io.Streams;

/**
 * This class provides an implementation of {@code FilterInputStream} that
 * decompresses data from an {@code InputStream} containing a ZIP archive.
 *
 * <p>A ZIP archive is a collection of (possibly) compressed files.
 * When reading from a {@code ZipInputStream}, you retrieve the
 * entry's metadata with {@code getNextEntry} before you can read the userdata.
 *
 * <p>Although {@code InflaterInputStream} can only read compressed ZIP archive
 * entries, this class can read non-compressed entries as well.
 *
 * <p>Use {@code ZipFile} if you can access the archive as a file directly,
 * especially if you want random access to entries, rather than needing to
 * iterate over all entries.
 *
 * <h3>Example</h3>
 * <p>Using {@code ZipInputStream} is a little more complicated than {@link GZIPInputStream}
 * because ZIP archives are containers that can contain multiple files. This code pulls all the
 * files out of a ZIP archive, similar to the {@code unzip(1)} utility.
 * <pre>
 * InputStream is = ...
 * ZipInputStream zis = new ZipInputStream(new BufferedInputStream(is));
 * try {
 *     ZipEntry ze;
 *     while ((ze = zis.getNextEntry()) != null) {
 *         ByteArrayOutputStream baos = new ByteArrayOutputStream();
 *         byte[] buffer = new byte[1024];
 *         int count;
 *         while ((count = zis.read(buffer)) != -1) {
 *             baos.write(buffer, 0, count);
 *         }
 *         String filename = ze.getName();
 *         byte[] bytes = baos.toByteArray();
 *         // do something with 'filename' and 'bytes'...
 *     }
 * } finally {
 *     zis.close();
 * }
 * </pre>
 *
 * @see ZipEntry
 * @see ZipFile
 */
public class ZipInputStream extends InflaterInputStream implements ZipConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:28.952 -0500", hash_original_field = "54699AF53E8564C6E5F214A7233CCDD6", hash_generated_field = "C7C4508444B1DF1FC0028548D38411C2")

    private static final int ZIPLocalHeaderVersionNeeded = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:28.962 -0500", hash_original_field = "EBCD046F74CB70BAE53EBB903C7F21F6", hash_generated_field = "5AB15FDF6F0D00EB61CB356C20A2F949")

    private boolean entriesEnd = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:28.970 -0500", hash_original_field = "2B861B3B5414D6B5D9284DD415417E9C", hash_generated_field = "01B9B653BA72011921756681A88BB0D4")

    private boolean hasDD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:28.977 -0500", hash_original_field = "DA303DBB27BF5F54F7215E11B2D070E2", hash_generated_field = "70C0E1ABC7A2C088413A0DEAD0E06C15")

    private int entryIn = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:28.985 -0500", hash_original_field = "9E78B9D9236AC98E6EA1E62DE65B039A", hash_generated_field = "D9B9DDAB6E94A633070B4360A0469156")

    private int inRead, lastRead = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.004 -0500", hash_original_field = "AE5E76079A9FB60B306BB24D8DD33468", hash_generated_field = "FAD8DD5A4D43550551E80B6E823A3546")

    private ZipEntry currentEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.012 -0500", hash_original_field = "04330805FEF68B2C499795E3642E34F2", hash_generated_field = "56C93EA708A209494AB5E75290EBA950")

    private final byte[] hdrBuf = new byte[LOCHDR - LOCVER];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.020 -0500", hash_original_field = "8797544496C08ADE2D4F77E9A38D0FB1", hash_generated_field = "05500ADE9A7CD6E53D52A131B8F3E602")

    private final CRC32 crc = new CRC32();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.029 -0500", hash_original_field = "4496A3AD30CD6ECCD3C9089BF0ED5F92", hash_generated_field = "6832CEC69BD7D80A32A9BCEB95CC7986")

    private byte[] nameBuf = new byte[256];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.036 -0500", hash_original_field = "CFDCDB01635BC5E0C6D5AC082BC7294A", hash_generated_field = "6A45CE718592EF029A0C7D6F9DC9F60B")

    private char[] charBuf = new char[256];

    /**
     * Constructs a new {@code ZipInputStream} from the specified input stream.
     *
     * @param stream
     *            the input stream to representing a ZIP archive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.046 -0500", hash_original_method = "32F7B432B343B7F58D1461B37558D4B2", hash_generated_method = "05116BFB9DF65B0E2F73BE0AD51C78C3")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
 
public ZipInputStream(InputStream stream) {
        super(new PushbackInputStream(stream, BUF_SIZE), new Inflater(true));
        if (stream == null) {
            throw new NullPointerException();
        }
    }

    /**
     * Closes this {@code ZipInputStream}.
     *
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.055 -0500", hash_original_method = "CA8615D5E3AAE2ABC2CABE3EA39D93C4", hash_generated_method = "F48855CC847FE1DFC14AD2CE6816B79E")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void close() throws IOException {
        if (!closed) {
            closeEntry(); // Close the current entry
            super.close();
        }
    }

    /**
     * Closes the current ZIP entry and positions to read the next entry.
     *
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.082 -0500", hash_original_method = "9F54CDA31FAC4F483D73C146FF485B4D", hash_generated_method = "24C07D7E853778412BE894D7A9C6759E")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void closeEntry() throws IOException {
        checkClosed();
        if (currentEntry == null) {
            return;
        }
        if (currentEntry instanceof java.util.jar.JarEntry) {
            Attributes temp = ((JarEntry) currentEntry).getAttributes();
            if (temp != null && temp.containsKey("hidden")) {
                return;
            }
        }

        /*
         * The following code is careful to leave the ZipInputStream in a
         * consistent state, even when close() results in an exception. It does
         * so by:
         *  - pushing bytes back into the source stream
         *  - reading a data descriptor footer from the source stream
         *  - resetting fields that manage the entry being closed
         */

        // Ensure all entry bytes are read
        Exception failure = null;
        try {
            Streams.skipAll(this);
        } catch (Exception e) {
            failure = e;
        }

        int inB, out;
        if (currentEntry.compressionMethod == ZipEntry.DEFLATED) {
            inB = inf.getTotalIn();
            out = inf.getTotalOut();
        } else {
            inB = inRead;
            out = inRead;
        }
        int diff = entryIn - inB;
        // Pushback any required bytes
        if (diff != 0) {
            ((PushbackInputStream) in).unread(buf, len - diff, diff);
        }

        try {
            readAndVerifyDataDescriptor(inB, out);
        } catch (Exception e) {
            if (failure == null) { // otherwise we're already going to throw
                failure = e;
            }
        }

        inf.reset();
        lastRead = inRead = entryIn = len = 0;
        crc.reset();
        currentEntry = null;

        if (failure != null) {
            if (failure instanceof IOException) {
                throw (IOException) failure;
            } else if (failure instanceof RuntimeException) {
                throw (RuntimeException) failure;
            }
            AssertionError error = new AssertionError();
            error.initCause(failure);
            throw error;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.097 -0500", hash_original_method = "D97D64F44034B029CF3622E88D52B954", hash_generated_method = "DDE2E43281990BECE66C778DCEE2F9A1")
    @DSBan(DSCat.PRIVATE_METHOD)
private void readAndVerifyDataDescriptor(int inB, int out) throws IOException {
        if (hasDD) {
            Streams.readFully(in, hdrBuf, 0, EXTHDR);
            int sig = Memory.peekInt(hdrBuf, 0, ByteOrder.LITTLE_ENDIAN);
            if (sig != (int) EXTSIG) {
                throw new ZipException(String.format("unknown format (EXTSIG=%x)", sig));
            }
            currentEntry.crc = ((long) Memory.peekInt(hdrBuf, EXTCRC, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
            currentEntry.compressedSize = ((long) Memory.peekInt(hdrBuf, EXTSIZ, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
            currentEntry.size = ((long) Memory.peekInt(hdrBuf, EXTLEN, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
        }
        if (currentEntry.crc != crc.getValue()) {
            throw new ZipException("CRC mismatch");
        }
        if (currentEntry.compressedSize != inB || currentEntry.size != out) {
            throw new ZipException("Size mismatch");
        }
    }

    /**
     * Reads the next entry from this {@code ZipInputStream} or {@code null} if
     * no more entries are present.
     *
     * @return the next {@code ZipEntry} contained in the input stream.
     * @throws IOException
     *             if an {@code IOException} occurs.
     * @see ZipEntry
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.131 -0500", hash_original_method = "54ECE3D106EDABB06E89F1683E79B515", hash_generated_method = "6C828158FDA1705A141B9B8188A06F6A")
    @DSSpec(DSCat.IO)
public ZipEntry getNextEntry() throws IOException {
        closeEntry();
        if (entriesEnd) {
            return null;
        }

        Streams.readFully(in, hdrBuf, 0, 4);
        int hdr = Memory.peekInt(hdrBuf, 0, ByteOrder.LITTLE_ENDIAN);
        if (hdr == CENSIG) {
            entriesEnd = true;
            return null;
        }
        if (hdr != LOCSIG) {
            return null;
        }

        // Read the local header
        Streams.readFully(in, hdrBuf, 0, (LOCHDR - LOCVER));
        int version = Memory.peekShort(hdrBuf, 0, ByteOrder.LITTLE_ENDIAN) & 0xff;
        if (version > ZIPLocalHeaderVersionNeeded) {
            throw new ZipException("Cannot read local header version " + version);
        }
        short flags = Memory.peekShort(hdrBuf, LOCFLG - LOCVER, ByteOrder.LITTLE_ENDIAN);
        hasDD = ((flags & ZipFile.GPBF_DATA_DESCRIPTOR_FLAG) != 0);
        int ceTime = Memory.peekShort(hdrBuf, LOCTIM - LOCVER, ByteOrder.LITTLE_ENDIAN) & 0xffff;
        int ceModDate = Memory.peekShort(hdrBuf, LOCTIM - LOCVER + 2, ByteOrder.LITTLE_ENDIAN) & 0xffff;
        int ceCompressionMethod = Memory.peekShort(hdrBuf, LOCHOW - LOCVER, ByteOrder.LITTLE_ENDIAN) & 0xffff;
        long ceCrc = 0, ceCompressedSize = 0, ceSize = -1;
        if (!hasDD) {
            ceCrc = ((long) Memory.peekInt(hdrBuf, LOCCRC - LOCVER, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
            ceCompressedSize = ((long) Memory.peekInt(hdrBuf, LOCSIZ - LOCVER, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
            ceSize = ((long) Memory.peekInt(hdrBuf, LOCLEN - LOCVER, ByteOrder.LITTLE_ENDIAN)) & 0xffffffffL;
        }
        int nameLength = Memory.peekShort(hdrBuf, LOCNAM - LOCVER, ByteOrder.LITTLE_ENDIAN) & 0xffff;
        if (nameLength == 0) {
            throw new ZipException("Entry is not named");
        }
        int extraLength = Memory.peekShort(hdrBuf, LOCEXT - LOCVER, ByteOrder.LITTLE_ENDIAN) & 0xffff;

        if (nameLength > nameBuf.length) {
            nameBuf = new byte[nameLength];
            // The bytes are modified UTF-8, so the number of chars will always be less than or
            // equal to the number of bytes. It's fine if this buffer is too long.
            charBuf = new char[nameLength];
        }
        Streams.readFully(in, nameBuf, 0, nameLength);
        currentEntry = createZipEntry(ModifiedUtf8.decode(nameBuf, charBuf, 0, nameLength));
        currentEntry.time = ceTime;
        currentEntry.modDate = ceModDate;
        currentEntry.setMethod(ceCompressionMethod);
        if (ceSize != -1) {
            currentEntry.setCrc(ceCrc);
            currentEntry.setSize(ceSize);
            currentEntry.setCompressedSize(ceCompressedSize);
        }
        if (extraLength > 0) {
            byte[] extraData = new byte[extraLength];
            Streams.readFully(in, extraData, 0, extraLength);
            currentEntry.setExtra(extraData);
        }
        return currentEntry;
    }

    /**
     * Reads up to the specified number of uncompressed bytes into the buffer
     * starting at the offset.
     *
     * @return the number of bytes read
     */
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.150 -0500", hash_original_method = "08559147F9D27369068888CD58E1DEEA", hash_generated_method = "0D4ED54206A2427810FBE423FEB86F58")
    @DSSpec(DSCat.IO)
@Override
    public int read(byte[] buffer, int offset, int byteCount) throws IOException {
        checkClosed();
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);

        if (inf.finished() || currentEntry == null) {
            return -1;
        }

        if (currentEntry.compressionMethod == ZipEntry.STORED) {
            int csize = (int) currentEntry.size;
            if (inRead >= csize) {
                return -1;
            }
            if (lastRead >= len) {
                lastRead = 0;
                if ((len = in.read(buf)) == -1) {
                    eof = true;
                    return -1;
                }
                entryIn += len;
            }
            int toRead = byteCount > (len - lastRead) ? len - lastRead : byteCount;
            if ((csize - inRead) < toRead) {
                toRead = csize - inRead;
            }
            System.arraycopy(buf, lastRead, buffer, offset, toRead);
            lastRead += toRead;
            inRead += toRead;
            crc.update(buffer, offset, toRead);
            return toRead;
        }
        if (inf.needsInput()) {
            fill();
            if (len > 0) {
                entryIn += len;
            }
        }
        int read;
        try {
            read = inf.inflate(buffer, offset, byteCount);
        } catch (DataFormatException e) {
            throw new ZipException(e.getMessage());
        }
        if (read == 0 && inf.finished()) {
            return -1;
        }
        crc.update(buffer, offset, read);
        return read;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.157 -0500", hash_original_method = "944D3DD754B8DECD27145FEAF048B004", hash_generated_method = "EF7D051F41DC2805D998C7B2E4ABD1FF")
    
@Override
    public int available() throws IOException {
        checkClosed();
        // The InflaterInputStream contract says we must only return 0 or 1.
        return (currentEntry == null || inRead < currentEntry.size) ? 1 : 0;
    }

    /**
     * creates a {@link ZipEntry } with the given name.
     *
     * @param name
     *            the name of the entry.
     * @return the created {@code ZipEntry}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.165 -0500", hash_original_method = "499185192566F23A832B6156D3A8CCC7", hash_generated_method = "2C1BD1614151BAADD071E85F4064D665")
    
protected ZipEntry createZipEntry(String name) {
        return new ZipEntry(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:07:29.172 -0500", hash_original_method = "249965AABC06DCB5B5F50760C9E2C49A", hash_generated_method = "B2C7CAFBEA57F8C308959ADD87C03C39")
    @DSSafe(DSCat.SAFE_OTHERS)
private void checkClosed() throws IOException {
        if (closed) {
            throw new IOException("Stream is closed");
        }
    }
}
