package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MemoryFile {
    private FileDescriptor mFD;
    private int mAddress;
    private int mLength;
    private boolean mAllowPurging = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.763 -0400", hash_original_method = "DB289001A1CA8608ADAAFD372FAC3009", hash_generated_method = "D15D3F9605C4C95451F18E8028C3473C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MemoryFile(String name, int length) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(length);
        mFD = native_open(name, length);
        {
            mAddress = native_mmap(mFD, length, PROT_READ | PROT_WRITE);
        } //End block
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

    
        private static FileDescriptor native_open(String name, int length) throws IOException {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int native_mmap(FileDescriptor fd, int length, int mode) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_munmap(int addr, int length) throws IOException {
    }

    
        private static void native_close(FileDescriptor fd) {
    }

    
        private static int native_read(FileDescriptor fd, int address, byte[] buffer,
            int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void native_write(FileDescriptor fd, int address, byte[] buffer,
            int srcOffset, int destOffset, int count, boolean isUnpinned) throws IOException {
    }

    
        private static void native_pin(FileDescriptor fd, boolean pin) throws IOException {
    }

    
        private static int native_get_size(FileDescriptor fd) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.765 -0400", hash_original_method = "DD734A9458D0580E341A373C2DD4F619", hash_generated_method = "7F225E857642156F0A275D26F494DF30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        deactivate();
        {
            boolean var87E69C193F176802B13B2F1C81F5377B_231408889 = (!isClosed());
            {
                native_close(mFD);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //deactivate();
        //if (!isClosed()) {
            //native_close(mFD);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.766 -0400", hash_original_method = "08DA91581CCCF703195AD89F50B4F4A1", hash_generated_method = "0B48AF74F890559535AAFE689E17451D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void deactivate() {
        {
            boolean var941F9BDB19A5D518067C6257AB508A03_1780506340 = (!isDeactivated());
            {
                try 
                {
                    native_munmap(mAddress, mLength);
                    mAddress = 0;
                } //End block
                catch (IOException ex)
                { }
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.766 -0400", hash_original_method = "6DDBFC199C19310599F0713304591847", hash_generated_method = "BDCED6C1E6A10DBA0E0351C2BAFDA423")
    @DSModeled(DSC.SAFE)
    private boolean isDeactivated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAddress == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.766 -0400", hash_original_method = "3246A0B1468E43E22E475A6EAB25C98D", hash_generated_method = "535E5637C35A1C992ABBC447C008B98E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isClosed() {
        boolean varFA3F4C45AF333D629D1394D6A839E3C9_1330807967 = (!mFD.valid());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !mFD.valid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.766 -0400", hash_original_method = "41074FB4CF57E698C714BECD1DB74DD1", hash_generated_method = "29F875BA7B54ADEB49C0C8A9CFB03EA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() {
        {
            boolean var87E69C193F176802B13B2F1C81F5377B_935236292 = (!isClosed());
            {
                close();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!isClosed()) {
            //Log.e(TAG, "MemoryFile.finalize() called while ashmem still open");
            //close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.767 -0400", hash_original_method = "C0D624CC7CEFFAF650D54F4FB963FAF6", hash_generated_method = "223B168FF17CEB39254F4FA4815BC666")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.767 -0400", hash_original_method = "36BC15D120E9C0B3759A6273F0B6F394", hash_generated_method = "641367F4FA29694FCEC19AD2BB5F2127")
    @DSModeled(DSC.SAFE)
    public boolean isPurgingAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowPurging;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.767 -0400", hash_original_method = "4E65A3A585AE016FD322D2CFB53AD9E7", hash_generated_method = "F39847E1BB64BA41C84DF903F335CAF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized public boolean allowPurging(boolean allowPurging) throws IOException {
        dsTaint.addTaint(allowPurging);
        boolean oldValue;
        oldValue = mAllowPurging;
        {
            native_pin(mFD, !allowPurging);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean oldValue = mAllowPurging;
        //if (oldValue != allowPurging) {
            //native_pin(mFD, !allowPurging);
            //mAllowPurging = allowPurging;
        //}
        //return oldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.767 -0400", hash_original_method = "1F9A300CE55BE9E69C06FFD4C6B98E29", hash_generated_method = "2A0A94D960F8765F0F56B2AF9C2BC510")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStream getInputStream() {
        InputStream varFDFB30FCFE87E4D8E3361C39D9483E8A_288220310 = (new MemoryInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MemoryInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.768 -0400", hash_original_method = "0A8C4757301CE72EF10D99AE7CF53794", hash_generated_method = "DFCB6F85C6AA08EA30E8FB88538712B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStream getOutputStream() {
        OutputStream var521F9EC9EEBBAF1C61C17490D10B03B0_1371225119 = (new MemoryOutputStream());
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new MemoryOutputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.768 -0400", hash_original_method = "E94CD8A455128D534B69DAAECC501B12", hash_generated_method = "A48B8AC6B1A1A657D7F0537583C5C276")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(destOffset);
        {
            boolean var69AE6633AAE7BF7BCBFA61A26FCE0675_1234609378 = (isDeactivated());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Can't read from deactivated memory file.");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int varBC098400FC4EDE9D23C50CE46391CB5B_1190519780 = (native_read(mFD, mAddress, buffer, srcOffset, destOffset, count, mAllowPurging));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.769 -0400", hash_original_method = "6737AABC2F88EDB7F71CE587CF7F9739", hash_generated_method = "4DDD9417A14EBD3E32D498EF25B6D415")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeBytes(byte[] buffer, int srcOffset, int destOffset, int count) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(count);
        dsTaint.addTaint(srcOffset);
        dsTaint.addTaint(destOffset);
        {
            boolean var69AE6633AAE7BF7BCBFA61A26FCE0675_639801966 = (isDeactivated());
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Can't write to deactivated memory file.");
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.769 -0400", hash_original_method = "2D6523548F3A6408618EC64E9280F841", hash_generated_method = "964FECED1C788FBD1572E8CB04014C8D")
    @DSModeled(DSC.SAFE)
    public FileDescriptor getFileDescriptor() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFD;
    }

    
        public static int getSize(FileDescriptor fd) throws IOException {
        return native_get_size(fd);
    }

    
    private class MemoryInputStream extends InputStream {
        private int mMark = 0;
        private int mOffset = 0;
        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.769 -0400", hash_original_method = "61EDA83D1A8F14ABC5822F7FA0E70BD1", hash_generated_method = "61EDA83D1A8F14ABC5822F7FA0E70BD1")
                public MemoryInputStream ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.769 -0400", hash_original_method = "C946C15ECBD8592757BE5150DF65639B", hash_generated_method = "3D5B20BBD2061436F153E8F52CA9C2EA")
        @DSModeled(DSC.SAFE)
        @Override
        public int available() throws IOException {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (mOffset >= mLength) {
                //return 0;
            //}
            //return mLength - mOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.770 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "4C8BC0E845541479E10014C1D7864553")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean markSupported() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.770 -0400", hash_original_method = "D9C9FB514524CC537FCE6FACAF9A295C", hash_generated_method = "0C99FDFA51C938995FBB7416AC56527C")
        @DSModeled(DSC.SAFE)
        @Override
        public void mark(int readlimit) {
            dsTaint.addTaint(readlimit);
            mMark = mOffset;
            // ---------- Original Method ----------
            //mMark = mOffset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.770 -0400", hash_original_method = "35916CEFACB2EEB27C627D30B06B91CE", hash_generated_method = "51C43F06C3033D3370FC41BB3D926B97")
        @DSModeled(DSC.SAFE)
        @Override
        public void reset() throws IOException {
            mOffset = mMark;
            // ---------- Original Method ----------
            //mOffset = mMark;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.771 -0400", hash_original_method = "A1D8D948EA118F9A15401118B0635D27", hash_generated_method = "395534844EDD563219BBF53583F082C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            {
                mSingleByte = new byte[1];
            } //End block
            int result;
            result = read(mSingleByte, 0, 1);
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.771 -0400", hash_original_method = "BFF461741A45AAAD780835BEF712AE09", hash_generated_method = "0C0BB6878E49C17904C788C3C7391ECE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte buffer[], int offset, int count) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(count);
            dsTaint.addTaint(offset);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            count = Math.min(count, available());
            int result;
            result = readBytes(buffer, mOffset, offset, count);
            {
                mOffset += result;
            } //End block
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.771 -0400", hash_original_method = "9D84182613F8631FDE5947AEAB012BC6", hash_generated_method = "DE2FF6EEBE1C2AFF6FD3D989043D371B")
        @DSModeled(DSC.SAFE)
        @Override
        public long skip(long n) throws IOException {
            dsTaint.addTaint(n);
            {
                n = mLength - mOffset;
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (mOffset + n > mLength) {
                //n = mLength - mOffset;
            //}
            //mOffset += n;
            //return n;
        }

        
    }


    
    private class MemoryOutputStream extends OutputStream {
        private int mOffset = 0;
        private byte[] mSingleByte;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.771 -0400", hash_original_method = "3EF1B2B242869D2691597F3539D0526E", hash_generated_method = "3EF1B2B242869D2691597F3539D0526E")
                public MemoryOutputStream ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.772 -0400", hash_original_method = "E169D47904A982CBC090A3E5EE81FFA1", hash_generated_method = "DE18C5C535B60C65320DCA90533E97E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte buffer[], int offset, int count) throws IOException {
            dsTaint.addTaint(buffer);
            dsTaint.addTaint(count);
            dsTaint.addTaint(offset);
            writeBytes(buffer, offset, mOffset, count);
            // ---------- Original Method ----------
            //writeBytes(buffer, offset, mOffset, count);
            //mOffset += count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.772 -0400", hash_original_method = "873021528A0C471EBDB778DCC5A89FEF", hash_generated_method = "E8563692F0E118B7414CD51351E67C81")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
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


    
    private static String TAG = "MemoryFile";
    private static final int PROT_READ = 0x1;
    private static final int PROT_WRITE = 0x2;
}

