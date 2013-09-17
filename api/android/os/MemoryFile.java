package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;





import droidsafe.helpers.DSUtils;

public class MemoryFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.525 -0400", hash_original_field = "651CEF29F37C9F53091FD6A9046D9F00", hash_generated_field = "472902F3844A9738091A7090C080AB6E")

    private FileDescriptor mFD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.525 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.525 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.525 -0400", hash_original_field = "D56569F1BD1DB3D7FF8A7B1E40755DF0", hash_generated_field = "7D003ADAD6B352F39344F33BE33DE0E3")

    private boolean mAllowPurging = false;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.526 -0400", hash_original_method = "DB289001A1CA8608ADAAFD372FAC3009", hash_generated_method = "FB21749D493E47AEEFC1CEB87AEF7AB5")
    public  MemoryFile(String name, int length) throws IOException {
        mLength = length;
        mFD = native_open(name, length);
        if(length > 0)        
        {
            mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
        } //End block
        else
        {
            mAddress = 0;
        } //End block
        // ---------- Original Method ----------
        //mLength = length;
        //mFD = native_open(name, length);
        //if (length > 0) {
            //mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
        //} else {
            //mAddress = 0;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    private static FileDescriptor native_open(String name, int length) throws IOException {
		return new FileDescriptor();
	}

    
    @DSModeled(DSC.SAFE)
    private static int native_mmap(FileDescriptor fd, int length, int mode) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719;
	}

    
    @DSModeled(DSC.SAFE)
    private static void native_munmap(int addr, int length) throws IOException {
	}

    
    @DSModeled(DSC.SAFE)
    private static void native_close(FileDescriptor fd) {
	}

    
    @DSModeled(DSC.SAFE)
    private static int native_read(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879;
	}

    
    @DSModeled(DSC.SAFE)
    private static void native_write(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
	}

    
    @DSModeled(DSC.SAFE)
    private static void native_pin(FileDescriptor fd, boolean pin) throws IOException {
	}

    
    @DSModeled(DSC.SAFE)
    private static int native_get_size(FileDescriptor fd) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.529 -0400", hash_original_method = "DD734A9458D0580E341A373C2DD4F619", hash_generated_method = "48AC5B1BE99B166C06CADE2EC1615164")
    public void close() {
        deactivate();
        if(!isClosed())        
        {
            native_close(mFD);
        } //End block
        // ---------- Original Method ----------
        //deactivate();
        //if (!isClosed()) {
            //native_close(mFD);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.530 -0400", hash_original_method = "08DA91581CCCF703195AD89F50B4F4A1", hash_generated_method = "5741B4223E746BB45735ECA03E926CEB")
     void deactivate() {
        if(!isDeactivated())        
        {
            try 
            {
                native_munmap(mAddress, mLength);
                mAddress = 0;
            } //End block
            catch (IOException ex)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!isDeactivated()) {
            //try {
                //native_munmap(mAddress, mLength);
                //mAddress = 0;
            //} catch (IOException ex) {
                //Log.e(TAG, ex.toString());
            //}
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.531 -0400", hash_original_method = "6DDBFC199C19310599F0713304591847", hash_generated_method = "E6077F9EB637C837C661248F57466C23")
    private boolean isDeactivated() {
        boolean var472664B108BA887238443A411579BA83_1725905244 = (mAddress == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926868972 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926868972;
        // ---------- Original Method ----------
        //return mAddress == 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.531 -0400", hash_original_method = "3246A0B1468E43E22E475A6EAB25C98D", hash_generated_method = "3573DDCADAAF32F6D8449AEB7121EE67")
    private boolean isClosed() {
        boolean var401A99D823C7C2A08DCAD7BDB9EB9F83_1484832973 = (!mFD.valid());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_356632677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_356632677;
        // ---------- Original Method ----------
        //return !mFD.valid();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.531 -0400", hash_original_method = "41074FB4CF57E698C714BECD1DB74DD1", hash_generated_method = "1C494876595D208B209A059E055B33B7")
    @Override
    protected void finalize() {
        if(!isClosed())        
        {
            close();
        } //End block
        // ---------- Original Method ----------
        //if (!isClosed()) {
            //Log.e(TAG, "MemoryFile.finalize() called while ashmem still open");
            //close();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.531 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "1D8E4B0EDA9AB9D67FAF24438EB4781A")
    public int length() {
        int var429F431E8CD8AC287AA27460675EAEFE_1358994150 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706616840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706616840;
        // ---------- Original Method ----------
        //return mLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.532 -0400", hash_original_method = "36BC15D120E9C0B3759A6273F0B6F394", hash_generated_method = "3AF66F053A63AB9D7D658B01616B3628")
    public boolean isPurgingAllowed() {
        boolean var9AF79FB5B21F6F4CE7B22525EBD546C0_858765473 = (mAllowPurging);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417622319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417622319;
        // ---------- Original Method ----------
        //return mAllowPurging;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.532 -0400", hash_original_method = "4E65A3A585AE016FD322D2CFB53AD9E7", hash_generated_method = "904B5C1E00E9D87D267DB31B4750FC06")
    synchronized public boolean allowPurging(boolean allowPurging) throws IOException {
        boolean oldValue = mAllowPurging;
        if(oldValue != allowPurging)        
        {
            native_pin(mFD, !allowPurging);
            mAllowPurging = allowPurging;
        } //End block
        boolean var0382B9FD9EF50B6A335F35E0AAAEBF99_594598528 = (oldValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383112588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_383112588;
        // ---------- Original Method ----------
        //boolean oldValue = mAllowPurging;
        //if (oldValue != allowPurging) {
            //native_pin(mFD, !allowPurging);
            //mAllowPurging = allowPurging;
        //}
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.533 -0400", hash_original_method = "1F9A300CE55BE9E69C06FFD4C6B98E29", hash_generated_method = "FA1A7C9FB4167D391CF9EEE515C2E17A")
    public InputStream getInputStream() {
InputStream varF269E856784FF2D368CBB8E7FA0B4440_1684563614 =         new MemoryInputStream();
        varF269E856784FF2D368CBB8E7FA0B4440_1684563614.addTaint(taint);
        return varF269E856784FF2D368CBB8E7FA0B4440_1684563614;
        // ---------- Original Method ----------
        //return new MemoryInputStream();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.533 -0400", hash_original_method = "0A8C4757301CE72EF10D99AE7CF53794", hash_generated_method = "AB249805C6699CB67162328DCB82EF1C")
    public OutputStream getOutputStream() {
OutputStream var86EFA5916CD0155241780D6EEE9688E0_1423779640 =         new MemoryOutputStream();
        var86EFA5916CD0155241780D6EEE9688E0_1423779640.addTaint(taint);
        return var86EFA5916CD0155241780D6EEE9688E0_1423779640;
        // ---------- Original Method ----------
        //return new MemoryOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.533 -0400", hash_original_method = "E94CD8A455128D534B69DAAECC501B12", hash_generated_method = "72AE52398855DAA829BB7FEBC71A7A72")
    public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        addTaint(count);
        addTaint(destOffset);
        addTaint(srcOffset);
        addTaint(buffer[0]);
        if(isDeactivated())        
        {
            IOException varEF7D4CDED219AEEF7A68C0F8169B94FE_457402631 = new IOException("Can't read from deactivated memory file.");
            varEF7D4CDED219AEEF7A68C0F8169B94FE_457402631.addTaint(taint);
            throw varEF7D4CDED219AEEF7A68C0F8169B94FE_457402631;
        } //End block
        if(destOffset < 0 || destOffset > buffer.length || count < 0
                || count > buffer.length - destOffset
                || srcOffset < 0 || srcOffset > mLength
                || count > mLength - srcOffset)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_323106244 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_323106244.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_323106244;
        } //End block
        int var6826620B9A9F7560608EC737B9C6EF75_79381644 = (native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984943479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984943479;
        // ---------- Original Method ----------
        //if (isDeactivated()) {
            //throw new IOException("Can't read from deactivated memory file.");
        //}
        //if (destOffset < 0 || destOffset > buffer.length || count < 0
                //|| count > buffer.length - destOffset
                //|| srcOffset < 0 || srcOffset > mLength
                //|| count > mLength - srcOffset) {
            //throw new IndexOutOfBoundsException();
        //}
        //return native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.534 -0400", hash_original_method = "6737AABC2F88EDB7F71CE587CF7F9739", hash_generated_method = "61E4CA9C81521F80B4974A6ADE464ED9")
    public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        addTaint(count);
        addTaint(destOffset);
        addTaint(srcOffset);
        addTaint(buffer[0]);
        if(isDeactivated())        
        {
            IOException var5DEDBFF5DDB744A6396B24807F07EB2F_1207651450 = new IOException("Can't write to deactivated memory file.");
            var5DEDBFF5DDB744A6396B24807F07EB2F_1207651450.addTaint(taint);
            throw var5DEDBFF5DDB744A6396B24807F07EB2F_1207651450;
        } //End block
        if(srcOffset < 0 || srcOffset > buffer.length || count < 0
                || count > buffer.length - srcOffset
                || destOffset < 0 || destOffset > mLength
                || count > mLength - destOffset)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1590623342 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1590623342.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1590623342;
        } //End block
        native_write(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
        // ---------- Original Method ----------
        //if (isDeactivated()) {
            //throw new IOException("Can't write to deactivated memory file.");
        //}
        //if (srcOffset < 0 || srcOffset > buffer.length || count < 0
                //|| count > buffer.length - srcOffset
                //|| destOffset < 0 || destOffset > mLength
                //|| count > mLength - destOffset) {
            //throw new IndexOutOfBoundsException();
        //}
        //native_write(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.534 -0400", hash_original_method = "2D6523548F3A6408618EC64E9280F841", hash_generated_method = "34243EAEB82351C1D9A4A6F60687C338")
    public FileDescriptor getFileDescriptor() throws IOException {
FileDescriptor varECF11D4F04AEADCE51301AA20EB886F5_744389184 =         mFD;
        varECF11D4F04AEADCE51301AA20EB886F5_744389184.addTaint(taint);
        return varECF11D4F04AEADCE51301AA20EB886F5_744389184;
        // ---------- Original Method ----------
        //return mFD;
    }

    
    @DSModeled(DSC.BAN)
    public static int getSize(FileDescriptor fd) throws IOException {
        return native_get_size(fd);
    }

    
    private class MemoryInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_field = "347231F94AB7C260D952FF25D7F7F6C4", hash_generated_field = "1CE465393F7752DBE05602CD816C716E")

        private int mMark = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_method = "8819C64327DEAF910328E1B34E1904BC", hash_generated_method = "8819C64327DEAF910328E1B34E1904BC")
        public MemoryInputStream ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_method = "C946C15ECBD8592757BE5150DF65639B", hash_generated_method = "C2B06E4C785021720909275A0F4940AC")
        @Override
        public int available() throws IOException {
            if(mOffset >= mLength)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_2037387706 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080955511 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080955511;
            } //End block
            int var0CE244EABE418D5C0C89775582171D8E_163502487 = (mLength - mOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865474015 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865474015;
            // ---------- Original Method ----------
            //if (mOffset >= mLength) {
                //return 0;
            //}
            //return mLength - mOffset;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "DFCA7FB67E306C8CA729223F0C801ED6")
        @Override
        public boolean markSupported() {
            boolean varB326B5062B2F0E69046810717534CB09_226709560 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_621342494 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_621342494;
            // ---------- Original Method ----------
            //return true;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.536 -0400", hash_original_method = "D9C9FB514524CC537FCE6FACAF9A295C", hash_generated_method = "E4F11F77F2CFC4BD43327EF113355F07")
        @Override
        public void mark(int readlimit) {
            addTaint(readlimit);
            mMark = mOffset;
            // ---------- Original Method ----------
            //mMark = mOffset;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.536 -0400", hash_original_method = "35916CEFACB2EEB27C627D30B06B91CE", hash_generated_method = "51C43F06C3033D3370FC41BB3D926B97")
        @Override
        public void reset() throws IOException {
            mOffset = mMark;
            // ---------- Original Method ----------
            //mOffset = mMark;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.536 -0400", hash_original_method = "A1D8D948EA118F9A15401118B0635D27", hash_generated_method = "5B3E384EFAEB99E70DFF8DF852FFD8BC")
        @Override
        public int read() throws IOException {
            if(mSingleByte == null)            
            {
                mSingleByte = new byte[1];
            } //End block
            int result = read(mSingleByte, 0, 1);
            if(result != 1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1200535764 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768707850 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_768707850;
            } //End block
            int varAF82E66A9F7D60CAAC7DD8ED96D784F8_1529521147 = (mSingleByte[0]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447509702 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1447509702;
            // ---------- Original Method ----------
            //if (mSingleByte == null) {
                //mSingleByte = new byte[1];
            //}
            //int result = read(mSingleByte, 0, 1);
            //if (result != 1) {
                //return -1;
            //}
            //return mSingleByte[0];
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.537 -0400", hash_original_method = "BFF461741A45AAAD780835BEF712AE09", hash_generated_method = "06EE7EE744B83410595BA1BEC0E4622B")
        @Override
        public int read(byte buffer[], int offset, int count) throws IOException {
            addTaint(count);
            addTaint(offset);
            addTaint(buffer[0]);
            if(offset < 0 || count < 0 || offset + count > buffer.length)            
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_851254499 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_851254499.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_851254499;
            } //End block
            count = Math.min(count, available());
            if(count < 1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1722421287 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557464978 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557464978;
            } //End block
            int result = readBytes(buffer, mOffset, offset, count);
            if(result > 0)            
            {
                mOffset += result;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_825603299 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318374309 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_318374309;
            // ---------- Original Method ----------
            //if (offset < 0 || count < 0 || offset + count > buffer.length) {
                //throw new IndexOutOfBoundsException();
            //}
            //count = Math.min(count, available());
            //if (count < 1) {
                //return -1;
            //}
            //int result = readBytes(buffer, mOffset, offset, count);
            //if (result > 0) {
                //mOffset += result;
            //}
            //return result;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.538 -0400", hash_original_method = "9D84182613F8631FDE5947AEAB012BC6", hash_generated_method = "F8BA31C5FBBD951D5FF7C8D73C69BE89")
        @Override
        public long skip(long n) throws IOException {
            if(mOffset + n > mLength)            
            {
                n = mLength - mOffset;
            } //End block
            mOffset += n;
            long var7B8B965AD4BCA0E41AB51DE7B31363A1_1370363992 = (n);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_750616782 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_750616782;
            // ---------- Original Method ----------
            //if (mOffset + n > mLength) {
                //n = mLength - mOffset;
            //}
            //mOffset += n;
            //return n;
        }

        
    }


    
    private class MemoryOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.538 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.538 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.538 -0400", hash_original_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB", hash_generated_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB")
        public MemoryOutputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.539 -0400", hash_original_method = "E169D47904A982CBC090A3E5EE81FFA1", hash_generated_method = "2A540594D593B88A808996AB68D6A1B1")
        @Override
        public void write(byte buffer[], int offset, int count) throws IOException {
            addTaint(offset);
            addTaint(buffer[0]);
            writeBytes(buffer, offset, mOffset, count);
            mOffset += count;
            // ---------- Original Method ----------
            //writeBytes(buffer, offset, mOffset, count);
            //mOffset += count;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.539 -0400", hash_original_method = "873021528A0C471EBDB778DCC5A89FEF", hash_generated_method = "05FDBE8172A59656C82C4D75C0EBFF5F")
        @Override
        public void write(int oneByte) throws IOException {
            if(mSingleByte == null)            
            {
                mSingleByte = new byte[1];
            } //End block
            mSingleByte[0] = (byte)oneByte;
            write(mSingleByte, 0, 1);
            // ---------- Original Method ----------
            //if (mSingleByte == null) {
                //mSingleByte = new byte[1];
            //}
            //mSingleByte[0] = (byte)oneByte;
            //write(mSingleByte, 0, 1);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.539 -0400", hash_original_field = "3081A19470620560723AFCCFD231D233", hash_generated_field = "5D3F94A828767D0FA960A9A7B583EDC1")

    private static String TAG = "MemoryFile";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.539 -0400", hash_original_field = "8485B64C5FEEDD71B9F0C2B303033EAA", hash_generated_field = "266C128FB04586E6755B38B52173946D")

    private static final int PROT_READ = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.539 -0400", hash_original_field = "4AC8997208999500EC0C56E354EE8162", hash_generated_field = "BDAF7D4E803BF7BEA3AAAA94A46AE56A")

    private static final int PROT_WRITE = 0x2;
}

