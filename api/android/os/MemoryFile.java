package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MemoryFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.644 -0400", hash_original_field = "651CEF29F37C9F53091FD6A9046D9F00", hash_generated_field = "472902F3844A9738091A7090C080AB6E")

    private FileDescriptor mFD;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.644 -0400", hash_original_field = "9C8E67CB570F7F2DF167C544686B922A", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.645 -0400", hash_original_field = "429F431E8CD8AC287AA27460675EAEFE", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.645 -0400", hash_original_field = "D56569F1BD1DB3D7FF8A7B1E40755DF0", hash_generated_field = "7D003ADAD6B352F39344F33BE33DE0E3")

    private boolean mAllowPurging = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.646 -0400", hash_original_method = "DB289001A1CA8608ADAAFD372FAC3009", hash_generated_method = "FB21749D493E47AEEFC1CEB87AEF7AB5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.650 -0400", hash_original_method = "DD734A9458D0580E341A373C2DD4F619", hash_generated_method = "48AC5B1BE99B166C06CADE2EC1615164")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.650 -0400", hash_original_method = "08DA91581CCCF703195AD89F50B4F4A1", hash_generated_method = "5741B4223E746BB45735ECA03E926CEB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.651 -0400", hash_original_method = "6DDBFC199C19310599F0713304591847", hash_generated_method = "8986F821FD345689A179573F68E8240E")
    private boolean isDeactivated() {
        boolean var472664B108BA887238443A411579BA83_1782640223 = (mAddress == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1704612612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1704612612;
        // ---------- Original Method ----------
        //return mAddress == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.651 -0400", hash_original_method = "3246A0B1468E43E22E475A6EAB25C98D", hash_generated_method = "63385832EBE23423ACAD157C7405C47A")
    private boolean isClosed() {
        boolean var401A99D823C7C2A08DCAD7BDB9EB9F83_1138598300 = (!mFD.valid());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382067590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382067590;
        // ---------- Original Method ----------
        //return !mFD.valid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.651 -0400", hash_original_method = "41074FB4CF57E698C714BECD1DB74DD1", hash_generated_method = "1C494876595D208B209A059E055B33B7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.652 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "71C3BDE24976A95A5F3C94D224478654")
    public int length() {
        int var429F431E8CD8AC287AA27460675EAEFE_485496203 = (mLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367170531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367170531;
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.652 -0400", hash_original_method = "36BC15D120E9C0B3759A6273F0B6F394", hash_generated_method = "3413478599195E482CD489C11120CAB7")
    public boolean isPurgingAllowed() {
        boolean var9AF79FB5B21F6F4CE7B22525EBD546C0_543356922 = (mAllowPurging);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874364855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874364855;
        // ---------- Original Method ----------
        //return mAllowPurging;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.652 -0400", hash_original_method = "4E65A3A585AE016FD322D2CFB53AD9E7", hash_generated_method = "4F11480613238B125AF19F3A78A4BDA4")
    synchronized public boolean allowPurging(boolean allowPurging) throws IOException {
        boolean oldValue = mAllowPurging;
    if(oldValue != allowPurging)        
        {
            native_pin(mFD, !allowPurging);
            mAllowPurging = allowPurging;
        } //End block
        boolean var0382B9FD9EF50B6A335F35E0AAAEBF99_545369695 = (oldValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345338422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345338422;
        // ---------- Original Method ----------
        //boolean oldValue = mAllowPurging;
        //if (oldValue != allowPurging) {
            //native_pin(mFD, !allowPurging);
            //mAllowPurging = allowPurging;
        //}
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.653 -0400", hash_original_method = "1F9A300CE55BE9E69C06FFD4C6B98E29", hash_generated_method = "C5322BC5A07ADB24D68AB9F806BDBC43")
    public InputStream getInputStream() {
InputStream varF269E856784FF2D368CBB8E7FA0B4440_909939042 =         new MemoryInputStream();
        varF269E856784FF2D368CBB8E7FA0B4440_909939042.addTaint(taint);
        return varF269E856784FF2D368CBB8E7FA0B4440_909939042;
        // ---------- Original Method ----------
        //return new MemoryInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.653 -0400", hash_original_method = "0A8C4757301CE72EF10D99AE7CF53794", hash_generated_method = "41ED04665C340859AF5090C3732AF9DC")
    public OutputStream getOutputStream() {
OutputStream var86EFA5916CD0155241780D6EEE9688E0_1431435914 =         new MemoryOutputStream();
        var86EFA5916CD0155241780D6EEE9688E0_1431435914.addTaint(taint);
        return var86EFA5916CD0155241780D6EEE9688E0_1431435914;
        // ---------- Original Method ----------
        //return new MemoryOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.653 -0400", hash_original_method = "E94CD8A455128D534B69DAAECC501B12", hash_generated_method = "6EDBB3185B6505606C68850D26B4E659")
    public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        addTaint(count);
        addTaint(destOffset);
        addTaint(srcOffset);
        addTaint(buffer[0]);
    if(isDeactivated())        
        {
            IOException varEF7D4CDED219AEEF7A68C0F8169B94FE_638794295 = new IOException("Can't read from deactivated memory file.");
            varEF7D4CDED219AEEF7A68C0F8169B94FE_638794295.addTaint(taint);
            throw varEF7D4CDED219AEEF7A68C0F8169B94FE_638794295;
        } //End block
    if(destOffset < 0 || destOffset > buffer.length || count < 0
                || count > buffer.length - destOffset
                || srcOffset < 0 || srcOffset > mLength
                || count > mLength - srcOffset)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1112617286 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1112617286.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1112617286;
        } //End block
        int var6826620B9A9F7560608EC737B9C6EF75_720571850 = (native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379210536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_379210536;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.654 -0400", hash_original_method = "6737AABC2F88EDB7F71CE587CF7F9739", hash_generated_method = "8F8262C548D7E524E23A1C358390F1A1")
    public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        addTaint(count);
        addTaint(destOffset);
        addTaint(srcOffset);
        addTaint(buffer[0]);
    if(isDeactivated())        
        {
            IOException var5DEDBFF5DDB744A6396B24807F07EB2F_1976904084 = new IOException("Can't write to deactivated memory file.");
            var5DEDBFF5DDB744A6396B24807F07EB2F_1976904084.addTaint(taint);
            throw var5DEDBFF5DDB744A6396B24807F07EB2F_1976904084;
        } //End block
    if(srcOffset < 0 || srcOffset > buffer.length || count < 0
                || count > buffer.length - srcOffset
                || destOffset < 0 || destOffset > mLength
                || count > mLength - destOffset)        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_520010233 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_520010233.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_520010233;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.654 -0400", hash_original_method = "2D6523548F3A6408618EC64E9280F841", hash_generated_method = "2300962B65729C13D36EB434456D2D92")
    public FileDescriptor getFileDescriptor() throws IOException {
FileDescriptor varECF11D4F04AEADCE51301AA20EB886F5_219755824 =         mFD;
        varECF11D4F04AEADCE51301AA20EB886F5_219755824.addTaint(taint);
        return varECF11D4F04AEADCE51301AA20EB886F5_219755824;
        // ---------- Original Method ----------
        //return mFD;
    }

    
        public static int getSize(FileDescriptor fd) throws IOException {
        return native_get_size(fd);
    }

    
    private class MemoryInputStream extends InputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.654 -0400", hash_original_field = "347231F94AB7C260D952FF25D7F7F6C4", hash_generated_field = "1CE465393F7752DBE05602CD816C716E")

        private int mMark = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.655 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.655 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.655 -0400", hash_original_method = "8819C64327DEAF910328E1B34E1904BC", hash_generated_method = "8819C64327DEAF910328E1B34E1904BC")
        public MemoryInputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.655 -0400", hash_original_method = "C946C15ECBD8592757BE5150DF65639B", hash_generated_method = "A72C5D57625ED3286C19077CBC47FD7B")
        @Override
        public int available() throws IOException {
    if(mOffset >= mLength)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_2028418626 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695635548 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_695635548;
            } //End block
            int var0CE244EABE418D5C0C89775582171D8E_2004689022 = (mLength - mOffset);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531508716 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531508716;
            // ---------- Original Method ----------
            //if (mOffset >= mLength) {
                //return 0;
            //}
            //return mLength - mOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.655 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "9EA9321BF50AAD895F68CC88BF76E286")
        @Override
        public boolean markSupported() {
            boolean varB326B5062B2F0E69046810717534CB09_1064814656 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367708010 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367708010;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.656 -0400", hash_original_method = "D9C9FB514524CC537FCE6FACAF9A295C", hash_generated_method = "E4F11F77F2CFC4BD43327EF113355F07")
        @Override
        public void mark(int readlimit) {
            addTaint(readlimit);
            mMark = mOffset;
            // ---------- Original Method ----------
            //mMark = mOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.656 -0400", hash_original_method = "35916CEFACB2EEB27C627D30B06B91CE", hash_generated_method = "51C43F06C3033D3370FC41BB3D926B97")
        @Override
        public void reset() throws IOException {
            mOffset = mMark;
            // ---------- Original Method ----------
            //mOffset = mMark;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.656 -0400", hash_original_method = "A1D8D948EA118F9A15401118B0635D27", hash_generated_method = "989C4B549480EAB7BD1BFCA50E02874A")
        @Override
        public int read() throws IOException {
    if(mSingleByte == null)            
            {
                mSingleByte = new byte[1];
            } //End block
            int result = read(mSingleByte, 0, 1);
    if(result != 1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1392115529 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749604872 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749604872;
            } //End block
            int varAF82E66A9F7D60CAAC7DD8ED96D784F8_29020436 = (mSingleByte[0]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183115424 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_183115424;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.657 -0400", hash_original_method = "BFF461741A45AAAD780835BEF712AE09", hash_generated_method = "2D29027B124C2DC19A7C0561B43405A3")
        @Override
        public int read(byte buffer[], int offset, int count) throws IOException {
            addTaint(count);
            addTaint(offset);
            addTaint(buffer[0]);
    if(offset < 0 || count < 0 || offset + count > buffer.length)            
            {
                IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1541439195 = new IndexOutOfBoundsException();
                varE4A00D3DB3B35ED0F12562B8AA17377A_1541439195.addTaint(taint);
                throw varE4A00D3DB3B35ED0F12562B8AA17377A_1541439195;
            } //End block
            count = Math.min(count, available());
    if(count < 1)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_12082167 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636693281 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_636693281;
            } //End block
            int result = readBytes(buffer, mOffset, offset, count);
    if(result > 0)            
            {
                mOffset += result;
            } //End block
            int varB4A88417B3D0170D754C647C30B7216A_527335885 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716048647 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1716048647;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.658 -0400", hash_original_method = "9D84182613F8631FDE5947AEAB012BC6", hash_generated_method = "3F75ABC27CA110AF69A6CDAB42D55F41")
        @Override
        public long skip(long n) throws IOException {
    if(mOffset + n > mLength)            
            {
                n = mLength - mOffset;
            } //End block
            mOffset += n;
            long var7B8B965AD4BCA0E41AB51DE7B31363A1_941333939 = (n);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1756395080 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1756395080;
            // ---------- Original Method ----------
            //if (mOffset + n > mLength) {
                //n = mLength - mOffset;
            //}
            //mOffset += n;
            //return n;
        }

        
    }


    
    private class MemoryOutputStream extends OutputStream {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.658 -0400", hash_original_field = "7870015E19539D5B7C0F8E6D8A862618", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.658 -0400", hash_original_field = "9893382187B6BE4A813F3C19CC69B8AF", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.658 -0400", hash_original_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB", hash_generated_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB")
        public MemoryOutputStream ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.658 -0400", hash_original_method = "E169D47904A982CBC090A3E5EE81FFA1", hash_generated_method = "2A540594D593B88A808996AB68D6A1B1")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.659 -0400", hash_original_method = "873021528A0C471EBDB778DCC5A89FEF", hash_generated_method = "05FDBE8172A59656C82C4D75C0EBFF5F")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.659 -0400", hash_original_field = "3081A19470620560723AFCCFD231D233", hash_generated_field = "5D3F94A828767D0FA960A9A7B583EDC1")

    private static String TAG = "MemoryFile";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.659 -0400", hash_original_field = "8485B64C5FEEDD71B9F0C2B303033EAA", hash_generated_field = "266C128FB04586E6755B38B52173946D")

    private static final int PROT_READ = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:32.659 -0400", hash_original_field = "4AC8997208999500EC0C56E354EE8162", hash_generated_field = "BDAF7D4E803BF7BEA3AAAA94A46AE56A")

    private static final int PROT_WRITE = 0x2;
}

