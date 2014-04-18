package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charsets;
import java.util.ArrayList;
import java.util.Arrays;

public class ZipOutputStream extends DeflaterOutputStream implements ZipConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.687 -0500", hash_original_field = "76C48874DF3F847D8799A9755C24ED8B", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.689 -0500", hash_original_field = "5C7A58E94B0366CCD8319D0DE1E9C38C", hash_generated_field = "C303454481B8041CEF37C1E89A2E0D63")

    public static final int STORED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.692 -0500", hash_original_field = "54699AF53E8564C6E5F214A7233CCDD6", hash_generated_field = "C7C4508444B1DF1FC0028548D38411C2")

    private static final int ZIPLocalHeaderVersionNeeded = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.695 -0500", hash_original_field = "6C9FE4127C88B2FD28EFE861CA65A713", hash_generated_field = "3ED42D4B537F5FDB36FDF1EA0D6B44D6")

    private String comment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.697 -0500", hash_original_field = "AC8055A280DC35CF986D8F9985631987", hash_generated_field = "FCD66FA4768DC8FA4CD3A9CC1267729C")

    private final ArrayList<String> entries = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.699 -0500", hash_original_field = "466121C1BB03C4AEEC4797317B8E914B", hash_generated_field = "E346083B375866BE2A4C0EAFE5E7BD2C")

    private int compressMethod = DEFLATED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.701 -0500", hash_original_field = "8D0A167E8895678068AB0FC4EDE9D878", hash_generated_field = "62D95194EDF4CD5AF603C678BBE8005F")

    private int compressLevel = Deflater.DEFAULT_COMPRESSION;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.703 -0500", hash_original_field = "A6095F3EC380485DF76B1EDC41E32D32", hash_generated_field = "C96530FB5377271C1898F50B375B5BBD")

    private ByteArrayOutputStream cDir = new ByteArrayOutputStream();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.706 -0500", hash_original_field = "AE5E76079A9FB60B306BB24D8DD33468", hash_generated_field = "FAD8DD5A4D43550551E80B6E823A3546")

    private ZipEntry currentEntry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.709 -0500", hash_original_field = "8797544496C08ADE2D4F77E9A38D0FB1", hash_generated_field = "05500ADE9A7CD6E53D52A131B8F3E602")

    private final CRC32 crc = new CRC32();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "F13C8B3640CBC13657DAF750F9C8A763", hash_generated_field = "724EB7AA080C9DB92A724877C069F566")

    private int offset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "0C9D69CB336285B27A073DBF36A55063", hash_generated_field = "78E3728F7EB982C6341A9332E0F24622")

    private int curOffset = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.855 -0400", hash_original_field = "670188D389D8410371BBA9B7E3605CFF", hash_generated_field = "74943DB2321A5915CA10DA328ADE45C0")

    private int nameLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.714 -0500", hash_original_field = "0D1AACDA58A3D49FFE7A3DC9DDAEC33A", hash_generated_field = "C02803E2C735C9AD9F5E84CD57AB59E3")

    private byte[] nameBytes;

    /**
     * Constructs a new {@code ZipOutputStream} with the specified output
     * stream.
     *
     * @param p1
     *            the {@code OutputStream} to write the data to.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.717 -0500", hash_original_method = "8A42A56E156B97294BE7CC83201EADCF", hash_generated_method = "F421FE5C883001A63E02AD136DB20949")
    
public ZipOutputStream(OutputStream p1) {
        super(p1, new Deflater(Deflater.DEFAULT_COMPRESSION, true));
    }

    /**
     * Closes the current {@code ZipEntry}, if any, and the underlying output
     * stream. If the stream is already closed this method does nothing.
     *
     * @throws IOException
     *             If an error occurs closing the stream.
     */
    @DSComment("no impacts")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.720 -0500", hash_original_method = "96C568DC9FCDB3D53590F6DD994D0456", hash_generated_method = "29AA042CE63E9348EE8728FB9A5169DB")
    
