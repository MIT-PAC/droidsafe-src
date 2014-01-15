package java.util.zip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;

import libcore.io.BufferIterator;
import libcore.io.HeapBufferIterator;
import libcore.io.Streams;
import dalvik.system.CloseGuard;

public class ZipFile implements ZipConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.308 -0500", hash_original_field = "5E14C7376EFF57EED7E931E162965942", hash_generated_field = "845771CF1327085096E285BA804AA3A7")

    static final int GPBF_DATA_DESCRIPTOR_FLAG = 1 << 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.311 -0500", hash_original_field = "F00CFA69768946574420EC34DF3CF48E", hash_generated_field = "AA1EB96D201748E5181D12EBA7874424")

    static final int GPBF_UTF8_FLAG = 1 << 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.313 -0500", hash_original_field = "AB5F58219A1BB55D87140FB529946D7F", hash_generated_field = "BDFA5188A857E38E442BEEEC9A478A22")

    public static final int OPEN_READ = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.316 -0500", hash_original_field = "22DF19D4C9DF257CD3728EDA6CDAA1FD", hash_generated_field = "9B4DAE08FD98D6BD64EFD48A6CA5D374")

    public static final int OPEN_DELETE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.318 -0500", hash_original_field = "90A7C14E9FDE747EFC2F1C95E470FF1A", hash_generated_field = "0CA74B4233F69873CB47E022D845EA81")

    private  String fileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.321 -0500", hash_original_field = "C2EBBED0D2DD3C8668837F5A2A59CAD2", hash_generated_field = "B13A9F7F3BCBF757EA8C226CB83B1836")

    private File fileToDeleteOnClose;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.323 -0500", hash_original_field = "74641A1C1F13FE91E84647C53784077C", hash_generated_field = "FB2540966EB1F635EC5558E5A5A775E6")

    private RandomAccessFile mRaf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.326 -0500", hash_original_field = "6C252FE5E279A8BB3F31EA95B50F1C86", hash_generated_field = "57A589128123E20585B6C054876EA61B")

    private final LinkedHashMap<String, ZipEntry> mEntries = new LinkedHashMap<String, ZipEntry>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.328 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * Constructs a new {@code ZipFile} with the specified file.
     *
     * @param file
     *            the file to read from.
     * @throws ZipException
     *             if a ZIP error occurs.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.331 -0500", hash_original_method = "E5AF570B733F2A8A2A3B06248A7E8835", hash_generated_method = "A59FE118065A3FA0C7A5ABC70B304A1F")
    
