package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_field = "5B063E275D506F65EBF1B02D926F19A4", hash_generated_field = "0CA74B4233F69873CB47E022D845EA81")

    private String fileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_field = "043B1F7CF119742EC4CEE56509E60C5D", hash_generated_field = "B13A9F7F3BCBF757EA8C226CB83B1836")

    private File fileToDeleteOnClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_field = "0345BD970021D77DF594F2A9A089C562", hash_generated_field = "FB2540966EB1F635EC5558E5A5A775E6")

    private RandomAccessFile mRaf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_field = "E710FE3D4B0A45908BA4536F88014F9F", hash_generated_field = "57A589128123E20585B6C054876EA61B")

    private final LinkedHashMap<String, ZipEntry> mEntries = new LinkedHashMap<String, ZipEntry>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.535 -0400", hash_original_method = "E5AF570B733F2A8A2A3B06248A7E8835", hash_generated_method = "7FF8C445EEAE9F6173828CE6C2A55791")
    public  ZipFile(File file) throws ZipException, IOException {
        this(file, OPEN_READ);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.536 -0400", hash_original_method = "695CBEBB4A56BF57E24064CBD947BCB2", hash_generated_method = "42C9D5BA0DC3898ACD021CDB97C516E7")
    public  ZipFile(File file, int mode) throws IOException {
        addTaint(mode);
        fileName = file.getPath();
    if(mode != OPEN_READ && mode != (OPEN_READ | OPEN_DELETE))        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_239885104 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_239885104.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_239885104;
        } //End block
    if((mode & OPEN_DELETE) != 0)        
        {
            fileToDeleteOnClose = file;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.537 -0400", hash_original_method = "B52E22744B2B372E6DB0945A3673793A", hash_generated_method = "EB73949118A9F8074498F5187BFD63BB")
    public  ZipFile(String name) throws IOException {
        this(new File(name), OPEN_READ);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.537 -0400", hash_original_method = "A7163D550D593B0FEEAE03A5B45C66A6", hash_generated_method = "9D91D888C0E0D82A65B3AF3CC427DF09")
    @Override
    protected void finalize() throws IOException {
        try 
        {
    if(guard != null)            
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
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_410899981 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_410899981.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_410899981;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.538 -0400", hash_original_method = "B3BE4D570FA623471DB2047631197E6D", hash_generated_method = "A038B3C187DE4197A3E2EBE9A61C8213")
    public void close() throws IOException {
        guard.close();
        RandomAccessFile raf = mRaf;
    if(raf != null)        
        {
            synchronized
(raf)            {
                mRaf = null;
                raf.close();
            } //End block
    if(fileToDeleteOnClose != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.538 -0400", hash_original_method = "65CE3BC8A7A8514DBA7266C40E446CDF", hash_generated_method = "12D6B77024D9365AEC8678576EDCF575")
    private void checkNotClosed() {
    if(mRaf == null)        
        {
            IllegalStateException var4D2E3C6EC148079EB8B6AAD6FAB0DF1F_230065070 = new IllegalStateException("Zip file closed");
            var4D2E3C6EC148079EB8B6AAD6FAB0DF1F_230065070.addTaint(taint);
            throw var4D2E3C6EC148079EB8B6AAD6FAB0DF1F_230065070;
        } //End block
        // ---------- Original Method ----------
        //if (mRaf == null) {
            //throw new IllegalStateException("Zip file closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.539 -0400", hash_original_method = "C7A9A4F6B932FEDB0ECC5AECA323DFC1", hash_generated_method = "DBE1D5AA3B02278B1B0E577936F1A364")
    public Enumeration<? extends ZipEntry> entries() {
        checkNotClosed();
        final Iterator<ZipEntry> iterator = mEntries.values().iterator();
Enumeration<? extends ZipEntry> var5C2492AEF6429BB2452507D2F1DD320A_1009656857 =         new Enumeration<ZipEntry>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.539 -0400", hash_original_method = "E86ACDCD19145E338744AC3C77C30364", hash_generated_method = "778061CC0E66D23283F0E60D6CB5FBEF")
        public boolean hasMoreElements() {
            checkNotClosed();
            boolean varD6B09E4375C520F8E3C47E2CD37ACCE3_828684741 = (iterator.hasNext());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110823652 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110823652;
            // ---------- Original Method ----------
            //checkNotClosed();
            //return iterator.hasNext();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.539 -0400", hash_original_method = "0AFF9A2DED00798BA27B7711FA7E95F7", hash_generated_method = "3F538D55B97097BC8432AAB69609B01B")
        public ZipEntry nextElement() {
            checkNotClosed();
ZipEntry var862BD85102BDD28E8A3902D84E203428_1892743272 =             iterator.next();
            var862BD85102BDD28E8A3902D84E203428_1892743272.addTaint(taint);
            return var862BD85102BDD28E8A3902D84E203428_1892743272;
            // ---------- Original Method ----------
            //checkNotClosed();
            //return iterator.next();
        }
};
        var5C2492AEF6429BB2452507D2F1DD320A_1009656857.addTaint(taint);
        return var5C2492AEF6429BB2452507D2F1DD320A_1009656857;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.540 -0400", hash_original_method = "D382D29E599C910662BB0F89A97F218A", hash_generated_method = "C7B4CE237FD1A2E7D6CDC9E231954A6A")
    public ZipEntry getEntry(String entryName) {
        addTaint(entryName.getTaint());
        checkNotClosed();
    if(entryName == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_944426849 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_944426849.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_944426849;
        } //End block
        ZipEntry ze = mEntries.get(entryName);
    if(ze == null)        
        {
            ze = mEntries.get(entryName + "/");
        } //End block
ZipEntry var73C8562FB105FA2AE4E182CC2B2A6163_1536642118 =         ze;
        var73C8562FB105FA2AE4E182CC2B2A6163_1536642118.addTaint(taint);
        return var73C8562FB105FA2AE4E182CC2B2A6163_1536642118;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.541 -0400", hash_original_method = "B69421FB9318C1ABE9ECEEB1DD311069", hash_generated_method = "35E292E0103FFDF0BABA95C55206780D")
    public InputStream getInputStream(ZipEntry entry) throws IOException {
        addTaint(entry.getTaint());
        entry = getEntry(entry.getName());
    if(entry == null)        
        {
InputStream var540C13E9E156B687226421B24F2DF178_473500988 =             null;
            var540C13E9E156B687226421B24F2DF178_473500988.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_473500988;
        } //End block
        RandomAccessFile raf = mRaf;
        synchronized
(raf)        {
            RAFStream rafstrm = new RAFStream(raf, entry.mLocalHeaderRelOffset + 28);
            DataInputStream is = new DataInputStream(rafstrm);
            int localExtraLenOrWhatever = Short.reverseBytes(is.readShort());
            is.close();
            rafstrm.skip(entry.nameLength + localExtraLenOrWhatever);
            rafstrm.mLength = rafstrm.mOffset + entry.compressedSize;
    if(entry.compressionMethod == ZipEntry.DEFLATED)            
            {
                int bufSize = Math.max(1024, (int)Math.min(entry.getSize(), 65535L));
InputStream varA1A5089AF66D782ED77C510B41C135BF_1967174577 =                 new ZipInflaterInputStream(rafstrm, new Inflater(true), bufSize, entry);
                varA1A5089AF66D782ED77C510B41C135BF_1967174577.addTaint(taint);
                return varA1A5089AF66D782ED77C510B41C135BF_1967174577;
            } //End block
            else
            {
InputStream varCCC692323793F05C82909AF4A23A4D26_1502398053 =                 rafstrm;
                varCCC692323793F05C82909AF4A23A4D26_1502398053.addTaint(taint);
                return varCCC692323793F05C82909AF4A23A4D26_1502398053;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.541 -0400", hash_original_method = "16A0E81CED7078E4D61B7DA2166E122D", hash_generated_method = "72A2243D9A97898B107BAE7DA755BB36")
    public String getName() {
String varBD5EACC393579FDF5D0E813DB68A2F73_275074010 =         fileName;
        varBD5EACC393579FDF5D0E813DB68A2F73_275074010.addTaint(taint);
        return varBD5EACC393579FDF5D0E813DB68A2F73_275074010;
        // ---------- Original Method ----------
        //return fileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.541 -0400", hash_original_method = "E69009FC6775A108297426EEDE85C8D2", hash_generated_method = "CA2A0860E82C6407C14047FEB8C46863")
    public int size() {
        checkNotClosed();
        int var2B1032AE02C6800C1DF6086DBBBD9D60_374075522 = (mEntries.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972600544 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_972600544;
        // ---------- Original Method ----------
        //checkNotClosed();
        //return mEntries.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.542 -0400", hash_original_method = "C4C5F4E81B860F4CAE8325550F47061B", hash_generated_method = "AE02A3EAA0C1C772DD43F866EEC09518")
    private void readCentralDir() throws IOException {
        long scanOffset = mRaf.length() - ENDHDR;
    if(scanOffset < 0)        
        {
            ZipException varDCBFD9907BC45F2235339C07B723FE62_1626735170 = new ZipException("too short to be Zip");
            varDCBFD9907BC45F2235339C07B723FE62_1626735170.addTaint(taint);
            throw varDCBFD9907BC45F2235339C07B723FE62_1626735170;
        } //End block
        long stopOffset = scanOffset - 65536;
    if(stopOffset < 0)        
        {
            stopOffset = 0;
        } //End block
        final int ENDHEADERMAGIC = 0x06054b50;
        while
(true)        
        {
            mRaf.seek(scanOffset);
    if(Integer.reverseBytes(mRaf.readInt()) == ENDHEADERMAGIC)            
            {
                break;
            } //End block
            scanOffset--;
    if(scanOffset < stopOffset)            
            {
                ZipException varB612409481C72D178BCF8ABFBF152D16_1318437871 = new ZipException("EOCD not found; not a Zip archive?");
                varB612409481C72D178BCF8ABFBF152D16_1318437871.addTaint(taint);
                throw varB612409481C72D178BCF8ABFBF152D16_1318437871;
            } //End block
        } //End block
        byte[] eocd = new byte[18];
        mRaf.readFully(eocd);
        BufferIterator it = HeapBufferIterator.iterator(eocd, 0, eocd.length, ByteOrder.LITTLE_ENDIAN);
        short diskNumber = it.readShort();
        short diskWithCentralDir = it.readShort();
        short numEntries = it.readShort();
        short totalNumEntries = it.readShort();
        it.skip(4);
        int centralDirOffset = it.readInt();
    if(numEntries != totalNumEntries || diskNumber != 0 || diskWithCentralDir != 0)        
        {
            ZipException varAFE6043B45A57CA8A437338ED6816F54_294017054 = new ZipException("spanned archives not supported");
            varAFE6043B45A57CA8A437338ED6816F54_294017054.addTaint(taint);
            throw varAFE6043B45A57CA8A437338ED6816F54_294017054;
        } //End block
        RAFStream rafs = new RAFStream(mRaf, centralDirOffset);
        BufferedInputStream bin = new BufferedInputStream(rafs, 4096);
        byte[] hdrBuf = new byte[CENHDR];
for(int i = 0;i < numEntries;++i)
        {
            ZipEntry newEntry = new ZipEntry(hdrBuf, bin);
            mEntries.put(newEntry.getName(), newEntry);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class RAFStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.543 -0400", hash_original_field = "51458950B7F230500F7285BEDBF5164C", hash_generated_field = "9A517EC1A66B8BABFBEC36F04F6D50E9")

        RandomAccessFile mSharedRaf;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.543 -0400", hash_original_field = "E8439EB32866F13AD7ABD06DB4A15343", hash_generated_field = "404D538D7C85388778B668910857AE1E")

        long mOffset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.543 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "CAB3DDEC49B3F58AA21EC9312CA21C26")

        long mLength;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.543 -0400", hash_original_method = "7566C7D40BAC719393DA5AE2730758DD", hash_generated_method = "C054BC53EF56F04CAC7E1CE72B1B499D")
        public  RAFStream(RandomAccessFile raf, long pos) throws IOException {
            mSharedRaf = raf;
            mOffset = pos;
            mLength = raf.length();
            // ---------- Original Method ----------
            //mSharedRaf = raf;
            //mOffset = pos;
            //mLength = raf.length();
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.544 -0400", hash_original_method = "EBB90581A10714B3978F18E12312CB3A", hash_generated_method = "6A40E3DD3F1AF85008208C1700A23C66")
        @Override
        public int available() throws IOException {
            int varB67C3BA4606855246B67D2231694DBEB_1135112079 = ((mOffset < mLength ? 1 : 0));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753754808 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1753754808;
            // ---------- Original Method ----------
            //return (mOffset < mLength ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.544 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "1F3B345F842DE431863CBD8DEFE4C602")
        @Override
        public int read() throws IOException {
            int varC29A5AE95A30EE64395CAB97F32FA4B0_387132827 = (Streams.readSingleByte(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889615040 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_889615040;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.545 -0400", hash_original_method = "EF568FF768F81FE11A38286E6FDCB2E1", hash_generated_method = "4B1E554CF1EF7279FCF1473807AC65F8")
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            addTaint(len);
            addTaint(off);
            addTaint(b[0]);
            synchronized
(mSharedRaf)            {
                mSharedRaf.seek(mOffset);
    if(len > mLength - mOffset)                
                {
                    len = (int) (mLength - mOffset);
                } //End block
                int count = mSharedRaf.read(b, off, len);
    if(count > 0)                
                {
                    mOffset += count;
                    int varE2942A04780E223B215EB8B663CF5353_1623770055 = (count);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851506800 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1851506800;
                } //End block
                else
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1813079061 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797594329 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797594329;
                } //End block
            } //End block
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.545 -0400", hash_original_method = "62A626F8A4A0AABE786C23986D3622F2", hash_generated_method = "D46255A6FC5EDF3E078E8CFBBF864F0E")
        @Override
        public long skip(long byteCount) throws IOException {
    if(byteCount > mLength - mOffset)            
            {
                byteCount = mLength - mOffset;
            } //End block
            mOffset += byteCount;
            long varA43EF6D60A83013EA1A61A23BDB16029_813807391 = (byteCount);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1829723032 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1829723032;
            // ---------- Original Method ----------
            //if (byteCount > mLength - mOffset) {
                //byteCount = mLength - mOffset;
            //}
            //mOffset += byteCount;
            //return byteCount;
        }

        
    }


    
    static class ZipInflaterInputStream extends InflaterInputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.546 -0400", hash_original_field = "1043BFC77FEBE75FAFEC0C4309FACCF1", hash_generated_field = "6ABF0A573F6A71AB8AAE237EF7DCBFD4")

        ZipEntry entry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.546 -0400", hash_original_field = "7D8F20515DCE7127CFD8808A1B0CF74F", hash_generated_field = "B454E81C25A392A63976B59EF20BFDA7")

        long bytesRead = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.546 -0400", hash_original_method = "7042D9D65A5773117A52B7582FC64EEF", hash_generated_method = "018F14EE6E4F12ECE0BE945E07BDFC7F")
        public  ZipInflaterInputStream(InputStream is, Inflater inf, int bsize, ZipEntry entry) {
            super(is, inf, bsize);
            addTaint(bsize);
            addTaint(inf.getTaint());
            addTaint(is.getTaint());
            this.entry = entry;
            // ---------- Original Method ----------
            //this.entry = entry;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.547 -0400", hash_original_method = "8B6BFDD773126A0A7B62B959FA690E20", hash_generated_method = "A9D6E52002C2976459674EBFB555B6C3")
        @Override
        public int read(byte[] buffer, int off, int nbytes) throws IOException {
            addTaint(nbytes);
            addTaint(off);
            addTaint(buffer[0]);
            int i = super.read(buffer, off, nbytes);
    if(i != -1)            
            {
                bytesRead += i;
            } //End block
            int var865C0C0B4AB0E063E5CAA3387C1A8741_1692183002 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012899170 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2012899170;
            // ---------- Original Method ----------
            //int i = super.read(buffer, off, nbytes);
            //if (i != -1) {
                //bytesRead += i;
            //}
            //return i;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.547 -0400", hash_original_method = "67EB7FFE4182D11E188F79FFA477AD5D", hash_generated_method = "8A4560C40A392440B49FBB61C321E6B0")
        @Override
        public int available() throws IOException {
    if(closed)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_1517564110 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575651382 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_575651382;
            } //End block
            int var3815DC5AD829DBA6EC0003920414A82C_620308000 = (super.available() == 0 ? 0 : (int) (entry.getSize() - bytesRead));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236212917 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_236212917;
            // ---------- Original Method ----------
            //if (closed) {
                //return 0;
            //}
            //return super.available() == 0 ? 0 : (int) (entry.getSize() - bytesRead);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.547 -0400", hash_original_field = "6B342FB26FF70384E471C5CA8CA6EA4B", hash_generated_field = "845771CF1327085096E285BA804AA3A7")

    static final int GPBF_DATA_DESCRIPTOR_FLAG = 1 << 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.548 -0400", hash_original_field = "6EB4A05860AC086267F3018BA4960053", hash_generated_field = "AA1EB96D201748E5181D12EBA7874424")

    static final int GPBF_UTF8_FLAG = 1 << 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.548 -0400", hash_original_field = "2030CB3C49CDD31F6DC1BA26C647D874", hash_generated_field = "BDFA5188A857E38E442BEEEC9A478A22")

    public static final int OPEN_READ = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.548 -0400", hash_original_field = "E60E95A92B8D974A47D037335C4C9DC7", hash_generated_field = "9B4DAE08FD98D6BD64EFD48A6CA5D374")

    public static final int OPEN_DELETE = 4;
}