@Override
    public void close() throws IOException {
        // don't call super.close() because that calls finish() conditionally
        if (out != null) {
            finish();
            def.end();
            out.close();
            out = null;
        }
    }

    /**
     * Closes the current {@code ZipEntry}. Any entry terminal data is written
     * to the underlying stream.
     *
     * @throws IOException
     *             If an error occurs closing the entry.
     */
    @DSComment("no impacts")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.724 -0500", hash_original_method = "7ED55E9CAB55F4762479C264D19A0A1A", hash_generated_method = "D2E42844E675B45C0508617ED084D17F")
    
public void closeEntry() throws IOException {
        checkClosed();
        if (currentEntry == null) {
            return;
        }
        if (currentEntry.getMethod() == DEFLATED) {
            super.finish();
        }

        // Verify values for STORED types
        if (currentEntry.getMethod() == STORED) {
            if (crc.getValue() != currentEntry.crc) {
                throw new ZipException("CRC mismatch");
            }
            if (currentEntry.size != crc.tbytes) {
                throw new ZipException("Size mismatch");
            }
        }
        curOffset = LOCHDR;

        // Write the DataDescriptor
        if (currentEntry.getMethod() != STORED) {
            curOffset += EXTHDR;
            writeLong(out, EXTSIG);
            writeLong(out, currentEntry.crc = crc.getValue());
            writeLong(out, currentEntry.compressedSize = def.getTotalOut());
            writeLong(out, currentEntry.size = def.getTotalIn());
        }
        // Update the CentralDirectory
        // http://www.pkware.com/documents/casestudies/APPNOTE.TXT
        int flags = currentEntry.getMethod() == STORED ? 0 : ZipFile.GPBF_DATA_DESCRIPTOR_FLAG;
        // Since gingerbread, we always set the UTF-8 flag on individual files.
        // Some tools insist that the central directory also have the UTF-8 flag.
        // http://code.google.com/p/android/issues/detail?id=20214
        flags |= ZipFile.GPBF_UTF8_FLAG;
        writeLong(cDir, CENSIG);
        writeShort(cDir, ZIPLocalHeaderVersionNeeded); // Version created
        writeShort(cDir, ZIPLocalHeaderVersionNeeded); // Version to extract
        writeShort(cDir, flags);
        writeShort(cDir, currentEntry.getMethod());
        writeShort(cDir, currentEntry.time);
        writeShort(cDir, currentEntry.modDate);
        writeLong(cDir, crc.getValue());
        if (currentEntry.getMethod() == DEFLATED) {
            curOffset += writeLong(cDir, def.getTotalOut());
            writeLong(cDir, def.getTotalIn());
        } else {
            curOffset += writeLong(cDir, crc.tbytes);
            writeLong(cDir, crc.tbytes);
        }
        curOffset += writeShort(cDir, nameLength);
        if (currentEntry.extra != null) {
            curOffset += writeShort(cDir, currentEntry.extra.length);
        } else {
            writeShort(cDir, 0);
        }
        String c;
        if ((c = currentEntry.getComment()) != null) {
            writeShort(cDir, c.length());
        } else {
            writeShort(cDir, 0);
        }
        writeShort(cDir, 0); // Disk Start
        writeShort(cDir, 0); // Internal File Attributes
        writeLong(cDir, 0); // External File Attributes
        writeLong(cDir, offset);
        cDir.write(nameBytes);
        nameBytes = null;
        if (currentEntry.extra != null) {
            cDir.write(currentEntry.extra);
        }
        offset += curOffset;
        if (c != null) {
            cDir.write(c.getBytes());
        }
        currentEntry = null;
        crc.reset();
        def.reset();
        done = false;
    }

    /**
     * Indicates that all entries have been written to the stream. Any terminal
     * information is written to the underlying stream.
     *
     * @throws IOException
     *             if an error occurs while terminating the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.727 -0500", hash_original_method = "999AC26E5377CA180C9B394D52C82ED1", hash_generated_method = "4679440353C04430FA42F14E1BC2AF1A")
    
@Override
    public void finish() throws IOException {
        // TODO: is there a bug here? why not checkClosed?
        if (out == null) {
            throw new IOException("Stream is closed");
        }
        if (cDir == null) {
            return;
        }
        if (entries.isEmpty()) {
            throw new ZipException("No entries");
        }
        if (currentEntry != null) {
            closeEntry();
        }
        int cdirSize = cDir.size();
        // Write Central Dir End
        writeLong(cDir, ENDSIG);
        writeShort(cDir, 0); // Disk Number
        writeShort(cDir, 0); // Start Disk
        writeShort(cDir, entries.size()); // Number of entries
        writeShort(cDir, entries.size()); // Number of entries
        writeLong(cDir, cdirSize); // Size of central dir
        writeLong(cDir, offset); // Offset of central dir
        if (comment != null) {
            writeShort(cDir, comment.length());
            cDir.write(comment.getBytes());
        } else {
            writeShort(cDir, 0);
        }
        // Write the central dir
        out.write(cDir.toByteArray());
        cDir = null;
    }

    /**
     * Writes entry information to the underlying stream. Data associated with
     * the entry can then be written using {@code write()}. After data is
     * written {@code closeEntry()} must be called to complete the writing of
     * the entry to the underlying stream.
     *
     * @param ze
     *            the {@code ZipEntry} to store.
     * @throws IOException
     *             If an error occurs storing the entry.
     * @see #write
     */
    @DSSink({DSSinkKind.IO})
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.731 -0500", hash_original_method = "B67EF5B3649AC60448D5855D166716A9", hash_generated_method = "6577F6E7EF0A9824426666CBE3AAA8F0")
    