public ZipFile(File file) throws ZipException, IOException {
        this(file, OPEN_READ);
    }

    /**
     * Opens a file as <i>ZIP-archive</i>. "mode" must be {@code OPEN_READ} or
     * {@code OPEN_DELETE} . The latter sets the "delete on exit" flag through a
     * file.
     *
     * @param file
     *            the ZIP file to read.
     * @param mode
     *            the mode of the file open operation.
     * @throws IOException
     *             if an {@code IOException} occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.334 -0500", hash_original_method = "695CBEBB4A56BF57E24064CBD947BCB2", hash_generated_method = "2C79B1CC50B0B516BBFD8CEA7489F244")
    
public ZipFile(File file, int mode) throws IOException {
        fileName = file.getPath();
        if (mode != OPEN_READ && mode != (OPEN_READ | OPEN_DELETE)) {
            throw new IllegalArgumentException();
        }

        if ((mode & OPEN_DELETE) != 0) {
            fileToDeleteOnClose = file; // file.deleteOnExit();
        } else {
            fileToDeleteOnClose = null;
        }

        mRaf = new RandomAccessFile(fileName, "r");

        readCentralDir();
        guard.open("close");
    }

    /**
     * Opens a ZIP archived file.
     *
     * @param name
     *            the name of the ZIP file.
     * @throws IOException
     *             if an IOException occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.336 -0500", hash_original_method = "B52E22744B2B372E6DB0945A3673793A", hash_generated_method = "B4A2164E39D126E607505733A191D881")
    
public ZipFile(String name) throws IOException {
        this(new File(name), OPEN_READ);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.339 -0500", hash_original_method = "A7163D550D593B0FEEAE03A5B45C66A6", hash_generated_method = "91983752378C3E03D46CB5D4FABFFB6C")
    
@Override protected void finalize() throws IOException {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
        } finally {
            try {
                super.finalize();
            } catch (Throwable t) {
                throw new AssertionError(t);
            }
        }
    }

    /**
     * Closes this ZIP file. This method is idempotent.
     *
     * @throws IOException
     *             if an IOException occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.342 -0500", hash_original_method = "B3BE4D570FA623471DB2047631197E6D", hash_generated_method = "F3FD63ABD3BE3678AF17069F54E5D0D5")
    
public void close() throws IOException {
        guard.close();
        RandomAccessFile raf = mRaf;

        if (raf != null) { // Only close initialized instances
            synchronized(raf) {
                mRaf = null;
                raf.close();
            }
            if (fileToDeleteOnClose != null) {
                fileToDeleteOnClose.delete();
                fileToDeleteOnClose = null;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.344 -0500", hash_original_method = "65CE3BC8A7A8514DBA7266C40E446CDF", hash_generated_method = "0ABE44428065F87931C5CB51E7EBB164")
    
private void checkNotClosed() {
        if (mRaf == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.805 -0400", hash_original_method = "C7A9A4F6B932FEDB0ECC5AECA323DFC1", hash_generated_method = "6F769368C927136E5DA2F396F24B94E5")
    public Enumeration<? extends ZipEntry> entries() {
        checkNotClosed();
        final Iterator<ZipEntry> iterator = mEntries.values().iterator();
Enumeration<? extends ZipEntry> var5C2492AEF6429BB2452507D2F1DD320A_330051403 =         new Enumeration<ZipEntry>() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.347 -0500", hash_original_method = "E86ACDCD19145E338744AC3C77C30364", hash_generated_method = "37CEFC45DE5D1AD01FCD8DB0138E5F1F")
            
public boolean hasMoreElements() {
                checkNotClosed();
                return iterator.hasNext();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.349 -0500", hash_original_method = "0AFF9A2DED00798BA27B7711FA7E95F7", hash_generated_method = "D79A666F419DCD9B04F294A5770B2CDB")
            
public ZipEntry nextElement() {
                checkNotClosed();
                return iterator.next();
            }
};
        var5C2492AEF6429BB2452507D2F1DD320A_330051403.addTaint(taint);
        return var5C2492AEF6429BB2452507D2F1DD320A_330051403;
        // ---------- Original Method ----------
        //checkNotClosed();
        //final Iterator<ZipEntry> iterator = mEntries.values().iterator();
        //return new Enumeration<ZipEntry>() {
            //public boolean hasMoreElements() {
                //checkNotClosed();
                //return iterator.hasNext();
            //}
            //public ZipEntry nextElement() {
                //checkNotClosed();
                //return iterator.next();
            //}
        //};
    }

    /**
     * Gets the ZIP entry with the specified name from this {@code ZipFile}.
     *
     * @param entryName
     *            the name of the entry in the ZIP file.
     * @return a {@code ZipEntry} or {@code null} if the entry name does not
     *         exist in the ZIP file.
     * @throws IllegalStateException if this ZIP file has been closed.
     */
    @DSComment("zip/io")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.354 -0500", hash_original_method = "D382D29E599C910662BB0F89A97F218A", hash_generated_method = "955202DE1AF533EEDFC3BBFC49E0D4E8")
    
public ZipEntry getEntry(String entryName) {
        checkNotClosed();
        if (entryName == null) {
            throw new NullPointerException();
        }

        ZipEntry ze = mEntries.get(entryName);
        if (ze == null) {
            ze = mEntries.get(entryName + "/");
        }
        return ze;
    }
    
    static class RAFStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.369 -0500", hash_original_field = "9A517EC1A66B8BABFBEC36F04F6D50E9", hash_generated_field = "9A517EC1A66B8BABFBEC36F04F6D50E9")

        RandomAccessFile mSharedRaf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.372 -0500", hash_original_field = "404D538D7C85388778B668910857AE1E", hash_generated_field = "404D538D7C85388778B668910857AE1E")

        long mOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.374 -0500", hash_original_field = "CAB3DDEC49B3F58AA21EC9312CA21C26", hash_generated_field = "CAB3DDEC49B3F58AA21EC9312CA21C26")

        long mLength;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.376 -0500", hash_original_method = "7566C7D40BAC719393DA5AE2730758DD", hash_generated_method = "3D829B32035C82BD94C8A02EB9B0B3EC")
        
