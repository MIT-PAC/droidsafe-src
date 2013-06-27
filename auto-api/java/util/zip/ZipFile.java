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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.933 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "0CA74B4233F69873CB47E022D845EA81")

    private String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.933 -0400", hash_original_field = "043B1F7CF119742EC4CEE56509E60C5D", hash_generated_field = "B13A9F7F3BCBF757EA8C226CB83B1836")

    private File fileToDeleteOnClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.934 -0400", hash_original_field = "0345BD970021D77DF594F2A9A089C562", hash_generated_field = "FB2540966EB1F635EC5558E5A5A775E6")

    private RandomAccessFile mRaf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.934 -0400", hash_original_field = "E710FE3D4B0A45908BA4536F88014F9F", hash_generated_field = "5A4692F4FCA863663FF38DD8A4906E7A")

    private LinkedHashMap<String, ZipEntry> mEntries = new LinkedHashMap<String, ZipEntry>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.934 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.936 -0400", hash_original_method = "E5AF570B733F2A8A2A3B06248A7E8835", hash_generated_method = "7FF8C445EEAE9F6173828CE6C2A55791")
    public  ZipFile(File file) throws ZipException, IOException {
        this(file, OPEN_READ);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.943 -0400", hash_original_method = "695CBEBB4A56BF57E24064CBD947BCB2", hash_generated_method = "55F18A6B50CAC8A2D2B4E7B98996B909")
    public  ZipFile(File file, int mode) throws IOException {
        fileName = file.getPath();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        {
            fileToDeleteOnClose = file;
        } //End block
        {
            fileToDeleteOnClose = null;
        } //End block
        mRaf = new RandomAccessFile(fileName, "r");
        readCentralDir();
        guard.open("close");
        addTaint(mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.944 -0400", hash_original_method = "B52E22744B2B372E6DB0945A3673793A", hash_generated_method = "EB73949118A9F8074498F5187BFD63BB")
    public  ZipFile(String name) throws IOException {
        this(new File(name), OPEN_READ);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.945 -0400", hash_original_method = "A7163D550D593B0FEEAE03A5B45C66A6", hash_generated_method = "38ACD8B2C26D452DA657D172547FF32A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.954 -0400", hash_original_method = "B3BE4D570FA623471DB2047631197E6D", hash_generated_method = "C20FC52BB46C9DC30918CCBF38AD6C23")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.957 -0400", hash_original_method = "65CE3BC8A7A8514DBA7266C40E446CDF", hash_generated_method = "5B1AAF2E45FF011BE251609E7D79CEC6")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Zip file closed");
        } //End block
        // ---------- Original Method ----------
        //if (mRaf == null) {
            //throw new IllegalStateException("Zip file closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.967 -0400", hash_original_method = "C7A9A4F6B932FEDB0ECC5AECA323DFC1", hash_generated_method = "F29A27BD476F471B2360847DCD388A21")
    public Enumeration<? extends ZipEntry> entries() {
        Enumeration<? extends ZipEntry> varB4EAC82CA7396A68D541C85D26508E83_121801728 = null; //Variable for return #1
        checkNotClosed();
        Iterator<ZipEntry> iterator;
        iterator = mEntries.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_121801728 = new Enumeration<ZipEntry>() {
            public boolean hasMoreElements() {
                checkNotClosed();
                return iterator.hasNext();
            }
            public ZipEntry nextElement() {
                checkNotClosed();
                return iterator.next();
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_121801728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_121801728;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.968 -0400", hash_original_method = "D382D29E599C910662BB0F89A97F218A", hash_generated_method = "3BE5B3697851CF45E11B1F2F2109C05B")
    public ZipEntry getEntry(String entryName) {
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_107375992 = null; //Variable for return #1
        checkNotClosed();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        ZipEntry ze;
        ze = mEntries.get(entryName);
        {
            ze = mEntries.get(entryName + "/");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_107375992 = ze;
        addTaint(entryName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_107375992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107375992;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.976 -0400", hash_original_method = "B69421FB9318C1ABE9ECEEB1DD311069", hash_generated_method = "5671E84AE068555EF82C6EB494C83C53")
    public InputStream getInputStream(ZipEntry entry) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1021431406 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1686084027 = null; //Variable for return #2
        InputStream varB4EAC82CA7396A68D541C85D26508E83_273240538 = null; //Variable for return #3
        entry = getEntry(entry.getName());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1021431406 = null;
        } //End block
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
                varB4EAC82CA7396A68D541C85D26508E83_1686084027 = new ZipInflaterInputStream(rafstrm, new Inflater(true), bufSize, entry);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_273240538 = rafstrm;
            } //End block
        } //End block
        addTaint(entry.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_1628369567; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1628369567 = varB4EAC82CA7396A68D541C85D26508E83_1021431406;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1628369567 = varB4EAC82CA7396A68D541C85D26508E83_1686084027;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1628369567 = varB4EAC82CA7396A68D541C85D26508E83_273240538;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1628369567.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1628369567;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.997 -0400", hash_original_method = "16A0E81CED7078E4D61B7DA2166E122D", hash_generated_method = "A0AE0820B3951924C39450C2EB2C63F4")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1242824068 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242824068 = fileName;
        varB4EAC82CA7396A68D541C85D26508E83_1242824068.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242824068;
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.997 -0400", hash_original_method = "E69009FC6775A108297426EEDE85C8D2", hash_generated_method = "51CE747E5BB5041C36F5A8B47001F7DC")
    public int size() {
        checkNotClosed();
        int var85B557D4654E88618B8057DD0AFCFFDA_654396398 = (mEntries.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635082685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_635082685;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return mEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.000 -0400", hash_original_method = "C4C5F4E81B860F4CAE8325550F47061B", hash_generated_method = "4A52F9348CA328F11D12C0BEF2C56B2B")
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
                boolean var4ED9CF7268BDF0C528752A1A4EA7FC4F_2125245017 = (Integer.reverseBytes(mRaf.readInt()) == ENDHEADERMAGIC);
            } //End collapsed parenthetic
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.000 -0400", hash_original_field = "51458950B7F230500F7285BEDBF5164C", hash_generated_field = "9A517EC1A66B8BABFBEC36F04F6D50E9")

        RandomAccessFile mSharedRaf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.000 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "404D538D7C85388778B668910857AE1E")

        long mOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.000 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "CAB3DDEC49B3F58AA21EC9312CA21C26")

        long mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.014 -0400", hash_original_method = "7566C7D40BAC719393DA5AE2730758DD", hash_generated_method = "C054BC53EF56F04CAC7E1CE72B1B499D")
        public  RAFStream(RandomAccessFile raf, long pos) throws IOException {
            mSharedRaf = raf;
            mOffset = pos;
            mLength = raf.length();
            // ---------- Original Method ----------
            //mSharedRaf = raf;
            //mOffset = pos;
            //mLength = raf.length();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.015 -0400", hash_original_method = "EBB90581A10714B3978F18E12312CB3A", hash_generated_method = "06B97C29A499090E630141095F2B4E45")
        @Override
        public int available() throws IOException {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419932379 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1419932379;
            // ---------- Original Method ----------
            //return (mOffset < mLength ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.015 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "6D62AF762033C5B51BA64DD0FFB3CB5C")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_1650538909 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303685794 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303685794;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.016 -0400", hash_original_method = "EF568FF768F81FE11A38286E6FDCB2E1", hash_generated_method = "FF43A85E1D5EA85EE23D873337BFF030")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
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
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94287129 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_94287129;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.016 -0400", hash_original_method = "62A626F8A4A0AABE786C23986D3622F2", hash_generated_method = "F2CFE771CB45D88C2EE7F90A3129D529")
        @Override
        public long skip(long byteCount) throws IOException {
            {
                byteCount = mLength - mOffset;
            } //End block
            mOffset += byteCount;
            long var0F5264038205EDFB1AC05FBB0E8C5E94_90465477 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_90465477;
            // ---------- Original Method ----------
            //if (byteCount > mLength - mOffset) {
                //byteCount = mLength - mOffset;
            //}
            //mOffset += byteCount;
            //return byteCount;
        }

        
    }


    
    static class ZipInflaterInputStream extends InflaterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.017 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "6ABF0A573F6A71AB8AAE237EF7DCBFD4")

        ZipEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.017 -0400", hash_original_field = "7D8F20515DCE7127CFD8808A1B0CF74F", hash_generated_field = "B454E81C25A392A63976B59EF20BFDA7")

        long bytesRead = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.017 -0400", hash_original_method = "7042D9D65A5773117A52B7582FC64EEF", hash_generated_method = "CA8D4335C37585B0DC1FBFEA29B1A020")
        public  ZipInflaterInputStream(InputStream is, Inflater inf, int bsize, ZipEntry entry) {
            super(is, inf, bsize);
            this.entry = entry;
            addTaint(is.getTaint());
            addTaint(inf.getTaint());
            addTaint(bsize);
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.018 -0400", hash_original_method = "8B6BFDD773126A0A7B62B959FA690E20", hash_generated_method = "59C9C0C847BFC383A35815D6F9453775")
        @Override
        public int read(byte[] buffer, int off, int nbytes) throws IOException {
            int i;
            i = super.read(buffer, off, nbytes);
            {
                bytesRead += i;
            } //End block
            addTaint(buffer[0]);
            addTaint(off);
            addTaint(nbytes);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150767581 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_150767581;
            // ---------- Original Method ----------
            //int i = super.read(buffer, off, nbytes);
            //if (i != -1) {
                //bytesRead += i;
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.019 -0400", hash_original_method = "67EB7FFE4182D11E188F79FFA477AD5D", hash_generated_method = "69D566F9A519E849A1F24ECB84C4FD58")
        @Override
        public int available() throws IOException {
            {
                boolean varB468C57145781459693BA514A4AED697_415908734 = (super.available() == 0);
                Object var4F59783E13CE810BB8A4B691B940F808_1574662076 = ((int) (entry.getSize() - bytesRead));
            } //End flattened ternary
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795762790 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795762790;
            // ---------- Original Method ----------
            //if (closed) {
                //return 0;
            //}
            //return super.available() == 0 ? 0 : (int) (entry.getSize() - bytesRead);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.019 -0400", hash_original_field = "6B342FB26FF70384E471C5CA8CA6EA4B", hash_generated_field = "4F81282A23F2B459589EA4A53447C524")

    static int GPBF_DATA_DESCRIPTOR_FLAG = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.019 -0400", hash_original_field = "6EB4A05860AC086267F3018BA4960053", hash_generated_field = "300DBC8E45E5ADA6EF2339783DDC5284")

    static int GPBF_UTF8_FLAG = 1 << 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.019 -0400", hash_original_field = "2030CB3C49CDD31F6DC1BA26C647D874", hash_generated_field = "BDFA5188A857E38E442BEEEC9A478A22")

    public static final int OPEN_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.031 -0400", hash_original_field = "E60E95A92B8D974A47D037335C4C9DC7", hash_generated_field = "9B4DAE08FD98D6BD64EFD48A6CA5D374")

    public static final int OPEN_DELETE = 4;
}