public void putNextEntry(ZipEntry ze) throws IOException {
        if (currentEntry != null) {
            closeEntry();
        }
        if (ze.getMethod() == STORED || (compressMethod == STORED && ze.getMethod() == -1)) {
            if (ze.crc == -1) {
                throw new ZipException("CRC mismatch");
            }
            if (ze.size == -1 && ze.compressedSize == -1) {
                throw new ZipException("Size mismatch");
            }
            if (ze.size != ze.compressedSize && ze.compressedSize != -1 && ze.size != -1) {
                throw new ZipException("Size mismatch");
            }
        }
        checkClosed();
        if (entries.contains(ze.name)) {
            throw new ZipException("Entry already exists: " + ze.name);
        }
        nameBytes = ze.name.getBytes(Charsets.UTF_8);
        nameLength = nameBytes.length;
        if (nameLength > 0xffff) {
            throw new IllegalArgumentException("Name too long: " + nameLength + " UTF-8 bytes");
        }

        def.setLevel(compressLevel);
        currentEntry = ze;
        entries.add(currentEntry.name);
        if (currentEntry.getMethod() == -1) {
            currentEntry.setMethod(compressMethod);
        }

        // Local file header.
        // http://www.pkware.com/documents/casestudies/APPNOTE.TXT
        int flags = currentEntry.getMethod() == STORED ? 0 : ZipFile.GPBF_DATA_DESCRIPTOR_FLAG;
        // Java always outputs UTF-8 filenames. (Before Java 7, the RI didn't set this flag and used
        // modified UTF-8. From Java 7, it sets this flag and uses normal UTF-8.)
        flags |= ZipFile.GPBF_UTF8_FLAG;
        writeLong(out, LOCSIG); // Entry header
        writeShort(out, ZIPLocalHeaderVersionNeeded); // Extraction version
        writeShort(out, flags);
        writeShort(out, currentEntry.getMethod());
        if (currentEntry.getTime() == -1) {
            currentEntry.setTime(System.currentTimeMillis());
        }
        writeShort(out, currentEntry.time);
        writeShort(out, currentEntry.modDate);

        if (currentEntry.getMethod() == STORED) {
            if (currentEntry.size == -1) {
                currentEntry.size = currentEntry.compressedSize;
            } else if (currentEntry.compressedSize == -1) {
                currentEntry.compressedSize = currentEntry.size;
            }
            writeLong(out, currentEntry.crc);
            writeLong(out, currentEntry.size);
            writeLong(out, currentEntry.size);
        } else {
            writeLong(out, 0);
            writeLong(out, 0);
            writeLong(out, 0);
        }
        writeShort(out, nameLength);
        if (currentEntry.extra != null) {
            writeShort(out, currentEntry.extra.length);
        } else {
            writeShort(out, 0);
        }
        out.write(nameBytes);
        if (currentEntry.extra != null) {
            out.write(currentEntry.extra);
        }
    }

    /**
     * Sets the {@code ZipFile} comment associated with the file being written.
     *
     * @param comment
     *            the comment associated with the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.733 -0500", hash_original_method = "26F6FBE233DD91F24B7F1E6618FAB1E0", hash_generated_method = "88B042804CAE1ED78FA95FA980EB9F1D")
    
public void setComment(String comment) {
        if (comment.length() > 0xFFFF) {
            throw new IllegalArgumentException("Comment too long: " + comment.length() + " characters");
        }
        this.comment = comment;
    }

    /**
     * Sets the compression level to be used for writing entry data. This level
     * may be set on a per entry basis. The level must have a value between -1
     * and 8 according to the {@code Deflater} compression level bounds.
     *
     * @param level
     *            the compression level (ranging from -1 to 8).
     * @see Deflater
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.736 -0500", hash_original_method = "E1ADAA90D59796919F5AECC9DBBFDE9F", hash_generated_method = "3D27F515660FE7DC44A066174B56A084")
    
public void setLevel(int level) {
        if (level < Deflater.DEFAULT_COMPRESSION || level > Deflater.BEST_COMPRESSION) {
            throw new IllegalArgumentException();
        }
        compressLevel = level;
    }

    /**
     * Sets the compression method to be used when compressing entry data.
     * method must be one of {@code STORED} (for no compression) or {@code
     * DEFLATED}.
     *
     * @param method
     *            the compression method to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.738 -0500", hash_original_method = "6F0DCE9ECB2E8D251D145F7781DE410D", hash_generated_method = "F514476FC84EF4E7AE8BB6FD9EF494C5")
    
public void setMethod(int method) {
        if (method != STORED && method != DEFLATED) {
            throw new IllegalArgumentException();
        }
        compressMethod = method;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.741 -0500", hash_original_method = "DBE9EE31F55A33C252870BC7FED94C64", hash_generated_method = "F8C3902681C785857E2BCA2B9A763610")
    
private long writeLong(OutputStream os, long i) throws IOException {
        // Write out the long value as an unsigned int
        os.write((int) (i & 0xFF));
        os.write((int) (i >> 8) & 0xFF);
        os.write((int) (i >> 16) & 0xFF);
        os.write((int) (i >> 24) & 0xFF);
        return i;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.743 -0500", hash_original_method = "1DFA02CC93F18F84127269F34641BCA1", hash_generated_method = "BDACE10D0777C5F6A7A4C77AF4D7E1A5")
    
private int writeShort(OutputStream os, int i) throws IOException {
        os.write(i & 0xFF);
        os.write((i >> 8) & 0xFF);
        return i;
    }

    /**
     * Writes data for the current entry to the underlying stream.
     *
     * @exception IOException
     *                If an error occurs writing to the stream
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.746 -0500", hash_original_method = "F9EBE9ED855C5E2014EA6CAF53F89130", hash_generated_method = "3F4E55B962E176E96CF3299F7DB01ADA")
    
@Override
    public void write(byte[] buffer, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, byteCount);
        if (currentEntry == null) {
            throw new ZipException("No active entry");
        }

        if (currentEntry.getMethod() == STORED) {
            out.write(buffer, offset, byteCount);
        } else {
            super.write(buffer, offset, byteCount);
        }
        crc.update(buffer, offset, byteCount);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:32.748 -0500", hash_original_method = "D282356A3A75F4936D2E72EF1631ED03", hash_generated_method = "AA4B361C944BEB9349F68E04FDA5B934")
    
private void checkClosed() throws IOException {
        if (cDir == null) {
            throw new IOException("Stream is closed");
        }
    }
}

