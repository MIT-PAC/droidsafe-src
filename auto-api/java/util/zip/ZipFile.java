package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import java.io.BufferedInputStream;
import java.io.EOFException;
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

public class ZipFile implements ZipConstants {
    static int GPBF_DATA_DESCRIPTOR_FLAG = 1 << 3;
    static int GPBF_UTF8_FLAG = 1 << 11;
    public static int OPEN_READ = 1;
    public static int OPEN_DELETE = 4;
    private String fileName;
    private File fileToDeleteOnClose;
    private RandomAccessFile mRaf;
    private LinkedHashMap<String, ZipEntry> mEntries = new LinkedHashMap<String, ZipEntry>();
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.009 -0400", hash_original_method = "E5AF570B733F2A8A2A3B06248A7E8835", hash_generated_method = "909E8745D51490F40F0C766D228AB36B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZipFile(File file) throws ZipException, IOException {
        this(file, OPEN_READ);
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.012 -0400", hash_original_method = "695CBEBB4A56BF57E24064CBD947BCB2", hash_generated_method = "43CEACCCE2566204C869DEB0CB412E84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZipFile(File file, int mode) throws IOException {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(mode);
        fileName = file.getPath();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            fileToDeleteOnClose = null;
        } //End block
        mRaf = new RandomAccessFile(fileName, "r");
        readCentralDir();
        guard.open("close");
        // ---------- Original Method ----------
        //fileName = file.getPath();
        //if (mode != OPEN_READ && mode != (OPEN_READ | OPEN_DELETE)) {
            //throw new IllegalArgumentException();
        //}
        //if ((mode & OPEN_DELETE) != 0) {
            //fileToDeleteOnClose = file; 
        //} else {
            //fileToDeleteOnClose = null;
        //}
        //mRaf = new RandomAccessFile(fileName, "r");
        //readCentralDir();
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.014 -0400", hash_original_method = "B52E22744B2B372E6DB0945A3673793A", hash_generated_method = "77B94B8160DBEA28F42063931B5F223B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZipFile(String name) throws IOException {
        this(new File(name), OPEN_READ);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.016 -0400", hash_original_method = "A7163D550D593B0FEEAE03A5B45C66A6", hash_generated_method = "2665581E18922190BAE145ED8B515C5E")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws IOException {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
        } //End block
        finally 
        {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(t);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
        //} finally {
            //try {
                //super.finalize();
            //} catch (Throwable t) {
                //throw new AssertionError(t);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.030 -0400", hash_original_method = "B3BE4D570FA623471DB2047631197E6D", hash_generated_method = "7DB3C0B324F3AB220F9A636D44076A3E")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        guard.close();
        RandomAccessFile raf;
        raf = mRaf;
        {
            {
                mRaf = null;
                raf.close();
            } //End block
            {
                fileToDeleteOnClose.delete();
                fileToDeleteOnClose = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //guard.close();
        //RandomAccessFile raf = mRaf;
        //if (raf != null) { 
            //synchronized(raf) {
                //mRaf = null;
                //raf.close();
            //}
            //if (fileToDeleteOnClose != null) {
                //fileToDeleteOnClose.delete();
                //fileToDeleteOnClose = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.034 -0400", hash_original_method = "65CE3BC8A7A8514DBA7266C40E446CDF", hash_generated_method = "66A74AA20B312C41EBF5D0042DA40D79")
    @DSModeled(DSC.SAFE)
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Zip file closed");
        } //End block
        // ---------- Original Method ----------
        //if (mRaf == null) {
            //throw new IllegalStateException("Zip file closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.040 -0400", hash_original_method = "C7A9A4F6B932FEDB0ECC5AECA323DFC1", hash_generated_method = "7F5D95F408EFD7141ED29416AB01374E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<? extends ZipEntry> entries() {
        checkNotClosed();
        Iterator<ZipEntry> iterator;
        iterator = mEntries.values().iterator();
        return (Enumeration<? extends ZipEntry>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.044 -0400", hash_original_method = "D382D29E599C910662BB0F89A97F218A", hash_generated_method = "89B2487373899DF9BAD1C0C5698E5E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ZipEntry getEntry(String entryName) {
        dsTaint.addTaint(entryName);
        checkNotClosed();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        ZipEntry ze;
        ze = mEntries.get(entryName);
        {
            ze = mEntries.get(entryName + "/");
        } //End block
        return (ZipEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (entryName == null) {
            //throw new NullPointerException();
        //}
        //ZipEntry ze = mEntries.get(entryName);
        //if (ze == null) {
            //ze = mEntries.get(entryName + "/");
        //}
        //return ze;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.049 -0400", hash_original_method = "B69421FB9318C1ABE9ECEEB1DD311069", hash_generated_method = "D09F3FC9513F47CEDBE7C1472DB3C122")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream(ZipEntry entry) throws IOException {
        dsTaint.addTaint(entry.dsTaint);
        entry = getEntry(entry.getName());
        RandomAccessFile raf;
        raf = mRaf;
        {
            RAFStream rafstrm;
            rafstrm = new RAFStream(raf, entry.mLocalHeaderRelOffset + 28);
            DataInputStream is;
            is = new DataInputStream(rafstrm);
            int localExtraLenOrWhatever;
            localExtraLenOrWhatever = Short.reverseBytes(is.readShort());
            is.close();
            rafstrm.skip(entry.nameLength + localExtraLenOrWhatever);
            rafstrm.mLength = rafstrm.mOffset + entry.compressedSize;
            {
                int bufSize;
                bufSize = Math.max(1024, (int)Math.min(entry.getSize(), 65535L));
            } //End block
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.051 -0400", hash_original_method = "16A0E81CED7078E4D61B7DA2166E122D", hash_generated_method = "BF6CD224084C2641505C7E96A108E4CA")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.053 -0400", hash_original_method = "E69009FC6775A108297426EEDE85C8D2", hash_generated_method = "DF7283CF8EB0C6C17D255D87993FBA88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        checkNotClosed();
        int var85B557D4654E88618B8057DD0AFCFFDA_700595402 = (mEntries.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkNotClosed();
        //return mEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.072 -0400", hash_original_method = "C4C5F4E81B860F4CAE8325550F47061B", hash_generated_method = "A480AB8591A77EFB2898652F27F588B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readCentralDir() throws IOException {
        long scanOffset;
        scanOffset = mRaf.length() - ENDHDR;
        {
            if (DroidSafeAndroidRuntime.control) throw new ZipException("too short to be Zip");
        } //End block
        long stopOffset;
        stopOffset = scanOffset - 65536;
        {
            stopOffset = 0;
        } //End block
        int ENDHEADERMAGIC;
        ENDHEADERMAGIC = 0x06054b50;
        {
            mRaf.seek(scanOffset);
            {
                boolean var4ED9CF7268BDF0C528752A1A4EA7FC4F_227109912 = (Integer.reverseBytes(mRaf.readInt()) == ENDHEADERMAGIC);
            } //End collapsed parenthetic
            scanOffset--;
            {
                if (DroidSafeAndroidRuntime.control) throw new ZipException("EOCD not found; not a Zip archive?");
            } //End block
        } //End block
        byte[] eocd;
        eocd = new byte[18];
        mRaf.readFully(eocd);
        BufferIterator it;
        it = HeapBufferIterator.iterator(eocd, 0, eocd.length, ByteOrder.LITTLE_ENDIAN);
        short diskNumber;
        diskNumber = it.readShort();
        short diskWithCentralDir;
        diskWithCentralDir = it.readShort();
        short numEntries;
        numEntries = it.readShort();
        short totalNumEntries;
        totalNumEntries = it.readShort();
        it.skip(4);
        int centralDirOffset;
        centralDirOffset = it.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new ZipException("spanned archives not supported");
        } //End block
        RAFStream rafs;
        rafs = new RAFStream(mRaf, centralDirOffset);
        BufferedInputStream bin;
        bin = new BufferedInputStream(rafs, 4096);
        byte[] hdrBuf;
        hdrBuf = new byte[CENHDR];
        {
            int i;
            i = 0;
            {
                ZipEntry newEntry;
                newEntry = new ZipEntry(hdrBuf, bin);
                mEntries.put(newEntry.getName(), newEntry);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class RAFStream extends InputStream {
        RandomAccessFile mSharedRaf;
        long mOffset;
        long mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.080 -0400", hash_original_method = "7566C7D40BAC719393DA5AE2730758DD", hash_generated_method = "46C49533F7F1C3E1ADC05E3D63A902B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RAFStream(RandomAccessFile raf, long pos) throws IOException {
            dsTaint.addTaint(raf.dsTaint);
            dsTaint.addTaint(pos);
            mLength = raf.length();
            // ---------- Original Method ----------
            //mSharedRaf = raf;
            //mOffset = pos;
            //mLength = raf.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.085 -0400", hash_original_method = "EBB90581A10714B3978F18E12312CB3A", hash_generated_method = "EBA86B979B53C7FD3AD90F5105AC296E")
        @DSModeled(DSC.SAFE)
        @Override
        public int available() throws IOException {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (mOffset < mLength ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.088 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "2FE5ED9FA9930711DEC7A5E179389BF3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_706555497 = (Streams.readSingleByte(this));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.101 -0400", hash_original_method = "EF568FF768F81FE11A38286E6FDCB2E1", hash_generated_method = "DBBD83324BB35D16D76894763BAC829E")
        @DSModeled(DSC.SAFE)
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            dsTaint.addTaint(b);
            dsTaint.addTaint(off);
            dsTaint.addTaint(len);
            {
                mSharedRaf.seek(mOffset);
                {
                    len = (int) (mLength - mOffset);
                } //End block
                int count;
                count = mSharedRaf.read(b, off, len);
                {
                    mOffset += count;
                } //End block
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (mSharedRaf) {
                //mSharedRaf.seek(mOffset);
                //if (len > mLength - mOffset) {
                    //len = (int) (mLength - mOffset);
                //}
                //int count = mSharedRaf.read(b, off, len);
                //if (count > 0) {
                    //mOffset += count;
                    //return count;
                //} else {
                    //return -1;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.105 -0400", hash_original_method = "62A626F8A4A0AABE786C23986D3622F2", hash_generated_method = "4B8405EDAEDC43740E5FEAA47E548F84")
        @DSModeled(DSC.SAFE)
        @Override
        public long skip(long byteCount) throws IOException {
            dsTaint.addTaint(byteCount);
            {
                byteCount = mLength - mOffset;
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (byteCount > mLength - mOffset) {
                //byteCount = mLength - mOffset;
            //}
            //mOffset += byteCount;
            //return byteCount;
        }

        
    }


    
    static class ZipInflaterInputStream extends InflaterInputStream {
        ZipEntry entry;
        long bytesRead = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.109 -0400", hash_original_method = "7042D9D65A5773117A52B7582FC64EEF", hash_generated_method = "6F75298E182DDF3C08F18584CFED6FB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ZipInflaterInputStream(InputStream is, Inflater inf, int bsize, ZipEntry entry) {
            super(is, inf, bsize);
            dsTaint.addTaint(is.dsTaint);
            dsTaint.addTaint(bsize);
            dsTaint.addTaint(entry.dsTaint);
            dsTaint.addTaint(inf.dsTaint);
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.111 -0400", hash_original_method = "8B6BFDD773126A0A7B62B959FA690E20", hash_generated_method = "02EF2E4CF9BD9663AACFF14A6968E3EF")
        @DSModeled(DSC.SAFE)
        @Override
        public int read(byte[] buffer, int off, int nbytes) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(nbytes);
            dsTaint.addTaint(off);
            int i;
            i = super.read(buffer, off, nbytes);
            {
                bytesRead += i;
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int i = super.read(buffer, off, nbytes);
            //if (i != -1) {
                //bytesRead += i;
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:37:19.121 -0400", hash_original_method = "67EB7FFE4182D11E188F79FFA477AD5D", hash_generated_method = "597F31ADF73311B6F21D650CB4F3F1EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            {
                boolean varB468C57145781459693BA514A4AED697_26369449 = (super.available() == 0);
                Object var4F59783E13CE810BB8A4B691B940F808_272406425 = ((int) (entry.getSize() - bytesRead));
            } //End flattened ternary
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (closed) {
                //return 0;
            //}
            //return super.available() == 0 ? 0 : (int) (entry.getSize() - bytesRead);
        }

        
    }


    
}


