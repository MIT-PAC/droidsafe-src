package java.util.zip;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "0CA74B4233F69873CB47E022D845EA81")

    private String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_field = "043B1F7CF119742EC4CEE56509E60C5D", hash_generated_field = "B13A9F7F3BCBF757EA8C226CB83B1836")

    private File fileToDeleteOnClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_field = "0345BD970021D77DF594F2A9A089C562", hash_generated_field = "FB2540966EB1F635EC5558E5A5A775E6")

    private RandomAccessFile mRaf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_field = "E710FE3D4B0A45908BA4536F88014F9F", hash_generated_field = "57A589128123E20585B6C054876EA61B")

    private final LinkedHashMap<String, ZipEntry> mEntries = new LinkedHashMap<String, ZipEntry>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.933 -0400", hash_original_method = "E5AF570B733F2A8A2A3B06248A7E8835", hash_generated_method = "7FF8C445EEAE9F6173828CE6C2A55791")
    public  ZipFile(File file) throws ZipException, IOException {
        this(file, OPEN_READ);
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.934 -0400", hash_original_method = "695CBEBB4A56BF57E24064CBD947BCB2", hash_generated_method = "55F18A6B50CAC8A2D2B4E7B98996B909")
    public  ZipFile(File file, int mode) throws IOException {
        fileName = file.getPath();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        {
            fileToDeleteOnClose = file;
        } 
        {
            fileToDeleteOnClose = null;
        } 
        mRaf = new RandomAccessFile(fileName, "r");
        readCentralDir();
        guard.open("close");
        addTaint(mode);
        
        
        
            
        
        
            
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.934 -0400", hash_original_method = "B52E22744B2B372E6DB0945A3673793A", hash_generated_method = "EB73949118A9F8074498F5187BFD63BB")
    public  ZipFile(String name) throws IOException {
        this(new File(name), OPEN_READ);
        addTaint(name.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.934 -0400", hash_original_method = "A7163D550D593B0FEEAE03A5B45C66A6", hash_generated_method = "38ACD8B2C26D452DA657D172547FF32A")
    @Override
    protected void finalize() throws IOException {
        try 
        {
            {
                guard.warnIfOpen();
            } 
        } 
        finally 
        {
            try 
            {
                super.finalize();
            } 
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(t);
            } 
        } 
        
        
            
                
            
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.935 -0400", hash_original_method = "B3BE4D570FA623471DB2047631197E6D", hash_generated_method = "35FFB071102C9BA88D036FC71857A2FA")
    public void close() throws IOException {
        guard.close();
        RandomAccessFile raf = mRaf;
        {
            {
                mRaf = null;
                raf.close();
            } 
            {
                fileToDeleteOnClose.delete();
                fileToDeleteOnClose = null;
            } 
        } 
        
        
        
        
            
                
                
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.935 -0400", hash_original_method = "65CE3BC8A7A8514DBA7266C40E446CDF", hash_generated_method = "5B1AAF2E45FF011BE251609E7D79CEC6")
    private void checkNotClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Zip file closed");
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.935 -0400", hash_original_method = "C7A9A4F6B932FEDB0ECC5AECA323DFC1", hash_generated_method = "C5ED2F3EB0605E332CFB5AFDA862557B")
    public Enumeration<? extends ZipEntry> entries() {
        Enumeration<? extends ZipEntry> varB4EAC82CA7396A68D541C85D26508E83_935829947 = null; 
        checkNotClosed();
        final Iterator<ZipEntry> iterator = mEntries.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_935829947 = new Enumeration<ZipEntry>() {
            public boolean hasMoreElements() {
                checkNotClosed();
                return iterator.hasNext();
            }
            public ZipEntry nextElement() {
                checkNotClosed();
                return iterator.next();
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_935829947.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_935829947;
        
        
        
        
            
                
                
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.937 -0400", hash_original_method = "D382D29E599C910662BB0F89A97F218A", hash_generated_method = "A8D28027CB20C798F08100DD5FF9A004")
    public ZipEntry getEntry(String entryName) {
        ZipEntry varB4EAC82CA7396A68D541C85D26508E83_1413406079 = null; 
        checkNotClosed();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        ZipEntry ze = mEntries.get(entryName);
        {
            ze = mEntries.get(entryName + "/");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1413406079 = ze;
        addTaint(entryName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1413406079.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1413406079;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.938 -0400", hash_original_method = "B69421FB9318C1ABE9ECEEB1DD311069", hash_generated_method = "3875F83A8607AD7A7309F94F470AAAEA")
    public InputStream getInputStream(ZipEntry entry) throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1913275702 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_312876864 = null; 
        InputStream varB4EAC82CA7396A68D541C85D26508E83_507799196 = null; 
        entry = getEntry(entry.getName());
        {
            varB4EAC82CA7396A68D541C85D26508E83_1913275702 = null;
        } 
        RandomAccessFile raf = mRaf;
        {
            RAFStream rafstrm = new RAFStream(raf, entry.mLocalHeaderRelOffset + 28);
            DataInputStream is = new DataInputStream(rafstrm);
            int localExtraLenOrWhatever = Short.reverseBytes(is.readShort());
            is.close();
            rafstrm.skip(entry.nameLength + localExtraLenOrWhatever);
            rafstrm.mLength = rafstrm.mOffset + entry.compressedSize;
            {
                int bufSize = Math.max(1024, (int)Math.min(entry.getSize(), 65535L));
                varB4EAC82CA7396A68D541C85D26508E83_312876864 = new ZipInflaterInputStream(rafstrm, new Inflater(true), bufSize, entry);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_507799196 = rafstrm;
            } 
        } 
        addTaint(entry.getTaint());
        InputStream varA7E53CE21691AB073D9660D615818899_2140625100; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2140625100 = varB4EAC82CA7396A68D541C85D26508E83_1913275702;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2140625100 = varB4EAC82CA7396A68D541C85D26508E83_312876864;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2140625100 = varB4EAC82CA7396A68D541C85D26508E83_507799196;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2140625100.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2140625100;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.939 -0400", hash_original_method = "16A0E81CED7078E4D61B7DA2166E122D", hash_generated_method = "977D4119A557101632619A2AE81B2F8A")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_409166960 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_409166960 = fileName;
        varB4EAC82CA7396A68D541C85D26508E83_409166960.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_409166960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.939 -0400", hash_original_method = "E69009FC6775A108297426EEDE85C8D2", hash_generated_method = "B4EE071BB0F24B2B2D2ADF13CA4C1ACE")
    public int size() {
        checkNotClosed();
        int var85B557D4654E88618B8057DD0AFCFFDA_1689972203 = (mEntries.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530671189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1530671189;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_method = "C4C5F4E81B860F4CAE8325550F47061B", hash_generated_method = "0B1013ED87C6AD063AC96FDDF2B4E8CB")
    private void readCentralDir() throws IOException {
        long scanOffset = mRaf.length() - ENDHDR;
        {
            if (DroidSafeAndroidRuntime.control) throw new ZipException("too short to be Zip");
        } 
        long stopOffset = scanOffset - 65536;
        {
            stopOffset = 0;
        } 
        final int ENDHEADERMAGIC = 0x06054b50;
        {
            mRaf.seek(scanOffset);
            {
                boolean var4ED9CF7268BDF0C528752A1A4EA7FC4F_543305929 = (Integer.reverseBytes(mRaf.readInt()) == ENDHEADERMAGIC);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new ZipException("EOCD not found; not a Zip archive?");
            } 
        } 
        byte[] eocd = new byte[18];
        mRaf.readFully(eocd);
        BufferIterator it = HeapBufferIterator.iterator(eocd, 0, eocd.length, ByteOrder.LITTLE_ENDIAN);
        short diskNumber = it.readShort();
        short diskWithCentralDir = it.readShort();
        short numEntries = it.readShort();
        short totalNumEntries = it.readShort();
        it.skip(4);
        int centralDirOffset = it.readInt();
        {
            if (DroidSafeAndroidRuntime.control) throw new ZipException("spanned archives not supported");
        } 
        RAFStream rafs = new RAFStream(mRaf, centralDirOffset);
        BufferedInputStream bin = new BufferedInputStream(rafs, 4096);
        byte[] hdrBuf = new byte[CENHDR];
        {
            int i = 0;
            {
                ZipEntry newEntry = new ZipEntry(hdrBuf, bin);
                mEntries.put(newEntry.getName(), newEntry);
            } 
        } 
        
        
    }

    
    static class RAFStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_field = "51458950B7F230500F7285BEDBF5164C", hash_generated_field = "9A517EC1A66B8BABFBEC36F04F6D50E9")

        RandomAccessFile mSharedRaf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "404D538D7C85388778B668910857AE1E")

        long mOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "CAB3DDEC49B3F58AA21EC9312CA21C26")

        long mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_method = "7566C7D40BAC719393DA5AE2730758DD", hash_generated_method = "C054BC53EF56F04CAC7E1CE72B1B499D")
        public  RAFStream(RandomAccessFile raf, long pos) throws IOException {
            mSharedRaf = raf;
            mOffset = pos;
            mLength = raf.length();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.940 -0400", hash_original_method = "EBB90581A10714B3978F18E12312CB3A", hash_generated_method = "6CA720CA4E2251A8EF6EA7E8DE1FD542")
        @Override
        public int available() throws IOException {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971278117 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971278117;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.941 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "ED6F902999D44C7CACF8DBA1203DEC24")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_843033894 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047702883 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047702883;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.941 -0400", hash_original_method = "EF568FF768F81FE11A38286E6FDCB2E1", hash_generated_method = "6473D86531F896D33FE5B5E0FB880257")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            {
                mSharedRaf.seek(mOffset);
                {
                    len = (int) (mLength - mOffset);
                } 
                int count = mSharedRaf.read(b, off, len);
                {
                    mOffset += count;
                } 
            } 
            addTaint(b[0]);
            addTaint(off);
            addTaint(len);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042384482 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042384482;
            
            
                
                
                    
                
                
                
                    
                    
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.942 -0400", hash_original_method = "62A626F8A4A0AABE786C23986D3622F2", hash_generated_method = "B64B0D896424DE8A66BA7B7CAC0862E4")
        @Override
        public long skip(long byteCount) throws IOException {
            {
                byteCount = mLength - mOffset;
            } 
            mOffset += byteCount;
            long var0F5264038205EDFB1AC05FBB0E8C5E94_2081772822 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_2081772822;
            
            
                
            
            
            
        }

        
    }


    
    static class ZipInflaterInputStream extends InflaterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.942 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "6ABF0A573F6A71AB8AAE237EF7DCBFD4")

        ZipEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.942 -0400", hash_original_field = "7D8F20515DCE7127CFD8808A1B0CF74F", hash_generated_field = "B454E81C25A392A63976B59EF20BFDA7")

        long bytesRead = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.942 -0400", hash_original_method = "7042D9D65A5773117A52B7582FC64EEF", hash_generated_method = "CA8D4335C37585B0DC1FBFEA29B1A020")
        public  ZipInflaterInputStream(InputStream is, Inflater inf, int bsize, ZipEntry entry) {
            super(is, inf, bsize);
            this.entry = entry;
            addTaint(is.getTaint());
            addTaint(inf.getTaint());
            addTaint(bsize);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.942 -0400", hash_original_method = "8B6BFDD773126A0A7B62B959FA690E20", hash_generated_method = "6AE901BB77760B849C355425E57B56A7")
        @Override
        public int read(byte[] buffer, int off, int nbytes) throws IOException {
            int i = super.read(buffer, off, nbytes);
            {
                bytesRead += i;
            } 
            addTaint(buffer[0]);
            addTaint(off);
            addTaint(nbytes);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973277762 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_973277762;
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.943 -0400", hash_original_method = "67EB7FFE4182D11E188F79FFA477AD5D", hash_generated_method = "E13CFF8C53F4A7A5B35AEF2FF9FE6A93")
        @Override
        public int available() throws IOException {
            {
                boolean varB468C57145781459693BA514A4AED697_1530691482 = (super.available() == 0);
                Object var4F59783E13CE810BB8A4B691B940F808_1053414159 = ((int) (entry.getSize() - bytesRead));
            } 
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560713117 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_560713117;
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.943 -0400", hash_original_field = "6B342FB26FF70384E471C5CA8CA6EA4B", hash_generated_field = "845771CF1327085096E285BA804AA3A7")

    static final int GPBF_DATA_DESCRIPTOR_FLAG = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.943 -0400", hash_original_field = "6EB4A05860AC086267F3018BA4960053", hash_generated_field = "AA1EB96D201748E5181D12EBA7874424")

    static final int GPBF_UTF8_FLAG = 1 << 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.943 -0400", hash_original_field = "2030CB3C49CDD31F6DC1BA26C647D874", hash_generated_field = "BDFA5188A857E38E442BEEEC9A478A22")

    public static final int OPEN_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.943 -0400", hash_original_field = "E60E95A92B8D974A47D037335C4C9DC7", hash_generated_field = "9B4DAE08FD98D6BD64EFD48A6CA5D374")

    public static final int OPEN_DELETE = 4;
}

