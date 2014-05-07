package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import droidsafe.helpers.DSUtils;

public class MemoryFile {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static FileDescriptor native_open(String name, int length) throws IOException {
		return new FileDescriptor();
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_mmap(FileDescriptor fd, int length, int mode) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_437101719;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_munmap(int addr, int length) throws IOException {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_close(FileDescriptor fd) {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_read(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563409879;
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_write(FileDescriptor fd, int address, byte[] buffer, int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void native_pin(FileDescriptor fd, boolean pin) throws IOException {
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int native_get_size(FileDescriptor fd) throws IOException {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962429955;
	}

    /**
     * Returns the size of the memory file that the file descriptor refers to,
     * or -1 if the file descriptor does not refer to a memory file.
     *
     * @throws IOException If <code>fd</code> is not a valid file descriptor.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.854 -0500", hash_original_method = "BCE66A712337B4BBAF82A3F870F7581D", hash_generated_method = "E41D856AAE4A158A39C51FE95963F1DC")
    
public static int getSize(FileDescriptor fd) throws IOException {
        return native_get_size(fd);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.771 -0500", hash_original_field = "49E38DACA03AD99386B61EABF1D70F50", hash_generated_field = "5D3F94A828767D0FA960A9A7B583EDC1")

    private static String TAG = "MemoryFile";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.774 -0500", hash_original_field = "EA854B3AC12969FF79319F9853694158", hash_generated_field = "266C128FB04586E6755B38B52173946D")

    private static final int PROT_READ = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.776 -0500", hash_original_field = "46785EB076A6FE4B95947359B755262A", hash_generated_field = "BDAF7D4E803BF7BEA3AAAA94A46AE56A")

    private static final int PROT_WRITE = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.814 -0500", hash_original_field = "1A1D246ADE6C04B67CBF287075FF1425", hash_generated_field = "472902F3844A9738091A7090C080AB6E")

    private FileDescriptor mFD;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.816 -0500", hash_original_field = "C6748DE6B660DCB404EDCE764B192848", hash_generated_field = "1BE2BFB4A5E404FE17164B090FF85336")

    private int mAddress;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.818 -0500", hash_original_field = "FC3D477E7B6A4ACE9A379E6E41129BD1", hash_generated_field = "E9E17726F18BEC3E5C2C142D209555FD")

    private int mLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.820 -0500", hash_original_field = "70BC190352D0E5A9F0651415A72292DE", hash_generated_field = "7D003ADAD6B352F39344F33BE33DE0E3")

    private boolean mAllowPurging = false;  // true if our ashmem region is unpinned

    /**
     * Allocates a new ashmem region. The region is initially not purgable.
     *
     * @param name optional name for the file (can be null).
     * @param length of the memory file in bytes.
     * @throws IOException if the memory file could not be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.822 -0500", hash_original_method = "DB289001A1CA8608ADAAFD372FAC3009", hash_generated_method = "B754BBAC3C3822C3744386A49392CFFB")
    
public MemoryFile(String name, int length) throws IOException {
        mLength = length;
        mFD = native_open(name, length);
        if (length > 0) {
            mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
        } else {
            mAddress = 0;
        }
    }

    /**
     * Closes the memory file. If there are no other open references to the memory
     * file, it will be deleted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.824 -0500", hash_original_method = "DD734A9458D0580E341A373C2DD4F619", hash_generated_method = "E3BC02224FD0199D03EA01A994058EA0")
    
public void close() {
        deactivate();
        if (!isClosed()) {
            native_close(mFD);
        }
    }

    /**
     * Unmaps the memory file from the process's memory space, but does not close it.
     * After this method has been called, read and write operations through this object
     * will fail, but {@link #getFileDescriptor()} will still return a valid file descriptor.
     *
     * @hide
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.827 -0500", hash_original_method = "08DA91581CCCF703195AD89F50B4F4A1", hash_generated_method = "08DA91581CCCF703195AD89F50B4F4A1")
    
void deactivate() {
        if (!isDeactivated()) {
            try {
                native_munmap(mAddress, mLength);
                mAddress = 0;
            } catch (IOException ex) {
                Log.e(TAG, ex.toString());
            }
        }
    }

    /**
     * Checks whether the memory file has been deactivated.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.829 -0500", hash_original_method = "6DDBFC199C19310599F0713304591847", hash_generated_method = "BC1516CAD839647BACB3E3229CF46E53")
    
private boolean isDeactivated() {
        return mAddress == 0;
    }

    /**
     * Checks whether the memory file has been closed.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.831 -0500", hash_original_method = "3246A0B1468E43E22E475A6EAB25C98D", hash_generated_method = "F89B5B48E6D65164DE427C517F844F7A")
    
private boolean isClosed() {
        return !mFD.valid();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.833 -0500", hash_original_method = "41074FB4CF57E698C714BECD1DB74DD1", hash_generated_method = "295A541A2CF4983E207FCD5D84EC7B3F")
    
@Override
    protected void finalize() {
        if (!isClosed()) {
            Log.e(TAG, "MemoryFile.finalize() called while ashmem still open");
            close();
        }
    }

    /**
     * Returns the length of the memory file.
     *
     * @return file length.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.836 -0500", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "8EA7C3FDBAE62B32653DE70AB5661C3A")
    
public int length() {
        return mLength;
    }

    /**
     * Is memory file purging enabled?
     *
     * @return true if the file may be purged.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.838 -0500", hash_original_method = "36BC15D120E9C0B3759A6273F0B6F394", hash_generated_method = "B4600CA43B78CB8016181B0092F2A3D9")
    
public boolean isPurgingAllowed() {
        return mAllowPurging;
    }

    /**
     * Enables or disables purging of the memory file.
     *
     * @param allowPurging true if the operating system can purge the contents
     * of the file in low memory situations
     * @return previous value of allowPurging
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.841 -0500", hash_original_method = "4E65A3A585AE016FD322D2CFB53AD9E7", hash_generated_method = "4570EDCB0C4DE7D1D2C196AA5B8DC406")
    
synchronized public boolean allowPurging(boolean allowPurging) throws IOException {
        boolean oldValue = mAllowPurging;
        if (oldValue != allowPurging) {
            native_pin(mFD, !allowPurging);
            mAllowPurging = allowPurging;
        }
        return oldValue;
    }

    /**
     * Creates a new InputStream for reading from the memory file.
     *
     @return InputStream
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.843 -0500", hash_original_method = "1F9A300CE55BE9E69C06FFD4C6B98E29", hash_generated_method = "7C05402E53936EEE4CFFB07B0AF6F015")
    
public InputStream getInputStream() {
        return new MemoryInputStream();
    }

    /**
     * Creates a new OutputStream for writing to the memory file.
     *
     @return OutputStream
     */
     @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.845 -0500", hash_original_method = "0A8C4757301CE72EF10D99AE7CF53794", hash_generated_method = "76B516386E2DCA79240512F75CF04B3F")
    
public OutputStream getOutputStream() {
        return new MemoryOutputStream();
    }
    
    private class MemoryInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.858 -0500", hash_original_field = "2E1768DDCD2720CE082D48DB6B9D009D", hash_generated_field = "1CE465393F7752DBE05602CD816C716E")

        private int mMark = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.860 -0500", hash_original_field = "9903C734D96A80C6871FB08938C010EE", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.862 -0500", hash_original_field = "D4905C1A6EF2255354869371A444BCF1", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.535 -0400", hash_original_method = "8819C64327DEAF910328E1B34E1904BC", hash_generated_method = "8819C64327DEAF910328E1B34E1904BC")
        public MemoryInputStream ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.865 -0500", hash_original_method = "C946C15ECBD8592757BE5150DF65639B", hash_generated_method = "13740AE0D609A949F73C178A6381BD83")
        
@Override
        public int available() throws IOException {
            if (mOffset >= mLength) {
                return 0;
            }
            return mLength - mOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.867 -0500", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
        
@Override
        public boolean markSupported() {
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.870 -0500", hash_original_method = "D9C9FB514524CC537FCE6FACAF9A295C", hash_generated_method = "87458722CEEC10F3A4173D417E3EF803")
        
@Override
        public void mark(int readlimit) {
            mMark = mOffset;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.872 -0500", hash_original_method = "35916CEFACB2EEB27C627D30B06B91CE", hash_generated_method = "904D6292AB138E31268DC055F573A295")
        
@Override
        public void reset() throws IOException {
            mOffset = mMark;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.875 -0500", hash_original_method = "A1D8D948EA118F9A15401118B0635D27", hash_generated_method = "7190EA32ECAA3028792F674EC9A78DCA")
        
@Override
        public int read() throws IOException {
            if (mSingleByte == null) {
                mSingleByte = new byte[1];
            }
            int result = read(mSingleByte, 0, 1);
            if (result != 1) {
                return -1;
            }
            return mSingleByte[0];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.877 -0500", hash_original_method = "BFF461741A45AAAD780835BEF712AE09", hash_generated_method = "B070035E9A8D612EF11A6B55D6BF723E")
        
@Override
        public int read(byte buffer[], int offset, int count) throws IOException {
            if (offset < 0 || count < 0 || offset + count > buffer.length) {
                // readBytes() also does this check, but we need to do it before
                // changing count.
                throw new IndexOutOfBoundsException();
            }
            count = Math.min(count, available());
            if (count < 1) {
                return -1;
            }
            int result = readBytes(buffer, mOffset, offset, count);
            if (result > 0) {
                mOffset += result;
            }
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.880 -0500", hash_original_method = "9D84182613F8631FDE5947AEAB012BC6", hash_generated_method = "C47CBA79EBD772F8F3535BE469A40B73")
        
@Override
        public long skip(long n) throws IOException {
            if (mOffset + n > mLength) {
                n = mLength - mOffset;
            }
            mOffset += n;
            return n;
        }
        
    }
    
    private class MemoryOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.885 -0500", hash_original_field = "9903C734D96A80C6871FB08938C010EE", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

        private int mOffset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.888 -0500", hash_original_field = "D4905C1A6EF2255354869371A444BCF1", hash_generated_field = "E7241BA1F5B2EEFC9242D732AA7BD5A0")

        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.538 -0400", hash_original_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB", hash_generated_method = "E9EA5EC07A45A76AA096F4AAFF6BF1DB")
        public MemoryOutputStream ()
        {
            //Synthesized constructor
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.890 -0500", hash_original_method = "E169D47904A982CBC090A3E5EE81FFA1", hash_generated_method = "DED4AF55CF5E1B977A8F79686FB9F7EE")
        
@Override
        public void write(byte buffer[], int offset, int count) throws IOException {
            writeBytes(buffer, offset, mOffset, count);
            mOffset += count;
        }

        @DSSink(DSSinkKind.IO)
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.892 -0500", hash_original_method = "873021528A0C471EBDB778DCC5A89FEF", hash_generated_method = "75081660C8BCEE2C6DE095A6F5387D78")
        
@Override
        public void write(int oneByte) throws IOException {
            if (mSingleByte == null) {
                mSingleByte = new byte[1];
            }
            mSingleByte[0] = (byte)oneByte;
            write(mSingleByte, 0, 1);
        }
        
    }

    /**
     * Reads bytes from the memory file.
     * Will throw an IOException if the file has been purged.
     *
     * @param buffer byte array to read bytes into.
     * @param srcOffset offset into the memory file to read from.
     * @param destOffset offset into the byte array buffer to read into.
     * @param count number of bytes to read.
     * @return number of bytes read.
     * @throws IOException if the memory file has been purged or deactivated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.847 -0500", hash_original_method = "E94CD8A455128D534B69DAAECC501B12", hash_generated_method = "D50A3974E0B932CCD6F84C89098DAAC2")
    
public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count)
            throws IOException {
        if (isDeactivated()) {
            throw new IOException("Can't read from deactivated memory file.");
        }
        if (destOffset < 0 || destOffset > buffer.length || count < 0
                || count > buffer.length - destOffset
                || srcOffset < 0 || srcOffset > mLength
                || count > mLength - srcOffset) {
            throw new IndexOutOfBoundsException();
        }
        return native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
    }

    /**
     * Write bytes to the memory file.
     * Will throw an IOException if the file has been purged.
     *
     * @param buffer byte array to write bytes from.
     * @param srcOffset offset into the byte array buffer to write from.
     * @param destOffset offset  into the memory file to write to.
     * @param count number of bytes to write.
     * @throws IOException if the memory file has been purged or deactivated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.849 -0500", hash_original_method = "6737AABC2F88EDB7F71CE587CF7F9739", hash_generated_method = "A0E45354F40988C3676D71B503879BA5")
    
public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count)
            throws IOException {
        if (isDeactivated()) {
            throw new IOException("Can't write to deactivated memory file.");
        }
        if (srcOffset < 0 || srcOffset > buffer.length || count < 0
                || count > buffer.length - srcOffset
                || destOffset < 0 || destOffset > mLength
                || count > mLength - destOffset) {
            throw new IndexOutOfBoundsException();
        }
        native_write(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging);
    }

    /**
     * Gets a FileDescriptor for the memory file.
     *
     * The returned file descriptor is not duplicated.
     *
     * @throws IOException If the memory file has been closed.
     *
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:41.851 -0500", hash_original_method = "2D6523548F3A6408618EC64E9280F841", hash_generated_method = "02AF995FD91DFE52837F24EDA124C08D")
    
public FileDescriptor getFileDescriptor() throws IOException {
        return mFD;
    }
}