public RAFStream(RandomAccessFile raf, long pos) throws IOException {
            mSharedRaf = raf;
            mOffset = pos;
            mLength = raf.length();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.379 -0500", hash_original_method = "EBB90581A10714B3978F18E12312CB3A", hash_generated_method = "BE241658E106D1C9658EA6A6AA2DAED2")
        
@Override public int available() throws IOException {
            return (mOffset < mLength ? 1 : 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.381 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "259E44B8B64C1FF49A2A2EC42CFB5CBE")
        
@Override public int read() throws IOException {
            return Streams.readSingleByte(this);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.384 -0500", hash_original_method = "EF568FF768F81FE11A38286E6FDCB2E1", hash_generated_method = "912659AC21D2D46002DC681A847896FF")
        
@Override public int read(byte[] b, int off, int len) throws IOException {
            synchronized (mSharedRaf) {
                mSharedRaf.seek(mOffset);
                if (len > mLength - mOffset) {
                    len = (int) (mLength - mOffset);
                }
                int count = mSharedRaf.read(b, off, len);
                if (count > 0) {
                    mOffset += count;
                    return count;
                } else {
                    return -1;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.387 -0500", hash_original_method = "62A626F8A4A0AABE786C23986D3622F2", hash_generated_method = "9E51DF3BA712F2D239DDA032E36B00E3")
        
@Override
        public long skip(long byteCount) throws IOException {
            if (byteCount > mLength - mOffset) {
                byteCount = mLength - mOffset;
            }
            mOffset += byteCount;
            return byteCount;
        }
        
    }
    
    static class ZipInflaterInputStream extends InflaterInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.392 -0500", hash_original_field = "6ABF0A573F6A71AB8AAE237EF7DCBFD4", hash_generated_field = "6ABF0A573F6A71AB8AAE237EF7DCBFD4")

        ZipEntry entry;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.394 -0500", hash_original_field = "B454E81C25A392A63976B59EF20BFDA7", hash_generated_field = "B454E81C25A392A63976B59EF20BFDA7")

        long bytesRead = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.397 -0500", hash_original_method = "7042D9D65A5773117A52B7582FC64EEF", hash_generated_method = "BD88FAF2D943047DBA2947877E90587A")
        
public ZipInflaterInputStream(InputStream is, Inflater inf, int bsize, ZipEntry entry) {
            super(is, inf, bsize);
            this.entry = entry;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.399 -0500", hash_original_method = "8B6BFDD773126A0A7B62B959FA690E20", hash_generated_method = "CB8B792E53A780626A66D4303BC50012")
        
@Override
        public int read(byte[] buffer, int off, int nbytes) throws IOException {
            int i = super.read(buffer, off, nbytes);
            if (i != -1) {
                bytesRead += i;
            }
            return i;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.402 -0500", hash_original_method = "67EB7FFE4182D11E188F79FFA477AD5D", hash_generated_method = "C2E4F4B0D9E6472209109F7183ECDDAF")
        
@Override
        public int available() throws IOException {
            if (closed) {
                // Our superclass will throw an exception, but there's a jtreg test that
                // explicitly checks that the InputStream returned from ZipFile.getInputStream
                // returns 0 even when closed.
                return 0;
            }
            return super.available() == 0 ? 0 : (int) (entry.getSize() - bytesRead);
        }
        
    }

    /**
     * Returns an input stream on the data of the specified {@code ZipEntry}.
     *
     * @param entry
     *            the ZipEntry.
     * @return an input stream of the data contained in the {@code ZipEntry}.
     * @throws IOException
     *             if an {@code IOException} occurs.
     * @throws IllegalStateException if this ZIP file has been closed.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.358 -0500", hash_original_method = "B69421FB9318C1ABE9ECEEB1DD311069", hash_generated_method = "8EAC736ACC17C5ECCFFF65C0A3EE6FFC")
    
public InputStream getInputStream(ZipEntry entry) throws IOException {
        // Make sure this ZipEntry is in this Zip file.  We run it through the name lookup.
        entry = getEntry(entry.getName());
        if (entry == null) {
            return null;
        }

        // Create an InputStream at the right part of the file.
        RandomAccessFile raf = mRaf;
        synchronized (raf) {
            // We don't know the entry data's start position. All we have is the
            // position of the entry's local header. At position 28 we find the
            // length of the extra data. In some cases this length differs from
            // the one coming in the central header.
            RAFStream rafstrm = new RAFStream(raf, entry.mLocalHeaderRelOffset + 28);
            DataInputStream is = new DataInputStream(rafstrm);
            int localExtraLenOrWhatever = Short.reverseBytes(is.readShort());
            is.close();

            // Skip the name and this "extra" data or whatever it is:
            rafstrm.skip(entry.nameLength + localExtraLenOrWhatever);
            rafstrm.mLength = rafstrm.mOffset + entry.compressedSize;
            if (entry.compressionMethod == ZipEntry.DEFLATED) {
                int bufSize = Math.max(1024, (int)Math.min(entry.getSize(), 65535L));
                return new ZipInflaterInputStream(rafstrm, new Inflater(true), bufSize, entry);
            } else {
                return rafstrm;
            }
        }
    }

    /**
     * Gets the file name of this {@code ZipFile}.
     *
     * @return the file name of this {@code ZipFile}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.360 -0500", hash_original_method = "16A0E81CED7078E4D61B7DA2166E122D", hash_generated_method = "61220CBF47CC3FDA292F55A4F9600680")
    
public String getName() {
        return fileName;
    }

    /**
     * Returns the number of {@code ZipEntries} in this {@code ZipFile}.
     *
     * @return the number of entries in this file.
     * @throws IllegalStateException if this ZIP file has been closed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.362 -0500", hash_original_method = "E69009FC6775A108297426EEDE85C8D2", hash_generated_method = "0CE53E5E0854D6AA9EFCF01C86339827")
    
public int size() {
        checkNotClosed();
        return mEntries.size();
    }

    /**
     * Find the central directory and read the contents.
     *
     * <p>The central directory can be followed by a variable-length comment
     * field, so we have to scan through it backwards.  The comment is at
     * most 64K, plus we have 18 bytes for the end-of-central-dir stuff
     * itself, plus apparently sometimes people throw random junk on the end
     * just for the fun of it.
     *
     * <p>This is all a little wobbly.  If the wrong value ends up in the EOCD
     * area, we're hosed. This appears to be the way that everybody handles
     * it though, so we're in good company if this fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:31.365 -0500", hash_original_method = "C4C5F4E81B860F4CAE8325550F47061B", hash_generated_method = "E1B44FC98B1B9EEE86046AB5EFD43859")
    
private void readCentralDir() throws IOException {
        /*
         * Scan back, looking for the End Of Central Directory field.  If
         * the archive doesn't have a comment, we'll hit it on the first
         * try.
         *
         * No need to synchronize mRaf here -- we only do this when we
         * first open the Zip file.
         */
        long scanOffset = mRaf.length() - ENDHDR;
        if (scanOffset < 0) {
            throw new ZipException("too short to be Zip");
        }

        long stopOffset = scanOffset - 65536;
        if (stopOffset < 0) {
            stopOffset = 0;
        }

        final int ENDHEADERMAGIC = 0x06054b50;
        while (true) {
            mRaf.seek(scanOffset);
            if (Integer.reverseBytes(mRaf.readInt()) == ENDHEADERMAGIC) {
                break;
            }

            scanOffset--;
            if (scanOffset < stopOffset) {
                throw new ZipException("EOCD not found; not a Zip archive?");
            }
        }

        // Read the End Of Central Directory. We could use ENDHDR instead of the magic number 18,
        // but we don't actually need all the header.
        byte[] eocd = new byte[18];
        mRaf.readFully(eocd);

        // Pull out the information we need.
        BufferIterator it = HeapBufferIterator.iterator(eocd, 0, eocd.length, ByteOrder.LITTLE_ENDIAN);
        short diskNumber = it.readShort();
        short diskWithCentralDir = it.readShort();
        short numEntries = it.readShort();
        short totalNumEntries = it.readShort();
        it.skip(4); // Ignore centralDirSize.
        int centralDirOffset = it.readInt();

        if (numEntries != totalNumEntries || diskNumber != 0 || diskWithCentralDir != 0) {
            throw new ZipException("spanned archives not supported");
        }

        // Seek to the first CDE and read all entries.
        RAFStream rafs = new RAFStream(mRaf, centralDirOffset);
        BufferedInputStream bin = new BufferedInputStream(rafs, 4096);
        byte[] hdrBuf = new byte[CENHDR]; // Reuse the same buffer for each entry.
        for (int i = 0; i < numEntries; ++i) {
            ZipEntry newEntry = new ZipEntry(hdrBuf, bin);
            mEntries.put(newEntry.getName(), newEntry);
        }
    }
}

